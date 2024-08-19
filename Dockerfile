FROM openjdk:17
EXPOSE 8888

WORKDIR /app


RUN curl -u admin:admin -o app.war "http://172.16.4.132:8081/repository/maven-releases/biz/picosoft/demo/v1/demo-v1.war"
ENTRYPOINT ["java","-war","app.war"]
