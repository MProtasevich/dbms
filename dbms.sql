-- phpMyAdmin SQL Dump
-- version 4.0.5
-- http://www.phpmyadmin.net
--
-- Host: 127.9.85.130:3306
-- Generation Time: Jan 22, 2014 at 01:35 PM
-- Server version: 5.1.71
-- PHP Version: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbms`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_category` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `type_of_category`) VALUES
(1, 'Супер гроссмейстер'),
(2, 'Международный гроссмейстер'),
(3, 'Гроссмейстер'),
(4, 'Международный мастер'),
(5, 'Мастер ФИДЕ'),
(6, 'КМС'),
(7, '1 разряд'),
(8, '2 разряд'),
(9, '3 разряд'),
(10, '4 разряд'),
(11, '5 разряд'),
(12, 'Без разряда');

-- --------------------------------------------------------

--
-- Table structure for table `chessplayer`
--

CREATE TABLE IF NOT EXISTS `chessplayer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forename` varchar(128) DEFAULT NULL,
  `surname` varchar(128) DEFAULT NULL,
  `middle_name` varchar(128) DEFAULT NULL,
  `category_id` int(11) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `club_entry_date` date DEFAULT NULL,
  `liberties_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`,`liberties_id`),
  KEY `liberties_id` (`liberties_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `chessplayer`
--

INSERT INTO `chessplayer` (`id`, `forename`, `surname`, `middle_name`, `category_id`, `birthdate`, `club_entry_date`, `liberties_id`) VALUES
(1, 'Евгений', 'Алексеев', 'Владимирович', 3, '1985-11-28', '1998-10-15', 9),
(2, 'Александр', 'Ластин', 'Николаевич', 6, '1976-10-30', '1996-10-08', 6),
(3, 'Гарри', 'Каспаров', 'Кимович', 2, '1963-04-13', '1980-03-11', 1),
(4, 'Карлсен', 'Магнус', 'Свен', 5, '1990-11-30', '2004-04-26', 4),
(5, 'Левон', 'Аронян', 'Григорьевич', 6, '1982-10-06', '1995-05-11', 5),
(6, 'Владислав', 'Крамник', 'Борисович', 3, '1975-06-25', '1992-06-24', 4),
(7, 'Сергей', 'Волков', 'Викторович', 2, '1974-02-07', '1998-10-15', 11),
(8, 'Александр', 'Грищук', 'Игоревич', 1, '1983-10-31', '1999-11-15', 1),
(9, 'Сергей', 'Карякин', 'Александрович', 7, '1990-01-12', '2002-01-13', 11),
(10, 'Пётр', 'Свидлер', 'Вениаминович', 6, '1976-06-17', '1994-06-03', 5);

-- --------------------------------------------------------

--
-- Table structure for table `debut`
--

CREATE TABLE IF NOT EXISTS `debut` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `debut_descr` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `debut`
--

INSERT INTO `debut` (`id`, `debut_descr`) VALUES
(1, 'Дебют Рети'),
(2, 'Дебют Бёрда'),
(3, 'Будапештский гамбит'),
(4, 'Английское начало'),
(5, 'Дебют Немцовича'),
(6, 'Защита Каро-Канн'),
(7, 'Скандинавская защита'),
(8, 'Гамбит Эванса'),
(9, 'Венская партия'),
(10, 'Венгерская защита');

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE IF NOT EXISTS `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `white_player_id` int(11) DEFAULT NULL,
  `black_player_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `white_debut_id` int(11) NOT NULL,
  `black_debut_id` int(11) NOT NULL,
  `num_of_turns` mediumint(9) DEFAULT NULL,
  `result_id` int(11) NOT NULL,
  `tournament_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tournament_id` (`tournament_id`,`white_debut_id`,`black_debut_id`,`result_id`),
  KEY `white_player_id` (`white_player_id`),
  KEY `black_player_id` (`black_player_id`),
  KEY `white_debut_id` (`white_debut_id`),
  KEY `black_debut_id` (`black_debut_id`),
  KEY `result_id` (`result_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`id`, `white_player_id`, `black_player_id`, `date`, `white_debut_id`, `black_debut_id`, `num_of_turns`, `result_id`, `tournament_id`) VALUES
