#
# TABLE STRUCTURE FOR: tblBill
#

DROP TABLE IF EXISTS `tblBill`;

CREATE TABLE `tblBill` (
  `ID` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `discount` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `paymentDate` date NOT NULL,
  `paymentType` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tblCardID` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tblUserID` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tblBill` (`ID`, `discount`, `paymentDate`, `paymentType`, `tblCardID`, `tblUserID`) VALUES ('1', '', '2022-04-27', 'card', '8', 1);
INSERT INTO `tblBill` (`ID`, `discount`, `paymentDate`, `paymentType`, `tblCardID`, `tblUserID`) VALUES ('2', '', '2022-04-26', 'cash', '4', 1);
INSERT INTO `tblBill` (`ID`, `discount`, `paymentDate`, `paymentType`, `tblCardID`, `tblUserID`) VALUES ('3', '', '2022-04-27', 'cash', '9', 1);
INSERT INTO `tblBill` (`ID`, `discount`, `paymentDate`, `paymentType`, `tblCardID`, `tblUserID`) VALUES ('4', '', '2022-04-26', 'card', '3', 1);
INSERT INTO `tblBill` (`ID`, `discount`, `paymentDate`, `paymentType`, `tblCardID`, `tblUserID`) VALUES ('5', '', '2022-04-26', 'card', '2', 1);


#
# TABLE STRUCTURE FOR: tblFilmSet
#

DROP TABLE IF EXISTS `tblFilmSet`;

CREATE TABLE `tblFilmSet` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `cost` int(10) NOT NULL,
  `startTime` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tbRoomID` int(10) NOT NULL,
  `tblFilmID` int(10) NOT NULL,
  `tblScheduleID` int(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tblFilmSet` (`ID`, `cost`, `startTime`, `tbRoomID`, `tblFilmID`, `tblScheduleID`) VALUES (1, 50000, '14:00', 3, 2, 4);
INSERT INTO `tblFilmSet` (`ID`, `cost`, `startTime`, `tbRoomID`, `tblFilmID`, `tblScheduleID`) VALUES (2, 50000, '20:00', 2, 1, 1);
INSERT INTO `tblFilmSet` (`ID`, `cost`, `startTime`, `tbRoomID`, `tblFilmID`, `tblScheduleID`) VALUES (3, 100000, '21:00', 1, 3, 3);
INSERT INTO `tblFilmSet` (`ID`, `cost`, `startTime`, `tbRoomID`, `tblFilmID`, `tblScheduleID`) VALUES (4, 150000, '21:00', 3, 5, 5);
INSERT INTO `tblFilmSet` (`ID`, `cost`, `startTime`, `tbRoomID`, `tblFilmID`, `tblScheduleID`) VALUES (5, 50000, '10:00', 4, 5, 2);


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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tblFilmSetOrder` (`ID`, `amountSeat`, `orderDate`, `tblFilmSetID`, `tblClientID`, `tblUserID`) VALUES (1, 3, '2022-04-24', 2, 1, 1);
INSERT INTO `tblFilmSetOrder` (`ID`, `amountSeat`, `orderDate`, `tblFilmSetID`, `tblClientID`, `tblUserID`) VALUES (2, 5, '2022-04-26', 3, 3, 1);
INSERT INTO `tblFilmSetOrder` (`ID`, `amountSeat`, `orderDate`, `tblFilmSetID`, `tblClientID`, `tblUserID`) VALUES (3, 3, '2022-04-26', 4, 5, 1);
INSERT INTO `tblFilmSetOrder` (`ID`, `amountSeat`, `orderDate`, `tblFilmSetID`, `tblClientID`, `tblUserID`) VALUES (4, 4, '2022-04-26', 3, 5, 1);
INSERT INTO `tblFilmSetOrder` (`ID`, `amountSeat`, `orderDate`, `tblFilmSetID`, `tblClientID`, `tblUserID`) VALUES (5, 1, '2022-04-26', 5, 1, 1);


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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `tblTicket` (`ID`, `seat`, `description`, `tblFilmSetOrderID`, `tblBillID`) VALUES (1, 7, 'Saepe molestias sapiente eveniet qui vel qui. Arch', 4, '4');
INSERT INTO `tblTicket` (`ID`, `seat`, `description`, `tblFilmSetOrderID`, `tblBillID`) VALUES (2, 1, 'Sequi maiores corrupti consequatur et amet. Incidu', 3, '1');
INSERT INTO `tblTicket` (`ID`, `seat`, `description`, `tblFilmSetOrderID`, `tblBillID`) VALUES (3, 10, 'Consequatur amet et qui ex dicta quia voluptates c', 2, '2');
INSERT INTO `tblTicket` (`ID`, `seat`, `description`, `tblFilmSetOrderID`, `tblBillID`) VALUES (4, 1, 'Incidunt sunt aut ut voluptatem autem maiores. Sin', 4, '3');
INSERT INTO `tblTicket` (`ID`, `seat`, `description`, `tblFilmSetOrderID`, `tblBillID`) VALUES (5, 5, 'Repellat et id est minima consectetur sint. Natus ', 5, '5');


