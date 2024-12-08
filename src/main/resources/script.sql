CREATE TABLE IF NOT EXISTS emp
(
    id       INT NOT NULL AUTO_INCREMENT,
    name     VARCHAR(255),
    fonction VARCHAR(255),
    salaire  DOUBLE,
    PRIMARY KEY (id)
);