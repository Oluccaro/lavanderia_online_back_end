# lavanderia_online_back_end

# Backend
- Abre o repositório no vscode
- Adicionar extensão "Spring Boot Extension Pack" da VMware.
- CTRL + SHIFT + P > procura por 'spring' e seleciona primeira opção com 'run'
- terá duas opções, uma pra usuario e outra para pedido
- rode ambas ou apenas a que quer usar

# Banco
- instala mysql server > $ sudo apt install mysql-server
- inicia o servidor > $ sudo systemctl start mysql
- sudo mysql -u root
- usa comandos de sql_lavanderia.sql para criar database, tabelas, inserir dados e garantir acessos

# Postman
- acessar postman e testar consultas
- GET http://localhost:9090/pedido
- GET http://localhost:8080/usuario
- verificar outros endereços dentro das implementações do back
- verificar erros no terminal do vscode rodando o spring boot caso necessário
