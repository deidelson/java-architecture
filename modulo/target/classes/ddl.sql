create table PERSONA
(
  ID int auto_increment
    primary key,
  NOMBRE varchar(30) not null
);

CREATE TABLE ROLE(
  ID INT AUTO_INCREMENT,
  ROLE_NAME VARCHAR (30) NOT NULL,
  DESCRIPCION  VARCHAR (30) NOT NULL,
  PRIMARY KEY (ID)
);

create table USER
(
  ID int auto_increment
    primary key,
  NICK varchar(30) not null,
  PASS varchar(30) not null
);

CREATE TABLE USER_ROLE(
  ID_ROLE INT NOT NULL,
  USER_ID VARCHAR(30) NOT NULL,
  PRIMARY KEY (ID_ROLE, USER_ID),
  FOREIGN KEY (ID_ROLE) REFERENCES ROLE (ID),
  FOREIGN KEY (USER_ID) REFERENCES USER(ID)
);




