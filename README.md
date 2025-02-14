[![](https://img.shields.io/badge/java-packagecloud.io-844fec.svg)](https://packagecloud.io/)

# java-build-essentials 1.0.1
Essentials for Java building

### Usage

#### ChangeLog Version Checker

```xml
    <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <executions>
            <execution>
                <id>ChangelogVersion</id>
                <phase>prepare-package</phase>
                <goals>
                    <goal>java</goal>
                </goals>
                <configuration>
                    <mainClass>com.mlieshoff.build.essentials.ChangeLogVersionChecker</mainClass>
                    <arguments>
                        <argument>./VERSION.txt</argument>
                        <argument>./CHANGELOG.md</argument>
                    </arguments>
                </configuration>
            </execution>
        </executions>
    </plugin>
```

#### ReadMe Version Checker

```xml
    <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <executions>
            <execution>
                <id>ReadmeVersion</id>
                <phase>prepare-package</phase>
                <goals>
                    <goal>java</goal>
                </goals>
                <configuration>
                    <mainClass>com.mlieshoff.build.essentials.ReadmeVersionChecker</mainClass>
                    <arguments>
                        <argument>./VERSION.txt</argument>
                        <argument>./README.md</argument>
                        <argument>${groupId}</argument>
                        <argument>${artifactId}</argument>
                    </arguments>
                </configuration>
            </execution>
        </executions>
    </plugin>
```

#### Release Version Checker 

```xml
    <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <executions>
            <execution>
                <id>ReleaseVersion</id>
                <phase>prepare-package</phase>
                <goals>
                    <goal>java</goal>
                </goals>
                <configuration>
                    <mainClass>com.mlieshoff.build.essentials.ReleaseVersionChecker</mainClass>
                    <arguments>
                        <argument>./VERSION.txt</argument>
                        <argument>./pom.xml</argument>
                    </arguments>
                </configuration>
            </execution>
        </executions>
    </plugin>
```

## How to bind the packagecloud repository

```xml
    <repositories>
        <repository>
            <id>packagecloud-java-build-essentials</id>
            <url>https://packagecloud.io/mlieshoff/java-build-essentials/maven2</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
```

## Add dependency

to Gradle:
```groovy
    implementation group: 'com.mlieshoff', name: 'java-build-essentials', version: '1.0.1'
```

to Maven:
```xml
    <dependency>
        <groupId>com.mlieshoff</groupId>
        <artifactId>java-build-essentials</artifactId>
        <version>1.0.1</version>
    </dependency>
```

## Continuous Integration

https://github.com/mlieshoff/java-build-essentials/actions

## Repository

https://packagecloud.io/mlieshoff/java-build-essentials

## Logging

We are using SLF4j.
