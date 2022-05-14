DROP TABLE IOTUSER.PRODUCTIMAGEDB;

CREATE TABLE IOTUSER.PRODUCTIMAGEDB(
    CATEGORY VARCHAR(40) NOT NULL,
    IMAGES VARCHAR(40) NOT NULL,
    PRIMARY KEY(CATEGORY)
);

INSERT INTO IOTUSER.PRODUCTIMAGEDB (CATEGORY,IMAGES)
VALUES 
    ('Wearable Tech', 'Smartwatch.jpg'),
    ('Gaming Console', 'Gaming_Console.jpg'),
    ('Smart TV', 'Smart_TV.jpg'), 
    ('Voice control device', 'Voice_Control_Device.jpg'),
    ('Printer', 'Printer.jpg'),
    ('Camera', 'Camera.jpg'),
    ('Lights',  'Lights.jpg'),
    ('Thermostat', 'Thermostat.jpg'),
    ('E-reader', 'E-reader.jpg'),
    ('Other', 'Iot.png')

SELECT * FROM IOTUSER.PRODUCTIMAGEDB;
