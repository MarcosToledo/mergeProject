-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sisnoti
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sisnoti` ;

-- -----------------------------------------------------
-- Schema sisnoti
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sisnoti` DEFAULT CHARACTER SET utf8 ;
USE `sisnoti` ;

-- -----------------------------------------------------
-- Table `sisnoti`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisnoti`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `document` VARCHAR(20) NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `phone` INT NOT NULL,
  `image_logo` VARCHAR(100) NOT NULL,
  `date_register` DATETIME NOT NULL,
  `date_update` DATETIME NOT NULL,
  `actived` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE INDEX `cpf_cnpj` ON `sisnoti`.`client` (`document` ASC);


-- -----------------------------------------------------
-- Table `sisnoti`.`visitor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisnoti`.`visitor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `phone` INT NOT NULL,
  `status` INT NOT NULL,
  `cpf` VARCHAR(45) NOT NULL COMMENT '\n',
  `email` VARCHAR(200) NULL,
  `zip_code` INT NULL,
  `street` VARCHAR(200) NULL,
  `number` INT NULL,
  `city` VARCHAR(200) NULL,
  `uf` VARCHAR(45) NULL,
  `midia` VARCHAR(45) NULL,
  `purchase_price` FLOAT NULL,
  `date_register` DATETIME NOT NULL,
  `date_update` DATETIME NOT NULL,
  `actived` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sisnoti`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisnoti`.`event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_client` INT NOT NULL,
  `id_visitor` INT NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `zip_code` INT NOT NULL,
  `address` VARCHAR(300) NOT NULL,
  `number` INT NOT NULL,
  `uf` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `product_image_logo` VARCHAR(45) NOT NULL,
  `date_register` DATETIME NOT NULL,
  `date_update` DATETIME NOT NULL,
  `actived` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_evento_cliente`
    FOREIGN KEY (`id_client`)
    REFERENCES `sisnoti`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_visitor`
    FOREIGN KEY (`id_visitor`)
    REFERENCES `sisnoti`.`visitor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `name` ON `sisnoti`.`event` (`name` ASC);

CREATE INDEX `fk_evento_cliente_idx` ON `sisnoti`.`event` (`id_client` ASC);

CREATE INDEX `fk_event_visitor_idx` ON `sisnoti`.`event` (`id_visitor` ASC);


-- -----------------------------------------------------
-- Table `sisnoti`.`broker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisnoti`.`broker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_client` INT NULL,
  `name` VARCHAR(200) NOT NULL,
  `company` VARCHAR(200) NOT NULL,
  `phone` INT NOT NULL,
  `date_register` DATETIME NOT NULL,
  `date_update` DATETIME NOT NULL,
  `actived` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_corretor_cliente`
    FOREIGN KEY (`id_client`)
    REFERENCES `sisnoti`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_corretor_cliente_idx` ON `sisnoti`.`broker` (`id_client` ASC);


-- -----------------------------------------------------
-- Table `sisnoti`.`config_notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisnoti`.`config_notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_event` INT NOT NULL,
  `category` VARCHAR(200) NOT NULL,
  `theme_name` VARCHAR(200) NOT NULL,
  `theme_color` VARCHAR(10) NOT NULL,
  `midia_layout` INT NOT NULL,
  `date_register` DATETIME NOT NULL,
  `date_update` DATETIME NOT NULL,
  `actived` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_config_notification_event`
    FOREIGN KEY (`id_event`)
    REFERENCES `sisnoti`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_config_notification_event_idx` ON `sisnoti`.`config_notification` (`id_event` ASC);


-- -----------------------------------------------------
-- Table `sisnoti`.`notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisnoti`.`notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_client` INT NOT NULL,
  `id_event` INT NOT NULL,
  `id_broker` INT NOT NULL,
  `id_visitor` INT NOT NULL,
  `date_register` DATETIME NOT NULL,
  `date_update` DATETIME NOT NULL,
  `actived` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_notificacao_cliente`
    FOREIGN KEY (`id_client`)
    REFERENCES `sisnoti`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notification_event`
    FOREIGN KEY (`id_event`)
    REFERENCES `sisnoti`.`event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notification_broker`
    FOREIGN KEY (`id_broker`)
    REFERENCES `sisnoti`.`broker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notification_visitor`
    FOREIGN KEY (`id_visitor`)
    REFERENCES `sisnoti`.`visitor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_notificacao_cliente_idx` ON `sisnoti`.`notification` (`id_client` ASC);

CREATE INDEX `fk_notification_event_idx` ON `sisnoti`.`notification` (`id_event` ASC);

CREATE INDEX `fk_notification_broker_idx` ON `sisnoti`.`notification` (`id_broker` ASC);

CREATE INDEX `fk_notification_visitor_idx` ON `sisnoti`.`notification` (`id_visitor` ASC);


-- -----------------------------------------------------
-- Table `sisnoti`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisnoti`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_client` INT NOT NULL,
  `username` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `type` INT NOT NULL,
  `token` VARCHAR(200) NOT NULL,
  `token_expiration` DATETIME NULL,
  `date_register` DATETIME NOT NULL,
  `date_update` DATETIME NOT NULL,
  `actived` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_usuario_cliente`
    FOREIGN KEY (`id_client`)
    REFERENCES `sisnoti`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `login` ON `sisnoti`.`user` (`username` ASC, `password` ASC);

CREATE INDEX `fk_usuario_cliente_idx` ON `sisnoti`.`user` (`id_client` ASC);

CREATE UNIQUE INDEX `token_UNIQUE` ON `sisnoti`.`user` (`token` ASC);


-- -----------------------------------------------------
-- Table `sisnoti`.`midia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisnoti`.`midia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_config` INT NOT NULL,
  `type` INT NOT NULL,
  `file_name` VARCHAR(200) NOT NULL,
  `path` VARCHAR(200) NOT NULL,
  `date_register` DATETIME NOT NULL,
  `date_update` DATETIME NOT NULL,
  `actived` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `id_config`
    FOREIGN KEY (`id_config`)
    REFERENCES `sisnoti`.`config_notification` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `id_config_idx` ON `sisnoti`.`midia` (`id_config` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
