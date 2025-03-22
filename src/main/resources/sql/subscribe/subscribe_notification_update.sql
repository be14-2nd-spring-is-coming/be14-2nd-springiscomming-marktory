# 알림 동의 여부 변경
UPDATE subscribe
    SET is_notification = 'N'
  WHERE id = 3;

# select * from subscribe; # 확인용