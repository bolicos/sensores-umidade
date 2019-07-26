DROP TABLE roles IF EXISTS;
DROP TABLE users IF EXISTS;
DROP TABLE types IF EXISTS;
DROP TABLE sensors IF EXISTS;
DROP TABLE plants IF EXISTS;
DROP TABLE reads IF EXISTS;

CREATE TABLE roles (
  id              INTEGER IDENTITY PRIMARY KEY,
  role            VARCHAR(20) NOT NULL
);
CREATE TABLE users (
  username			VARCHAR(20) NOT NULL,
  password			VARCHAR(30) NOT NULL,
  passwrd_confirm	VARCHAR(30),
  first_name      	VARCHAR(50) NOT NULL,
  last_name			VARCHAR(50) NOT NULL,
  email				VARCHAR(30) NOT NULL,
  enabled   		BOOLEAN DEFAULT TRUE NOT NULL,
  role_id			INTEGER,
  PRIMARY KEY (username)
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
  username			VARCHAR(20) NOT NULL,
  plant_id			INTEGER NOT NULL
);
ALTER TABLE sensors ADD CONSTRAINT fk_sensors_users FOREIGN KEY (username) REFERENCES users (username);
ALTER TABLE sensors ADD CONSTRAINT fk_sensors_plants FOREIGN KEY (plant_id) REFERENCES plants (id);

CREATE TABLE reads (
 id					INTEGER IDENTITY PRIMARY KEY,
 sensor_id			INTEGER NOT NULL,
 humidity			INTEGER NOT NULL,
 status				BOOLEAN NOT NULL,
 date_time			TIMESTAMP NOT NULL
);
ALTER TABLE reads ADD CONSTRAINT fk_reads_sensors FOREIGN KEY (sensor_id) REFERENCES sensors (id);