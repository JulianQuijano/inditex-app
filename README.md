# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

### Maven Start Up Batch script

#### Required:

*   JAVA_HOME - location of a JDK home dir 
*   Lombok Annotations processing enabled

#### Optional ENV vars
*   M2_HOME - location of maven2's installed home dir
*   MAVEN_OPTS - parameters passed to the Java VM when running Maven
    e.g. to debug Maven itself, use
      set MAVEN_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
*   MAVEN_SKIP_RC - flag to disable loading of mavenrc files

## Curl example

```
curl --location --request GET 'http://localhost:8080/brand/1/product/35455/price?date_time=2020-06-14-10.00.00'
```