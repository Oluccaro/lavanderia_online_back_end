package br.net.lavanderia.usuario.rest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.net.lavanderia.usuario.DTO.UsuarioDTO;
import br.net.lavanderia.usuario.model.Login;
import br.net.lavanderia.usuario.model.Usuario;
import br.net.lavanderia.usuario.repository.UsuarioRepository;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@CrossOrigin
@RestController
public class AuthREST {

  @Autowired
  private UsuarioRepository repo;
  
  @Autowired
  private ModelMapper mapper;


  public static List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();

  @PostMapping("/login")
  public UsuarioDTO login(@RequestBody Login login){

    UsuarioDTO usuario = repo.findAll().stream()
    .filter(usu -> 
      usu.getLogin().equals(login.getLogin()) &&
      usu.getSenha().equals(hashPassword(login.getSenha(), Base64.getDecoder().decode(usu.getSalt())))  
    )
    .map(e -> mapper.map(e, UsuarioDTO.class))
    .findAny()
    .orElse(null);

    return usuario;
  }

  @PostMapping("/cadastro")
  public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuario){

    Usuario user = mapper.map(usuario, Usuario.class);

    // Gerar senha aleatoria para o UsuarioDTO
    String pass = Integer.toString(Usuario.gerarSenha());

    byte[] salt = generateSalt();    

    // Criptografar a senha com SHA-256 e SALT
    String hashedPassword = hashPassword(pass, salt);

    // Configurar a senha hashada e o novo salt
    user.setSenha(hashedPassword);
    user.setSalt(Base64.getEncoder().encodeToString(salt));

    repo.save(user);

    // Enviar senha por e-mail
    sendPasswordByEmail("lavanderiaonline.naoresponda@gmail.com", pass);

    Usuario usu = repo.findAll().stream()
                  .filter(u -> u.getLogin().equals(usuario.getLogin()))
                  .findAny()
                  .orElse(null);
    return mapper.map(usu, UsuarioDTO.class);
  }

  private byte[] generateSalt() {
    byte[] salt = new byte[16];
    SecureRandom random = new SecureRandom();
    random.nextBytes(salt);
    return salt;
  }

private String hashPassword(String password, byte[] salt) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Adicionar o SALT à senha antes de criar o hash
        md.update(salt);

        // Criar o hash da senha
        byte[] hashedPassword = md.digest(password.getBytes());

        // Converter o hash para uma representação em string (Base64)
        return Base64.getEncoder().encodeToString(hashedPassword);
    } catch (NoSuchAlgorithmException e) {
        // Lidar com a exceção, se ocorrer
        e.printStackTrace();
        return null;
    }
  }

  private void sendPasswordByEmail(String email, String senha) {
    String to = email;
    String from = "lavanderiaonline.naoresponda@gmail.com"; // E-mail de origem
    final String username = "lavanderiaonline.naoresponda@gmail.com";
    final String password = "vxbbicosasjjohxo";

    String host = "smtp.gmail.com";

    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", host);
    properties.setProperty("mail.smtp.port", "587");
    properties.setProperty("mail.smtp.auth", "true");
    properties.setProperty("mail.smtp.starttls.enable", "true");

    Session session = Session.getDefaultInstance(properties, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });

    try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Senha de Cadastro - Sistema Lavanderia On-Line");
        message.setText("Sua senha de cadastro ao Sistema de Lavanderia On-line é: " + senha);

        Transport.send(message);
        System.out.println("E-mail enviado com sucesso.");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }
  }
}