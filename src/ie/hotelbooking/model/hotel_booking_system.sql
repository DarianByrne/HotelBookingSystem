-- MySQL dump 10.13  Distrib 8.0.40, for Linux (x86_64)
--
-- Host: localhost    Database: hotel_booking_system
-- ------------------------------------------------------
-- Server version	8.0.40-0ubuntu0.24.04.1

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
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `bookingID` int NOT NULL AUTO_INCREMENT,
  `paymentID` int DEFAULT NULL,
  `customerID` int DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  KEY `paymentID` (`paymentID`),
  KEY `customerID` (`customerID`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`paymentID`) REFERENCES `payment` (`paymentID`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conference_booking`
--

DROP TABLE IF EXISTS `conference_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conference_booking` (
  `bookingID` int NOT NULL,
  `venueName` varchar(255) DEFAULT NULL,
  `arrivalDate` date DEFAULT NULL,
  `departureDate` date DEFAULT NULL,
  `arrivalTime` time DEFAULT NULL,
  `departureTime` time DEFAULT NULL,
  `eventType` varchar(255) DEFAULT NULL,
  `numberOfAttendees` int DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  CONSTRAINT `conference_booking_ibfk_1` FOREIGN KEY (`bookingID`) REFERENCES `booking` (`bookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conference_booking`
--

LOCK TABLES `conference_booking` WRITE;
/*!40000 ALTER TABLE `conference_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `conference_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gym_booking`
--

DROP TABLE IF EXISTS `gym_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gym_booking` (
  `bookingID` int NOT NULL,
  `date` date DEFAULT NULL,
  `arrivalTime` time DEFAULT NULL,
  `departureTime` time DEFAULT NULL,
  `gymSessionID` int DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  CONSTRAINT `gym_booking_ibfk_1` FOREIGN KEY (`bookingID`) REFERENCES `booking` (`bookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gym_booking`
--

LOCK TABLES `gym_booking` WRITE;
/*!40000 ALTER TABLE `gym_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `gym_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gym_pass`
--

DROP TABLE IF EXISTS `gym_pass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gym_pass` (
  `bookingID` int NOT NULL,
  `passID` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  CONSTRAINT `gym_pass_ibfk_1` FOREIGN KEY (`bookingID`) REFERENCES `booking` (`bookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gym_pass`
--

LOCK TABLES `gym_pass` WRITE;
/*!40000 ALTER TABLE `gym_pass` DISABLE KEYS */;
/*!40000 ALTER TABLE `gym_pass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `paymentID` int NOT NULL AUTO_INCREMENT,
  `customerID` int DEFAULT NULL,
  `cardNumber` int DEFAULT NULL,
  `cardCVV` int DEFAULT NULL,
  `cardExpiryDate` date DEFAULT NULL,
  `cardHolderName` varchar(255) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  PRIMARY KEY (`paymentID`),
  KEY `customerID` (`customerID`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_reservation`
--

DROP TABLE IF EXISTS `restaurant_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `restaurant_reservation` (
  `bookingID` int NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `numberOfGuests` int DEFAULT NULL,
  `tableNumber` int DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  CONSTRAINT `restaurant_reservation_ibfk_1` FOREIGN KEY (`bookingID`) REFERENCES `booking` (`bookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_reservation`
--

LOCK TABLES `restaurant_reservation` WRITE;
/*!40000 ALTER TABLE `restaurant_reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `restaurant_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_booking`
--

DROP TABLE IF EXISTS `room_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_booking` (
  `bookingID` int NOT NULL,
  `roomNumber` varchar(255) DEFAULT NULL,
  `arrivalDate` date DEFAULT NULL,
  `departureDate` date DEFAULT NULL,
  `numberOfGuests` int DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  CONSTRAINT `room_booking_ibfk_1` FOREIGN KEY (`bookingID`) REFERENCES `booking` (`bookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_booking`
--

LOCK TABLES `room_booking` WRITE;
/*!40000 ALTER TABLE `room_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `room_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spa_booking`
--

DROP TABLE IF EXISTS `spa_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spa_booking` (
  `bookingID` int NOT NULL,
  `date` date DEFAULT NULL,
  `arrivalTime` time DEFAULT NULL,
  `departureTime` time DEFAULT NULL,
  `numberOfGuests` int DEFAULT NULL,
  `spaServiceID` int DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  CONSTRAINT `spa_booking_ibfk_1` FOREIGN KEY (`bookingID`) REFERENCES `booking` (`bookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spa_booking`
--

LOCK TABLES `spa_booking` WRITE;
/*!40000 ALTER TABLE `spa_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `spa_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wedding_booking`
--

DROP TABLE IF EXISTS `wedding_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wedding_booking` (
  `bookingID` int NOT NULL,
  `venueName` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `numberOfGuests` int DEFAULT NULL,
  `civil` tinyint(1) DEFAULT NULL,
  `indoor` tinyint(1) DEFAULT NULL,
  `afterParty` tinyint(1) DEFAULT NULL,
  `dinner` tinyint(1) DEFAULT NULL,
  `groomName` varchar(255) DEFAULT NULL,
  `brideName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookingID`),
  CONSTRAINT `wedding_booking_ibfk_1` FOREIGN KEY (`bookingID`) REFERENCES `booking` (`bookingID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wedding_booking`
--

LOCK TABLES `wedding_booking` WRITE;
/*!40000 ALTER TABLE `wedding_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `wedding_booking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-06 16:39:56
