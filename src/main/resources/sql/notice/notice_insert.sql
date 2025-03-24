# 공지사항 작성
 select * from notice; # 확인용

# 공지사항 추가
INSERT
    INTO notice
(date, content, member_id)
VALUES
(
  NOW()
, '시스템 점검이 예정되어 있습니다. 점검 시간 동안 일부 기능이 제한될 수 있습니다.'
, 7
);
