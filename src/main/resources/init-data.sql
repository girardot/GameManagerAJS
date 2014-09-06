INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'PS3');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'XBOX 360');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), '3DS');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'WII U');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'PS VITA');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'PS2');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'GAMECUBE');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'GBA');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'WII');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'PS ONE');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'DS');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'PSP');
INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), 'SUPER NES');

INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'uncharted drake s fortune', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'battlefield3 Limited edition', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'call of duty Modern warfare 2', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'call of duty black ops', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'call of duty MW3', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'call of duty Modern warfare', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'need for speed the run limited edition', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'dishonored', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'mirror s edge', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'assasin s creed brotherhoood', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'max payne 3', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'grand theft auto Episode From liberty city', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'grand theft auto IV', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'red dead redemption', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'uncharted 2 : Among thieves', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'Batman : Arkham Asylum', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'Batman Arkam city', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'god of war III', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'assasin s creed', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'assasin s creed II', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'Final fantasy XIII', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'skyrim', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'playstation all-stars battle royale', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'nhl 2k9', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'fifa 12', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'uncharted 3', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'god of war collection volume 2', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'Assasin s creed reveleations', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'farcry 3', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'tombraider', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'little big planet karting', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'heavy rain', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS3'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'gears of war', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'gears of war 2', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'gears of war 3', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'splinter cell conviction', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'assasin s creed III', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'pes 2010', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D Halo reach', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D Halo 3', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D de blob', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D crackdown', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D soulcalibur IV', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D masss effect', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D pes 6', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D def jam : icon', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D crossboard 7', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D lost planet', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D The orange Box', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D left 4 dead', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D N3 ninety-nine nights', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D tomb raider underworld', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'D two worlds', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='XBOX 360'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'donkey kong country returns 3D', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='3DS'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'luigi s mansion 2', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='3DS'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'fire emblem awakening', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='3DS'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'zelda ocarina of time 3D', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='3DS'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'super mario 3D land', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='3DS'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'residant evil revelation', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='3DS'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'nintendo land', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII U'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'call of duty black op II', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII U'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'zombi u', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII U'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'new super mario bros wii u', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII U'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'uncharted golden abyss', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS VITA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'virtues last reward', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS VITA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'Persona 4 golden', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS VITA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'metal gear solid hd collection', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS VITA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'new little king s story', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS VITA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'assasin s creed II liberation', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS VITA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'rayman origins', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS VITA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'gravity rush', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS VITA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'ninja gaiden sigma plus', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS VITA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'timesplitters 2', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'grant theft auto : vice city', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'warhammer 40,000: fire warrior', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'aggressive inline', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'final fantasy X', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'PES 2', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'metal gear solid 2', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'tomb raider l ange des tenebres', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'grant theft auto : san adreas', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'top gun combat zone', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'le seigneur des anneaux: les deux tours', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'socom: U.S navy seals', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'grand turismo 3', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'conflict desert storm II', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'conflict desert storm', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'nhl 2004', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'medal of honor en premier ligne', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'ace combat : distant thunder', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS2'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'beyond good & evil', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'spider man', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'summonet la deesse reincarnée', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'driven', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'prince of persia the sands of time', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'star wars rogue leader', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'need for speed underground 2', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'final fantasy crystal chronicles', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false,'sonic mega collection', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'sonic heroes', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'phantasy star online episode I &II', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'jedi knight II', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'super smash bros melee', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'tony hawk s american wasterland', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'tony hawk s undeground', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, '007 nightfire', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'resident evil', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'the legend of zela the wind waker', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GAMECUBE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'golden sun l age perdu', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GBA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'super mario world 2', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GBA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'l aigle de guerre', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GBA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'metroid fusion', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GBA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'donkey kong country', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GBA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'the legend of zelda a link to the past', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='GBA'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'call of duty 3', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'super mario galaxy', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'wii sports', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'bully scholarship', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'one piece', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'metroid prime corruption', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'metal slug anthology', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'need for speed carbon', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'les 4 fantastiques et le surfer d argent', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'resident evil 4', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'fifa 08', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'mario strikers charged football', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'mario kart wii', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'super mario galaxy 2', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'wii play', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'mario party 8', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'super smash bross brawl', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'dbz budokai tenkaichi 3', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'bomberman land ', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'monster 4x4 world circuit', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'cars', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'wii party', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'bleach', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'naruto clash of ninja', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='WII'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'final fantasy VII', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS ONE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'final fantasy VIII', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS ONE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'eagle one', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS ONE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'moto racer world tour', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS ONE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'fifa 2001', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PS ONE'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'sonic rush', 2, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='DS'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'pokemon version blanche', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PSP'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'grand theft auto : vice city stories', 1, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='PSP'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'street fighter II', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='SUPER NES'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'pilotwings', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='SUPER NES'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'f1 pole position', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='SUPER NES'));
INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), false, 'super street fighter turbo', 0, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='SUPER NES'));
