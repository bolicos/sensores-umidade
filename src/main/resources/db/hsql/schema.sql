DROP TABLE users IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE sensors IF EXISTS;
DROP TABLE plants IF EXISTS;
DROP TABLE reads IF EXISTS;

CREATE TABLE users (
  id				INTEGER IDENTITY PRIMARY KEY,
  first_name      	VARCHAR(50),
  last_name			VARCHAR(50),
  email				VARCHAR(30),
  user_name			VARCHAR(20),
  password			VARCHAR(30)
);
CREATE TABLE types (
  id				INTEGER IDENTITY PRIMARY KEY,
  name      		VARCHAR(20),
  trackmin			INTEGER,
  trackmax			INTEGER
);

CREATE TABLE plants (
  id				INTEGER IDENTITY PRIMARY KEY,
  type_id			INTEGER NOT NULL
);
ALTER TABLE plants ADD CONSTRAINT fk_plants_types FOREIGN KEY (type_id) REFERENCES types (id);

CREATE TABLE sensors (
  id				INTEGER IDENTITY PRIMARY KEY,
  name      		VARCHAR(50),
  user_id			INTEGER NOT NULL,
  plant_id			INTEGER NOT NULL
);
ALTER TABLE sensors ADD CONSTRAINT fk_sensors_users FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE sensors ADD CONSTRAINT fk_sensors_plants FOREIGN KEY (plant_id) REFERENCES plants (id);

CREATE TABLE reads (
 id					INTEGER IDENTITY PRIMARY KEY,
 sensor_id			INTEGER NOT NULL,
 humidity			INTEGER,
 status				BOOLEAN,
 date_time			TIMESTAMP
);
ALTER TABLE reads ADD CONSTRAINT fk_reads_sensors FOREIGN KEY (sensor_id) REFERENCES sensors (id);