import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

def artifactId = request.artifactId
def sanitizedArtifactId = artifactId.replaceAll("[^a-zA-Z0-9]", "")

if (artifactId == sanitizedArtifactId) {
    return
}

// The project is generated inside a directory named artifactId
def projectDir = Paths.get(request.outputDirectory, artifactId)
def packagePath = request.package.replace('.', '/')
def sourceDir = projectDir.resolve("src/main/java/" + packagePath + "/" + artifactId)
def targetDir = projectDir.resolve("src/main/java/" + packagePath + "/" + sanitizedArtifactId)

if (Files.exists(sourceDir)) {
    println "Renaming package directory from ${sourceDir} to ${targetDir}"
    Files.move(sourceDir, targetDir, StandardCopyOption.REPLACE_EXISTING)
}
