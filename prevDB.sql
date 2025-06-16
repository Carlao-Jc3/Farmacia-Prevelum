-- Host: 127.0.0.1
-- Tempo de geração: 27-Abr-2023 às 17:58
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `uc11`
--
drop database if exists prevelum;
create database prevelum;
use prevelum;
-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE Usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL, -- Armazena a senha (futuramente pode ser hash)
    nivel_acesso ENUM('Administrador', 'Operador', 'Aprendiz') NOT NULL
);


CREATE TABLE `pessoa` (
id bigint(20) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
`nome` text DEFAULT NULL,
`cpf` int DEFAULT NULL,
`genero` boolean DEFAULT NULL
);
SELECT nome, 
       CASE WHEN genero = TRUE THEN 'Masculino' 
            WHEN genero = FALSE THEN 'Feminino' 
       END AS genero
FROM pessoa;


CREATE TABLE Produtos (
  `id` bigint(20) UNSIGNED NOT NULL primary key auto_increment,
  `nome` text DEFAULT NULL,
  `utilidade` varchar(225),
  `valor` int(11) DEFAULT NULL,
  `status` ENUM ('A venda', 'Vendido') not null default 'A venda'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Vendas (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    id_P INT NOT NULL,
    id_C INT,
    `data` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_P) REFERENCES Produtos(id),
    FOREIGN KEY (id_C) REFERENCES Clientes(id)
);

CREATE TABLE Clientes(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE, -- Formato: 123.456.789-00
    telefone VARCHAR(15), -- Formato: (XX) XXXXX-XXXX
    email VARCHAR(100)
);


--
-- Populando o banco 
--
INSERT INTO Usuarios (usuario, senha, nivel_acesso) VALUES
('admin', 'admin123', 'Administrador'),
('operador', 'op123', 'Operador'),
('aprendiz', 'ap123', 'Aprendiz');

INSERT INTO Clientes (nome, cpf, telefone, email) VALUES
('João Silva', '123.456.789-00', '(11) 98765-4321', 'joao.silva@email.com'),
('Maria Oliveira', '987.654.321-00', '(21) 91234-5678', 'maria.oliveira@email.com');

INSERT INTO Produtos (nome, utilidade, valor, status) VALUES
('Paracetamol', 'Analgésico', 15.50, 'a Venda'),
('Amoxicilina', 'Antibiótico', 45.00, 'a Venda'),
('Dipirona', 'Analgésico', 10.00, 'Vendido');

INSERT INTO Vendas (id_produto, id_cliente) VALUES
(3, 1); -- Venda do produto Dipirona para João Silva


--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
