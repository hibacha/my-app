DROP TABLE  IF EXISTS PUBLIC.TICKET;
create table PUBLIC.TICKET(
ID INTEGER not null,
DEPARTURE_TIME timestamptz,
ARRIVAL_TIME timestamptz,
FARE NUMERIC(10,2),
CONSTRAINT ID_PKEY PRIMARY KEY (ID)
)

WITH (
  OIDS=FALSE
);