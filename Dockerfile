FROM openjdk:17-jdk-slim
COPY ./build/libs/test_shift-0.0.1.jar /opt/service.jar
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://database:5432/sales
ENV POSTGRES_USER=postgres
EXPOSE 8080
CMD java -jar /opt/service.jar