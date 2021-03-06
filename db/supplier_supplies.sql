CREATE TABLE "SUPPLIER_SUPPLIES"(
    SUPPLY_ID INTEGER NOT NULL,
    SUPPLIER_ID INTEGER NOT NULL,
    STOCK_QUANTITY INTEGER NOT NULL,
    FOREIGN KEY(SUPPLY_ID) REFERENCES SUPPLY(SUPPLY_ID),
    FOREIGN KEY(SUPPLIER_ID) REFERENCES SUPPLIER(SUPPLIER_ID),
    PRIMARY KEY(SUPPLY_ID, SUPPLIER_ID)
);

INSERT INTO "SUPPLIER_SUPPLIES" ("SUPPLY_ID", "SUPPLIER_ID", "STOCK_QUANTITY") VALUES (
    1, 1, 156
);