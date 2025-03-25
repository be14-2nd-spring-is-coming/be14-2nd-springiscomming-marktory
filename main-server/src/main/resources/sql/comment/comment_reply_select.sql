# 특정 댓글에 등록된 대댓글 조회

SELECT
       c.id
     , c.content
     , c.written_date
     , c.modify_date
     , u.nickname
     , COUNT(l.id) AS likes_count
  FROM comment c
  JOIN member u ON c.member_id = u.id
  LEFT JOIN likes l ON c.id = l.comment_id AND l.type = 'comment'
 WHERE c.above_id = ? AND c.type = 2 AND c.is_deleted = FALSE
 GROUP BY c.id, c.content, c.written_date, c.modify_date, u.nickname
 ORDER BY c.written_date ASC;