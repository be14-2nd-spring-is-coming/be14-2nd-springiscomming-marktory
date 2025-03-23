# 해시태그 id를 통한 특정 게시글 조회

SELECT
    B.hashtag_id,
    C.name,
    A.id,
    A.title,
    A.content,
    A.written_date,
    A.delete_date,
    A.visibility,
    A.member_id
FROM post A
         JOIN post_hashtag B ON A.id = B.post_id
         JOIN hashtag C ON C.id = B.hashtag_id
WHERE hashtag_id = ?;