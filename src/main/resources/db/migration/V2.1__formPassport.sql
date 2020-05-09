CREATE TABLE model_form_passports (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
surnames VARCHAR(100) NOT NUll,
names VARCHAR(100) NOT NUll,
patronymics VARCHAR(100) NOT NUll,
telephones VARCHAR(100) NOT NULL,
mails VARCHAR(100) NOT NUll,
series INT NOT NULL,
numbers INT NOT NULL,
date_births VARCHAR(100) Not null,
place_births VARCHAR(100) NOT NUll,
division_codes INT NOT NULL,
date_issues VARCHAR(100) Not null,
who_issued VARCHAR(100) NOT NUll,
indexes INT NOT NULL,
regions VARCHAR(100) NOT NUll,
city VARCHAR(100) NOT NUll,
streets VARCHAR(100) NOT NUll,
houses VARCHAR(100) NOT NUll,
building VARCHAR(100) NOT NUll,
apartments VARCHAR(100) NOT NUll,
status_applications BOOL not null
);


