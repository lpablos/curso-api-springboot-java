# ===============================
# Etapa 1: Build
# ===============================
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Archivos necesarios para Maven
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw

# Descargar dependencias (cache)
RUN ./mvnw dependency:go-offline

# Código fuente
COPY src src

# Construir el JAR
RUN ./mvnw clean package -DskipTests

# ===============================
# Etapa 2: Runtime
# ===============================
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/curso-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

