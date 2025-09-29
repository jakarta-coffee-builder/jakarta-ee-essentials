import java.io.File

// 'basedir' is the test directory, e.g., target/it/simple-test
File basedir = new File(basedir)
File buildLog = new File(basedir, "build.log")
assert buildLog.exists() : "El log de build no existe"
assert buildLog.text.contains("BUILD SUCCESS") : "La compilación del proyecto generado falló"

// The generated project is in a subdirectory, named after the artifactId
File projectDir = new File(basedir, "my-app")
assert projectDir.isDirectory() : "El directorio del proyecto 'my-app' no fue generado"

// Check for key files
File pom = new File(projectDir, "pom.xml")
assert pom.isFile() : "pom.xml no existe en el proyecto generado"

File indexHtml = new File(projectDir, "src/main/webapp/index.html")
assert indexHtml.isFile() : "index.html no existe"

// Check some content
String pomText = pom.text
assert pomText.contains("<groupId>com.example</groupId>")
assert pomText.contains("<artifactId>my-app</artifactId>")
assert pomText.contains("<name>my-app</name>")

println "Verificación completada con éxito."
return true