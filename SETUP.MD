# Address API 
Address API provides programmatic acces to read and write the Address data. If you wish to use the address API, please refer to README.MD as this is inteded for the application setup

### Setting up the Project: 
Address API is a Maven-based Spring Boot application with an embedded tomcat server. Packaging this application in maven produces a runable jar that you can run with "java -jar" command locally or on any PAAS that is able to run java. This project is particularly tested with Cloud Foundry (a manifest.yml for Pivotal Cloud Foundry is included). 

Prerequisite:
i) you must have Maven installed in your environment. Test with 
```sh
$ mvn --version
```
If you do not have maven installed, see here:
https://maven.apache.org/install.html
    
ii) if you wish to run this project locally, you must have Java 8 installed. If you wish to run this project on cloud foundry (recommended), you must have Cloud Foudry Command Line Interface installed. If you do not have Cf-cli installed, see here:
https://github.com/cloudfoundry/cli

iii) Before deploying this project, you must setup the MySQL database for persistent storage. You must run script.sql file against the database and record the following information: 
- Public URL
- Port number
- Database Name
- Username
- Password

Alternatively, you can take a look at the 'addressdatabase Project' (https://github.com/saedalav/addressdatabase) if you wish to automatically provision the database in AWS RDS using Ansible. 

1. Clone this project: 
```sh
$ git clone https://github.com/saedalav/addressapi.git
$ cd addressapi
```
2. Modify src/main/resources/aplication.properties and enter your database information in the following format: 
spring.datasource.url=jdbc:mysql://DATABASE_URL:DB_PORT/address
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
```sh
$ vim src/main/resources/aplication.properties
$ [Modify the file]
$ wq
```

3. From the project's root directory (where the pom.xml file is present), run Maven's package in order to package the project into a runnable jar 
```sh
$ mvn clean package
```
This will produce addressapi-0.0.1-SNAPSHOT.jar in target directory. This is the runnable jar that you can run either locally or in Cloud Foudry 

4. Run the addressapi-0.0.1-SNAPSHOT.jar 
(a) To run the application locally with Java 8, 
```sh
$ java -jar addressapi-0.0.1-SNAPSHOT.jar
```
The application will be available at http://localhost:8080/. Test your application by invoking different REST API methods. 

(b) To run the application on your Cloud Foudry: 
Open manifest.yml file and modify the default values if you wish. then: 
```sh
$ cf login -a API_URL -u USERNAME -p PASSWORD (Then Select Org and workspace)
$ cf push
```
The application will then be available in https://yourappspace.fqdn/addressapi. Test your application by invoking different REST API methods. 
