-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_esmeralda
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `id_categoria` int NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `stock_minimo` int DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Bebidas',10,'Activo'),(2,'Galletas',10,'Activo'),(3,'Lacteos',10,'Activo');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL,
  `dni_cliente` int NOT NULL,
  PRIMARY KEY (`id_cliente`),
  CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `personas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (2,60150242),(4,64312547);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobantepago`
--

DROP TABLE IF EXISTS `comprobantepago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprobantepago` (
  `id_cp` int NOT NULL,
  `fecha` date NOT NULL,
  `subtotal` float NOT NULL,
  `igv` float DEFAULT NULL,
  `total_venta` float NOT NULL,
  `metodo_pago` varchar(30) NOT NULL,
  `id_tc` int NOT NULL,
  PRIMARY KEY (`id_cp`),
  KEY `R_17` (`id_tc`),
  CONSTRAINT `comprobantepago_ibfk_1` FOREIGN KEY (`id_tc`) REFERENCES `tipocomprobante` (`id_tc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobantepago`
--

LOCK TABLES `comprobantepago` WRITE;
/*!40000 ALTER TABLE `comprobantepago` DISABLE KEYS */;
INSERT INTO `comprobantepago` VALUES (1,'2020-11-24',3,0,3,'Efectivo',1),(2,'2020-11-24',9.6,0,9.6,'Efectivo',1),(3,'2020-11-12',7.7,0,7.7,'Efectivo',1),(4,'2020-11-11',1.5,0,1.5,'Efectivo',2),(5,'2020-11-10',3,0,3,'Efectivo',1),(6,'2020-11-14',1.5,0,1.5,'Efectivo',1),(7,'2020-11-18',5.8,0,5.8,'Efectivo',1),(8,'2020-11-17',3,0,3,'Efectivo',2),(9,'2020-11-25',3,0,3,'Efectivo',1);
/*!40000 ALTER TABLE `comprobantepago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentausuarios`
--

DROP TABLE IF EXISTS `cuentausuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentausuarios` (
  `id_cuenta` int NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `contrasenha` varchar(60) NOT NULL,
  `tipo_usuario` varchar(40) NOT NULL,
  `id_empleado` int NOT NULL,
  PRIMARY KEY (`id_cuenta`),
  KEY `R_21` (`id_empleado`),
  CONSTRAINT `cuentausuarios_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentausuarios`
--

LOCK TABLES `cuentausuarios` WRITE;
/*!40000 ALTER TABLE `cuentausuarios` DISABLE KEYS */;
INSERT INTO `cuentausuarios` VALUES (1,'Ramiquero','$2y$12$fDpkPP8UlSpPZ/KHS1YxEucnITFU.VbsUBQpbroVdr.dnOQrM8xme','Administrador',7),(2,'Onajarro','$2y$12$mW5zwls2L./pGJOzZULFke6yDwbk55fqspdN6mrqaKntX0OySM1YK','Cajero',8);
/*!40000 ALTER TABLE `cuentausuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentausuarios_permisos`
--

DROP TABLE IF EXISTS `cuentausuarios_permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentausuarios_permisos` (
  `id_cuenta` int NOT NULL,
  `id_permiso` int NOT NULL,
  PRIMARY KEY (`id_cuenta`,`id_permiso`),
  KEY `R_24` (`id_permiso`),
  CONSTRAINT `cuentausuarios_permisos_ibfk_1` FOREIGN KEY (`id_cuenta`) REFERENCES `cuentausuarios` (`id_cuenta`),
  CONSTRAINT `cuentausuarios_permisos_ibfk_2` FOREIGN KEY (`id_permiso`) REFERENCES `permisos` (`id_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentausuarios_permisos`
--

LOCK TABLES `cuentausuarios_permisos` WRITE;
/*!40000 ALTER TABLE `cuentausuarios_permisos` DISABLE KEYS */;
INSERT INTO `cuentausuarios_permisos` VALUES (1,1),(1,2),(1,3),(2,6);
/*!40000 ALTER TABLE `cuentausuarios_permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalleventa` (
  `id_producto` int NOT NULL,
  `id_venta` int NOT NULL,
  `cantidad_producto` int NOT NULL,
  `importe` float NOT NULL,
  PRIMARY KEY (`id_producto`,`id_venta`),
  KEY `R_8` (`id_venta`),
  CONSTRAINT `detalleventa_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  CONSTRAINT `detalleventa_ibfk_2` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventa`
--

LOCK TABLES `detalleventa` WRITE;
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
INSERT INTO `detalleventa` VALUES (2,1,2,3),(2,4,1,1.5),(2,6,1,1.5),(3,9,3,3),(5,5,1,2.5),(6,5,1,0.5),(7,3,1,1.7),(8,2,2,7.6),(8,7,1,3.8),(9,2,1,2),(9,7,1,2),(10,3,2,6),(10,8,1,3);
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id_empleado` int NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `dni_empleado` int NOT NULL,
  `genero` varchar(20) NOT NULL,
  PRIMARY KEY (`id_empleado`),
  CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `personas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (3,'Fernadez sanchez',63545589,'femenino'),(7,'Amiquero Vargas',60150242,'masculino'),(8,'Najarro Huaman',98796356,'masculino'),(9,'Torrejon Vargas',65555556,'masculino');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entradaproductos`
--

DROP TABLE IF EXISTS `entradaproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entradaproductos` (
  `id_ep` int NOT NULL,
  `nro_factura` varchar(30) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `id_proveedor` int NOT NULL,
  PRIMARY KEY (`id_ep`),
  KEY `R_31` (`id_proveedor`),
  CONSTRAINT `entradaproductos_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradaproductos`
--

LOCK TABLES `entradaproductos` WRITE;
/*!40000 ALTER TABLE `entradaproductos` DISABLE KEYS */;
INSERT INTO `entradaproductos` VALUES (1,'F00001','2020-11-26',1),(2,'F00002','2020-11-27',1),(3,'F00003','2020-11-27',5),(4,'F00004','2020-12-09',1),(5,'F00005','2020-12-01',1);
/*!40000 ALTER TABLE `entradaproductos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entradaproductos_productos`
--

DROP TABLE IF EXISTS `entradaproductos_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entradaproductos_productos` (
  `id_ep` int NOT NULL,
  `id_producto` int NOT NULL,
  `cantidad_ingresado` int NOT NULL,
  `costo_unitario` float NOT NULL,
  `fechav_nuevo` date NOT NULL,
  PRIMARY KEY (`id_ep`,`id_producto`),
  KEY `R_30` (`id_producto`),
  CONSTRAINT `entradaproductos_productos_ibfk_1` FOREIGN KEY (`id_ep`) REFERENCES `entradaproductos` (`id_ep`),
  CONSTRAINT `entradaproductos_productos_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entradaproductos_productos`
--

LOCK TABLES `entradaproductos_productos` WRITE;
/*!40000 ALTER TABLE `entradaproductos_productos` DISABLE KEYS */;
INSERT INTO `entradaproductos_productos` VALUES (1,1,5,2,'2020-12-14'),(2,1,30,0.8,'2020-12-12'),(2,5,20,2.1,'2021-01-01'),(3,2,14,0.8,'2020-12-11'),(4,13,3,2.2,'2021-05-01'),(5,14,30,8.2,'2021-01-08');
/*!40000 ALTER TABLE `entradaproductos_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permisos` (
  `id_permiso` int NOT NULL,
  `descripcion` varchar(70) NOT NULL,
  PRIMARY KEY (`id_permiso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,'Registrar Proveedores'),(2,'Listar Proveedores'),(3,'Registrar Productos'),(4,'Salida de Productos'),(5,'Entrada de Productos'),(6,'Listar Productos'),(7,'Realizar Venta'),(8,'Listar Usuarios'),(9,'Listar Ventas Registradas'),(10,'Reportes'),(11,'Registrar Usuarios');
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id` int NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `direccion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'Ronald','roamz.2017@gmail.com',957108923,'Av. Los manzanos '),(2,'Messi','messi.2010@gmail.com',975642321,'Av. los peras'),(3,'Erny','erny.23@gmail.com',978456325,'av. los naranjos'),(4,'Nataly','nataly.12@gmail.com',965478512,'av. por venir'),(5,'Maria','maria.20@gmail.com',987456824,'av. los manzanos lt 12'),(6,'Carlitos','carlosito@gmail.com',976325479,'jr. cascos la torre 13'),(7,'Roy','roy.2040@gmail.com',987896548,'jr. los angeles lt s/n'),(8,'Oscar','oscar.23@gmail.com',987855656,'jr. 11 los marcianitos'),(9,'Jhon','jhon.20@gmail.com',987565889,'jr. moutpe lt 18');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_producto` int NOT NULL,
  `codigo_barra` varchar(50) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `costo_unitario` float NOT NULL,
  `precio_venta` float NOT NULL,
  `stock_producto` int NOT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `R_25` (`id_categoria`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'codb00001','galleta soda',0.65,0.7,54,'2020-11-27',2),(2,'codb00002','galleta cracknel',0.7,1.5,40,'2020-12-11',2),(3,'codb00003','gaseosa kr pequeño',0.8,1,57,'2020-11-18',1),(4,'codb00004','gaseosa kr mediano',1,1.5,0,'2020-11-26',1),(5,'codb00005','gaseosa kr grande',2,2.5,60,'2020-11-26',1),(6,'codb00006','galleta casino',0.3,0.5,62,'2020-11-23',2),(7,'codb00007','leche gloria pequeño',1.3,1.7,44,'2021-02-06',3),(8,'codb00008','leche gloria grande',3.2,3.8,43,'2021-05-12',3),(9,'codb00009','yogurt gloria pequeño',1.6,2,76,'2021-02-24',3),(10,'codb00010','yogurt gloria mediano',2.5,3,57,'2021-01-29',3),(11,'codb00011','Energizante Volt Ginseng 300 ml',2,2.5,46,'2021-01-09',1),(12,'codb00012','Red Bull Sugar Free 250 ml',6,6.9,56,'2021-06-18',1),(13,'codb00013','Energizante Volt Maca 300 ml',2.1,2.5,48,'2021-05-01',1),(14,'codb00014','Monster Energy Ultra 473 ml',8.1,8.5,70,'2021-01-08',1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos_salidaproducto`
--

DROP TABLE IF EXISTS `productos_salidaproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos_salidaproducto` (
  `id_producto` int NOT NULL,
  `id_sp` int NOT NULL,
  PRIMARY KEY (`id_producto`,`id_sp`),
  KEY `R_34` (`id_sp`),
  CONSTRAINT `productos_salidaproducto_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  CONSTRAINT `productos_salidaproducto_ibfk_2` FOREIGN KEY (`id_sp`) REFERENCES `salidaproducto` (`id_sp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos_salidaproducto`
--

LOCK TABLES `productos_salidaproducto` WRITE;
/*!40000 ALTER TABLE `productos_salidaproducto` DISABLE KEYS */;
/*!40000 ALTER TABLE `productos_salidaproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `id_proveedor` int NOT NULL,
  `nombre_empresa` varchar(30) NOT NULL,
  `comercializa` varchar(70) DEFAULT NULL,
  `ruc` int NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  CONSTRAINT `proveedores_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `personas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES (1,'Roamz sac','Bebidas, Galletas, Lacteos',56656999),(5,'Gloria sac','Lacteos, bebidas, embutidos',95556668),(6,'Carlos sac','Bebidas, Cereales',89632457);
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores_productos`
--

DROP TABLE IF EXISTS `proveedores_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores_productos` (
  `id_producto` int NOT NULL,
  `id_proveedor` int NOT NULL,
  PRIMARY KEY (`id_proveedor`,`id_producto`),
  KEY `R_13` (`id_producto`),
  CONSTRAINT `proveedores_productos_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  CONSTRAINT `proveedores_productos_ibfk_2` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores_productos`
--

LOCK TABLES `proveedores_productos` WRITE;
/*!40000 ALTER TABLE `proveedores_productos` DISABLE KEYS */;
INSERT INTO `proveedores_productos` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,5),(10,5),(11,1),(12,1),(13,1),(14,1);
/*!40000 ALTER TABLE `proveedores_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salidaproducto`
--

DROP TABLE IF EXISTS `salidaproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salidaproducto` (
  `id_sp` int NOT NULL,
  `fecha_salida` date NOT NULL,
  `cantidad` int NOT NULL,
  `tipo_movimiento` varchar(50) NOT NULL,
  `motivo_movimiento` varchar(70) DEFAULT NULL,
  `id_proveedor` int DEFAULT NULL,
  PRIMARY KEY (`id_sp`),
  KEY `R_35` (`id_proveedor`),
  CONSTRAINT `salidaproducto_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salidaproducto`
--

LOCK TABLES `salidaproducto` WRITE;
/*!40000 ALTER TABLE `salidaproducto` DISABLE KEYS */;
/*!40000 ALTER TABLE `salidaproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocomprobante`
--

DROP TABLE IF EXISTS `tipocomprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipocomprobante` (
  `id_tc` int NOT NULL,
  `descripcion` varchar(40) NOT NULL,
  PRIMARY KEY (`id_tc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocomprobante`
--

LOCK TABLES `tipocomprobante` WRITE;
/*!40000 ALTER TABLE `tipocomprobante` DISABLE KEYS */;
INSERT INTO `tipocomprobante` VALUES (1,'Boleta'),(2,'Factura');
/*!40000 ALTER TABLE `tipocomprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `id_venta` int NOT NULL,
  `id_cliente` int NOT NULL,
  `id_empleado` int NOT NULL,
  `id_cp` int NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `R_15` (`id_cliente`),
  KEY `R_20` (`id_empleado`),
  KEY `R_37` (`id_cp`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_empleado`) REFERENCES `empleados` (`id_empleado`),
  CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`id_cp`) REFERENCES `comprobantepago` (`id_cp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,2,3,1),(2,4,3,2),(3,2,3,3),(4,2,3,4),(5,2,3,5),(6,2,3,6),(7,2,3,7),(8,4,3,8),(9,2,3,9);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-14  9:07:49
