cd main-server
#./gradlew build --refresh-dependencies
./gradlew build -x test
cd build/libs
java -jar marktory-0.0.2-SNAPSHOT.jar