# EventTracker

- [EventTracker](#eventtracker)
  - [Description](#description)
  - [Topics](#topics)
  - [How to Run](#how_to_run)
  - [Technologies](#technologies)
  - [Concepts](#concepts)
  - [Rest Endpoints](#rest_endpoints)
  - [UML Diagram](#uml_diagram)
  - [Concepts](#concepts)
  - [Challenges and Lessons Learned](#challenges-and-lessons-learned)


## Description

This is a Ghost Tour tracker. Tours can be posted by users and then reviewed. Reviews can have comments added.

- [Back to Top](#eventtracker)

## Topics
-   Creating a SQL database and subsequent tables
-   Configuring a JPA project
-   Configuring REST Api's
- Using Postman to test backend projects
-   Mapping Entities to SQL tables
-   Creating JUnit tests to ensure JPA mappings are correct
-   Integrating a Spring MVC project with a JPA project
-   Performing basic CRUD operations
-   Gradle dependency management



- [Back to Top](#eventtracker)

##  How to Run

-  [EventTrackerProject URL](#54.176.46.29:8083/EventTrackerProject)

- [Back to Top](#eventtracker)

# Technologies

-   REST API
-   JSON
-   MySQL 5.7
-   Spring Web MVC Framework
-   JPA
-   JPQL
-   JUnit 5
-   Bootstrap 5.2
-   CSS
-   JSP
-   MySQL Workbench
-   Gradle
-   MAMP
-   Git
-   Github
-   Spring Tool Suite 4
-   Slack
-   Zoom
-   macOS on Silicon

- [Back to Top](#eventtracker)

# Concepts

-   Request Mapping
-   Get, Post, Delete, Put
-   Database extraction with Repository
-   Style Pages - Object Oriented Programming
-   Class hierarchies
-   Interfaces
-   APIE (Abstraction - Polymorphism - Inheritance - Encapsulation)
-   Implementation
-   Lists
-   Collections
-   Try/Catch Statements and Exceptions
-   Web Forms

- [Back to Top](#eventtracker)

## REST Endpoints

Postman routes:

|   HTTP Verb Purpose |URI                                |Request Body              |Response Body            | Operation
|---------------------|-----------------------------------|--------------------------|-------------------------|-----------
|POST                 |`/api/tours`                       |JSON for new tour         |Create tour              |Create
|POST                 |`/api/tours/{tourId}/reviews`      |JSON for new review       |Create review by tour id |Create
|POST                 |`/api/reviews/{reviewId}/comments` |JSON for new comment      |Create comment for review|Create
|GET                  |`/api/tours`                       |                          |List of tours            |Read
|GET                  |`/api/reviews`                     |                          |List of reviews          |Read
|GET                  |`/api/comments`                    |                          |List of comments         |Read
|GET                  |`/api/review/{id}`                 |                          |View review by id        |Read
|PUT                  |`/api/tours/{tourId}`              |JSON to update tour       |Update tour              |Update      
|PUT                  |`/api/reviews/{reviewId}`          |JSON to update review     |Update review            |Update
|PUT                  |`/api/comments/{commentId}`        |JSON to update comments   |Update comment           |Update
|DELETE               |`/api/tours/{id}`                  |                          |Delete tour              |Delete
|DELETE               |`/api/reviews/{id}`                |                          |Delete review            |Delete
|DELETE               |`/api/comments/{id}`               |                          |Delete comment           |Delete






- [Back to Top](#eventtracker)

## UML diagram
[![](https://mermaid.ink/img/pako:eNqtU8tuwyAQ_JXVnpMf8LX1oYc0Upq0F0sWNRsHyYAFy8Gy_e-FxqniyqkatSshYGd4zCz0WFlJmCG5RyVqJ3Rh4Ctujffbww6GYb22Pezy16f8DTIo8CQ8aGG6Aq_JZ3o_T6VQhkHJed6zU6YGIzQtApXibhHwLHh5idKi_oaMV9NrZNKSlA09PGw3m_x5_4O0M_8-aay4oftEkxaqWUQk-cqplpU1c1za8N4QtE5VVLbkUvPWwPIu0bqychQ7-VsLLyrZBlcmqbcdjjFZ-V-PwGpNhv9abQBcoSYX3ZXxB3xerkA-UTwWU9ElHUVoONV8jNTQJqNyqdg6zI6i8bRCEdi-dKbCjF2gC2n6SxNr_ACZH-YW)](https://mermaid.live/edit#pako:eNqtU8tuwyAQ_JXVnpMf8LX1oYc0Upq0F0sWNRsHyYAFy8Gy_e-FxqniyqkatSshYGd4zCz0WFlJmCG5RyVqJ3Rh4Ctujffbww6GYb22Pezy16f8DTIo8CQ8aGG6Aq_JZ3o_T6VQhkHJed6zU6YGIzQtApXibhHwLHh5idKi_oaMV9NrZNKSlA09PGw3m_x5_4O0M_8-aay4oftEkxaqWUQk-cqplpU1c1za8N4QtE5VVLbkUvPWwPIu0bqychQ7-VsLLyrZBlcmqbcdjjFZ-V-PwGpNhv9abQBcoSYX3ZXxB3xerkA-UTwWU9ElHUVoONV8jNTQJqNyqdg6zI6i8bRCEdi-dKbCjF2gC2n6SxNr_ACZH-YW)

- [Back to Top](#eventtracker)
## Challenges and Lessons Learned



- [Back to Top](#eventtracker)
