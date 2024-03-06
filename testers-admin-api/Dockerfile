FROM amazoncorretto:17-alpine3.16
RUN addgroup -S naizfit && adduser -S naizfit -G naizfit
USER naizfit:naizfit
COPY build/libs/testers-admin-api-0.0.1-SNAPSHOT.jar testers-admin-api.jar
EXPOSE 8080

ENTRYPOINT ["java", "-Xms200m", "-Xmx400m", "-Xlog:gc=debug:stdout", "-jar", "testers-admin-api.jar"]
