FROM openjdk:11

EXPOSE 8080

COPY target/nlp-notepad-project-*.jar /nlp-notepad-project.jar

ENTRYPOINT ["java", "-jar", "/nlp-notepad-project.jar"]



