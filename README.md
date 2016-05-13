# What is this? #
///todo
## System Requirements ##

1. Get your environment installed. For more info see the  http://gitlab.webdev.wlw.de/webdevs/docker-compose project.
2. Maven 3.0.0 or newer, to build and deploy the examples
    * If you have not yet installed Maven, see the [Maven Getting Started Guide](http://maven.apache.org/guides/getting-started/index.html) for details.
    * If you have installed Maven, you can check the version by typing the following in a command line:
	
            mvn --version

## Check Out the Source ##

1. To clone this Git repository, use the following command:

            clone git@gitlab.webdev.wlw.de:webdevs/mad_profiler.git

## How to test my project? ##

This project contains   [Arquillian](http://arquillian.org/) tests which are executed against [WildFly](http://wildfly.org/) application server.

The Arquillian testing platform is used to enable the testing automation. Arquillian integrates transparently with the testing framework which is JUnit in this case.

The Tests defines the three core aspects needed for the execution of an Arquillian test cases:

container — the runtime environment
deployment — the process of dispatching an artifact to a container
archive — a packaged assembly of code, configuration and resources

The test cases are dispatched to the container's environment through coordination with ShrinkWrap, which is used to declaratively define a custom Java EE archive that encapsulates the test classes and its dependent resources. Arquillian packages the ShrinkWrap defined archive at runtime and deploys it to the target container. It then negotiates the execution of the test methods and captures the test results using remote communication with the server. Finally, Arquillian undeploys the test archive.

The POM (pom.xml) file contains two profiles:

* arq-wildlfy-managed — managed container
* arq-wildfly-remote — remote container

By default the arq-wildfly-managed (managed container) profile is active. An Arquillian managed container is a remote container whose lifecycle is managed by Arquillian.

### Test Execution ###

* Locally (you don not need to specify the name of the profile as the arq-wildlfy-managed profile is the default one)

            mvn clean test

* or remotely in case of a server deployed in docker or in a jenkins environment 

            mvn clean test -Parq-wildfly-remote

Please note that you have to set the path of your wildfly server in case of a local test or the IP address in case you want to test remotely.
The container's configuration resides in the Arquillian XML configuration file  (test/resources/arquillian.xml).


## How to deploy my project? ##

1. Make sure you start the Wildfly server as described in the http://gitlab.webdev.wlw.de/webdevs/docker-compose.
2. Open a command line and navigate to the root directory of the project you want to run.
3. Use this command to build and deploy the archive:

            mvn clean packag

4. Navigate to the view bundle (view-bundle)

            cd /view-bundle

5. Now you can deploy

            mvn -Pdefault wildfly:deploy


## More info? ##

//todo

- Un-deploy the project