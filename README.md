# SpringBoot-Phones-REST-API
This is a REST API build with Spring Boot. For Db it uses MySql. It is for learning purposes and it can be used in phonestore search system.
It is work in progress...

# Tools
- For running it is required you to have:

- Maven as your build tool

- JDK 1.8+

- MySql


# Dependencies

- It is required you to have these dependencies:

- Spring Data JPA

- MySql Driver

- Spring WEB

# Getting Started

Clone The Project `https://github.com/ilird7/java-project`

# Configure the Database

- Create a database in MySql
- Add credentials to `/src/main/resources/application.properties`.

```
## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url = jdbc:mysql://localhost:3306/name_of_your_database_here
spring.datasource.username = root
spring.datasource.password = ''


## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```

- Install the dependencies and run the application

# Endpoints

-For Phone Entity

`http://localhost:8080/api/phones` (GET) to get all the rooms

`http://localhost:8080/api/phones/{id}` (GET) to get a room by id

`http://localhost:8080/api/phones (POST)` to create a new room

`http://localhost:8080/api/phones/{id}` (PUT) to update an existing room

`http://localhost:8080/api/phones/{id}` (DELETE) to delete an existing room


-For Employee Entity

`http://localhost:8080/api/employees` (GET) to get all the employees

`http://localhost:8080/api/employees/{id}` (GET) to get an employee by id

`http://localhost:8080/api/employees (POST)` to create a new employee

`http://localhost:8080/api/employees/{id}` (PUT) to update an existing employee

`http://localhost:8080/api/employees/{id}` (DELETE) to delete an existing employee


-For Customer Entity

`http://localhost:8080/api/customers` (GET) to get all the guests

`http://localhost:8080/api/customers/{id}` (GET) to get a guest by id

`http://localhost:8080/api/customers (POST)` to create a new guest

`http://localhost:8080/api/customers/{id}` (PUT) to update an existing guest

`http://localhost:8080/api/customers/{id}` (DELETE) to delete an existing guest


