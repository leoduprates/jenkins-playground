![Jenkins](https://img.shields.io/badge/jenkins-%23D24939.svg?style=for-the-badge&logo=jenkins&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
<a href="https://linkedin.com/in/leonardo-duprates">
    <img alt="LinkedIn" src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white"/>
</a>

# Jenkins Playground

This project provides a Dockerfile with the setup to run the Jenkins server and Docker in the same container for studying and testing purposes.

There are some examples available to demonstrate different Jenkins pipeline strategies, including declarative pipelines, shared libraries, etc.

## Docker

1\. Build Docker (Dockerfile) image.

```bash
$ docker build -t myjenkins .
```

2\. Run Docker containner.

```bash
$ docker run --name myjenkins -p 0.0.0.0:3000:8080 -p 50000:50000 -v /var/run/docker.sock:/var/run/docker.sock myjenkins
```

3\. Stop Docker container.

```bash
$ docker stop myjenkins
```

4\. Remove Docker image.

```bash
$ docker rm myjenkins
```

5\. If you are using Minikube to run the Docker CLI, the localhost will be available at the IP address assigned to the Minikube.

```bash
$ minikube ip
```
