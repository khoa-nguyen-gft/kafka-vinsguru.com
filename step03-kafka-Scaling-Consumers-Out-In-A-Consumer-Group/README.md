


#Run the below command to produce the fat jar with all the dependencies for the spring boot producer application.
mvn clean package

#Then below command to create a docker image for this application.
docker build -t vinsdocker/kafka-producer .
docker build -t vinsdocker/kafka-consumer .

#The docker-compose will create 1 zookeeper, 3 kafka-brokers and 1 kafka manager. 
docker-compose up


#Once you have played with kafka cluster, you can bring entire cluster down by issuing below command
docker-compose down
