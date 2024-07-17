# Forum-Hub

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.1-brightgreen.svg)
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)
![JwT](http://jwt.io/img/badge.svg)

## 📌 Descripción

Forum-Hub es una API Rest de foro desarrollada con Spring Boot 3, diseñada para proporcionar una plataforma sobre discusiones en línea. Este proyecto implementa operaciones CRUD para tópicos y respuestas.

### 🌟 Características Principales

- **Gestión de Tópicos**: Crear, leer, actualizar y eliminar tópicos de discusión.
- **Sistema de Respuestas**: Permite a los usuarios responder a los tópicos existentes.
- **Autenticación JWT**: Implementa autenticación segura mediante JSON Web Tokens.
- **Validaciones**: Implementa validaciones para garantizar la integridad de los datos.
- **Manejo de Excepciones**: Gestión de errores personalizada para una mejor experiencia de usuario.
- **Persistencia de Datos**: Utiliza Spring Data JPA con MySQL para el almacenamiento eficiente de datos.
- **Migraciones de Base de Datos**: Implementa Flyway para gestionar y versionar el esquema de la base de datos.

## 🛠️ Tecnologías Utilizadas

- Java 17
- Spring Boot 3.1.1
- Spring Data JPA
- MySQL 8
- Flyway
- Bean Validation
- Lombok
- JSON Web Tokens (JWT)
- Spring Security


## 🚀 Instalación y Configuración

1. **Clonar el Repositorio**
   ```bash
   git clone https://github.com/yoldi-rgb/Forum-Hub.git
   cd Forum-Hub
   ```

2. **Configurar la Base de Datos**
   - Crea una base de datos MySQL.
   - Actualiza `src/main/resources/application.properties` con tus credenciales de base de datos.

3. **Ejecutar la Aplicación**
   ```bash
   ./mvnw spring-boot:run
   ```

   🌐 La aplicación estará disponible en `http://localhost:8080`

## 📚 Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/example/forum/
│   │   ├── controller/
│   │   ├── domain/  
│   │   ├── infra/
│   │   └── ForumApplication.java
│   └── resources/
│       ├── application.yml
│       └── db/migration/
└── test/
    └── java/
```

## 🔍 Uso de la API

La API proporciona los siguientes endpoints principales:

### Tópicos
- `POST /topicos`: Crea un nuevo tópico
- `GET /topicos`: Lista todos los tópicos
- `GET /topicos/{id}`: Obtiene un tópico específico
- `PUT /topicos`: Actualiza un tópico existente
- `DELETE /topicos/{id}`: Elimina un tópico

Para más detalles sobre cómo usar estos endpoints, consulta las clases en el paquete `controller`.

## 🛡️ Seguridad

El proyecto utiliza Spring Security para la autenticación y autorización. Asegúrate de configurar adecuadamente los roles y permisos según tus necesidades.


## 📬 Contacto

yoldi Carrada - [**Linkedin**](www.linkedin.com/in/yoldi-carrada)

---

⭐️ ¡Si te gusta Forum-Hub, no olvides darle una estrella en GitHub! ⭐️
