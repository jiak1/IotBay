CREATE TABLE "STAFF"(
    STAFF_ID INTEGER PRIMARY KEY,
    "ROLE" VARCHAR(30) NOT NULL,
    FOREIGN KEY(STAFF_ID) REFERENCES ACCOUNT(USER_ID)
);

INSERT INTO "STAFF" ("STAFF_ID", "ROLE") VALUES (
    1, 'Supplier'
);