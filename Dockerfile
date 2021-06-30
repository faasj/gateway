FROM adoptopenjdk:16.0.1_9-jre-hotspot
EXPOSE 8080
COPY build/libs/*SNAPSHOT.jar /app.jar
LABEL maintainer="Roman Ivanov <roman@faasj.com>"
CMD ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseContainerSupport", "-jar", "app.jar"]