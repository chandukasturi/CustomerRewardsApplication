**CustomerRewardsApplication**

A retailer offers a rewards program to its customers awarding points based on each recorded purchase as follows:For every dollar spent over $50 on the transaction, the customer receives one point.In addition, for every dollar spent over $100, the customer receives another point.
Ex: for a $120 purchase, the customer receives
(120 - 50) x 1 + (120 - 100) x 1 = 90 points

Created a REST API Endpoint that calculates and returns the reward points.The applicaiton is built using Java, SpringBoot and H2 in-memory database

The package name is structured as com.reward.spring
Used H2 in-memory database as the backend storage.
Install H2 db locally and run it . change the db settings in application.properties file.
Do run the data.sql on H2 in memory DB to prepare the test data each time you run the application

The application runs on: http://localhost:8181/customer/{customerId}/rewards

