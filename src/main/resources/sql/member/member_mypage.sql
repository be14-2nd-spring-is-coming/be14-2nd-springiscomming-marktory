# 로그인 된 상태로, 마이페이지에 들어갔다고 했을 때
SELECT
       nickname
     , image
     , password
  FROM member
 WHERE id = ?;

# 로그인 된 상태로, 마이페이지에서 내가 작성한 게시글 확인
SELECT
       B.title
     , B.content
  FROM member A
         JOIN post B ON (A.id = B.member_id)
WHERE A.id = ?;

# 로그인 된 상태로, 마이페이지에서 내 템플릿 저장소 확인
SELECT
       C.title
     , C.content
  FROM member A
  JOIN template_space B ON (A.id = B.member_id)
  JOIN member_template C ON (B.id = C.repository_id)
 WHERE A.id = ?;

# 로그인 된 상태로, 마이페이지에서 내가 단 댓글 확인
SELECT
       A.nickname
     , B.content
     , B.written_date
  FROM member A
  JOIN comment B ON (A.id = B.member_id)
 WHERE A.id = ?;


# 내 모든 게시글에, 달린 댓글 한번에 확인
SELECT
  FROM member A
  JOIN post B ON (A.id = B.member_id)
