TRUNCATE TABLE CONSOLE;
TRUNCATE TABLE GAME;
INSERT INTO CONSOLE (id, console_name) VALUES (-1, 'ps2');
INSERT INTO CONSOLE (id, console_name) VALUES (-2, 'ps3');
INSERT INTO GAME (id, title, console_id) VALUES (-3, 'call of duty', (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps3'));
INSERT INTO GAME (id, title, console_id) VALUES (-4, 'gta3', (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps2'));
INSERT INTO GAME (id, title, console_id) VALUES (-5, 'nhl 2004', (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps2'));
