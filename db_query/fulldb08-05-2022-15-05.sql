#
# TABLE STRUCTURE FOR: tblBill
#

DROP TABLE IF EXISTS `tblBill`;

CREATE TABLE `tblBill` (
  `ID` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `discount` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `paymentDate` date NOT NULL,
  `paymentType` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tblCardID` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tbleUserID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKtblBill846082` (`tbleUserID`),
  KEY `FKtblBill196276` (`tblCardID`),
  CONSTRAINT `FKtblBill196276` FOREIGN KEY (`tblCardID`) REFERENCES `tblCard` (`ID`),
  CONSTRAINT `FKtblBill846082` FOREIGN KEY (`tbleUserID`) REFERENCES `tbleUser` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# TABLE STRUCTURE FOR: tblCard
#

DROP TABLE IF EXISTS `tblCard`;

CREATE TABLE `tblCard` (
  `ID` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `point` int(10) NOT NULL,
  `tblClientID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKtblCard461667` (`tblClientID`),
  CONSTRAINT `FKtblCard461667` FOREIGN KEY (`tblClientID`) REFERENCES `tblClient` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tblCard` (`ID`, `point`, `tblClientID`) VALUES ('2', 20, 5);
INSERT INTO `tblCard` (`ID`, `point`, `tblClientID`) VALUES ('3', 20, 2);
INSERT INTO `tblCard` (`ID`, `point`, `tblClientID`) VALUES ('4', 30, 1);
INSERT INTO `tblCard` (`ID`, `point`, `tblClientID`) VALUES ('8', 30, 3);
INSERT INTO `tblCard` (`ID`, `point`, `tblClientID`) VALUES ('9', 50, 4);


#
# TABLE STRUCTURE FOR: tblClient
#

DROP TABLE IF EXISTS `tblClient`;

CREATE TABLE `tblClient` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dateOfBirth` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tblClient` (`ID`, `name`, `dateOfBirth`) VALUES (1, 'Miss Ashtyn Lemke', '1999-10-28');
INSERT INTO `tblClient` (`ID`, `name`, `dateOfBirth`) VALUES (2, 'Shany Frami II', '1981-09-15');
INSERT INTO `tblClient` (`ID`, `name`, `dateOfBirth`) VALUES (3, 'Mr. Jarrell Strosin', '1990-09-26');
INSERT INTO `tblClient` (`ID`, `name`, `dateOfBirth`) VALUES (4, 'Dr. Terrell Lynch', '1984-03-21');
INSERT INTO `tblClient` (`ID`, `name`, `dateOfBirth`) VALUES (5, 'Rosella Ruecker I', '1988-06-27');


#
# TABLE STRUCTURE FOR: tblFilm
#

DROP TABLE IF EXISTS `tblFilm`;

CREATE TABLE `tblFilm` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `year` int(10) NOT NULL,
  `studio` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ageLimit` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tblFilm` (`ID`, `name`, `type`, `year`, `studio`, `ageLimit`) VALUES (1, 'JUSTICE LEAGUE', 'ADVENTURE', 2022, 'DC', 15);
INSERT INTO `tblFilm` (`ID`, `name`, `type`, `year`, `studio`, `ageLimit`) VALUES (2, 'WANDA VISION', 'FICTION', 2022, 'DC', 14);
INSERT INTO `tblFilm` (`ID`, `name`, `type`, `year`, `studio`, `ageLimit`) VALUES (3, 'AQUAMAN', 'ACTION', 2021, 'MARVEL', 14);
INSERT INTO `tblFilm` (`ID`, `name`, `type`, `year`, `studio`, `ageLimit`) VALUES (4, 'DOCTOR STRANGE', 'ACTION', 2018, 'MARVEL', 12);
INSERT INTO `tblFilm` (`ID`, `name`, `type`, `year`, `studio`, `ageLimit`) VALUES (5, 'BATMAN', 'ACTION', 2018, 'DC', 14);


#
# TABLE STRUCTURE FOR: tblFilmSet
#

DROP TABLE IF EXISTS `tblFilmSet`;

CREATE TABLE `tblFilmSet` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `cost` int(10) NOT NULL,
  `startTime` date NOT NULL,
  `tbRoomID` int(10) NOT NULL,
  `tblFilmID` int(10) NOT NULL,
  `tblScheduleID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKtblFilmSet666796` (`tblScheduleID`),
  KEY `FKtblFilmSet489349` (`tbRoomID`),
  KEY `FKtblFilmSet87838` (`tblFilmID`),
  CONSTRAINT `FKtblFilmSet489349` FOREIGN KEY (`tbRoomID`) REFERENCES `tblRoom` (`ID`),
  CONSTRAINT `FKtblFilmSet666796` FOREIGN KEY (`tblScheduleID`) REFERENCES `tblSchedule` (`ID`),
  CONSTRAINT `FKtblFilmSet87838` FOREIGN KEY (`tblFilmID`) REFERENCES `tblFilm` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# TABLE STRUCTURE FOR: tblFilmSetOrder
#

DROP TABLE IF EXISTS `tblFilmSetOrder`;

CREATE TABLE `tblFilmSetOrder` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `amountSeat` int(10) NOT NULL,
  `orderDate` date NOT NULL,
  `tblFilmSetID` int(10) NOT NULL,
  `tblClientID` int(10) NOT NULL,
  `tblUserID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKtblFilmSet849932` (`tblUserID`),
  KEY `FKtblFilmSet443236` (`tblClientID`),
  KEY `FKtblFilmSet358304` (`tblFilmSetID`),
  CONSTRAINT `FKtblFilmSet358304` FOREIGN KEY (`tblFilmSetID`) REFERENCES `tblFilmSet` (`ID`),
  CONSTRAINT `FKtblFilmSet443236` FOREIGN KEY (`tblClientID`) REFERENCES `tblClient` (`ID`),
  CONSTRAINT `FKtblFilmSet849932` FOREIGN KEY (`tblUserID`) REFERENCES `tblUser` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# TABLE STRUCTURE FOR: tblRoom
#

DROP TABLE IF EXISTS `tblRoom`;

CREATE TABLE `tblRoom` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `seats` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tblRoom` (`ID`, `name`, `type`, `seats`) VALUES (1, 'voluptas', '3D', 16);
INSERT INTO `tblRoom` (`ID`, `name`, `type`, `seats`) VALUES (2, 'veritatis', 'VIP', 16);
INSERT INTO `tblRoom` (`ID`, `name`, `type`, `seats`) VALUES (3, 'sint', '2D', 19);
INSERT INTO `tblRoom` (`ID`, `name`, `type`, `seats`) VALUES (4, 'voluptas', '3D', 20);
INSERT INTO `tblRoom` (`ID`, `name`, `type`, `seats`) VALUES (5, 'quia', '2D', 20);


#
# TABLE STRUCTURE FOR: tblSchedule
#

DROP TABLE IF EXISTS `tblSchedule`;

CREATE TABLE `tblSchedule` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `tblUserID` int(10) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKtblSchedul887858` (`tblUserID`),
  CONSTRAINT `FKtblSchedul887858` FOREIGN KEY (`tblUserID`) REFERENCES `tblUser` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tblSchedule` (`ID`, `tblUserID`, `time`) VALUES (1, 2, '2022-05-07');
INSERT INTO `tblSchedule` (`ID`, `tblUserID`, `time`) VALUES (2, 2, '2022-05-05');
INSERT INTO `tblSchedule` (`ID`, `tblUserID`, `time`) VALUES (3, 2, '2022-04-29');
INSERT INTO `tblSchedule` (`ID`, `tblUserID`, `time`) VALUES (4, 2, '2022-05-01');
INSERT INTO `tblSchedule` (`ID`, `tblUserID`, `time`) VALUES (5, 2, '2022-05-08');


#
# TABLE STRUCTURE FOR: tblTicket
#

DROP TABLE IF EXISTS `tblTicket`;

CREATE TABLE `tblTicket` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `seat` int(10) NOT NULL,
  `description` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tblFilmSetOrderID` int(10) NOT NULL,
  `tblBillID` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKtblTicket474874` (`tblBillID`),
  KEY `FKtblTicket314950` (`tblFilmSetOrderID`),
  CONSTRAINT `FKtblTicket314950` FOREIGN KEY (`tblFilmSetOrderID`) REFERENCES `tblFilmSetOrder` (`ID`),
  CONSTRAINT `FKtblTicket474874` FOREIGN KEY (`tblBillID`) REFERENCES `tblBill` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

#
# TABLE STRUCTURE FOR: tbleUser
#

DROP TABLE IF EXISTS `tbleUser`;

CREATE TABLE `tbleUser` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tbleUser` (`ID`, `name`, `password`, `role`) VALUES (1, 'admin', '1', 3);
INSERT INTO `tbleUser` (`ID`, `name`, `password`, `role`) VALUES (2, 'manager', '1', 2);
INSERT INTO `tbleUser` (`ID`, `name`, `password`, `role`) VALUES (3, 'seller', '1', 1);


