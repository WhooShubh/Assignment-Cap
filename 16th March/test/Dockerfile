# start from jdk image
FROM eclipse-temurin:17-jdk-jammy

# copy the springboot jar into the container
COPY target/test-0.0.1-SNAPSHOT.jar test.jar

# Port Number
# EXPOSE 8080

# run the jar
ENTRYPOINT [ "java", "-jar", "/test.jar" ]
# java -jar /test.jar