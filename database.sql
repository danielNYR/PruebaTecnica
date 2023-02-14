-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.10.2-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para projecbb
CREATE DATABASE IF NOT EXISTS `projecbb` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `projecbb`;

-- Volcando estructura para tabla projecbb.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `contrasenaCliente` varchar(45) DEFAULT NULL,
  `estadoCliente` varchar(45) DEFAULT NULL,
  `idPersona` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`,`idPersona`),
  KEY `fk_Cliente_Persona_idx` (`idPersona`),
  CONSTRAINT `fk_Cliente_Persona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla projecbb.cliente: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT IGNORE INTO `cliente` (`idCliente`, `contrasenaCliente`, `estadoCliente`, `idPersona`) VALUES
	(1, 'Pass01', 'Activo', 3),
	(2, 'Pass02', 'Activo', 4);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla projecbb.cuenta
CREATE TABLE IF NOT EXISTS `cuenta` (
  `numeroCuenta` int(11) NOT NULL AUTO_INCREMENT,
  `tipoCuenta` varchar(45) DEFAULT NULL,
  `saldoInicialCuenta` double DEFAULT NULL,
  `estadoCuenta` varchar(45) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  PRIMARY KEY (`numeroCuenta`,`idCliente`),
  KEY `fk_Cuenta_Cliente1_idx` (`idCliente`),
  CONSTRAINT `fk_Cuenta_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla projecbb.cuenta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
INSERT IGNORE INTO `cuenta` (`numeroCuenta`, `tipoCuenta`, `saldoInicialCuenta`, `estadoCuenta`, `idCliente`) VALUES
	(2, 'Nomina', 1200, 'Activo', 1),
	(3, 'Ahorro', 2000, 'Activo', 2);
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;

-- Volcando estructura para tabla projecbb.movimiento
CREATE TABLE IF NOT EXISTS `movimiento` (
  `idMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `valor` varchar(45) DEFAULT NULL,
  `saldo` varchar(45) DEFAULT NULL,
  `numeroCuenta` int(11) NOT NULL,
  PRIMARY KEY (`idMovimiento`,`numeroCuenta`),
  KEY `fk_Movimiento_Cuenta1_idx` (`numeroCuenta`),
  CONSTRAINT `fk_Movimiento_Cuenta1` FOREIGN KEY (`numeroCuenta`) REFERENCES `cuenta` (`numeroCuenta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla projecbb.movimiento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
INSERT IGNORE INTO `movimiento` (`idMovimiento`, `fecha`, `tipo`, `valor`, `saldo`, `numeroCuenta`) VALUES
	(1, '11/02/2023', 'Deposito', '200', '200', 3),
	(2, '13-02-2023', 'deposito', '200.0', '1300.0', 2),
	(3, '13-02-2023', 'retiro', '100.0', '1200.0', 2);
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;

-- Volcando estructura para tabla projecbb.persona
CREATE TABLE IF NOT EXISTS `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombrePersona` varchar(45) DEFAULT NULL,
  `generoPersona` varchar(45) DEFAULT NULL,
  `edadPersona` varchar(45) DEFAULT NULL,
  `identificacionPersona` varchar(45) DEFAULT NULL,
  `direccionPersona` varchar(255) DEFAULT NULL,
  `telefonoPersona` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Volcando datos para la tabla projecbb.persona: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT IGNORE INTO `persona` (`idPersona`, `nombrePersona`, `generoPersona`, `edadPersona`, `identificacionPersona`, `direccionPersona`, `telefonoPersona`) VALUES
	(3, 'Daniel Nava', 'Hombre', '25', '011223344', 'Rubi Coral 97', '7471459116'),
	(4, 'Yessica Alondra', 'Mujer', '26', '1122334455', '16 de Septiembre 25', '7471253391');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
