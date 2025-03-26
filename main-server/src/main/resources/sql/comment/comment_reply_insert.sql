# 특정 댓글 대댓글 등록

INSERT
  INTO comment (content, written_date, member_id, post_id, above_id, type)
VALUES (
        ?,
        NOW(),
        ?,
        ?,
        ?,
        ?
        );