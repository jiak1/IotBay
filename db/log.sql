CREATE TABLE "LOG"(
    LOG_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1,  INCREMENT BY 1),
    SUPPLY_ID INTEGER NOT NULL,
    CUSTOMER_ID INTEGER NOT NULL,
    DETAILS VARCHAR(1000) NOT NULL,
    LOG_DATE DATE NOT NULL,
    FOREIGN KEY(SUPPLY_ID) REFERENCES SUPPLY(SUPPLY_ID),
    FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID),
    PRIMARY KEY(LOG_ID, SUPPLY_ID, CUSTOMER_ID)
);

INSERT INTO "LOG" ("SUPPLY_ID", "CUSTOMER_ID", "DETAILS", "LOG_DATE") VALUES (
    1, 1, 'Complained about loading times', '2022-05-03'
);