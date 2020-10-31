# REST CRUD API of Vehicles with Spring Boot, PostgresSQL

Spring boot backend application to perform basic CRUD operation on Vehicle API.

## Steps to run the application
### 1. Create appropriate database with postgreSQL 

```
create database vehicle_database
```

### 2. Change connection properties
1. open ```src/main/resources/application.properties```
2. change ```spring.datasource.username``` and ```spring.datasource.password``` as per the user role under postgreSQL.

### 3. Build and run the application using maven.
```
mvn clean install
mvn package
java -jar target/<SNAPSHOT>.jar
```

OR

```
mvn spring-boot:run
```

## REST APIs endpoints
The application defines the following CRUD APIs.
```
GET /api/v1/vehicles

POST /api/v1/vehicles

GET /api/v1/vehicles/{vehicleId}

PUT /api/v1/vehicles/{vehicleId}

DELETE /api/v1/vehicles/{vehicleId}

```
