-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Wind`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Wind` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Wind` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `direction` INT NOT NULL,
  `speed` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ship_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Ship_type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Ship_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `max_speed` INT NOT NULL,
  `max_speed_change` INT NOT NULL,
  `max_sailors` INT NOT NULL,
  `max_hull` INT NOT NULL,
  `max_sail` INT NOT NULL,
  `rows_of_guns` INT NOT NULL,
  `guns_per_row` INT NOT NULL,
  `sailor_per_gun` INT NOT NULL,
  `number_of_sails` INT NOT NULL,
  `sailor_per_sail` INT NOT NULL,
  `number_of_turns` INT NOT NULL,
  `sail_50_speed` INT NOT NULL,
  `sail_25_speed` INT NOT NULL,
  `sail_10_speed` INT NOT NULL,
  `sail_0_speed` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `Ship_typecol_UNIQUE` (`type` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ammunition_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Ammunition_type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Ammunition_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `table1col_UNIQUE` (`type` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Nationality`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Nationality` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Nationality` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NOT NULL,
  `color` VARCHAR(45) NOT NULL,
  `captain` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Ships`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Ships` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Ships` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nationality_id` INT NOT NULL,
  `ship_type_id` INT NOT NULL,
  `ammunition_type_id` INT NOT NULL,
  `sailors` INT NOT NULL,
  `hull` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `id_idx` (`ammunition_type_id` ASC) VISIBLE,
  INDEX `id_idx1` (`ship_type_id` ASC) VISIBLE,
  INDEX `id_idx2` (`nationality_id` ASC) VISIBLE,
  CONSTRAINT `ammunitionTypeID`
    FOREIGN KEY (`ammunition_type_id`)
    REFERENCES `mydb`.`Ammunition_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `shipTypeID`
    FOREIGN KEY (`ship_type_id`)
    REFERENCES `mydb`.`Ship_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nationalityID`
    FOREIGN KEY (`nationality_id`)
    REFERENCES `mydb`.`Nationality` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Map`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Map` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Map` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `wind_id` INT NOT NULL,
  `height` INT NOT NULL,
  `width` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `id_idx` (`wind_id` ASC) VISIBLE,
  CONSTRAINT `windID`
    FOREIGN KEY (`wind_id`)
    REFERENCES `mydb`.`Wind` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Movement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Movement` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Movement` (
  `ship_id` INT NOT NULL,
  `map_id` INT NOT NULL,
  `xPosition` INT NOT NULL,
  `yPosition` INT NOT NULL,
  `Speed` INT NOT NULL,
  `direction` INT NOT NULL,
  INDEX `id_idx` (`map_id` ASC) VISIBLE,
  INDEX `id_idx1` (`ship_id` ASC) VISIBLE,
  CONSTRAINT `mapID`
    FOREIGN KEY (`map_id`)
    REFERENCES `mydb`.`Map` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `shipsID`
    FOREIGN KEY (`ship_id`)
    REFERENCES `mydb`.`Ships` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Orders` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Orders` (
  `turn_number` INT NOT NULL,
  `ship_id` INT NOT NULL,
  `direction` INT NOT NULL,
  `xPosition` INT NOT NULL,
  `yPosition` INT NOT NULL,
  `map_id` INT NOT NULL,
  INDEX `id_idx` (`ship_id` ASC) VISIBLE,
  INDEX `id_idx1` (`map_id` ASC) VISIBLE,
  CONSTRAINT `shipID`
    FOREIGN KEY (`ship_id`)
    REFERENCES `mydb`.`Ships` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `mapsID`
    FOREIGN KEY (`map_id`)
    REFERENCES `mydb`.`Map` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydb`.`Ship_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Ship_type` (`id`, `type`, `max_speed`, `max_speed_change`, `max_sailors`, `max_hull`, `max_sail`, `rows_of_guns`, `guns_per_row`, `sailor_per_gun`, `number_of_sails`, `sailor_per_sail`, `number_of_turns`, `sail_50_speed`, `sail_25_speed`, `sail_10_speed`, `sail_0_speed`) VALUES (1, 'Brig', 2, 1, 60, 25, 30, 1, 8, 3, 4, 6, 1, 1, 1, 1, 0);
INSERT INTO `mydb`.`Ship_type` (`id`, `type`, `max_speed`, `max_speed_change`, `max_sailors`, `max_hull`, `max_sail`, `rows_of_guns`, `guns_per_row`, `sailor_per_gun`, `number_of_sails`, `sailor_per_sail`, `number_of_turns`, `sail_50_speed`, `sail_25_speed`, `sail_10_speed`, `sail_0_speed`) VALUES (2, 'Ship of the Line', 5, 2, 160, 60, 60, 2, 16, 3, 10, 6, 2, 3, 2, 1, 0);
INSERT INTO `mydb`.`Ship_type` (`id`, `type`, `max_speed`, `max_speed_change`, `max_sailors`, `max_hull`, `max_sail`, `rows_of_guns`, `guns_per_row`, `sailor_per_gun`, `number_of_sails`, `sailor_per_sail`, `number_of_turns`, `sail_50_speed`, `sail_25_speed`, `sail_10_speed`, `sail_0_speed`) VALUES (3, 'Man at War', 4, 1, 340, 140, 80, 3, 28, 3, 24, 6, 1, 3, 2, 1, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Ammunition_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Ammunition_type` (`id`, `type`) VALUES (1, 'Cannon ball');
INSERT INTO `mydb`.`Ammunition_type` (`id`, `type`) VALUES (2, 'Chain');
INSERT INTO `mydb`.`Ammunition_type` (`id`, `type`) VALUES (3, 'Grape bot');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydb`.`Nationality`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydb`;
INSERT INTO `mydb`.`Nationality` (`id`, `country`, `color`, `captain`) VALUES (1, 'Denmark', 'Red', 'Niels Juel');
INSERT INTO `mydb`.`Nationality` (`id`, `country`, `color`, `captain`) VALUES (2, 'Japan', 'White', 'Kōsaku Aruga');
INSERT INTO `mydb`.`Nationality` (`id`, `country`, `color`, `captain`) VALUES (3, 'Argentina', 'Teal', 'William Brown');
INSERT INTO `mydb`.`Nationality` (`id`, `country`, `color`, `captain`) VALUES (4, 'Portugal', 'Green', 'Ferdinand Magellan');

COMMIT;

