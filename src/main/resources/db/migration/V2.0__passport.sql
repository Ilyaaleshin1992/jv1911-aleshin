CREATE TABLE contact_informations (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
surnames VARCHAR(100) NOT NUll,
names VARCHAR(100) NOT NUll,
patronymics VARCHAR(100) NOT NUll
);

CREATE TABLE user_address (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
indexes INT NOT NULL,
owner_mail VARCHAR(100) NOT NUll,
regions VARCHAR(100) NOT NUll,
city VARCHAR(100) NOT NUll,
streets VARCHAR(100) NOT NUll,
houses VARCHAR(100) NOT NUll,
building VARCHAR(100) NOT NUll,
apartments VARCHAR(100) NOT NUll,
status_address VARCHAR(100) NOT NUll,
contact_information_id INT NOT NULL REFERENCES contact_informations(id)

);

CREATE TABLE user_mails (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
names VARCHAR(100) NOT NUll,
contact_information_id INT REFERENCES contact_informations(id)
);

CREATE TABLE user_telephones (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
numbers VARCHAR(100) NOT NULL,
contact_information_id INT REFERENCES contact_informations(id)
);

CREATE TABLE passports (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
series INT NOT NULL,
numbers INT NOT NULL,
date_births date Not null,
place_births VARCHAR(100) NOT NUll,
date_issues date Not null,
division_codes INT NOT NULL,
who_issued VARCHAR(100) NOT NUll,
owner_id INT NOT NULL REFERENCES users(id),
owner_passport_id INT REFERENCES passports(id)
);

ALTER TABLE users ADD COLUMN contact_informations INT REFERENCES users (id);
