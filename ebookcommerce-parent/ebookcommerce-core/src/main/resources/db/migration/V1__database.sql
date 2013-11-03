SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `camilo_ebook` ;
CREATE SCHEMA IF NOT EXISTS `camilo_ebook` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `camilo_ebook` ;
-- -----------------------------------------------------
-- Table `camilo_ebook`.`category_ebook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `camilo_ebook`.`category_ebook` ;

CREATE  TABLE IF NOT EXISTS `camilo_ebook`.`category_ebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `description_UNIQUE` (`description` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `camilo_ebook`.`ebook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `camilo_ebook`.`ebook` ;

CREATE  TABLE IF NOT EXISTS `camilo_ebook`.`ebook` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `status` VARCHAR(45) NOT NULL DEFAULT 'Inactive' ,
  `title` VARCHAR(75) NOT NULL ,
  `summary_file` VARCHAR(45) NULL ,
  `description` VARCHAR(1000) NOT NULL ,
  `price` DECIMAL(10,2) NOT NULL ,
  `cover` VARCHAR(45) NOT NULL ,
  `year_publish` INT(11) NOT NULL ,
  `sale_url` VARCHAR(200) NULL ,
  `ISBN` VARCHAR(100) NULL ,
  `totalPage` INT(4) NOT NULL ,
  `editionNumber` INT(3) NOT NULL DEFAULT 1 ,
  `category_ebook_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) ,
  INDEX `fk_ebook_category_ebook1` (`category_ebook_id` ASC) ,
  CONSTRAINT `fk_ebook_category_ebook1`
    FOREIGN KEY (`category_ebook_id` )
    REFERENCES `camilo_ebook`.`category_ebook` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `camilo_ebook`.`type_ebook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `camilo_ebook`.`type_ebook` ;

CREATE  TABLE IF NOT EXISTS `camilo_ebook`.`type_ebook` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `description` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `camilo_ebook`.`ebook_has_type_ebook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `camilo_ebook`.`ebook_has_type_ebook` ;

CREATE  TABLE IF NOT EXISTS `camilo_ebook`.`ebook_has_type_ebook` (
  `ebook_id` INT(11) NOT NULL ,
  `type_ebook_id` INT(11) NOT NULL ,
  PRIMARY KEY (`ebook_id`, `type_ebook_id`) ,
  INDEX `fk_ebook_has_type_ebook_type_ebook1` (`type_ebook_id` ASC) ,
  INDEX `fk_ebook_has_type_ebook_ebook1` (`ebook_id` ASC) ,
  CONSTRAINT `fk_ebook_has_type_ebook_ebook1`
    FOREIGN KEY (`ebook_id` )
    REFERENCES `camilo_ebook`.`ebook` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ebook_has_type_ebook_type_ebook1`
    FOREIGN KEY (`type_ebook_id` )
    REFERENCES `camilo_ebook`.`type_ebook` (`id` )
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `camilo_ebook`.`author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `camilo_ebook`.`author` ;

CREATE  TABLE IF NOT EXISTS `camilo_ebook`.`author` (
  `ID` INT NOT NULL ,
  `NAME` VARCHAR(45) NULL ,
  `LASTNAME` VARCHAR(45) NULL ,
  `EMAIL` VARCHAR(45) NOT NULL ,
  `REPO_URL` VARCHAR(80) NULL ,
  `TWITTER` VARCHAR(45) NULL ,
  `SITE` VARCHAR(80) NULL ,
  `NAME_EDITOR` VARCHAR(45) NOT NULL ,
  `PHOTO` VARCHAR(250) NOT NULL ,
  `CV` TEXT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC) )
ENGINE = InnoDB;
ALTER TABLE `camilo_ebook`.`author` MODIFY COLUMN `ID` INT(11) NOT NULL AUTO_INCREMENT;
-- -----------------------------------------------------
-- Table `camilo_ebook`.`ebook_has_author`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `camilo_ebook`.`ebook_has_author` ;

CREATE  TABLE IF NOT EXISTS `camilo_ebook`.`ebook_has_author` (
  `ebook_id` INT NOT NULL ,
  `Author_ID` INT NOT NULL ,
  PRIMARY KEY (`ebook_id`, `Author_ID`) ,
  INDEX `fk_ebook_has_author_Author1` (`Author_ID` ASC) ,
  INDEX `fk_ebook_has_author_ebook1` (`ebook_id` ASC) ,
  CONSTRAINT `fk_ebook_has_author_ebook1`
    FOREIGN KEY (`ebook_id` )
    REFERENCES `camilo_ebook`.`ebook` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ebook_has_Author_Author1`
    FOREIGN KEY (`Author_ID` )
    REFERENCES `camilo_ebook`.`author` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
