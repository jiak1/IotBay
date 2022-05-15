DROP TABLE USERDB;

CREATE TABLE USERDB(
    USERID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    "NAME" VARCHAR(50) NOT NULL,
    DOB DATE NOT NULL,
    PHONE VARCHAR(12) NOT NULL,
    ADDRESS VARCHAR(100) NOT NULL,
    EMAIL VARCHAR(50) UNIQUE NOT NULL,
    PASSWORD VARCHAR(50) NOT NULL,
    ADMINACCESS BOOLEAN,
    DEACTIVATED BOOLEAN DEFAULT FALSE NOT NULL,
    PRIMARY KEY(USERID)
);

INSERT INTO USERDB ("NAME",DOB,PHONE,ADDRESS,EMAIL,PASSWORD,ADMINACCESS)
VALUES 
    ('Harry Styles','1966-06-16', '4444444', '1 Admin Pl ADMIN NSW 2000', 'admin@uts.com','admin',true),
    ('John Smith','1997-11-01', '95959595', '12 John Pl JOHN NSW 2000', 'john.smith@uts.com','hello123',false),
    ('David Alen Jones','1998-05-17', '95950000', '12 Alen Pl ALEN NSW 2000', 'alen.david@example.com','demo123',false),
    ('Jim Lee','2007-01-01', '95000055', '12 Jim Pl JIM NSW 2000', 'jim.l@uts.com','jim123',false),
    ('Emilia Adams','2001-03-11', '88889999', '12 Emilia Pl EMILIA NSW 2000', 'emilia.a@gmail.com','adams123',false),
    ('Carl Ridle','1999-08-21','91910011', '12 Carl Pl CARL NSW 2000', 'carl.r@uts.com','mmm123',false),
    ('Paula Costa','1991-05-11','95591001', '12 Paula Pl PAULA NSW 2000', 'paula.costa@uts.com','uts123',false),
    ('Jessica Jones','1993-07-03','95957775', '12 Jess Pl JESS NSW 2000', 'jess.jones@example.com','hijess123',false),
    ('Carol Knox','2001-05-15','88880000', '12 Carol Pl CAROL NSW 2000', 'carol.k@gmail.com','knox123',false),
    ('Andreas Brehme','2002-06-18', '88009595', '12 Andy Pl ANDY NSW 2000', 'andy.b@uts.com','ger123',false);

SELECT * FROM USERDB;



