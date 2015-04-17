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
-- Table structure for table `filetypes`
--

DROP TABLE IF EXISTS `filetypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filetypes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filetypes`
--

LOCK TABLES `filetypes` WRITE;
/*!40000 ALTER TABLE `filetypes` DISABLE KEYS */;
INSERT INTO `filetypes` VALUES (2,'PDF'),(3,'XML'),(4,'Doc / Docx'),(5,'Image'),(6,'Video'),(7,'Flash'),(8,'XML'),(10,'Doc / Docx'),(12,'XML'),(14,'Image'),(15,'Flash'),(16,'Doc / Docx'),(17,'Flash');
/*!40000 ALTER TABLE `filetypes` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participants`
--

LOCK TABLES `participants` WRITE;
/*!40000 ALTER TABLE `participants` DISABLE KEYS */;
INSERT INTO `participants` VALUES (1,'','Jaqueline','K.','Barbosa','Student','jb@scu.edu','555-000-0000','SCU'),(2,'','Kirsten','','Petersen','Student','kp@scu.edu','555-0002','SCU'),(3,'PHD','Shobha','','Krishnan','Faculty','sk@scu.edu','555-0003','SCU'),(4,'','Sonny','','Gandhi','Student','sg@scu.edu','555-0004','SCU'),(5,'','Zuhyr','','Elahi','Student','ze@scu.edu','555-0005','SCU'),(6,'','John','','Seubert','Student','js@scu.edu','555-0006','SCU'),(7,'PHD','Ben','S.','Demaree','Student','bd@scu.edu','555-000-0000','SCU'),(8,'','Jessica','','VanderGiessen','Student','jv@scu.edu','555-0008','SCU'),(9,'PHD','Silvia','K.','Figueira','Faculty','sf@scu.edu','555-999-0000','SCU'),(10,'PHD','Ashley','','Kim','Faculty','ak@scu.edu','555-0010','SCU'),(11,'','Erik','','McAdams','Student','em@scu.edu','555-0011','SCU'),(12,'','Hugo','','Mailloux-Beauchemin','Student','hb@scu.edu','555-0012','SCU'),(13,'','Jonathan','','Chimento','Student','jc@scu.edu','555-0013','SCU'),(14,'','Tonya','','Nilsson','Faculty','tn@scu.edu','555-0014','SCU'),(15,'PHD','Jonathan','S.','Ahumada','Student','ja@scu.edu','555-001-9999','SCU'),(16,'','Kurt','','Jurgens','Student','kjb@scu.edu','555-0016','SCU'),(17,'','Jasmine','M.','Farias','Student','jf@scu.edu','555-001-9999','SCU'),(18,'','Fundacion','','Paraguaya','Partners','fp@scu.edu','555-0018','SCU'),(19,'','Christine','','Horman','Student','ch@scu.edu','555-0019','SCU'),(20,'','Matthew','','Lee','Student','ml@scu.edu','555-0020','SCU'),(21,'','Mark','','Wagner','Student','mw@scu.edu','555-0021','SCU'),(22,'PHD','Hohyun','','Lee','Faculty','hl@scu.edu','555-0022','SCU'),(23,'','Chrisss','S.','Gayles','Bachelor','gb@scu.edu','555-0044','SCU'),(24,'','Chris','check@gmail.com','Gayle','Partners','cg@scu.edu','555-0024','SCU'),(25,'PHD','Rahulss','K.','Sharma','Student','rs@scu.edu','555-0025','SCU'),(26,'PHD','Brian','J.','Lara','Faculty','bl@scu.edu','555-0026','SCU'),(27,'','Steve','','Smith','','','',''),(28,'MD','Mike','','Smith','','','',''),(29,'','Elizabeth','','Sweeny','','','',''),(30,'PHD','Lucas','','Smith','','','',''),(31,'','Loyola','','Atkinson','','','',''),(32,'','John','','Adrahim','','','',''),(33,'PHD','Bitto','','Vari','Alumni','','',''),(34,'','Charles','','White','','','',''),(35,'','Steven','','Creeks','','','',''),(36,'','Leo','','Schultz','','','',''),(37,'','Frankiln','','Benjamin','','','',''),(38,'','Divi','','Seksaria','','','',''),(39,'','Radhika','','Grover','','','',''),(40,'','Leo','','Xi','','','',''),(41,'','Hinsen','','Chan','','','',''),(42,'','Sergio','','Silvia','','','',''),(43,'','Tina','','Sharma','','','',''),(44,'','Mark','','Richardson','','','',''),(45,'','Malcom','','Marshall','','','',''),(46,'','Joel','','Garner','','','',''),(47,'','Michael','','Holding','','','',''),(48,'','Carl','','Hooper','','','','');
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
  `archive` varchar(5) DEFAULT 'no',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Micro-Grid for Uganda (Extension of Solar Home System Project)','A Locally Manufacturable and Serviceable Solar Home System','This project is a result of the collaboration between Santa Clara University and Energy Made in Uganda, a\ncommunity-based organization in Mpigi, Uganda. Four Ugandan students trained in solar manufacturing,\ninstallation, and servicing, are continuing solar trainings at local Solar Technology Centers to manufacture Solar\nHome Systems which are sold in Ugandan communities. This method ensures that if a solar product breaks,\nthere is a community representative available to service it. In partnership with these four students, this senior\ndesign project is to design the electronic system that is efficient, affordable, safe, serviceable, and that meets\nthe end users\' needs.','2013-10-01','2014-06-15','TBD',1,'TBD','NULL','no'),(2,'Lab in a Chip','TBD','TBD','2012-10-05',NULL,'TBD',1,'TBD','NULL','no'),(3,'Emergency Power for Hospitals in Under-Developed Countries','TBD','TBD','2012-10-05',NULL,'TBD',1,'TBD','NULL','yes'),(4,'Dynamic Poverty Heat Map','TBD','TBD','2012-10-05',NULL,'TBD',1,'TBD','NULL','no'),(5,'Nicaraguan Cookstove with Thermoelectric Power Generation','TBD','TBD','2012-10-05',NULL,'TBD',1,'TBD','NULL','no'),(14,'kjdkas','jkndksa',NULL,'2014-06-06','2014-06-14','',1,NULL,'NULL','no'),(15,'hsagd','ldkaslk',NULL,'2014-06-14','2014-06-21','',1,NULL,'NULL','no'),(17,'Nice pro','jdbsajk',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL','yes'),(18,'okok','dbkjas',NULL,'2014-06-07','2014-06-21','',1,NULL,'NULL','no'),(19,'dsaoh','djas',NULL,'2014-06-07','2014-06-21','',1,NULL,'NULL','no'),(20,'iidsjaio','kjdsak',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL','no'),(21,'nkjn','dbsa',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL','no'),(22,'jdaskl','kjdbask',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL','no'),(23,'jdaskljdsaksa','kjdbask',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL','no'),(24,'Test Today','OKok',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL','no'),(28,'nlkdn','dnndsa',NULL,'2014-06-07','2014-06-12','',1,NULL,'NULL','no'),(50,'kjbjhbhjb','jdkjsbajk',NULL,'2014-06-14','2014-06-21','',1,NULL,'NULL','no'),(57,'knbjk','nlnl',NULL,'2014-06-06','2014-06-06','',1,NULL,'NULL','no'),(58,'jnjkn','dlkasn',NULL,'2014-06-07','2014-06-14','',1,NULL,'NULL','no'),(59,'ndjln','djsak',NULL,'2014-06-14','2014-06-27','',1,NULL,'NULL','no'),(60,'ndjlndasdas','djsak',NULL,'2014-06-14','2014-06-27','',1,NULL,'NULL','no'),(62,'ndjlndasdasdnajksl','djsak',NULL,'2014-06-14','2014-06-27','',1,NULL,'NULL','no'),(63,'ndjlndasdasdnajksldsa','djsak',NULL,'2014-06-14','2014-06-27','',1,NULL,'NULL','no'),(64,'Hello Project is Nice','Looks OK calm and composed','ndfjn ndjknda ','2014-06-07','2014-06-13','Out of Scope',1,'No Outcome','NULL','no'),(77,'hs','dsh',NULL,'2014-06-07','2014-06-13','lcknclk',1,'nldkasnlkd','NULL','no'),(89,'Test again check','nice','yesss','2014-06-06','2014-06-07','All',1,'Pending','NULL','no'),(100,'njnjdn','jkfndn',NULL,'2014-06-07','2014-06-13','nlkndjn',1,'njfnkdsj','NULL','no'),(101,'lknlkf','fdlkfn',NULL,'2014-06-07','2014-06-20','njndjnfdjsn',1,'ndjkasbfkhdb','NULL','no'),(104,'ofhduohou','joihfuodho',NULL,'2014-06-07','2014-06-20','njkbdfbdshb',1,'bhabfhdsbjd','NULL','no'),(110,'dsajbd','habfi',NULL,'2014-06-07','2014-06-14','ncjxb',1,'onasobdoas','NULL','no'),(111,'Test This','dskj',NULL,'2014-06-07','2014-06-14','kjbdkasbh',1,'aksdbsak','NULL','no'),(152,'ldnsan','djaksbndkj',NULL,'2014-06-14','2014-06-20','fdgfhgh',1,'hdgasd','NULL','no'),(154,'kdjkjb','dhsjdb',NULL,'2014-06-07','2014-06-14','hdbashvb',1,'bdahsbdh','NULL','yes'),(200,'Great Project','Looks Good','Oh Yes its nice','2014-06-07','2014-06-21','Still not decided',1,'Desktop Project','NULL','no'),(205,'Test Project Entry','cool',NULL,'2014-06-14','2014-06-20','dunno',1,'nothing','NULL','no'),(206,'hdajshdj','dhasbh',NULL,'2014-06-06','2014-06-14','doshuin',1,'iasdiabsi','NULL','no'),(209,'oidjasohuio','dhasuidhiu',NULL,'2014-06-06','2014-06-07','dnasnbdi',1,'dnasdbsia','NULL','no'),(210,'dsjdbh','dhbashb',NULL,'2014-06-07','2014-06-14','jdnsjnbkj',1,'jkdsajkk','NULL','no'),(212,'ndsajkn','jknasjk',NULL,'2014-06-07','2014-06-20','kncdnlk',1,'klnclanl','NULL','no'),(213,'dhausdhiu','dahduasihiu',NULL,'2014-06-07','2014-06-20','ndjksn',1,'kdmsnakld','NULL','no'),(214,'dhshdas','hdashdvhj',NULL,'2014-06-07','2014-06-20','nlndlasnlk',1,'lkndlkasndlsaj','NULL','no'),(220,'thursday','dasbjk',NULL,'2014-06-06','2014-06-21','mdkmnlk',1,'md;aks','NULL','no'),(221,'nnksandkd',';daskndskal',NULL,'2014-06-06','2014-06-21','mdkmnlk',1,'md;aks','NULL','no'),(350,'new form','lkdjslkj',NULL,'2014-06-07','2014-06-13','nklkjn',1,'jnjknj','NULL','no'),(434,'Message Driven Computing','MDC parallel approach','MDC parallel approach is nice','2014-08-01','2014-08-23','Demo',1,'New approach','San jose','no'),(444,'Cloud Computing','Project for Security in Cloud Computing','Security and caching are the goals of this project','2014-08-07','2014-08-23','Data Center',1,'A Cloud Provider','Santa Clara','no'),(999,'sjdhisu','djsadjk',NULL,'2014-06-07','2014-06-14','hduadbiuas',1,'basibdisa','NULL','no'),(1000,'dkaslk','dajsk','jdnasjkdn','2014-09-06','2014-09-18','m,cxn,',1,'XBCZ',',mcxn,','yes'),(1001,'Pattern Matching','Its nice','Awesome idea','2014-09-03','2014-12-16','Web',1,'Nice doc','Lucas Hall',NULL),(1003,'Check new add','Cool','nice and awesome','2014-09-05','2014-09-20','None',1,'None','haha','no'),(1005,'Sarvesh Project','Putting in short description','nice project','2014-09-05','2014-09-13','check',1,'none','nice location',NULL),(1003177,'Mission','Mission is a project for reason','Mission is a project for reason, and many other purposes.','2014-09-06','2014-09-27','Religion',1,'An awareness among people to have faith.','Frugal Lab','no'),(1098040,'Tag Testing','kfjsdlkf','kjklsjkflds','2014-09-05','2014-09-27','lfkdsflkskl',1,'kddjfklds','fksdflksdlfk',NULL),(1273081,'Park Central','jhfjkdsh','kjhdjsakdhjkas','2014-09-06','2014-09-27','fjkshdjk',1,'jdajksdjaks','kkldaskldmsal',NULL),(1303633,'Adding new Project','test','test','2014-09-19','2014-09-27','test',1,'test','test','no'),(1387104,'jhdsjk','klhkdjsahdkja','dmaslk','2014-09-12','2014-09-26','mdasm,d,',1,'lkmlkdasmlkdmnlas','dasl',NULL),(1413092,'test again','ok testing','lets see','2014-09-04','2014-09-20','ok',1,'ok','frugal',NULL),(1565748,'Its me','sdjksd','jdhasjkdsa','2014-09-05','2014-09-27','dskajlk',1,'kdljaslk','nice',NULL),(1615563,'Algorithms Research','Good algo project','Nice to have this','2014-09-05','2014-09-27','In scope',1,'good','Lucas Hall','no'),(1673284,'Shri Ganesh','nice','awesome','2014-09-06','2014-09-20','dkslajlk',1,'jdklasjlda','kdskal',NULL),(1736365,'GOOD GOOD GOOD','jhdjkashdjk','dksmldkm	','2014-09-05','2014-09-27','dshad',1,'jkdhasjkdhjk','ndkfjnkj',NULL),(1835719,'One more chec','ok','ok','2014-09-05','2014-09-27','good',1,'fine','arts',NULL),(1849316,'Mobile App','NIce app to have handy','THis is a good future app','2014-09-05','2014-09-27','none',1,'none','Frugal Lab',NULL),(1904003,'Modified New Project','dashdajksh','jdkhajkdhasjk','2014-09-06','2014-09-27','dhasgjh',1,'jkhdasjkdhka','mdasmd',NULL);
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
INSERT INTO `project_category_map` VALUES (2,'Bio Engineering'),(22,'Bio Engineering'),(23,'Bio Engineering'),(24,'Bio Engineering'),(28,'Bio Engineering'),(58,'Bio Engineering'),(104,'Bio Engineering'),(111,'Bio Engineering'),(3,'Civil Engineering'),(23,'Civil Engineering'),(24,'Civil Engineering'),(28,'Civil Engineering'),(50,'Civil Engineering'),(57,'Civil Engineering'),(77,'Civil Engineering'),(89,'Civil Engineering'),(101,'Civil Engineering'),(104,'Civil Engineering'),(110,'Civil Engineering'),(111,'Civil Engineering'),(152,'Civil Engineering'),(154,'Civil Engineering'),(200,'Civil Engineering'),(205,'Civil Engineering'),(206,'Civil Engineering'),(209,'Civil Engineering'),(210,'Civil Engineering'),(220,'Civil Engineering'),(221,'Civil Engineering'),(350,'Civil Engineering'),(444,'Civil Engineering'),(999,'Civil Engineering'),(1000,'Civil Engineering'),(1001,'Civil Engineering'),(1003,'Civil Engineering'),(1303633,'Civil Engineering'),(1387104,'Civil Engineering'),(1565748,'Civil Engineering'),(1615563,'Civil Engineering'),(1673284,'Civil Engineering'),(1736365,'Civil Engineering'),(1835719,'Civil Engineering'),(1849316,'Civil Engineering'),(1904003,'Civil Engineering'),(2,'Computer Engineering'),(4,'Computer Engineering'),(22,'Computer Engineering'),(23,'Computer Engineering'),(58,'Computer Engineering'),(64,'Computer Engineering'),(89,'Computer Engineering'),(154,'Computer Engineering'),(200,'Computer Engineering'),(206,'Computer Engineering'),(209,'Computer Engineering'),(210,'Computer Engineering'),(350,'Computer Engineering'),(434,'Computer Engineering'),(444,'Computer Engineering'),(1000,'Computer Engineering'),(1001,'Computer Engineering'),(1003,'Computer Engineering'),(1005,'Computer Engineering'),(1003177,'Computer Engineering'),(1098040,'Computer Engineering'),(1273081,'Computer Engineering'),(1303633,'Computer Engineering'),(1413092,'Computer Engineering'),(1565748,'Computer Engineering'),(1615563,'Computer Engineering'),(1849316,'Computer Engineering'),(1,'Electrical Engineering'),(2,'Electrical Engineering'),(64,'Electrical Engineering'),(200,'Electrical Engineering'),(212,'Electrical Engineering'),(213,'Electrical Engineering'),(214,'Electrical Engineering'),(1615563,'Electrical Engineering'),(1736365,'Electrical Engineering'),(5,'Mechanical Engineering'),(23,'Mechanical Engineering'),(59,'Mechanical Engineering'),(60,'Mechanical Engineering'),(62,'Mechanical Engineering'),(63,'Mechanical Engineering'),(64,'Mechanical Engineering'),(205,'Mechanical Engineering'),(212,'Mechanical Engineering'),(213,'Mechanical Engineering'),(214,'Mechanical Engineering'),(434,'Mechanical Engineering'),(1003177,'Mechanical Engineering'),(1615563,'Mechanical Engineering');
/*!40000 ALTER TABLE `project_category_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_files_map`
--

DROP TABLE IF EXISTS `project_files_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_files_map` (
  `projectid` int(11) NOT NULL DEFAULT '0',
  `filetypeid` int(11) NOT NULL DEFAULT '0',
  `filename` varchar(50) NOT NULL DEFAULT '',
  `filepath` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`projectid`,`filetypeid`,`filename`,`filepath`),
  KEY `FK_project_files_map_filetypeid` (`filetypeid`),
  CONSTRAINT `FK_project_files_map_filetypeid` FOREIGN KEY (`filetypeid`) REFERENCES `filetypes` (`id`),
  CONSTRAINT `FK_project_files_map_projectid` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`),
  CONSTRAINT `project_files_map_ibfk_1` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`),
  CONSTRAINT `project_files_map_ibfk_2` FOREIGN KEY (`filetypeid`) REFERENCES `filetypes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_files_map`
--

LOCK TABLES `project_files_map` WRITE;
/*!40000 ALTER TABLE `project_files_map` DISABLE KEYS */;
INSERT INTO `project_files_map` VALUES (1673284,2,'JSR','F:\\frugallab.sql'),(1904003,2,'mnp one','F:\\frugal-1.sql'),(1003177,4,'dump sql','F:\\dump.sql'),(1098040,4,'dfs','C:\\Users\\Jaishreeganesh\\Documents\\pgadmin.log'),(1273081,5,'im 1','F:\\Daffodils.jpg'),(1673284,5,'JGD','F:\\dump.sql'),(1003177,6,'daffodils image','F:\\Daffodils.jpg'),(1273081,6,'im 2','F:\\daffodils-1.jpg'),(1904003,6,'Pattern 2','F:\\pattern2.jpg'),(434,12,'XML 1','F:\\frugallab-new.sql'),(1303633,12,'','F:\\frugal-1.sql'),(1904003,14,'Daffodils','F:\\Daffodils.jpg');
/*!40000 ALTER TABLE `project_files_map` ENABLE KEYS */;
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
  CONSTRAINT `FK_project_participants_designation` FOREIGN KEY (`designation`) REFERENCES `participant_designation` (`id`),
  CONSTRAINT `FK_project_participants_participant_id` FOREIGN KEY (`participant_id`) REFERENCES `participants` (`id`),
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
INSERT INTO `project_participants` VALUES (1,1,1),(1,2,1),(2,4,1),(2,5,1),(2,6,1),(2,7,1),(2,8,1),(3,5,1),(3,11,1),(3,12,1),(3,13,1),(4,2,1),(4,5,1),(4,11,1),(4,12,1),(4,13,1),(4,15,1),(4,16,1),(4,17,1),(5,4,1),(5,19,1),(5,20,1),(5,21,1),(19,12,1),(89,2,1),(89,5,1),(89,6,1),(89,11,1),(89,12,1),(89,13,1),(89,15,1),(89,16,1),(89,17,1),(111,1,1),(111,5,1),(154,1,1),(200,3,1),(205,6,1),(206,2,1),(210,3,1),(444,13,1),(444,25,1),(1003,1,1),(1003177,13,1),(1303633,47,1),(1303633,48,1),(1413092,10,1),(1615563,37,1),(1615563,45,1),(1615563,46,1),(1849316,10,1),(1,3,2),(2,3,2),(2,9,2),(2,10,2),(3,6,2),(3,14,2),(3,23,2),(4,9,2),(4,14,2),(5,22,2),(19,23,2),(89,1,2),(89,2,2),(89,9,2),(89,14,2),(110,3,2),(110,6,2),(111,3,2),(205,4,2),(213,6,2),(220,4,2),(221,4,2),(434,1,2),(1000,3,2),(1001,1,2),(1001,5,2),(1005,3,2),(1003177,15,2),(1003177,21,2),(1273081,13,2),(1303633,37,2),(1413092,17,2),(1565748,1,2),(1565748,17,2),(1615563,15,2),(1615563,31,2),(1736365,1,2),(3,1,3),(3,2,3),(3,3,3),(3,5,3),(3,6,3),(4,2,3),(4,5,3),(4,18,3),(19,1,3),(19,2,3),(19,3,3),(19,5,3),(19,6,3),(64,1,3),(89,1,3),(89,2,3),(89,3,3),(89,5,3),(89,18,3),(104,2,3),(110,1,3),(110,2,3),(200,5,3),(209,1,3),(210,1,3),(210,2,3),(210,5,3),(212,1,3),(212,4,3),(213,2,3),(214,1,3),(214,2,3),(214,3,3),(214,5,3),(214,6,3),(350,2,3),(444,26,3),(1098040,13,3),(1273081,5,3),(1387104,7,3),(1615563,44,3),(1673284,7,3),(1736365,5,3),(1835719,13,3),(1904003,7,3),(1904003,9,3);
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
INSERT INTO `project_status_map` VALUES (1,'Completed'),(4,'Completed'),(5,'Completed'),(18,'Completed'),(19,'Completed'),(20,'Completed'),(22,'Completed'),(23,'Completed'),(24,'Completed'),(28,'Completed'),(57,'Completed'),(58,'Completed'),(59,'Completed'),(60,'Completed'),(62,'Completed'),(63,'Completed'),(77,'Completed'),(100,'Completed'),(101,'Completed'),(104,'Completed'),(110,'Completed'),(111,'Completed'),(152,'Completed'),(209,'Completed'),(212,'Completed'),(213,'Completed'),(214,'Completed'),(220,'Completed'),(221,'Completed'),(350,'Completed'),(999,'Completed'),(1000,'Completed'),(1003,'Completed'),(1005,'Completed'),(1098040,'Completed'),(1273081,'Completed'),(1303633,'Completed'),(1387104,'Completed'),(1565748,'Completed'),(1673284,'Completed'),(1736365,'Completed'),(1835719,'Completed'),(1904003,'Completed'),(3,'Dormant'),(21,'Dormant'),(50,'Dormant'),(64,'Dormant'),(154,'Dormant'),(205,'Dormant'),(206,'Dormant'),(434,'Dormant'),(1615563,'Dormant'),(1849316,'Dormant'),(2,'In Progress'),(89,'In Progress'),(200,'In Progress'),(210,'In Progress'),(444,'In Progress'),(1001,'In Progress'),(1003177,'In Progress'),(1413092,'In Progress');
/*!40000 ALTER TABLE `project_status_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_tag_map`
--

DROP TABLE IF EXISTS `project_tag_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_tag_map` (
  `projectid` int(11) NOT NULL,
  `tagname` varchar(100) NOT NULL,
  PRIMARY KEY (`projectid`,`tagname`),
  KEY `FK_project_tag_map_tagname` (`tagname`),
  CONSTRAINT `FK_project_tag_map_projectid` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`),
  CONSTRAINT `project_tag_map_ibfk_1` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `project_tag_map_ibfk_2` FOREIGN KEY (`tagname`) REFERENCES `tags` (`tagname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_tag_map`
--

LOCK TABLES `project_tag_map` WRITE;
/*!40000 ALTER TABLE `project_tag_map` DISABLE KEYS */;
INSERT INTO `project_tag_map` VALUES (1273081,'Computer'),(1303633,'Computer'),(1273081,'Electrical'),(1003177,'Humanity'),(1003177,'Religion');
/*!40000 ALTER TABLE `project_tag_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectfiles`
--

DROP TABLE IF EXISTS `projectfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectfiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `filepath` varchar(255) DEFAULT NULL,
  `filetypeid` int(11) DEFAULT NULL,
  `projectid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_projectfiles_projectid` (`projectid`),
  KEY `FK_projectfiles_filetypeid` (`filetypeid`),
  CONSTRAINT `FK_projectfiles_filetypeid` FOREIGN KEY (`filetypeid`) REFERENCES `filetypes` (`id`),
  CONSTRAINT `FK_projectfiles_projectid` FOREIGN KEY (`projectid`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectfiles`
--

LOCK TABLES `projectfiles` WRITE;
/*!40000 ALTER TABLE `projectfiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectfiles` ENABLE KEYS */;
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
INSERT INTO `tags` VALUES ('Algorithms'),('Computer'),('Electrical'),('Humanity'),('Mechanical'),('Religion'),('Rocket');
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
INSERT INTO `users` VALUES ('ambati','rayudu','ambati@gmail.com','ambati','ambati@44',89383928,1),('Dipti','Kanthilal','itzdipti@gmail.com','dipti44','Dipti@123',8888888888,1),('irfan','pathan','irfan@gmail.com','irfan','irfan@44',889898989,1),('m','m','me','m','m',1,1),('Sachin','Tendulkar','sachin@gmail.com','sachin44','sachin44',87878787,1),('Sarvesh','Sharma 3','itzsarvo@gmail.com','sarvo44','Sarvesh@123',9999999999,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles_map`
--

DROP TABLE IF EXISTS `users_roles_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles_map` (
  `username` varchar(50) NOT NULL DEFAULT '',
  `role_name` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`username`,`role_name`),
  KEY `FK_users_roles_map_role_name` (`role_name`),
  CONSTRAINT `FK_users_roles_map_role_name` FOREIGN KEY (`role_name`) REFERENCES `user_roles` (`name`),
  CONSTRAINT `users_roles_map_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `users_roles_map_ibfk_2` FOREIGN KEY (`role_name`) REFERENCES `user_roles` (`name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles_map`
--

LOCK TABLES `users_roles_map` WRITE;
/*!40000 ALTER TABLE `users_roles_map` DISABLE KEYS */;
INSERT INTO `users_roles_map` VALUES ('ambati','Administrator'),('dipti44','Administrator'),('irfan','Administrator'),('m','Administrator'),('sarvo44','Administrator'),('sachin44','Viewer');
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

-- Dump completed on 2014-09-22 15:06:23
