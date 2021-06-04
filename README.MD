

# Trainers API Challenge for Camp Gladiator

<p>This is an example API built on top of Spring Boot + MongoDB as part of a challenge in the recruiting process for Camp Gladiator.</p>

## Requirements
Create two REST API endpoints as follows:

Create a new trainer
Get details for a trainer
The Trainer model should include (at the very least) the following attributes:
```json
{
    "id" : "trainer-id-000001",
    "email" : "trainer@campgladiator.com",
    "phone" : "5125125120",
    "first_name": "Fearless",
    "last_name": "Contender"
}
```
## Requirements
* Java 11
* Mongo DB

or

* Docker

## Installation and Running
### Run locally with a MongoDB installed
* Download the zip file or clone the repository
* From the folder execute
```bash
./gradlew clean build
```
Run MongoDB locally in port 27017 and then run the application
```bash
./gradlew clean bootRun
```

### Run using containers
First build the jar with
```bash
./gradlew clean build
```
then build and start the containers with
```bash
docker-compose up -d
```
## Key points to see as an example
* API implementation and validation of parameters.
* Error handling to build the response (code + message).
* Testing.

## Testing
### With Curl
Save new trainer
```bash
curl --location --request POST 'http://localhost:8080/api/v1/camp/trainer/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email" : "trainer2@campgladiator.com",
    "phone" : "5125125120",
    "firstName": "Fearless2",
    "lastName": "Contender"
}'
```
Get Trainer by ID
```bash
curl --location --request GET 'http://localhost:8080/api/v1/camp/trainer/<trainerId>'
```
List All trainers
```bash
curl --location --request GET 'http://localhost:8080/api/v1/camp/trainer'
```

### With Postman
To run the tests, install Postman and import the collection. You can run the tests one by one.
```
src\test\resources\CampGladiator.postman_collection.json
```

## Possible improvements / next steps
* Paginate ListAll method
* Configure static code review, coverage and formatter
* We could add security
* We could create a CI/CD pipeline 

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - IoC framework used (current version 2.5.0)
* [Gradle](https://gradle.org/) - Dependency Management
* [MongoDb](https://www.mongodb.com//) - NoSQL database
* [Docker](https://www.docker.com/) - Container creator
* Java JDK 11

## Author

* **Tomás Colombo**