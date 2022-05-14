DROP TABLE ORDERDB;

CREATE TABLE ORDERDB(
    ORDERID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 300000, INCREMENT BY 1),
    USERID INTEGER NOT NULL,
    STATUS VARCHAR(20),
    O_DATE DATE NOT NULL,
    O_QUANTITY INTEGER NOT NULL,
    PRIMARY KEY(ORDERID)
);

INSERT INTO ORDERDB (USERID,STATUS,O_DATE,O_QUANTITY)
VALUES 
    (100000, 'AWAITING PAYMENT', '2018-12-12', 12),
    (100001, 'AWAITING PACKAGING', '2018-12-12', 2),
    (100002, 'AWAITING DELIVERY', '2018-12-12', 23),
    (100003, 'DELIVERED', '2018-12-12', 7),
    (100004, 'REVOKED', '2018-12-12', 16);

SELECT * FROM ORDERDB;