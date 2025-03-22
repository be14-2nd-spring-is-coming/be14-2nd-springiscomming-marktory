# 구독 추가
SELECT
    *
    FROM subscribe
  WHERE subscriber_id=3;
# -> 현재 4,5

# 멤버 id가 3인 회원이 8인 회원을 구독
INSERT
    INTO subscribe
(is_notification, subscriber_id, subscribed_id)
VALUES
(
  'Y'
, 3
, 8
);
# -> 4,5,8