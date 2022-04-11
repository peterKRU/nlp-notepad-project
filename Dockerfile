FROM openjdk:11


COPY target/nlp-notepad-project-*.jar /nlp-notepad-project.jar
COPY lib/mysql-connector-java-8.0.28.jar /mysql-connector-java-8.0.28.jar

CMD ["java", "-cd", "/*"]
ENTRYPOINT ["java", "-jar", "/nlp-notepad-project.jar"]



