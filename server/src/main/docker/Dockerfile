FROM openjdk:15-jdk-alpine
RUN mkdir -p /usr/app/pupok
COPY ./*.jar /usr/app/pupok
WORKDIR /usr/app/pupok
EXPOSE 7911
ENTRYPOINT ["java", "-cp", "./*", "com.kolev.chat.Server"]