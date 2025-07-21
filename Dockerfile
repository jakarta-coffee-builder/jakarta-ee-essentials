# Usar una imagen base oficial de Maven con JDK 17 (Temurin)
FROM maven:3.9-eclipse-temurin-17-focal

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /usr/src/app

# Copiar el script de prueba primero para darle permisos
COPY run-test.sh .

# Dar permisos de ejecución al script
RUN chmod +x run-test.sh

# Copiar el resto del código del proyecto
COPY . .

# Establecer el script como el comando por defecto a ejecutar, usando bash explícitamente
CMD ["/bin/bash", "./run-test.sh"]