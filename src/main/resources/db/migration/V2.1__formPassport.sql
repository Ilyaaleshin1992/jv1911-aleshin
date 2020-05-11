CREATE TABLE model_form_passports (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
surnames VARCHAR(100) ,
names VARCHAR(100) ,
patronymics VARCHAR(100) ,
telephones VARCHAR(100) ,
mails VARCHAR(100) ,
series INT ,
numbers INT ,
date_births VARCHAR(100) ,
place_births VARCHAR(100) ,
division_codes INT ,
date_issues VARCHAR(100) ,
who_issued VARCHAR(100),
indexes INT,
regions VARCHAR(100),
city VARCHAR(100),
streets VARCHAR(100),
houses VARCHAR(100),
building VARCHAR(100),
apartments VARCHAR(100),
status_applications BOOL
);


