# Jakarta EE Essentials Archetype

This archetype allows you to create a Jakarta EE project with the essential configurations, avoiding unnecessary dependencies and plugins. It provides a clean foundation for your applications.

## How to Use

To generate a new project using this archetype, run the following command in your terminal, replacing the placeholders with the desired values:


**bash**

```shell
mvn archetype:generate \
    -DarchetypeGroupId=com.apuntesdejava \
    -DarchetypeArtifactId=jakarta-ee-essentials \
    -DarchetypeVersion=0.0.7 \
    -DjakartaProfile=core \
    -DjakartaModule=web \
    -DgroupId=com.example \
    -DartifactId=my-jakarta-app \
    -Dversion=1.0.0-SNAPSHOT
```

**Powershell**

```powershell
mvn archetype:generate `
    -DarchetypeGroupId="com.apuntesdejava" `
    -DarchetypeArtifactId="jakarta-ee-essentials" `
    -DarchetypeVersion="0.0.7" `
    -DjakartaProfile="core" `
    -DjakartaModule="web" `
    -DgroupId="com.example" `
    -DartifactId="my-jakarta-app" `
    -Dversion="1.0.0-SNAPSHOT"
```


## Development and Deployment

Follow these instructions if you want to contribute to the archetype or deploy it.

### Local Installation

To build the archetype and install it in your local Maven repository, run the following command. This will make the archetype available on your machine for generating new projects locally.

```shell
mvn clean install
```

After installation, you can use the `archetype:generate` command shown above to test it.

### Deploying to Sonatype (Maven Central)

To deploy a release version to Sonatype, which synchronizes with Maven Central, you need to have GPG and your Sonatype credentials configured in your `settings.xml`.

Once your environment is set up, run the following command:

```shell
mvn versions:set -DnewVersion=<release-version> -DgenerateBackupPoms=false
mvn clean deploy -P release
```

This command will sign the artifacts and publish them through the Sonatype Central Portal.

## Continuous Integration (GitHub Actions)

This project uses GitHub Actions to automate the build and deployment processes. The workflow is defined in `.github/workflows/maven-ci-cd.yml` and includes the following jobs:

The workflow expects these repository secrets to be configured: `OSSRH_USERNAME`, `OSSRH_TOKEN`, `GPG_PRIVATE_KEY`, and `GPG_PASSPHRASE`.

- **Build and Test**:
  - Triggered on every push to the `develop`, `main`, and `master` branches.
  - It checks out the code, sets up JDK 21, and runs `mvn verify` to ensure the project builds successfully.

- **Deploy SNAPSHOT to Sonatype**:
  - Triggered on every push to the `develop` branch, after the `Build and Test` job succeeds.
  - It requires the Maven project version to end with `-SNAPSHOT`.
  - It deploys the artifact to Sonatype's snapshot repository.

- **Release to Sonatype Central**:
  - Triggered on every push to the `main` or `master` branch, after the `Build and Test` job succeeds.
  - It requires the Maven project version to end with `-SNAPSHOT`.
  - It creates a release version in the GitHub Actions runner (e.g., `1.0.0` from `1.0.0-SNAPSHOT`), signs the artifacts, and publishes them to Sonatype Central.
  - Finally, it creates a new release tag on GitHub.
