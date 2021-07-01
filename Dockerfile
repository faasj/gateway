FROM adoptopenjdk:16.0.1_9-jre-hotspot
EXPOSE 8080
WORKDIR /
COPY build/libs/*SNAPSHOT.jar /app.jar
CMD ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-jar", "app.jar"]