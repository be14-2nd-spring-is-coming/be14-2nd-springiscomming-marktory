cd eureka-server
#./gradlew build --refresh-dependencies
./gradlew build -x test
cd build/libs
java -jar eurekaserver-0.0.1-SNAPSHOT.jar
