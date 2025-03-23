# 특정 회원이 좋아요한 특정 게시물 좋아요 취소

DELETE FROM likes
WHERE member_id = ?
  AND (
    (post_id = ? AND comment_id IS NULL)
        OR
    (comment_id = ? AND post_id IS NULL)
    )
  AND type = ?;
