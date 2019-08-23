--CREATE TABLE IF NOT EXISTS `meal` (
--  `meal_id` int(11) NOT NULL AUTO_INCREMENT,
--  `uid` varchar(20) NOT NULL,
--  `date_id` varchar(10) NOT NULL,
--  `type` varchar(5) NOT NULL,
--  `total_kcal` int(11) DEFAULT '0',
--  PRIMARY KEY (`meal_id`)
--) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `meal` (
  `meal_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_id` varchar(255) DEFAULT NULL,
  `total_kcal` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`meal_id`),
  KEY `idx_uid_date_id` (`uid`,`date_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8