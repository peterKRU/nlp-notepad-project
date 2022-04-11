FROM openjdk:11


COPY target/nlp-notepad-project-*.jar /nlp-notepad-project.jar

ENTRYPOINT ["java", "-jar", "/nlp-notepad-project.jar"]



