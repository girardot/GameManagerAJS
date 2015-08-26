--liquibase formatted sql

--changeset jgt:1
--comment: create user table
CREATE TABLE "USER" ( ID INT PRIMARY KEY NOT NULL, EMAIL CHAR(255), FIRSTNAME CHAR(255), LASTNAME CHAR(255));

--changeset jgt:2
alter table "CONSOLE"
add constraint FK_CONSOLE_USER
foreign key (user_id)
references "USER";

--changeset jgt:3
alter table "GAME_TO_BUY"
add constraint FK_GAME_TO_BUY_USER
foreign key (user_id)
references "USER";

--changeset jgt:4
INSERT INTO "USER"(email, firstname, lastname)
VALUES ('girardot.jul@gmail.com', 'julien', 'girardot');

UPDATE GAME_TO_BUY
SET user_id = (SELECT id FROM USER WHERE email='girardot.jul@gmail.com');

UPDATE CONSOLE
SET user_id = (SELECT id FROM USER WHERE email='girardot.jul@gmail.com');
