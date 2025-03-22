SELECT
    *
    FROM member
  WHERE id = 2;

# 닉네임 변경
UPDATE member
    SET nickname = '서준의박물관'
  WHERE id = 2;

# 비밀번호 변경
UPDATE member
    SET password = '123456789@@'
  WHERE id = 2;

# 프로필 이미지 변경
UPDATE member
    SET image = 'https://example.com/images/cute_dog.jpg'
  WHERE id = 2;