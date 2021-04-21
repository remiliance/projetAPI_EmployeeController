DROP TABLE IF EXISTS employees, Movie, Commande, Address, Company;


CREATE TABLE Address(
   id INT AUTO_INCREMENT  PRIMARY KEY,
   Street VARCHAR(250) NOT NULL
);






CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  address_id int,
  FOREIGN KEY (address_id) REFERENCES Address(id)
);

CREATE TABLE Company(
   id INT AUTO_INCREMENT  PRIMARY KEY,
   Name VARCHAR(250) NOT NULL,
   employee_id int,
   FOREIGN KEY (employee_id) REFERENCES employees(id)
);

CREATE TABLE Movie (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  DATE_DE_SORTIE VARCHAR(50) NOT NULL,
  RATING int (10) NOT NULL,
  NOM VARCHAR(250) NOT NULL,
  COUNTRY_CODE int (10) NOT NULL
);

CREATE TABLE Commande (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    PersonID int,
    MovieID int,
    FOREIGN KEY (PersonID) REFERENCES employees(id),
    FOREIGN KEY (MovieID) REFERENCES Movie(id)
);




INSERT INTO Address (id,Street) VALUES
    (1,'Lancieux'),
    (2, 'Paname'),
    (3,'St briac');



INSERT INTO employees (first_name, last_name, mail, password, address_id) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent',1),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie',2),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe',3);

INSERT INTO Movie (id,DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES (1,'01/01', 1,'Twilight',10);
INSERT INTO Movie (id,DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES (2,'01/02', 2,'Matrix',10);
INSERT INTO Movie (id,DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES (3,'Date', 3,'Rambo',10);
INSERT INTO Movie (id,DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES (4,'01/02', 1,'Twilight',11);
INSERT INTO Movie (id,DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES (5,'01/02', 2,'Matrix',11);
INSERT INTO Movie (id,DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES (6,'Date', 3,'Rambo',11);


 INSERT INTO Company (id,Name, employee_id) VALUES
        (1,'Pecheur',1),
        (2, 'Boucherie',2),
        (3,'Charcuterie',3);

INSERT INTO Commande (id, PersonID, MovieID) VALUES (12,1,1);
INSERT INTO Commande (id, PersonID, MovieID) VALUES (13,1,2);
INSERT INTO Commande (id, PersonID, MovieID) VALUES (14,1,3);
INSERT INTO Commande (id, PersonID, MovieID) VALUES (15,2,5);