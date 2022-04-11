FROM openjdk:11

EXPOSE 3306

COPY target/nlp-notepad-project-*.jar /nlp-notepad-project.jar

ENTRYPOINT ["java", "-jar", "/nlp-notepad-project.jar"]



