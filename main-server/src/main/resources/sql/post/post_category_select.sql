# 카테고리 id를 통한 특정 게시글 조회

SELECT
    B.id,
    B.name,
    A.id,
    A.title,
    A.content,
    A.written_date,
    A.delete_date,
    A.visibility,
    A.member_id
FROM post A
         JOIN category B ON A.category_id
WHERE B.id = ?;