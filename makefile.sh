sudo yum update -y

#Install git in your EC2 instance
sudo yum install git -y

#INSTALL APACHE HTTP SERVER
sudo yum install httpd -y

#install java
sudo yum install java-1.8.0 -y

#install apache maven
sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
sudo yum install -y apache-maven

#install jdk for springboot
sudo yum install java-1.8.0-openjdk-devel
sudo yum install java-1.8.0-openjdk


######################## GCP configs

sudo apt-get install openjdk-8-jdk openjdk-8-jre mysql-server maven


gcloud auth login

gcloud compute firewall-rules create default-allow-http-8080 \
     --allow tcp:8080 \
     --source-ranges 0.0.0.0/0 \
     --target-tags http-server \
     --description "Allow port 8080 access to http-server"


