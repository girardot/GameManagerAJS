--liquibase formatted sql

--changeset jgt:1
--comment: create user table
CREATE TABLE user_account (
  ID        BIGINT PRIMARY KEY NOT NULL,
  EMAIL     VARCHAR(255),
  FIRSTNAME VARCHAR(255),
  LASTNAME  VARCHAR(255)
);

--changeset jgt:2
--comment: add julien user
INSERT INTO user_account (ID, EMAIL, FIRSTNAME, LASTNAME) VALUES (1, 'girardot.jul@gmail.com', 'julien', 'girardot');

--changeset jgt:2
--comment: add FK
ALTER TABLE CONSOLE
ADD CONSTRAINT FK_CONSOLE_USER_ACCOUNT
FOREIGN KEY (user_id)
REFERENCES user_account;

ALTER TABLE GAME_TO_BUY
ADD CONSTRAINT FK_GAME_TO_BUY_USER_ACCOUNT
FOREIGN KEY (user_id)
REFERENCES user_account;
