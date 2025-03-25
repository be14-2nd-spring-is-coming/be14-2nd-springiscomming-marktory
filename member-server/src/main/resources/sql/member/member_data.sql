INSERT
    INTO member
( email, password, name, nickname, birthday, image, status, black_date, assigned_date, delete_date, report_count, is_terms)
VALUES
( 'seoyoung.lee@example.com', '$2a$12$CktCkMNMe4f4DJjesDGqHuGVYS.XNqpO5auclxJvih/dLvhdNmfKe', '이서영', '서영의공방', '2000-11-11',
'https://example.com/images/seoyoung.jpg', 'is_delete', NULL, '2023-05-10 14:23:45', '2024-01-20 09:15:30', 0, TRUE),

( 'seojun.oh@example.com', '$2a$12$3ZTIPsuJTz71AvL/N3BWzueo7wei7p37.ousi8HAPJ6FSlUhEJwQa', '오서준', '서준의사진관', '1999-05-10',
'https://example.com/images/seojun.jpg', 'is_delete', NULL, '2023-07-15 16:40:20', '2024-02-10 11:05:50', 0, TRUE),

( 'junghoon.kim@example.com', '$2a$12$vXk6X1gKk/L0uZM33KqTUudlXAi/s3L1Lgg9hpq.ViLMENqgCGqw2', '김정훈', '정훈의운동일기', '1990-07-19',
'https://example.com/images/junghoon.jpg', 'is_black', '2025-01-30 18:20:10', '2023-08-05 10:30:00', NULL, 7, TRUE),

( 'dongwoo.park@example.com', '$2a$12$oNNlx0A3sY8cdw6cuV61fO//.J/EsRIuerdZPbGqHwZYRMn8nCQAq', '박동우', '동우의여행기', '1992-06-30', NULL,
'is_black', '2025-02-15 20:55:00', '2023-12-20 14:10:15', NULL, 5, TRUE),

( 'soyeon.han@example.com', '$2a$12$7cuVH4yicaE8gV8LOWVgLuXaOGTzsZPpFs3bfB8IAte8EehIR3/Y2', '한소연', '소연의책방', '1994-12-05', NULL,
'is_active', NULL, '2024-01-15 08:45:30', NULL, 2, TRUE),

( 'youngho.choi@example.com', '$2a$12$cPV.qW.ewHOgySTjmZaim.GrI8N3sbOW06qixaPZHveW.oOkWMoUO', '최영호', '코딩하는영호', '1997-03-14',
'https://example.com/images/youngho.jpg', 'is_active', NULL, '2024-02-28 12:05:25', NULL, 0, TRUE),

( 'minseok.yoon@example.com', '$2a$12$ycwMZRMquJ5B3TGRe2T8juFhn2JS.IU8rCpBTFF0E5ywslXW/H76G', '윤민석', '민석의하루', '1995-04-23',
'https://example.com/images/minseok.jpg', 'is_active', NULL, '2024-03-01 21:15:40', NULL, 0, TRUE),

( 'jihye.kang@example.com', '$2a$12$rwsbi/0RpvJeUV/BdfIl3e9Iew2PrYdmNY.cq3Hq5VnPzZEC5444.', '강지혜', '지혜로운생활', '1998-09-17',
'https://example.com/images/jihye.jpg', 'is_active', NULL, '2024-03-05 17:35:55', NULL, 1, TRUE),

( 'yuna.song@example.com', '$2a$12$iEtxFB1k28fHfJO7tbAQ9uwuYm74sKYZzuqMePaEF1id9nLYIJm66', '송유나', '유나의하루', '1996-03-27', NULL,
'is_active', NULL, '2024-06-01 13:50:10', NULL, 0, TRUE),

( 'eunji.park@example.com', '$2a$12$Z.3Eytnkw4VkcAWk.9xH4uljNb9VVwjHs7RdWMPPJvUhnLlU4ru32', '박은지', '은지의요리노트', '2001-01-22', NULL,
'is_active', NULL, '2024-09-10 07:25:45', NULL, 1, TRUE);