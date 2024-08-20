# Use an official Maven image to build the app
FROM maven:3.8.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Build the Spring Boot application
RUN mvn clean install

# Use an official Tomcat image as the base
FROM tomcat:9.0.79-jdk17-temurin

# Copy custom server.xml and context.xml into the appropriate directories
COPY tomcat-conf/server.xml /usr/local/tomcat/conf/
COPY tomcat-conf/context.xml /usr/local/tomcat/conf/

# Add PostgreSQL JDBC driver
#COPY path/to/postgresql-<version>.jar /usr/local/tomcat/lib/

# Copy the WAR file to the Tomcat webapps directory
#COPY --from=build /app/target/demo-v1.war /usr/local/tomcat/webapps/
COPY --from=build /app/target/demo-v1.war /usr/local/tomcat/webapps/
COPY --from=build /app/dependency/*.jar /usr/local/tomcat/lib/

# Expose the port your app runs on
EXPOSE 8888

# Set the entry point to start Tomcat
CMD ["catalina.sh", "run"]
