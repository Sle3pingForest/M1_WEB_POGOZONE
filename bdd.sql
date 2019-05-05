/*
CREATION DE LA BASE 
*/
CREATE DATABASE IF NOT EXISTS PROJET_WEB;
USE PROJET_WEB;

/*CREATION DES TABLE*/
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS PRODUIT;
DROP TABLE IF EXISTS PANIER;
/*
TABLE USER 
*/
CREATE TABLE IF NOT EXISTS USER(
ID_USER SMALLINT NOT NULL AUTO_INCREMENT,
EST_ADMIN INT DEFAULT NULL,
NOM VARCHAR(30),
PASSWORD VARCHAR(30),
DATE_NAISSANCE DATE,
E_MAIL VARCHAR(320),
VILLE VARCHAR(60),
CODE_POSTAL CHAR(10),
PRIMARY KEY(ID_USER)
);
/*
TABLE PRODUIT id type stock_dispo marque
*/
CREATE TABLE IF NOT EXISTS PRODUIT(
ID SMALLINT NOT NULL AUTO_INCREMENT,
TYPE_PRODUIT VARCHAR(30),
MARQUE VARCHAR(30),
STOCK_DISPO INT,
PRIMARY KEY(ID)
);
/*
TABLE PANIER
*/
CREATE TABLE IF NOT EXISTS PANIER(
Cookie SMALLINT,
ID_USER SMALLINT,
ID_PRODUIT SMALLINT,
QUANTITE INT,
CONSTRAINT FK_ID_USER FOREIGN KEY(ID_USER) REFERENCES USER(ID_USER),
CONSTRAINT FK_ID_PRODUIT FOREIGN KEY(ID_PRODUIT) REFERENCES PRODUIT(ID)
);

