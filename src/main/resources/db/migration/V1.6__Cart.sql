CREATE TABLE carts (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    number_cart INT,
    owner_id INT REFERENCES account (number)
);


