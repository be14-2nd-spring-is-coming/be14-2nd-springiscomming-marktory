# 닉네임 변경
UPDATE member
    SET nickname = ?
  WHERE id = ?;

# 비밀번호 변경
UPDATE member
    SET password = ?
  WHERE id = ?;

# 프로필 이미지 변경
UPDATE member
    SET image = ?
  WHERE id = ?;

# 한 번에 받기
UPDATE member
    SET nickname = ?,
        password = ?,
        image = ?
  WHERE id = ?;
# -> 동적 쿼리 필요