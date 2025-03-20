# 회원
INSERT INTO member
( email, password, name, nickname, birthday, image, status, black_date, assigned_date, delete_date, report_count
, is_terms)
VALUES ( 'minseok.yoon@example.com', 'hashed_password_01', '윤민석', '민석의하루', '1995-04-23'
       , 'https://example.com/images/minseok.jpg', 'is_active', NULL, '2024-03-01', NULL, 0, TRUE)
     , ( 'jihye.kang@example.com', 'hashed_password_02', '강지혜', '지혜로운생활', '1998-09-17'
       , 'https://example.com/images/jihye.jpg', 'is_active', NULL, '2024-03-05', NULL, 1, TRUE)
     , ( 'dongwoo.park@example.com', 'hashed_password_03', '박동우', '동우의여행기', '1992-06-30', NULL, 'is_black', '2025-02-15'
       , '2023-12-20', NULL, 5, TRUE)
     , ( 'seoyoung.lee@example.com', 'hashed_password_04', '이서영', '서영의공방', '2000-11-11'
       , 'https://example.com/images/seoyoung.jpg', 'is_delete', NULL, '2023-05-10', '2024-01-20', 0, TRUE)
     , ( 'youngho.choi@example.com', 'hashed_password_05', '최영호', '코딩하는영호', '1997-03-14'
       , 'https://example.com/images/youngho.jpg', 'is_active', NULL, '2024-02-28', NULL, 0, TRUE)
     , ( 'soyeon.han@example.com', 'hashed_password_06', '한소연', '소연의책방', '1994-12-05', NULL, 'is_active', NULL
       , '2024-01-15', NULL, 2, TRUE)
     , ( 'junghoon.kim@example.com', 'hashed_password_07', '김정훈', '정훈의운동일기', '1990-07-19'
       , 'https://example.com/images/junghoon.jpg', 'is_black', '2025-01-30', '2023-08-05', NULL, 7, TRUE)
     , ( 'yuna.song@example.com', 'hashed_password_08', '송유나', '유나의하루', '1996-03-27', NULL, 'is_active', NULL
       , '2024-06-01', NULL, 0, TRUE)
     , ( 'seojun.oh@example.com', 'hashed_password_09', '오서준', '서준의사진관', '1999-05-10'
       , 'https://example.com/images/seojun.jpg', 'is_delete', NULL, '2023-07-15', '2024-02-10', 0, TRUE)
     , ( 'eunji.park@example.com', 'hashed_password_10', '박은지', '은지의요리노트', '2001-01-22', NULL, 'is_active', NULL
       , '2024-09-10', NULL, 1, TRUE);
