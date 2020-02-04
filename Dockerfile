FROM openjdk:8-jdk-alpine
RUN addgroup -S admin && adduser -S admin -G admin
USER admin:admin
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.smoothstack.avalanche.lms.adminmsvc.LmsAdminMsvc"]