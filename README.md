# product-sales-manager
API para gestionar la venta de productos de seguros

## Modelo de datos:
https://github.com/mokusan/product-sales-manager/blob/master/dataModel.png

## Documentacion de los rest services
http://localhost:8080/swagger-ui.html#/

## Colección Postman
https://www.getpostman.com/collections/ba4bc277c09d90c2ca07

## UI de Base de datos en memoria
http://localhost:8080/h2-console/
- JCDB URL: jdbc:h2:mem:test
- User: sa
- Password: password (Credenciales se puede modificar en el application.properties)

## Despliegue:
  1- Iniciar docker

  2- cd al directorio de proyecto
  
  3- Modificar el campo "cron.expression" en el archivo application.properties en caso de que se desee modificar el tiempo de ejecución del proceso que modifica los precios. Actualmente está configurado para ejecutarse cada 24h a las 5:35 am. Para fines de prueba se puede modificar la expresión cron para que el proceso se ejecute cada 30 segundo (cron.expression=*/30 * * * * *) 

  4- Ejecutar docker build para crear la imagen:
  
    docker build --build-arg JAR_FILE=build/libs/\*.jar -t jcry/falabella-product-sales-manager .

  5- Ejecutar docker run para inicializar la imagen de app product-sales-manager:
  
    docker run -p 8080:8080 jcry/falabella-product-sales-manager
