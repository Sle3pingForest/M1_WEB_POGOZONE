/*
CREATION DE LA BASE 
*/
CREATE DATABASE IF NOT EXISTS PROJET_WEB;
USE PROJET_WEB;

/*CREATION DES TABLE*/
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS PRODUIT;
/*
TABLE USER 
*/
CREATE TABLE IF NOT EXISTS USER(
ID_USER SMALLINT,
NOM VARCHAR(30),
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
ID SMALLINT,
TYPE_PRODUIT VARCHAR(30),
MARQUE VARCHAR(30),
STOCK_DISPO INT,
PRIMARY KEY(ID)
);

