# DevSecOps Project - Wanderlust

This is a DevSecOps project aimed at creating a web application called "Wanderlust". Wanderlust is a journal application where users can record their outdoor adventures, thoughts, and experiences.

## Overview

The project involves setting up a cloud-based infrastructure on Amazon Web Services (AWS), containerizing the application using Docker, implementing a CI/CD pipeline with Jenkins, and ensuring security through various tools such as SonarQube, OWASP Dependency-check, and Trivy.

## Project Setup

1. **AWS Setup**
   - Launch a new EC2 instance on AWS.
   - Open port 5000 for backend and port 5173 for frontend.

2. **Backend Setup**
   - Pull the code from the [Wanderlust GitHub Repository] (https://gihub.com/krishnaacharyaa/wanderlust.git)
   - Download and install Node.js and npm.
   - Install MongoDB and fill it with dummy data.
   - Connect the backend to the MongoDB server.

3. **Frontend Setup**
   - Run `npm i` to install dependencies.

4. **Docker Setup**
   - Install Docker.
   - Create Dockerfiles for backend and frontend.
   - Build Docker images for backend and frontend.
   - Create Docker containers for backend and frontend.
   - Use Docker Compose to manage multi-container Docker applications.
   - Add Redis container in the `docker-compose.yml` file.

5. **Jenkins Setup**
   - Install Jenkins.
   - Install necessary Jenkins plugins: SonarQube Scanner, Sonar Quality Gates, OWASP Dependency-check, Docker.
   - Install Trivy.
   - Webhook SonarQube and Jenkins.

6. **CI/CD Pipeline**
   - Create a Jenkins pipeline with the following stages:
     1. Clone Code from GitHub.
     2. Sonarqube quality analysis.
     3. OWASP Dependency Check.
     4. Sonar Quality Gate Scan.
     5. Trivy File System Scan.
     6. Deploy using Docker Compose.

## Usage

1. Clone the Wanderlust repository.

2. Set up AWS, Docker, and Jenkins as described in the project setup.

3. Run the CI/CD pipeline on Jenkins to build, test, and deploy the application.


## Author

Hardik Lokwani

