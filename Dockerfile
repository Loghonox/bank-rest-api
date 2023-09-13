FROM maven:3.9.4-amazoncorretto-20-al2023
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bank1.jar
RUN bash -c 'touch /bank1.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bank1.jar"]
WORKDIR /app/source
COPY . .

RUN mvn clean install -DskipTests

CMD mvn spring-boot:run