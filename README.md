![Jenkins](https://img.shields.io/badge/jenkins-%23D24939.svg?style=for-the-badge&logo=jenkins&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
<a href="https://linkedin.com/in/leonardo-duprates">
    <img alt="LinkedIn" src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white"/>
</a>

# Jenkins Playground

This project provides a Dockerfile with the setup to run the Jenkins server and Docker in the same container for studying and testing purposes.

There are some examples available to demonstrate different Jenkins pipeline strategies, including declarative pipelines, shared libraries, etc.

## Jenkins

Jenkins is an open source platform developed using Java for managing continuous integration and delivery that started development in 2005, was originally called Hudson and renamed in 2011 after a dispute with Oracle.

Key Facts:

- Jenkins provides different strategies to create pipelines, always guiding users to use pipeline as code. This is known as the declarative pipeline, which uses a domain-specific language (DSL) based on Groovy.

- Jenkins uses the concept of building blocks, where each feature is a plugin that you choose to install in your application. Core plugins are maintained by the Jenkins community, while others are by companies and developers.

- The architecture of Jenkins is based on servers and agents. The server hosts the application and coordinates the execution of jobs on agents, which can be either local machines, virtual machines, or containers.

- Jenkins provides comprehensive and readable documentation about the platform and its plugins. It is a highly popular tool with a vast knowledge base on Github and developer forums.

- The project is supported by the Jenkins community and has relevant sponsors such as Amazon and GitHub. The most active sponsor is CloudBees, which supports the core plugins, documentation, and official certification.


## Examples

The examples available on this project cover declarative pipeline, build job pipeline, multibranch pipeline, and shared libraries.

In the examples, you can find how to run the pipeline using containers, set up nightly builds, handle catch errors to avoid pipeline failure, use parameters and environment variables, and more.

The JSApp examples use the project [javascript-testing](https://github.com/leoduprates/javascript-testing) to perform three types of pipelines, which are:

**Build:**
```bash
    ⦿ Checkout
    ⦿ Install Dependencies
    ⦿ Unit Tests
    ⦿ Integration Tests
    ⦿ Test Coverage
```

**E2E Tests:**
```bash
    ⦿ Checkout
    ⦿ Install Dependencies
    ⦿ Frontend Tests
    ⦿ Backend Tests
```
**Performance Test:**
```bash
    ⦿ Checkout
    ⦿ Performance Tests
```

## Docker

1\. Build Docker (Dockerfile) image.

```bash
$ docker build -t myjenkins .
```

2\. Run Docker containner.

```bash
$ docker run -d --name myjenkins -p 0.0.0.0:3000:8080 -p 50000:50000 -v /var/run/docker.sock:/var/run/docker.sock myjenkins
```

3\. The following command retrieve the Jenkins SSH key from a Jenkins Docker container:

```bash
$ docker exec myjenkins cat /var/jenkins_home/.ssh/id_rsa.pub
```

4\. Stop Docker container.

```bash
$ docker stop myjenkins
```

5\. Remove Docker image.

```bash
$ docker rm myjenkins
```

6\. If you are using Minikube to run the Docker CLI, the localhost will be available at the IP address assigned to the Minikube.

```bash
$ minikube ip
```
