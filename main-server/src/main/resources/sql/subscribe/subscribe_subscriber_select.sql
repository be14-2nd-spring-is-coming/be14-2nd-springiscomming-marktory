# 구독자 목록의 회원 정보 가져오기
SELECT
    m.id, email, nickname, image
FROM member m
         JOIN subscribe s ON (s.subscriber_id = m.id)
WHERE subscribed_id = ?;
