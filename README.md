# Microservicio Creado Por KennerEspinalDev

_Sistema desarrollado por KennerDev_

## Comenzando 🚀

### Pre-requisitos 📋

_Para poder inicializar el sistema se requiere lo siguiente :_

```
1. Spring Boot.
2. Docker & Docker Compose.
3. PostgreSQL.
4. IntelliJ (Editor de Codigo).
5. Git (Controlador de versiones).
```

### Instalación 🔧
```
git clone https://github.com/KennerEspinal/Spring-Boot-Hexagonal.git
```

## Configuring the Dockerfile
-	Dockerfile.
```sh
# Establece la imagen base para la fase de compilación
FROM maven:3.8.4-openjdk-17 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml del contexto de construcción local al directorio de trabajo en el contenedor
COPY pom.xml .

# Copia el directorio src del contexto de construcción local al directorio de trabajo en el contenedor
COPY src ./src

# Ejecuta el comando "mvn package -DskipTests" para compilar el proyecto Maven y generar el archivo JAR de la aplicación
RUN mvn package -DskipTests

# Establece la imagen base para la fase de empaquetado
FROM openjdk:17-jdk-slim AS final

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado durante la fase de compilación desde el directorio /app/target al directorio /app en esta segunda fase
COPY --from=build /app/target/microservice-products-*.jar /app/microservice-products.jar

# Copia los archivos de Swagger generados durante la compilación al directorio correspondiente dentro del contenedor
COPY --from=build /app/target/classes/META-INF/swagger /app/META-INF/swagger

# Expone el puerto 8080 del contenedor para que la aplicación pueda ser accedida desde fuera del contenedor
EXPOSE 8080

# Instala la herramienta "dockerize" para esperar a que la base de datos esté disponible antes de iniciar la aplicación
RUN apt-get update && \
    apt-get install -y wget && \
    wget https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-linux-amd64-v0.6.1.tar.gz && \
    tar -C /usr/local/bin -xzvf dockerize-linux-amd64-v0.6.1.tar.gz && \
    rm dockerize-linux-amd64-v0.6.1.tar.gz

# Define el comando predeterminado que se ejecutará cuando se inicie el contenedor
CMD ["dockerize", "-wait", "tcp://0.0.0.0:5432", "-timeout", "10s", "java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "/app/microservice-products.jar"]

```

## Autor ✒️

* **Kenner Espinal**

## Expresiones de Gratitud 🎁

* Comenta a otros sobre este proyecto 📢
* Invitanos una cerveza 🍺 o un café ☕ a alguien del equipo. 
* Da las gracias públicamente 🤓.
* etc.
