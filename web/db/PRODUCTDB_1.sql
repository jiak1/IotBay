DROP TABLE PRODUCTDB;

CREATE TABLE PRODUCTDB(
    PRODUCTID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 200000, INCREMENT BY 1),
    "NAME" VARCHAR(100) UNIQUE NOT NULL,
    PRICE DOUBLE NOT NULL,
    TAX DOUBLE NOT NULL,
    ADDED_DT DATE NOT NULL,
    EXPIRY_DT DATE,
    QUANTITY INTEGER NOT NULL,
    CATEGORY VARCHAR(40),
    LOCATION VARCHAR(40),
    PRIMARY KEY(PRODUCTID)
);

INSERT INTO PRODUCTDB ("NAME",PRICE,TAX,ADDED_DT,EXPIRY_DT,QUANTITY,CATEGORY,LOCATION)
VALUES 
    ('Apple Smart Watch',509.99, 51.00, '2018-12-12', '2030-12-15', 25, 'Wearable Tech', 'SYDNEY'),
    ('Galaxy Smart Watch',259.99, 26.00, '2017-12-12', '2040-12-15', 45, 'Wearable Tech', 'MELBOURNE'),
    ('Playstation4',209.99, 21.00, '2016-12-12', '2050-12-15', 35, 'Gaming Console', 'BRISBANE'),
    ('Playstation5',339.99, 34.00, '2016-12-12', '2050-12-15', 5, 'Gaming Console', 'SYDNEY'),
    ('XBOX One',389.99, 39.00, '2016-12-12', '2050-12-15', 35, 'Gaming Console', 'PERTH'),
    ('Nintendo Switch',139.99, 14.00, '2016-12-12', '2050-12-15', 22, 'Gaming Console', 'MELBOURNE'),
    ('Samsung 4K UHD TV',1509.99, 151.00, '2016-12-12', '2050-12-15', 35, 'Smart TV', 'BRISBANE'), 
    ('Sony 4K UHD TV',2209.99, 221.00, '2016-12-12', '2050-12-15', 35, 'Smart TV', 'PERTH'),
    ('Panasonic 4K UHD TV',1709.99, 171.00, '2016-12-12', '2050-12-15', 35, 'Smart TV', 'SYDNEY'),
    ('Generic Set Top Box',59.99, 6.00, '2016-12-12', '2050-12-15', 35, 'Smart TV', 'ADELAIDE'),
    ('Apple TV Set Top Box',509.99, 51.00, '2016-12-12', '2050-12-15', 35, 'Smart TV', 'ADELAIDE'),
    ('Sony VR Headset',99.99, 10.00, '2016-12-12', '2050-12-15', 35, 'Smart TV', 'MELBOURNE'), 
    ('Apple VR Headset',199.99, 20.00, '2016-12-12', '2050-12-15', 35, 'Smart TV', 'PERTH'),
    ('Google VR Headset',119.99, 12.00, '2016-12-12', '2050-12-15', 35, 'Smart TV', 'BRISBANE'),
    ('Siri Voice',229.99, 23.00, '2016-12-12', '2050-12-15', 35, 'Voice control device', 'MELBOURNE'),
    ('Apple Voice',199.99, 20.00, '2016-12-12', '2050-12-15', 35, 'Voice control device', 'PERTH'),
    ('Premium 3D Printer',599.99, 60.00, '2016-12-12', '2050-12-15', 35, 'Printer', 'BRISBANE'),
    ('Half size 3D Printer',399.99, 40.00, '2016-12-12', '2050-12-15', 35, 'Printer', 'SYDNEY'),
    ('Laser Printer',39.99, 4.00, '2016-12-12', '2050-12-15', 35, 'Printer', 'PERTH'),
    ('20 security camera set',99.99, 10.00, '2016-12-12', '2050-12-15', 35, 'Camera', 'MELBOURNE'),
    ('Web cam',19.99, 2.00, '2016-12-12', '2050-12-15', 35, 'Camera', 'BRISBANE'),
    ('Night vision camera',79.99, 8.00, '2016-12-12', '2050-12-15', 35, 'Lights', 'PERTH'),
    ('Smart Light bulb',9.99, 1.00, '2016-12-12', '2050-12-15', 35, 'Lights', 'MELBOURNE'),
    ('Automated Light System',79.99, 8.00, '2016-12-12', '2050-12-15', 15, 'Lights', 'SYDNEY'),
    ('Adaptive light solution set',49.99, 5.00, '2016-12-12', '2050-12-15', 35, 'Lights', 'BRISBANE'),
    ('Googles nest eco-set',99.99, 10.00, '2016-12-12', '2050-12-15', 35, 'Thermostat', 'MELBOURNE'),
    ('ecobee thermostat system',69.99, 7.00, '2016-12-12', '2050-12-15', 35, 'Thermostat', 'PERTH'),
    ('Honeywell eco-warmth system',49.99, 5.00, '2016-12-12', '2050-12-15', 15, 'Thermostat', 'SYDNEY'),
    ('Galaxy pad',99.99, 10.00, '2016-12-12', '2050-12-15', 35, 'E-reader', 'BRISBANE'),
    ('Kobo eReader',69.99, 7.00, '2016-12-12', '2050-12-15', 35, 'E-reader', 'SYDNEY'),
    ('Kindle',49.99, 5.00, '2016-12-12', '2050-12-15', 15, 'E-reader', 'MELBOURNE'),
    ('Paperwhite',49.99, 5.00, '2016-12-12', '2050-12-15', 35, 'E-reader', 'PERTH');

SELECT * FROM PRODUCTDB;

SELECT * FROM PRODUCTDB WHERE "NAME" LIKE '%Google%'

SELECT * FROM PRODUCTDB WHERE "NAME" LIKE '%Google%'