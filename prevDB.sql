-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
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
CREATE TABLE `pessoa` (
`id` bigint(20) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
`nome` text DEFAULT NULL,
`cpf` int DEFAULT NULL,
`genero` boolean DEFAULT NULL
);
SELECT nome, 
       CASE WHEN genero = TRUE THEN 'Masculino' 
            WHEN genero = FALSE THEN 'Feminino' 
       END AS genero
FROM pessoa;

CREATE TABLE `produtos` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nome` text DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `status` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id`, `nome`, `valor`, `status`) VALUES
(2, 'DermaSOL', 1500, 'A venda'),
(3, 'Dipurona', 800, 'A venda'),
(4, 'Água oxigenada', 4800, 'A venda'),
(5, 'Corticoide', 400, 'A Venda');


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
