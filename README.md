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
1.	Click on the Code dropdown menu in the repository and download the zip file to your local machine.
2.	Extract the zip file in your machine and open the project with text editor of your choice (IntelliJ is preferred).

![1](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/b18ae92e-a5f4-42c9-b491-240f170099ec)

3.	The project is built with Gradle so make sure you have Gradle installed in your machine and load the scripts in your IDE to build the application.
4.	Build the Gradle project in your local machine.
5.	Set up the Project Run configuration using Java 17 SDK.
6.	Check for the application.properties file in resources folder for H2 database credentials and the port the application is running on.

![2](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/b8c20dc6-72da-4ecc-9c8c-37c648dbc4d3)

7.  After verifying the port and H2 database credentials. Run the “gradle test” command to run all the test cases in the application.

![3](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/506d40ba-38fe-469f-9def-c5e3891a3ac3)

8.	After all test cases are passed. Run the application with respective configuration in your IDE using “gradle bootRun” command
9.	The application runs on the url: http://localhost:8181/customer/{customerId}/rewards
10.	The application has spring actuator enabled to let you monitor and interact with your application: http://localhost:8181/actuator
11.	There is a health check (http://localhost:8181/actuator/health) for the H2 database connection which checks on a sample query. Because H2 is an in-memory database it will report the connection to be “DOWN” initially.

![4](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/ecc3dbeb-1c27-4fbc-9881-aff5e935a5e0)

12.	Run the data.sql script in the h2-console to generate the data (http://localhost:8181/h2)
13.	The status for the “h2DatabaseHealthCheck” will change to “UP” and running.

![5](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/72786969-30ca-48d5-b27f-60fc0d83de01)

14.	Depending on the data added in the H2 database query the REST endpoint using (http://localhost:8181/customer/{customerId}/rewards)

![6](https://github.com/chandukasturi/CustomerRewardsApplication/assets/79279925/4fc5bab2-99f2-435f-8e44-d53a127819bd)




