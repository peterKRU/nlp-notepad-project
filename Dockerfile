FROM openjdk:8

COPY target/nlp-notepad-project-*.jar /nlp-notepad-project.jar

CMD ["java", "-jar", "/nlp-notepad-project.jar"]



