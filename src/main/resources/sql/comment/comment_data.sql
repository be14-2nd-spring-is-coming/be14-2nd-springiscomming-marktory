# 댓글
INSERT
     INTO comment
(
    content, written_date, modify_date, is_deleted, type, above_id, member_id, post_id
)
VALUES
-- 기본 댓글
('좋은 정보 감사합니다! 😊', '2024-03-10 20:37:39', NULL, FALSE, 1, NULL, 2, 1),
('여행 체크리스트 유용하네요!✈️', '2024-03-11 13:50:13', NULL, FALSE, 1, NULL, 3, 2),
('운동 루틴 공유해주셔서 감사합니다!💪', '2024-03-12 17:13:45', NULL, FALSE, 1, NULL, 4, 3),
('완전 못쓴다 ㅋㅋ', '2024-03-19', NULL, FALSE, 1, NULL, 3, 5),

-- 대댓글 (위 댓글에 대한 답변)
('진짜 ㅋㅋ 우웩', '2024-03-13 10:03:03', NULL, FALSE, 2, 1, 3, 1),
('풉 ㅋㅋ', '2024-03-14 02:29:19', NULL, FALSE, 2, 2, 4, 2),

-- 삭제된 댓글
('삭제된 댓글입니다.', '2024-03-15 08:22:35', '2025-03-16 07:31:38', TRUE, 1, NULL, 2, 3),

-- 수정된 댓글
('수정 전 댓글', '2024-03-17 10:15:09', '2025-03-18 15:46:38', FALSE, 1, NULL, 1, 1);
