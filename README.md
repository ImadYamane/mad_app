## What is this? ##

## System Requirements ##

1. Get your environment installed. For more info see the  http://gitlab.webdev.wlw.de/webdevs/docker-compose project.
2. Maven 3.0.0 or newer, to build and deploy the examples
    * If you have not yet installed Maven, see the [Maven Getting Started Guide](http://maven.apache.org/guides/getting-started/index.html) for details.
    * If you have installed Maven, you can check the version by typing the following in a command line:
	
            mvn --version

## Check Out the Source ##

1. To clone this Git repository, use the following command:

            clone git@gitlab.webdev.wlw.de:webdevs/mad_profiler.git

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

coming soon:

- Running tests
- Un-deploy the project