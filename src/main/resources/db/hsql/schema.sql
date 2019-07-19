DROP TABLE plants IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE sensors IF EXISTS;


CREATE TABLE plants (
  id			INTEGER IDENTITY PRIMARY KEY,
  sensor_id 	INTEGER,
  type_id		INTEGER,
  humidity  	INTEGER,
  status		VARCHAR(30),
  trackmin		INTEGER,
  trackmax		INTEGER,
  dataTime		DATE
);
ALTER TABLE plants ADD CONSTRAINT fk_plants_sensors FOREIGN KEY (sensor_id) REFERENCES sensors (id);
ALTER TABLE plants ADD CONSTRAINT fk_plants_types FOREIGN KEY (type_id) REFERENCES types (id);

CREATE TABLE types (
  id			INTEGER IDENTITY PRIMARY KEY,
  name      	VARCHAR(20)
);
CREATE TABLE sensors (
  id			INTEGER IDENTITY PRIMARY KEY
);