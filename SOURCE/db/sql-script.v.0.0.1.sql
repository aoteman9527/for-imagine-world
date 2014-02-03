CREATE SCHEMA `imagine_world` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE `imagine_world`.`PRODUCT` (
  `id_product` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `price` VARCHAR(45) NULL,
  `product_code` VARCHAR(45) NULL,
  `product_amount` INT NULL,
  `last_update_date` DATE NULL,
  PRIMARY KEY (`id_product`));

CREATE TABLE `imagine_world`.`PRODUCT` (
  `id_product` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `price` VARCHAR(45) NULL,
  `product_code` VARCHAR(45) NULL,
  `product_amount` INT NULL,
  `last_update_date` DATE NULL,
  PRIMARY KEY (`id_product`));

CREATE TABLE `imagine_world`.`Tag` (
  `id_tag` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id_tag`));

