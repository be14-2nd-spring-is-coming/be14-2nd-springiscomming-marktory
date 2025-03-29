cd gateway-server
#./gradlew build --refresh-dependencies
./gradlew build -x test
cd build/libs
#java -jar gatewayserver-0.0.1-SNAPSHOT.jar # 실제 배포시 활성화
java -Dspring.profiles.active=test -jar gatewayserver-0.0.1-SNAPSHOT.jar # 테스트용 실행 명령어