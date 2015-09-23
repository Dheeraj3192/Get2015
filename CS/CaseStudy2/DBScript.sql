Create DATABASE vehicle;

USE vehicle;

DROP TABLE  IF EXISTS vehicle ;

CREATE TABLE  vehicle (
	vehicle_id INTEGER AUTO_INCREMENT NOT NULL,
	make_year VARCHAR(5) NOT NULL,
	modal VARCHAR(30) NOT NULL ,
	engine_in_cc INTEGER NOT NULL,
	fuel_capacity INTEGER NOT NULL,
	milage DOUBLE NOT NULL,
	price DOUBLE NOT NULL,
	road_tax DOUBLE NOT NULL ,
	created_by  VARCHAR(30) NOT NULL ,
	created_time DATE NOT NULL ,
	vehicle_type INT(1) NOT NULL ,
	PRIMARY KEY(vehicle_id)
);

DROP TABLE  IF EXISTS car ;

CREATE TABLE car (
	car_id INTEGER AUTO_INCREMENT NOT NULL,
	has_ac TINYINT(1) NOT NULL DEFAULT 0,
	has_power_steering  TINYINT(1) NOT NULL DEFAULT 0,
	has_accessory_kit  TINYINT(1) NOT NULL DEFAULT 0 ,
	vehicle_id INTEGER ,
	PRIMARY KEY(car_id) ,
	CONSTRAINT fk_car_id FOREIGN KEY (vehicle_id) REFERENCES vehicle (vehicle_id) ON DELETE CASCADE 
);

DROP TABLE  IF EXISTS bike ;


CREATE TABLE bike (
	bike_id INTEGER  AUTO_INCREMENT NOT NULL,
	is_self_start  TINYINT(1) NOT NULL DEFAULT 0,
	helmet_price INTEGER NOT NULL,
	vehicle_id INTEGER  ,
	PRIMARY KEY(bike_id) ,
	CONSTRAINT fk_bike_id FOREIGN KEY (vehicle_id) REFERENCES vehicle (vehicle_id) ON DELETE CASCADE 
);

DROP TRIGGER IF EXISTS initVehicleIdcar ;

DELIMITER ;;
CREATE TRIGGER initVehicleIdCar before INSERT ON car FOR EACH ROW
BEGIN
      SET NEW.vehicle_id = (SELECT LAST_INSERT_ID() from vehicle limit 1);
END;;
DELIMITER ;


DROP TRIGGER IF EXISTS initVehicleIdbike ;

DELIMITER ;;
CREATE TRIGGER initVehicleIdBike BEFORE INSERT ON bike FOR EACH ROW
BEGIN
      SET NEW.vehicle_id = (SELECT LAST_INSERT_ID() from vehicle limit 1);
END;;
DELIMITER ;







