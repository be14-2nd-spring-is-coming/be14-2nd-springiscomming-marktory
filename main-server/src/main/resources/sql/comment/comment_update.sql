# 특정 댓글 수정

UPDATE comment
   SET content = ?
     , modify_date = NOW()
 WHERE id = ?;