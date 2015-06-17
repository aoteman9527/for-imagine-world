CREATE SCHEMA `imagine_world` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE `imagine_world`.`MYPRODUCT` (
  `id_product` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `price` DOUBLE NOT NULL,
  `product_code` VARCHAR(45) NULL,
  `product_amount` INT NULL,
  `last_update_date` DATE NULL,
  `image_url` TEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`id_product`));
  
CREATE TABLE `imagine_world`.`MYTAG` (
  `id_tag` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id_tag`));

CREATE TABLE `imagine_world`.`MYSHOPPINGCART` (
  `cart_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`cart_id`));
  
CREATE TABLE `imagine_world`.`MYORDER` (
`order_id` INT NOT NULL,
`user_id` INT NOT NULL,
`totalprice` DOUBLE NOT NULL,
`date` INT NOT NULL,
PRIMARY KEY (`order_id`));