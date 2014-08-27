mvn package
export PORT=5000
java -Dspring.profiles.active="dev" -cp "target\classes\jgt;target\dependency\*" ServerGameManager