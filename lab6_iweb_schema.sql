-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema lab6sw1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema lab6sw1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lab6sw1` DEFAULT CHARACTER SET utf8mb3 ;
USE `lab6sw1` ;

-- -----------------------------------------------------
-- Table `lab6sw1`.`banda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`banda` (
  `idbanda` VARCHAR(3) NOT NULL,
  `nombre_banda` VARCHAR(30) NOT NULL,
  `artista_lider` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idbanda`),
  INDEX `fk_banda_artista1_idx` (`artista_lider` ASC) VISIBLE,
  CONSTRAINT `fk_banda_artista1`
    FOREIGN KEY (`artista_lider`)
    REFERENCES `lab6sw1`.`artista` (`idartista`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`instrumento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`instrumento` (
  `idinstrumento` VARCHAR(3) NOT NULL,
  `nombre_inst` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idinstrumento`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`artista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`artista` (
  `idartista` INT NOT NULL AUTO_INCREMENT,
  `nombre_artista` VARCHAR(30) NOT NULL,
  `instrumento` VARCHAR(3) NOT NULL,
  `banda` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idartista`),
  INDEX `fk_artista_instrumento1_idx` (`instrumento` ASC) VISIBLE,
  INDEX `fk_artista_banda1_idx` (`banda` ASC) VISIBLE,
  CONSTRAINT `fk_artista_banda1`
    FOREIGN KEY (`banda`)
    REFERENCES `lab6sw1`.`banda` (`idbanda`),
  CONSTRAINT `fk_artista_instrumento1`
    FOREIGN KEY (`instrumento`)
    REFERENCES `lab6sw1`.`instrumento` (`idinstrumento`))
ENGINE = InnoDB
AUTO_INCREMENT = 16
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`cancion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`cancion` (
  `idcancion` INT NOT NULL AUTO_INCREMENT,
  `nombre_cancion` VARCHAR(40) NOT NULL,
  `banda` VARCHAR(3) NOT NULL,
  `playlist_idplaylist` VARCHAR(4) NULL DEFAULT NULL,
  PRIMARY KEY (`idcancion`),
  INDEX `fk_cancion_banda1_idx` (`banda` ASC) VISIBLE,
  CONSTRAINT `fk_cancion_banda1`
    FOREIGN KEY (`banda`)
    REFERENCES `lab6sw1`.`banda` (`idbanda`))
ENGINE = InnoDB
AUTO_INCREMENT = 66
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`pais` (
  `idpais` VARCHAR(3) NOT NULL,
  `nombre_pais` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idpais`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`ciudad` (
  `idciudad` VARCHAR(3) NOT NULL,
  `nombre_ciudad` VARCHAR(20) NOT NULL,
  `pais` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idciudad`),
  INDEX `fk_ciudad_pais1_idx` (`pais` ASC) VISIBLE,
  CONSTRAINT `fk_ciudad_pais1`
    FOREIGN KEY (`pais`)
    REFERENCES `lab6sw1`.`pais` (`idpais`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`playlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`playlist` (
  `idplaylist` VARCHAR(4) NOT NULL,
  `nombre_playlist` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idplaylist`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`reproduccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`reproduccion` (
  `idreproduccion` INT NOT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `cancion_idcancion` INT NOT NULL,
  PRIMARY KEY (`idreproduccion`),
  INDEX `fk_reproduccion_cancion1_idx` (`cancion_idcancion` ASC) VISIBLE,
  CONSTRAINT `fk_reproduccion_cancion1`
    FOREIGN KEY (`cancion_idcancion`)
    REFERENCES `lab6sw1`.`cancion` (`idcancion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`tour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`tour` (
  `idtour` INT NOT NULL AUTO_INCREMENT,
  `nombre_tour` VARCHAR(30) NOT NULL,
  `banda` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`idtour`),
  INDEX `fk_tour_banda1_idx` (`banda` ASC) VISIBLE,
  CONSTRAINT `fk_tour_banda1`
    FOREIGN KEY (`banda`)
    REFERENCES `lab6sw1`.`banda` (`idbanda`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`tours_por_ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`tours_por_ciudad` (
  `tour` INT NOT NULL,
  `ciudad` VARCHAR(3) NOT NULL,
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`tour`, `ciudad`),
  INDEX `fk_tour_has_ciudad_ciudad1_idx` (`ciudad` ASC) VISIBLE,
  INDEX `fk_tour_has_ciudad_tour1_idx` (`tour` ASC) VISIBLE,
  CONSTRAINT `fk_tour_has_ciudad_ciudad1`
    FOREIGN KEY (`ciudad`)
    REFERENCES `lab6sw1`.`ciudad` (`idciudad`),
  CONSTRAINT `fk_tour_has_ciudad_tour1`
    FOREIGN KEY (`tour`)
    REFERENCES `lab6sw1`.`tour` (`idtour`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `lab6sw1`.`favorito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lab6sw1`.`favorito` (
  `idcancion` INT NOT NULL,
  `nombre_cancion` VARCHAR(40) NOT NULL,
  `banda` VARCHAR(3) NOT NULL,
  INDEX `fk_cancion_banda1_idx` (`banda` ASC) VISIBLE,
  CONSTRAINT `fk_cancion_banda10`
    FOREIGN KEY (`banda`)
    REFERENCES `lab6sw1`.`banda` (`idbanda`))
ENGINE = InnoDB
AUTO_INCREMENT = 66
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
