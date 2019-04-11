FROM sgrio/java-oracle:jdk_11_ubuntu
VOLUME /tmp
ARG jar=target/rai-scheduler.jar
ADD $jar app.jar
ENV JAVA_OPTS $JAVA_OPTS "-Xms2048m -Xmx4096m"
ENV JAVA_OPTS $JAVA_OPTS "-Dserver.port=8080"
ENV JAVA_OPTS $JAVA_OPTS "-Djava.security.egd=file:/dev/./urandom"
ENTRYPOINT exec java $JAVA_OPTS -jar /app.jar
