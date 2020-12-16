git checkout master
git pull
mvn package
java -jar -Dspring.profiles.active=prod target/ecommerce-backend-0.0.1-SNAPSHOT.jar