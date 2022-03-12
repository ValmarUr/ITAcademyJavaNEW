
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CulAmpolla
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `CulAmpolla` ;

-- -----------------------------------------------------
-- Schema CulAmpolla
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CulAmpolla` ;
USE `CulAmpolla` ;

-- -----------------------------------------------------
-- Table `CulAmpolla`.`proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CulAmpolla`.`proveedor` ;

CREATE TABLE IF NOT EXISTS `CulAmpolla`.`proveedor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `calle` VARCHAR(100) NOT NULL,
  `numero` INT NOT NULL,
  `piso` INT NULL,
  `puerta` INT NULL,
  `ciudad` VARCHAR(30) NOT NULL,
  `CP` INT NOT NULL,
  `pais` VARCHAR(20) NOT NULL,
  `telefono` INT NOT NULL,
  `fax` INT NULL,
  `nif` CHAR(9) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CulAmpolla`.`marca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CulAmpolla`.`marca` ;

CREATE TABLE IF NOT EXISTS `CulAmpolla`.`marca` (
  `id_marca` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(50) NOT NULL,
  `proveedor_id` INT NOT NULL,
  PRIMARY KEY (`id_marca`),
  INDEX `fk_marca_proveedor_idx` (`proveedor_id` ASC),
  CONSTRAINT `fk_marca_proveedor`
    FOREIGN KEY (`proveedor_id`)
    REFERENCES `CulAmpolla`.`proveedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CulAmpolla`.`tipo_montura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CulAmpolla`.`tipo_montura` ;

CREATE TABLE IF NOT EXISTS `CulAmpolla`.`tipo_montura` (
  `id_tipo` INT NOT NULL AUTO_INCREMENT,
  `nombre` ENUM('flotant', 'pasta', 'metalica') NOT NULL,
  PRIMARY KEY (`id_tipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CulAmpolla`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CulAmpolla`.`clientes` ;

CREATE TABLE IF NOT EXISTS `CulAmpolla`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `mail` VARCHAR(50) NOT NULL,
  `CP` CHAR(5) NOT NULL,
  `telefono` CHAR(9) NOT NULL,
  `fecha_registro` DATE NOT NULL,
  `id_recomendado` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clientes_clientes1_idx` (`id_recomendado` ASC),
  CONSTRAINT `fk_clientes_clientes1`
    FOREIGN KEY (`id_recomendado`)
    REFERENCES `CulAmpolla`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CulAmpolla`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CulAmpolla`.`empleado` ;

CREATE TABLE IF NOT EXISTS `CulAmpolla`.`empleado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CulAmpolla`.`gafas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CulAmpolla`.`gafas` ;

CREATE TABLE IF NOT EXISTS `CulAmpolla`.`gafas` (
  `id_gafas` INT NOT NULL AUTO_INCREMENT,
  `graduacion_ojo_izquierdo` INT NOT NULL,
  `graduacion_ojo_derecho` INT NOT NULL,
  `color_montura` CHAR(1) NOT NULL COMMENT 'values:\n- V: vermell\n- B: blau\n- G: groc\n....',
  `color_cristal` CHAR(1) NOT NULL COMMENT 'values:\n- T: transparents\n- S: ullleres de Sol\n...\n',
  `precio` DECIMAL(8,2) NOT NULL,
  `tipo_montura_id_tipo` INT NOT NULL,
  `marca_id_marca` INT NOT NULL,
  `clientes_id` INT NOT NULL,
  `empleado_id` INT NOT NULL,
  PRIMARY KEY (`id_gafas`),
  INDEX `fk_gafas_marca1_idx` (`marca_id_marca` ASC),
  INDEX `fk_gafas_tipo_montura1_idx` (`tipo_montura_id_tipo` ASC),
  INDEX `fk_gafas_clientes1_idx` (`clientes_id` ASC),
  INDEX `fk_gafas_empleado1_idx` (`empleado_id` ASC),
  CONSTRAINT `fk_gafas_marca1`
    FOREIGN KEY (`marca_id_marca`)
    REFERENCES `CulAmpolla`.`marca` (`id_marca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gafas_tipo_montura1`
    FOREIGN KEY (`tipo_montura_id_tipo`)
    REFERENCES `CulAmpolla`.`tipo_montura` (`id_tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gafas_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `CulAmpolla`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gafas_empleado1`
    FOREIGN KEY (`empleado_id`)
    REFERENCES `CulAmpolla`.`empleado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
