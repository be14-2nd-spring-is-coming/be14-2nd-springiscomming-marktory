# 구독자 템플릿 조회
SELECT
       mt.id
     , mt.title
     , mt.content
     , mt.visibility
     , mt.written_date
     , mt.delete_date
     , mt.usage_count
     , mt.is_copy
     , mt.repository_id
FROM member_template mt
JOIN member m ON m.id = mt.repository_id
WHERE visibility = 'subonly' AND m.id = ?;