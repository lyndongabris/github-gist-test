# github-gist-test
A test framework designed to test GitHub's GIST service

Author: Lyndon Gabris

This framework has been built using Serenity BDD (https://serenity-bdd.github.io/theserenitybook/latest/index.html).

##Prerequisites

The automation requires a properties file `user.properties` to be created in the project's home directory,
 and will require a personal access token to be defined here as `gist.token=TOKEN` where `TOKEN` needs
to be replaced with a GitHub personal access token with GIST scope.

A Gradle wrapper has been checked into source , and a task has been defined to run all
 the tests, which can be found as BDD scenarios in `src/test/resources`

This project uses Gradle to build and execute tests, and requires Java 1.8 with the JAVA_HOME environment variable to
defined (https://docs.gradle.org/current/userguide/build_environment.html)

##To execute the tests:

1. In a terminal navigate to the project 
2. Run the command `gradlew runTests`

I have also added a test runner to execute explicit tests tagged with `@selected`, with none specified by default. 
These can be executed with the command `gradlew runSelectedTests`

##Generating a Serenity BDD report

Once all the tests have been completed, the Serenity report can be generated by running the command `gradlew aggregate`

The report will be generated to the directory `target/site/serenity` and opening the `index.html` file

I have included use of the evidencing functionality so that the json files sent and received are recorded

By default, all created GISTs are deleted, but this functionality can be disabled by defining a property `delete.data.after.test=false`
 in the user.properties file