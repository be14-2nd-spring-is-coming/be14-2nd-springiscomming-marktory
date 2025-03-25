# ---------------------------------------------------- 테이블 삭제 ------------------------------------
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS likes;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS post_hashtag;
DROP TABLE IF EXISTS report;
DROP TABLE IF EXISTS report_type;

DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS member_template;
DROP TABLE IF EXISTS public_template;

DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS hashtag;

DROP TABLE IF EXISTS subscribe;
DROP TABLE IF EXISTS member_profile_image;
DROP TABLE IF EXISTS notice;

DROP TABLE IF EXISTS member_roles;
DROP TABLE IF EXISTS authority;

DROP TABLE IF EXISTS template_space;
DROP TABLE IF EXISTS email_token;

DROP TABLE IF EXISTS member;
SET FOREIGN_KEY_CHECKS = 1;
# ---------------------------------------------------- 테이블 생성 ------------------------------------

CREATE TABLE member (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        email VARCHAR(255) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        name VARCHAR(255) NOT NULL,
                        nickname VARCHAR(255) NOT NULL,
                        birthday VARCHAR(255) NOT NULL,
                        image VARCHAR(255),
                        status VARCHAR(255) NOT NULL DEFAULT 'is_active',
                        black_date VARCHAR(255),
                        assigned_date VARCHAR(255) NOT NULL,
                        delete_date VARCHAR(255),
                        report_count INT DEFAULT 0,
                        is_terms BOOLEAN NOT NULL DEFAULT FALSE,
                        UNIQUE(email),
                        UNIQUE(nickname),
                        CHECK ( status in ('is_active', 'is_delete', 'is_black') )
) ENGINE = INNODB;

CREATE TABLE subscribe (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           is_notification CHAR NOT NULL,
                           subscriber_id BIGINT,
                           subscribed_id BIGINT,
                           CHECK ( is_notification in ('Y', 'N') ),
                           CONSTRAINT FOREIGN KEY (subscriber_id) REFERENCES member(id),
                           CONSTRAINT FOREIGN KEY (subscribed_id) REFERENCES member(id),
                           UNIQUE(subscriber_id, subscribed_id)
) ENGINE = INNODB;

CREATE TABLE member_profile_image (
                                      member_id BIGINT PRIMARY KEY,
                                      URL VARCHAR(255),
                                      CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;

CREATE TABLE notice (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        date VARCHAR(255) NOT NULL,
                        content VARCHAR(255) NOT NULL,
                        member_id BIGINT,
                        CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;

CREATE TABLE authority (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           name varchar(255) NOT NULL
) ENGINE = INNODB;

CREATE TABLE member_roles(
                             member_id BIGINT PRIMARY KEY,
                             authority_id BIGINT,
                             CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id),
                             CONSTRAINT FOREIGN KEY (authority_id) REFERENCES authority(id)
) ENGINE = INNODB;

CREATE TABLE category (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          member_id BIGINT,
                          CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;

CREATE TABLE template_space(
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               member_id BIGINT NOT NULL,
                               CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id)
) ENGINE = INNODB;

CREATE TABLE public_template (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 title VARCHAR(255) NOT NULL,
                                 content LONGTEXT NOT NULL,
                                 written_date VARCHAR(255) NOT NULL,
                                 delete_date VARCHAR(255),
                                 usage_count INT NOT NULL DEFAULT 0,
                                 writer_id BIGINT NOT NULL
) ENGINE = INNODB;

CREATE TABLE member_template(
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                title VARCHAR(255) NOT NULL,
                                content LONGTEXT NOT NULL,
                                visibility VARCHAR(255) NOT NULL DEFAULT 'public',
                                written_date VARCHAR(255) NOT NULL,
                                delete_date VARCHAR(255),
                                usage_count INT NOT NULL DEFAULT 0,
                                is_copy CHAR NOT NULL DEFAULT 'N',
                                repository_id BIGINT,
                                CONSTRAINT FOREIGN KEY (repository_id) REFERENCES template_space(id),
                                CHECK ( visibility IN ('public','private','subonly') ),
                                CHECK ( is_copy IN ('Y','N'))
) ENGINE = INNODB;

CREATE TABLE post (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      title VARCHAR(255) NOT NULL,
                      content LONGTEXT NOT NULL,
                      written_date VARCHAR(255) NOT NULL,
                      delete_date VARCHAR(255),
                      visibility VARCHAR(255) NOT NULL DEFAULT 'public',
                      member_id BIGINT,
                      category_id BIGINT,
                      CHECK ( visibility IN ('public', 'private', 'subonly')),
                      CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id),
                      CONSTRAINT FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE SET NULL
) ENGINE = INNODB;

