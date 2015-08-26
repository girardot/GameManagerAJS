--liquibase formatted sql

--changeset jgt:1
create table USER (
    id bigint not null,
    email varchar(255),
    firstname varchar(255),
    lastname varchar(255),
    CONSTRAINT PK_USER PRIMARY KEY(ID)
);
