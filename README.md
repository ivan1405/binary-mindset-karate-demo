# Karate demo

This project contains some examples of how to develop Rest-Assured and Load tests for APIs using Karate

## Integration tests

The class KarateRunnerTest takes care of running the features and generating Cucumber reports with the results

```
mvn clean test
```

## Gatling

The Scala class LoadTests uses Gatlign to inject users during an specified time. To run it:
```
mvn clean test-compile gatling:test
```

You can specify the number of users and duration by giving the following params:
```
mvn gatling:test -DrampUpUsers=50 -DrampUpDuration=20
```

## Pipelines

There are two pipelines:
* Jenkins-it runs the integration tests on Jenkins
* Jenkins-loadtests runs the loadtests on Jenkins.