This is a very simple Java and Spring application demonstrating the use of RabbitMQ on Cloud Foundry.

## Deploying to Cloud Foundry ##

After installing in the 'cf' [command-line interface](http://docs.cloudfoundry.com/docs/using/managing-apps/cf/) for Cloud Foundry, targeting a Cloud Foundry instance, and logging in, the application can be pushed using these commands:

    $ mvn package
    $ cf push
    ...
    Push successful! App 'rabbitmq-spring' available at http://rabbitmq-spring-12345.cfapps.io

The provided `manifest.yml` file will be used to provide the application parameters to Cloud Foundry. A unique URL will be assigned to the application, which is shown at the end of the output from 'cf push'. The `manifest.yml` file specifies a RabbitMQ services that is available on the [run.pivotal.io](http://docs.cloudfoundry.com/docs/dotcom/getting-started.html) Cloud Foundry services marketplace. You may need to change the details of the RabbitMQ service to push to a different Cloud Foundry instance.
