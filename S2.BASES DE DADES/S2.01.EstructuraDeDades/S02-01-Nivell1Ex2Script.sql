
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Pizzeria
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Pizzeria` ;

-- -----------------------------------------------------
-- Schema Pizzeria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Pizzeria` ;
USE `Pizzeria` ;

-- -----------------------------------------------------
-- Table `Pizzeria`.`provincia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`provincia` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`provincia` (
  `id provincia` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id provincia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`localidad`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`localidad` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`localidad` (
  `id_localidad` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `provincia_id provincia` INT NOT NULL,
  PRIMARY KEY (`id_localidad`),
  INDEX `fk_localidad_provincia1_idx` (`provincia_id provincia` ASC) VISIBLE,
  CONSTRAINT `fk_localidad_provincia1`
    FOREIGN KEY (`provincia_id provincia`)
    REFERENCES `Pizzeria`.`provincia` (`id provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`cliente` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `CP` CHAR(5) NOT NULL,
  `telefono` CHAR(9) NOT NULL,
  `localidad_id_localidad` INT NOT NULL,
  `provincia_id provincia` INT NOT NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_clientes_localidad_idx` (`localidad_id_localidad` ASC) VISIBLE,
  INDEX `fk_clientes_provincia1_idx` (`provincia_id provincia` ASC) VISIBLE,
  CONSTRAINT `fk_clientes_localidad`
    FOREIGN KEY (`localidad_id_localidad`)
    REFERENCES `Pizzeria`.`localidad` (`id_localidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientes_provincia1`
    FOREIGN KEY (`provincia_id provincia`)
    REFERENCES `Pizzeria`.`provincia` (`id provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`tienda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`tienda` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`tienda` (
  `id_tienda` INT NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `CP` VARCHAR(5) NOT NULL,
  `localidad_id_localidad` INT NOT NULL,
  PRIMARY KEY (`id_tienda`),
  INDEX `fk_tienda_localidad1_idx` (`localidad_id_localidad` ASC) VISIBLE,
  CONSTRAINT `fk_tienda_localidad1`
    FOREIGN KEY (`localidad_id_localidad`)
    REFERENCES `Pizzeria`.`localidad` (`id_localidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`empleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`empleado` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`empleado` (
  `id_empleado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nif` CHAR(9) NOT NULL,
  `telefono` CHAR(9) NOT NULL,
  `empleo` ENUM('repartidor', 'cocinero') NOT NULL,
  `tienda_id_tienda` INT NOT NULL,
  INDEX `fk_empleado_tienda1_idx` (`tienda_id_tienda` ASC) VISIBLE,
  PRIMARY KEY (`id_empleado`),
  CONSTRAINT `fk_empleado_tienda1`
    FOREIGN KEY (`tienda_id_tienda`)
    REFERENCES `Pizzeria`.`tienda` (`id_tienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`pedido` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`pedido` (
  `id_pedido` INT NOT NULL AUTO_INCREMENT,
  `fecha_hora` DATETIME NOT NULL,
  `tipo_pedido` ENUM('domicili', 'recollir') NOT NULL,
  `cantidad_por_categoria` INT NOT NULL,
  `precio_total` FLOAT NOT NULL,
  `cliente_id_cliente` INT NOT NULL,
  `tienda_id_tienda` INT NOT NULL,
  `empleado_id_empleado` INT NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `fk_pedido_clientes1_idx` (`cliente_id_cliente` ASC) VISIBLE,
  INDEX `fk_pedido_tienda1_idx` (`tienda_id_tienda` ASC) VISIBLE,
  INDEX `fk_pedido_empleado1_idx` (`empleado_id_empleado` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_clientes1`
    FOREIGN KEY (`cliente_id_cliente`)
    REFERENCES `Pizzeria`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_tienda1`
    FOREIGN KEY (`tienda_id_tienda`)
    REFERENCES `Pizzeria`.`tienda` (`id_tienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_empleado1`
    FOREIGN KEY (`empleado_id_empleado`)
    REFERENCES `Pizzeria`.`empleado` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`tipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`tipo` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`tipo` (
  `id_tipo` INT NOT NULL,
  `nombre` ENUM('pizza', 'hamburguesa', 'beguda') NOT NULL,
  PRIMARY KEY (`id_tipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`categoria_pizza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`categoria_pizza` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`categoria_pizza` (
  `id_categoria_pizza` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_categoria_pizza`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`productos` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`productos` (
  `id_productos` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `imagen` BLOB NULL,
  `precio` FLOAT NOT NULL,
  `tipo_id_tipo` INT NOT NULL,
  `categoria_pizza_id_categoria_pizza` INT NULL,
  PRIMARY KEY (`id_productos`),
  INDEX `fk_productos_tipo_producto1_idx` (`tipo_id_tipo` ASC) VISIBLE,
  INDEX `fk_productos_categoria_pizza1_idx` (`categoria_pizza_id_categoria_pizza` ASC) VISIBLE,
  CONSTRAINT `fk_productos_tipo_producto1`
    FOREIGN KEY (`tipo_id_tipo`)
    REFERENCES `Pizzeria`.`tipo` (`id_tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productos_categoria_pizza1`
    FOREIGN KEY (`categoria_pizza_id_categoria_pizza`)
    REFERENCES `Pizzeria`.`categoria_pizza` (`id_categoria_pizza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`pedido_has_producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Pizzeria`.`pedido_has_producto` ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`pedido_has_producto` (
  `pedido_id_pedido` INT NOT NULL,
  `productos_id_producto` INT NOT NULL,
  PRIMARY KEY (`pedido_id_pedido`, `productos_id_producto`),
  INDEX `fk_pedido_has_producto_producto1_idx` (`productos_id_producto` ASC) VISIBLE,
  INDEX `fk_pedido_has_producto_pedido1_idx` (`pedido_id_pedido` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_has_producto_pedido1`
    FOREIGN KEY (`pedido_id_pedido`)
    REFERENCES `Pizzeria`.`pedido` (`id_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_has_producto_producto1`
    FOREIGN KEY (`productos_id_producto`)
    REFERENCES `Pizzeria`.`productos` (`id_productos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
