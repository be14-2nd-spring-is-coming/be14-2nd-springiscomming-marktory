cd main-server
#./gradlew build --refresh-dependencies
./gradlew build -x test
cd build/libs
#java -jar marktory-0.0.2-SNAPSHOT.jar # 실제 배포시 활성화
java -Dspring.profiles.active=test -jar marktory-0.0.2-SNAPSHOT.jar # 테스트용 실행 명령어

# 테스트용 실행을 한다면 추가적으로 main-server yml에서 아래의 코드 주석 처리 필요
#token:
#  expiration_time: 43200000
#  secret: u7uSfjpMtBgE9vQJg6N95arlkv8pv1yjitGOlM0bI9wKMxVeaCflPsysAPS1768PpW1RuOcpMxI3yB4WCQw77Q==