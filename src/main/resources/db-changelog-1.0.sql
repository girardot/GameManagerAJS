--liquibase formatted sql

--changeset jgt:1
CREATE TABLE USER (
    ID bigint NOT NULL,
    EMAIL VARCHAR(255),
    FIRSTNAME VARCHAR(255),
    LASTNAME VARCHAR(255),
    CONSTRAINT PK_USER PRIMARY KEY (id)
);

--changeset jgt:2
alter table CONSOLE
add constraint FK_CONSOLE_USER
foreign key (user_id)
references USER;

--changeset jgt:3
alter table GAME_TO_BUY
add constraint FK_GAME_TO_BUY_USER
foreign key (user_id)
references USER;