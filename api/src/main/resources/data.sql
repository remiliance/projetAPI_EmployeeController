DROP TABLE IF EXISTS employees, Movie, Commande;

CREATE TABLE employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);

CREATE TABLE Movie (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  DATE_DE_SORTIE VARCHAR(50) NOT NULL,
  RATING int (10) NOT NULL,
  NOM VARCHAR(250) NOT NULL,
  COUNTRY_CODE int (10) NOT NULL
);

CREATE TABLE Commande (
    OrderID INT AUTO_INCREMENT  PRIMARY KEY,
    Order_Num int(10) not null,
    PersonID int,
    MovieID int,
    FOREIGN KEY (PersonID) REFERENCES employees(id),
    FOREIGN KEY (MovieID) REFERENCES Movie(id)
);

INSERT INTO employees (first_name, last_name, mail, password) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent'),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe');

INSERT INTO Movie (DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES ('01/01', 1,'Twilight',10);
INSERT INTO Movie (DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES ('01/02', 2,'Matrix',10);
INSERT INTO Movie (DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES ('Date', 3,'Rambo',10);
INSERT INTO Movie (DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES ('01/02', 1,'Twilight',11);
INSERT INTO Movie (DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES ('01/02', 2,'Matrix',11);
INSERT INTO Movie (DATE_DE_SORTIE, RATING, NOM, COUNTRY_CODE) VALUES ('Date', 3,'Rambo',11);


INSERT INTO Commande (Order_Num, PersonID, MovieID) VALUES (12,1,1);
INSERT INTO Commande (Order_Num, PersonID, MovieID) VALUES (13,1,2);
INSERT INTO Commande (Order_Num, PersonID, MovieID) VALUES (14,1,3);
INSERT INTO Commande (Order_Num, PersonID, MovieID) VALUES (15,2,5);