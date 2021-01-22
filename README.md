# product-sales-manager
API para gestionar la venta de productos de seguros

## Modelo de datos:
https://github.com/mokusan/product-sales-manager/blob/master/dataModel.png

## Documentacion de los rest services
http://localhost:8080/swagger-ui.html#/

## UI de Base de datos en memoria
http://localhost:8080/h2-console/
- JCDB URL: jdbc:h2:mem:test
- User: sa
- Password: (dejar en blanco) (Credenciales se puede modificar en el application.properties)

## Despliegue:
  1- Iniciar docker

  2- cd al directorio de proyecto

  3- Ejecutar docker build para crear la imagen:
  
    docker build --build-arg JAR_FILE=build/libs/\*.jar -t jcry/falabella-product-sales-manager .

  4- Ejecutar docker run para inicializar la imagen de app product-sales-manager:
  
    docker run -p 8080:8080 jcry/falabella-product-sales-manager
