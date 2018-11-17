-- MySQL Script generated by MySQL Workbench
-- Sat Nov 17 14:18:13 2018
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
-- Table `bui`.`o`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bui`.`o` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `created_at` BIGINT NOT NULL,
  `updated_at` BIGINT NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_ACCOUNT_NAME` (`name` ASC),
  UNIQUE INDEX `UQ_ACCOUNT_EMAIL` (`email` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `bui`.`user_credential`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bui`.`user_credential` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `public_key` VARCHAR(256) NOT NULL,
  `secret_key` TINYTEXT NOT NULL,
  `created_at` BIGINT NOT NULL,
  `updated_at` BIGINT NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_CREDENTIAL_PUBLIC_KEY` (`public_key` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `bui`.`op_operator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bui`.`op_operator` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `created_at` BIGINT NOT NULL,
  `updated_at` BIGINT NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_OPERATOR_NAME` (`name` ASC),
  UNIQUE INDEX `UQ_OPERATOR_EMAIL` (`email` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `bui`.`op_operator_credential`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bui`.`op_operator_credential` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `operator` INT UNSIGNED NOT NULL,
  `public_key` VARCHAR(256) NOT NULL,
  `secret_key` TINYTEXT NOT NULL,
  `created_at` BIGINT NOT NULL,
  `updated_at` BIGINT NOT NULL,
  `modify_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `FK_OPERATOR_CREDENTIAL_PK_OPERATOR` (`operator` ASC),
  UNIQUE INDEX `UQ_OPERATOR_CREDENTIAL_PUBLIC_KEY` (`public_key` ASC),
  CONSTRAINT `FK_OPERATOR_CREDENTIAL_PK_OPERATOR`
    FOREIGN KEY (`operator`)
    REFERENCES `bui`.`op_operator` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
