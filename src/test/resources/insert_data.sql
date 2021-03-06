TRUNCATE TABLE CONSOLE;
TRUNCATE TABLE GAME_TO_BUY;
TRUNCATE TABLE GAME;

INSERT INTO user_account (id, firstname, lastname, email) VALUES (NEXT VALUE FOR hibernate_sequence, 'julien', 'girardot', 'girardot.jul@gmail.com');
INSERT INTO user_account (id, firstname, lastname, email) VALUES (NEXT VALUE FOR hibernate_sequence, 'seb', 'girardot', 'seb@gmail.com');

INSERT INTO CONSOLE (id, user_id, console_name) VALUES (NEXT VALUE FOR hibernate_sequence, (SELECT ID FROM user_account WHERE email='girardot.jul@gmail.com'), 'ps2');
INSERT INTO CONSOLE (id, user_id, console_name) VALUES (NEXT VALUE FOR hibernate_sequence, (SELECT ID FROM user_account WHERE email='seb@gmail.com'), 'ps3');

INSERT INTO GAME (id, title, progression, console_id) VALUES (NEXT VALUE FOR hibernate_sequence, 'call of duty', 0, (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps3'));
INSERT INTO GAME (id, title, progression, console_id) VALUES (NEXT VALUE FOR hibernate_sequence, 'call of duty 2', 1, (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps2'));
INSERT INTO GAME (id, title, progression, console_id) VALUES (NEXT VALUE FOR hibernate_sequence, 'gta3', 0, (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps2'));
INSERT INTO GAME (id, title, progression, console_id) VALUES (NEXT VALUE FOR hibernate_sequence, 'nhl 2004', 0, (SELECT id FROM CONSOLE WHERE CONSOLE_NAME='ps2'));

INSERT INTO GAME (id, title) VALUES (NEXT VALUE FOR hibernate_sequence, 'game to buy');
INSERT INTO GAME (id, title) VALUES (NEXT VALUE FOR hibernate_sequence, 'game to buy 2');
INSERT INTO GAME (id, title) VALUES (NEXT VALUE FOR hibernate_sequence, 'game to buy 3');
INSERT INTO GAME (id, title) VALUES (NEXT VALUE FOR hibernate_sequence, 'game to buy seb');

INSERT INTO GAME_TO_BUY (id, user_id, game_id, to_buy_order) VALUES (NEXT VALUE FOR hibernate_sequence, (SELECT id FROM user_account WHERE email='girardot.jul@gmail.com'), (SELECT id FROM GAME WHERE title='game to buy 2'), 2);
INSERT INTO GAME_TO_BUY (id, user_id, game_id, to_buy_order) VALUES (NEXT VALUE FOR hibernate_sequence, (SELECT id FROM user_account WHERE email='girardot.jul@gmail.com'), (SELECT id FROM GAME WHERE title='game to buy'), 1);
INSERT INTO GAME_TO_BUY (id, user_id, game_id, to_buy_order) VALUES (NEXT VALUE FOR hibernate_sequence, (SELECT id FROM user_account WHERE email='girardot.jul@gmail.com'), (SELECT id FROM GAME WHERE title='game to buy 3'), 3);
INSERT INTO GAME_TO_BUY (id, user_id, game_id, to_buy_order) VALUES (NEXT VALUE FOR hibernate_sequence, (SELECT id FROM user_account WHERE email='seb@gmail.com'), (SELECT id FROM GAME WHERE title='game to buy seb'), 1);

INSERT INTO CREDENTIALS (email, password) VALUES ('girardot.jul@gmail.com', 'abc');
