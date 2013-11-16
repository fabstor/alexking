SET AUTOCOMMIT OFF;
SET PAGESIZE 100;
SET LINESIZE 100;

DROP TABLE SimpleOrder;
DROP TABLE ComplexOrder;
DROP TABLE Contient;
DROP TABLE Book;
DROP TABLE Photo;
DROP TABLE Album;
DROP TABLE Utilisateur;



DROP TABLE Format;

CREATE TABLE utilisateur (
	idUser		INT NOT NULL ,
	email 		VARCHAR2(255) UNIQUE,
	password	VARCHAR2(255) NOT NULL,
	isAdmin		CHAR(1) NOT NULL ,
	name 		VARCHAR2(255) NOT NULL,
	surname		VARCHAR2(255) NOT NULL,
	street		VARCHAR2(255),
	streetNumber   VARCHAR2(255),
	country	VARCHAR2(255),
	city VARCHAR2(255),
	zipcode 	VARCHAR2(5),
	lastConnexion TIMESTAMP,	--modified
	creationDate TIMESTAMP,			--modified
	CONSTRAINT pk_User PRIMARY KEY(idUser)
) ;

CREATE TABLE Photo (
	idPhoto		INT NOT NULL ,
	idUser		INT NOT NULL,
	url			VARCHAR2(255) ,
	camera 		VARCHAR2(255) ,
	objective	VARCHAR2(255),
	focalDistance	VARCHAR2(255),
	sensitivity 	VARCHAR2(255),
	obturationSpeed 	VARCHAR2(255),
	resolution 	VARCHAR2(255) NOT NULL,
	creationDate TIMESTAMP,			--modified
	CONSTRAINT pk_Photo PRIMARY KEY(idPhoto),
	CONSTRAINT fk_Photo FOREIGN KEY(idUser) REFERENCES Utilisateur(idUser)
) ;

CREATE TABLE Album (
	idAlbum		INT NOT NULL,
	idUser		INT NOT NULL,
	title 		VARCHAR2(255) UNIQUE,
	subtitle	VARCHAR2(1024),
	isPublic	CHAR(1),
	creationDate TIMESTAMP,			--modified
	CONSTRAINT pk_Album PRIMARY KEY(idAlbum),
	CONSTRAINT fk_Album FOREIGN KEY(idUser) REFERENCES Utilisateur(idUser)
) ;

CREATE TABLE Contient (
	idAlbum		INT NOT NULL,
	idPhoto		INT NOT NULL,
	name 		VARCHAR2(255),
	commentt	VARCHAR2(1024),
	orderC	INT,
	CONSTRAINT pk_Contient PRIMARY KEY(idAlbum,idPhoto),
	CONSTRAINT fk1_Contient FOREIGN KEY(idAlbum) REFERENCES Album(idAlbum),
	CONSTRAINT fk2_Contient FOREIGN KEY(idPhoto) REFERENCES Photo(idPhoto)
) ;

CREATE TABLE Book (
	idBook		INT NOT NULL ,
	idAlbum		INT NOT NULL,
	idPhotoCouverture		INT,
	firstPage	VARCHAR2(1024),
	lastPage	VARCHAR2(1024),
	isPublic	CHAR(1),
	creationDate TIMESTAMP,			--modified
	CONSTRAINT pk_Book PRIMARY KEY(idBook),
	CONSTRAINT fk1_Book FOREIGN KEY(idAlbum) REFERENCES Album(idAlbum),
	CONSTRAINT fk2_Book FOREIGN KEY(idPhotoCouverture) REFERENCES Photo(idPhoto)
) ;

CREATE TABLE Format(
	idFormat INT NOT NULL ,
	name VARCHAR2(255),
	price NUMBER, -- Modified
	CONSTRAINT pk_Format PRIMARY KEY(idFormat)
);

CREATE TABLE ComplexOrder(
	idOrder INT NOT NULL,
	idUser INT NOT NULL,
	orderDate TIMESTAMP,	--Modified : last : DATE
	totalPrice NUMBER, -- Modified
	invoiceStreet VARCHAR2(255),
	invoiceNumber VARCHAR2(255),
	invoiceCountry VARCHAR2(255),
	invoiceCity VARCHAR2(255),
	invoiceZipcode VARCHAR2(5) , -- Modified
	deliveryStreet VARCHAR2(255),
	deliveryNumber VARCHAR2(255),
	deliveryCountry VARCHAR2(255),
	deliveryCity VARCHAR2(255),
	deliveryZipcode VARCHAR2(5), -- Modified
	CONSTRAINT pk_Order PRIMARY KEY(idOrder),
	CONSTRAINT fk_Order FOREIGN KEY(idUser) REFERENCES Utilisateur(idUser)
) ;

CREATE TABLE simpleOrder (
	idSimpleOrder	INT NOT NULL ,
	idAlbum		INT NOT NULL,
	idFormat		INT NOT NULL,
	quantity	NUMBER,
	isBook	CHAR(1),
	CONSTRAINT pk_simpleOrder PRIMARY KEY(idSimpleOrder),
	CONSTRAINT fk1_simpleOrder FOREIGN KEY(idAlbum) REFERENCES Album(idAlbum),
	CONSTRAINT fk2_simpleOrder FOREIGN KEY(idFormat) REFERENCES Format(idFormat)
) ;






