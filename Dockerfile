FROM openjdk:11-jre-slim
COPY deliverymoment-service.jar app.jar
ENTRYPOINT ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar","app.jar"]
EXPOSE 8080
