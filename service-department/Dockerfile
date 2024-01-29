FROM eclipse-temurin:17-jre

ARG JAR_FILE=target/*.jar
ARG AGENT_FILE=agent/*.jar  

ADD ${JAR_FILE} /app.jar
ADD ${AGENT_FILE} /opentelemetry-javaagent.jar

EXPOSE 8081

ENTRYPOINT ["java","-javaagent:/opentelemetry-javaagent.jar","-jar","/app.jar"]