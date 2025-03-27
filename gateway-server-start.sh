cd gateway-server
#./gradlew build --refresh-dependencies
./gradlew build -x test
cd build/libs
java -jar gatewayserver-0.0.1-SNAPSHOT.jar