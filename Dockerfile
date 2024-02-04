FROM openjdk:11
EXPOSE 8080
ADD /target/springdevops-integration.jar springdevops-integration.jar
ENTRYPOINT ["java", "-jar", "/springdevops-integration.jar"]