(1, 1, 2, '2013-10-06', 3, 4, 20, 1, 8),
(2, 3, 4, '2013-10-06', 5, 6, 20, 2, 8),
(3, 5, 6, '2013-10-06', 7, 8, 20, 3, 8),
(4, 7, 8, '2013-10-06', 1, 2, 20, 4, 8),
(5, 1, 3, '2013-09-06', 1, 8, 20, 5, 8),
(6, 8, 5, '2013-10-06', 1, 1, 20, 6, 8),
(7, 1, 5, '2013-10-06', 3, 5, 20, 7, 8),
(8, 9, 10, '2013-10-06', 1, 1, 20, 8, 10),
(9, 1, 2, '2013-10-06', 1, 2, 20, 9, 10),
(10, 3, 4, '2013-10-06', 1, 5, 20, 10, 10),
(11, 5, 6, '2013-10-06', 6, 7, 20, 11, 10),
(12, 9, 1, '2013-10-06', 1, 8, 20, 12, 10),
(13, 6, 3, '2013-10-06', 1, 2, 20, 13, 10),
(14, 3, 9, '2013-10-06', 4, 4, 20, 14, 10),
(15, 7, 8, '2013-10-06', 5, 1, 20, 15, 1),
(16, 9, 10, '2013-09-06', 1, 2, 20, 16, 1),
(17, 7, 10, '2013-10-06', 1, 2, 20, 17, 1),
(18, 1, 2, '2013-10-06', 1, 3, 20, 18, 2),
(19, 3, 4, '2013-10-06', 2, 4, 20, 19, 2),
(20, 3, 2, '2013-10-06', 8, 10, 20, 20, 2),
(21, 5, 6, '2013-10-06', 10, 8, 20, 21, 3),
(22, 7, 8, '2013-10-06', 10, 9, 20, 22, 3),
(23, 7, 6, '2013-10-06', 9, 2, 20, 23, 3),
(24, 9, 10, '2013-10-06', 6, 5, 20, 24, 4),
(25, 1, 2, '2013-10-06', 8, 5, 20, 25, 4),
(26, 1, 10, '2013-10-06', 6, 6, 20, 26, 4),
(27, 3, 4, '2013-09-06', 2, 1, 20, 27, 5),
(28, 6, 5, '2013-10-06', 1, 2, 20, 28, 5),
(29, 6, 3, '2013-10-06', 9, 3, 20, 29, 5),
(30, 7, 8, '2013-10-06', 1, 10, 20, 30, 6),
(31, 9, 10, '2013-10-06', 10, 5, 20, 31, 6),
(32, 10, 7, '2013-10-06', 5, 8, 20, 32, 6),
(33, 1, 2, '2013-10-06', 2, 6, 20, 33, 7),
(34, 3, 4, '2013-10-06', 2, 7, 20, 34, 7),
(35, 1, 4, '2013-10-06', 10, 8, 20, 35, 7),
(36, 5, 6, '2013-10-06', 3, 5, 20, 36, 9),
(37, 7, 8, '2013-09-06', 1, 6, 20, 37, 9),
(38, 5, 7, '2013-10-06', 3, 5, 20, 38, 9);

-- --------------------------------------------------------

--
-- Table structure for table `game_result`
--

CREATE TABLE IF NOT EXISTS `game_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `winner` int(11) NOT NULL,
  `looser` int(11) NOT NULL,
  `tie` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `winner` (`winner`,`looser`),
  KEY `looser` (`looser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=39 ;

--
-- Dumping data for table `game_result`
--

