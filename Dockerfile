FROM centos:latest

RUN yum install libXext.x86_64
RUN yum install libXrender.x86_64 
RUN yum install libXtst.x86_64

FROM openjdk:8

ENV JAVA_HOME /opt/jdk

ENV PATH ${PATH}:${JAVA_HOME}/bin

COPY target/nlp-notepad-project-*.jar /nlp-notepad-project.jar


ENTRYPOINT ["java", "-jar", "/nlp-notepad-project.jar"]


