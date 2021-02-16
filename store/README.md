## General:
Application provides very basic functionalities on STORE domain. It allow to get items and carts.


### App is based on:
- java 11
- springboot 2.x version
- JPA, Springdata, hibernate
- lombok
- swagger
- in memory H2 database
  
Note! More detailed dependencies can be seen in pom file.

### How to run todo demo app - from store directory:

by Intellij from StoreApplication class</br>
or  
mvn spring-boot:run  
or  
build with: mvn package  
and  
java -jar target\store-0.0.1-SNAPSHOT.jar

### How to open swagger UI

Open in browser:
http://localhost:8080/swagger-ui.html

### Tasks:

#### Task 1
- Create possibility of adding new store items via REST.
- Item should be added with given name, price and count.
- When item with given name already exists - extend its count.
- Response should contain created/updated item id.

#### Task 2
- create add a product to cart via REST.  
  Request Payload:
  ```
  {
  "cartId": 0,
  "itemId": 1
  } 
  ```
- Create new Cart if in db there is no Cart with id given in request.
- Count of item should be reduced if item is in the cart.
- It is not possible to add item when count is 0.

- create HTTP REST method to show cart with ordered items and total price of items from cart.  
  Response:
  ```
  {
  "orderItems": [
    {
    "name": "string",
    "price": 0
    }
  ],
  "totalPrice": 0
  }
  ```
- write test for features
