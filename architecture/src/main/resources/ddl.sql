drop TABLE if EXISTS USER_ROLE;
drop TABLE if EXISTS PERSONA;
drop TABLE if EXISTS ROLE;
drop TABLE if EXISTS USER;


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
  ROLE_ID INT NOT NULL,
  USER_ID int NOT NULL,
  PRIMARY KEY (ROLE_ID, USER_ID),
  FOREIGN KEY (ROLE_ID) REFERENCES ROLE (ID),
  FOREIGN KEY (USER_ID) REFERENCES USER(ID)
);


insert into ROLE (ROLE_NAME, DESCRIPCION) VALUES ('admin', 'admin');
insert into USER (NICK, PASS) VALUES ('admin', 'admin');
insert into USER_ROLE (ROLE_ID, USER_ID) VALUES (1, 1);


SELECT U.NICK, R.ROLE_NAME FROM USER U
INNER JOIN USER_ROLE UR on U.ID = UR.USER_ID
INNER JOIN ROLE R ON UR.ROLE_ID = R.ID
