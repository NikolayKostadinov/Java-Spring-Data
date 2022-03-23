-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: 04_hospital_db
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses`
    DISABLE KEYS */;
INSERT INTO `addresses`
VALUES (1, 'Meden Rudnik, bl.18, vh.2', 2);
/*!40000 ALTER TABLE `addresses`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `diagnoses`
--

LOCK TABLES `diagnoses` WRITE;
/*!40000 ALTER TABLE `diagnoses`
    DISABLE KEYS */;
INSERT INTO `diagnoses`
VALUES (2, '6te mine', 'Gripche'),
       (3, 'n.p.', 'Grip');
/*!40000 ALTER TABLE `diagnoses`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `medicaments`
--

LOCK TABLES `medicaments` WRITE;
/*!40000 ALTER TABLE `medicaments`
    DISABLE KEYS */;
INSERT INTO `medicaments`
VALUES (1, 'Aspirin'),
       (2, 'Vitamin C');
/*!40000 ALTER TABLE `medicaments`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients`
    DISABLE KEYS */;
INSERT INTO `patients`
VALUES (1, '1977-11-24 00:00:00.000000', 'test@test.com', 'Ivan', _binary '', 'Ivanov', NULL, 1);
/*!40000 ALTER TABLE `patients`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `prescription`
--

LOCK TABLES `prescription` WRITE;
/*!40000 ALTER TABLE `prescription`
    DISABLE KEYS */;
INSERT INTO `prescription`
VALUES (1, 2),
       (2, 3);
/*!40000 ALTER TABLE `prescription`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `prescriptions_row`
--

LOCK TABLES `prescriptions_row` WRITE;
/*!40000 ALTER TABLE `prescriptions_row`
    DISABLE KEYS */;
INSERT INTO `prescriptions_row`
VALUES (1, 2, 3, 2, 1),
       (2, 2, 3, 2, 2),
       (3, 1, 2, 1, 2);
/*!40000 ALTER TABLE `prescriptions_row`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `towns`
--

LOCK TABLES `towns` WRITE;
/*!40000 ALTER TABLE `towns`
    DISABLE KEYS */;
INSERT INTO `towns`
VALUES (1, 'Sofia'),
       (2, 'Burgas'),
       (3, 'Varna');
/*!40000 ALTER TABLE `towns`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `visitations`
--

LOCK TABLES `visitations` WRITE;
/*!40000 ALTER TABLE `visitations`
    DISABLE KEYS */;
INSERT INTO `visitations`
VALUES (1, 'Ima temperatura', '2022-03-01 08:40:00.000000', 2, 1),
       (2, 'Proba', '2022-03-01 09:30:00.000000', 3, 1);
/*!40000 ALTER TABLE `visitations`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2022-03-02 11:05:14
