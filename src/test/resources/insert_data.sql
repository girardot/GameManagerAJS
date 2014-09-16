TRUNCATE TABLE CONSOLE;

TRUNCATE TABLE GAME;

INSERT INTO CONSOLE (id, console_name) VALUES (NEXT VALUE FOR hibernate_sequence, 'ps2');
INSERT INTO CONSOLE (id, console_name) VALUES (NEXT VALUE FOR hibernate_sequence, 'ps3');

INSERT INTO GAME (id, title, console_id) VALUES (NEXT VALUE FOR hibernate_sequence, 'call of duty', (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps3'));
INSERT INTO GAME (id, title, console_id) VALUES (NEXT VALUE FOR hibernate_sequence, 'gta3', (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps2'));
INSERT INTO GAME (id, title, console_id) VALUES (NEXT VALUE FOR hibernate_sequence, 'nhl 2004', (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps2'));

INSERT INTO GAME (id, title) VALUES (NEXT VALUE FOR hibernate_sequence, 'game to buy');
INSERT INTO GAME (id, title) VALUES (NEXT VALUE FOR hibernate_sequence, 'game to buy 2');

INSERT INTO GAME_TO_BUY (id, game_id, to_buy_order) VALUES (NEXT VALUE FOR hibernate_sequence, (SELECT id FROM GAME WHERE title='game to buy'), 1);
INSERT INTO GAME_TO_BUY (id, game_id, to_buy_order) VALUES (NEXT VALUE FOR hibernate_sequence, (SELECT id FROM GAME WHERE title='game to buy 2'), 2);
