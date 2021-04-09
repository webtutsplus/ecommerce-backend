-- -- MariaDB dump 10.18  Distrib 10.5.8-MariaDB, for debian-linux-gnu (x86_64)
-- --
-- -- Host: localhost    Database: ecommerce
-- -- ------------------------------------------------------
-- -- Server version	10.5.8-MariaDB-3

-- /*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
-- /*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
-- /*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
-- /*!40101 SET NAMES utf8mb4 */;
-- /*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
-- /*!40103 SET TIME_ZONE='+00:00' */;
-- /*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
-- /*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
-- /*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- /*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- --
-- -- Table structure for table `categories`
-- --

-- DROP TABLE IF EXISTS `categories`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!40101 SET character_set_client = utf8 */;
-- CREATE TABLE `categories` (
--   `id` bigint(20) NOT NULL AUTO_INCREMENT,
--   `category_name` varchar(255) DEFAULT NULL,
--   `description` varchar(255) DEFAULT NULL,
--   `image_url` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `categories`
-- --

-- LOCK TABLES `categories` WRITE;
-- /*!40000 ALTER TABLE `categories` DISABLE KEYS */;
-- INSERT INTO `categories` VALUES (1,'Electronics','string','string'),(2,'Kites','These are Kites','https://images.unsplash.com/photo-1600387822941-a6ac49b2f0a3?ixid=MXwxMjA3fDB8MHxzZWFyY2h8OHx8a2l0ZXN8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),(3,'Television','Television','https://images.unsplash.com/photo-1593359677879-a4bb92f829d1?ixid=MXwxMjA3fDB8MHxzZWFyY2h8NXx8dGVsZXZpc2lvbnxlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),(4,'Shoes','Shoes','https://images.unsplash.com/photo-1460353581641-37baddab0fa2?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8c2hvZXN8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),(5,'Clothes','Clothes',NULL),(6,NULL,'Kids space',NULL),(7,'Toys','Space for kids',NULL),(8,'Demo3','This is Demo category','https://images.unsplash.com/photo-1560529178-855fa2041193?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTd8fHRveXN8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),(9,'Demo5','This is demo test','https://images.unsplash.com/photo-1545997281-2cfe4d4b740f?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTB8fHRveXN8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),(10,'Demo','Demo','null'),(11,'demo4','demo4','null'),(12,'Demo10','Demo10','Demo10'),(13,'Smartphones','This contains all sartphones','https://images.unsplash.com/photo-1510878933023-e2e2e3942fb0?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1051&q=80'),(14,'Clocks','Collection of clocks','https://images.unsplash.com/photo-1585586463948-9e40851ed193?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80'),(15,'Kites','This is a collection of kites','https://images.unsplash.com/photo-1534640881905-039ca1e21a81?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8a2l0ZXN8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),(16,'Books','This section contains Books','https://images.unsplash.com/photo-1524578271613-d550eacf6090?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8Ym9va3N8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),(17,'Automobiles','Find all vehicles','https://images.unsplash.com/photo-1552519507-da3b142c6e3d?ixid=MXwxMjA3fDB8MHxzZWFyY2h8Mnx8Y2Fyc3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),(18,'Bags','High Quality Bags',NULL),(19,'Groceries','Find all your groceries here','https://images.unsplash.com/photo-1543168256-418811576931?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8Z3JvY2VyaWVzfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'),(20,'Biscuits','Tasty Biscuits','https://images.unsplash.com/photo-1531685932387-e60fae5f6163?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTN8fGJpc2N1aXRzfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60');
-- /*!40000 ALTER TABLE `categories` ENABLE KEYS */;
-- UNLOCK TABLES;

-- --
-- -- Table structure for table `products`
-- --

-- DROP TABLE IF EXISTS `products`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!40101 SET character_set_client = utf8 */;
-- CREATE TABLE `products` (
--   `id` bigint(20) NOT NULL AUTO_INCREMENT,
--   `description` varchar(255) DEFAULT NULL,
--   `imageurl` varchar(255) DEFAULT NULL,
--   `name` varchar(255) DEFAULT NULL,
--   `price` double NOT NULL,
--   `category_id` bigint(20) NOT NULL,
--   PRIMARY KEY (`id`),
--   KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`)
-- ) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- /*
-- CREATE TABLE products (
--   id serial PRIMARY KEY,
--   description varchar(255) DEFAULT NULL,
--   imageurl varchar(255) DEFAULT NULL,
--   name varchar(255) DEFAULT NULL,
--   price double NOT NULL,
--   category_id int NOT NULL,
--     FOREIGN KEY (category_id)
--       REFERENCES categories (id)
-- );

-- CREATE TABLE categories (
--   id serial PRIMARY KEY,
--   category_name varchar(255) DEFAULT NULL,
--   description varchar(255) DEFAULT NULL,
--   image_url varchar(255) DEFAULT NULL
-- );

-- */
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `products`
-- --

-- LOCK TABLES `products` WRITE;
-- /*!40000 ALTER TABLE `products` DISABLE KEYS */;
-- INSERT INTO `products` VALUES (1,'Microcontroller board for starters.','https://images.unsplash.com/photo-1608564697071-ddf911d81370?ixid=MXwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwzOHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Arduino UNO',500,9),(2,'Highly accurate','https://images.unsplash.com/photo-1497997457905-3f85463eb0bc?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8c2Vuc29yfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Ultrasonic sensor',200,2),(3,'hello World','https://images.unsplash.com/photo-1609584862854-57387c661076?ixid=MXwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxNHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Hello World',100,1),(4,'This is a Car','https://images.unsplash.com/photo-1600661653561-629509216228?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTl8fGV2fGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Tesla Car',10000,17),(5,'This is demo200','https://images.unsplash.com/photo-1602526211905-6adc54adb8d2?ixid=MXwxMjA3fDF8MHxlZGl0b3JpYWwtZmVlZHw5fHx8ZW58MHx8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','demo200',50000,1),(6,'This is a toy','https://images.unsplash.com/photo-1563396983906-b3795482a59a?ixid=MXwxMjA3fDB8MHxzZWFyY2h8OXx8dG95c3xlbnwwfHwwfA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Toy',200,3),(7,'Demo','https://images.unsplash.com/photo-1469037784699-75dcff1cbf75?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MjZ8fHRveXN8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Demo',89,5),(8,'This is a great Toy','https://images.unsplash.com/photo-1517348159000-002b80abf80f?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MzV8fHRveXN8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Toy',500,1),(9,'This is a car','https://images.unsplash.com/photo-1502877338535-766e1452684a?ixid=MXwxMjA3fDB8MHxzZWFyY2h8Nnx8Y2FyfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Car',5000,1),(10,'This is a Iphone','https://images.unsplash.com/photo-1556656793-08538906a9f8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80','Iphone',1000,1),(11,'This is a watch','https://images.unsplash.com/photo-1542496658-e33a6d0d50f6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80','Watch',2000,1),(12,'This is a clock','https://images.unsplash.com/photo-1563861826100-9cb868fdbe1c?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8Y2xvY2t8ZW58MHx8MHw%3D&auto=format&fit=crop&w=500&q=60','Wall Clock',2000,14),(13,'This is a TV','https://images.unsplash.com/photo-1571415060716-baff5f717c37?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8dHZ8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','LG TV',5000,3),(14,'This is a Samsung Smartphone','https://images.unsplash.com/photo-1553179459-4514c0f52f41?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTR8fHNhbXN1bmclMjBzbWFydHBob25lfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Samsung Galaxy ',5000,13),(15,'Fruits','https://images.unsplash.com/photo-1609257574707-a3114f91cefe?ixid=MXwxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxNnx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Fruits',1500,2),(16,'A great historical tamil novel by Amarar Kalki!','https://dwtr67e3ikfml.cloudfront.net/bookCovers/8d0aebe488c9389b799f9c153bc05717ce2fa45f','Ponniyin Selvan',2500,2),(17,'This is a Historical clock','https://images.unsplash.com/photo-1415604934674-561df9abf539?ixid=MXwxMjA3fDB8MHxzZWFyY2h8OHx8Y2xvY2tzfGVufDB8fDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60','Ancient Clock',1000,14);
-- /*!40000 ALTER TABLE `products` ENABLE KEYS */;
-- UNLOCK TABLES;

-- --
-- -- Table structure for table `tokens`
-- --

-- DROP TABLE IF EXISTS `tokens`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!40101 SET character_set_client = utf8 */;
-- CREATE TABLE `tokens` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `token` varchar(255) DEFAULT NULL,
--   `created_date` datetime DEFAULT NULL,
--   `user_id` int(11) NOT NULL,
--   PRIMARY KEY (`id`),
--   KEY `FK2dylsfo39lgjyqml2tbe0b0ss` (`user_id`)
-- ) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;


-- /*
-- CREATE TABLE `tokens` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `token` varchar(255) DEFAULT NULL,
--   `created_date` datetime DEFAULT NULL,
--   `user_id` int(11) NOT NULL,
--   PRIMARY KEY (`id`),
--   KEY `FK2dylsfo39lgjyqml2tbe0b0ss` (`user_id`)
-- ) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- CREATE TABLE tokens (
-- 	id serial PRIMARY KEY,
-- 	token VARCHAR ( 50 ) UNIQUE NOT NULL,
-- 	user_id int ( 11 ) NOT NULL,
--   last_name VARCHAR ( 50 ) NOT NULL,
-- 	password VARCHAR ( 255 ) UNIQUE NOT NULL,
-- 	role VARCHAR ( 255 ) UNIQUE NOT NULL
-- );


-- */
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `tokens`
-- --

-- LOCK TABLES `tokens` WRITE;
-- /*!40000 ALTER TABLE `tokens` DISABLE KEYS */;
-- INSERT INTO `tokens` VALUES (1,'0a686925-7735-4d5e-930a-285e23d8aed1','2020-12-22 13:19:11',1),(2,'73110419-d579-4fd9-ad98-dd9402226adb','2020-12-22 13:22:02',2),(3,'9816248d-4623-474f-a985-d11b094325f9','2020-12-22 13:22:14',3),(4,'120038ca-5a15-49fa-a50f-6580345ad35e','2020-12-27 06:24:23',4),(5,'ea8303ca-29c7-4892-961a-5829814d02d3','2020-12-27 06:25:06',5),(6,'59f35dc9-9dc4-4bcc-ab28-f4ea6f81722d','2020-12-27 06:25:16',6),(7,'cba245a4-d4eb-41a2-9789-e3dc9b46855a','2020-12-27 07:48:16',7),(8,'3ea96f41-708c-4ad6-adf8-b862fc7ee125','2020-12-27 07:50:11',8),(9,'fb32b650-fd27-4dc3-b8e2-9bee7f5a66f3','2020-12-27 08:23:40',9),(10,'f54d51b9-01e3-4a1c-9ab7-b072801305dd','2020-12-27 08:41:01',10),(11,'1b7e5c1a-0161-453f-950e-367397190065','2020-12-27 15:39:16',11),(12,'4fee3514-cc3d-46c8-a0eb-0cc04a0fda59','2020-12-28 09:55:06',12),(13,'a3699f8e-56c6-4d00-8849-68833c37b571','2020-12-28 10:03:34',13),(14,'4a0d58f1-1171-4721-b617-ad2604bc12c2','2020-12-28 10:04:09',14),(15,'3d0bd78a-b4a1-4a91-bc9c-a9960c83a6e2','2020-12-28 11:30:29',15),(16,'f0425c15-7a5e-4735-993d-cb3577143c16','2020-12-28 12:41:57',16),(17,'495d3ac3-fb1a-4373-9997-42329a10e31c','2020-12-29 14:07:45',17),(18,'8d32ef2a-9494-4d0f-912e-684940cd03ff','2020-12-29 14:10:29',18),(19,'73a0a7e4-eaf4-4f7c-a1a1-3f29b19d9d1a','2020-12-29 16:23:12',19),(20,'b368062c-6074-4ef3-8311-b6b37581d202','2020-12-30 21:32:04',20),(21,'2e8418cb-af90-47f1-a94a-bec5bf7f4b1b','2021-01-01 09:04:52',21),(22,'6415441f-c621-435e-8535-7170a5f8c50f','2021-01-01 09:40:21',22),(23,'f4c3c2e9-f82a-4137-a174-de197428cd8b','2021-01-01 10:05:17',23);
-- /*!40000 ALTER TABLE `tokens` ENABLE KEYS */;
-- UNLOCK TABLES;

-- --
-- -- Table structure for table `user_profile`
-- --

-- DROP TABLE IF EXISTS `user_profile`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!40101 SET character_set_client = utf8 */;
-- CREATE TABLE `user_profile` (
--   `id` bigint(20) NOT NULL AUTO_INCREMENT,
--   `email` varchar(255) DEFAULT NULL,
--   `first_name` varchar(255) DEFAULT NULL,
--   `last_name` varchar(255) DEFAULT NULL,
--   `username` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `user_profile`
-- --

-- LOCK TABLES `user_profile` WRITE;
-- /*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
-- /*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
-- UNLOCK TABLES;

-- --
-- -- Table structure for table `users`
-- --

-- DROP TABLE IF EXISTS `users`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!40101 SET character_set_client = utf8 */;
-- CREATE TABLE `users` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `email` varchar(255) DEFAULT NULL,
--   `first_name` varchar(255) DEFAULT NULL,
--   `last_name` varchar(255) DEFAULT NULL,
--   `password` varchar(255) DEFAULT NULL,
--   `role` varchar(255) DEFAULT NULL,
--   PRIMARY KEY (`id`)
-- ) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- /*
-- CREATE TABLE users (
-- 	id serial PRIMARY KEY,
-- 	email VARCHAR ( 50 ) UNIQUE NOT NULL,
-- 	first_name VARCHAR ( 50 ) NOT NULL,
--   last_name VARCHAR ( 50 ) NOT NULL,
-- 	password VARCHAR ( 255 ) NOT NULL,
-- 	role VARCHAR ( 255 )  NOT NULL
-- );
-- CREATE TABLE tokens (
--   id serial PRIMARY KEY,
--   token varchar(255) DEFAULT NULL,
--   created_date timestamp DEFAULT NULL,
--   user_id int NOT NULL,
--   FOREIGN KEY (user_id)
--       REFERENCES users (id)
--   );
-- */
-- --
-- -- Dumping data for table `users`
-- --

-- LOCK TABLES `users` WRITE;
-- /*!40000 ALTER TABLE `users` DISABLE KEYS */;
-- INSERT INTO `users` VALUES (16,'t@t.t','rr','rr','E358EFA489F58062F10DD7316B65649E','user'),(15,'tt@tt.ttt','string','string','B45CFFE084DD3D20D928BEE85E7B0F21','user'),(14,'t@tt.tt',NULL,NULL,'ACCC9105DF5383111407FD5B41255E23','user'),(13,'tt@tt.t',NULL,NULL,'633DE4B0C14CA52EA2432A3C8A5C4C31','user'),(12,'tt@tt.tt','t','t','ACCC9105DF5383111407FD5B41255E23','user'),(11,'test@test.com','test','test','CEB6C970658F31504A901B89DCD3E461','user'),(10,'t@t.in','string','string','B45CFFE084DD3D20D928BEE85E7B0F21','user'),(9,'admin@gmail.com','admin','admin','21232F297A57A5A743894A0E4A801FC3','user'),(17,'chathrua@test.com','Chathrua','Buddhika','34F85CA80EC353D3052B8A2D3973A0C5','user'),(18,NULL,NULL,'Darsha','69FE8DBF75B65A08B4C1F005B400F261','user'),(19,'testuser@gmail.com','test','user','098F6BCD4621D373CADE4E832627B4F6','user'),(20,'chathu@gmail.com','Chathura','Darsha','69FE8DBF75B65A08B4C1F005B400F261','user'),(21,'sdcdsc@gmail.com','Chathura','Darsha','69FE8DBF75B65A08B4C1F005B400F261','user'),(22,'ascscas@ds.hi','ascsc','Darshaaas','81DC9BDB52D04DC20036DBD8313ED055','user'),(23,'asdf@asdf.com','dsih','jisci','A545F9A48DF4BE512630CC53CEE1916B','user');
-- /*!40000 ALTER TABLE `users` ENABLE KEYS */;
-- UNLOCK TABLES;

-- --
-- -- Table structure for table `wishlist`
-- --

-- DROP TABLE IF EXISTS `wishlist`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!40101 SET character_set_client = utf8 */;
-- CREATE TABLE `wishlist` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `user_id` int(11) NOT NULL,
--   `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
--   `product_id` bigint(20) NOT NULL,
--   PRIMARY KEY (`id`),
--   KEY `FK6p7qhvy1bfkri13u29x6pu8au` (`product_id`)
-- ) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
-- /*!40101 SET character_set_client = @saved_cs_client */;

-- --
-- -- Dumping data for table `wishlist`
-- --

-- LOCK TABLES `wishlist` WRITE;
-- /*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
-- INSERT INTO `wishlist` VALUES (1,1,'2021-01-12 21:06:39',1),(2,1,'2021-01-12 21:11:54',6),(3,2,'2021-01-12 21:12:34',3),(5,9,'2021-01-13 02:48:42',3),(6,11,'2021-01-13 02:51:01',1);
-- /*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
-- UNLOCK TABLES;
-- /*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

-- /*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
-- /*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
-- /*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
-- /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
-- /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
-- /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- /*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- -- Dump completed on 2021-01-13  3:42:14
