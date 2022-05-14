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
    (300000, 200010, 509.99, 1, 'Apple TV Set Top Box', 'ADELAIDE'),
    (300001, 200011, 99.99, 1, 'Sony VR Headset', 'MELBOURNE'),
    (300002, 200012, 400.97, 2, 'Apple VR Headset', 'PERTH'),
    (300003, 200013, 119.99, 1, 'Google VR Headset', 'BRISBANE'),
    (300004, 200014, 229.99, 1, 'Siri Voice', 'MELBOURNE');

SELECT * FROM ORDERLINEITEMDB;