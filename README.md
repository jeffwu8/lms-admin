# LMS Administrator Microservice
Implementation of a library management system admin REST API. Provides CRUD operations on following database tables: Authors, Books, Book Loans, Borrowers, Branches, and Publishers through HTTP requests.

## Getting Started

### Prerequisites

Please have installed:
* [JDK 1.8 (either Oracle or OpenJDK)](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3.5+](https://maven.apache.org/download.cgi)
* [Docker 19+](https://www.docker.com/products/docker-desktop)

### Building

With your CLI of choice, enter the directory containing the Dockerfile, src folder, and pom.xml. Package the java source code: 
```
mvn clean package
```

Extract the contents of the packaged jar file:
```
mkdir target/dependency && (cd target/dependency; jar -xf ../*.jar)
```

Build the Docker image:
```
docker build -t lms-admin .
```

### Running
Run the Docker image:
```
docker run -p 8081:8081 lms-admin
```

### Testing the Endpoint

Find the IP address of your docker machine
```
docker-machine ip
```

Make requests to the API using the IP on port 8081
```
{Docker Machine IP}:8081/lms/admin/authors
{Docker Machine IP}:8081/lms/admin/books
{Docker Machine IP}:8081/lms/admin/borrowers
{Docker Machine IP}:8081/lms/admin/branches
{Docker Machine IP}:8081/lms/admin/loans
{Docker Machine IP}:8081/lms/admin/publishers
```

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Java Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [H2 Database Engine](https://www.h2database.com/html/main.html) - Used to generate in-memory database
* [Hibernate](https://hibernate.org/) - ORM

## Credits & Similar Work
* **Jeffrey Wu** - *Main Contributor* - [Github](https://github.com/jeffwu8)
* **Ashraf Abbas** - *Teammate/Reviewer* - [Github](https://github.com/ash-abbas-smooth)
    * [LMS Borrower Microservice](https://github.com/ash-abbas-smooth/LMS-Borrower)
* **Marc Watters** - *Teammate/Reviewer* - [Github](https://github.com/SS-MW)
    * [LMS Librarian Microservice](https://github.com/SS-MW/LMS-Librarian)