INSERT INTO `game_result` (`id`, `winner`, `looser`, `tie`) VALUES
(1, 1, 2, 0),
(2, 3, 4, 0),
(3, 5, 6, 0),
(4, 8, 7, 0),
(5, 1, 3, 0),
(6, 5, 8, 0),
(7, 5, 1, 0),
(8, 9, 10, 0),
(9, 1, 2, 0),
(10, 3, 4, 0),
(11, 6, 5, 0),
(12, 9, 1, 0),
(13, 3, 6, 0),
(14, 9, 3, 0),
(15, 7, 8, 0),
(16, 10, 9, 0),
(17, 7, 10, 1),
(18, 2, 1, 0),
(19, 3, 4, 0),
(20, 2, 3, 0),
(21, 6, 5, 0),
(22, 7, 8, 0),
(23, 7, 6, 0),
(24, 10, 9, 0),
(25, 1, 2, 0),
(26, 1, 10, 0),
(27, 3, 4, 0),
(28, 6, 5, 0),
(29, 3, 6, 0),
(30, 7, 8, 0),
(31, 10, 9, 0),
(32, 7, 10, 0),
(33, 1, 2, 0),
(34, 4, 3, 0),
(35, 1, 4, 0),
(36, 5, 6, 0),
(37, 7, 8, 0),
(38, 7, 5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `liberties`
--

CREATE TABLE IF NOT EXISTS `liberties` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `liberty_descr` varchar(128) NOT NULL,
  `discount` float NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `liberties`
--

INSERT INTO `liberties` (`id`, `liberty_descr`, `discount`) VALUES
(1, 'Скидка 50%', 0.5),
(2, 'Скидка 45%', 0.55),
(3, 'Скидка 40%', 0.6),
(4, 'Скидка 35%', 0.65),
(5, 'Скидка 30%', 0.7),
(6, 'Скидка 25%', 0.75),
(7, 'Скидка 20%', 0.8),
(8, 'Скидка 15%', 0.85),
(9, 'Скидка 10%', 0.9),
(10, 'Скидка 5%', 0.95),
(11, 'Без скидки', 1);

-- --------------------------------------------------------

--
-- Table structure for table `member_fees`
--

CREATE TABLE IF NOT EXISTS `member_fees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chessplayer_id` int(11) NOT NULL,
  `fee_amount` float DEFAULT NULL,
  `year` year(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `chessplayer_id` (`chessplayer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `member_fees`
--

INSERT INTO `member_fees` (`id`, `chessplayer_id`, `fee_amount`, `year`) VALUES
(1, 3, 1.25, 2013),
(2, 4, 2, 2012),
(3, 4, 2, 2013),
(4, 4, 1.98, 2014),
(5, 2, 3.45, 2013),
(6, 6, 2.43, 2014),
(7, 5, 1.3, 2014),
(8, 9, 0.78, 2012),
(9, 1, 3.45, 2014),
(10, 3, 1.31, 2014);

-- --------------------------------------------------------

--
-- Table structure for table `play_system`
--

CREATE TABLE IF NOT EXISTS `play_system` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `system_descr` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `play_system`
--

INSERT INTO `play_system` (`id`, `system_descr`) VALUES
(1, 'Схевенингенская'),
(2, 'Нокаут-система'),
(3, 'Круговая'),
(4, 'Швейцарская');

-- --------------------------------------------------------

--
-- Table structure for table `tournament`
--

CREATE TABLE IF NOT EXISTS `tournament` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `registration_fee` float DEFAULT NULL,
  `first_place_winnings` float DEFAULT NULL,
  `second_place_winnings` float DEFAULT NULL,
  `third_place_winnings` float DEFAULT NULL,
  `date_of_start` date DEFAULT NULL,
  `date_of_completion` date DEFAULT NULL,
  `play_system_id` int(11) DEFAULT NULL,
  `first_place_player` int(11) DEFAULT NULL,
  `second_place_player` int(11) DEFAULT NULL,
  `third_place_player` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `play_system_id` (`play_system_id`),
  KEY `first_place_player_id` (`first_place_player`),
  KEY `second_place_player_id` (`second_place_player`),
  KEY `third_place_player_id` (`third_place_player`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `tournament`
--

INSERT INTO `tournament` (`id`, `title`, `registration_fee`, `first_place_winnings`, `second_place_winnings`, `third_place_winnings`, `date_of_start`, `date_of_completion`, `play_system_id`, `first_place_player`, `second_place_player`, `third_place_player`) VALUES
(1, 'Линарес', 600, 6000, 2500, 1500, '2003-07-10', '2003-08-23', 4, 7, 10, 9),
(2, 'Линарес', 610, 6000, 2500, 1500, '2004-07-18', '2004-08-31', 4, 2, 3, 4),
(3, 'Линарес', 610, 6000, 2500, 1500, '2005-06-30', '2005-08-01', 4, 7, 6, 8),
(4, 'Линарес', 610, 6000, 2500, 1500, '2006-07-10', '2006-08-10', 4, 1, 10, 2),
(5, 'Биль', 400.53, 6500, 2300, 1200, '2010-06-10', '2010-08-07', 1, 3, 6, 5),
(6, 'Биль', 398.46, 6500, 2200, 1300, '2011-06-10', '2011-08-01', 1, 7, 10, 9),
(7, 'Биль', 240.76, 6200, 2400, 1400, '2012-06-06', '2012-08-03', 2, 1, 4, 3),
(8, 'Биль', 133.15, 6200, 2400, 1400, '2014-06-10', '2014-08-06', 2, 5, 1, 8),
(9, 'Лондон', 145.02, 7000, 2000, 1000, '2013-08-08', '2013-10-06', 3, 7, 5, 8),
(10, 'Лондон', 136.72, 6800, 2150, 1050, '2014-08-13', '2014-09-19', 3, 9, 3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `tournament_players`
--

CREATE TABLE IF NOT EXISTS `tournament_players` (
  `player_id` int(11) NOT NULL,
  `tournament_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`player_id`,`tournament_id`),
  KEY `player_id` (`player_id`,`tournament_id`),
  KEY `tournament_id` (`tournament_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tournament_players`
--

INSERT INTO `tournament_players` (`player_id`, `tournament_id`, `id`) VALUES
(1, 2, 0),
(1, 4, 0),
(1, 7, 0),
(1, 8, 0),
(1, 10, 0),
(2, 2, 0),
(2, 4, 0),
(2, 7, 0),
(2, 8, 0),
(2, 10, 0),
(3, 2, 0),
(3, 5, 0),
(3, 7, 0),
(3, 8, 0),
(3, 10, 0),
(4, 2, 0),
(4, 5, 0),
(4, 7, 0),
(4, 8, 0),
(4, 10, 0),
(5, 3, 0),
(5, 5, 0),
(5, 8, 0),
(5, 9, 0),
(5, 10, 0),
(6, 3, 0),
(6, 5, 0),
(6, 8, 0),
(6, 9, 0),
(6, 10, 0),
(7, 1, 0),
(7, 3, 0),
(7, 6, 0),
(7, 8, 0),
(7, 9, 0),
(8, 1, 0),
(8, 3, 0),
(8, 6, 0),
(8, 8, 0),
(8, 9, 0),
(9, 1, 0),
(9, 4, 0),
(9, 6, 0),
(9, 10, 0),
(10, 1, 0),
(10, 4, 0),
(10, 6, 0),
(10, 10, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chessplayer`
--
ALTER TABLE `chessplayer`
  ADD CONSTRAINT `chessplayer_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `chessplayer_ibfk_2` FOREIGN KEY (`liberties_id`) REFERENCES `liberties` (`id`);

--
-- Constraints for table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `game_ibfk_1` FOREIGN KEY (`white_player_id`) REFERENCES `chessplayer` (`id`),
  ADD CONSTRAINT `game_ibfk_2` FOREIGN KEY (`black_player_id`) REFERENCES `chessplayer` (`id`),
  ADD CONSTRAINT `game_ibfk_3` FOREIGN KEY (`white_debut_id`) REFERENCES `debut` (`id`),
  ADD CONSTRAINT `game_ibfk_4` FOREIGN KEY (`black_debut_id`) REFERENCES `debut` (`id`),
  ADD CONSTRAINT `game_ibfk_5` FOREIGN KEY (`result_id`) REFERENCES `game_result` (`id`),
  ADD CONSTRAINT `game_ibfk_6` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`id`);

--
-- Constraints for table `game_result`
--
ALTER TABLE `game_result`
  ADD CONSTRAINT `game_result_ibfk_1` FOREIGN KEY (`winner`) REFERENCES `chessplayer` (`id`),
  ADD CONSTRAINT `game_result_ibfk_2` FOREIGN KEY (`looser`) REFERENCES `chessplayer` (`id`);

--
-- Constraints for table `member_fees`
--
ALTER TABLE `member_fees`
  ADD CONSTRAINT `member_fees_ibfk_1` FOREIGN KEY (`chessplayer_id`) REFERENCES `chessplayer` (`id`);

--
-- Constraints for table `tournament`
--
ALTER TABLE `tournament`
  ADD CONSTRAINT `first_place_player_id` FOREIGN KEY (`first_place_player`) REFERENCES `chessplayer` (`id`),
  ADD CONSTRAINT `second_place_player_id` FOREIGN KEY (`second_place_player`) REFERENCES `chessplayer` (`id`),
  ADD CONSTRAINT `third_place_player_id` FOREIGN KEY (`third_place_player`) REFERENCES `chessplayer` (`id`),
  ADD CONSTRAINT `tournament_ibfk_1` FOREIGN KEY (`play_system_id`) REFERENCES `play_system` (`id`);

--
-- Constraints for table `tournament_players`
--
ALTER TABLE `tournament_players`
  ADD CONSTRAINT `tournament_players_ibfk_1` FOREIGN KEY (`player_id`) REFERENCES `chessplayer` (`id`),
  ADD CONSTRAINT `tournament_players_ibfk_2` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