CREATE TABLE hashtag (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL
) ENGINE = INNODB;

CREATE TABLE post_hashtag (
                              post_id BIGINT NOT NULL,
                              hashtag_id BIGINT NOT NULL,
                              CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
                              CONSTRAINT FOREIGN KEY (hashtag_id) REFERENCES hashtag(id)

) ENGINE = INNODB;


CREATE TABLE comment
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    content      VARCHAR(255) NOT NULL,
    written_date VARCHAR(255) NOT NULL,
    modify_date  VARCHAR(255),
    is_deleted   BOOLEAN NOT NULL DEFAULT false,
    type         INT NOT NULL DEFAULT 1,
    above_id     BIGINT,
    member_id      BIGINT,
    post_id      BIGINT,
    CHECK ( type IN (1, 2) ),
    CONSTRAINT FOREIGN KEY (member_id) REFERENCES member (id)
) ENGINE = INNODB;

CREATE TABLE likes (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       type VARCHAR(255) NOT NULL,
                       post_id BIGINT,
                       comment_id BIGINT,
                       member_id BIGINT NOT NULL,
                       CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
                       CONSTRAINT FOREIGN KEY (comment_id) REFERENCES comment(id),
                       CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id),
                       UNIQUE (member_id, post_id, type),
                       UNIQUE (member_id, comment_id, type)
) ENGINE = INNODB;

#신고
CREATE TABLE report (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        content VARCHAR(255) NOT NULL,
                        status BOOLEAN NOT NULL DEFAULT FALSE,
                        date VARCHAR(255) NOT NULL,
                        type VARCHAR(255) NOT NULL,
                        member_id BIGINT NOT NULL,
                        comment_id BIGINT,
                        post_id BIGINT,
                        template_id BIGINT,
                        CONSTRAINT FOREIGN KEY (member_id) REFERENCES member(id),
                        CHECK ( type in ('comment','post','template') ),
                        CONSTRAINT FOREIGN KEY (comment_id) REFERENCES comment(id),
                        CONSTRAINT FOREIGN KEY (post_id) REFERENCES post(id),
                        CONSTRAINT FOREIGN KEY (template_id) REFERENCES member_template(id)

) ENGINE = INNODB;

# 이메일 토큰 테이블 추가
CREATE TABLE email_token (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        email VARCHAR(255) NOT NULL,
                        token VARCHAR(255) NOT NULL,
                        expiration_time DATETIME,
                        is_verified BOOLEAN,
                        UNIQUE(email)
) ENGINE = INNODB;

# ---------------------------------------------------- 더미 데이터 생성 ------------------------------------

