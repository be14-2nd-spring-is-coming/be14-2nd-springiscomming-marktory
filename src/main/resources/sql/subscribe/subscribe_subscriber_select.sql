# 구독자 목록의 회원 정보 가져오기
SELECT
    member.id, email, name, image
FROM member
         JOIN subscribe ON (subscribe.subscriber_id = member.id)
WHERE subscribed_id = ?;
