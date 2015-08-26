GameManagerAJS
==============
[![Build Status](http://travis-ci.org/girardot/GameManagerAJS.png)](http://travis-ci.org/girardot/GameManagerAJS)


[In Heroku](http://gamemanagerajs.herokuapp.com/)

[Trello](https://trello.com/b/1NKIycMK/gamemanagerajs)

In intellij
vm options ===> -Dspring.profiles.active="local-server"
Environment variables ===> PORT=5000


Heroku logs :
heroku logs -n 200
heroku logs --tail

Restore a backup
heroku pg:backups restore 'a081' gamemanagerajs::silver::resting-vastly-3226
a081 is the PG Backup id in herokupostgres


test





