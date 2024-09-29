FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/hello.jar
ARG JAR_LIB_FILE=target/lib/

# cd /usr/local/runme
WORKDIR /usr/local/runme

# cp target/hello.jar /usr/local/runme/app.jar
COPY ${JAR_FILE} app.jar


# java -jar /usr/local/runme/app.jar
ENTRYPOINT ["java","-jar","app.jar"]