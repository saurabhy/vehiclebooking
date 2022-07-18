# vehiclebooking
Vehicle rental booking project


Instructions for the code base : 

Code is written using spring boot framework which requires gradle 6.8 or above and It will not run on Gradle version lower than 6.8.

To create a build : 
  Use : ./gradlew build
  To Run test cases : ./gradlew clean test


This Submission is a spring boot application with following api signature : 

curl -X POST \
  http://localhost:8080/vehiclebooking/process \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 1d9392bb-1ddc-b34d-b35a-6c43a1f0e97d' \
  -d '{
  "filePath": "D:\\work\\vehiclebooking\\src\\main\\resources\\static\\input1"
}'

Response : 200 Ok
For Each instruction output is printed accordingly in console please check console for that.

"filePath" : this takes a file path containing a file(*.txt) having input instructions.

Sample input file is present in location "src\main\resources\static\input1"

Unit Tests: Unit tests are written for sections where logic is implemented.(src/test/java/com/practice/vehiclebooking)

Assumptions: 
Bookings can be made in multiple of Hours Ranging from [1,24].

Note: 
As it is an application, If you want to run two input text files INDEPENDENT of each other Please restart the application on every run.
