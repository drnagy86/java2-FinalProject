DROP DATABASE IF EXISTS cars;
CREATE DATABASE cars;

/* *****************************************************************************
    Create statement for table Car
***************************************************************************** */
DROP TABLE IF EXISTS Car;
CREATE TABLE Car(
    licensePlate VARCHAR(25) NOT NULL, 
    make VARCHAR(256) NOT NULL, 
    model VARCHAR(256) NOT NULL, 
    modelYear INT NOT NULL, 
    PRIMARY KEY(licensePlate)
);

/* *****************************************************************************
    Build Stored Procedure sp_add_Car
***************************************************************************** */
DELIMITER $$
CREATE PROCEDURE sp_add_Car(
    IN p_licensePlate VARCHAR(25),
    IN p_make VARCHAR(256), 
    IN p_model VARCHAR(256),
    IN p_modelYear INT
)
BEGIN
    INSERT INTO Car(
        licensePlate,
        make,
        model,
        modelYear
    )
    VALUES (
        p_licensePlate,
        p_make,
        p_model,
        p_modelYear
    );
END$$
DELIMITER ;

/* *****************************************************************************
    Build Stored Procedure sp_get_Car_by_License_Plate
***************************************************************************** */
DELIMITER $$
CREATE PROCEDURE sp_get_Car_by_License_Plate(
    IN p_licensePlate VARCHAR(25)
) 
BEGIN
    SELECT licensePlate, make, model, modelYear
    FROM Car
    WHERE licensePlate = p_licensePlate;
END$$
DELIMITER ;

/* *****************************************************************************
    Build Stored Procedure sp_get_all_Cars
***************************************************************************** */
DELIMITER $$
CREATE PROCEDURE sp_get_all_Cars( 
)
BEGIN
    SELECT licensePlate, make, model, modelYear
    FROM Car;
END$$
DELIMITER ;

/* *****************************************************************************
    Build Stored Procedure sp_update_Car
***************************************************************************** */
DELIMITER $$
CREATE PROCEDURE sp_update_Car(
    IN p_original_licensePlate VARCHAR(25),
    IN p_updated_licensePlate VARCHAR(25),
    IN p_updated_make VARCHAR(256),
    IN p_updated_model VARCHAR(256),
    IN p_updated_modelYear INT
)
BEGIN
    -- Make sure the original record exists
    DECLARE var_record_count INT DEFAULT 0;
    
    SELECT COUNT(*) INTO var_record_count
    FROM Car
    WHERE licensePlate = p_original_licensePlate;
    
    IF var_record_count <> 1 THEN
        SIGNAL SQLSTATE '53000'
        SET MESSAGE_TEXT = 'Cannot update; no such record.';
    END IF;
    
    -- Update the record
    UPDATE Car
        SET licensePlate = p_updated_licensePlate,
        make = p_updated_make,
        model = p_updated_model,
        modelYear = p_updated_modelYear
    WHERE licensePlate = p_original_licensePlate;
        
    SELECT ROW_COUNT() AS 'Updated';
END$$
DELIMITER ;

/* *****************************************************************************
    Build Stored Procedure sp_delete_from_Car
***************************************************************************** */
DELIMITER $$
CREATE PROCEDURE sp_delete_from_Car(
    IN p_original_licensePlate VARCHAR(25)
)
BEGIN
    DELETE FROM Car
    WHERE licensePlate = p_original_licensePlate;
    
    SELECT ROW_COUNT() AS 'Deleted';
END$$
DELIMITER ;

/* *****************************************************************************
    Add some data
***************************************************************************** */
CALL sp_add_Car('ECTO-1','Cadillac','Miller-Meteor Sentinel',1959);
CALL sp_add_Car('NRVOUS','Ferrari','250 GT California Spyder',1961);
CALL sp_add_Car('BANDIT','Pontiac','Trans Am',1977);
CALL sp_add_Car('OUTATIME','DMC','DeLorean',1981);
CALL sp_add_Car('LUV ME','Ferrari','308GTSi',1981);
CALL sp_add_Car('STARK 33','Acura','NSX',2012);

/* *****************************************************************************
    Create a user and grant permission to execute the stored procedures.
***************************************************************************** */
DROP USER IF EXISTS 'java2user'@'%';
CREATE USER 'java2user'@'%' IDENTIFIED BY 'password';

GRANT EXECUTE ON PROCEDURE cars.sp_add_Car TO 'java2user'@'%';
GRANT EXECUTE ON PROCEDURE cars.sp_get_Car_by_License_Plate TO 'java2user'@'%';
GRANT EXECUTE ON PROCEDURE cars.sp_get_all_Cars TO 'java2user'@'%';
GRANT EXECUTE ON PROCEDURE cars.sp_update_Car TO 'java2user'@'%';
GRANT EXECUTE ON PROCEDURE cars.sp_delete_from_Car TO 'java2user'@'%';

/* *****************************************************************************
                               END OF SCRIPT    
***************************************************************************** */