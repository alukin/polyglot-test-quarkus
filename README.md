# polyglot-test-quarkus

This is simpliest possible test application to run JavaScript inside of Quarkus application.
It works perfect with release 1.2.1 but does not work with any newest starting from to 1.3.0

Quarkus does not work with GraalVM polyglot feature since release 1.3.0 up to 1.9.0
in development mode. It works filne when running "runnner" jar with GraalVM. In all other
cases it does not work.

To test it, you need GraalVM 20.2.0 installed.

Run to get exceptions:

./mvnw compile quarkus:dev
And then open your browser with URL http://localhost:8080/hello

Run to get it working
./mvnw clean package
java -jar target/polygottest-1.0.0-SNAPSHOT-runner.jar

You'll see "From JS: 42" string in your browser.

It does not work when runing from IDE in "Run" or "Debug" mode either
