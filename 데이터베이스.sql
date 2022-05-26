-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.7.3-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- todolist 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `todolist`;
CREATE DATABASE IF NOT EXISTS `todolist` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `todolist`;

-- 테이블 todolist.todolist_mst 구조 내보내기
DROP TABLE IF EXISTS `todolist_mst`;
CREATE TABLE IF NOT EXISTS `todolist_mst` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usercode` int(11) DEFAULT NULL,
  `content` varchar(500) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 todolist.todolist_mst:~2 rows (대략적) 내보내기
DELETE FROM `todolist_mst`;
/*!40000 ALTER TABLE `todolist_mst` DISABLE KEYS */;
INSERT INTO `todolist_mst` (`id`, `usercode`, `content`, `create_date`, `update_date`) VALUES
	(1, 1, 'ㅁㅁ', '2022-05-26 11:47:22', '2022-05-26 11:47:23'),
	(2, 1, 'dvdvㅎ', '2022-05-26 12:36:17', '2022-05-26 12:36:17');
/*!40000 ALTER TABLE `todolist_mst` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
