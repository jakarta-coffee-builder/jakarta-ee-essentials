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