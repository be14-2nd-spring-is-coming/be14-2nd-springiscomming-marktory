# 구독자 템플릿 조회
SELECT
    id
     , title
     , content
     , visibility
     , written_date
     , delete_date
     , usage_count
     , is_copy
     , repository_id
FROM member_template
WHERE visibility = 'subonly';