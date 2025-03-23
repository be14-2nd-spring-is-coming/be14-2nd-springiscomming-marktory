# 알림 동의 여부 변경
UPDATE subscribe
    SET is_notification = ?
  WHERE id = ?;

# select * from subscribe; # 확인용