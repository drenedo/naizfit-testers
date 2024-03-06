# Coding challenge for "Naiz fit"

## Requirements

- Java >= 17
- Gradle is not mandatory you can use the gradle wrapper
- Any container runtime (Docker, Podman, Minikube...) for testing phase.

## Extructure of the project

The project is divided in three modules: **[testers-core](testers-core)**, **[testers-api](testers-api)** and **[testers-admin-api](testers-admin-api)**. 
The modules helps to scale the application and to separate the domain logic from the infrastructure logic. Also testers-core could be used as another application in the future.

The project is developed following an hexagonal architecture. The main idea is to separate the domain logic from the infrastructure logic.
In some use cases whe use domain events to communicate between different use cases.


### testers-core

This module contains the domain logic of the application, and the repository infrastructure. It is the core of the application.

### testers-api

This module contains the infrastructure logic of the application. It is the entry point of the application for the users.

### testers-admin-api

This module contains the infrastructure logic of the application. It is the entry point of the application for the admin users.

### Swagger documentation for both applications

You could find the swagger documentation in the following url:

http://instance/webjars/swagger-ui/index.html

## Persistence

The project uses a PostgreSQL database. The database is deployed in a container managed by testcontainers library for testing phases. 
Also the same database is used in the production phase. See [schema.sql](testers-core%2Fsrc%2Fmain%2Fresources%2Fschema.sql) of the database to know more about the data structure.

## Testing

The project is prepared to be tested with JUnit 5 and Mockito. The database is deployed in a container managed by testcontainers library for testing phases.

### Examples of post bodies to help in manual testing

Tester body
```json
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "name": "tester",
  "email": "tester@naiz.fit",
  "password": "tester",
  "birthdate": "2024-03-05",
  "sex": "MALE",
  "measures": [
    {
      "id": "3f285f64-5717-4562-b3fc-2c963f66afa6",
      "height": 234.5,
      "weight": 76.5
    },
    {
      "id": "3f185f64-5717-4562-b3fc-2c963f66afa6",
      "height": 234.5,
      "weight": 76.5
    }
  ]
}
```
Product body
```json
{
  "id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "sku": "sku",
  "sizes": [
    "M","L","XS","S","XL","XXL"
  ],
  "pictures": [
    "https://google.com"
  ],
  "color": "Red",
  "brand": {
    "id": "3fa85f64-5717-4562-b3fc-2c123466afa6",
    "name": "brand",
    "logo": "https://google.com"
  }
}
```

## Run the project with docker

You can run the project with docker using the following seps.

1. First you need to build the project.
```shell
~/testers$ ./gradlew build
```
2. Then run the script to build the docker images and launch the containers.
```shell
~/testers$ cd infra
~/testers/infra$ ./run.sh
```

## TODOs and improvements

### Pending ideas

- Better documentation.
- Run sonarqube.
- Testing e2e and more unit tests.
- Read and Update operations in CRUD for admin apps. 
- Optimization based in AOT, GraalVM needed. [More info](
  https://docs.spring.io/spring-boot/docs/current/reference/html/native-image.html)

### Better design decisions

- Permissions in use cases.
- More domain events, there are only one.

