git checkout master
git pull
#kill if something already running in 8080 port
sudo kill -9 `sudo lsof -t -i:8080`
mvn package
#to run in background
nohup java -jar -Dspring.profiles.active=prod target/ecommerce-backend-0.0.1-SNAPSHOT.jar &
# to list jobs
#jobs -l
#see logs
#vim /home/spring-boot-app.log
