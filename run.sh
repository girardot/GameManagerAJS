mvn package
export PORT=5000
java -Dspring.profiles.active="local-server" -cp "target\classes;target\dependency\*" jgt.ServerGameManager