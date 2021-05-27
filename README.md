# Project Description

**This application was Built by MVC architectural pattern based on Java Spring Boot in the Server Side,<br>
To manage inventory items list with a REST controller. The application exposes a *Swagger API* and the following APIs :**
 
 <p align="center">
  <img src="https://i.ibb.co/TBnL647/APIS.jpg" width="550" title="hover text">
</p>

- Read item details
- Add item to stock 
- Delete an item from stock  
- Withdrawal quantity of a specific item from stock 
- Deposit quantity of a specific item to stock 

**Item Model includes:**
```
id, item number, name, amount, inventory code
```
------

### Technology Stack

#### Back End:

java 15, Java Spring Boot, JPA, Hibernate

#### Database and Tools:

H2, MongoDB ATLAS *(cloud database service)* and Postman

#### Dependencies:

```
    spring-boot-starter-data-jpa
    spring-boot-starter-test
    spring-boot-starter-web
    spring-boot-starter-data-mongodb
    springfox-swagger-ui
    springfox-swagger2
    spring-boot-devtools
    Lombok
    H2
```
------

### JUnit tests for the API

for Testing the Controller API'S I used:

1. Added The Dependency: **`spring-boot-starter-test`**
2. Annotated **`itemsApplicationTests`** class with:
```
@RunWith(SpringRunner.class)
@SpringBootTest
```
3. Used **`restTemplate class`** to test the HTTP based restful web services exposed in my Controller. ***(GET, POST, PUT, DELETE)***

#### Example of Junit Test Execution:

In this execution we can see *4 tests passed, and 1 failed*.
 
 <p align="left">
  <img src="https://i.ibb.co/6gy08YN/tests.jpg" width="550" title="hover text">
</p>

on **`deleteItem @Test`** we got the following Exception: *"id is not exist"* - means i have tested with Item ID which is not found in the database.
 
 <p align="left">
  <img src="https://i.ibb.co/NKZMRxf/failed.jpg" width="550" title="hover text">
</p>

-------

### MongoDB ATLAS

is open and valid only to my ip whichc is replacing him self...

 <p align="left">
  <img src="https://i.ibb.co/Vq5nNFV/mongoDB.jpg" width="300" title="hover text">
</p>

-------

### Docker

**Once we have a working application, we should containerize it.** <br>

#### Steps has taken for containerizing the application:

1. Create a Jar File 
2. Create a Dockerfile as follows:

**to build an image I used a `Dockerfile` Configuration as follows:**
```
FROM openjdk:11
ADD target/demo.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]
```
**With the use of the Image below from `Docker Hub`:**

https://hub.docker.com/_/openjdk

3. Executing the commands Below:

> $docker build -f Dockerfile -t demo . <br>

after running the command above, Docker Image has been created:

<p align="left">
  <img src="https://i.ibb.co/1L4dZpx/docker-Image.jpg" width="550" title="hover text">
</p>

> $docker run -p 8080:8080 demo

**we can see the container of our App in DockerDesktop as follows:**

<p align="left">
  <img src="https://i.ibb.co/bBzPFMS/Docker-Desktop.jpg" width="550" title="hover text">
</p>

**Now we have the Application containerize and running as a proccess in the Docker.**

------

#### Heroku
**Another option of Deploying the Application onto a hosting service is Heroku Platform.** <br>
*you can see the application in the link below:*

https://springboot-backend-app.herokuapp.com/items

-------


