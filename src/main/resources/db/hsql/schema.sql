DROP TABLE strawberries IF EXISTS;
DROP TABLE cacti IF EXISTS;
DROP TABLE mushrooms IF EXISTS;
DROP TABLE violets IF EXISTS;
DROP TABLE lavenders IF EXISTS;


CREATE TABLE strawberries (
  id			INTEGER IDENTITY PRIMARY KEY,
  idsensor 		INTEGER,
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);
CREATE TABLE cacti (
  id			INTEGER IDENTITY PRIMARY KEY,
  idsensor 		INTEGER,
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);
CREATE TABLE mushrooms (
  id			INTEGER IDENTITY PRIMARY KEY,
  idsensor 		INTEGER,
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);
CREATE TABLE violets (
  id			INTEGER IDENTITY PRIMARY KEY,
  idsensor 		INTEGER,
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);
CREATE TABLE lavenders (
  id			INTEGER IDENTITY PRIMARY KEY,
  idsensor 		INTEGER,
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);