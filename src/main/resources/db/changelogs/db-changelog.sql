--liquibase formatted sql

--changeset jgt:1
INSERT INTO USER(email, firstname, lastname)
VALUES ('girardot.jul@gmail.com', 'julien', 'girardot');

UPDATE GAME_TO_BUY
SET user_id = 1;

UPDATE CONSOLE
SET user_id = 1;