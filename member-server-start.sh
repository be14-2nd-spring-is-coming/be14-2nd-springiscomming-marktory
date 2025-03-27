cd member-server
#./gradlew build --refresh-dependencies
./gradlew build -x test
cd build/libs
java -jar marktory-0.0.1-SNAPSHOT.jar