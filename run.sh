git pull origin nmadhab/docker-ecr-aws
mvn package
java -jar target/ecommerce-backend-0.0.1-SNAPSHOT.jar &
#jobs -l