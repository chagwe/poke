FROM  openjdk:8
EXPOSE 8080
ADD target/poke-application.jar poke-application.jar
ENTRYPOINT ["java","-jar","poke-application.jar"]