FROM openjdk:17
EXPOSE 8888

WORKDIR /app


RUN curl -u admin:admin -o app.war "http://192.168.2.10:8081/repository/maven-releases/biz/picosoft/demo/v1/demo-v1.war"
ENTRYPOINT ["java","-war","app.war"]
