CREATE DATABASE `bibliotheque_db`;

USE `bibliotheque_db`;

CREATE TABLE auteur (
	id_auteur INT NOT NULL AUTO_INCREMENT,
    nom VARCHAR(60),
    age INT,
    PRIMARY KEY (id_auteur)
);

CREATE TABLE `livre` (
	id_livre INT NOT NULL AUTO_INCREMENT,
    titre VARCHAR(60),
    ref_auteur INT,
    editeur VARCHAR(60),
    dateEdition DATE,
    PRIMARY KEY (id_livre),
	FOREIGN KEY (ref_auteur) REFERENCES auteur (id_auteur)
    );
	
INSERT INTO `auteur` (nom, age)
VALUES
('Rudyard Kipling', 1936),
('Harry Harrison', 2012),
('JK Rowling', 53),
('Dan Brown', 54);

INSERT INTO `livre` (titre, ref_auteur, editeur, dateEdition)
VALUES
('Le livre de la jungle', 1, 'Disney', '2018-06-20'),
('Soleil vert', 2, "J'ai Lu", '2002-02-02'),
('Harry Potter', 3, 'Gallimard', '2015-12-23'),
('Anges et Démons', 4, 'JC Lattès', '2005-08-15')
('Forteresse digitale', 4, 'JC Lattès', '2007-01-10'),
('Da Vinci CODE', 4, 'JC Lattès', '2005-04-10'),
('Le Symbole PERDU', 4, 'JC Lattès', '2009-11-10'),
('INFERNO', 4, 'JC Lattès', '2013-10-10');

select * from livre
inner join auteur
where id_auteur = ref_auteur
and id_auteur = 4;
    