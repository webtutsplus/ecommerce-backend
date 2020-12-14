# ecommerce
 Ecommerce backend apis

### Incase of "java.lang.IllegalStateException: Unable to load cache item error":
- Go into pom.xml and comment out the scope for the "spring-boot-starter-tomcat" dependency

###How to run in local
- change application properties according to local mysql
- after starting application, go to http://localhost:8080/swagger-ui.html#/