# 해시태그를 통한 특정 게시글 조회

SELECT p.id, p.title, p.content, p.written_date, p.visibility, p.member_id, p.category_id
FROM post p
         JOIN post_hashtag ph ON p.id = ph.post_id
         JOIN hashtag h ON ph.hashtag_id = h.id
WHERE h.name = ? #{hashtagName}
ORDER BY p.written_date DESC;
