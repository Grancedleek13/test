# Используем базовый образ OpenJDK
FROM openjdk:11-jdk-slim

# Устанавливаем рабочую директорию в контейнере
WORKDIR /Main

# Копируем файлы проекта в контейнер
COPY target/microservice /Main/app.java

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "microservice-1.jar"]
