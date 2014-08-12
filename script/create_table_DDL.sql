DROP TABLE IF EXISTS PUBLIC.LOCATION;
CREATE TABLE PUBLIC.LOCATION(
ID INTEGER NOT NULL,
ADDRESS  varchar(255),
LATITUDE varchar(255),
LONGITUDE varchar(255),
ABBREVIATION varchar(255),
CONSTRAINT LOCATION_PKEY_ID PRIMARY KEY(ID)
);


DROP TABLE IF EXISTS PUBLIC.ROUTE;
CREATE TABLE PUBLIC.ROUTE(
ID INTEGER NOT NULL,
PICKUP INTEGER REFERENCES LOCATION(ID),
DROPOFF INTEGER REFERENCES LOCATION(ID),
CONSTRAINT ROUTE_PKEY_ID PRIMARY KEY(ID)
);

DROP TABLE IF EXISTS PUBLIC.SCHEDULE;
CREATE TABLE PUBLIC.SCHEDULE
(
  ID INTEGER NOT NULL,
  ROUTE INTEGER REFERENCES ROUTE(ID),
  DEPARTURETIME TIME WITH TIME ZONE,
  DEPARTUREDATE DATE,
  PRICE DOUBLE PRECISION -- CURRENT PRICE
  LENGTH DOUBLE PRECISION -- TRIP TIME
  CONSTRAINT SCHEDULE_PKEY_ID PRIMARY KEY(ID)
);