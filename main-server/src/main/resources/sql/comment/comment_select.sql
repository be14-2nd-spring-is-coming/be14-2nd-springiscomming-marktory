# 특정 게시물에 등록된 댓글 조회

SELECT
       c.id
     , c.content
     , c.written_date
     , c.modify_date
     , u.nickname
     , (SELECT
               COUNT(r.id)
          FROM comment r
         WHERE r.above_id = c.id AND r.type = 2 AND r.is_deleted = FALSE) AS reply_count
     , COUNT(l.id) AS likes_count
  FROM comment c
  JOIN member u ON c.member_id = u.id
  LEFT JOIN likes l ON c.id = l.comment_id AND l.type = 'comment'
 WHERE c.post_id = ? AND c.type = 1 AND c.is_deleted = FALSE
 GROUP BY c.id, c.content, c.written_date, c.modify_date, u.nickname
 ORDER BY c.written_date ASC;