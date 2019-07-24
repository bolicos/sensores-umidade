DROP TABLE users IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE sensors IF EXISTS;
DROP TABLE plants IF EXISTS;

CREATE TABLE users (
  id				INTEGER IDENTITY PRIMARY KEY,
  first_name      	VARCHAR(50),
  last_name			VARCHAR(50),
  email				VARCHAR(30)
);
CREATE TABLE types (
  id			INTEGER IDENTITY PRIMARY KEY,
  name      	VARCHAR(20),
  trackmin		INTEGER,
  trackmax		INTEGER,
  user_id		INTEGER NOT NULL
);
ALTER TABLE types ADD CONSTRAINT fk_types_users FOREIGN KEY (user_id) REFERENCES users (id);

CREATE TABLE sensors (
  id			INTEGER IDENTITY PRIMARY KEY,
  name      	VARCHAR(20)
);

CREATE TABLE plants (
  id			INTEGER IDENTITY PRIMARY KEY,
  sensor_id 	INTEGER NOT NULL,
  type_id		INTEGER NOT NULL,
  humidity  	INTEGER,
  status		VARCHAR(30),
  data_time		TIMESTAMP
);
ALTER TABLE plants ADD CONSTRAINT fk_plants_sensors FOREIGN KEY (sensor_id) REFERENCES sensors (id);
ALTER TABLE plants ADD CONSTRAINT fk_plants_types FOREIGN KEY (type_id) REFERENCES types (id);