FROM openjdk:11

ENV PATH ${PATH}:${JAVA_HOME}/bin

COPY target/nlp-notepad-project-*.jar /nlp-notepad-project.jar


ENTRYPOINT ["java", "-jar", "/nlp-notepad-project.jar"]


