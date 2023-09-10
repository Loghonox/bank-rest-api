FROM maven:3.9.4-amazoncorretto-20-al2023
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bank.jar
RUN bash -c 'touch /bank.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bank.jar"]
WORKDIR /app/source
COPY . .

RUN mvn clean install -DskipTests

CMD mvn spring-boot:run