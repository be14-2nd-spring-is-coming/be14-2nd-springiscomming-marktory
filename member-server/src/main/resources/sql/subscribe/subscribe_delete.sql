# 구독 취소
# 구독 목록에서 제거
DELETE
FROM subscribe
  WHERE subscriber_id=? and subscribed_id=?;

