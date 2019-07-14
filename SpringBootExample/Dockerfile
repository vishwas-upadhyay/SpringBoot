FROM ubuntu:latest
COPY target/SpringBootExample-0.0.1-SNAPSHOT.jar /opt/spring-boot/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/spring-boot/lib/SpringBootExample-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888