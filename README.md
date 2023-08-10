This project was bootstrapped with Java 8.

# Autor

Emanuel Sodero

# Challange Dedalus Search Patient

This is a REST API search patient by id project built in [SprintBoot](https://spring.io/projects/spring-boot). 
For to complete this challenge, I was create one REST API that provides the capability to search Patient by id from a FHIR Repository.

## Objective

The backend will receive a request to get a patient by his ID. The request URL is up to you.
choice.
It will return a JSON with the following structure:
```
{
"id": "string",
"nhc": "string",
"name": "string",
"surname": "string",
"birthDate":"2023-08-07", (JSON date)
"gender": "Masculino|Femenino|Otro|Desconocido",
}
```

## Run

On the demo folder execute:

```
mvn install

mvn exec:java -Dexec.mainClass="com.demo.DemoApplication"

```

# Swagger

Documentation in

```

http://localhost:8081/swagger-ui/index.html

```
