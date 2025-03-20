# 신고별 구분
INSERT INTO report_type (report_id, comment_id, post_id, template_id) VALUES
                                                                           -- 게시글 신고
(1, NULL, 2, NULL),  -- report_id 1: 여행 체크리스트 게시글 신고
(2, NULL, 4, NULL),  -- report_id 2: Django vs FastAPI 비교 게시글 신고

                                                                           -- 댓글 신고
(3, 1, NULL, NULL),  -- report_id 3: "좋은 정보 감사합니다!" 댓글 신고
(4, 3, NULL, NULL),  -- report_id 4: "운동 루틴 공유 감사합니다!" 댓글 신고

                                                                           -- 템플릿 신고
(5, NULL, NULL, 1),  -- report_id 5: 템플릿 ID 1 신고
(6, NULL, NULL, 2),  -- report_id 6: 템플릿 ID 2 신고

                                                                           -- 혼합 신고 (게시글 & 댓글 둘 다 포함)
(7, 2, 5, NULL);  -- report_id 7: "여행 체크리스트 유용하네요!" 댓글 + 서울 핫플 카페 추천 게시글 신고