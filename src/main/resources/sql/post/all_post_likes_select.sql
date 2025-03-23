# 전체 게시글 좋아요순 조회

SELECT
    a.id AS post_id,
    a.title,
    a.content,
    a.written_date,
    a.delete_date,
    a.visibility,
    COUNT(b.post_id) AS like_count
FROM post a
         LEFT JOIN likes b ON a.id = b.post_id
GROUP BY a.id, a.title, a.content, a.written_date, a.delete_date, a.visibility;