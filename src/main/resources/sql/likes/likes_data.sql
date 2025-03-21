INSERT
    INTO likes
(type, post_id, comment_id, member_id)
VALUES
-- 게시글 좋아요
('post', 1, NULL, 2),  -- 파이썬 기초 문법 글 좋아요
('post', 2, NULL, 3),  -- 여행 체크리스트 글 좋아요
('post', 3, NULL,5),  -- 헬스 초보자 가이드 글 좋아요
('post', 4, NULL, 6),  -- Django vs FastAPI 비교 분석 글 좋아요
('post', 5, NULL, 3),  -- 서울 핫플 카페 추천 글 좋아요

-- 댓글 좋아요
('comment', NULL, 1, 4),  -- "좋은 정보 감사합니다!" 댓글 좋아요
('comment', NULL, 2, 2),  -- "여행 체크리스트 유용하네요!" 댓글 좋아요
('comment', NULL, 3,3),  -- "운동 루틴 공유 감사합니다!" 댓글 좋아요
('comment', NULL, 4, 6),  -- "정말 유익한 글이에요!" 댓글 좋아요
('comment', NULL, 5,2);  -- "여행 짐 싸는 팁도 있나요?" 댓글 좋아요