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
- Get an accident by its identifier
- Get the list of the most common conditions of the accidents (temperature, humidity, wind conditions, etc.)

## Run the application locally

-- TODO: explicar como levantarla

Once the app is up and running, access the
following [link](http://localhost:8080/swagger-ui/index.html#/) to see the API specification.

## Useful Links

- [Mongo Repositories](https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html)
- [Spring Data MongoDB - Reference Documentation](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/)
- [Draw a Polygon online](https://www.mathsisfun.com/geometry/polygons-interactive.html)
- [Model Mapper](https://www.baeldung.com/java-modelmapper)

## Ownership

- Onofri, Melisa
- Repetto, Lorenzo