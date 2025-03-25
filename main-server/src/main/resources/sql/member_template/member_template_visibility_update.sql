UPDATE member_template mt
JOIN member m ON m.id = mt.repository_id
SET mt.visibility = ?
WHERE m.id = ?;