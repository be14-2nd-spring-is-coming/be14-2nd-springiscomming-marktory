# 특정 회원의 게시글 전체 수정

UPDATE post
SET
    title = ?,
    content = ?,
    written_date = ?,
    delete_date = ?,
    visibility = ?,
    category_id = ?
WHERE
    id = ?
  AND member_id = ?;


# 특정 회원의 특정 컬럼(내용) 수정

UPDATE post
SET content = ?
WHERE id = ?;