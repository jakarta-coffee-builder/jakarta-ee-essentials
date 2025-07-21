#!/bin/bash
# Salir inmediatamente si un comando falla
set -e

echo "================================================="
echo "1. Construyendo e instalando el arquetipo localmente"
echo "================================================="
# Instala el arquetipo en el repositorio local de Maven del contenedor
mvn clean install

# Extraer la versión del arquetipo del pom.xml para usarla en el siguiente paso
ARCHETYPE_VERSION=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

echo "================================================="
echo "2. Generando un proyecto de prueba desde el arquetipo"
echo "================================================="
# Navegar a un directorio temporal para no ensuciar el código fuente
cd /tmp

# Generar el proyecto de forma no interactiva
mvn archetype:generate \
  -DinteractiveMode=false \
  -DarchetypeGroupId=com.apuntesdejava \
  -DarchetypeArtifactId=jakarta-ee-essentials \
  -DarchetypeVersion=${ARCHETYPE_VERSION} \
  -DgroupId=com.example.test \
  -DartifactId=test-project \
  -Dversion=1.0.0

echo "================================================="
echo "3. Construyendo el proyecto generado"
echo "================================================="
cd test-project
mvn clean package

echo "================================================="
echo "4. Verificando la estructura del proyecto generado"
echo "================================================="
# Comprobar que los archivos esenciales existen
if [ ! -f "pom.xml" ]; then
    echo "ERROR: El archivo pom.xml no se encontró en el proyecto generado."
    exit 1
fi
if [ ! -f "src/main/webapp/index.html" ]; then
    echo "ERROR: El archivo index.html no se encontró."
    exit 1
fi

# Comprobar contenido básico en el pom.xml generado
grep -q "<artifactId>test-project</artifactId>" pom.xml
if [ $? -ne 0 ]; then
    echo "ERROR: El artifactId esperado no se encontró en el pom.xml generado."
    exit 1
fi

echo "================================================="
echo "¡Verificación completada con éxito!"
echo "El arquetipo ha generado un proyecto válido."
echo "================================================="
