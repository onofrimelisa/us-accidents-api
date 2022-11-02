# US ACCIDENTS API

- [Description](#description)
- [Run the application locally](#run-the-application-locally)
- [Useful Links](#useful-links)
- [Ownership](#ownership)

## Description

The **US Accidents API** is a Spring Boot based application which is aimed to inform the car accidents that occurred in the United States.

To store the accidents, the application uses Mongo DB.

The API provides the following functionalities:

- Get a paginated list of accidents that took place within a given polygon shape, providing the points that form the polygon.
- Get a paginated list of accidents that took place within a given circle shape, providing a point and radius.
- Get an accident by its identifier.
- Get a paginated list of all the accidents.
- Get the list of the most common conditions of the accidents (temperature, humidity, weather conditions)

## Run the application locally

1. Download the JSON file containing the dataset from [here](https://drive.google.com/file/d/17qCWlPhQbePxwhUWHy5oi8sAuVSb0YX2/view?usp=sharing).
2. Unzip the file and store it within the _/mongo_ folder, by the name **us_accidents.json**
3. On the root of the project, execute the command `docker-compose up`.
   This command will set up the Mongo database, executing the script _/mongo/import.sh_ which will import the dataset to the database.
4. Within the _/accidents_ folder, start the Java application.
5. Once the application is up and running, access the
   following [link](http://localhost:8080/swagger-ui/index.html#/) to see the API specification. You can test the endpoints developed through the Swagger UI,
   or using the Postman collection provided in the _/accidents/docs/BD2.postman_collection.json_ file,
   which gathers some sample requests to send to each endpoint.

## Useful Links

- [Mongo Repositories](https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html)
- [Spring Data MongoDB - Reference Documentation](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/)
- [Draw a Polygon online](https://www.mathsisfun.com/geometry/polygons-interactive.html)
- [Model Mapper](https://www.baeldung.com/java-modelmapper)

## Ownership

- Onofri, Melisa
- Repetto, Lorenzo

2022