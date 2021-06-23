


#The docker-compose will create 1 zookeeper, 3 kafka-brokers and 1 kafka manager. 
docker-compose -f kafka-compose.yml up
docker-compose -f postgres-mongo-compose up


#Once you have played with kafka cluster, you can bring entire cluster down by issuing below command
docker-compose -f postgres-mongo-compose down -v


#Create database in postgres products.
./products.sql


#Create database in postgres customers.
./users.sql
