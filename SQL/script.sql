CREATE DATABASE `assignment_project`;

CREATE TABLE `assignment_project`.`flight_data` (
  `flight_number` VARCHAR(50) NOT NULL, 
  `hex` VARCHAR(255) NOT NULL, 
  `reg_number` VARCHAR(255) NOT NULL, 
  `lat` DECIMAL NOT NULL, 
  `lng` DECIMAL NOT NULL, 
  `alt` INT(10) NOT NULL, 
  `arr_iata` VARCHAR(255) NOT NULL, 
  `dep_iata` VARCHAR(255) NOT NULL, 
  `flag` VARCHAR(3) NOT NULL, 
  `speed` INT(6) NOT NULL, 
  `status` VARCHAR(255) NOT NULL, 
  `is_active` BOOLEAN NOT NULL DEFAULT TRUE, 
  `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  `updated_date` TIMESTAMP NULL DEFAULT NULL, 
  PRIMARY KEY (
    `flight_number`(50)
  )
) ENGINE = InnoDB;
