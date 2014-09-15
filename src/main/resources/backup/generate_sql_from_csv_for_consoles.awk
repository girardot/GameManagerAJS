# cd src/main/resources/backup
# awk --file=generate_sql_from_csv_for_consoles.awk console.csv > console.sql
BEGIN {
    FS = ","
}
{
    if(NR > 1) {
        printf("INSERT INTO CONSOLE(ID, CONSOLE_NAME) VALUES (nextval('hibernate_sequence'), '%s');\n", $2);
    }
}