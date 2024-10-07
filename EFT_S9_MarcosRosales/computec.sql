-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-10-2024 a las 02:13:17
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `computec`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `rut` int(100) NOT NULL,
  `nombres` varchar(200) NOT NULL,
  `apellidos` varchar(200) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `comuna` varchar(200) NOT NULL,
  `correo` varchar(200) NOT NULL,
  `numero` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `rut`, `nombres`, `apellidos`, `direccion`, `comuna`, `correo`, `numero`) VALUES
(1, 20467984, 'marcos', 'rosales', 'lo moreno', 'el bosque', 'rosaleasjq@wqdas.com', 944039685),
(2, 173753160, 'Christian', 'Gonzalez', 'jose joaquin prieto 123123', 'lo espejo', 'gfkljhakleqwjhwekqfadlsldk@asld.com', 789456132);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desktop`
--

CREATE TABLE `desktop` (
  `id` int(11) NOT NULL,
  `modelo` varchar(200) NOT NULL,
  `cpu` varchar(200) NOT NULL,
  `disco` int(255) NOT NULL,
  `ram` int(255) NOT NULL,
  `precio` double NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `fuente` varchar(200) NOT NULL,
  `forma` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `desktop`
--

INSERT INTO `desktop` (`id`, `modelo`, `cpu`, `disco`, `ram`, `precio`, `disponible`, `fuente`, `forma`) VALUES
(1, 'asus KLFDSAKLJF', 'AMD ', 200, 16, 700, 1, 'cooler master', 'ATX'),
(2, 'ASUS ASDJA', 'AMD', 1000, 32, 700, 1, 'cool', 'ATX');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laptop`
--

CREATE TABLE `laptop` (
  `id` int(11) NOT NULL,
  `modelo` varchar(200) NOT NULL,
  `cpu` varchar(200) NOT NULL,
  `disco` int(255) NOT NULL,
  `ram` int(255) NOT NULL,
  `precio` double NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `pulgadas` varchar(200) NOT NULL,
  `puertos` varchar(200) NOT NULL,
  `touch` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `laptop`
--

INSERT INTO `laptop` (`id`, `modelo`, `cpu`, `disco`, `ram`, `precio`, `disponible`, `pulgadas`, `puertos`, `touch`) VALUES
(1, 'HP 1235412', 'Intel i3', 500, 8, 550, 1, '22 pulgadas', '4 puertos', 1),
(2, 'REDRAGON AWSQE', 'INTEL I7', 780, 32, 500, 1, '28 PULGADAS', '5 PUERTOS', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventasdesk`
--

CREATE TABLE `ventasdesk` (
  `idVenta` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idDesk` int(11) NOT NULL,
  `total` double NOT NULL,
  `fechaHora` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventaslaptop`
--

CREATE TABLE `ventaslaptop` (
  `idVenta` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idLap` int(11) NOT NULL,
  `total` double NOT NULL,
  `fechaHora` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventaslaptop`
--

INSERT INTO `ventaslaptop` (`idVenta`, `idCliente`, `idLap`, `total`, `fechaHora`) VALUES
(1, 2, 1, 550, '2024-10-07 00:03:16');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `desktop`
--
ALTER TABLE `desktop`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `laptop`
--
ALTER TABLE `laptop`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventasdesk`
--
ALTER TABLE `ventasdesk`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `fk_cliente` (`idCliente`),
  ADD KEY `fk_desk` (`idDesk`);

--
-- Indices de la tabla `ventaslaptop`
--
ALTER TABLE `ventaslaptop`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `fk_clientelap` (`idCliente`),
  ADD KEY `fk_lap` (`idLap`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `desktop`
--
ALTER TABLE `desktop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `laptop`
--
ALTER TABLE `laptop`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ventasdesk`
--
ALTER TABLE `ventasdesk`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ventaslaptop`
--
ALTER TABLE `ventaslaptop`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ventasdesk`
--
ALTER TABLE `ventasdesk`
  ADD CONSTRAINT `fk_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `fk_desk` FOREIGN KEY (`idDesk`) REFERENCES `desktop` (`id`);

--
-- Filtros para la tabla `ventaslaptop`
--
ALTER TABLE `ventaslaptop`
  ADD CONSTRAINT `fk_clientelap` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `fk_lap` FOREIGN KEY (`idLap`) REFERENCES `laptop` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
