# cd src/main/resources/backup
# awk --file=generate_sql_from_csv_for_games.awk game_modified.csv > game.sql
BEGIN {
    FS = ","
}
{
    if(NR > 1) {
        printf("INSERT INTO GAME(ID, DEMATERIALIZED, TITLE, PROGRESSION, CONSOLE_ID) VALUES (nextval('hibernate_sequence'), %s, '%s', %s, (SELECT ID FROM CONSOLE WHERE CONSOLE_NAME='%s'));\n", $2, $3, $4, $1);
    }
}