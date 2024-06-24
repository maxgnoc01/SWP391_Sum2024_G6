CREATE DATABASE  IF NOT EXISTS `swp391` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `swp391`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: swp391
-- ------------------------------------------------------
-- Server version	8.4.0

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
-- Table structure for table `class_detail`
--

DROP TABLE IF EXISTS `class_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `class_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3iqjfyg49mw43ta4x8kxor3h4` (`class_id`),
  CONSTRAINT `FK3iqjfyg49mw43ta4x8kxor3h4` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_detail`
--

LOCK TABLES `class_detail` WRITE;
/*!40000 ALTER TABLE `class_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) NOT NULL,
  `course_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkhwfqb4rahpl3q2w4jw5k7jlp` (`course_id`),
  CONSTRAINT `FKkhwfqb4rahpl3q2w4jw5k7jlp` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (91,'SE1801-NET',1),(92,'SE1803-NET',1),(93,'SE1804-NET',1),(94,'SE1805-NET',1),(95,'SE1806-NET',2),(96,'SE1807-NET',2),(97,'SE1808-NET',2),(98,'SE1809-NET',2),(99,'SE1810-NET',3),(100,'SE1811-NET',3),(101,'SE1812-NET',3),(102,'SE1813-NET',3),(103,'SE1814-NET',2),(104,'SE1815-NET',5),(105,'SE1816-NET',8),(106,'SE1817-NET',9),(107,'SE1818-NET',5),(108,'SE1819-NET',5),(109,'SE1820-NET',5),(110,'SE1821-NET',5),(111,'SE1822-NET',6),(112,'SE1823-NET',6),(113,'SE1824-NET',6),(114,'SE1825-NET',6),(115,'SE1826-NJ',7),(116,'SE1827-NJ',7),(117,'SE1828-NJ',7),(118,'SE1829-NJ',7),(119,'SE1830-NJ',8),(120,'SE1831-NJ',8),(121,'SE1834-NJ',8),(122,'SE1835-NJ',8),(123,'SE1836-NJ',9),(124,'SE1837-NJ',9),(125,'SE1838-NJ',9),(126,'SE1839-NJ',9),(127,'SE1840-KS',10),(128,'SE1841-KS',10),(129,'SE1842-KS',10),(130,'SE1845-JS1',10),(131,'SE1846-JS1',11),(132,'SE1847-JS2',11),(133,'SE1848-SAP',11),(134,'SE1849-SAP',11),(135,'SE1850-SAP',12);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) NOT NULL,
  `semester_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlmyb73uymsfhqh374ndr3n4c0` (`semester_id`),
  CONSTRAINT `FKlmyb73uymsfhqh374ndr3n4c0` FOREIGN KEY (`semester_id`) REFERENCES `semester` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Mathematics 101ds',1),(2,'Physics 101',1),(3,'Mathematics 101',1),(5,'Chemistry 101',2),(6,'Biology 101',2),(7,'Computer Science 101',3),(8,'History 101',3),(9,'Geography 101',4),(10,'English Literature 101',4),(11,'Philosophy 101',5),(12,'Psychology 101',5),(13,'ds',1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `correct_answer` char(1) NOT NULL,
  `optiona` varchar(255) DEFAULT NULL,
  `optionb` varchar(255) DEFAULT NULL,
  `optionc` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `quiz_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn3gvco4b0kewxc0bywf1igfms` (`quiz_id`),
  CONSTRAINT `FKn3gvco4b0kewxc0bywf1igfms` FOREIGN KEY (`quiz_id`) REFERENCES `quizzes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (10,'A','21','2','e','ds',4),(11,'A','2','e3','3r1','1',4),(12,'B','ewq','21','ưqe','daá',5),(13,'B','ew','21e','ew','e12',5);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz_result`
--

DROP TABLE IF EXISTS `quiz_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz_result` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `score` int NOT NULL,
  `quiz_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnm9n99phtdm1dhkwlr24976gm` (`quiz_id`),
  KEY `FKnuben697e3lorbhgsbif22f2t` (`user_id`),
  CONSTRAINT `FKnm9n99phtdm1dhkwlr24976gm` FOREIGN KEY (`quiz_id`) REFERENCES `quizzes` (`id`),
  CONSTRAINT `FKnuben697e3lorbhgsbif22f2t` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz_result`
--

LOCK TABLES `quiz_result` WRITE;
/*!40000 ALTER TABLE `quiz_result` DISABLE KEYS */;
INSERT INTO `quiz_result` VALUES (5,1,4,9),(6,0,4,9);
/*!40000 ALTER TABLE `quiz_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quizzes`
--

DROP TABLE IF EXISTS `quizzes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quizzes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `duration` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quizzes`
--

LOCK TABLES `quizzes` WRITE;
/*!40000 ALTER TABLE `quizzes` DISABLE KEYS */;
INSERT INTO `quizzes` VALUES (4,12,'dsa'),(5,123,'sa');
/*!40000 ALTER TABLE `quizzes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester`
--

DROP TABLE IF EXISTS `semester`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semester` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `end_date` datetime(6) NOT NULL,
  `semester_name` varchar(255) NOT NULL,
  `start_date` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jcw9rj74tioaxe0e57px2xqc2` (`semester_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester`
--

LOCK TABLES `semester` WRITE;
/*!40000 ALTER TABLE `semester` DISABLE KEYS */;
INSERT INTO `semester` VALUES (1,'2021-05-15 00:00:00.000000','Spring 2021','2021-01-01 00:00:00.000000'),(2,'2021-08-15 00:00:00.000000','Summer 2021','2021-06-01 00:00:00.000000'),(3,'2021-12-15 00:00:00.000000','Fall 2021','2021-09-01 00:00:00.000000'),(4,'2022-01-15 00:00:00.000000','Winter 2021','2021-12-16 00:00:00.000000'),(5,'2022-05-15 00:00:00.000000','Spring 2022','2022-01-16 00:00:00.000000'),(6,'2022-08-15 00:00:00.000000','Summer 2022','2022-06-01 00:00:00.000000'),(7,'2022-12-15 00:00:00.000000','Fall 2022','2022-09-01 00:00:00.000000'),(8,'2023-01-15 00:00:00.000000','Winter 2022','2022-12-16 00:00:00.000000'),(9,'2023-05-15 00:00:00.000000','Spring 2023','2023-01-16 00:00:00.000000'),(10,'2023-08-15 00:00:00.000000','Summer 2023','2023-06-01 00:00:00.000000'),(13,'2024-06-19 00:00:00.000000','asd 2024','2024-06-25 00:00:00.000000'),(15,'2024-06-25 00:00:00.000000','heipsed','2024-06-19 00:00:00.000000');
/*!40000 ALTER TABLE `semester` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `provider` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'abcdf@gmail.com','abcdfabcdf','ROLE_ADMIN','abcdf@gmail.com',NULL),(2,'hocsinh@gmail.com','hocsinhhocsinh','ROLE_USER','hocsinh@gmail.com',NULL),(3,'admin@example.com','password123','ROLE_MANAGER','admin@example.com',NULL),(4,'manager@example.com','password123','ROLE_MANAGER','manager@example.com',NULL),(5,'teacher@example.com','password123','ROLE_TEACHER','teacher@example.com',NULL),(6,'student1@example.com','password123','ROLE_STUDENT','student1@example.com',NULL),(7,'student2@example.com','password123','ROLE_STUDENT','student2@example.com',NULL),(8,'pxlnhw984@gmail.com','123456789','ROLE_USER','pxlnhw984@gmail.com',NULL),(9,'jigita7488@usharer.com','123','ROLE_USER','jigita7488@usharer.com',NULL),(10,'hiepduy192893@gmail.com','123465','ROLE_MANAGER','hiepduy192893@gmail.com',NULL),(11,'trungthanh26148@gmail.com',NULL,'ROLE_USER','trungthanh26148@gmail.com',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-24 21:25:35
