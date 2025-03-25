# 특정 게시물 id로 삭제

UPDATE post
SET delete_date = NOW(), visibility = 'private'
WHERE id = ? AND delete_date IS NULL;
