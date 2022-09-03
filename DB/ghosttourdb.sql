-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ghosttourdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ghosttourdb` ;

-- -----------------------------------------------------
-- Schema ghosttourdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ghosttourdb` DEFAULT CHARACTER SET utf8 ;
USE `ghosttourdb` ;

-- -----------------------------------------------------
-- Table `tour`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tour` ;

CREATE TABLE IF NOT EXISTS `tour` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `city` VARCHAR(100) NULL,
  `state` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `review` ;

CREATE TABLE IF NOT EXISTS `review` (
  `id` INT NOT NULL,
  `title` VARCHAR(100) NULL,
  `name` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `description` VARCHAR(1000) NULL,
  `price_per_person` DOUBLE NULL,
  `image` VARCHAR(2000) NULL,
  `date_created` DATETIME NULL,
  `tour_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Review_tour_idx` (`tour_id` ASC),
  CONSTRAINT `fk_Review_tour`
    FOREIGN KEY (`tour_id`)
    REFERENCES `tour` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment` ;

CREATE TABLE IF NOT EXISTS `comment` (
  `id` INT NOT NULL,
  `review_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `comment` VARCHAR(1000) NULL,
  `image` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comment_Review1_idx` (`review_id` ASC),
  CONSTRAINT `fk_comment_Review1`
    FOREIGN KEY (`review_id`)
    REFERENCES `review` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS ghosttour@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'ghosttour'@'localhost' IDENTIFIED BY 'ghosttour';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'ghosttour'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `tour`
-- -----------------------------------------------------
START TRANSACTION;
USE `ghosttourdb`;
INSERT INTO `tour` (`id`, `name`, `city`, `state`) VALUES (1, 'Stanley Hotel Tour', 'Estes Park', 'Colorado');

COMMIT;


-- -----------------------------------------------------
-- Data for table `review`
-- -----------------------------------------------------
START TRANSACTION;
USE `ghosttourdb`;
INSERT INTO `review` (`id`, `title`, `name`, `email`, `description`, `price_per_person`, `image`, `date_created`, `tour_id`) VALUES (1, 'What a creepy hotel!', 'Fred Fredette', 'fred@gmails.com', 'Went in the winter and it freaked out our whole group. ', 20, NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `ghosttourdb`;
INSERT INTO `comment` (`id`, `review_id`, `name`, `comment`, `image`) VALUES (1, 1, 'Pebbles Bam', 'I agree! so great', NULL);

COMMIT;

