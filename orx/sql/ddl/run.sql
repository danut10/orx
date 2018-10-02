
--
-- prepare database
--

DROP DATABASE IF EXISTS `orx-dev-01`;
FLUSH TABLES;
FLUSH STATUS;
CREATE DATABASE `orx-dev-01` CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `orx-dev-01`;

--
-- create tables
--

source tables/tables-admin.sql;
source test-data/test-data-admin.sql;

