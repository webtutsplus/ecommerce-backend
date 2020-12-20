git checkout master
git pull
sudo kill -9 `sudo lsof -t -i:8080`
mvn package -DskipTests=true
nohup java -jar -Dspring.profiles.active=prod target/ecommerce-backend-0.0.1-SNAPSHOT.jar &
#jobs -l
#nohup python3 -m http.server 8001 &
