
[![Build Status](https://travis-ci.org/veritaserg/DeveloperJDBC.svg?branch=master)](https://travis-ci.org/veritaserg/DeveloperJDBC)


Необходимо создать БД, которая содержит следующие таблицы:

- developers (хранит данные о разработчиках)
- skills (навыки разработчиков – Java, C++, etc.)
- accounts (хранит анкетные данные разработчика)
При этом, связи между таблицами - следующие:
developers - skills ManyToMany
developers - accounts OneToOne
 
Необходимо реализовать консольное приложение, которое взаимодействует с данной БД.
Приложение должно позволять выполнять все CRUD операции для каждой из сущностей
Требования:
Придерживаться шаблона MVC
Миграция БД должна быть реализована с использованием liquibase
https://www.liquibase.org/
Для сборки проекта использовать Maven (для импорта зависимостей и сборки приложения)
Сборка приложения должна генерировать JAR файл
Для взаимодействия с БД - JDBC

Результатом выполнения задания должен быть отдельный репозиторий на github, с использованием Travis (https://travis-ci.org/) и отображением статуса сборки проекта.