# 회원
INSERT
INTO member
( email, password, name, nickname, birthday, image, status, black_date, assigned_date, delete_date, report_count, is_terms)
VALUES
    ( 'seoyoung.lee@example.com', '$2a$12$qRN4y0dTIAyPnLdFzTAIXOnD5HDFXjrXo7MKgzz2YNyss2FjDLbyq', '이서영', '서영의공방', '2000-11-11',
      'https://example.com/images/seoyoung.jpg', 'is_delete', NULL, '2023-05-10 14:23:45', '2024-01-20 09:15:30', 0, TRUE),

    ( 'seojun.oh@example.com', '$2a$12$T5pZVvXEKxkThFQZN2dUlucO2cQsiR9AL5pJyjeHGgJ6snfr9dADm', '오서준', '서준의사진관', '1999-05-10',
      'https://example.com/images/seojun.jpg', 'is_delete', NULL, '2023-07-15 16:40:20', '2024-02-10 11:05:50', 0, TRUE),

    ( 'junghoon.kim@example.com', '$2a$12$KWtci/1Bld/V8ypHElWUs.1N6Lb/ucrHtx4reKN5.wuHI7krmcvRW', '김정훈', '정훈의운동일기', '1990-07-19',
      'https://example.com/images/junghoon.jpg', 'is_black', '2025-01-30 18:20:10', '2023-08-05 10:30:00', NULL, 7, TRUE),

    ( 'dongwoo.park@example.com', '$2a$12$1Fu6TYRaaic64HOEqdkAmeFLtNBiAhOGSXNUU50jFtJmMu7x1YvvK', '박동우', '동우의여행기', '1992-06-30', NULL,
      'is_black', '2025-02-15 20:55:00', '2023-12-20 14:10:15', NULL, 5, TRUE),

    ( 'soyeon.han@example.com', '$2a$12$FGghs0HHU8Fk2y0BzhBtVuUv3akzXe1dJEqrwnp.Bp.Fns7MIOz9O', '한소연', '소연의책방', '1994-12-05', NULL,
      'is_active', NULL, '2024-01-15 08:45:30', NULL, 2, TRUE),

    ( 'youngho.choi@example.com', '$2a$12$BGPLRrCaZPryrCDD01SehuEP444AoEtZgGJhh40.kdchPMLXLZqyK', '최영호', '코딩하는영호', '1997-03-14',
      'https://example.com/images/youngho.jpg', 'is_active', NULL, '2024-02-28 12:05:25', NULL, 0, TRUE),

    ( 'minseok.yoon@example.com', '$2a$12$DEoGO.i/553jJ./MNZvVweHDeJchnPCt0Ej1Ok8PRmY0NfIUCNmlC', '윤민석', '민석의하루', '1995-04-23',
      'https://example.com/images/minseok.jpg', 'is_active', NULL, '2024-03-01 21:15:40', NULL, 0, TRUE),

    ( 'jihye.kang@example.com', '$2a$12$/L686p7Jumg4c6bq3mdpJ.MBLSTNwcfCMxGCMLAh79XXw0536Itw2', '강지혜', '지혜로운생활', '1998-09-17',
      'https://example.com/images/jihye.jpg', 'is_active', NULL, '2024-03-05 17:35:55', NULL, 1, TRUE),

    ( 'yuna.song@example.com', '$2a$12$y9QXgAPTj8hv9/8op0BjHO1g/QmhDkOUDpC6UZm9UkqNEXqnS9uWW', '송유나', '유나의하루', '1996-03-27', NULL,
      'is_active', NULL, '2024-06-01 13:50:10', NULL, 0, TRUE),

    ( 'eunji.park@example.com', '$2a$12$aANRQsJobsfAd6YbfmO4vuce32R8/ewTk8ig9Tvdn7n6NejjEf7pe', '박은지', '은지의요리노트', '2001-01-22', NULL,
      'is_active', NULL, '2024-09-10 07:25:45', NULL, 1, TRUE);

# 카테고리
INSERT
INTO category
(id, name, member_id)
VALUES
    (1, '개발 & 프로그래밍', 1),
    (2, '여행 & 맛집', 2),
    (3, '건강 & 운동', 3),
    (4, '일상 & 자유게시판', 4);

# 권한
INSERT
INTO authority
(id, name)
VALUES
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_MEMBER');

