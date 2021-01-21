# product-sales-manager
API para gestionar la venta de productos de seguros

## Despliegue:
  1- Iniciar docker

  2- cd al directorio de proyecto

  3- Ejecutar docker build para crear la imagen:
    docker build --build-arg JAR_FILE=build/libs/\*.jar -t jcry/falabella-product-sales-manager .

  4- Ejecutar docker run para inicializar la imagen de app product-sales-manager:
    docker run -p 8080:8080 jcry/falabella-product-sales-manager
