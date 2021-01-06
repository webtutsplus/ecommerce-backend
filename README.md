# ecommerce
 Ecommerce backend apis

* This is a Maven Project. Ensure, Maven is installed on your system.
* It is Recommended that you use Linux Based OS.
* It might happen that you have installed XAMPP/LAMPP software (by Bitnami) on your system. Instead of using the db provided by XAMPP/LAMPP by bitnami, it is recommended that you install ``mariadb-server`` and use it as  database while running this application.  

###How to run in local
1. Change the Application Properties (E.g. username/password of DB) present in ``resources/application.properties``  according to your local mysql-server.
1. Create a database called `ecommerce` with ``CHARACTER SET utf8mb4`` and `COLLATE utf8mb4_0900_ai_ci`. MariaDB does not support `COLLATE utf8mb4_0900_ai_ci`. So, if you are using MariaDB, open `database-dump.sql` file and replace `COLLATE utf8mb4_0900_ai_ci` with `COLLATE utf8mb4_general_ci`  
1. Import `database-dump.sql` in it. 
1. To run the application, run the command ``sh run.sh`` i.e. execute the ``run.sh`` file. 
1. After starting application, go to http://localhost:8080/api/swagger-ui.html/




### In case of "java.lang.IllegalStateException: Unable to load cache item error":
- Go into pom.xml and comment out the scope for the "spring-boot-starter-tomcat" dependency


##How to use prod profile
mvn package
java -jar -Dspring.profiles.active=prod <package name in target>

##Run in prod with latest changes in master
ssh root@167.99.37.15


(use password: webTuts9plus)

cd ecommerce

sh run.sh 

you should see the swagger UI in http://167.99.44.132:8080/api/swagger-ui.html

#admin access
email: admin@gmail.com
password: admin
firstname: admin


##export database 
mysqldump -u root -p ecommerce > database-dump.sql
scp root@104.236.26.66:database-dump.sql .
