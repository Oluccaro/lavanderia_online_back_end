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

CREATE TABLE pedido (
    id INT PRIMARY KEY AUTO_INCREMENT,
    status VARCHAR(50),
    valor DECIMAL(10, 2),
    dt_pedido DATE,
    dt_entrega_prevista DATE,
    id_cliente int,
    foreign key (id_cliente) references usuario(id)
);

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
('80230-001', 'Rua Paranaguá', 'Apto 101', 'Centro', 'Curitiba', 'PR', 4106902, 1234, 41, 7535, '456'),
('71020-001', 'Avenida W3 Sul', 'Bloco C', 'Asa Sul', 'Brasília', 'DF', 5300108, 5678, 61, 9701, '789'),
('04503-001', 'Rua Oscar Freire', 'Conjunto 205', 'Cerqueira César', 'São Paulo', 'SP', 3550308, 9101, 11, 7107, '101'),
('51020-001', 'Avenida da Paz', 'Casa 55', 'Pantanal', 'Cuiabá', 'MT', 5103403, 2468, 65, 2498, '222'),
('22041-001', 'Rua Coelho Rodrigues', 'Loja 10', 'Centro', 'Teresina', 'PI', 2211001, 1357, 86, 5120, '789'),
('86020-001', 'Avenida Higienópolis', 'Sala 301', 'Zona 01', 'Londrina', 'PR', 4113700, 9753, 43, 6892, '456'),
('87020-001', 'Rua Maringá', 'Casa 30', 'Zona 03', 'Maringá', 'PR', 4115200, 3579, 44, 5210, '789'),
('33010-001', 'Avenida Amaral Peixoto', 'Apartamento 15', 'Centro', 'Niterói', 'RJ', 3303302, 8642, 21, 6001, '101'),
('79002-001', 'Rua Barão do Rio Branco', 'Sala 502', 'Centro', 'Campo Grande', 'MS', 5002704, 9753, 67, 3456, '222'),
('57020-001', 'Avenida Fernandes Lima', 'Loja 30', 'Farol', 'Maceió', 'AL', 2704302, 3579, 82, 6523, '789');

INSERT INTO usuario (nome, login, senha, salt, cpf, perfil, telefone, end_id, dt_nascimento)
VALUES
('Maria', 'maria.funcionaria@email.com', 'M9yRMYA60JRJve+cG2gmfvVE54SGbvrzUY6ABEZxAzU=', 'WApEQkqlOb+W3vWRgga8GA==', '111.111.111-11', 'FUNC', '(41) 99999-9991', 1, '1991-01-01'),
('Mário', 'mario.funcionario@email.com', 'z7cTpg+PInbD1TES/ks9ckMjwewKgLZQMxLsSAjETgw=', 'UEYad20oWEdq4an/xRuJdg==', '222.222.222-22', 'FUNC', '(41) 99999-9992', 2, '1992-02-02'),
('João', 'joao.cliente@email.com', '8BH/ZUsvqvu++F4PPieBOtkyx4wwNICt+UPqwPchvoA=', 'pm1tTC31OBGGMJ5XT4px1Q==', '333.333.333-33', 'CLIENTE', '(41) 99999-9993', 3, '1993-03-03'),
('José', 'jose.cliente@email.com', 'NzTai0KvXcl5tDI9Ty886lO5WO57tkTEcHv+YkyC8As=', 'kXbsJxDxPM3vCWZNhCtQOQ==', '444.444.444-44', 'CLIENTE', '(41) 99999-9994', 4, '1994-04-04'),
('Joana', 'joana.cliente@email.com', 'aNX28C0aDG2ReNCXq0VaC3Ly7bXerjVGE4mgH/xqSSg=', 'NZo4j70rWe1NzVM8kthNKA==', '555.555.555-55', 'CLIENTE', '(41) 99999-9995', 5, '1995-05-05'),
('Joaquina', 'joaquina.cliente@email.com', 'DDYRcrY41SoQuildCAlse5nJ3rpVpEf1YmXJrI1g9RQ=', 'ImNemV4i7kBIDkQxc+Yf+g==', '666.666.666-66', 'CLIENTE', '(41) 99999-9996', 6, '1996-06-06'),
('Lucas', 'lucas.funcionario@email.com', 'YfwJRydIYfEuP+/k0LGkEO0wN7lApeSEhKtACVJLjCI=', 'pCQ1iV5ujUMs8CO2FjRzeQ==', '000.000.000-00', 'FUNC', '(41) 99999-9990', 10, '1990-10-10'),
('Gabriel', 'gabriel.cliente@email.com', '2MY7LzVf+bb3+OSmCqE/W+IVYJY5VOp5RowNoD6CfXs=', '2IBhnuPE+cT1/oGWFnxctg==', '777.777.777-77', 'CLIENTE', '(41) 99999-9997', 7, '1987-07-07'),
('Daniela', 'daniela.cliente@email.com', 'Qp61sb9d1m07ottz2mCK+uXD7JCIDmFrGQDPTZsuhQc=', 'igBf/Y3h5T4wXrhGxC4RKA==', '888.888.888-88', 'CLIENTE', '(41) 99999-9998', 8, '1988-08-08'),
('Fernando', 'fernando.cliente@email.com', 'uoork1QrnBUazjwsrTueo4w+RbKuyqIc1P3yqIXs4Rc=', 'KChszXE8J/ZE8AAd71hgWg==', '999.999.999-99', 'CLIENTE', '(41) 99999-9999', 9, '1989-09-09');

