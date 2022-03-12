
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema YouTube
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `YouTube` ;

-- -----------------------------------------------------
-- Schema YouTube
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `YouTube` DEFAULT CHARACTER SET utf8 ;
USE `YouTube` ;

-- -----------------------------------------------------
-- Table `YouTube`.`canal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`canal` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`canal` (
  `canal_id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(100) NOT NULL,
  `descripcio` VARCHAR(1000) NOT NULL,
  `data_creacio` DATE NOT NULL DEFAULT (CURRENT_DATE),
  PRIMARY KEY (`canal_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`usuari`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`usuari` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`usuari` (
  `usuari_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `nom_usuari` VARCHAR(45) NOT NULL,
  `data_naixement` DATE NOT NULL,
  `sexe` CHAR(1) NULL COMMENT '\'F\' for female\n\'M\' for male',
  `pais` VARCHAR(45) NOT NULL,
  `CP` VARCHAR(6) NOT NULL COMMENT 'Russia & China got 6-digit zip codes',
  `canal_canal_id` INT NOT NULL,
  PRIMARY KEY (`usuari_id`),
  INDEX `fk_usuari_canal1_idx` (`canal_canal_id` ASC) VISIBLE,
  CONSTRAINT `fk_usuari_canal1`
    FOREIGN KEY (`canal_canal_id`)
    REFERENCES `YouTube`.`canal` (`canal_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`video`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`video` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`video` (
  `video_id` INT NOT NULL AUTO_INCREMENT,
  `titol` VARCHAR(200) NOT NULL,
  `descripcio` VARCHAR(1000) NULL,
  `grandaria` VARCHAR(5) NULL COMMENT 'FORMAT: \n\'5MB\'\n\'190MB\'\n\'2.5GB\'',
  `nom_arxiu` VARCHAR(100) NOT NULL,
  `durada` TIME NOT NULL,
  `thumbnail` BLOB NOT NULL,
  `reproduccions` INT NOT NULL,
  `n_likes` INT NOT NULL,
  `n_dislikes` INT NOT NULL,
  `moment_publicacio` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estat_video` ENUM('public', 'ocult', 'privat') NOT NULL,
  `usuari_usuari_id` INT NOT NULL,
  PRIMARY KEY (`video_id`),
  INDEX `fk_video_usuari1_idx` (`usuari_usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_video_usuari1`
    FOREIGN KEY (`usuari_usuari_id`)
    REFERENCES `YouTube`.`usuari` (`usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`etiqueta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`etiqueta` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`etiqueta` (
  `etiqueta_id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`etiqueta_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`video_has_etiqueta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`video_has_etiqueta` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`video_has_etiqueta` (
  `video_video_id` INT NOT NULL,
  `etiqueta_etiqueta_id` INT NOT NULL,
  PRIMARY KEY (`video_video_id`, `etiqueta_etiqueta_id`),
  INDEX `fk_video_has_etiqueta_etiqueta1_idx` (`etiqueta_etiqueta_id` ASC) VISIBLE,
  INDEX `fk_video_has_etiqueta_video1_idx` (`video_video_id` ASC) VISIBLE,
  CONSTRAINT `fk_video_has_etiqueta_video1`
    FOREIGN KEY (`video_video_id`)
    REFERENCES `YouTube`.`video` (`video_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_video_has_etiqueta_etiqueta1`
    FOREIGN KEY (`etiqueta_etiqueta_id`)
    REFERENCES `YouTube`.`etiqueta` (`etiqueta_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`subscripicio_canal_altres_usuaris`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`subscripicio_canal_altres_usuaris` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`subscripicio_canal_altres_usuaris` (
  `usuari_usuari_id` INT NOT NULL,
  `canal_canal_id` INT NOT NULL,
  INDEX `fk_usuari_has_canal_canal1_idx` (`canal_canal_id` ASC) VISIBLE,
  INDEX `fk_usuari_has_canal_usuari1_idx` (`usuari_usuari_id` ASC) VISIBLE,
  PRIMARY KEY (`usuari_usuari_id`, `canal_canal_id`),
  CONSTRAINT `fk_usuari_has_canal_usuari1`
    FOREIGN KEY (`usuari_usuari_id`)
    REFERENCES `YouTube`.`usuari` (`usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_usuari_has_canal_canal1`
    FOREIGN KEY (`canal_canal_id`)
    REFERENCES `YouTube`.`canal` (`canal_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`registre_like_video`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`registre_like_video` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`registre_like_video` (
  `usuari_usuari_id` INT NOT NULL,
  `video_video_id` INT NOT NULL,
  `data_registre` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `like_dislike` CHAR(1) NULL COMMENT '\'L\' for Like\n\'D\' for Dislike ',
  INDEX `fk_registre_like_dislike_usuari1_idx` (`usuari_usuari_id` ASC) VISIBLE,
  INDEX `fk_registre_like_dislike_video1_idx` (`video_video_id` ASC) VISIBLE,
  PRIMARY KEY (`usuari_usuari_id`, `video_video_id`),
  CONSTRAINT `fk_registre_like_dislike_usuari1`
    FOREIGN KEY (`usuari_usuari_id`)
    REFERENCES `YouTube`.`usuari` (`usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_registre_like_dislike_video1`
    FOREIGN KEY (`video_video_id`)
    REFERENCES `YouTube`.`video` (`video_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`playlist` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`playlist` (
  `playlist_id` INT NOT NULL AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `data_creacio` DATE NOT NULL DEFAULT (CURRENT_DATE),
  `estat` ENUM('public', 'privat') NOT NULL,
  `usuari_usuari_id` INT NOT NULL,
  PRIMARY KEY (`playlist_id`),
  INDEX `fk_playlist_usuari1_idx` (`usuari_usuari_id` ASC) VISIBLE,
  CONSTRAINT `fk_playlist_usuari1`
    FOREIGN KEY (`usuari_usuari_id`)
    REFERENCES `YouTube`.`usuari` (`usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`comentari`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`comentari` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`comentari` (
  `comentaris_id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(1000) NOT NULL,
  `data_comentari` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usuari_usuari_id` INT NOT NULL,
  `video_video_id` INT NOT NULL,
  PRIMARY KEY (`comentaris_id`),
  INDEX `fk_comentaris_usuari1_idx` (`usuari_usuari_id` ASC) VISIBLE,
  INDEX `fk_comentaris_video1_idx` (`video_video_id` ASC) VISIBLE,
  CONSTRAINT `fk_comentaris_usuari1`
    FOREIGN KEY (`usuari_usuari_id`)
    REFERENCES `YouTube`.`usuari` (`usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_comentaris_video1`
    FOREIGN KEY (`video_video_id`)
    REFERENCES `YouTube`.`video` (`video_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`registre_agrada_comentari`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`registre_agrada_comentari` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`registre_agrada_comentari` (
  `usuari_usuari_id` INT NOT NULL,
  `comentari_comentaris_id` INT NOT NULL,
  `data_registre` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `valor_registrat` CHAR(1) NOT NULL COMMENT '\'A\' for m\'Agrada\n\'N\' for No m\'agrada',
  INDEX `fk_registre_agrada_comentari_usuari1_idx` (`usuari_usuari_id` ASC) VISIBLE,
  INDEX `fk_registre_agrada_comentari_comentari1_idx` (`comentari_comentaris_id` ASC) VISIBLE,
  PRIMARY KEY (`usuari_usuari_id`, `comentari_comentaris_id`),
  CONSTRAINT `fk_registre_agrada_comentari_usuari1`
    FOREIGN KEY (`usuari_usuari_id`)
    REFERENCES `YouTube`.`usuari` (`usuari_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_registre_agrada_comentari_comentari1`
    FOREIGN KEY (`comentari_comentaris_id`)
    REFERENCES `YouTube`.`comentari` (`comentaris_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`playlist_has_video`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `YouTube`.`playlist_has_video` ;

CREATE TABLE IF NOT EXISTS `YouTube`.`playlist_has_video` (
  `playlist_playlist_id` INT NOT NULL,
  `video_video_id` INT NOT NULL,
  PRIMARY KEY (`playlist_playlist_id`, `video_video_id`),
  INDEX `fk_playlist_has_video_video1_idx` (`video_video_id` ASC) VISIBLE,
  INDEX `fk_playlist_has_video_playlist1_idx` (`playlist_playlist_id` ASC) VISIBLE,
  CONSTRAINT `fk_playlist_has_video_playlist1`
    FOREIGN KEY (`playlist_playlist_id`)
    REFERENCES `YouTube`.`playlist` (`playlist_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_playlist_has_video_video1`
    FOREIGN KEY (`video_video_id`)
    REFERENCES `YouTube`.`video` (`video_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
