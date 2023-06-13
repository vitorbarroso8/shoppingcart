# Shoppingcart

API restfull to controller the workflow shoppingcart.

## Run the projetc

Developed using Java 17 with Spring boot, data, jpa, web.
Docker, mysql, swagger.

To rum its necessary: 
-Docker

```
docker compose up
```
After the project running is possible to validate tests in Insominia

The collections package is ```/shoppingcart/collection```


The logical for discont is ```ShoppingCartServiceImpl``` method ```getTotalPrice()```



### The architecture and the design implemented

```
/config: configurations 
/controllers: endpoints 
/entity: models and entity
/repositories: jpa repositories
/services: services to provide implementation
/impl: implementation of services
```