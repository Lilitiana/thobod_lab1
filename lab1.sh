cd D:/Дляучёбы/4курс/БигДата/docker-hadoop-master
docker-compose up -d

cd D:/Дляучёбы/4курс/БигДата/lab1
mvn package

docker cp D:/Дляучёбы/4курс/БигДата/lab1/target/lab1-1.0-jar-with-dependencies.jar e74e62ba8bdb:/
docker cp D:/Дляучёбы/4курс/БигДата/1.txt e74e62ba8bdb:/
docker cp D:/Дляучёбы/4курс/БигДата/lab1_1.sh e74e62ba8bdb:/

docker exec -it e74e62ba8bdb bash lab1_1.sh
cd D:/Дляучёбы/4курс/БигДата/docker-hadoop-master
docker-compose stop
