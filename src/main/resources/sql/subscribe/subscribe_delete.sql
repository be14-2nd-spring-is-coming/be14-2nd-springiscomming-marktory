# 구독 취소
SELECT
    *
FROM subscribe
  WHERE subscriber_id=3;
# -> 현재 4,5,8

# 멤버 id가 8인 구독 목록에서 제거
DELETE
FROM subscribe
  WHERE subscriber_id=3 and subscribed_id=8;

SELECT
    *
FROM subscribe
  WHERE subscriber_id=3;
# -> 현재 4,5