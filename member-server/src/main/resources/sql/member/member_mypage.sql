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
     , A.nickname
     , B.content
  FROM member A
         JOIN post B ON (A.id = B.member_id)
WHERE A.id = ?;

# 로그인 된 상태로, 마이페이지에서 내 템플릿 저장소 확인
SELECT
       A.nickname
     , C.title
     , C.content
     , C.visibility
     , C.is_copy
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
       D.nickname
     , C.content AS comment_content
     , B.title AS post_title
     , B.id AS post_id
  FROM member A
  JOIN post B ON A.id = B.member_id
  JOIN comment C ON B.id = C.post_id
  JOIN member D ON C.member_id = D.id  -- 댓글 단 사람: D
 WHERE A.id = ?;