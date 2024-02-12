FROM openjdk:17-oracle
COPY target/*.jar productmicroservice.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","productmicroservice.jar"]
