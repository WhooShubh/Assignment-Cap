FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY  target/*.jar student.jar
ENTRYPOINT [ "java","-jar","student.jar" ]