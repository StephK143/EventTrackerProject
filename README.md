# EventTracker

- [EventTracker](#midtermproject)
  - [Description](#description)
  - [Topics](#topics)
  - [How to Run](#how_to_run)
  - [Technologies](#technologies)
  - [Concepts](#concepts)
  - [Rest Endpoints](#rest_endpoints)
  - [UML Diagram](#uml_diagram)
  - [Concepts](#concepts)
  - [Challenges and Lessons Learned](#challenges-and-lessons-learned)
- [MidtermProject](#midtermproject-1)

## Description

This is a Ghost Tour tracker. Tours can be posted by users and then reviewed. Reviews can have comments added.


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




##  How to Run

//TODO: URL of deployed app

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


## REST Endpoints

Here are the links for Postman:

|   HTTP Verb Purpose |URI                           |Request Body              |Response Body            | Operation
|---------------------|------------------------------|--------------------------|-------------------------|------------
|GET                  | `/api/tours`                 |                          |List of tours            |Read
|GET                  | `/api/reviews`               |                          |List of reviews          |Read
|GET                  | `/api/comments`              |                          |List of comments         |Read
|GET                  |`api/review/{id}`             |                          |View review by id        |Read
|POST                 |`api/tours/{id}/reviews`      |JSON for new Tour         |Create review by tour id |Create





## UML diagram
[![](https://mermaid.ink/img/pako:eNqtU8tuwyAQ_JXVnpMf8LX1oYc0Upq0F0sWNRsHyYAFy8Gy_e-FxqniyqkatSshYGd4zCz0WFlJmCG5RyVqJ3Rh4Ctujffbww6GYb22Pezy16f8DTIo8CQ8aGG6Aq_JZ3o_T6VQhkHJed6zU6YGIzQtApXibhHwLHh5idKi_oaMV9NrZNKSlA09PGw3m_x5_4O0M_8-aay4oftEkxaqWUQk-cqplpU1c1za8N4QtE5VVLbkUvPWwPIu0bqychQ7-VsLLyrZBlcmqbcdjjFZ-V-PwGpNhv9abQBcoSYX3ZXxB3xerkA-UTwWU9ElHUVoONV8jNTQJqNyqdg6zI6i8bRCEdi-dKbCjF2gC2n6SxNr_ACZH-YW)](https://mermaid.live/edit#pako:eNqtU8tuwyAQ_JXVnpMf8LX1oYc0Upq0F0sWNRsHyYAFy8Gy_e-FxqniyqkatSshYGd4zCz0WFlJmCG5RyVqJ3Rh4Ctujffbww6GYb22Pezy16f8DTIo8CQ8aGG6Aq_JZ3o_T6VQhkHJed6zU6YGIzQtApXibhHwLHh5idKi_oaMV9NrZNKSlA09PGw3m_x5_4O0M_8-aay4oftEkxaqWUQk-cqplpU1c1za8N4QtE5VVLbkUvPWwPIu0bqychQ7-VsLLyrZBlcmqbcdjjFZ-V-PwGpNhv9abQBcoSYX3ZXxB3xerkA-UTwWU9ElHUVoONV8jNTQJqNyqdg6zI6i8bRCEdi-dKbCjF2gC2n6SxNr_ACZH-YW)

## ## Challenges and Lessons Learned

This project was our first with JPA and REST API's.
