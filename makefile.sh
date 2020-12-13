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