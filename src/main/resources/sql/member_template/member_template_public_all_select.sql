# 전체 공개된 템플릿을 조회한다.
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
WHERE visibility = 'public';
