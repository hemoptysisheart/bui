-- MySQL Script generated by MySQL Workbench
-- Sun Nov 18 10:47:15 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bui
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bui` ;

-- -----------------------------------------------------
-- Schema bui
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bui` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
SHOW WARNINGS;
USE `bui` ;

-- -----------------------------------------------------
-- Table `ui_`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ui_` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