# 게시글
INSERT
INTO post
(title, content, written_date, delete_date, visibility, member_id, category_id)
VALUES
( '파이썬 기초 문법 정리'
, '<h1>🐍 파이썬 기초 문법</h1><h2>1. 변수 선언</h2><pre><code class="language-python">x = 10\ny = "hello"</code></pre><p>변수는 위와 같이 선언할 수 있습니다.</p><p><img src="https://example.com/images/python-logo.png" alt="파이썬 로고"></p>'
, '2024-03-01 00:30:52', NULL, 'public', 1, 1)
     , ( '여행 준비 체크리스트 ✈️'
       , '<h1>✈️ 여행 준비 체크리스트</h1><p>여행을 떠나기 전, 다음 리스트를 꼭 확인하세요!</p><ul><li><input type="checkbox" checked disabled> 여권 챙기기</li><li><input type="checkbox" checked disabled> 항공권 예매 확인</li><li><input type="checkbox" checked disabled> 호텔 예약 완료</li></ul><p><img src="https://example.com/images/travel-checklist.jpg" alt="여행 이미지"></p>'
       , '2024-03-02 06:36:42', NULL, 'public', 2, 2)
     , ( '초보자를 위한 헬스 가이드 💪'
       , '<h1>💪 헬스 초보자 가이드</h1><h2>1. 운동 루틴</h2><pre><code>월: 가슴 + 삼두\n화: 등 + 이두\n수: 하체</code></pre><h3>2. 기본적인 식단</h3><ul><li>단백질 섭취 증가</li><li>탄수화물 적절히 조절</li></ul><p><img src="https://example.com/images/fitness-guide.jpg" alt="운동 이미지"></p>'
       , '2024-03-03 03:36:26', NULL, 'public', 3, 3)
     , ( 'Django vs FastAPI 비교 분석 🆚'
       , '<h1>🆚 Django vs FastAPI</h1><table><thead><tr><th>프레임워크</th><th>속도</th><th>유연성</th><th>커뮤니티</th></tr></thead><tbody><tr><td>Django</td><td>중간</td><td>낮음</td><td>큼</td></tr><tr><td>FastAPI</td><td>빠름</td><td>높음</td><td>작음</td></tr></tbody></table><p>Django와 FastAPI의 차이점을 비교하고 장단점을 분석해보았습니다.</p><p><img src="https://example.com/images/django-fastapi.jpg" alt="Django vs FastAPI"></p>'
       , '2024-03-04 02:37:54', NULL, 'public', 1, 1)
     , ( '서울 핫플 카페 추천 ☕'
       , '<h1>☕ 서울 핫플 카페 추천</h1><p>요즘 뜨는 감성 카페를 소개합니다!</p><ol><li><strong>블루보틀 성수</strong> - 미니멀한 인테리어와 퀄리티 높은 커피 ☕</li><li><strong>펠트 커피</strong> - 직접 로스팅한 원두의 깊은 맛</li></ol><p><img src="https://example.com/images/seoul-cafes.jpg" alt="카페 이미지"></p>'
       , '2024-03-05 19:13:27', NULL, 'public', 2, 2)
     , ( '운동 루틴 공유 (삭제됨)'
       , '<h1>🏋️ 운동 루틴 공유</h1><h3>저의 개인 운동 루틴</h3><pre><code>월: 가슴, 삼두\n화: 등, 이두\n수: 하체\n목: 어깨\n금: 코어</code></pre><p>운동을 함께 해봐요! 💪</p><p><img src="https://example.com/images/workout.jpg" alt="운동 이미지"></p>'
       , '2024-03-06 01:29:03', '2025-03-10 10:29:44', 'public', 3, 3)
     , ( '개발자 포트폴리오 만들기 📁'
       , '<h1>📁 개발자 포트폴리오 가이드</h1><h2>1. 필수 포함 항목</h2><ul><li>프로젝트 소개</li><li>기술 스택</li><li>경험 및 성과</li></ul><p><strong>Tip</strong>: 깃허브 링크와 블로그를 포함하면 좋아요! 👍</p><p><img src="https://example.com/images/portfolio-guide.jpg" alt="포트폴리오 예시"></p>'
       , '2024-03-07 09:25:42', NULL, 'private', 1, 1)
     , ( '부산 맛집 투어 🍜'
       , '<h1>🍜 부산 맛집 투어</h1><p>부산에서 꼭 가봐야 할 맛집 리스트!</p><ul><li>📌 <strong>돼지국밥</strong> - 삼진국밥</li><li>📌 <strong>밀면</strong> - 할매밀면</li><li>📌 <strong>회</strong> - 자갈치시장</li></ul><p><img src="https://example.com/images/busan-food.jpg" alt="부산 맛집"></p>'
       , '2024-03-08 04:01:18', NULL, 'subonly', 2, 2)
     , ( 'AI 트렌드 분석 🤖'
       , '<h1>🤖 최신 AI 트렌드</h1><p>최근 AI 업계에서 주목할만한 기술과 흐름을 분석합니다.</p><ul><li>OpenAI GPT-5 출시 예정?</li><li>Stable Diffusion 3.0, 새로운 이미지 생성 기술</li><li>기업들이 AI 도입에 집중하는 이유</li></ul><p><img src="https://example.com/images/ai-trends.jpg" alt="AI 트렌드"></p>'
       , '2024-03-09 09:59:55', NULL, 'public', 1, 1)
     , ( '등산 초보자를 위한 코스 추천 🏔️'
       , '<h1>🏔️ 등산 초보자 추천 코스</h1><h3>가볍게 등산할 수 있는 코스</h3><ol><li>북한산 둘레길</li><li>남산 둘레길</li><li>인왕산 정상까지 트레킹</li></ol><p><img src="https://example.com/images/hiking-course.jpg" alt="등산 이미지"></p>'
       , '2024-03-10 04:16:58', NULL, 'public', 3, 3);

# 댓글
INSERT
INTO comment
(
    content, written_date, modify_date, is_deleted, type, above_id, member_id, post_id
) VALUES
-- 기본 댓글
('좋은 정보 감사합니다! 😊', '2024-03-10 20:37:39', NULL, FALSE, 1, NULL, 2, 1),
('여행 체크리스트 유용하네요!✈️', '2024-03-11 13:50:13', NULL, FALSE, 1, NULL, 3, 2),
('운동 루틴 공유해주셔서 감사합니다!💪', '2024-03-12 17:13:45', NULL, FALSE, 1, NULL, 4, 3),
('완전 못쓴다 ㅋㅋ', '2024-03-19 17:12:56', NULL, FALSE, 1, NULL, 3, 5),

