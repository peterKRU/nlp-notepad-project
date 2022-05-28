FROM openjdk

ENV TEST="elelele"

EXPOSE 4000

COPY target/nlp-notepad-project-*.jar /nlp-notepad-project.jar

ENTRYPOINT ["java", "-jar", "/nlp-notepad-project.jar"]



