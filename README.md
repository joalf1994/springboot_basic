# PROYECTO CURD BASICO CON SPRING BOOT

Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) desarrollada con Spring Boot y Java. Utiliza una base de datos H2 embebida para almacenamiento de datos. La aplicación gestiona una entidad `Persona`, y está estructurada en capas para una arquitectura limpia y mantenible.

## Características

- **CRUD completo** para la entidad `Persona`.
- **H2** como base de datos embebida.
- Implementación de **DTOs**, **Services**, **Repositories**, **Mappers** y **Controllers**.

## Requisitos

- Java 17
- Maven (para gestión de dependencias y construcción del proyecto)

## Estructura del Proyecto

- **`src/main/java/com/jbobadilla/crud`**: Código fuente de la aplicación.
    - **`controller`**: Controladores REST que manejan las solicitudes HTTP.
    - **`dto`**: Objetos de transferencia de datos utilizados para intercambiar información entre capas.
    - **`mapper`**: Mappers para la conversión entre entidades y DTOs.
    - **`model`**: Clases de entidad, como `Persona`.
    - **`repository`**: Interfaces de acceso a datos.
    - **`service`**: Servicios de negocio que implementan la lógica de la aplicación.
- **`src/main/resources`**: Archivos de configuración y recursos.
    - **`application.properties`**: Configuración de la aplicación, incluyendo la configuración de H2.


## Configuración

La base de datos H2 está configurada para funcionar en modo embebido. Puedes encontrar la configuración en `src/main/resources/application.properties`.

Ejemplo de configuración:

```properties
spring.datasource.url=jdbc:h2:mem:crud
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
```

La consola web de H2 se puede acceder en http://localhost:8080/h2-console con las siguientes credenciales:

- JDBC URL: `jdbc:h2:mem:crud`
- Usuario: `sa`
- Contraseña:

# Endpoints de la API
Se adjunta el archivo de colección Postman llamado `crud_basic.postman_collection.json` para pruebas

## Crear Persona
  - Método HTTP: POST
  - Ruta: /api/v1/persona
  - Descripción: Crea una nueva persona. 
  - Request Body:
```json
{
    "dni": "74859612",
    "nombre": "Maria",
    "apellido": "Contreras",
    "telefono": "+51987456321",
    "edad": 25,
    "sexo": 0
}
```
  - Response:
    - Código de estado: 200 OK
    - Body
```json 
{
    "id": 1,
    "dni": "74859612",
    "nombre": "Maria",
    "apellido": "Contreras",
    "telefono": "+51987456321",
    "edad": 25,
    "sexo": false
}
```
## Obtener Todas las Personas
- Método HTTP: GET
- Ruta: /api/v1/persona
- Descripción: Obtiene una lista de todas las personas.
- Response:
  - Código de estado: 200 OK
  - Body:
```json 
[
  {
  "id": 1,
  "dni": "74859612",
  "nombre": "Maria",
  "apellido": "Contreras",
  "telefono": "+51987456321",
  "edad": 25,
  "sexo": false
  },
  {
  "id": 2,
  "dni": "74859612",
  "nombre": "Juan",
  "apellido": "Prado",
  "telefono": "+51988546321",
  "edad": 45,
  "sexo": true
  }
]
```
## Obtener Persona por ID
- Método HTTP: GET
- Ruta: /api/v1/persona/{id}
- Descripción: Obtiene una persona específica por su ID.
- Request Parameter:
  - ID: 2 (ID de persona)
- Response:
  - Código de estado: 200 OK
  - Body:
```json
{
    "id": 2,
    "dni": "74859612",
    "nombre": "Juan",
    "apellido": "Prado",
    "telefono": "+51988546321",
    "edad": 45,
    "sexo": true
}
```
## Actualizar Persona
- Método HTTP: PUT
- Ruta: /api/v1/persona/upd
- Descripción: Actualiza una persona existente.
- Request Body:
```json
{
    "id": 2,
    "dni": "74859612",
    "nombre": "Carlos",
    "apellido": "Martines",
    "telefono": "+51987456321",
    "edad": 25,
    "sexo": 1
}
```
- Response:
  - Código de estado: `200 OK`
  - Body:
```json
{
    "id": 2,
    "dni": "74859612",
    "nombre": "Carlos",
    "apellido": "Martines",
    "telefono": "+51987456321",
    "edad": 25,
    "sexo": true
}
```

## Eliminar Persona
- Método HTTP: DELETE
- Ruta: /api/v1/persona/{id}
- Descripción: Elimina una persona por su ID.
- Request Parameter:
  - ID: 1 (ID de persona)
- Response:
  - Código de estado: 200 OK (Con un cuerpo vacío, sin contenido)