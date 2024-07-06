
# Alexis Biñuelo BetterCloud Test

This project was made in spring boot 3.3.1 also includes swagger documentation.
Requirements to run project :
* Java 17
* Maven 3.8.4

Project includes a H2 database so it's no necessary to install o run a database script
```sh
mvn spring-boot:run -- to run project
```
To see swagger documentation:
http://localhost:8081/swagger-ui/index.html

To test using curl(can use 1,2,3 as parameters): 
```sh
curl --location 'http://localhost:8081/draw/1' \
--header 'accept: */*'
```


