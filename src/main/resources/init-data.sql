INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('console_sequence'), 'PS3');

INSERT INTO GAME(ID, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('game_sequence'), 'uncharted drake s fortune', 2, currval('console_sequence'));
INSERT INTO GAME(ID, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('game_sequence'), 'battlefield3 Limited edition', 2, currval('console_sequence'));
INSERT INTO GAME(ID, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('game_sequence'), 'call of duty Modern warfare 2', 2, currval('console_sequence'));