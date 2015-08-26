--liquibase formatted sql

--changeset jgt:1
--comment: create user table
CREATE TABLE USER (
  ID INT PRIMARY KEY NOT NULL,
  EMAIL CHAR(255),
  FIRSTNAME CHAR(255),
  LASTNAME CHAR(255)
);
