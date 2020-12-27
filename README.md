# ecommerce
 Ecommerce backend apis

### Incase of "java.lang.IllegalStateException: Unable to load cache item error":
- Go into pom.xml and comment out the scope for the "spring-boot-starter-tomcat" dependency

###How to run in local
- change application properties according to local mysql
- after starting application, go to http://localhost:8080/swagger-ui.html#/

##How to use prod profile
mvn package
java -jar -Dspring.profiles.active=prod <package name in target>

##Run in prod with latest changes in master
ssh root@104.236.26.66

(use password: webTuts9plus)

cd ecommerce

sh run.sh 

you should see the swagger UI in http://167.99.44.132:8080/api/swagger-ui.html

#admin access
email: admin@gmail.com
password: admin
firstname: admin