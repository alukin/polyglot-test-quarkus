# Polyglot bug reproduser for Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

**This repository will be archieved in a month or two because bug is finally fixed in release 1.13.0"
I hope the bug will not apear again becuase Quarkus developers added tests for GraalVM polyglot feature.

**THIS IS A BUG REPRODUCER for polyglot support in Quarkus. Polyglot support is brocken in Quarkus since 1.3.0 release
  due to class loader changes in Quarkus 1.3.0.**

**Note** that workaround provided in GreetinResource.java now required for not only debug mode but for Java and Native modes also.

Prevoiusly, bug was in development mode only. Polyglot (JavaScript in this case) worked in final builds in Java and Native mode.

This code also contains work-around commented out
 
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `polyglot-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/polyglot-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/polyglot-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

# RESTEasy JAX-RS

<p>A Hello World RESTEasy resource</p>

Guide: https://quarkus.io/guides/rest-json
