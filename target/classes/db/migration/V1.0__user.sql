CREATE TABLE users (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR (100) NOT NULL,
password VARCHAR (100) NOT NULL,
UNIQUE INDEX (username)
);