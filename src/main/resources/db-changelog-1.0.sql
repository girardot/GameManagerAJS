--liquibase formatted sql

--changeset jgt:1
--comment: create user table
CREATE TABLE "USER" ( ID INT PRIMARY KEY NOT NULL, EMAIL CHAR(255), FIRSTNAME CHAR(255), LASTNAME CHAR(255));

--changeset jgt:2
--comment: Update game to buy
update game_to_buy set user_id=1;


