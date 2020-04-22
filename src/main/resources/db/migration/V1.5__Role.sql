CREATE TABLE user_roles (
    user_id INT NOT NULL REFERENCES users (id),
    role VARCHAR(100) NOT NULL,
    PRIMARY KEY (user_id, role)
);


