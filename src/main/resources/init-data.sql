INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('console_idauto_seq'), 'PS3');

INSERT INTO GAME(ID, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('game_idauto_seq'), 'uncharted drake s fortune', 2, currval('console_idauto_seq'));
INSERT INTO GAME(ID, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('game_idauto_seq'), 'battlefield3 Limited edition', 2, currval('console_idauto_seq'));
INSERT INTO GAME(ID, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('game_idauto_seq'), 'call of duty Modern warfare 2', 2, currval('console_idauto_seq'));