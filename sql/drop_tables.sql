-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: frugalinnovationlab
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Current Database: `frugalinnovationlab`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `frugalinnovationlab` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `frugalinnovationlab`;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lab_details`
--

DROP TABLE IF EXISTS `lab_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lab_details` (
  `logo` varchar(100) NOT NULL,
  `alt_text` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `tag_line` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lab_details`
--

LOCK TABLES `lab_details` WRITE;
/*!40000 ALTER TABLE `lab_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `lab_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_adobe`
--

DROP TABLE IF EXISTS `media_adobe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_adobe` (
  `project_id` int(11) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `file_type` varchar(20) NOT NULL,
  PRIMARY KEY (`project_id`,`file_path`),
  CONSTRAINT `FK_media_adobe_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_adobe_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_adobe`
--

LOCK TABLES `media_adobe` WRITE;
/*!40000 ALTER TABLE `media_adobe` DISABLE KEYS */;
INSERT INTO `media_adobe` VALUES (350,'C:\\Users\\Jaishreeganesh\\Documents\\Dhruvkumar Vastapara - Images.doc','Dhruvkumar Vastapara - Images',NULL,'PDF'),(444,'C:\\Users\\Jaishreeganesh\\Documents\\Java Printing.pdf','Java Printing',NULL,'PDF');
/*!40000 ALTER TABLE `media_adobe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_cad`
--

DROP TABLE IF EXISTS `media_cad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_cad` (
  `project_id` int(11) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`file_path`),
  CONSTRAINT `FK_media_cad_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_cad_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_cad`
--

LOCK TABLES `media_cad` WRITE;
/*!40000 ALTER TABLE `media_cad` DISABLE KEYS */;
INSERT INTO `media_cad` VALUES (62,'D:\\dump-sar.sql','dump-sar',NULL),(63,'D:\\dump-sar.sql','dump-sar',NULL),(89,'C:\\Users\\Jaishreeganesh\\Documents\\Policy-Cancel-Request.docx','Policy-Cancel-Request',NULL),(205,'C:\\Users\\Jaishreeganesh\\Documents\\MTS-steps.txt','MTS-steps',NULL),(205,'C:\\Users\\Jaishreeganesh\\Documents\\pgadmin.log','pgadmin',NULL),(205,'C:\\Users\\Jaishreeganesh\\Documents\\Policy-Cancel-Request.docx','Policy-Cancel-Request',NULL);
/*!40000 ALTER TABLE `media_cad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_code`
--

DROP TABLE IF EXISTS `media_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_code` (
  `project_id` int(11) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`file_path`),
  CONSTRAINT `FK_media_code_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_code_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_code`
--

LOCK TABLES `media_code` WRITE;
/*!40000 ALTER TABLE `media_code` DISABLE KEYS */;
INSERT INTO `media_code` VALUES (62,'F:\\dump.sql','dump',NULL),(63,'F:\\dump.sql','dump',NULL),(89,'C:\\Users\\Jaishreeganesh\\Documents\\pgadmin.log','pgadmin',NULL),(110,'D:\\dump-sar.zip','dump-sar',NULL);
/*!40000 ALTER TABLE `media_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_hyperlink`
--

DROP TABLE IF EXISTS `media_hyperlink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_hyperlink` (
  `project_id` int(11) NOT NULL,
  `link` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `open_in_window` varchar(10) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`link`),
  CONSTRAINT `FK_media_hyperlink_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_hyperlink_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_hyperlink`
--

LOCK TABLES `media_hyperlink` WRITE;
/*!40000 ALTER TABLE `media_hyperlink` DISABLE KEYS */;
/*!40000 ALTER TABLE `media_hyperlink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_locationmap`
--

DROP TABLE IF EXISTS `media_locationmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_locationmap` (
  `project_id` int(11) NOT NULL,
  `address` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `lattitude` varchar(25) DEFAULT NULL,
  `longitude` varchar(25) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `state` varchar(25) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `zipcode` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`address`),
  CONSTRAINT `FK_media_locationmap_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_locationmap_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_locationmap`
--

LOCK TABLES `media_locationmap` WRITE;
/*!40000 ALTER TABLE `media_locationmap` DISABLE KEYS */;
/*!40000 ALTER TABLE `media_locationmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_pdf`
--

DROP TABLE IF EXISTS `media_pdf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_pdf` (
  `project_id` int(11) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`file_path`),
  CONSTRAINT `FK_media_pdf_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_pdf_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_pdf`
--

LOCK TABLES `media_pdf` WRITE;
/*!40000 ALTER TABLE `media_pdf` DISABLE KEYS */;
INSERT INTO `media_pdf` VALUES (63,'C:\\Users\\Jaishreeganesh\\Documents\\Dhruvkumar Vastapara - Tavant.doc','Dhruvkumar Vastapara - Tavant',NULL),(89,'C:\\Users\\Jaishreeganesh\\Documents\\Dhruvkumar Vastapara - Tavant.doc','Dhruvkumar Vastapara - Tavant',NULL);
/*!40000 ALTER TABLE `media_pdf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_photos`
--

DROP TABLE IF EXISTS `media_photos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_photos` (
  `project_id` int(11) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`file_path`),
  CONSTRAINT `FK_media_photos_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_photos_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_photos`
--

LOCK TABLES `media_photos` WRITE;
/*!40000 ALTER TABLE `media_photos` DISABLE KEYS */;
INSERT INTO `media_photos` VALUES (63,'C:\\Users\\Jaishreeganesh\\Documents\\CustomerService.accdt','CustomerService',NULL),(89,'C:\\Users\\Jaishreeganesh\\Documents\\Dhruvkumar Vastapara - Images.doc','Dhruvkumar Vastapara - Images',NULL);
/*!40000 ALTER TABLE `media_photos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_plaintext`
--

DROP TABLE IF EXISTS `media_plaintext`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_plaintext` (
  `project_id` int(11) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`file_path`),
  CONSTRAINT `FK_media_plaintext_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_plaintext_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_plaintext`
--

LOCK TABLES `media_plaintext` WRITE;
/*!40000 ALTER TABLE `media_plaintext` DISABLE KEYS */;
INSERT INTO `media_plaintext` VALUES (58,'D:\\dump-sar.zip','dump-sar',NULL),(89,'C:\\Users\\Jaishreeganesh\\Documents\\Faculty.accdt','Faculty',NULL),(220,'C:\\Users\\Jaishreeganesh\\Documents\\Dhruvkumar Vastapara - Tavant.doc','Dhruvkumar Vastapara - Tavant',NULL),(221,'C:\\Users\\Jaishreeganesh\\Documents\\Dhruvkumar Vastapara - Tavant.doc','Dhruvkumar Vastapara - Tavant',NULL);
/*!40000 ALTER TABLE `media_plaintext` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_spreadsheet`
--

DROP TABLE IF EXISTS `media_spreadsheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_spreadsheet` (
  `project_id` int(11) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`file_path`),
  CONSTRAINT `FK_media_spreadsheet_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_spreadsheet_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_spreadsheet`
--

LOCK TABLES `media_spreadsheet` WRITE;
/*!40000 ALTER TABLE `media_spreadsheet` DISABLE KEYS */;
INSERT INTO `media_spreadsheet` VALUES (89,'C:\\Users\\Jaishreeganesh\\Documents\\MTS-steps.txt','MTS-steps',NULL),(200,'C:\\Users\\Jaishreeganesh\\Documents\\CustomerService.accdt','CustomerService',NULL);
/*!40000 ALTER TABLE `media_spreadsheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_video`
--

DROP TABLE IF EXISTS `media_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_video` (
  `project_id` int(11) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `file_type` varchar(10) DEFAULT NULL,
  `duration` varchar(25) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`file_path`),
  CONSTRAINT `FK_media_video_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_video_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_video`
--

LOCK TABLES `media_video` WRITE;
/*!40000 ALTER TABLE `media_video` DISABLE KEYS */;
INSERT INTO `media_video` VALUES (57,'D:\\dump-sar.zip',NULL,NULL,'dump-sar',NULL),(58,'D:\\insert-queries.txt','video',NULL,'insert-queries',NULL),(64,'C:\\Users\\Jaishreeganesh\\Documents\\sindhi.txt','video',NULL,'sindhi',NULL),(89,'C:\\Users\\Jaishreeganesh\\Documents\\CustomerService.accdt','video',NULL,'CustomerService',NULL);
/*!40000 ALTER TABLE `media_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `media_word`
--

DROP TABLE IF EXISTS `media_word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `media_word` (
  `project_id` int(11) NOT NULL,
  `file_path` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`,`file_path`),
  CONSTRAINT `FK_media_word_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `media_word_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `media_word`
--

LOCK TABLES `media_word` WRITE;
/*!40000 ALTER TABLE `media_word` DISABLE KEYS */;
INSERT INTO `media_word` VALUES (89,'C:\\Users\\Jaishreeganesh\\Documents\\Cover Letter.docx','Cover Letter',NULL),(101,'C:\\Users\\Jaishreeganesh\\Documents\\Dhruvkumar Vastapara - Images.doc','Dhruvkumar Vastapara - Images',NULL);
/*!40000 ALTER TABLE `media_word` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant_designation`
--

DROP TABLE IF EXISTS `participant_designation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participant_designation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant_designation`
--

LOCK TABLES `participant_designation` WRITE;
/*!40000 ALTER TABLE `participant_designation` DISABLE KEYS */;
INSERT INTO `participant_designation` VALUES (2,'Faculty'),(3,'Partners'),(1,'Student');
/*!40000 ALTER TABLE `participant_designation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participants`
--

DROP TABLE IF EXISTS `participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_title` varchar(5) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `middlename` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `position` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `organization` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participants`
--

LOCK TABLES `participants` WRITE;
/*!40000 ALTER TABLE `participants` DISABLE KEYS */;
INSERT INTO `participants` VALUES (1,'Miss.','Jaqueline','','Barbosa','Student','jb@scu.edu','555-0001','SCU'),(2,'Mr.','Kirsten','','Petersen','Student','kp@scu.edu','555-0002','SCU'),(3,'Dr.','Shobha','','Krishnan','Faculty','sk@scu.edu','555-0003','SCU'),(4,'Miss.','Sonny','','Gandhi','Student','sg@scu.edu','555-0004','SCU'),(5,'Mr.','Zuhyr','','Elahi','Student','ze@scu.edu','555-0005','SCU'),(6,'Mr.','John','','Seubert','Student','js@scu.edu','555-0006','SCU'),(7,'Mr.','Ben','','Demaree','Student','bd@scu.edu','555-0007','SCU'),(8,'Miss.','Jessica','','VanderGiessen','Student','jv@scu.edu','555-0008','SCU'),(9,'Dr.','Silvia','','Figueira','Faculty','sf@scu.edu','555-0009','SCU'),(10,'Dr.','Ashley','','Kim','Faculty','ak@scu.edu','555-0010','SCU'),(11,'Mr.','Erik','','McAdams','Student','em@scu.edu','555-0011','SCU'),(12,'Mr.','Hugo','','Mailloux-Beauchemin','Student','hb@scu.edu','555-0012','SCU'),(13,'Mr.','Jonathan','','Chimento','Student','jc@scu.edu','555-0013','SCU'),(14,'Mr.','Tonya','','Nilsson','Faculty','tn@scu.edu','555-0014','SCU'),(15,'Mr.','Jonathan','','Ahumada','Student','ja@scu.edu','555-0015','SCU'),(16,'Mr.','Kurt','','Jurgens','Student','kjb@scu.edu','555-0016','SCU'),(17,'Mr.','Jasmine','','Farias','Student','jf@scu.edu','555-0017','SCU'),(18,'Mr.','Fundacion','','Paraguaya','Partners','fp@scu.edu','555-0018','SCU'),(19,'Mr.','Christine','','Horman','Student','ch@scu.edu','555-0019','SCU'),(20,'Mr.','Matthew','','Lee','Student','ml@scu.edu','555-0020','SCU'),(21,'Mr.','Mark','','Wagner','Student','mw@scu.edu','555-0021','SCU'),(22,'Dr.','Hohyun','','Lee','Faculty','hl@scu.edu','555-0022','SCU'),(23,'Mr.','Chris','M.','Gayle','Bachelor','gb@scu.edu','555-0023','SCU'),(24,'','Chris','check@gmail.com','Gayle','Partners','cg@scu.edu','555-0024','SCU'),(25,'Mr.','Rahul','K.','Sharma','Student','rs@scu.edu','555-0025','SCU'),(26,'Mr.','Brian','','Lara','Faculty','bl@scu.edu','555-0026','SCU');
/*!40000 ALTER TABLE `participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `shortdesc` varchar(100) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `scope` varchar(100) NOT NULL,
  `display` tinyint(1) NOT NULL DEFAULT '1',
  `outcome` varchar(500) DEFAULT NULL,
  `location` varchar(50) DEFAULT 'NULL',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Micro-Grid for Uganda (Extension of Solar Home System Project)','A Locally Manufacturable and Serviceable Solar Home System','This project is a result of the collaboration between Santa Clara University and Energy Made in Uganda, a\ncommunity-based organization in Mpigi, Uganda. Four Ugandan students trained in solar manufacturing,\ninstallation, and servicing, are continuing solar trainings at local Solar Technology Centers to manufacture Solar\nHome Systems which are sold in Ugandan communities. This method ensures that if a solar product breaks,\nthere is a community representative available to service it. In partnership with these four students, this senior\ndesign project is to design the electronic system that is efficient, affordable, safe, serviceable, and that meets\nthe end users\' needs.','2013-10-01','2014-06-15','TBD',1,'TBD','NULL'),(2,'Lab in a Chip','TBD','TBD','2012-10-05',NULL,'TBD',1,'TBD','NULL'),(3,'Emergency Power for Hospitals in Under-Developed Countries','TBD','TBD','2012-10-05',NULL,'TBD',1,'TBD','NULL'),(4,'Dynamic Poverty Heat Map','TBD','TBD','2012-10-05',NULL,'TBD',1,'TBD','NULL'),(5,'Nicaraguan Cookstove with Thermoelectric Power Generation','TBD','TBD','2012-10-05',NULL,'TBD',1,'TBD','NULL'),(14,'kjdkas','jkndksa',NULL,'2014-06-06','2014-06-14','',1,NULL,'NULL'),(15,'hsagd','ldkaslk',NULL,'2014-06-14','2014-06-21','',1,NULL,'NULL'),(17,'Nice pro','jdbsajk',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL'),(18,'okok','dbkjas',NULL,'2014-06-07','2014-06-21','',1,NULL,'NULL'),(19,'dsaoh','djas',NULL,'2014-06-07','2014-06-21','',1,NULL,'NULL'),(20,'iidsjaio','kjdsak',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL'),(21,'nkjn','dbsa',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL'),(22,'jdaskl','kjdbask',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL'),(23,'jdaskljdsaksa','kjdbask',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL'),(24,'Test Today','OKok',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL'),(28,'nlkdn','dnndsa',NULL,'2014-06-07','2014-06-12','',1,NULL,'NULL'),(50,'kjbjhbhjb','jdkjsbajk',NULL,'2014-06-14','2014-06-21','',1,NULL,'NULL'),(57,'knbjk','nlnl',NULL,'2014-06-06','2014-06-06','',1,NULL,'NULL'),(58,'jnjkn','dlkasn',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL'),(59,'ndjln','djsak',NULL,'2014-06-14','2014-06-27','',1,NULL,'NULL'),(60,'ndjlndasdas','djsak',NULL,'2014-06-14','2014-06-27','',1,NULL,'NULL'),(62,'ndjlndasdasdnajksl','djsak',NULL,'2014-06-14','2014-06-27','',1,NULL,'NULL'),(63,'ndjlndasdasdnajksldsa','djsak',NULL,'2014-06-14','2014-06-27','',1,NULL,'NULL'),(64,'Hello Project is Nice','Looks OK calm and composed','ndfjn ndjknda ','2014-06-07','2014-06-13','Out of Scope',1,'No Outcome','NULL'),(77,'hs','dsh',NULL,'2014-06-07','2014-06-13','lcknclk',1,'nldkasnlkd','NULL'),(89,'Test again check','nice','yesss','2014-06-06','2014-06-07','All',1,'Pending','NULL'),(100,'njnjdn','jkfndn',NULL,'2014-06-07','2014-06-13','nlkndjn',1,'njfnkdsj','NULL'),(101,'lknlkf','fdlkfn',NULL,'2014-06-07','2014-06-20','njndjnfdjsn',1,'ndjkasbfkhdb','NULL'),(104,'ofhduohou','joihfuodho',NULL,'2014-06-07','2014-06-20','njkbdfbdshb',1,'bhabfhdsbjd','NULL'),(110,'dsajbd','habfi',NULL,'2014-06-07','2014-06-14','ncjxb',1,'onasobdoas','NULL'),(111,'Test This','dskj',NULL,'2014-06-07','2014-06-14','kjbdkasbh',1,'aksdbsak','NULL'),(152,'ldnsan','djaksbndkj',NULL,'2014-06-14','2014-06-20','fdgfhgh',1,'hdgasd','NULL'),(154,'kdjkjb','dhsjdb',NULL,'2014-06-07','2014-06-14','hdbashvb',1,'bdahsbdh','NULL'),(200,'Great Project','Looks Good','Oh Yes its nice','2014-06-07','2014-06-21','Still not decided',1,'Desktop Project','NULL'),(205,'Test Project Entry','cool',NULL,'2014-06-14','2014-06-20','dunno',1,'nothing','NULL'),(206,'hdajshdj','dhasbh',NULL,'2014-06-06','2014-06-14','doshuin',1,'iasdiabsi','NULL'),(209,'oidjasohuio','dhasuidhiu',NULL,'2014-06-06','2014-06-07','dnasnbdi',1,'dnasdbsia','NULL'),(210,'dsjdbh','dhbashb',NULL,'2014-06-07','2014-06-14','jdnsjnbkj',1,'jkdsajkk','NULL'),(212,'ndsajkn','jknasjk',NULL,'2014-06-07','2014-06-20','kncdnlk',1,'klnclanl','NULL'),(213,'dhausdhiu','dahduasihiu',NULL,'2014-06-07','2014-06-20','ndjksn',1,'kdmsnakld','NULL'),(214,'dhshdas','hdashdvhj',NULL,'2014-06-07','2014-06-20','nlndlasnlk',1,'lkndlkasndlsaj','NULL'),(220,'thursday','dasbjk',NULL,'2014-06-06','2014-06-21','mdkmnlk',1,'md;aks','NULL'),(221,'nnksandkd',';daskndskal',NULL,'2014-06-06','2014-06-21','mdkmnlk',1,'md;aks','NULL'),(350,'new form','lkdjslkj',NULL,'2014-06-07','2014-06-13','nklkjn',1,'jnjknj','NULL'),(434,'Message Driven Computing','MDC parallel approach','MDC parallel approach is nice','2014-08-01','2014-08-23','Demo',1,'New approach','San jose'),(444,'Cloud Computing','Project for Security in Cloud Computing','Security and caching are the goals of this project','2014-08-07','2014-08-23','Data Center',1,'A Cloud Provider','Santa Clara'),(999,'sjdhisu','djsadjk',NULL,'2014-06-07','2014-06-14','hduadbiuas',1,'basibdisa','NULL');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_category`
--

DROP TABLE IF EXISTS `project_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_category` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_category`
--

LOCK TABLES `project_category` WRITE;
/*!40000 ALTER TABLE `project_category` DISABLE KEYS */;
INSERT INTO `project_category` VALUES ('Bio Engineering'),('Civil Engineering'),('Computer Engineering'),('Electrical Engineering'),('Mechanical Engineering');
/*!40000 ALTER TABLE `project_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_category_map`
--

DROP TABLE IF EXISTS `project_category_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_category_map` (
  `project_id` int(11) NOT NULL,
  `category_name` varchar(50) NOT NULL,
  PRIMARY KEY (`project_id`,`category_name`),
  KEY `FK_project_category_map_category_name` (`category_name`),
  CONSTRAINT `FK_project_category_map_category_name` FOREIGN KEY (`category_name`) REFERENCES `project_category` (`name`),
  CONSTRAINT `FK_project_category_map_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `project_category_map_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `project_category_map_ibfk_2` FOREIGN KEY (`category_name`) REFERENCES `project_category` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_category_map`
--

LOCK TABLES `project_category_map` WRITE;
/*!40000 ALTER TABLE `project_category_map` DISABLE KEYS */;
INSERT INTO `project_category_map` VALUES (2,'Bio Engineering'),(22,'Bio Engineering'),(23,'Bio Engineering'),(24,'Bio Engineering'),(28,'Bio Engineering'),(58,'Bio Engineering'),(104,'Bio Engineering'),(111,'Bio Engineering'),(3,'Civil Engineering'),(23,'Civil Engineering'),(24,'Civil Engineering'),(28,'Civil Engineering'),(50,'Civil Engineering'),(57,'Civil Engineering'),(77,'Civil Engineering'),(89,'Civil Engineering'),(101,'Civil Engineering'),(104,'Civil Engineering'),(110,'Civil Engineering'),(111,'Civil Engineering'),(152,'Civil Engineering'),(154,'Civil Engineering'),(200,'Civil Engineering'),(205,'Civil Engineering'),(206,'Civil Engineering'),(209,'Civil Engineering'),(210,'Civil Engineering'),(220,'Civil Engineering'),(221,'Civil Engineering'),(350,'Civil Engineering'),(444,'Civil Engineering'),(999,'Civil Engineering'),(2,'Computer Engineering'),(4,'Computer Engineering'),(22,'Computer Engineering'),(23,'Computer Engineering'),(58,'Computer Engineering'),(64,'Computer Engineering'),(89,'Computer Engineering'),(154,'Computer Engineering'),(200,'Computer Engineering'),(206,'Computer Engineering'),(209,'Computer Engineering'),(210,'Computer Engineering'),(350,'Computer Engineering'),(434,'Computer Engineering'),(444,'Computer Engineering'),(1,'Electrical Engineering'),(2,'Electrical Engineering'),(64,'Electrical Engineering'),(200,'Electrical Engineering'),(212,'Electrical Engineering'),(213,'Electrical Engineering'),(214,'Electrical Engineering'),(5,'Mechanical Engineering'),(23,'Mechanical Engineering'),(59,'Mechanical Engineering'),(60,'Mechanical Engineering'),(62,'Mechanical Engineering'),(63,'Mechanical Engineering'),(64,'Mechanical Engineering'),(205,'Mechanical Engineering'),(212,'Mechanical Engineering'),(213,'Mechanical Engineering'),(214,'Mechanical Engineering'),(434,'Mechanical Engineering');
/*!40000 ALTER TABLE `project_category_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_participants`
--

DROP TABLE IF EXISTS `project_participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_participants` (
  `project_id` int(11) NOT NULL,
  `participant_id` int(11) NOT NULL,
  `designation` int(11) NOT NULL,
  PRIMARY KEY (`project_id`,`participant_id`,`designation`),
  UNIQUE KEY `project_id` (`project_id`,`participant_id`,`designation`),
  KEY `FK_project_participants_designation` (`designation`),
  KEY `FK_project_participants_participant_id` (`participant_id`),
  CONSTRAINT `FK_project_participants_participant_id` FOREIGN KEY (`participant_id`) REFERENCES `participants` (`id`),
  CONSTRAINT `FK_project_participants_designation` FOREIGN KEY (`designation`) REFERENCES `participant_designation` (`id`),
  CONSTRAINT `FK_project_participants_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `project_participants_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `project_participants_ibfk_2` FOREIGN KEY (`participant_id`) REFERENCES `participants` (`id`),
  CONSTRAINT `project_participants_ibfk_3` FOREIGN KEY (`designation`) REFERENCES `participant_designation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_participants`
--

LOCK TABLES `project_participants` WRITE;
/*!40000 ALTER TABLE `project_participants` DISABLE KEYS */;
INSERT INTO `project_participants` VALUES (1,1,1),(1,2,1),(2,4,1),(2,5,1),(2,6,1),(2,7,1),(2,8,1),(3,5,1),(3,11,1),(3,12,1),(3,13,1),(4,2,1),(4,5,1),(4,11,1),(4,12,1),(4,13,1),(4,15,1),(4,16,1),(4,17,1),(5,4,1),(5,19,1),(5,20,1),(5,21,1),(19,12,1),(89,2,1),(89,5,1),(89,6,1),(89,11,1),(89,12,1),(89,13,1),(89,15,1),(89,16,1),(89,17,1),(111,1,1),(111,5,1),(154,1,1),(200,3,1),(205,6,1),(206,2,1),(210,3,1),(444,25,1),(1,3,2),(2,3,2),(2,9,2),(2,10,2),(3,6,2),(3,14,2),(3,23,2),(4,9,2),(4,14,2),(5,22,2),(19,23,2),(89,1,2),(89,2,2),(89,9,2),(89,14,2),(110,3,2),(110,6,2),(111,3,2),(205,4,2),(213,6,2),(220,4,2),(221,4,2),(434,1,2),(3,1,3),(3,2,3),(3,3,3),(3,5,3),(3,6,3),(4,2,3),(4,5,3),(4,18,3),(19,1,3),(19,2,3),(19,3,3),(19,5,3),(19,6,3),(64,1,3),(89,1,3),(89,2,3),(89,3,3),(89,5,3),(89,18,3),(104,2,3),(110,1,3),(110,2,3),(200,5,3),(209,1,3),(210,1,3),(210,2,3),(210,5,3),(212,1,3),(212,4,3),(213,2,3),(214,1,3),(214,2,3),(214,3,3),(214,5,3),(214,6,3),(350,2,3),(444,26,3);
/*!40000 ALTER TABLE `project_participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_status`
--

DROP TABLE IF EXISTS `project_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_status` (
  `status` varchar(25) NOT NULL,
  `status_description` varchar(200) DEFAULT '',
  PRIMARY KEY (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_status`
--

LOCK TABLES `project_status` WRITE;
/*!40000 ALTER TABLE `project_status` DISABLE KEYS */;
INSERT INTO `project_status` VALUES ('Completed',''),('Dormant',NULL),('In Progress',NULL);
/*!40000 ALTER TABLE `project_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_status_map`
--

DROP TABLE IF EXISTS `project_status_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_status_map` (
  `project_id` int(11) NOT NULL,
  `status_name` varchar(25) NOT NULL,
  PRIMARY KEY (`project_id`,`status_name`),
  KEY `FK_project_status_map_status_name` (`status_name`),
  CONSTRAINT `FK_project_status_map_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FK_project_status_map_status_name` FOREIGN KEY (`status_name`) REFERENCES `project_status` (`status`),
  CONSTRAINT `project_status_map_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `project_status_map_ibfk_2` FOREIGN KEY (`status_name`) REFERENCES `project_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_status_map`
--

LOCK TABLES `project_status_map` WRITE;
/*!40000 ALTER TABLE `project_status_map` DISABLE KEYS */;
INSERT INTO `project_status_map` VALUES (1,'Completed'),(4,'Completed'),(5,'Completed'),(18,'Completed'),(19,'Completed'),(20,'Completed'),(22,'Completed'),(23,'Completed'),(24,'Completed'),(28,'Completed'),(57,'Completed'),(58,'Completed'),(59,'Completed'),(60,'Completed'),(62,'Completed'),(63,'Completed'),(77,'Completed'),(100,'Completed'),(101,'Completed'),(104,'Completed'),(110,'Completed'),(111,'Completed'),(152,'Completed'),(209,'Completed'),(212,'Completed'),(213,'Completed'),(214,'Completed'),(220,'Completed'),(221,'Completed'),(350,'Completed'),(999,'Completed'),(3,'Dormant'),(21,'Dormant'),(50,'Dormant'),(64,'Dormant'),(154,'Dormant'),(205,'Dormant'),(206,'Dormant'),(434,'Dormant'),(2,'In Progress'),(89,'In Progress'),(200,'In Progress'),(210,'In Progress'),(444,'In Progress');
/*!40000 ALTER TABLE `project_status_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_tag_map`
--

DROP TABLE IF EXISTS `project_tag_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_tag_map` (
  `projectid` int(10) DEFAULT NULL,
  `tagname` varchar(100) DEFAULT NULL,
  KEY `FK_project_tag_map_projectid` (`projectid`),
  KEY `FK_project_tag_map_tagname` (`tagname`),
  CONSTRAINT `FK_project_tag_map_tagname` FOREIGN KEY (`tagname`) REFERENCES `tags` (`tagname`),
  CONSTRAINT `FK_project_tag_map_projectid` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`),
  CONSTRAINT `project_tag_map_ibfk_1` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`),
  CONSTRAINT `project_tag_map_ibfk_2` FOREIGN KEY (`tagname`) REFERENCES `tags` (`tagname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_tag_map`
--

LOCK TABLES `project_tag_map` WRITE;
/*!40000 ALTER TABLE `project_tag_map` DISABLE KEYS */;
INSERT INTO `project_tag_map` VALUES (434,'Mechanical'),(434,'Computer'),(434,'Cloud Computing'),(434,'San jose'),(434,'Santa Clara');
/*!40000 ALTER TABLE `project_tag_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentrecord`
--

DROP TABLE IF EXISTS `studentrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentrecord` (
  `id` int(11) NOT NULL,
  `dept_id` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentrecord`
--

LOCK TABLES `studentrecord` WRITE;
/*!40000 ALTER TABLE `studentrecord` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tags` (
  `tagname` varchar(100) NOT NULL DEFAULT '""',
  PRIMARY KEY (`tagname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES ('Arts and Sciene'),('Bio Enginnering'),('Cloud Computing'),('Computer'),('Electrical'),('Humanity'),('Mechanical'),('Rocket'),('San jose'),('Santa Clara');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('Administrator'),('Viewer');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `firstname` varchar(25) NOT NULL,
  `lastname` varchar(25) NOT NULL,
  `emailaddress` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL,
  `contactnumber` bigint(20) DEFAULT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Dipti','Kanthilal','itzdipti@gmail.com','dipti44','Dipti@123',8888888888,1),('steve','smith','dsakbh@hd','dshsjkhjks','hhhhhhh',787987,1),('dsajhds','dasdjsa','jdsajkhdsajk@djs','jdasjhdsjka','hhhhhhh',77678678,0),('djhsjdk','hdajskhdkj','djjsk@dhasjh','jdhsjahjk','jjjjjjj',53543,0),('m','m','me','m','m',1,1),('sachin','tenndulkar1','sachin@gmail.com','sachin44','sachin@123',999999999,1),('Sarvesh','Sharma 3','itzsarvo@gmail.com','sarvo44','Sarvesh@123',9999999999,1),('aaaaaaaa','bbbbbbbbbb','qqqq@qqqq.com','sasa','11111',31313131,1),('Sony','Pandi','itzsony@gmail.com','sony44','Sony@123',7777777777,1),('Test','AGAIN','testgmail.com','test44','11',44444,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles_map`
--

DROP TABLE IF EXISTS `users_roles_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles_map` (
  `username` varchar(50) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`username`,`role_name`),
  KEY `FK_users_roles_map_role_name` (`role_name`),
  CONSTRAINT `FK_users_roles_map_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `FK_users_roles_map_role_name` FOREIGN KEY (`role_name`) REFERENCES `user_roles` (`name`),
  CONSTRAINT `users_roles_map_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `users_roles_map_ibfk_2` FOREIGN KEY (`role_name`) REFERENCES `user_roles` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles_map`
--

LOCK TABLES `users_roles_map` WRITE;
/*!40000 ALTER TABLE `users_roles_map` DISABLE KEYS */;
INSERT INTO `users_roles_map` VALUES ('dipti44','Administrator'),('jdasjhdsjka','Administrator'),('m','Administrator'),('sarvo44','Administrator'),('sasa','Administrator'),('sony44','Administrator'),('dshsjkhjks','Viewer'),('jdhsjahjk','Viewer'),('sachin44','Viewer'),('test44','Viewer');
/*!40000 ALTER TABLE `users_roles_map` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-01 15:41:44
