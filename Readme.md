# Spring Boot 3.2 with Java 21 Project

This project demonstrates the usage of Spring Boot 3.2 with Java 21, showcasing the latest features introduced in Java 21, including records, sealed classes, pattern matching, text blocks, Project Loom, and Virtual Threads, as well as Sequenced Collections.

## Java 21 Features

### Records

[Java records](https://docs.oracle.com/en/java/javase/16/language/records.html) provide a concise way to model immutable data without boilerplate code. The project leverages records for simplifying data structures.

### Sealed Classes

Sealed classes and interfaces allow you to control which classes can be subclasses. This enhances encapsulation and enables better design of APIs.

### Pattern Matching

Pattern matching simplifies code by providing a more concise and readable syntax for conditional statements. This feature is used throughout the project for improved code expressiveness.

### Text Blocks

[Text blocks](https://docs.oracle.com/en/java/javase/13/text-blocks/index.html) offer a cleaner way to include multiline strings in the code, making it easier to write and maintain text-heavy content such as SQL queries or HTML templates.

### Project Loom and Virtual Threads

Project Loom introduces lightweight, user-mode threads known as Virtual Threads. This enables highly scalable and efficient concurrent programming. The project explores the benefits of using Virtual Threads.

### Sequenced Collections

Java 21 introduces sequenced collections, providing an ordered and deterministic alternative to unordered collections. The project demonstrates the usage of sequenced collections for predictable iteration order.

