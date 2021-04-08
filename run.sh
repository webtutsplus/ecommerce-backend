#git stash
#git checkout master
#git pull

sudo kill -9 `sudo lsof -t -i:8443`
mvn package -DskipTests=true
# create upload-dir
#mkdir upload-dir
nohup java -jar -Dspring.profiles.active=prod target/ecommerce-backend-0.0.1-SNAPSHOT.jar &
#java -jar -Dspring.profiles.active=prod target/ecommerce-backend-0.0.1-SNAPSHOT.jar &
#jobs -l
#nohup python3 -m http.server 8001 &

