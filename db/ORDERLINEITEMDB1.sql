DROP TABLE ORDERLINEITEMDB;

CREATE TABLE ORDERLINEITEMDB(
    ORDERLINEITEMID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 400000, INCREMENT BY 1),
    ORDERID INTEGER NOT NULL,
    PRODUCTID INTEGER NOT NULL,
    COST DOUBLE NOT NULL,
    QTY INTEGER NOT NULL,
    "NAME" VARCHAR(40),
    LOCATION VARCHAR(100),
    PRIMARY KEY(ORDERLINEITEMID)
);

INSERT INTO ORDERLINEITEMDB (ORDERID,PRODUCTID, COST, QTY, "NAME", LOCATION)
VALUES 
    (200000,200000,509.99,1,'SYDNEY','Apple Smart Watch'),
    (200001,200001,259.99,1,'MELBOURNE','Galaxy Smart Watch'),
    (200002,200002,209.99, 1,'BRISBANE','Playstation4'),
    (200003,200003,339.99, 1,'SYDNEY','Playstation5'),
    (200004,200004,389.99,1,'PERTH','XBOX One'),
    (200005,200005,139.99,1,'MELBOURNE','Nintendo Switch'),
    (200006,200006,1509.99,1,'BRISBANE','Samsung 4K UHD TV'), 
    (200007,200007,2209.99, 1,'PERTH','Sony 4K UHD TV'),
    (200008,200008,1709.99, 1,'SYDNEY','Panasonic 4K UHD TV'),
    (200009,200009,59.99, 6, 'ADELAIDE','Generic Set Top Box'),
    (200010,200010,509.99,1,'ADELAIDE','Apple TV Set Top Box'),
    (200011,200011,99.99,1,'MELBOURNE','Sony VR Headset'), 
    (200012,200012,199.99,1,'PERTH','Apple VR Headset'),
    (200013,200013,119.99,1,'BRISBANE','Google VR Headset'),
    (200014,200014,229.99,1,'MELBOURNE','Siri Voice'),
    (200015,200015,199.99, 1, 'PERTH','Apple Voice'),
    (200016,200016,599.99, 1,'BRISBANE','Premium 3D Printer'),
    (200017,200017,399.99, 1,'SYDNEY','Half size 3D Printer'),
    (200018,200018,39.99,1, 'PERTH','Laser Printer'),
    (200019,200019,99.99, 1,'MELBOURNE','20 security camera set'),
    (200020,200020,19.99, 1,'BRISBANE','Web cam'),
    (200021,200021,79.99,1, 'PERTH','Night vision camera'),
    (200022,200022,9.99, 1,'MELBOURNE','Smart Light bulb'),
    (200023,200023,79.99,1,'SYDNEY','Automated Light System'),
    (200024,200024,49.99,1,'BRISBANE','Adaptive light solution set'),
    (200025,200025,99.99, 1,'MELBOURNE','Googles nest eco-set'),
    (200026,200026,69.99, 1,'PERTH','ecobee thermostat system'),
    (200027,200027,49.99, 1,'SYDNEY','Honeywell eco-warmth system'),
    (200028,200028,99.99, 1,'BRISBANE','Galaxy pad'),
    (200029,200029,69.99,1, 'SYDNEY','Kobo eReader'),
    (200030,200030,49.99, 1, 'MELBOURNE','Kindle'),
    (200031,200031,49.99, 1, 'PERTH','Paperwhite');

SELECT * FROM ORDERLINEITEMDB;