/* SENHAS:
1) maria.funcionaria@email.com: 1012;
2) mario.funcionario@email.com: 1271;
3) joao.cliente@email.com: 9767;
4) jose.cliente@email.com: 9751;
5) joana.cliente@email.com: 1378;
6) joaquina.cliente@email.com: 7626;
7) lucas.funcionario@email.com: 1740;
8) gabriel.cliente@email.com: 5905;
9) daniela.cliente@email.com: 3793;
10) fernando.cliente@email.com: 3997.
*/

INSERT INTO roupa (preco, prazo, descricao, imagem_descr, imagem)
VALUES
(17.5, 15, 'Calça', 'calca.png', ""),
(15, 15, 'Camisa', 'camisa.png', ""),
(12.5, 15, 'Camiseta', 'camiseta.png', ""),
(10, 15, 'Meia', 'meia.png', ""),
(10, 15, 'Cueca', 'cueca.png', "");

INSERT INTO pedido (status, valor, dt_pedido, dt_entrega_prevista, id_cliente)
VALUES 
('EM ABERTO', 35, '2023-01-01', '2023-01-16', 3),
('EM ABERTO', 30, '2023-01-02', '2023-01-17', 3),
('EM ABERTO', 25, '2023-01-03', '2023-01-18', 3),
('REJEITADO', 20, '2023-01-04', '2023-01-19', 3),
('CANCELADO', 20, '2023-01-05', '2023-01-20', 3),
('RECOLHIDO', 17.5, '2023-02-01', '2023-02-16', 3),
('RECOLHIDO', 15, '2023-02-02', '2023-02-17', 3),
('FINALIZADO', 12.5, '2023-02-03', '2023-02-18', 3),
('FINALIZADO', 10, '2023-02-04', '2023-02-19', 3),
('EM ABERTO', 35, '2023-02-01', '2023-02-16', 4),
('AGUARDANDO PAGAMENTO', 30, '2023-02-02', '2023-02-17', 4),
('AGUARDANDO PAGAMENTO', 25, '2023-02-03', '2023-02-18', 4),
('PAGO', 20, '2023-02-04', '2023-02-19', 4),
('FINALIZADO', 20, '2023-02-05', '2023-02-20', 4),
('FINALIZADO', 17.5, '2023-03-01', '2023-03-16', 4),
('RECOLHIDO', 35, '2023-03-01', '2023-03-16', 5),
('AGUARDANDO PAGAMENTO', 30, '2023-03-02', '2023-03-17', 5),
('AGUARDANDO PAGAMENTO', 25, '2023-03-03', '2023-03-18', 5),
('PAGO', 20, '2023-03-04', '2023-03-19', 5),
('PAGO', 20, '2023-03-05', '2023-03-20', 5),
('FINALIZADO', 17.5, '2023-04-01', '2023-04-16', 5),
('FINALIZADO', 15, '2023-04-02', '2023-04-17', 5),
('FINALIZADO', 12.5, '2023-04-03', '2023-04-18', 5),
('RECOLHIDO', 35, '2023-04-01', '2023-04-16', 6),
('RECOLHIDO', 30, '2023-04-02', '2023-04-17', 6),
('AGUARDANDO PAGAMENTO', 25, '2023-04-03', '2023-04-18', 6),
('PAGO', 20, '2023-04-04', '2023-04-19', 6),
('PAGO', 20, '2023-04-05', '2023-04-20', 6),
('FINALIZADO', 17.5, '2023-05-01', '2023-05-16', 6),
('FINALIZADO', 15, '2023-05-02', '2023-05-17', 6);


INSERT INTO pedido_roupa (id_pedido, id_roupa, quantidade)
VALUES
(1, 1, 2),
(2, 2, 2),
(3, 3, 2),
(4, 4, 2),
(5, 5, 2),
(6, 1, 1),
(7, 2, 1),
(8, 3, 1),
(9, 4, 1),
(10, 1, 2),
(11, 2, 2),
(12, 3, 2),
(13, 4, 2),
(14, 5, 2),
(15, 1, 1),
(16, 1, 2),
(17, 2, 2),
(18, 3, 2),
(19, 4, 2),
(20, 5, 2),
(21, 1, 1),
(22, 2, 1),
(23, 3, 1),
(24, 1, 2),
(25, 2, 2),
(26, 3, 2),
(27, 4, 2),
(28, 5, 2),
(29, 1, 1),
(30, 2, 1);

select 
  *
from usuario u
left join endereco e on u.end_id = e.id;

select * from pedido_roupa;
select * from usuario;
select * from endereco;
select * from roupa;

GRANT ALL PRIVILEGES ON lavanderia TO 'lavanderia_user'@'localhost';

-- Grant privileges on each table
GRANT SELECT, INSERT, UPDATE, DELETE ON lavanderia.endereco TO 'lavanderia_user'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON lavanderia.pedido TO 'lavanderia_user'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON lavanderia.pedido_roupa TO 'lavanderia_user'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON lavanderia.roupa TO 'lavanderia_user'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON lavanderia.usuario TO 'lavanderia_user'@'localhost';

