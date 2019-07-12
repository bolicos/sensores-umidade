DROP TABLE sensors IF EXISTS;


CREATE TABLE sensors (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(80),
  plant VARCHAR(30),
  track VARCHAR(30),
  humidity INTEGER
);
CREATE INDEX sensors_name ON sensors (name);