-- 대댓글 (위 댓글에 대한 답변)
('진짜 ㅋㅋ 우웩', '2024-03-13 10:03:03', NULL, FALSE, 2, 1, 3, 1),
('풉 ㅋㅋ', '2024-03-14 02:29:19', NULL, FALSE, 2, 2, 4, 2),

-- 삭제된 댓글
('삭제된 댓글입니다.', '2024-03-15 08:22:35', '2025-03-16 07:31:38', TRUE, 1, NULL, 2, 3),

-- 수정된 댓글
('수정 전 댓글', '2024-03-17 10:15:09', '2025-03-18 15:46:38', FALSE, 1, NULL, 1, 1);

# 좋아요
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

# 구독
INSERT
INTO subscribe
(is_notification, subscriber_id, subscribed_id)
VALUES
    ('Y', 1, 2),  -- 유저 1 → 유저 2 구독 (알림 O)
    ('N', 2, 3),  -- 유저 2 → 유저 3 구독 (알림 X)
    ('Y', 3, 4),  -- 유저 3 → 유저 4 구독 (알림 O)
    ('Y', 4, 5),  -- 유저 4 → 유저 5 구독 (알림 O)
    ('N', 5, 1),  -- 유저 5 → 유저 1 구독 (알림 X)
    ('Y', 1, 3),  -- 유저 1 → 유저 3 구독 (알림 O)
    ('N', 2, 4),  -- 유저 2 → 유저 4 구독 (알림 X)
    ('Y', 3, 5);  -- 유저 3 → 유저 5 구독 (알림 O)


# 공용 템플릿
INSERT
INTO public_template
(title, content, written_date, delete_date, usage_count, writer_id)
VALUES
    ('효율적인 공부법', '<h1>📌 집중력을 높이는 공부법</h1><ul><li><strong>목표 설정</strong>: 하루 공부 목표를 정하세요.</li></ul>', '2024-03-10 08:15:30', NULL, 5, 1),
    ('유럽 여행 가이드', '<h1>🛫 유럽 여행 준비 가이드</h1><ol><li><strong>여권 &amp; 비자 확인</strong></li></ol>', '2024-03-12 09:45:20', NULL, 3, 2),
    ('베이킹 초보자를 위한 가이드', '<h1>🍪 초보자를 위한 베이킹 가이드</h1><p><strong>쉬운 쿠키 레시피</strong></p>', '2024-03-15 11:30:10', '2025-02-01 23:59:59', 7, 3),
    ('효율적인 코딩 습관', '<h1>🚀 개발 생산성을 높이는 습관</h1><ul><li><strong>매일 30분 알고리즘 문제 풀기</strong></li></ul>', '2024-03-18 14:05:45', NULL, 10, 4),
    ('독서 리스트 추천', '<h1>📚 이번 달 추천 도서</h1><ol><li><strong>"미니멀 라이프"</strong></li></ol>', '2024-03-20 16:20:25', NULL, 2, 5),
    ('홈 트레이닝 루틴', '<h1>💪 집에서 하는 운동 루틴</h1><h3>1. 상체 운동</h3>', '2024-03-22 18:50:10', '2024-12-01 23:59:59', 8, 6),
    ('일본 여행 팁', '<h1>✈ 일본 여행 체크리스트</h1><p>✔ <strong>JR 패스 미리 구매하기</strong></p>', '2024-03-25 07:40:55', NULL, 5, 8),
    ('사진 촬영 기초', '<h1>📷 DSLR 초보자를 위한 가이드</h1><ul><li><strong>셔터 스피드</strong></li></ul>', '2024-03-27 12:10:35', NULL, 4, 8),
    ('건강한 식습관', '<h1>🥗 건강한 식습관 가이드</h1><ul><li><strong>아침: 단백질 + 탄수화물 섭취</strong></li></ul>', '2024-03-30 20:15:20', NULL, 3, 9),
    ('자취생을 위한 간편 요리', '<h1>🍳 간단한 자취 요리 레시피</h1><h3>✅ 참치마요 덮밥</h3>', '2024-04-01 22:05:10', NULL, 6, 10);


