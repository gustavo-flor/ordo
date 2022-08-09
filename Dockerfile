FROM maven:3.8.5-openjdk-17-slim AS build

COPY pom.xml .
COPY api api
COPY core core

RUN mvn clean install --batch-mode -DskipTests

FROM openjdk:17-slim AS release

COPY --from=build /api/target/*.jar /api.jar
COPY docker-entrypoint.sh /

RUN chmod +x /docker-entrypoint.sh

ENTRYPOINT ["/docker-entrypoint.sh"]
