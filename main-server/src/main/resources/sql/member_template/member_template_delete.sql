# 회원이 자신에게 속해 있는 템플릿을 삭제 한다.
UPDATE member_template mt
    JOIN template_space ts ON mt.repository_id = ts.id
SET mt.delete_date = '2025-03-22'
WHERE ts.member_id = 1 AND mt.id = ?;