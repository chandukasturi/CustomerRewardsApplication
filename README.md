# CustomerRewardsApplication

A retailer offers a rewards program to its customers awarding points based on each recorded purchase as follows:For every dollar spent over $50 on the transaction, the customer receives one point.In addition, for every dollar spent over $100, the customer receives another point.
Ex: for a $120 purchase, the customer receives
(120 - 50) x 1 + (120 - 100) x 1 = 90 points

Created a REST API Endpoint that calculates and returns the reward points.The applicaiton is built using Java, SpringBoot and H2 in-memory database

The package name is structured as com.reward.spring
The Project uses Java 17 and H2 in-memory database as the backend storage.
Install H2 db locally and run it . change the db settings in application.properties file.
Do run the data.sql on H2 in memory DB to prepare the test data each time you run the application

The application runs on: http://localhost:8181/customer/{customerId}/rewards

## Instructions to Clone the package and run it locally.
1.	Clone the Java project from GitHub.
2.	Set up the Java SDK under Project Settings.
3.	Install Gradle: If you haven't already installed Gradle, download and install it from the official website: https://gradle.org/install/.
4.	Build Project: 
..1.	Navigate to the project directory and Build the project using the command: ```gradle build```
..2.	This will compile the Java source files, run any tests, and package the project into a JAR file.
5.	Run the Project using: ```java -jar build/libs/CustomerRewardsApplication.jar```
6.	Check for the application.properties file in resources folder for H2 database credentials and the port the application is running on.
7.	The application runs on the url: http://localhost:8181/customer/{customerId}/rewards

![2](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/b8c20dc6-72da-4ecc-9c8c-37c648dbc4d3)

## Running Unit Tests Locally

Run the test cases using the command: ```gradle test``` . You can also use ```./gradlew test``` command if you do not have gradle installed in your local machine..

## Actuator Health Check
The application has spring actuator enabled to let you monitor and interact with your application: http://localhost:8181/actuator. There is a health check endpoint (http://localhost:8181/actuator/health) for the H2 database connection which checks on a sample query. Because H2 is an in-memory database it will report the connection to be “DOWN” initially.

![4](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/ecc3dbeb-1c27-4fbc-9881-aff5e935a5e0)

Run the data.sql script in the h2-console to generate the data (http://localhost:8181/h2). The status for the “h2DatabaseHealthCheck” will change to “UP” and running.

![5](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/72786969-30ca-48d5-b27f-60fc0d83de01)

Depending on the data added in the H2 database query the REST endpoint using (http://localhost:8181/customer/{customerId}/rewards)

![6](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/4fc5bab2-99f2-435f-8e44-d53a127819bd)




