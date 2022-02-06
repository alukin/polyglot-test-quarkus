# Polyglot bug reproduser for Quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.


** Tested with version 2.7.0. Works fine.

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


# It fails again!
At least it does not work with GraalVM 22.0.0.2  native-image andQuarkus 2.7.0
I need to try some tricks again


### Exeptions

2022-02-06 22:00:05,885 INFO  [io.quarkus] (main) code-with-quarkus 1.0.0-SNAPSHOT native (powered by Quarkus 2.7.0.Final) started in 0.038s. Listening on: http://0.0.0.0:8080
2022-02-06 22:00:05,886 INFO  [io.quarkus] (main) Profile prod activated. 
2022-02-06 22:00:05,886 INFO  [io.quarkus] (main) Installed features: [cdi, resteasy, smallrye-context-propagation, vertx]
2022-02-06 22:00:19,028 ERROR [io.qua.ver.htt.run.QuarkusErrorHandler] (executor-thread-0) HTTP Request to /hello-resteasy failed, error id: fd35a6e6-96d3-4ce9-87f2-0f6a02e67b79-1: org.jboss.resteasy.spi.UnhandledException: java.lang.IllegalStateException: No language and polyglot implementation was found on the classpath. Make sure a language is added to the classpath (e.g., native-image --language:js).
        at org.jboss.resteasy.core.ExceptionHandler.handleApplicationException(ExceptionHandler.java:105)
        at org.jboss.resteasy.core.ExceptionHandler.handleException(ExceptionHandler.java:359)
        at org.jboss.resteasy.core.SynchronousDispatcher.writeException(SynchronousDispatcher.java:218)
        at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:519)
        at org.jboss.resteasy.core.SynchronousDispatcher.lambda$invoke$4(SynchronousDispatcher.java:261)
        at org.jboss.resteasy.core.SynchronousDispatcher.lambda$preprocess$0(SynchronousDispatcher.java:161)
        at org.jboss.resteasy.core.interception.jaxrs.PreMatchContainerRequestContext.filter(PreMatchContainerRequestContext.java:364)
        at org.jboss.resteasy.core.SynchronousDispatcher.preprocess(SynchronousDispatcher.java:164)
        at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:247)
        at io.quarkus.resteasy.runtime.standalone.RequestDispatcher.service(RequestDispatcher.java:73)
        at io.quarkus.resteasy.runtime.standalone.VertxRequestHandler.dispatch(VertxRequestHandler.java:151)
        at io.quarkus.resteasy.runtime.standalone.VertxRequestHandler$1.run(VertxRequestHandler.java:91)
        at io.quarkus.vertx.core.runtime.VertxCoreRecorder$13.runWith(VertxCoreRecorder.java:543)
        at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2449)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1478)
        at org.jboss.threads.DelegatingRunnable.run(DelegatingRunnable.java:29)
        at org.jboss.threads.ThreadLocalResettingRunnable.run(ThreadLocalResettingRunnable.java:29)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.lang.Thread.run(Thread.java:829)
        at com.oracle.svm.core.thread.JavaThreads.threadStartRoutine(JavaThreads.java:597)
        at com.oracle.svm.core.posix.thread.PosixJavaThreads.pthreadStartRoutine(PosixJavaThreads.java:194)
Caused by: java.lang.IllegalStateException: No language and polyglot implementation was found on the classpath. Make sure a language is added to the classpath (e.g., native-image --language:js).
