CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appoitments`
--

DROP TABLE IF EXISTS `appoitments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appoitments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` varchar(255) DEFAULT NULL,
  `patient_id` varchar(255) DEFAULT NULL,
  `creationTime` datetime DEFAULT NULL,
  `appointmentTime` datetime DEFAULT NULL,
  `isDone` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appoitments`
--

LOCK TABLES `appoitments` WRITE;
/*!40000 ALTER TABLE `appoitments` DISABLE KEYS */;
INSERT INTO `appoitments` VALUES (1,'200000000','300000000','2016-01-08 13:00:00','2016-01-26 13:00:00',1),(2,'200000007','300000000','2016-02-15 16:00:00','2016-02-24 16:00:00',1),(3,'200000008','300000000','2015-12-21 11:00:00','2016-01-03 11:00:00',1),(4,'200000008','300000000','2016-06-08 00:00:00','2016-06-14 00:00:00',0),(5,'200000009','300000000','2016-01-04 16:00:00','2016-01-17 16:00:00',1),(6,'200000002','300000000','2016-06-20 15:00:00','2016-06-20 15:00:00',0),(7,'200000008','300000001','2016-04-20 09:00:00','2016-04-26 09:00:00',1),(8,'200000001','300000001','2016-06-18 14:00:00','2016-06-19 14:00:00',0),(9,'200000002','300000001','2015-12-21 15:00:00','2016-01-04 15:00:00',1),(10,'200000009','300000001','2016-03-21 09:00:00','2016-03-21 09:00:00',1),(11,'200000010','300000001','2016-06-17 11:00:00','2016-06-23 11:00:00',0),(12,'200000009','300000002','2016-03-20 00:00:00','2016-03-24 00:00:00',0),(13,'200000010','300000002','2016-03-01 10:00:00','2016-03-20 10:00:00',1),(14,'200000004','300000002','2016-02-26 09:00:00','2016-03-03 09:00:00',1),(15,'200000011','300000002','2016-03-04 15:00:00','2016-03-16 15:00:00',1),(16,'200000004','300000002','2016-06-07 09:00:00','2016-06-14 09:00:00',0),(17,'200000010','300000003','2016-03-17 16:00:00','2016-03-21 16:00:00',1),(18,'200000011','300000003','2016-01-31 14:00:00','2016-02-17 14:00:00',0),(19,'200000004','300000003','2016-06-10 15:00:00','2016-06-16 15:00:00',0),(20,'200000005','300000003','2016-03-06 09:00:00','2016-03-23 09:00:00',0),(21,'200000012','300000003','2016-03-22 09:00:00','2016-03-24 09:00:00',1),(22,'200000005','300000003','2016-06-12 10:00:00','2016-06-20 10:00:00',0),(23,'200000004','300000004','2016-05-29 14:00:00','2016-06-13 14:00:00',0),(24,'200000005','300000004','2016-04-16 10:00:00','2016-04-17 10:00:00',0),(25,'200000012','300000004','2016-04-06 14:00:00','2016-04-14 14:00:00',1),(26,'200000005','300000004','2016-05-26 10:00:00','2016-06-14 10:00:00',0),(27,'200000006','300000004','2016-01-16 11:00:00','2016-01-26 11:00:00',1),(28,'200000013','300000004','2016-03-15 14:00:00','2016-03-23 14:00:00',0),(29,'200000006','300000004','2016-06-08 14:00:00','2016-06-19 14:00:00',0),(30,'200000005','300000005','2016-03-18 14:00:00','2016-04-05 15:00:00',1),(31,'200000006','300000005','2016-05-03 09:00:00','2016-05-16 09:00:00',1),(32,'200000013','300000005','2016-02-02 09:00:00','2016-02-07 09:00:00',1),(33,'200000013','300000005','2016-06-18 11:00:00','2016-06-21 11:00:00',0),(34,'200000000','300000005','2016-04-05 10:00:00','2016-04-06 10:00:00',1),(35,'200000007','300000005','2016-04-24 09:00:00','2016-05-01 09:00:00',1),(36,'200000007','300000005','2016-06-03 16:00:00','2016-06-22 16:00:00',0),(37,'200000006','300000006','2016-03-16 15:00:00','2016-03-20 15:00:00',1),(38,'200000013','300000006','2016-05-03 09:00:00','2016-05-03 09:00:00',1),(39,'200000000','300000006','2016-01-01 11:00:00','2016-01-13 11:00:00',1),(40,'200000007','300000006','2016-01-11 10:00:00','2016-01-11 10:00:00',0),(41,'200000007','300000006','2016-06-09 00:00:00','2016-06-26 00:00:00',0),(42,'200000008','300000006','2016-02-14 15:00:00','2016-02-17 15:00:00',1),(43,'200000008','300000006','2016-05-28 11:00:00','2016-06-12 11:00:00',0),(44,'200000000','300000007','2016-02-05 10:00:00','2016-02-11 10:00:00',1),(45,'200000000','300000007','2016-06-05 00:00:00','2016-06-16 00:00:00',0),(46,'200000001','300000007','2016-06-08 10:00:00','2016-06-15 10:00:00',0),(47,'200000002','300000007','2016-04-18 15:00:00','2016-04-20 15:00:00',1),(48,'200000009','300000007','2016-02-29 13:00:00','2016-03-07 13:00:00',1),(49,'200000009','300000007','2016-06-07 10:00:00','2016-06-23 10:00:00',0),(50,'200000001','300000008','2016-01-18 13:00:00','2016-01-24 13:00:00',1),(51,'200000008','300000008','2016-03-17 14:00:00','2016-03-21 14:00:00',1),(52,'200000001','300000008','2016-06-14 16:00:00','2016-06-26 16:00:00',0),(53,'200000002','300000008','2016-02-25 11:00:00','2016-02-25 11:00:00',1),(54,'200000002','300000008','2016-06-09 09:00:00','2016-06-20 09:00:00',0),(55,'200000002','300000009','2016-04-04 00:00:00','2016-04-18 00:00:00',1),(56,'200000003','300000009','2016-04-26 10:00:00','2016-04-27 10:00:00',1),(57,'200000011','300000009','2016-01-23 11:00:00','2016-02-02 11:00:00',1),(58,'200000004','300000009','2016-06-12 14:00:00','2016-06-26 14:00:00',0),(59,'200000003','300000010','2016-02-02 11:00:00','2016-02-04 11:00:00',1),(60,'200000010','300000010','2016-06-17 14:00:00','2016-06-23 14:00:00',0),(61,'200000004','300000010','2016-02-22 11:00:00','2016-03-09 11:00:00',1),(62,'200000011','300000010','2016-01-24 15:00:00','2016-01-24 15:00:00',1),(63,'200000004','300000010','2016-05-28 16:00:00','2016-06-14 16:00:00',0),(64,'200000005','300000010','2016-03-10 15:00:00','2016-03-22 15:00:00',1),(65,'200000012','300000010','2016-02-13 13:00:00','2016-02-17 13:00:00',1),(66,'200000005','300000010','2016-06-11 09:00:00','2016-06-14 09:00:00',0),(67,'200000004','300000011','2016-02-11 13:00:00','2016-02-24 13:00:00',0),(68,'200000011','300000011','2016-05-19 15:00:00','2016-05-25 15:00:00',1),(69,'200000012','300000011','2016-02-29 10:00:00','2016-03-08 10:00:00',1),(70,'200000006','300000011','2016-02-11 11:00:00','2016-02-22 11:00:00',1),(71,'200000013','300000011','2016-04-13 15:00:00','2016-04-13 15:00:00',1),(72,'200000013','300000011','2016-06-07 11:00:00','2016-06-22 11:00:00',0),(73,'200000005','300000012','2016-01-11 00:00:00','2016-01-24 00:00:00',1),(74,'200000012','300000012','2016-03-20 13:00:00','2016-04-04 14:00:00',1),(75,'200000005','300000012','2016-06-09 00:00:00','2016-06-19 00:00:00',0),(76,'200000006','300000012','2016-05-16 14:00:00','2016-05-22 14:00:00',1),(77,'200000006','300000012','2016-06-21 09:00:00','2016-06-22 09:00:00',0),(78,'200000007','300000012','2016-04-07 15:00:00','2016-04-10 15:00:00',0),(79,'200000007','300000012','2016-05-26 00:00:00','2016-06-14 00:00:00',0),(80,'200000013','300000013','2016-01-20 09:00:00','2016-02-04 09:00:00',1),(81,'200000006','300000013','2016-06-18 00:00:00','2016-06-20 00:00:00',0),(82,'200000000','300000013','2015-12-27 00:00:00','2016-01-06 00:00:00',0),(83,'200000007','300000013','2016-04-29 14:00:00','2016-05-03 14:00:00',1),(84,'200000007','300000013','2016-05-25 16:00:00','2016-06-13 16:00:00',0),(85,'200000008','300000013','2016-05-10 14:00:00','2016-05-25 14:00:00',1),(86,'200000001','300000013','2016-06-06 16:00:00','2016-06-13 16:00:00',0),(87,'200000001','300000014','2015-12-29 10:00:00','2016-01-13 10:00:00',1),(88,'200000001','300000014','2016-06-26 00:00:00','2016-06-26 00:00:00',0),(89,'200000002','300000014','2016-01-19 00:00:00','2016-02-02 00:00:00',1),(90,'200000009','300000014','2016-01-20 10:00:00','2016-02-04 10:00:00',0),(91,'200000008','300000015','2016-01-11 15:00:00','2016-01-24 15:00:00',1),(92,'200000001','300000015','2016-06-14 15:00:00','2016-06-14 15:00:00',0),(93,'200000002','300000015','2016-01-06 10:00:00','2016-01-18 10:00:00',1),(94,'200000009','300000015','2016-02-01 09:00:00','2016-02-03 09:00:00',1),(95,'200000003','300000015','2016-01-29 00:00:00','2016-02-10 00:00:00',0),(96,'200000010','300000015','2016-03-06 11:00:00','2016-03-14 11:00:00',0),(97,'200000002','300000016','2016-01-28 13:00:00','2016-02-07 13:00:00',0),(98,'200000009','300000016','2016-06-09 11:00:00','2016-06-13 11:00:00',0),(99,'200000003','300000016','2016-02-13 00:00:00','2016-03-03 00:00:00',0),(100,'200000010','300000016','2016-03-28 00:00:00','2016-04-05 00:00:00',1),(101,'200000003','300000016','2016-05-30 13:00:00','2016-06-13 13:00:00',0),(102,'200000004','300000016','2016-02-19 14:00:00','2016-02-24 14:00:00',1),(103,'200000011','300000016','2016-04-23 15:00:00','2016-05-10 15:00:00',1),(104,'200000004','300000016','2016-06-10 00:00:00','2016-06-22 00:00:00',0),(105,'200000003','300000017','2016-04-19 13:00:00','2016-05-03 13:00:00',1),(106,'200000010','300000017','2016-05-05 11:00:00','2016-05-11 11:00:00',1),(107,'200000004','300000017','2016-04-25 15:00:00','2016-05-05 15:00:00',1),(108,'200000011','300000017','2016-03-13 15:00:00','2016-03-21 15:00:00',1),(109,'200000005','300000017','2016-03-02 00:00:00','2016-03-07 00:00:00',1),(110,'200000012','300000017','2016-04-11 09:00:00','2016-04-25 09:00:00',1),(111,'200000004','300000018','2016-05-08 15:00:00','2016-05-15 15:00:00',1),(112,'200000011','300000018','2016-06-09 13:00:00','2016-06-12 13:00:00',0),(113,'200000012','300000018','2016-02-01 00:00:00','2016-02-10 00:00:00',1),(114,'200000006','300000018','2016-04-09 10:00:00','2016-04-10 10:00:00',1),(115,'200000006','300000018','2016-06-11 09:00:00','2016-06-26 09:00:00',0),(116,'200000012','300000019','2016-05-26 10:00:00','2016-05-26 10:00:00',1),(117,'200000005','300000019','2016-06-12 15:00:00','2016-06-12 15:00:00',0),(118,'200000006','300000019','2016-05-03 15:00:00','2016-05-05 15:00:00',0),(119,'200000013','300000019','2016-04-01 15:00:00','2016-04-04 15:00:00',1),(120,'200000000','300000019','2016-04-14 13:00:00','2016-04-25 13:00:00',1),(121,'200000007','300000019','2016-02-08 16:00:00','2016-02-25 16:00:00',1),(122,'200000000','300000019','2016-06-23 13:00:00','2016-06-23 13:00:00',0);
/*!40000 ALTER TABLE `appoitments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinics`
--

DROP TABLE IF EXISTS `clinics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinics` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `hasLabratory` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinics`
--

LOCK TABLES `clinics` WRITE;
/*!40000 ALTER TABLE `clinics` DISABLE KEYS */;
INSERT INTO `clinics` VALUES (1,'GHealth King\'s Landing','King\'s Landing','ghealth_king\'s_landing0@crows.com','04-5143001',1),(2,'GHealth Winterfell','Winterfell','ghealth_winterfell1@crows.com','04-5143002',0),(3,'GHealth Iron Islands','Iron Islands','ghealth_iron_islands2@crows.com','04-5143003',1),(4,'GHealth Valyeria','Valyeria','ghealth_valyeria3@crows.com','04-5143004',0),(5,'GHealth The Wall','The Wall','ghealth_the_wall4@crows.com','04-5143005',1);
/*!40000 ALTER TABLE `clinics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmations`
--

DROP TABLE IF EXISTS `confirmations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `confirmations` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `refferal_id` varchar(255) DEFAULT NULL,
  `approval_id` varchar(255) DEFAULT NULL,
  `hmo_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmations`
--

LOCK TABLES `confirmations` WRITE;
/*!40000 ALTER TABLE `confirmations` DISABLE KEYS */;
INSERT INTO `confirmations` VALUES (1,'500','500','1000'),(2,'501','501','1000'),(3,'502','502','1000'),(4,'503','503','1001'),(5,'504','504','1001'),(6,'505','505','1001'),(7,'506','506','1002'),(8,'507','507','1002'),(9,'508','508','1002'),(10,'509','509','1003'),(11,'5010','5010','1003'),(12,'5011','5011','1003'),(13,'5012','5012','1004'),(14,'5013','5013','1004'),(15,'5014','5014','1004'),(16,'5015','5015','1005'),(17,'5016','5016','1005'),(18,'5017','5017','1005'),(19,'5018','5018','1006'),(20,'5019','5019','1006'),(21,'5020','5020','1006'),(22,'5021','5021','1007'),(23,'5022','5022','1007'),(24,'5023','5023','1007'),(25,'5024','5024','1008'),(26,'5025','5025','1008'),(27,'5026','5026','1008'),(28,'5027','5027','1009'),(29,'5028','5028','1009'),(30,'5029','5029','1009'),(31,'5030','5030','10010'),(32,'5031','5031','10010'),(33,'5032','5032','10010'),(34,'5033','5033','10011'),(35,'5034','5034','10011'),(36,'5035','5035','10011'),(37,'5036','5036','10012'),(38,'5037','5037','10012'),(39,'5038','5038','10012'),(40,'5039','5039','10013'),(41,'5040','5040','10013'),(42,'5041','5041','10013'),(43,'5042','5042','10014'),(44,'5043','5043','10014'),(45,'5044','5044','10014'),(46,'5045','5045','10015'),(47,'5046','5046','10015'),(48,'5047','5047','10015'),(49,'5048','5048','10016'),(50,'5049','5049','10016'),(51,'5050','5050','10016'),(52,'5051','5051','10017'),(53,'5052','5052','10017'),(54,'5053','5053','10017'),(55,'5054','5054','10018'),(56,'5055','5055','10018'),(57,'5056','5056','10018'),(58,'5057','5057','10019'),(59,'5058','5058','10019'),(60,'5059','5059','10019');
/*!40000 ALTER TABLE `confirmations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dispatchers`
--

DROP TABLE IF EXISTS `dispatchers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dispatchers` (
  `pass` varchar(255) DEFAULT NULL,
  `isLocked` tinyint(1) DEFAULT NULL,
  `sid` varchar(255) NOT NULL DEFAULT '',
  `lastName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispatchers`
--

LOCK TABLES `dispatchers` WRITE;
/*!40000 ALTER TABLE `dispatchers` DISABLE KEYS */;
INSERT INTO `dispatchers` VALUES ('123123',0,'500000000','Blackfrey','Cersi','1988-11-15 00:00:00','cersi.blackfrey0@crows.com','0548103004','Iron Islands, St. 0'),('123123',0,'500000001','Drogo','Yara','1981-06-19 00:00:00','yara.drogo1@crows.com','0548103005','Winterfell, St. 1'),('123123',0,'500000002','River','Ramsey','1983-09-11 00:00:00','ramsey.river2@crows.com','0548103006','King\'s Landing, St. 2');
/*!40000 ALTER TABLE `dispatchers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doctors` (
  `speciality` varchar(255) DEFAULT NULL,
  `clinic_id` int(11) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `isLocked` tinyint(1) DEFAULT NULL,
  `sid` varchar(255) NOT NULL DEFAULT '',
  `lastName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES ('Surgon',1,'123123',0,'200000000','Targeryan','Robert','1969-01-02 00:00:00','robert.targeryan0@crows.com','0548143001','King\'s Landing, St. 0'),('Oncologe',2,'123123',0,'200000001','Bolton','Mountain','1971-07-02 00:00:00','mountain.bolton1@crows.com','0548143002','The Wall, St. 1'),('Urologe',3,'123123',0,'200000002','Targeryan','John','1961-12-12 00:00:00','john.targeryan2@crows.com','0548143003','Valyeria, St. 2'),('Cardiologe',4,'123123',0,'200000003','Stark','Stannis','1978-07-12 00:00:00','stannis.stark3@crows.com','0548143004','Iron Islands, St. 3'),('Bone',5,'123123',0,'200000004','Weiss','Dyneris','1977-02-06 00:00:00','dyneris.weiss4@crows.com','0548143005','Iron Islands, St. 4'),('Family',1,'123123',0,'200000005','Frey','Ned','1963-09-14 00:00:00','ned.frey5@crows.com','0548143006','Iron Islands, St. 5'),('Children',2,'123123',0,'200000006','Martel','Stannis','1971-05-21 00:00:00','stannis.martel6@crows.com','0548143007','Winterfell, St. 6'),('Surgon',3,'123123',0,'200000007','Blackfrey','Euron','1975-02-05 00:00:00','euron.blackfrey7@crows.com','0548143008','Iron Islands, St. 7'),('Oncologe',4,'123123',0,'200000008','Karstak','Robert','1972-10-03 00:00:00','robert.karstak8@crows.com','0548143009','Iron Islands, St. 8'),('Urologe',5,'123123',0,'200000009','Snow','Dyneris','1977-12-08 00:00:00','dyneris.snow9@crows.com','0548143010','The Wall, St. 9'),('Cardiologe',1,'123123',0,'200000010','Slavador','Yara','1962-03-18 00:00:00','yara.slavador10@crows.com','0548143011','Winterfell, St. 10'),('Bone',2,'123123',0,'200000011','Frey','Mountain','1976-04-30 00:00:00','mountain.frey11@crows.com','0548143012','Iron Islands, St. 11'),('Family',3,'123123',0,'200000012','River','Robert','1974-11-16 00:00:00','robert.river12@crows.com','0548143013','The Wall, St. 12'),('Children',4,'123123',0,'200000013','Frey','Sandor','1975-07-26 00:00:00','sandor.frey13@crows.com','0548143014','Winterfell, St. 13'),('Surgon',5,'123123',0,'200000014','Bolton','Sansa','1975-08-28 00:00:00','sansa.bolton14@crows.com','0548143015','Valyeria, St. 14');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examinations`
--

DROP TABLE IF EXISTS `examinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `examinations` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `treatment_id` int(11) DEFAULT NULL,
  `labratorian_id` varchar(255) DEFAULT NULL,
  `clinic_id` int(11) DEFAULT NULL,
  `eType` varchar(255) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `examinationDate` datetime DEFAULT NULL,
  `referralDate` datetime DEFAULT NULL,
  `results` varchar(255) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examinations`
--

LOCK TABLES `examinations` WRITE;
/*!40000 ALTER TABLE `examinations` DISABLE KEYS */;
INSERT INTO `examinations` VALUES (1,1,'400000004',1,'Urine','This look good','2000-12-04 00:00:00','2000-12-01 00:00:00','good',NULL),(2,1,'400000002',2,'Urine','This look good','1991-08-09 00:00:00','1991-08-04 00:00:00','good',NULL),(3,2,'400000004',1,'Eye','This look good','2004-09-11 00:00:00','2004-09-02 00:00:00','good',NULL),(4,2,'400000000',2,'Urine','This look good','1990-07-28 00:00:00','1990-07-05 00:00:00',NULL,NULL),(5,3,'400000000',1,'Blood','This look good','2006-09-28 00:00:00','2006-09-04 00:00:00','good',NULL),(6,4,'400000000',1,'Blood','This look good','2003-03-25 00:00:00','2003-02-27 00:00:00','good',NULL),(7,6,'400000004',1,'X-Ray','This look good','1990-06-27 00:00:00','1990-05-30 00:00:00','good',NULL),(8,7,'400000000',1,'Blood','This look good','1993-10-11 00:00:00','1993-09-28 00:00:00',NULL,NULL),(9,8,'400000000',1,'ECG','This look good','1999-12-03 00:00:00','1999-12-01 00:00:00','good',NULL),(10,9,'400000000',1,'Urine','This look good','1999-03-22 00:00:00','1999-02-28 00:00:00',NULL,NULL),(11,11,'400000002',1,'CAT','This look good','2007-01-28 00:00:00','2006-12-29 00:00:00','good',NULL),(12,11,'400000004',2,'ECG','This look good','1996-06-19 00:00:00','1996-05-30 00:00:00','good',NULL),(13,12,'400000000',1,'CT','This look good','2007-03-17 00:00:00','2007-03-04 00:00:00','good',NULL),(14,13,'400000002',1,'CAT','This look good','2004-12-22 00:00:00','2004-12-02 00:00:00',NULL,NULL),(15,13,'400000000',2,'Blood','This look good','1996-06-07 00:00:00','1996-06-01 00:00:00','good',NULL),(16,15,'400000004',1,'CAT','This look good','2001-07-19 00:00:00','2001-07-01 00:00:00','good',NULL),(17,19,'400000004',1,'Urine','This look good','1995-02-26 00:00:00','1995-01-28 00:00:00','good',NULL),(18,19,'400000002',2,'X-Ray','This look good','1994-06-30 00:00:00','1994-06-03 00:00:00',NULL,NULL),(19,20,'400000004',1,'CAT','This look good','1994-02-23 00:00:00','1994-02-03 00:00:00',NULL,NULL),(20,21,'400000004',1,'CT','This look good','1990-12-26 00:00:00','1990-12-03 00:00:00','good',NULL),(21,22,'400000000',1,'CAT','This look good','1995-03-28 00:00:00','1995-02-28 00:00:00','good',NULL),(22,25,'400000004',1,'Eye','This look good','1995-06-06 00:00:00','1995-05-31 00:00:00',NULL,NULL),(23,26,'400000004',1,'CT','This look good','1993-04-06 00:00:00','1993-03-30 00:00:00','good',NULL),(24,27,'400000000',1,'CT','This look good','1998-04-11 00:00:00','1998-04-04 00:00:00',NULL,NULL),(25,28,'400000002',1,'Eye','This look good','1996-04-28 00:00:00','1996-03-30 00:00:00','good',NULL),(26,30,'400000002',1,'Eye','This look good','1994-03-23 00:00:00','1994-03-01 00:00:00',NULL,NULL),(27,31,'400000004',1,'CT','This look good','2008-10-15 00:00:00','2008-10-02 00:00:00','good',NULL),(28,31,'400000000',2,'Urine','This look good','1996-09-24 00:00:00','1996-09-01 00:00:00','good',NULL),(29,33,'400000002',1,'Eye','This look good','2000-04-15 00:00:00','2000-04-02 00:00:00','good',NULL),(30,35,'400000000',1,'X-Ray','This look good','1995-03-14 00:00:00','1995-02-28 00:00:00','good',NULL),(31,36,'400000002',1,'ECG','This look good','2004-07-16 00:00:00','2004-07-01 00:00:00','good',NULL),(32,36,'400000002',2,'CAT','This look good','2004-03-13 00:00:00','2004-03-04 00:00:00','good',NULL),(33,37,'400000000',1,'Urine','This look good','1998-08-23 00:00:00','1998-07-29 00:00:00',NULL,NULL),(34,37,'400000004',2,'X-Ray','This look good','1992-04-28 00:00:00','1992-03-31 00:00:00','good',NULL),(35,38,'400000000',1,'Eye','This look good','1992-07-24 00:00:00','1992-07-01 00:00:00',NULL,NULL),(36,40,'400000000',1,'CAT','This look good','1995-07-21 00:00:00','1995-07-02 00:00:00','good',NULL),(37,41,'400000004',1,'Urine','This look good','2003-03-26 00:00:00','2003-03-02 00:00:00','good',NULL),(38,42,'400000002',1,'Urine','This look good','2004-04-19 00:00:00','2004-04-01 00:00:00',NULL,NULL),(39,42,'400000000',2,'Urine','This look good','1992-12-31 00:00:00','1992-12-02 00:00:00','good',NULL),(40,46,'400000000',1,'Blood','This look good','1997-07-13 00:00:00','1997-06-26 00:00:00',NULL,NULL),(41,46,'400000004',2,'Blood','This look good','1999-04-27 00:00:00','1999-03-31 00:00:00',NULL,NULL),(42,49,'400000002',1,'CT','This look good','1994-06-09 00:00:00','1994-06-02 00:00:00','good',NULL),(43,49,'400000004',2,'CAT','This look good','2005-05-28 00:00:00','2005-05-04 00:00:00','good',NULL),(44,50,'400000000',1,'X-Ray','This look good','2002-05-02 00:00:00','2002-05-03 00:00:00','good',NULL),(45,52,'400000004',1,'Blood','This look good','1996-07-19 00:00:00','1996-07-02 00:00:00',NULL,NULL),(46,52,'400000002',2,'CAT','This look good','2003-04-24 00:00:00','2003-04-01 00:00:00',NULL,NULL),(47,53,'400000004',1,'Eye','This look good','2004-06-26 00:00:00','2004-06-05 00:00:00',NULL,NULL),(48,54,'400000002',1,'Urine','This look good','2005-09-02 00:00:00','2005-09-04 00:00:00',NULL,NULL),(49,55,'400000002',1,'CT','This look good','1998-01-26 00:00:00','1998-01-01 00:00:00',NULL,NULL),(50,57,'400000004',1,'ECG','This look good','1995-03-06 00:00:00','1995-02-27 00:00:00',NULL,NULL),(51,60,'400000004',1,'Urine','This look good','2009-05-28 00:00:00','2009-05-01 00:00:00','good',NULL);
/*!40000 ALTER TABLE `examinations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `labratorians`
--

DROP TABLE IF EXISTS `labratorians`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `labratorians` (
  `clinic_id` int(11) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `isLocked` tinyint(1) DEFAULT NULL,
  `sid` varchar(255) NOT NULL DEFAULT '',
  `lastName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `labratorians`
--

LOCK TABLES `labratorians` WRITE;
/*!40000 ALTER TABLE `labratorians` DISABLE KEYS */;
INSERT INTO `labratorians` VALUES (1,'123123',0,'400000000','Lanister','Varys','1981-05-24 00:00:00','varys.lanister0@crows.com','0548143001','Valyeria, St. 0'),(3,'123123',0,'400000002','Frey','Walder','1982-03-07 00:00:00','walder.frey2@crows.com','0548143003','Iron Islands, St. 2'),(5,'123123',0,'400000004','Mormont','Mountain','1980-11-18 00:00:00','mountain.mormont4@crows.com','0548143005','King\'s Landing, St. 4');
/*!40000 ALTER TABLE `labratorians` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managers`
--

DROP TABLE IF EXISTS `managers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `managers` (
  `isCeo` tinyint(1) DEFAULT NULL,
  `clinic_id` int(11) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `isLocked` tinyint(1) DEFAULT NULL,
  `sid` varchar(255) NOT NULL DEFAULT '',
  `lastName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managers`
--

LOCK TABLES `managers` WRITE;
/*!40000 ALTER TABLE `managers` DISABLE KEYS */;
INSERT INTO `managers` VALUES (1,1,'123123',0,'600000000','Targeryan','Renly','1978-09-08 00:00:00','renly.targeryan0@crows.com','0548143001','Winterfell, St. 0'),(0,2,'123123',0,'600000001','Baratheon','Roose','1976-10-12 00:00:00','roose.baratheon1@crows.com','0548143002','The Wall, St. 1'),(0,3,'123123',0,'600000002','Greyjoy','Tyrion','1960-09-19 00:00:00','tyrion.greyjoy2@crows.com','0548143003','King\'s Landing, St. 2'),(0,4,'123123',0,'600000003','Weiss','Ramsey','1970-01-01 00:00:00','ramsey.weiss3@crows.com','0548143004','Iron Islands, St. 3'),(0,5,'123123',0,'600000004','Martel','Robert','1963-09-13 00:00:00','robert.martel4@crows.com','0548143005','Winterfell, St. 4');
/*!40000 ALTER TABLE `managers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_records`
--

DROP TABLE IF EXISTS `medical_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medical_records` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(255) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_records`
--

LOCK TABLES `medical_records` WRITE;
/*!40000 ALTER TABLE `medical_records` DISABLE KEYS */;
INSERT INTO `medical_records` VALUES (1,'300000000','2003-04-14 00:00:00'),(2,'300000001','1996-07-15 00:00:00'),(3,'300000002','2007-12-01 00:00:00'),(4,'300000003','1991-03-16 00:00:00'),(5,'300000004','2000-08-12 00:00:00'),(6,'300000005','1993-08-06 00:00:00'),(7,'300000006','2002-03-01 00:00:00'),(8,'300000007','2009-04-03 00:00:00'),(9,'300000008','2003-10-27 00:00:00'),(10,'300000009','2003-10-25 00:00:00'),(11,'300000010','1998-09-04 00:00:00'),(12,'300000011','2007-12-28 00:00:00'),(13,'300000012','1993-04-05 00:00:00'),(14,'300000013','1998-10-19 00:00:00'),(15,'300000014','2008-01-25 00:00:00'),(16,'300000015','1991-08-27 00:00:00'),(17,'300000016','2001-08-27 00:00:00'),(18,'300000017','2006-08-21 00:00:00'),(19,'300000018','2004-05-24 00:00:00'),(20,'300000019','1997-08-15 00:00:00');
/*!40000 ALTER TABLE `medical_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patients` (
  `weight` float DEFAULT NULL,
  `height` float DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `leavingTime` datetime DEFAULT NULL,
  `medical_id` int(11) DEFAULT NULL,
  `sid` varchar(255) NOT NULL DEFAULT '',
  `lastName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (95,175,'male',NULL,1,'300000000','Lanister','Euron','1989-11-02 00:00:00','euron.lanister0@crows.com','0548143001','Valyeria, St. 0'),(95,175,'male',NULL,2,'300000001','Martel','Varys','1973-11-26 00:00:00','varys.martel1@crows.com','0548143002','Valyeria, St. 1'),(95,175,'male',NULL,3,'300000002','Snow','Cersi','1979-01-27 00:00:00','cersi.snow2@crows.com','0548143003','Winterfell, St. 2'),(95,175,'male',NULL,4,'300000003','Lanister','Stannis','1987-09-08 00:00:00','stannis.lanister3@crows.com','0548143004','Valyeria, St. 3'),(95,175,'male',NULL,5,'300000004','Martel','Sansa','1971-03-14 00:00:00','sansa.martel4@crows.com','0548143005','Winterfell, St. 4'),(95,175,'male',NULL,6,'300000005','Weiss','Tyrion','1970-10-24 00:00:00','tyrion.weiss5@crows.com','0548143006','Valyeria, St. 5'),(95,175,'male',NULL,7,'300000006','Weiss','Walder','1985-05-11 00:00:00','walder.weiss6@crows.com','0548143007','Valyeria, St. 6'),(95,175,'male',NULL,8,'300000007','Lanister','Arya','1975-12-27 00:00:00','arya.lanister7@crows.com','0548143008','Winterfell, St. 7'),(95,175,'male',NULL,9,'300000008','Lanister','Tyrion','1987-10-24 00:00:00','tyrion.lanister8@crows.com','0548143009','King\'s Landing, St. 8'),(95,175,'male',NULL,10,'300000009','Drogo','Sansa','1978-01-14 00:00:00','sansa.drogo9@crows.com','0548143010','The Wall, St. 9'),(95,175,'male',NULL,11,'300000010','Drogo','Roose','1980-06-02 00:00:00','roose.drogo10@crows.com','0548143011','Winterfell, St. 10'),(95,175,'male',NULL,12,'300000011','Slavador','Stannis','1980-01-09 00:00:00','stannis.slavador11@crows.com','0548143012','Winterfell, St. 11'),(95,175,'male',NULL,13,'300000012','Clegane','Cersi','1970-04-21 00:00:00','cersi.clegane12@crows.com','0548143013','King\'s Landing, St. 12'),(95,175,'male',NULL,14,'300000013','Turlly','Varys','1979-02-22 00:00:00','varys.turlly13@crows.com','0548143014','Valyeria, St. 13'),(95,175,'male',NULL,15,'300000014','Turlly','Ned','1977-09-30 00:00:00','ned.turlly14@crows.com','0548143015','The Wall, St. 14'),(95,175,'male',NULL,16,'300000015','Slavador','Sandor','1979-11-01 00:00:00','sandor.slavador15@crows.com','0548143016','Valyeria, St. 15'),(95,175,'male',NULL,17,'300000016','Karstak','Jaime','1976-08-16 00:00:00','jaime.karstak16@crows.com','0548143017','Iron Islands, St. 16'),(95,175,'male',NULL,18,'300000017','Baratheon','Mountain','1979-06-22 00:00:00','mountain.baratheon17@crows.com','0548143018','Iron Islands, St. 17'),(95,175,'male',NULL,19,'300000018','Turlly','Walder','1985-02-14 00:00:00','walder.turlly18@crows.com','0548143019','Winterfell, St. 18'),(95,175,'male',NULL,20,'300000019','Martel','John','1983-06-10 00:00:00','john.martel19@crows.com','0548143020','The Wall, St. 19');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `referrals`
--

DROP TABLE IF EXISTS `referrals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referrals` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` varchar(255) DEFAULT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `speciality` varchar(255) DEFAULT NULL,
  `confirm_id` int(11) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `referrals`
--

LOCK TABLES `referrals` WRITE;
/*!40000 ALTER TABLE `referrals` DISABLE KEYS */;
INSERT INTO `referrals` VALUES (1,'300000000','ahmad','2016-06-13 00:00:00',NULL,'Surgon',1,1),(2,'300000000','bolous','2007-04-05 00:00:00',NULL,'Oncologe',2,1),(3,'300000000','Muhmmad','2016-06-13 00:00:00',NULL,'Urologe',3,1),(4,'300000001','ahmad','2016-06-13 00:00:00',NULL,'Oncologe',4,1),(5,'300000001','bolous','2008-06-22 00:00:00',NULL,'Urologe',5,1),(6,'300000001','Muhmmad','2016-06-13 00:00:00',NULL,'Cardiologe',6,1),(7,'300000002','ahmad','2016-06-13 00:00:00',NULL,'Urologe',7,1),(8,'300000002','bolous','2007-06-28 00:00:00',NULL,'Cardiologe',8,1),(9,'300000002','Muhmmad','2016-06-13 00:00:00',NULL,'Bone',9,1),(10,'300000003','ahmad','2016-06-13 00:00:00',NULL,'Cardiologe',10,1),(11,'300000003','bolous','1993-03-31 00:00:00',NULL,'Bone',11,1),(12,'300000003','Muhmmad','2016-06-13 00:00:00',NULL,'Family',12,1),(13,'300000004','ahmad','2016-06-13 00:00:00',NULL,'Bone',13,1),(14,'300000004','bolous','2001-08-25 00:00:00',NULL,'Family',14,1),(15,'300000004','Muhmmad','2016-06-13 00:00:00',NULL,'Children',15,1),(16,'300000005','ahmad','2016-06-13 00:00:00',NULL,'Family',16,1),(17,'300000005','bolous','2003-12-11 00:00:00',NULL,'Children',17,1),(18,'300000005','Muhmmad','2016-06-13 00:00:00',NULL,'Surgon',18,1),(19,'300000006','ahmad','2016-06-13 00:00:00',NULL,'Children',19,1),(20,'300000006','bolous','2008-01-14 00:00:00',NULL,'Surgon',20,1),(21,'300000006','Muhmmad','2016-06-13 00:00:00',NULL,'Oncologe',21,1),(22,'300000007','ahmad','2016-06-13 00:00:00',NULL,'Surgon',22,1),(23,'300000007','bolous','2004-09-26 00:00:00',NULL,'Oncologe',23,1),(24,'300000007','Muhmmad','2016-06-13 00:00:00',NULL,'Urologe',24,1),(25,'300000008','ahmad','2016-06-13 00:00:00',NULL,'Oncologe',25,1),(26,'300000008','bolous','1996-04-04 00:00:00',NULL,'Urologe',26,1),(27,'300000008','Muhmmad','2016-06-13 00:00:00',NULL,'Cardiologe',27,1),(28,'300000009','ahmad','2016-06-13 00:00:00',NULL,'Urologe',28,1),(29,'300000009','bolous','1995-07-18 00:00:00',NULL,'Cardiologe',29,1),(30,'300000009','Muhmmad','2016-06-13 00:00:00',NULL,'Bone',30,1),(31,'300000010','ahmad','2016-06-13 00:00:00',NULL,'Cardiologe',31,1),(32,'300000010','bolous','2002-02-19 00:00:00',NULL,'Bone',32,1),(33,'300000010','Muhmmad','2016-06-13 00:00:00',NULL,'Family',33,1),(34,'300000011','ahmad','2016-06-13 00:00:00',NULL,'Bone',34,1),(35,'300000011','bolous','1997-01-26 00:00:00',NULL,'Family',35,1),(36,'300000011','Muhmmad','2016-06-13 00:00:00',NULL,'Children',36,1),(37,'300000012','ahmad','2016-06-13 00:00:00',NULL,'Family',37,1),(38,'300000012','bolous','1995-10-23 00:00:00',NULL,'Children',38,1),(39,'300000012','Muhmmad','2016-06-13 00:00:00',NULL,'Surgon',39,1),(40,'300000013','ahmad','2016-06-13 00:00:00',NULL,'Children',40,1),(41,'300000013','bolous','2005-05-25 00:00:00',NULL,'Surgon',41,1),(42,'300000013','Muhmmad','2016-06-13 00:00:00',NULL,'Oncologe',42,1),(43,'300000014','ahmad','2016-06-13 00:00:00',NULL,'Surgon',43,1),(44,'300000014','bolous','2006-02-25 00:00:00',NULL,'Oncologe',44,1),(45,'300000014','Muhmmad','2016-06-13 00:00:00',NULL,'Urologe',45,1),(46,'300000015','ahmad','2016-06-13 00:00:00',NULL,'Oncologe',46,1),(47,'300000015','bolous','2005-03-09 00:00:00',NULL,'Urologe',47,1),(48,'300000015','Muhmmad','2016-06-13 00:00:00',NULL,'Cardiologe',48,1),(49,'300000016','ahmad','2016-06-13 00:00:00',NULL,'Urologe',49,1),(50,'300000016','bolous','1996-10-01 00:00:00',NULL,'Cardiologe',50,1),(51,'300000016','Muhmmad','2016-06-13 00:00:00',NULL,'Bone',51,1),(52,'300000017','ahmad','2016-06-13 00:00:00',NULL,'Cardiologe',52,1),(53,'300000017','bolous','1993-08-23 00:00:00',NULL,'Bone',53,1),(54,'300000017','Muhmmad','2016-06-13 00:00:00',NULL,'Family',54,1),(55,'300000018','ahmad','2016-06-13 00:00:00',NULL,'Bone',55,1),(56,'300000018','bolous','1993-05-09 00:00:00',NULL,'Family',56,1),(57,'300000018','Muhmmad','2016-06-13 00:00:00',NULL,'Children',57,1),(58,'300000019','ahmad','2016-06-13 00:00:00',NULL,'Family',58,1),(59,'300000019','bolous','1992-05-20 00:00:00',NULL,'Children',59,1),(60,'300000019','Muhmmad','2016-06-13 00:00:00',NULL,'Surgon',60,1);
/*!40000 ALTER TABLE `referrals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretaries`
--

DROP TABLE IF EXISTS `secretaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretaries` (
  `clinic_id` int(11) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `isLocked` tinyint(1) DEFAULT NULL,
  `sid` varchar(255) NOT NULL DEFAULT '',
  `lastName` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `birthDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretaries`
--

LOCK TABLES `secretaries` WRITE;
/*!40000 ALTER TABLE `secretaries` DISABLE KEYS */;
INSERT INTO `secretaries` VALUES (1,'123123',0,'400000010','Frey','Renly','1985-03-07 00:00:00','renly.frey0@crows.com','0548143001','The Wall, St. 0'),(2,'123123',0,'400000011','Slavador','Dyneris','1998-11-08 00:00:00','dyneris.slavador1@crows.com','0548143002','The Wall, St. 1'),(3,'123123',0,'400000012','Martel','Stannis','1984-08-24 00:00:00','stannis.martel2@crows.com','0548143003','King\'s Landing, St. 2'),(4,'123123',0,'400000013','Targeryan','Sansa','1989-04-14 00:00:00','sansa.targeryan3@crows.com','0548143004','Iron Islands, St. 3'),(5,'123123',0,'400000014','Greyjoy','Sandor','1983-01-10 00:00:00','sandor.greyjoy4@crows.com','0548143005','The Wall, St. 4');
/*!40000 ALTER TABLE `secretaries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shifts`
--

DROP TABLE IF EXISTS `shifts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shifts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `doctor_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `startDate` (`startDate`,`endDate`,`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shifts`
--

LOCK TABLES `shifts` WRITE;
/*!40000 ALTER TABLE `shifts` DISABLE KEYS */;
INSERT INTO `shifts` VALUES (1,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000000'),(10,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000001'),(19,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000002'),(28,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000003'),(37,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000004'),(46,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000005'),(55,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000006'),(64,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000007'),(73,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000008'),(82,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000009'),(91,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000010'),(100,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000011'),(109,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000012'),(118,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000013'),(127,'2016-06-13 09:00:00','2016-06-13 17:00:00','200000014'),(2,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000000'),(11,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000001'),(20,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000002'),(29,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000003'),(38,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000004'),(47,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000005'),(56,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000006'),(65,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000007'),(74,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000008'),(83,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000009'),(92,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000010'),(101,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000011'),(110,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000012'),(119,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000013'),(128,'2016-06-14 09:00:00','2016-06-14 17:00:00','200000014'),(3,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000000'),(12,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000001'),(21,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000002'),(30,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000003'),(39,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000004'),(48,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000005'),(57,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000006'),(66,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000007'),(75,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000008'),(84,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000009'),(93,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000010'),(102,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000011'),(111,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000012'),(120,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000013'),(129,'2016-06-15 09:00:00','2016-06-15 17:00:00','200000014'),(4,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000000'),(13,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000001'),(22,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000002'),(31,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000003'),(40,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000004'),(49,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000005'),(58,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000006'),(67,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000007'),(76,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000008'),(85,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000009'),(94,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000010'),(103,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000011'),(112,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000012'),(121,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000013'),(130,'2016-06-16 09:00:00','2016-06-16 17:00:00','200000014'),(5,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000000'),(14,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000001'),(23,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000002'),(32,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000003'),(41,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000004'),(50,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000005'),(59,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000006'),(68,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000007'),(77,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000008'),(86,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000009'),(95,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000010'),(104,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000011'),(113,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000012'),(122,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000013'),(131,'2016-06-19 09:00:00','2016-06-19 17:00:00','200000014'),(6,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000000'),(15,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000001'),(24,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000002'),(33,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000003'),(42,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000004'),(51,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000005'),(60,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000006'),(69,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000007'),(78,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000008'),(87,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000009'),(96,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000010'),(105,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000011'),(114,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000012'),(123,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000013'),(132,'2016-06-20 09:00:00','2016-06-20 17:00:00','200000014'),(7,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000000'),(16,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000001'),(25,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000002'),(34,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000003'),(43,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000004'),(52,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000005'),(61,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000006'),(70,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000007'),(79,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000008'),(88,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000009'),(97,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000010'),(106,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000011'),(115,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000012'),(124,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000013'),(133,'2016-06-21 09:00:00','2016-06-21 17:00:00','200000014'),(8,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000000'),(17,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000001'),(26,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000002'),(35,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000003'),(44,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000004'),(53,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000005'),(62,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000006'),(71,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000007'),(80,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000008'),(89,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000009'),(98,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000010'),(107,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000011'),(116,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000012'),(125,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000013'),(134,'2016-06-22 09:00:00','2016-06-22 17:00:00','200000014'),(9,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000000'),(18,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000001'),(27,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000002'),(36,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000003'),(45,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000004'),(54,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000005'),(63,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000006'),(72,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000007'),(81,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000008'),(90,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000009'),(99,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000010'),(108,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000011'),(117,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000012'),(126,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000013'),(135,'2016-06-23 09:00:00','2016-06-23 17:00:00','200000014');
/*!40000 ALTER TABLE `shifts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statistics`
--

DROP TABLE IF EXISTS `statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `numOfPatients` int(11) DEFAULT NULL,
  `waitingPeriod` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=361 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statistics`
--

LOCK TABLES `statistics` WRITE;
/*!40000 ALTER TABLE `statistics` DISABLE KEYS */;
INSERT INTO `statistics` VALUES (1,'2016-01-02 00:00:00',20,18),(2,'2016-01-03 00:00:00',25,3),(3,'2016-01-04 00:00:00',13,17),(4,'2016-01-05 00:00:00',16,31),(5,'2016-01-06 00:00:00',9,55),(6,'2016-01-07 00:00:00',20,40),(7,'2016-01-08 00:00:00',26,40),(8,'2016-01-09 00:00:00',20,32),(9,'2016-01-10 00:00:00',25,46),(10,'2016-01-11 00:00:00',28,12),(11,'2016-01-12 00:00:00',17,8),(12,'2016-01-13 00:00:00',5,41),(13,'2016-01-14 00:00:00',27,28),(14,'2016-01-15 00:00:00',5,1),(15,'2016-01-16 00:00:00',13,54),(16,'2016-01-17 00:00:00',2,23),(17,'2016-01-18 00:00:00',10,51),(18,'2016-01-19 00:00:00',9,15),(19,'2016-01-20 00:00:00',3,10),(20,'2016-01-21 00:00:00',15,51),(21,'2016-01-22 00:00:00',9,44),(22,'2016-01-23 00:00:00',16,7),(23,'2016-01-24 00:00:00',23,31),(24,'2016-01-25 00:00:00',9,28),(25,'2016-01-26 00:00:00',2,45),(26,'2016-01-27 00:00:00',10,0),(27,'2016-01-28 00:00:00',1,59),(28,'2016-01-29 00:00:00',17,21),(29,'2016-01-30 00:00:00',14,46),(30,'2016-01-31 00:00:00',28,5),(31,'2016-02-01 00:00:00',24,33),(32,'2016-02-02 00:00:00',27,46),(33,'2016-02-03 00:00:00',23,53),(34,'2016-02-04 00:00:00',1,31),(35,'2016-02-05 00:00:00',15,54),(36,'2016-02-06 00:00:00',17,0),(37,'2016-02-07 00:00:00',0,12),(38,'2016-02-08 00:00:00',27,18),(39,'2016-02-09 00:00:00',23,43),(40,'2016-02-10 00:00:00',4,3),(41,'2016-02-11 00:00:00',18,23),(42,'2016-02-12 00:00:00',22,29),(43,'2016-02-13 00:00:00',26,19),(44,'2016-02-14 00:00:00',4,9),(45,'2016-02-15 00:00:00',19,52),(46,'2016-02-16 00:00:00',11,20),(47,'2016-02-17 00:00:00',28,19),(48,'2016-02-18 00:00:00',23,50),(49,'2016-02-19 00:00:00',21,5),(50,'2016-02-20 00:00:00',27,27),(51,'2016-02-21 00:00:00',19,3),(52,'2016-02-22 00:00:00',5,27),(53,'2016-02-23 00:00:00',17,18),(54,'2016-02-24 00:00:00',2,54),(55,'2016-02-25 00:00:00',5,31),(56,'2016-02-26 00:00:00',28,9),(57,'2016-02-27 00:00:00',29,1),(58,'2016-02-28 00:00:00',19,12),(59,'2016-02-29 00:00:00',1,25),(60,'2016-03-01 00:00:00',6,13),(61,'2016-03-02 00:00:00',8,35),(62,'2016-03-03 00:00:00',23,34),(63,'2016-03-04 00:00:00',18,31),(64,'2016-03-05 00:00:00',6,55),(65,'2016-03-06 00:00:00',11,22),(66,'2016-03-07 00:00:00',18,35),(67,'2016-03-08 00:00:00',8,44),(68,'2016-03-09 00:00:00',12,37),(69,'2016-03-10 00:00:00',2,14),(70,'2016-03-11 00:00:00',25,54),(71,'2016-03-12 00:00:00',26,49),(72,'2016-03-13 00:00:00',6,50),(73,'2016-03-14 00:00:00',10,22),(74,'2016-03-15 00:00:00',23,9),(75,'2016-03-16 00:00:00',25,57),(76,'2016-03-17 00:00:00',3,33),(77,'2016-03-18 00:00:00',5,18),(78,'2016-03-19 00:00:00',2,26),(79,'2016-03-20 00:00:00',20,43),(80,'2016-03-21 00:00:00',22,29),(81,'2016-03-22 00:00:00',26,28),(82,'2016-03-23 00:00:00',9,10),(83,'2016-03-24 00:00:00',18,56),(84,'2016-03-25 00:00:00',12,52),(85,'2016-03-26 01:00:00',20,1),(86,'2016-03-27 01:00:00',2,27),(87,'2016-03-28 01:00:00',22,52),(88,'2016-03-29 01:00:00',0,39),(89,'2016-03-30 01:00:00',3,2),(90,'2016-03-31 01:00:00',21,7),(91,'2016-04-01 01:00:00',29,7),(92,'2016-04-02 01:00:00',15,37),(93,'2016-04-03 01:00:00',16,6),(94,'2016-04-04 01:00:00',16,33),(95,'2016-04-05 01:00:00',21,58),(96,'2016-04-06 01:00:00',10,13),(97,'2016-04-07 01:00:00',28,56),(98,'2016-04-08 01:00:00',22,36),(99,'2016-04-09 01:00:00',6,44),(100,'2016-04-10 01:00:00',12,26),(101,'2016-04-11 01:00:00',10,31),(102,'2016-04-12 01:00:00',20,21),(103,'2016-04-13 01:00:00',21,55),(104,'2016-04-14 01:00:00',22,46),(105,'2016-04-15 01:00:00',8,19),(106,'2016-04-16 01:00:00',2,7),(107,'2016-04-17 01:00:00',10,27),(108,'2016-04-18 01:00:00',4,58),(109,'2016-04-19 01:00:00',8,18),(110,'2016-04-20 01:00:00',27,46),(111,'2016-04-21 01:00:00',26,55),(112,'2016-04-22 01:00:00',11,33),(113,'2016-04-23 01:00:00',6,17),(114,'2016-04-24 01:00:00',16,39),(115,'2016-04-25 01:00:00',9,33),(116,'2016-04-26 01:00:00',16,10),(117,'2016-04-27 01:00:00',18,18),(118,'2016-04-28 01:00:00',20,11),(119,'2016-04-29 01:00:00',12,28),(120,'2016-04-30 01:00:00',7,5),(121,'2016-05-01 01:00:00',2,2),(122,'2016-05-02 01:00:00',24,53),(123,'2016-05-03 01:00:00',21,37),(124,'2016-05-04 01:00:00',12,26),(125,'2016-05-05 01:00:00',22,30),(126,'2016-05-06 01:00:00',17,7),(127,'2016-05-07 01:00:00',22,19),(128,'2016-05-08 01:00:00',29,51),(129,'2016-05-09 01:00:00',3,28),(130,'2016-05-10 01:00:00',27,5),(131,'2016-05-11 01:00:00',16,53),(132,'2016-05-12 01:00:00',18,36),(133,'2016-05-13 01:00:00',2,12),(134,'2016-05-14 01:00:00',4,7),(135,'2016-05-15 01:00:00',22,17),(136,'2016-05-16 01:00:00',13,43),(137,'2016-05-17 01:00:00',7,1),(138,'2016-05-18 01:00:00',19,21),(139,'2016-05-19 01:00:00',9,8),(140,'2016-05-20 01:00:00',18,19),(141,'2016-05-21 01:00:00',5,15),(142,'2016-05-22 01:00:00',2,2),(143,'2016-05-23 01:00:00',26,19),(144,'2016-05-24 01:00:00',22,34),(145,'2016-05-25 01:00:00',11,52),(146,'2016-05-26 01:00:00',6,7),(147,'2016-05-27 01:00:00',14,41),(148,'2016-05-28 01:00:00',2,5),(149,'2016-05-29 01:00:00',18,25),(150,'2016-05-30 01:00:00',26,50),(151,'2016-05-31 01:00:00',24,39),(152,'2016-06-01 01:00:00',4,20),(153,'2016-06-02 01:00:00',8,43),(154,'2016-06-03 01:00:00',16,50),(155,'2016-06-04 01:00:00',16,14),(156,'2016-06-05 01:00:00',22,16),(157,'2016-06-06 01:00:00',6,12),(158,'2016-06-07 01:00:00',9,47),(159,'2016-06-08 01:00:00',19,1),(160,'2016-06-09 01:00:00',27,50),(161,'2016-06-10 01:00:00',20,45),(162,'2016-06-11 01:00:00',7,12),(163,'2016-06-12 01:00:00',18,9),(164,'2016-06-13 01:00:00',9,27),(165,'2016-06-14 01:00:00',2,0),(166,'2016-06-15 01:00:00',5,7),(167,'2016-06-16 01:00:00',16,10),(168,'2016-06-17 01:00:00',9,16),(169,'2016-06-18 01:00:00',15,17),(170,'2016-06-19 01:00:00',14,36),(171,'2016-06-20 01:00:00',7,57),(172,'2016-06-21 01:00:00',26,45),(173,'2016-06-22 01:00:00',1,22),(174,'2016-06-23 01:00:00',7,11),(175,'2016-06-24 01:00:00',0,54),(176,'2016-06-25 01:00:00',25,19),(177,'2016-06-26 01:00:00',8,52),(178,'2016-06-27 01:00:00',17,37),(179,'2016-06-28 01:00:00',7,57),(180,'2016-06-29 01:00:00',24,44),(181,'2016-06-30 01:00:00',13,21),(182,'2016-07-01 01:00:00',18,28),(183,'2016-07-02 01:00:00',13,42),(184,'2016-07-03 01:00:00',5,19),(185,'2016-07-04 01:00:00',26,6),(186,'2016-07-05 01:00:00',1,53),(187,'2016-07-06 01:00:00',22,11),(188,'2016-07-07 01:00:00',25,14),(189,'2016-07-08 01:00:00',10,28),(190,'2016-07-09 01:00:00',6,26),(191,'2016-07-10 01:00:00',12,2),(192,'2016-07-11 01:00:00',16,50),(193,'2016-07-12 01:00:00',23,8),(194,'2016-07-13 01:00:00',21,58),(195,'2016-07-14 01:00:00',2,5),(196,'2016-07-15 01:00:00',13,55),(197,'2016-07-16 01:00:00',16,49),(198,'2016-07-17 01:00:00',12,33),(199,'2016-07-18 01:00:00',5,7),(200,'2016-07-19 01:00:00',12,21),(201,'2016-07-20 01:00:00',11,22),(202,'2016-07-21 01:00:00',12,7),(203,'2016-07-22 01:00:00',18,58),(204,'2016-07-23 01:00:00',15,52),(205,'2016-07-24 01:00:00',19,50),(206,'2016-07-25 01:00:00',24,20),(207,'2016-07-26 01:00:00',28,1),(208,'2016-07-27 01:00:00',14,29),(209,'2016-07-28 01:00:00',19,14),(210,'2016-07-29 01:00:00',15,42),(211,'2016-07-30 01:00:00',2,17),(212,'2016-07-31 01:00:00',19,28),(213,'2016-08-01 01:00:00',5,35),(214,'2016-08-02 01:00:00',25,32),(215,'2016-08-03 01:00:00',3,29),(216,'2016-08-04 01:00:00',24,11),(217,'2016-08-05 01:00:00',20,30),(218,'2016-08-06 01:00:00',10,22),(219,'2016-08-07 01:00:00',27,23),(220,'2016-08-08 01:00:00',28,57),(221,'2016-08-09 01:00:00',9,9),(222,'2016-08-10 01:00:00',7,32),(223,'2016-08-11 01:00:00',5,26),(224,'2016-08-12 01:00:00',21,50),(225,'2016-08-13 01:00:00',16,9),(226,'2016-08-14 01:00:00',22,22),(227,'2016-08-15 01:00:00',16,32),(228,'2016-08-16 01:00:00',28,11),(229,'2016-08-17 01:00:00',27,11),(230,'2016-08-18 01:00:00',17,3),(231,'2016-08-19 01:00:00',17,40),(232,'2016-08-20 01:00:00',26,40),(233,'2016-08-21 01:00:00',5,1),(234,'2016-08-22 01:00:00',1,20),(235,'2016-08-23 01:00:00',20,2),(236,'2016-08-24 01:00:00',23,7),(237,'2016-08-25 01:00:00',17,12),(238,'2016-08-26 01:00:00',21,31),(239,'2016-08-27 01:00:00',8,3),(240,'2016-08-28 01:00:00',14,12),(241,'2016-08-29 01:00:00',22,37),(242,'2016-08-30 01:00:00',12,26),(243,'2016-08-31 01:00:00',19,20),(244,'2016-09-01 01:00:00',24,0),(245,'2016-09-02 01:00:00',13,50),(246,'2016-09-03 01:00:00',15,27),(247,'2016-09-04 01:00:00',16,43),(248,'2016-09-05 01:00:00',9,12),(249,'2016-09-06 01:00:00',25,24),(250,'2016-09-07 01:00:00',27,7),(251,'2016-09-08 01:00:00',2,47),(252,'2016-09-09 01:00:00',3,17),(253,'2016-09-10 01:00:00',1,20),(254,'2016-09-11 01:00:00',18,12),(255,'2016-09-12 01:00:00',10,19),(256,'2016-09-13 01:00:00',4,15),(257,'2016-09-14 01:00:00',7,59),(258,'2016-09-15 01:00:00',23,13),(259,'2016-09-16 01:00:00',13,23),(260,'2016-09-17 01:00:00',2,59),(261,'2016-09-18 01:00:00',23,36),(262,'2016-09-19 01:00:00',24,43),(263,'2016-09-20 01:00:00',21,4),(264,'2016-09-21 01:00:00',1,15),(265,'2016-09-22 01:00:00',16,50),(266,'2016-09-23 01:00:00',3,47),(267,'2016-09-24 01:00:00',28,42),(268,'2016-09-25 01:00:00',5,55),(269,'2016-09-26 01:00:00',22,24),(270,'2016-09-27 01:00:00',29,57),(271,'2016-09-28 01:00:00',0,1),(272,'2016-09-29 01:00:00',23,51),(273,'2016-09-30 01:00:00',2,7),(274,'2016-10-01 01:00:00',26,36),(275,'2016-10-02 01:00:00',21,51),(276,'2016-10-03 01:00:00',22,45),(277,'2016-10-04 01:00:00',28,52),(278,'2016-10-05 01:00:00',19,0),(279,'2016-10-06 01:00:00',9,57),(280,'2016-10-07 01:00:00',4,45),(281,'2016-10-08 01:00:00',19,23),(282,'2016-10-09 01:00:00',2,18),(283,'2016-10-10 01:00:00',17,7),(284,'2016-10-11 01:00:00',6,41),(285,'2016-10-12 01:00:00',14,45),(286,'2016-10-13 01:00:00',9,23),(287,'2016-10-14 01:00:00',0,43),(288,'2016-10-15 01:00:00',23,0),(289,'2016-10-16 01:00:00',18,51),(290,'2016-10-17 01:00:00',16,43),(291,'2016-10-18 01:00:00',11,14),(292,'2016-10-19 01:00:00',21,33),(293,'2016-10-20 01:00:00',20,10),(294,'2016-10-21 01:00:00',20,2),(295,'2016-10-22 01:00:00',19,12),(296,'2016-10-23 01:00:00',10,55),(297,'2016-10-24 01:00:00',20,12),(298,'2016-10-25 01:00:00',24,53),(299,'2016-10-26 01:00:00',0,18),(300,'2016-10-27 01:00:00',28,19),(301,'2016-10-28 01:00:00',9,37),(302,'2016-10-29 01:00:00',12,13),(303,'2016-10-30 01:00:00',13,3),(304,'2016-10-31 00:00:00',23,23),(305,'2016-11-01 00:00:00',23,45),(306,'2016-11-02 00:00:00',16,1),(307,'2016-11-03 00:00:00',16,29),(308,'2016-11-04 00:00:00',21,35),(309,'2016-11-05 00:00:00',13,2),(310,'2016-11-06 00:00:00',19,36),(311,'2016-11-07 00:00:00',16,7),(312,'2016-11-08 00:00:00',28,3),(313,'2016-11-09 00:00:00',17,5),(314,'2016-11-10 00:00:00',0,43),(315,'2016-11-11 00:00:00',14,14),(316,'2016-11-12 00:00:00',13,26),(317,'2016-11-13 00:00:00',9,59),(318,'2016-11-14 00:00:00',6,9),(319,'2016-11-15 00:00:00',29,54),(320,'2016-11-16 00:00:00',3,54),(321,'2016-11-17 00:00:00',22,49),(322,'2016-11-18 00:00:00',12,27),(323,'2016-11-19 00:00:00',12,0),(324,'2016-11-20 00:00:00',26,43),(325,'2016-11-21 00:00:00',11,33),(326,'2016-11-22 00:00:00',10,47),(327,'2016-11-23 00:00:00',25,35),(328,'2016-11-24 00:00:00',5,39),(329,'2016-11-25 00:00:00',29,8),(330,'2016-11-26 00:00:00',22,26),(331,'2016-11-27 00:00:00',8,21),(332,'2016-11-28 00:00:00',27,12),(333,'2016-11-29 00:00:00',24,48),(334,'2016-11-30 00:00:00',14,4),(335,'2016-12-01 00:00:00',21,48),(336,'2016-12-02 00:00:00',19,23),(337,'2016-12-03 00:00:00',19,38),(338,'2016-12-04 00:00:00',4,40),(339,'2016-12-05 00:00:00',28,27),(340,'2016-12-06 00:00:00',17,29),(341,'2016-12-07 00:00:00',6,31),(342,'2016-12-08 00:00:00',24,43),(343,'2016-12-09 00:00:00',17,40),(344,'2016-12-10 00:00:00',19,18),(345,'2016-12-11 00:00:00',6,59),(346,'2016-12-12 00:00:00',15,55),(347,'2016-12-13 00:00:00',21,17),(348,'2016-12-14 00:00:00',26,3),(349,'2016-12-15 00:00:00',15,58),(350,'2016-12-16 00:00:00',19,37),(351,'2016-12-17 00:00:00',27,5),(352,'2016-12-18 00:00:00',6,49),(353,'2016-12-19 00:00:00',9,32),(354,'2016-12-20 00:00:00',10,14),(355,'2016-12-21 00:00:00',24,38),(356,'2016-12-22 00:00:00',21,49),(357,'2016-12-23 00:00:00',28,2),(358,'2016-12-24 00:00:00',19,19),(359,'2016-12-25 00:00:00',5,30),(360,'2016-12-26 00:00:00',22,44);
/*!40000 ALTER TABLE `statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatments`
--

DROP TABLE IF EXISTS `treatments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treatments` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `endFlag` tinyint(1) DEFAULT NULL,
  `hasInvoice` tinyint(1) DEFAULT NULL,
  `tType` varchar(255) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `doctor_id` varchar(255) DEFAULT NULL,
  `medical_id` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatments`
--

LOCK TABLES `treatments` WRITE;
/*!40000 ALTER TABLE `treatments` DISABLE KEYS */;
INSERT INTO `treatments` VALUES (1,0,0,'Patient is ok','1999-05-27 00:00:00',NULL,'200000013',1,NULL),(2,0,0,'Patient is ok','1997-06-18 00:00:00',NULL,'200000009',1,NULL),(3,0,0,'Patient is ok','1996-05-03 00:00:00',NULL,'200000005',1,NULL),(4,0,0,'Patient is ok','1992-09-08 00:00:00',NULL,'200000008',2,NULL),(5,0,0,'Patient is ok','1996-03-05 00:00:00',NULL,'200000014',2,NULL),(6,0,0,'Patient is ok','2003-10-25 00:00:00',NULL,'200000011',2,NULL),(7,0,0,'Patient is ok','2001-03-19 00:00:00',NULL,'200000009',3,NULL),(8,0,0,'Patient is ok','1999-12-02 00:00:00',NULL,'200000003',3,NULL),(9,0,0,'Patient is ok','1995-08-10 00:00:00',NULL,'200000000',3,NULL),(10,0,0,'Patient is ok','1997-03-31 00:00:00',NULL,'200000010',4,NULL),(11,0,0,'Patient is ok','1993-02-16 00:00:00',NULL,'200000002',4,NULL),(12,0,0,'Patient is ok','1995-05-21 00:00:00',NULL,'200000010',4,NULL),(13,0,0,'Patient is ok','1995-05-22 00:00:00',NULL,'200000003',5,NULL),(14,0,0,'Patient is ok','1990-01-10 00:00:00',NULL,'200000004',5,NULL),(15,0,0,'Patient is ok','2005-05-27 00:00:00',NULL,'200000003',5,NULL),(16,0,0,'Patient is ok','2001-06-19 00:00:00',NULL,'200000004',6,NULL),(17,0,0,'Patient is ok','1997-08-26 00:00:00',NULL,'200000005',6,NULL),(18,0,0,'Patient is ok','2003-06-18 00:00:00',NULL,'200000005',6,NULL),(19,0,0,'Patient is ok','1999-05-07 00:00:00',NULL,'200000012',7,NULL),(20,0,0,'Patient is ok','2005-02-25 00:00:00',NULL,'200000003',7,NULL),(21,0,0,'Patient is ok','2007-08-05 00:00:00',NULL,'200000005',7,NULL),(22,0,0,'Patient is ok','1993-09-12 00:00:00',NULL,'200000004',8,NULL),(23,0,0,'Patient is ok','2006-02-11 00:00:00',NULL,'200000011',8,NULL),(24,0,0,'Patient is ok','2005-06-28 00:00:00',NULL,'200000008',8,NULL),(25,0,0,'Patient is ok','1992-04-10 00:00:00',NULL,'200000008',9,NULL),(26,0,0,'Patient is ok','1993-03-24 00:00:00',NULL,'200000007',9,NULL),(27,0,0,'Patient is ok','2006-01-01 00:00:00',NULL,'200000003',9,NULL),(28,0,0,'Patient is ok','2007-06-14 00:00:00',NULL,'200000008',10,NULL),(29,0,0,'Patient is ok','1996-02-05 00:00:00',NULL,'200000010',10,NULL),(30,0,0,'Patient is ok','2007-08-31 00:00:00',NULL,'200000010',10,NULL),(31,0,0,'Patient is ok','2002-09-23 00:00:00',NULL,'200000007',11,NULL),(32,0,0,'Patient is ok','2004-05-13 00:00:00',NULL,'200000014',11,NULL),(33,0,0,'Patient is ok','2000-01-20 00:00:00',NULL,'200000012',11,NULL),(34,0,0,'Patient is ok','1999-08-06 00:00:00',NULL,'200000009',12,NULL),(35,0,0,'Patient is ok','1992-01-04 00:00:00',NULL,'200000006',12,NULL),(36,0,0,'Patient is ok','2003-09-07 00:00:00',NULL,'200000014',12,NULL),(37,0,0,'Patient is ok','2006-04-09 00:00:00',NULL,'200000003',13,NULL),(38,0,0,'Patient is ok','2001-02-08 00:00:00',NULL,'200000005',13,NULL),(39,0,0,'Patient is ok','2003-03-21 00:00:00',NULL,'200000007',13,NULL),(40,0,0,'Patient is ok','2007-02-17 00:00:00',NULL,'200000001',14,NULL),(41,0,0,'Patient is ok','1992-08-07 00:00:00',NULL,'200000007',14,NULL),(42,0,0,'Patient is ok','1994-08-09 00:00:00',NULL,'200000014',14,NULL),(43,0,0,'Patient is ok','1996-06-28 00:00:00',NULL,'200000000',15,NULL),(44,0,0,'Patient is ok','2006-09-05 00:00:00',NULL,'200000000',15,NULL),(45,0,0,'Patient is ok','2006-06-08 00:00:00',NULL,'200000002',15,NULL),(46,0,0,'Patient is ok','2004-06-19 00:00:00',NULL,'200000004',16,NULL),(47,0,0,'Patient is ok','1993-03-28 00:00:00',NULL,'200000002',16,NULL),(48,0,0,'Patient is ok','1998-09-20 00:00:00',NULL,'200000010',16,NULL),(49,0,0,'Patient is ok','1993-10-04 00:00:00',NULL,'200000013',17,NULL),(50,0,0,'Patient is ok','2006-07-24 00:00:00',NULL,'200000012',17,NULL),(51,0,0,'Patient is ok','2003-01-20 00:00:00',NULL,'200000003',17,NULL),(52,0,0,'Patient is ok','2007-06-14 00:00:00',NULL,'200000003',18,NULL),(53,0,0,'Patient is ok','2005-02-22 00:00:00',NULL,'200000001',18,NULL),(54,0,0,'Patient is ok','1996-12-06 00:00:00',NULL,'200000000',18,NULL),(55,0,0,'Patient is ok','1997-07-14 00:00:00',NULL,'200000012',19,NULL),(56,0,0,'Patient is ok','1990-05-01 00:00:00',NULL,'200000008',19,NULL),(57,0,0,'Patient is ok','1999-03-21 00:00:00',NULL,'200000012',19,NULL),(58,0,0,'Patient is ok','2001-07-10 00:00:00',NULL,'200000014',20,NULL),(59,0,0,'Patient is ok','1999-05-01 00:00:00',NULL,'200000004',20,NULL),(60,0,0,'Patient is ok','2002-01-03 00:00:00',NULL,'200000011',20,NULL);
/*!40000 ALTER TABLE `treatments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visits`
--

DROP TABLE IF EXISTS `visits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visits` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `visitDate` datetime DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `treatment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visits`
--

LOCK TABLES `visits` WRITE;
/*!40000 ALTER TABLE `visits` DISABLE KEYS */;
INSERT INTO `visits` VALUES (1,'2007-10-05 00:00:00','The patient has a pain ',2),(2,'2004-08-17 00:00:00','The patient has a pain ',3),(3,'1994-09-25 00:00:00','The patient has a pain ',4),(4,'1995-09-28 00:00:00','The patient has a pain ',4),(5,'1994-08-06 00:00:00','The patient has a pain ',5),(6,'1999-06-25 00:00:00','The patient has a pain ',7),(7,'2008-12-28 00:00:00','The patient has a pain ',7),(8,'2002-12-21 00:00:00','The patient has a pain ',8),(9,'2002-04-30 00:00:00','The patient has a pain ',9),(10,'1998-08-18 00:00:00','The patient has a pain ',11),(11,'2000-05-28 00:00:00','The patient has a pain ',12),(12,'2009-06-12 00:00:00','The patient has a pain ',16),(13,'1996-08-18 00:00:00','The patient has a pain ',17),(14,'1991-10-22 00:00:00','The patient has a pain ',17),(15,'1997-02-06 00:00:00','The patient has a pain ',20),(16,'2003-12-12 00:00:00','The patient has a pain ',27),(17,'2003-12-24 00:00:00','The patient has a pain ',28),(18,'1996-04-12 00:00:00','The patient has a pain ',29),(19,'2001-06-20 00:00:00','The patient has a pain ',31),(20,'2002-07-11 00:00:00','The patient has a pain ',33),(21,'2002-06-23 00:00:00','The patient has a pain ',33),(22,'1991-08-10 00:00:00','The patient has a pain ',35),(23,'1996-02-04 00:00:00','The patient has a pain ',35),(24,'1990-10-01 00:00:00','The patient has a pain ',36),(25,'2008-03-17 00:00:00','The patient has a pain ',37),(26,'2002-01-04 00:00:00','The patient has a pain ',38),(27,'2000-09-22 00:00:00','The patient has a pain ',38),(28,'2008-05-23 00:00:00','The patient has a pain ',39),(29,'2007-06-03 00:00:00','The patient has a pain ',41),(30,'1991-08-11 00:00:00','The patient has a pain ',42),(31,'1997-02-13 00:00:00','The patient has a pain ',42),(32,'2004-10-28 00:00:00','The patient has a pain ',43),(33,'2009-03-01 00:00:00','The patient has a pain ',44),(34,'2006-02-17 00:00:00','The patient has a pain ',44),(35,'2005-07-14 00:00:00','The patient has a pain ',45),(36,'1997-03-11 00:00:00','The patient has a pain ',47),(37,'2007-05-08 00:00:00','The patient has a pain ',49),(38,'1996-09-28 00:00:00','The patient has a pain ',49),(39,'1990-04-24 00:00:00','The patient has a pain ',50),(40,'1998-01-03 00:00:00','The patient has a pain ',51),(41,'2002-04-19 00:00:00','The patient has a pain ',52),(42,'1999-09-22 00:00:00','The patient has a pain ',53),(43,'2008-10-28 00:00:00','The patient has a pain ',53),(44,'1995-12-18 00:00:00','The patient has a pain ',54),(45,'1996-01-24 00:00:00','The patient has a pain ',56),(46,'1996-03-08 00:00:00','The patient has a pain ',59),(47,'1994-07-26 00:00:00','The patient has a pain ',60);
/*!40000 ALTER TABLE `visits` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-13  8:20:30
