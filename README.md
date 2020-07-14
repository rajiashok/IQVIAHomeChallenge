# IQVIAHomeChallenge

##Problem description:
     Write a RESTful web service that schedules messages to be printed. The web service should accept a message content and delivery time. The
     web service should return 202 status code (accepted) if the message was successfully scheduled. The web service should print the message
     content on the console at the delivery time specified. The system should recover and messages should not be lost in case of restart.

##Steps for running the code locally:

  ###Set Up Active MQ:
    1. In this project in order not to lose the messages while restarting the java Application, Apache active MQ is being used. 
       Hence, active MQ is required to be downloaded locally from the below mentioned website:
        https://activemq.apache.org/components/classic/download/
    2. To start the active MQ locally, open the command promt and open the bin path of the downloaded activeMQ and run the command .\activemq start
    3. Open http://localhost:8161/admin/queues.jsp in your browser.
    4. Under the Queues tab, create a queue with name "MessageQueue".
  
  ###To run the code locally, IDE such as eclipse or STS can be used:
    1. Checkout the project from the GIT hub repository in your local.
    2. Open the IDE and import the project as existing maven project.
    3. Right click on the imported project IQVIA and run as Spring boot application.
    4. The spring boot application gets started and is ready to consume API calls.
  
  ###API Testing:
    1. API can be tested using postman.
    2. Create a post request in postman with the following API request
        http://localhost:8080/message/pushv2
    3. For the request body the belo sample could be used. Raw data radio button has ti be enabled with type as JSON. 
        {
            "message":"Welcome to IQVIA Application",
            "scheduledTime":"13-07-2020 17:48:52"
         }
    4. The scheduled Time format is expected to be same as mentioned above
  
  