# 공지사항
INSERT
INTO notice
(date, content, member_id)
VALUES
    ('2025-03-09 08:30:15', '일부 버그가 수정되었습니다. 최신 업데이트를 확인하세요.', 7),
    ('2025-03-10 10:15:40', '보안 강화를 위해 비밀번호 변경을 권장합니다.', 7),
    ('2025-03-11 12:50:05', '사용자 피드백을 반영한 기능 개선이 적용되었습니다.', 7),
    ('2025-03-12 14:20:30', '시스템 점검이 예정되어 있습니다. 점검 시간 동안 일부 기능이 제한될 수 있습니다.', 7),
    ('2025-03-13 09:45:55', '새로운 공지 사항이 등록되었습니다. 공지 페이지를 확인해주세요.', 7),
    ('2025-03-14 11:10:25', '서비스 유지보수를 위해 일부 기능이 일시적으로 제한됩니다.', 7),
    ('2025-03-15 15:05:10', '일부 서비스 점검이 완료되었습니다. 원활한 이용이 가능합니다.', 7),
    ('2025-03-16 18:30:20', '버전 2.1.0이 출시되었습니다. 새로운 기능을 확인해보세요.', 7),
    ('2025-03-17 07:55:35', '보안 패치가 적용되었습니다. 최신 버전을 유지해주세요.', 7),
    ('2025-03-17 20:40:50', '새로운 시스템 업데이트가 적용되었습니다. 변경 사항을 확인하세요.', 7);

# 회원별 템플릿 저장소
INSERT
INTO template_space
(member_id)
VALUES
    (1),  -- 이서영 ('2023-05-10')
    (2),  -- 오서준 ('2023-07-15')
    (3),  -- 김정훈 ('2023-08-05')
    (4),  -- 박동우 ('2023-12-20')
    (5),  -- 한소연 ('2024-01-15')
    (6),  -- 최영호 ('2024-02-28')
    (7),  -- 윤민석 ('2024-03-01')
    (8),  -- 강지혜 ('2024-03-05')
    (9),  -- 송유나 ('2024-06-01')
    (10); -- 박은지 ('2024-09-10')

# 개인 템플릿
INSERT
INTO member_template
(title, content, visibility, written_date, delete_date, usage_count, is_copy, repository_id)
VALUES
-- ✅ 기존 10개 (visibility = 'public')
('효율적인 공부법', '<h1>📌 집중력을 높이는 공부법</h1><ul><li><strong>목표 설정</strong>: 하루 공부 목표를 정하세요.</li></ul>', 'public', '2024-03-10 08:15:30', NULL, 5, 'N', 1),
('유럽 여행 가이드', '<h1>🛫 유럽 여행 준비 가이드</h1><ol><li><strong>여권 &amp; 비자 확인</strong></li></ol>', 'public', '2024-03-12 09:45:20', NULL, 3, 'N', 2),
('베이킹 초보자를 위한 가이드', '<h1>🍪 초보자를 위한 베이킹 가이드</h1><p><strong>쉬운 쿠키 레시피</strong></p>', 'public', '2024-03-15 11:30:10', '2024-09-01 23:59:59', 7, 'N', 3),
('효율적인 코딩 습관', '<h1>🚀 개발 생산성을 높이는 습관</h1><ul><li><strong>매일 30분 알고리즘 문제 풀기</strong></li></ul>', 'public', '2024-03-18 14:05:45', NULL, 10, 'N', 4),
('독서 리스트 추천', '<h1>📚 이번 달 추천 도서</h1><ol><li><strong>"미니멀 라이프"</strong></li></ol>', 'public', '2024-03-20 16:20:25', NULL, 2, 'N', 5),
('홈 트레이닝 루틴', '<h1>💪 집에서 하는 운동 루틴</h1><h3>1. 상체 운동</h3>', 'public', '2024-03-22 18:50:10', '2024-12-01 23:59:59', 8, 'N', 6),
('일본 여행 팁', '<h1>✈ 일본 여행 체크리스트</h1><p>✔ <strong>JR 패스 미리 구매하기</strong></p>', 'public', '2024-03-25 07:40:55', NULL, 5, 'N', 8),
('사진 촬영 기초', '<h1>📷 DSLR 초보자를 위한 가이드</h1><ul><li><strong>셔터 스피드</strong></li></ul>', 'public', '2024-03-27 12:10:35', NULL, 4, 'N', 8),
('건강한 식습관', '<h1>🥗 건강한 식습관 가이드</h1><ul><li><strong>아침: 단백질 + 탄수화물 섭취</strong></li></ul>', 'public', '2024-03-30 20:15:20', NULL, 3, 'N', 9),
('자취생을 위한 간편 요리', '<h1>🍳 간단한 자취 요리 레시피</h1><h3>✅ 참치마요 덮밥</h3>', 'public', '2024-04-01 22:05:10', NULL, 6, 'N', 10),


