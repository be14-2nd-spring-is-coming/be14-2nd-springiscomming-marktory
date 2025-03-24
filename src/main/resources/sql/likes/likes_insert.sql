# 특정 회원이 좋아요 누른 게시글에 좋아요 추가(중복 제거)

INSERT INTO likes (type, post_id, comment_id, member_id)
VALUES (?, ?, ?, ?)
ON DUPLICATE KEY UPDATE id = id;