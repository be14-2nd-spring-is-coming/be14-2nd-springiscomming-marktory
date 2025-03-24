# 아이디 찾기
SELECT
       email
  FROM member
 WHERE name = ?
   AND birthday = ?;

# 비밀번호 찾기는 upadte에 걸리는 where 조건