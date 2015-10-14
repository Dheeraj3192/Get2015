CREATE DATABASE User_information;

USE User_information;

CREATE TABLE Registration(
    username VARCHAR(20) PRIMARY KEY ,
    password VARCHAR(20),
    emailid VARCHAR(30)
);