-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-05-2025 a las 21:37:37
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
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_ips`
--

CREATE TABLE `historial_ips` (
  `id` int(11) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `ip` varchar(45) NOT NULL,
  `hostname` varchar(255) DEFAULT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `pais` varchar(10) DEFAULT NULL,
  `coordenadas` varchar(50) DEFAULT NULL,
  `fecha` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `historial_ips`
--

INSERT INTO `historial_ips` (`id`, `usuario_id`, `ip`, `hostname`, `ciudad`, `pais`, `coordenadas`, `fecha`) VALUES
(28, 7, '8.8.8.8', 'dns.google', 'Mountain View', 'US', '38.0088,-122.1175', '2025-05-22 10:17:29'),
(29, 7, '8.8.8.8', 'dns.google', 'Mountain View', 'US', '38.0088,-122.1175', '2025-05-22 13:06:43'),
(30, 27, '8.8.8.8', 'dns.google', 'Mountain View', 'US', '37.4056,-122.0775', '2025-05-22 21:21:16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas_log`
--

CREATE TABLE `personas_log` (
  `ID_LOG` int(11) NOT NULL,
  `NOMBRE_USUARIO` varchar(100) DEFAULT NULL,
  `HORA_CREACION` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `personas_log`
--

INSERT INTO `personas_log` (`ID_LOG`, `NOMBRE_USUARIO`, `HORA_CREACION`) VALUES
(1, 'Medac', '2025-05-22 10:21:14'),
(2, 'loloRico', '2025-05-22 10:26:16'),
(3, 'JuanButanero', '2025-05-22 21:01:25'),
(4, 'medac', '2025-05-22 21:21:03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_user`
--

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Volcado de datos para la tabla `tb_user`
--

INSERT INTO `tb_user` (`id`, `nombre_usuario`, `contrasena`) VALUES
(7, 'David', 'admin'),
(26, 'JuanButanero', 'lolo1234'),
(27, 'medac', 'medac');

--
-- Disparadores `tb_user`
--
DELIMITER $$
CREATE TRIGGER `TRG_PERSONAS` AFTER INSERT ON `tb_user` FOR EACH ROW BEGIN
  INSERT INTO PERSONAS_LOG (
    NOMBRE_USUARIO,
    HORA_CREACION
  ) VALUES (
    NEW.nombre_usuario,
    NOW()
  );
END
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `historial_ips`
--
ALTER TABLE `historial_ips`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indices de la tabla `personas_log`
--
ALTER TABLE `personas_log`
  ADD PRIMARY KEY (`ID_LOG`);

--
-- Indices de la tabla `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre_usuario` (`nombre_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historial_ips`
--
ALTER TABLE `historial_ips`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `personas_log`
--
ALTER TABLE `personas_log`
  MODIFY `ID_LOG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historial_ips`
--
ALTER TABLE `historial_ips`
  ADD CONSTRAINT `historial_ips_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
