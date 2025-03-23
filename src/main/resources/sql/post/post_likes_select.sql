# 특정 게시글의 좋아요 수 조회

SELECT
    b.post_id,
    COUNT(b.post_id) AS like_count
FROM likes b
WHERE b.post_id = ?;