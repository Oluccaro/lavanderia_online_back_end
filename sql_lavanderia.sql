create user 'lavanderia_user'@'localhost' identified by 'admin';
create database lavanderia;
use lavanderia;
show tables;

CREATE TABLE endereco (
    id INT PRIMARY KEY auto_increment,
    cep VARCHAR(10),
    logradouro VARCHAR(255),
    complemento VARCHAR(255),
    bairro VARCHAR(255),
    localidade VARCHAR(255),
    uf VARCHAR(2),
    ibge INT,
    gia INT,
    ddd INT,
    siaf INT,
    numero VARCHAR(10)
);

CREATE TABLE usuario (
	id INT PRIMARY KEY auto_increment,
    nome VARCHAR(255),
    login VARCHAR(255),
	senha VARCHAR(255),
    salt VARCHAR(512),
    cpf VARCHAR(14),
    perfil VARCHAR(255),
    telefone VARCHAR(20),
    end_id integer,
    dt_nascimento date,
    foreign key (end_id) references endereco(id)
);
CREATE TABLE roupa (
    id INT PRIMARY KEY auto_increment,
    preco DECIMAL(10, 2),
    prazo int,
    descricao VARCHAR(255),
    imagem longtext,
    imagem_descr varchar(255)
);
-- Table for orders
CREATE TABLE pedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    status VARCHAR(50),
    valor DECIMAL(10, 2),
    dt_pedido DATE,
    dt_entrega_prevista DATE,
    id_cliente int,
    foreign key (id_cliente) references usuario(id)
);

-- Junction table for the many-to-many relationship
CREATE TABLE pedido_roupa (
	id int primary key auto_increment,
    id_pedido INT,
    id_roupa INT,
    quantidade INT,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    FOREIGN KEY (id_roupa) REFERENCES roupa(id)
);

drop table usuario;
drop table endereco;
drop table roupa;
drop table pedido;
drop table pedido_roupa;
show tables;
INSERT INTO endereco (cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siaf, numero)
VALUES
('80540-400', 'Avenida Anita Garibaldi', 'de 222 a 1344 - lado par', 'Cabral', 'Curitiba', 'PR', 4106902, null, 41, 7535, '900'),
('70000-000', 'Rua das Flores', 'Apto 301', 'Centro', 'Brasília', 'DF', 5300108, null, 61, 9701, '123'),
('04101-300', 'Avenida Paulista', 'Sala 502', 'Bela Vista', 'São Paulo', 'SP', 3550308, null, 11, 7107, '789'),
('50000-000', 'Rua do Recife', 'Casa 42', 'Boa Viagem', 'Recife', 'PE', 2611606, null, 81, 2498, '567'),
('20000-000', 'Avenida Rio Branco', 'Loja 15', 'Centro', 'Rio de Janeiro', 'RJ', 3304557, null, 21, 6001, '321'),
('83010-160', 'Rua Irati', 'de 222 a 1344 - lado par', 'Cruzeiro', 'São José dos Pinhais', 'PR', 4125506, null, 41, 7885, '56'),
('85015-100', 'Travessa Social', '65', 'Santa Cruz', 'Guarapuava', 'PR', 4109401, null, 42, 7583, '65'),
('83010-160', 'Rua Irati', 'casa', 'Cruzeiro', 'São José dos Pinhais', 'PR', 4125506, null, 41, 7885, '12');

INSERT INTO usuario (nome, login, senha, cpf, perfil, telefone, end_id, dt_nascimento)
VALUES
('João Clienteson', 'joao-cliente@email.com', '1234', '111.111.111-11', 'CLIENTE', '4199999-9999', 1, null),
('Maria Funcionaria', 'maria-funcionaria@email.com', '1234', '222.222.222-22', 'FUNC', '4199999-9999', null, '2020-12-15'),
('José Cliente', 'jose-cliente@email.com', '1234', '333.333.333-33', 'CLIENTE', '4199999-9999', 3, null),
('Joana Cliente', 'joana-cliente@email.com', '1234', '444.444.444-44', 'CLIENTE', '4199999-9999', 4, null),
('Joaquina Cliente', 'joaquina-cliente@email.com', '1234', '555.555.555-55', 'CLIENTE', '4199999-9999', 5, null),
('Mario Funcionário', 'mario-funcionario@email.com', '1234', '666.666.666-66', 'FUNC', NULL, NULL, '1989-04-15'),
('Juca do Teste', 'jucateste96@email.com', '8638', '98765432199', 'CLIENTE', '41999999999', 6, null),
('juquietas', 'jq@email.com', '7035', '98765432199', 'CLIENTE', '419987987987', 7, null),
('Juca do Teste', 'asd@aw', '383', '98765432199', 'CLIENTE', '41999999999', 8, null),
('Juca do Teste', 'lucasfnunes96@gmail.com', '7415', '98765432199', 'CLIENTE', '41999999999', null, null),
('lucas.cazionato@ufpr.br', 'lucas.cazionato@ufpr.br', '6408', NULL, 'CLIENTE', NULL, 2, null),
('lucascazidddd@ufpr.br', 'lucascazidddd@ufpr.br', '1933', NULL, 'CLIENTE', NULL, 5, null);

INSERT INTO roupa (preco, prazo, descricao, imagem_descr, imagem)
VALUES
(17.5, 5, 'Calça', 'calca.png', ""),
(15, 5, 'Camisa', 'camisa.png', ""),
(12.5, 3, 'Camiseta', 'camiseta.png', ""),
(10, 2, 'Meia', 'meia.png', ""),
(10, 2, 'Cueca', 'cueca.png', "");

INSERT INTO pedido (status, valor, dt_pedido, dt_entrega_prevista, id_cliente)
VALUES 
('FINALIZADO', 200, '2023-11-25', '2023-11-30', 1),
('EM ABERTO', 150.20, '2023-11-10', '2023-12-05', 3);

INSERT INTO pedido_roupa (id_pedido, id_roupa, quantidade)
VALUES
(1, 2, 2),
(1, 3, 1),
(2, 1, 2),
(2, 2, 1);

select 
  *
from usuario u
left join endereco e on u.end_id = e.id;

select * from pedido_roupa;
select * from usuario;
select * from endereco;
select * from roupa;

grant all privileges on endereco to lavanderia_user;

GRANT ALL PRIVILEGES ON lavanderia TO 'lavanderia_user'@'localhost';

flush privileges;

-- Grant privileges on the Usuario table
GRANT SELECT, INSERT, UPDATE, DELETE ON lavanderia.usuario TO 'lavanderia_user'@'localhost';

-- Grant privileges on the Endereco table
GRANT SELECT, INSERT, UPDATE, DELETE ON lavanderia.endereco TO 'lavanderia_user'@'localhost';
