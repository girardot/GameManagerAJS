INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'PS3');

INSERT INTO GAME(ID, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), 'uncharted drake s fortune', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME= 'PS3'));
INSERT INTO GAME(ID, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), 'battlefield3 Limited edition', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME= 'PS3'));
INSERT INTO GAME(ID, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), 'call of duty Modern warfare 2', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME= 'PS3'));