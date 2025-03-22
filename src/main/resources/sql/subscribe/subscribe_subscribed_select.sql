# 구독 목록의 회원 정보 가져오기
SELECT
    member.id, email, name, image
FROM member
         JOIN subscribe ON (subscribe.subscribed_id = member.id)
WHERE subscriber_id = ?;
# -> member_id가 4,5 회원들 정보 조회