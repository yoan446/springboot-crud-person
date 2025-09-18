# Spring Boot CRUD - Person API

Un projet simple avec **Spring Boot** qui implémente un CRUD (Create, Read, Update, Delete) sur un objet `Person`.

## 🚀 Technologies utilisées
- Java 21
- Spring Boot 3.x
- Spring Data JPA
- MySQL (ou PostgreSQL, configurable)
- Maven

## 📌 Fonctionnalités
- Ajouter une personne (`POST /api/persons`)
- Récupérer toutes les personnes (`GET /api/persons`)
- Récupérer une personne par ID (`GET /api/persons/{id}`)
- Mettre à jour une personne (`PUT /api/persons/{id}`)
- Supprimer une personne (`DELETE /api/persons/{id}`)

## ⚙️ Configuration

Dans `src/main/resources/application.properties` configure la base de données :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ma_base
spring.datasource.username=root
spring.datasource.password=motdepasse
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
