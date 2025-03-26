# 특정 대댓글 수정

UPDATE comment
   SET content = ?
     , modify_date = NOW()
 WHERE id = ? AND type = 2;