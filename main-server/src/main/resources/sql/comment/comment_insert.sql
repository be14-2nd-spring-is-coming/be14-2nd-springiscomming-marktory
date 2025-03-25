# 특정 게시물 댓글 등록

INSERT
  INTO comment (content, written_date, member_id, post_id)
VALUES (
        ?,
        NOW(),
        ?,
        ?
        );