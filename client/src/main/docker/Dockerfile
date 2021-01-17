FROM openjdk:15-jdk-alpine
RUN mkdir -p /usr/app/pupok/client
COPY ./*.jar /usr/app/pupok/client
WORKDIR /usr/app/pupok
EXPOSE 7911
ENTRYPOINT ["java", "-cp", "./*", "com.kolev.chat.Client"]