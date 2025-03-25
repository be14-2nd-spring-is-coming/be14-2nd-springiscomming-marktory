# 특정 회원이 자신의 모든 템플릿을 조회할 때 쿼리 (repository_id = member_id 이기 때문에 JOIN이 필요없음)
# 본인 id로만 조회할 수 있도록 보안관련 코드는 백엔드 처리

SELECT
       id,
       title,
       content,
       visibility,
       written_date,
       delete_date,
       usage_count,
       is_copy,
       repository_id
FROM member_template
WHERE repository_id IN (
    SELECT id FROM template_space WHERE member_id = ?
);