--liquibase formatted sql

--changeset jgt:1
--comment: create user table
CREATE TABLE "user_account" (
  ID        BIGINT PRIMARY KEY NOT NULL,
  EMAIL     VARCHAR(255),
  FIRSTNAME VARCHAR(255),
  LASTNAME  VARCHAR(255)
);

--changeset jgt:2
--comment: add julien user
INSERT INTO "user_account" (ID, EMAIL, FIRSTNAME, LASTNAME) VALUES (1, 'girardot.jul@gmail.com', 'julien', 'girardot');

--changeset jgt:3
--comment: add fk_console_user_account
ALTER TABLE "console"
ADD CONSTRAINT fk_console_user_account
FOREIGN KEY (user_id)
REFERENCES "user_account";

--changeset jgt:4
--comment: add fk_game_to_buy_user_account
ALTER TABLE "game_to_buy"
ADD CONSTRAINT fk_game_to_buy_user_account
FOREIGN KEY (user_id)
REFERENCES "user_account";
