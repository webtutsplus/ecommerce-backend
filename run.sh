git checkout master
git pull
sudo kill -9 `sudo lsof -t -i:8080`
mvn package
java -jar -Dspring.profiles.active=prod target/ecommerce-backend-0.0.1-SNAPSHOT.jar &
#jobs -l
