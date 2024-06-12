# Prueba Técnica Spring Boot

## Descripción

Este proyecto es una API desarrollada con Spring Boot que permite realizar un mantenimiento CRUD de naves espaciales de series y películas. La aplicación incluye funcionalidades de consulta, creación, modificación y eliminación de naves espaciales, y está diseñada para ser ejecutada en un entorno Dockerizado. También incluye características adicionales como test unitarios, gestión centralizada de excepciones, caching, logging con aspectos, y seguridad.

## Requisitos

- Java 17 (última versión LTS)
- Maven 3.6+
- Docker
- Docker Compose

## Funcionalidades

- Consultar todas las naves con paginación.
- Consultar una única nave por ID.
- Consultar todas las naves que contienen un valor en su nombre.
- Crear una nueva nave.
- Modificar una nave existente.
- Eliminar una nave.
- Test unitario de una clase.
- Logging con Aspect para peticiones con ID negativo.
- Gestión centralizada de excepciones.
- Caching de resultados.
- API documentada con Swagger/OpenAPI.
- Seguridad en los endpoints.
- Integración con Kafka como broker de mensajería.

## Instrucciones para Ejecutar la Aplicación

### Paso 1: Configurar el entorno

Asegúrate de tener Java 17, Maven y Docker instalados en tu sistema.

### Paso 2: Construir el proyecto

Ejecuta el siguiente comando para limpiar y empaquetar el proyecto con Maven:
mvn clean package

### Paso 3: Construir y ejecutar el contenedor Docker

Crea y ejecuta el contenedor Docker con el siguiente comando:
docker build -t spaceships-app .
docker run -p 8080:8080 spaceships-app


### Paso 4: Acceder a la aplicación
La aplicación estará disponible en http://localhost:8080. Puedes acceder a la consola H2 en http://localhost:8080/h2-console y a la documentación de la API en http://localhost:8080/swagger-ui.html.

### Paso 5: Probar la API
Usa herramientas como curl o Postman para probar los endpoints de la API.

### Ejemplos de Comandos curl
Consultar todas las naves:
curl -u username:password -X GET "http://localhost:8080/api/spaceships"

## Consultar una nave por ID:
curl -u username:password -X GET "http://localhost:8080/api/spaceships/1"

## Consultar naves por nombre:
curl -u username:password -X GET "http://localhost:8080/api/spaceships/search/by-name?name=Falcon"

## Crear una nueva nave:
curl -u username:password -X POST -H "Content-Type: application/json" -d '{"name":"New Ship","series":"New Series","movie":"New Movie"}' "http://localhost:8080/api/spaceships"

## Modificar una nave:
curl -u username:password -X PUT -H "Content-Type: application/json" -d '{"name":"Updated Ship","series":"Updated Series","movie":"Updated Movie"}' "http://localhost:8080/api/spaceships/1"

## Eliminar una nave:
curl -u username:password -X DELETE "http://localhost:8080/api/spaceships/1"

## Características Adicionales


### Logging con Aspect
Se ha implementado un aspecto para registrar un mensaje en el log cuando se realiza una petición para obtener una nave con un ID negativo. Este aspecto intercepta las llamadas a los métodos de los controladores y, si el ID proporcionado en la URL es negativo, registra un mensaje de advertencia en los logs del servidor. Esta característica es útil para detectar y manejar posibles errores en las solicitudes de los clientes.

### Gestión Centralizada de Excepciones
Se ha centralizado la gestión de excepciones mediante @ControllerAdvice para manejar errores de manera uniforme. Esta clase captura las excepciones lanzadas en los controladores y devuelve respuestas personalizadas con mensajes de error y códigos de estado HTTP adecuados. Esto mejora la manejabilidad y consistencia de los errores en la API.

### Caching
Se ha implementado caching para mejorar el rendimiento de las consultas. Utilizando la anotación @Cacheable en los métodos del servicio, los resultados de las consultas a la base de datos se almacenan en caché. Esto reduce la carga en la base de datos y mejora el tiempo de respuesta de la API para las solicitudes repetidas.

### Seguridad
La API está asegurada con Spring Security y requiere autenticación básica para acceder a los endpoints. Se ha configurado un filtro de seguridad que intercepta todas las solicitudes y verifica las credenciales proporcionadas en los encabezados de la solicitud. Esto garantiza que solo los usuarios autorizados puedan acceder y manipular los datos.

### Integración con Kafka
Se ha añadido la configuración necesaria para integrar la aplicación con Kafka como broker de mensajería. Esto permite que la aplicación pueda producir y consumir mensajes de un tópico de Kafka, facilitando la comunicación asíncrona entre servicios y mejorando la escalabilidad de la arquitectura de microservicios.

### Contribuir
Si deseas contribuir a este proyecto, por favor, realiza un fork del repositorio y envía un pull request con tus mejoras.

### Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.
