# springboot-dynamodb
Spring Boot with DynamoDB Integration


Build and Execustion Steps:
--------------------------

Step 1) Provide your AWS Credentials and Region details in resource properties  file

Step 2) Download and execute mvn clean install

Step 3) Configure AWS CLI

Step 4) Run the below dynamodb script in aws cli <change if your region is different>
      aws dynamodb create-table --table-name Person --attribute-definitions AttributeName=Id,AttributeType=S --key-schema AttributeName=Id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 --endpoint-url https://dynamodb.eu-central-1.amazonaws.com
  
step 5) Run API; http://localhost:8080/save

step 6) Run API; http://localhost:8080/findall

and keep rock.....
