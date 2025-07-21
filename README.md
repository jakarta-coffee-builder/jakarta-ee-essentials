# Jakarta EE Essentials Archetype

This archetype allows you to create a Jakarta EE project
with the least amount of dependencies and plugins. Includes:

- `web.xml`
- `microprofile-config.properties` (Microprofile Example)
- `persistence.xml`

```shell
mvn -DarchetypeGroupId=com.apuntesdejava \
    -DarchetypeArtifactId=jakarta-ee-essentials \
    -DjakartaProfile={jakartaProfile} \
    -DjakartaVersion={jakartaVersion} \
    org.apache.maven.plugins:maven-archetype-plugin:generate 
```

Values for `jakartaProfile`:
- core
- web
- full

Values for `jakartaVersion`:
- 10.0.0
- 11.0.0

## Development

### Local Installation

To build the archetype and install it in your local Maven repository, run the following command. This will make the archetype available on your machine for generating new projects.

```shell
mvn clean install
```

### Functional Testing

This project includes functional tests that verify the generated project's integrity. These tests use Docker to create an isolated environment, generate a project from the archetype, and then build that new project.

**Prerequisites:**
- Docker must be installed and running.

To run the tests, execute the following command:

```shell
mvn clean verify -P docker-test
```

### Deploying

To deploy a release version to the Maven repository, run:

```shell
mvn deploy -P release
```