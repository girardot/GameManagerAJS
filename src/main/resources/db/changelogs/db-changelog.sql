--liquibase formatted sql

--changeset nvoxland:1
create table USER (
    id bigint not null,
    email varchar(255),
    firstname varchar(255),
    lastname varchar(255),
    primary key (id)
);

ALTER TABLE CONSOLE ADD (
  user_id bigint
);

alter table CONSOLE
add constraint FK_CONSOLE_USER
foreign key (user_id)
references USER;

ALTER TABLE GAME_TO_BUY ADD (
  user_id bigint
);

alter table GAME_TO_BUY
add constraint FK_GAME_TO_BUY_USER
foreign key (user_id)
references USER;

INSERT INTO USER(email, firstname, lastname)
VALUES ('girardot.jul@gmail.com', 'julien', 'girardot');

UPDATE GAME_TO_BUY
SET user_id = (SELECT id FROM USER WHERE email='girardot.jul@gmail.com');

UPDATE CONSOLE
SET user_id = (SELECT id FROM USER WHERE email='girardot.jul@gmail.com');