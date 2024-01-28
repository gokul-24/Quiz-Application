FROM openjdk:17
EXPOSE 8081
ADD target/discover-docker.jar discover-docker.jar
ENTRYPOINT ["java","-jar","/discover-docker.jar"]