-- ✅ 새로운 10개 (visibility = 'private' 또는 'subonly')
('효율적인 시간 관리', '<h1>⏳ 시간 관리를 잘하는 법</h1><ul><li><strong>우선순위 설정하기</strong></li></ul>', 'private', '2024-04-05 08:30:00', NULL, 4, 'N', 1),
('개발자 포트폴리오 작성법', '<h1>💻 좋은 포트폴리오의 조건</h1><ol><li><strong>깔끔한 UI</strong></li></ol>', 'subonly', '2024-04-07 10:15:30', NULL, 5, 'N', 2),
('1년 동안 영어 실력 늘리기', '<h1>📖 영어 공부 루틴</h1><ul><li><strong>매일 영어 뉴스 읽기</strong></li></ul>', 'private', '2024-04-10 09:45:20', NULL, 3, 'N', 3),
('가성비 좋은 노트북 추천', '<h1>🖥 2024년 노트북 가이드</h1><ul><li><strong>M1 vs M2 비교</strong></li></ul>', 'subonly', '2024-04-12 13:20:45', NULL, 6, 'N', 4),
('초보자를 위한 투자 전략', '<h1>💰 장기 투자를 위한 팁</h1><ul><li><strong>ETF부터 시작하기</strong></li></ul>', 'private', '2024-04-15 15:10:55', NULL, 2, 'N', 5),
('셀프 인테리어 가이드', '<h1>🏡 집 꾸미기 팁</h1><ul><li><strong>벽지 고르는 법</strong></li></ul>', 'subonly', '2024-04-18 16:50:30', '2024-10-01 23:59:59', 4, 'N', 6),
('자기계발 추천 도서', '<h1>📚 자기계발 필독서</h1><ol><li><strong>"성공하는 사람들의 7가지 습관"</strong></li></ol>', 'private', '2024-04-20 17:40:15', NULL, 5, 'N', 8),
('스마트폰 사진 잘 찍는 법', '<h1>📸 핸드폰 사진 강의</h1><ul><li><strong>노출 조절하기</strong></li></ul>', 'subonly', '2024-04-23 19:30:25', NULL, 3, 'N', 8),
('유튜브 시작하기', '<h1>🎬 유튜브 채널 운영 가이드</h1><ul><li><strong>콘텐츠 기획법</strong></li></ul>', 'private', '2024-04-25 21:05:40', NULL, 7, 'N', 9),
('여행 경비 절약 팁', '<h1>🌍 저렴하게 여행하는 법</h1><ul><li><strong>LCC 항공권 활용하기</strong></li></ul>', 'subonly', '2024-04-28 22:55:50', NULL, 4, 'N', 10);



# 회원별 프로필 사진
INSERT
INTO member_profile_image
(member_id, url)
VALUES
    (1, 'https://example.com/images/seoyoung.jpg'),
    (2, 'https://example.com/images/seojun.jpg'),
    (3, 'https://example.com/images/junghoon.jpg'),
    (4, NULL),
    (5, NULL),
    (6, 'https://example.com/images/youngho.jpg'),
    (7, 'https://example.com/images/minseok.jpg'),
    (8, 'https://example.com/images/jihye.jpg'),
    (9, NULL),
    (10, NULL);

# 해시태그
INSERT
INTO hashtag
(name)
VALUES
    ('여행'),       -- (post_id: 2)
    ('맛집'),       -- (post_id: 5, 8)
    ('운동'),       -- (post_id: 3, 6)
    ('일상'),       -- (post_id: 5, 10)
    ('개발자'),     -- (post_id: 1, 4, 7, 9)
    ('프론트엔드'), -- (post_id: 4)
    ('백엔드'),     -- (post_id: 1, 4)
    ('IT트렌드'),   -- (post_id: 1, 7, 9)
    ('다이어트'),   -- (post_id: 3)
    ('스포츠');     -- (post_id: 10)

# 회원별 권한
INSERT
INTO member_roles
(member_id, authority_id)
VALUES
    (1, 2),  -- 이서영 (일반 회원)
    (2, 2),  -- 오서준 (일반 회원)
    (3, 2),  -- 김정훈 (일반 회원)
    (4, 2),  -- 박동우 (일반 회원)
    (5, 2),  -- 한소연 (일반 회원)
    (6, 2),  -- 최영호 (일반 회원)
    (7, 1),  -- 윤민석 (관리자)
    (8, 2),  -- 강지혜 (일반 회원)
    (9, 2),  -- 송유나 (일반 회원)
    (10, 2); -- 박은지 (일반 회원)

