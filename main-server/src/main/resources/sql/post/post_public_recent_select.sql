# public 게시글 최신순 조회

SELECT * FROM post
WHERE visibility = 'public' AND delete_date IS NULL
ORDER BY written_date DESC;


