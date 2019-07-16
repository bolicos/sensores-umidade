DROP TABLE sensor1 IF EXISTS;
DROP TABLE sensor2 IF EXISTS;
DROP TABLE sensor3 IF EXISTS;
DROP TABLE sensor4 IF EXISTS;
DROP TABLE sensor5 IF EXISTS;


CREATE TABLE sensor1 (
  id			INTEGER IDENTITY PRIMARY KEY,
  name 			VARCHAR(30),
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);
CREATE TABLE sensor2 (
  id			INTEGER IDENTITY PRIMARY KEY,
  name 			VARCHAR(30),
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);
CREATE TABLE sensor3 (
  id			INTEGER IDENTITY PRIMARY KEY,
  name 			VARCHAR(30),
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);
CREATE TABLE sensor4 (
  id			INTEGER IDENTITY PRIMARY KEY,
  name 			VARCHAR(30),
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);
CREATE TABLE sensor5 (
  id			INTEGER IDENTITY PRIMARY KEY,
  name 			VARCHAR(30),
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);