# 게시글별 해시태그
INSERT
INTO post_hashtag
(post_id, hashtag_id)
VALUES
    (1, 5),  -- 파이썬 기초 문법 정리 -> 개발자
    (1, 7),  -- 백엔드
    (1, 8),  -- IT트렌드

    (2, 1),  -- 여행 준비 체크리스트 -> 여행

    (3, 3),  -- 초보자를 위한 헬스 가이드 -> 운동
    (3, 9),  -- 다이어트

    (4, 5),  -- Django vs FastAPI 비교 분석 -> 개발자
    (4, 6),  -- 프론트엔드
    (4, 7),  -- 백엔드

    (5, 2),  -- 서울 핫플 카페 추천 -> 맛집
    (5, 4),  -- 일상

    (6, 3),  -- 운동 루틴 공유 -> 운동

    (7, 5),  -- 개발자 포트폴리오 만들기 -> 개발자
    (7, 8),  -- IT트렌드

    (8, 2),  -- 부산 맛집 투어 -> 맛집

    (9, 8),  -- AI 트렌드 분석 -> IT트렌드
    (9, 5),  -- 개발자

    (10, 10), -- 등산 초보자 추천 -> 스포츠
    (10, 4);  -- 일상




# 신고
INSERT
INTO report
(content, status, date, type, member_id, comment_id, post_id ,template_id)
VALUES
    ('허위 정보를 유포한 템플릿입니다.', FALSE , '2024-07-11 10:15:30', 'template', 4
    ,NULL,NULL,4),  #16
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-12 12:30:45', 'template', 3
    ,NULL,NULL,3),  #15
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-13 14:05:20', 'template', 2
    ,NULL,NULL,2),  #14
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-14 09:45:10', 'template', 5
    ,NULL,NULL,1),  #13
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-17 16:20:55', 'template', 6
    ,NULL,NULL,5),  #12
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-19 08:10:35', 'template', 3
    ,NULL,NULL,11),  #11F
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-20 22:40:50', 'template', 3
    ,NULL,NULL,8),  #10
    ('비방적인 언어를 사용한 댓글입니다', FALSE, '2024-07-21 13:25:15', 'comment', 3
    ,4,NULL,NULL),  #9
    ('비방적인 언어를 사용한 댓글입니다', FALSE, '2024-07-22 15:50:05', 'comment', 2
    ,5,NULL,NULL),  #8
    ('비방적인 언어를 사용한 댓글입니다', FALSE, '2024-07-23 17:35:40', 'comment', 2
    ,6,NULL,NULL),  #7
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-24 11:10:25', 'post', 3
    ,NULL,1,NULL),  #6
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-25 20:55:30', 'post', 10
    ,NULL,2,NULL), #5
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-26 07:05:55', 'post', 2
    ,NULL,4,NULL),  #4
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-27 18:30:20', 'post', 6
    ,NULL,3,NULL),  #3
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-28 14:15:45', 'post', 4
    ,NULL,5,NULL),  #2
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-28 21:40:10', 'post', 3
    ,NULL,8,NULL);  #1

# 신고
INSERT
INTO report
(content, status, date, type, member_id, comment_id, post_id ,template_id)
VALUES
    ('허위 정보를 유포한 템플릿입니다.', FALSE , '2024-07-11 10:15:30', 'template', 4
    ,NULL,NULL,4),  #16
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-12 12:30:45', 'template', 3
    ,NULL,NULL,3),  #15
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-13 14:05:20', 'template', 2
    ,NULL,NULL,2),  #14
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-14 09:45:10', 'template', 5
    ,NULL,NULL,1),  #13
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-17 16:20:55', 'template', 6
    ,NULL,NULL,5),  #12
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-19 08:10:35', 'template', 3
    ,NULL,NULL,11),  #11F
    ('허위 정보를 유포한 템플릿입니다.', FALSE, '2024-07-20 22:40:50', 'template', 3
    ,NULL,NULL,8),  #10
    ('비방적인 언어를 사용한 댓글입니다', FALSE, '2024-07-21 13:25:15', 'comment', 3
    ,4,NULL,NULL),  #9
    ('비방적인 언어를 사용한 댓글입니다', FALSE, '2024-07-22 15:50:05', 'comment', 2
    ,5,NULL,NULL),  #8
    ('비방적인 언어를 사용한 댓글입니다', FALSE, '2024-07-23 17:35:40', 'comment', 2
    ,6,NULL,NULL),  #7
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-24 11:10:25', 'post', 3
    ,NULL,1,NULL),  #6
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-25 20:55:30', 'post', 10
    ,NULL,2,NULL), #5
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-26 07:05:55', 'post', 2
    ,NULL,4,NULL),  #4
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-27 18:30:20', 'post', 6
    ,NULL,3,NULL),  #3
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-28 14:15:45', 'post', 4
    ,NULL,5,NULL),  #2
    ('허위 정보를 유포한 게시글입니다.', FALSE, '2024-07-28 21:40:10', 'post', 3
    ,NULL,8,NULL);  #1g

