# verve-zhongli
Homework for Verve Application

# Quick Start
## Basic Requirement
1. download jar file from GitHub release page
2. run jar with JDK17+ using following command 
```shell
java -jar build/libs/verve-zhongli-0.0.1-SNAPSHOT.jar
```
3. test api using following command
```shell
curl 'http://localhost:8080/api/verve/accept?id=1&&endpoint=icanhazip.com'
```

## Extension 1
run jar using following command
```shell
java -jar build/libs/verve-zhongli-1.0.0.jar --spring.profiles.active=extension-1
```

## Extension 2
WARNING: extension 2 need docker running in the background

run jar using following command
```shell
java -jar build/libs/verve-zhongli-1.0.0.jar --spring.profiles.active=extension-2
```

## Extension 3
WARNING: extension 3 need docker running in the background
 
run jar using following command
```shell
java -jar build/libs/verve-zhongli-1.0.0.jar --spring.profiles.active=extension-3
```

checkout kafka message in the pod terminal using following command
```shell
./opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic verve-id-count-topic --from-beginning
```