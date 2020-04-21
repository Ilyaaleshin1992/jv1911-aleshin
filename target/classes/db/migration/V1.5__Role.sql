CREATE TABLE roles (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(100) NOT NULL,
    UNIQUE INDEX (role)
);

CREATE TABLE user_roles (
    user_id INT NOT NULL REFERENCES users (id),
    role_id INT NOT NULL REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);


