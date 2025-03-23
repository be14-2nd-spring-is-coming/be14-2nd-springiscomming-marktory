# 기존 게시글 id를 통한 공개범위 설정 변경

UPDATE post
SET visibility = 'private'
WHERE id = 11;