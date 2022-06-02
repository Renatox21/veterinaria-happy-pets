-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_veterinaria
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_categoria`
--

DROP TABLE IF EXISTS `tb_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_categoria` (
  `id_categoria` int NOT NULL COMMENT 'id de la categoría',
  `desc_categoria` varchar(45) NOT NULL COMMENT 'descripción de la categoría',
  PRIMARY KEY (`id_categoria`),
  UNIQUE KEY `id_categoria_UNIQUE` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Categoría de los proctos que hay en almacén';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria`
--

LOCK TABLES `tb_categoria` WRITE;
/*!40000 ALTER TABLE `tb_categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT COMMENT 'id del cliente',
  `dni_cliente` varchar(45) NOT NULL COMMENT 'dni del cliente',
  `nom_cliente` varchar(115) NOT NULL COMMENT 'nombre del cliente',
  `ape_cliente` varchar(115) NOT NULL COMMENT 'apellido del cliente',
  `correo_cliente` varchar(225) NOT NULL COMMENT 'correo del cliente',
  `tef_cliente` varchar(15) NOT NULL DEFAULT '000-000-000' COMMENT 'telefono o celular del cliente',
  `dirc_cliente` varchar(225) NOT NULL COMMENT 'dirección del cliente',
  `sexo_cliente` varchar(45) NOT NULL COMMENT 'sexo del cliente',
  `fec_nac` date NOT NULL COMMENT 'fecha de nacimiento',
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_UNIQUE` (`id_cliente`),
  UNIQUE KEY `dni_dueño_UNIQUE` (`dni_cliente`),
  UNIQUE KEY `correo_cliente_UNIQUE` (`correo_cliente`),
  UNIQUE KEY `tef_cliente_UNIQUE` (`tef_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_comprobante_pago`
--

DROP TABLE IF EXISTS `tb_comprobante_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_comprobante_pago` (
  `num_comprobante_pago` varchar(45) NOT NULL COMMENT 'Número de comprobante de pago',
  `tipo_comprobante` varchar(10) NOT NULL COMMENT 'tipo de comprobante de pago(boleta, factura)',
  `ruc` char(11) NOT NULL DEFAULT '00000000000',
  `dni` char(8) NOT NULL,
  `id_cliente` int NOT NULL,
  `id_empleado` int NOT NULL,
  PRIMARY KEY (`num_comprobante_pago`),
  UNIQUE KEY `num_comprobante_pago_UNIQUE` (`num_comprobante_pago`),
  KEY `id_cliente_idx` (`id_cliente`),
  KEY `id_empleado_idx` (`id_empleado`),
  CONSTRAINT `id_cliente_comprobante_pago` FOREIGN KEY (`id_cliente`) REFERENCES `tb_cliente` (`id_cliente`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `id_empleado_comprobante_pago` FOREIGN KEY (`id_empleado`) REFERENCES `tb_empleado` (`id_empleado`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Comprobante de pago, boleta o factura';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_comprobante_pago`
--

LOCK TABLES `tb_comprobante_pago` WRITE;
/*!40000 ALTER TABLE `tb_comprobante_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_comprobante_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_consulta`
--

DROP TABLE IF EXISTS `tb_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_consulta` (
  `id_consulta` int NOT NULL AUTO_INCREMENT COMMENT 'id de la consulta',
  `id_empleado` int NOT NULL COMMENT 'id del empleado',
  `id_mascota` int NOT NULL COMMENT 'id de la mascota',
  `id_cliente` int NOT NULL COMMENT 'id del cliente',
  `id_detalleConsulta` int NOT NULL COMMENT 'detalle de la consulta',
  `razon_consulta` varchar(45) NOT NULL COMMENT 'razón de la consulta',
  `costo_consulta` decimal(7,2) NOT NULL COMMENT 'costo de la consulta',
  `fec_registro` date NOT NULL COMMENT 'fecha de registro de la cita programada',
  `fec_consulta` date NOT NULL COMMENT 'fecha que se realizó la consulta',
  PRIMARY KEY (`id_consulta`),
  UNIQUE KEY `id_consulta_UNIQUE` (`id_consulta`),
  KEY `id_empleado_idx` (`id_empleado`),
  KEY `id_cliente_idx` (`id_cliente`),
  KEY `id_mascota_idx` (`id_mascota`),
  KEY `id_detalleConsulta_idx` (`id_detalleConsulta`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `tb_cliente` (`id_cliente`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `id_detalleConsulta` FOREIGN KEY (`id_detalleConsulta`) REFERENCES `tb_detalleconsulta` (`id_detalleConsulta`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `id_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `tb_empleado` (`id_empleado`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `id_mascota` FOREIGN KEY (`id_mascota`) REFERENCES `tb_mascota` (`id_mascota`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabla de la consulta';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_consulta`
--

LOCK TABLES `tb_consulta` WRITE;
/*!40000 ALTER TABLE `tb_consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalle_comprobante`
--

DROP TABLE IF EXISTS `tb_detalle_comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_detalle_comprobante` (
  `num_comprobante_pago` varchar(45) NOT NULL COMMENT 'número del comprobante de pago',
  `id_producto` int NOT NULL COMMENT 'id del producto',
  `cantidad` int NOT NULL COMMENT 'Cantidad comprada del producto',
  `pre_uni` decimal(7,2) NOT NULL COMMENT 'Precio unitario del producto',
  `descuento` decimal(5,2) NOT NULL COMMENT 'Descuento del producto',
  PRIMARY KEY (`num_comprobante_pago`,`id_producto`),
  KEY `id_producto_idx` (`id_producto`),
  CONSTRAINT `id_producto` FOREIGN KEY (`id_producto`) REFERENCES `tb_producto` (`id_producto`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `num_comprobante_pago` FOREIGN KEY (`num_comprobante_pago`) REFERENCES `tb_comprobante_pago` (`num_comprobante_pago`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Detalle del comprobate de pago';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalle_comprobante`
--

LOCK TABLES `tb_detalle_comprobante` WRITE;
/*!40000 ALTER TABLE `tb_detalle_comprobante` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detalle_comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalleconsulta`
--

DROP TABLE IF EXISTS `tb_detalleconsulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_detalleconsulta` (
  `id_detalleConsulta` int NOT NULL AUTO_INCREMENT,
  `observacion` varchar(255) CHARACTER SET sjis COLLATE sjis_japanese_ci NOT NULL COMMENT 'observaciones del doctor',
  `recomendaciones` varchar(255) NOT NULL COMMENT 'recomendaciones por el doctor',
  PRIMARY KEY (`id_detalleConsulta`),
  UNIQUE KEY `id_detalleConsulta_UNIQUE` (`id_detalleConsulta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Detalle de la consulta de una mascota';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalleconsulta`
--

LOCK TABLES `tb_detalleconsulta` WRITE;
/*!40000 ALTER TABLE `tb_detalleconsulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detalleconsulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empleado`
--

DROP TABLE IF EXISTS `tb_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_empleado` (
  `id_empleado` int NOT NULL AUTO_INCREMENT COMMENT 'id del empleado',
  `dni_empleado` char(8) NOT NULL COMMENT 'dni del empleado',
  `nom_empleado` varchar(115) NOT NULL COMMENT 'nombre del empleado',
  `ape_empleado` varchar(115) NOT NULL COMMENT 'apellido del empleado',
  `sexo_empleado` varchar(45) NOT NULL COMMENT 'sexo del empleado',
  `fec_nac` date NOT NULL COMMENT 'fecha de nacimiento del empleado',
  `fec_ing` date NOT NULL COMMENT 'fecha de ingreso del empleado al negocio',
  `user` varchar(45) NOT NULL COMMENT 'Usuario del empleado',
  PRIMARY KEY (`id_empleado`),
  UNIQUE KEY `id_empleado_UNIQUE` (`id_empleado`),
  UNIQUE KEY `user_UNIQUE` (`user`),
  CONSTRAINT `user` FOREIGN KEY (`user`) REFERENCES `tb_usuario` (`user`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Empleados que pertenecen a la veterinaria';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empleado`
--

LOCK TABLES `tb_empleado` WRITE;
/*!40000 ALTER TABLE `tb_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_mascota`
--

DROP TABLE IF EXISTS `tb_mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_mascota` (
  `id_mascota` int NOT NULL AUTO_INCREMENT COMMENT 'id de la mascota',
  `nombre_mascota` varchar(45) NOT NULL COMMENT 'nombre de la mascota',
  `tipo_mascota` varchar(45) NOT NULL COMMENT 'tipo de mascota',
  `raza_mascota` varchar(45) NOT NULL COMMENT 'raza de la mascota',
  `id_vacunas` int NOT NULL COMMENT 'id de la vacunas recibinas por la mascota',
  `fec_mascota` date NOT NULL DEFAULT '0000-00-00' COMMENT 'fecha de registro de la mascota a la veterinaria',
  `fec_nac` date NOT NULL DEFAULT '0000-00-00' COMMENT 'fecha de nacimeinto de la mascota',
  PRIMARY KEY (`id_mascota`),
  UNIQUE KEY `id_mascota_UNIQUE` (`id_mascota`),
  KEY `id_vacunas_idx` (`id_vacunas`),
  CONSTRAINT `id_vacunas` FOREIGN KEY (`id_vacunas`) REFERENCES `tb_vacuna` (`id_vacuna`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabla de Mascotas';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_mascota`
--

LOCK TABLES `tb_mascota` WRITE;
/*!40000 ALTER TABLE `tb_mascota` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_producto` (
  `id_producto` int NOT NULL COMMENT 'id de los productos',
  `desc_producto` varchar(225) NOT NULL COMMENT 'Descripción del producto',
  `stock` int NOT NULL COMMENT 'Cantidad de los productos en almacén',
  `pre_uni` decimal(7,2) NOT NULL COMMENT 'Precio unitario del producto',
  `id_categoria` int NOT NULL COMMENT 'id de la categoría del producto',
  PRIMARY KEY (`id_producto`),
  UNIQUE KEY `id_producto_UNIQUE` (`id_producto`),
  KEY `id_categoria_idx` (`id_categoria`),
  CONSTRAINT `id_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `tb_categoria` (`id_categoria`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabla de los productos que se venderan';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_producto`
--

LOCK TABLES `tb_producto` WRITE;
/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `user` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  PRIMARY KEY (`user`),
  UNIQUE KEY `user_UNIQUE` (`user`),
  UNIQUE KEY `password_UNIQUE` (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Usuarios y sus cargos';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_vacuna`
--

DROP TABLE IF EXISTS `tb_vacuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_vacuna` (
  `id_vacuna` int NOT NULL AUTO_INCREMENT COMMENT 'id de la vacuna',
  `desc_vacuna` varchar(45) NOT NULL COMMENT 'Descripción de la vacuna',
  PRIMARY KEY (`id_vacuna`),
  UNIQUE KEY `id_vacuna_UNIQUE` (`id_vacuna`),
  UNIQUE KEY `desc_vacuna_UNIQUE` (`desc_vacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Tabla de las vacunas';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_vacuna`
--

LOCK TABLES `tb_vacuna` WRITE;
/*!40000 ALTER TABLE `tb_vacuna` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_vacuna` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-18 14:19:56
