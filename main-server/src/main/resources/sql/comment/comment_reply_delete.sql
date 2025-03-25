# 특정 대댓글 삭제

UPDATE comment
   SET is_deleted = TRUE
 WHERE id = ? AND type = 2;