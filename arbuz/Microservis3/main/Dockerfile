# Используем официальный образ Java
FROM openjdk:17-jdk-slim as build

# Устанавливаем рабочую директорию
WORKDIR /Main

# Копируем файлы проекта в контейнер
COPY . .

# Собираем JAR файл с помощью Maven (или Gradle, если вы используете его)
RUN ./mvnw clean package -DskipTests

# Используем минимальный JDK образ для работы
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /main

# Копируем собранный JAR файл из предыдущего шага
COPY --from=build /Main/target/microservice-3-0.0.1-SNAPSHOT.jar microservice-3.jar

# Открываем порт, на котором будет работать приложение
EXPOSE 8083

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "microservice-3.jar"]
