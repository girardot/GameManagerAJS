# cd src/main/resources/backup
# awk --file=replace_id_console_by_console_name.awk game.csv > game_modified.csv
{
    gsub("^1640,","PS4,", $0)
    gsub("^13,","SUPER NES,", $0)
    gsub("^12,","PSP,", $0)
    gsub("^11,","DS,", $0)
    gsub("^10,","PS ONE,", $0)
    gsub("^9,","WII,", $0)
    gsub("^8,","GBA,", $0)
    gsub("^7,","GAMECUBE,", $0)
    gsub("^6,","PS2,", $0)
    gsub("^5,","PS VITA,", $0)
    gsub("^4,","WII U,", $0)
    gsub("^3,","3DS,", $0)
    gsub("^2,","XBOX 360,", $0)
    gsub("^1,","PS3,", $0)
    print $0
}