CREATE DATABASE  IF NOT EXISTS `gstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gstore`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gstore
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `descuento`
--

DROP TABLE IF EXISTS `descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descuento` (
  `id` int(11) NOT NULL,
  `nombre` varchar(64) DEFAULT NULL,
  `porcentaje` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuento`
--

LOCK TABLES `descuento` WRITE;
/*!40000 ALTER TABLE `descuento` DISABLE KEYS */;
INSERT INTO `descuento` VALUES (1,'gabrielelmejor',65.5),(2,'margotlamejor',99.99);
/*!40000 ALTER TABLE `descuento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `id_compra` int(11) NOT NULL,
  `nombre_cliente` varchar(64) DEFAULT NULL,
  `id_cliente` varchar(11) DEFAULT NULL,
  `nombre_cel` varchar(32) NOT NULL,
  `precio_cel` double NOT NULL,
  `descuento` double DEFAULT NULL,
  `total` double NOT NULL,
  `tarjeta` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id_compra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (1,'Miguel Iglesias','1','Oneplus 6T',1100000.332,0,4400001.328,'1234567891234567'),(2,'Alvaro Uribe','4567','iPhone 8',1350000.642,0,1350000.642,'4765434356787654'),(3,'Miguel Iglesias','1','Oneplus 6T',1700000.654,5099491.9618037995,510.0001962007955,'2165434356787654'),(4,'Lupita Acevedo','1243','iPhone X',2250000.5,1473750.3275,776250.1725000001,'8932434356787654');
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id` varchar(11) NOT NULL,
  `primer_nombre` varchar(32) NOT NULL,
  `primer_apellido` varchar(32) DEFAULT NULL,
  `correo` varchar(64) NOT NULL,
  `contrasena` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES ('1','Miguel','Iglesias','miguel@gmail.com','1'),('123','Gabriel','Garcia','gabriel@gmail.com','gabrieljajasaludos'),('1243','Lupita','Acevedo','lupi@gmail.com','lupita'),('32355643','Mireya','Lopez','mire.lopez@hotmail.com','mireya'),('45342121','German','Granados','german.granados@hotmail.com','germangranados'),('4567','Alvaro','Uribe','elgrancolombiano@centrodemocratico.com','uribe'),('5789','Jose','Restrepo','eljose@udea.com','jose57890'),('634433','Juan','Ortega','ortega@hotmail.com','ortega'),('root','root','root','root','root');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefono` (
  `id` int(11) NOT NULL,
  `marca` varchar(32) NOT NULL DEFAULT 'Genérico',
  `nombre` varchar(32) NOT NULL,
  `color` varchar(32) NOT NULL,
  `capacidad` double NOT NULL,
  `precio` double NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono`
--

LOCK TABLES `telefono` WRITE;
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
INSERT INTO `telefono` VALUES (1,'Apple','iPhone X','Negro',64,2250000.5,4),(2,'Samsung','Galaxy Note 10','Azul',256,2500000.578,6),(3,'Huawei','Mate 10 Lite','Dorado',32,450000.23,0),(4,'Oppo','Oneplus 6T','Gris Espacial',128,1700000.654,1),(11,'Apple','iPhone 11','Blanco',128,3000000,2),(12,'Apple','iPhone SE','Azul celeste',16,850000.324,5),(13,'Apple','iPhone 8','Dorado',64,1350000.642,7),(21,'Samsung','Galaxy S10 Plus','Negro',256,2454362.745,1),(401,'Oppo','Oneplus 6T','Azul',32,1100000.332,7);
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-11  1:27:12
