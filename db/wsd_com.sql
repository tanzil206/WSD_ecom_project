/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.28-MariaDB : Database - wsd_com
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wsd_com` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;

USE `wsd_com`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `customer_name` text NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Data for the table `customer` */

<<<<<<< HEAD
insert  into `customer`(`id`,`customer_name`,`user_name`) values (1,'Tanzil Ahamed','tanzir206'),(2,'Tanzil Ahmed','tanzil206');
=======
insert  into `customer`(`id`,`customer_name`,`user_name`) values (1,'Tanzil Ahmed','tanzir206');
>>>>>>> b76f25d690c5fd4e73db0abfb93170a9e47e7e84

/*Table structure for table `customer_seq` */

DROP TABLE IF EXISTS `customer_seq`;

CREATE TABLE `customer_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Data for the table `customer_seq` */

insert  into `customer_seq`(`next_val`) values (51);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `product_name` text NOT NULL,
  `product_code` varchar(255) NOT NULL,
  `unit_price` float NOT NULL,
  `total_unit` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `total_stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Data for the table `product` */

<<<<<<< HEAD
insert  into `product`(`id`,`product_name`,`product_code`,`unit_price`,`total_unit`,`code`,`total_stock`) values (1,'Salt','salt-500',20,20,NULL,20),(2,'ToothPaste','tp',100,10,NULL,100),(3,'Chawl','ch',60,30,NULL,60),(4,'Fish','fh',200,15,NULL,200),(5,'Beef','bf',700,7,NULL,700),(6,'Biscuit','bs',50,10,NULL,50),(7,'Noodles','nd',50,8,NULL,50),(8,'Salt','salt-1000',40,5,NULL,40),(9,'Minikate Chawl','mn-ch',70,20,NULL,70);
=======
insert  into `product`(`id`,`product_name`,`product_code`,`unit_price`,`total_unit`,`code`,`total_stock`) values (1,'Salt','salt-500',20,20,NULL,20),(2,'ToothPaste','tp',100,10,NULL,100),(3,'Chawl','ch',60,30,NULL,60),(4,'Fish','fh',200,15,NULL,200),(5,'Beef','bf',700,7,NULL,700),(6,'Biscuit','bs',50,10,NULL,50),(7,'Noodles','nd',50,8,NULL,50),(8,'Salt','salt-1000',40,5,NULL,40);
>>>>>>> b76f25d690c5fd4e73db0abfb93170a9e47e7e84

/*Table structure for table `product_seq` */

DROP TABLE IF EXISTS `product_seq`;

CREATE TABLE `product_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Data for the table `product_seq` */

insert  into `product_seq`(`next_val`) values (1);

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `sale_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKonrcqwf09u6spb6ty6sh11jh5` (`product_id`),
  CONSTRAINT `FKonrcqwf09u6spb6ty6sh11jh5` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_nopad_bin;

/*Data for the table `sale` */

<<<<<<< HEAD
insert  into `sale`(`id`,`product_id`,`total_amount`,`total_price`,`sale_date`) values (1,1,1,20,'2024-06-30 00:00:00.000000'),(2,1,2,40,'2024-07-06 00:00:00.000000'),(3,2,1,100,'2024-06-23 00:00:00.000000'),(4,5,1,700,'2024-06-10 00:00:00.000000'),(5,8,1,40,'2024-06-18 00:00:00.000000'),(6,4,3,600,'2024-06-12 00:00:00.000000'),(7,6,2,100,'2024-07-06 00:00:00.000000'),(8,3,5,300,'2024-06-13 00:00:00.000000'),(9,3,10,600,'2024-07-06 00:00:00.000000'),(10,3,2,120,'2024-06-01 00:00:00.000000');
=======
insert  into `sale`(`id`,`product_id`,`total_amount`,`total_price`,`sale_date`) values (1,1,1,20,'2024-06-30 00:00:00.000000'),(2,1,2,40,'2024-07-07 00:00:00.000000'),(3,2,1,100,'2024-06-23 00:00:00.000000'),(4,5,1,700,'2024-06-10 00:00:00.000000'),(5,8,1,40,'2024-06-18 00:00:00.000000'),(6,4,3,600,'2024-06-12 00:00:00.000000'),(7,6,2,100,'2024-07-06 00:00:00.000000'),(8,3,5,300,'2024-06-13 00:00:00.000000'),(9,3,10,600,'2024-07-06 00:00:00.000000'),(10,3,2,120,'2024-06-01 00:00:00.000000');
>>>>>>> b76f25d690c5fd4e73db0abfb93170a9e47e7e84

/*Table structure for table `sale_seq` */

DROP TABLE IF EXISTS `sale_seq`;

CREATE TABLE `sale_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Data for the table `sale_seq` */

insert  into `sale_seq`(`next_val`) values (1);

/*Table structure for table `wish_list` */

DROP TABLE IF EXISTS `wish_list`;

CREATE TABLE `wish_list` (
  `id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1lnlly6r9bd5l5i0a5ibo7p9o` (`customer_id`),
  KEY `FKqn4e0ta2823kynefeg4jektp0` (`product_id`),
  CONSTRAINT `FK1lnlly6r9bd5l5i0a5ibo7p9o` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKqn4e0ta2823kynefeg4jektp0` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Data for the table `wish_list` */

<<<<<<< HEAD
insert  into `wish_list`(`id`,`product_id`,`customer_id`) values (0,1,1),(1,2,1),(2,8,2);
=======
insert  into `wish_list`(`id`,`product_id`,`customer_id`) values (0,1,1),(1,2,1);
>>>>>>> b76f25d690c5fd4e73db0abfb93170a9e47e7e84

/*Table structure for table `wish_list_seq` */

DROP TABLE IF EXISTS `wish_list_seq`;

CREATE TABLE `wish_list_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

/*Data for the table `wish_list_seq` */

insert  into `wish_list_seq`(`next_val`) values (1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
