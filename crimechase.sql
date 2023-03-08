-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: crimechase
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `crime`
--

DROP TABLE IF EXISTS `crime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crime` (
  `crimeID` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `place` varchar(20) NOT NULL,
  `description` varchar(40) NOT NULL,
  `Detailed_description` varchar(140) NOT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`crimeID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crime`
--

LOCK TABLES `crime` WRITE;
/*!40000 ALTER TABLE `crime` DISABLE KEYS */;
INSERT INTO `crime` VALUES (1,'2022-01-01','New York','Robbery','A person stole money from a bank','Solved'),(2,'2022-01-02','Los Angeles','Assault','A person attacked another person with a knife','Closed'),(3,'2022-01-03','Chicago','Burglary','A person broke into a home and stole valuables','Open'),(4,'2022-01-04','Houston','Vandalism','A person damaged public property','Closed'),(5,'2022-01-05','Philadelphia','Arson','A building was set on fire','Open'),(6,'2023-02-05','Park Street','Robbery','Stolen jewelry worth $10,000','unsolved'),(7,'2023-02-10','Main Street','Homicide','Murder of a local businessman','solved'),(8,'2023-02-15','Oak Avenue','Assault','Victim was hospitalized with serious injuries','unsolved'),(9,'2023-02-20','Maple Road','Burglary','Homeowner reported missing cash and electronics','unsolved'),(10,'2023-02-25','Elm Street','Vandalism','Several cars were spray-painted','unsolved'),(11,'2021-12-01','Baker Street','Robbery','Stole cash and jewelry worth $50,000','Pending'),(12,'2021-12-02','Park Lane','Assault','Attacked victim with a baseball bat','Solved'),(13,'2021-12-03','Regent Street','Burglary','Stole electronics and jewelry worth $20,000','Pending'),(14,'2021-12-04','Baker Street','Assault','Beat victim unconscious','Pending'),(15,'2021-12-05','Oxford Street','Robbery','Stole cash and electronics worth $30,000','Solved'),(16,'2021-12-06','Park Lane','Burglary','Stole electronics and jewelry worth $40,000','Solved'),(17,'2021-12-07','Regent Street','Assault','Punched victim in the face','Pending'),(18,'2021-12-08','Baker Street','Robbery','Stole cash and jewelry worth $60,000','Pending'),(19,'2021-12-09','Oxford Street','Assault','Threatened victim with a knife','Pending'),(20,'2021-12-10','Regent Street','Robbery','Stole cash and electronics worth $25,000','Solved');
/*!40000 ALTER TABLE `crime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crime_criminal`
--

DROP TABLE IF EXISTS `crime_criminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crime_criminal` (
  `crime_criminal_id` int NOT NULL AUTO_INCREMENT,
  `crimeid` int NOT NULL,
  `criminalid` int NOT NULL,
  PRIMARY KEY (`crime_criminal_id`),
  KEY `crimeid` (`crimeid`),
  KEY `criminalid` (`criminalid`),
  CONSTRAINT `crime_criminal_ibfk_1` FOREIGN KEY (`crimeid`) REFERENCES `crime` (`crimeID`),
  CONSTRAINT `crime_criminal_ibfk_2` FOREIGN KEY (`criminalid`) REFERENCES `criminal` (`criminalid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crime_criminal`
--

LOCK TABLES `crime_criminal` WRITE;
/*!40000 ALTER TABLE `crime_criminal` DISABLE KEYS */;
INSERT INTO `crime_criminal` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,2,1),(7,3,1),(8,4,1),(9,1,25);
/*!40000 ALTER TABLE `crime_criminal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criminal`
--

DROP TABLE IF EXISTS `criminal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `criminal` (
  `criminalid` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `age` int NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(30) NOT NULL,
  `idmark` varchar(50) NOT NULL,
  PRIMARY KEY (`criminalid`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criminal`
--

LOCK TABLES `criminal` WRITE;
/*!40000 ALTER TABLE `criminal` DISABLE KEYS */;
INSERT INTO `criminal` VALUES (1,'John Smith',30,'Male','123 Main St','Tattoo on left arm'),(2,'Sarah Johnson',25,'Female','456 Maple Ave','Scar above right eyebrow'),(3,'Michael Lee',42,'Male','789 Oak St','Missing finger on right hand'),(4,'Jessica',30,'Female','22 Baker Street, London','Mole on the right cheek'),(5,'John',45,'Male','15 High Street, Manchester','Scar on the left hand'),(6,'Jackie Chan',65,'Male','123 Main Street','Missing finger on left hand'),(7,'Maggie Simpson',3,'Female','742 Evergreen Terrace','Pacifier in mouth'),(8,'Darth Vader',54,'Male','Death Star','Breathing apparatus'),(9,'Cruella De Vil',52,'Female','13 Forest Lane','White streak in hair'),(10,'Hannibal Lecter',63,'Male','1113 Baltimore St','Polydactyly'),(11,'sahil',15,'male','worli','tatoo'),(12,'sahil',15,'male','worli','tattoo'),(13,'Rakesh',34,'male','GandhiNagar','Bruises'),(24,'rushi',20,'male','worli','scar'),(25,'rudra',20,'male','worli','scar');
/*!40000 ALTER TABLE `criminal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-26 22:29:58
