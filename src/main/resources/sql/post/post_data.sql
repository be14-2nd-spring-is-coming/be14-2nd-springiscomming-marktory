INSERT
    INTO post
(title, content, written_date, delete_date, visibility, member_id, category_id)
VALUES
( '파이썬 기초 문법 정리'
, '# 🐍 파이썬 기초 문법\n\n## 1. 변수 선언\n```python\nx = 10\ny = "hello"\n```\n변수는 위와 같이 선언할 수 있습니다.\n\n![파이썬 로고](https://example.com/images/python-logo.png)'
, '2025-03-01 00:30:52', NULL, 'public', 1, 1)
     , ( '여행 준비 체크리스트 ✈️'
       , '# ✈️ 여행 준비 체크리스트\n\n여행을 떠나기 전, 다음 리스트를 꼭 확인하세요!\n\n- [x] 여권 챙기기\n- [x] 항공권 예매 확인\n- [x] 호텔 예약 완료\n\n![여행 이미지](https://example.com/images/travel-checklist.jpg)'
       , '2025-03-02 06:36:42', NULL, 'public', 2, 2)
     , ( '초보자를 위한 헬스 가이드 💪'
       , '# 💪 헬스 초보자 가이드\n\n## 1. 운동 루틴\n```\n월: 가슴 + 삼두\n화: 등 + 이두\n수: 하체\n```\n### 2. 기본적인 식단\n- 단백질 섭취 증가\n- 탄수화물 적절히 조절\n\n![운동 이미지](https://example.com/images/fitness-guide.jpg)'
       , '2025-03-03 03:36:26', NULL, 'public', 3, 3)
     , ( 'Django vs FastAPI 비교 분석 🆚'
       , '# 🆚 Django vs FastAPI\n\n| 프레임워크 | 속도 | 유연성 | 커뮤니티 |\n|-----------|------|------|------|\n| Django    | 중간 | 낮음  | 큼  |\n| FastAPI   | 빠름 | 높음  | 작음  |\n\nDjango와 FastAPI의 차이점을 비교하고 장단점을 분석해보았습니다.\n\n![Django vs FastAPI](https://example.com/images/django-fastapi.jpg)'
       , '2025-03-04 02:37:54', NULL, 'public', 1, 1)
     , ( '서울 핫플 카페 추천 ☕'
       , '# ☕ 서울 핫플 카페 추천\n\n요즘 뜨는 감성 카페를 소개합니다!\n\n1️⃣ **블루보틀 성수** - 미니멀한 인테리어와 퀄리티 높은 커피 ☕\n2️⃣ **펠트 커피** - 직접 로스팅한 원두의 깊은 맛\n\n![카페 이미지](https://example.com/images/seoul-cafes.jpg)'
       , '2025-03-05 19:13:27', NULL, 'public', 2, 2)
     , ( '운동 루틴 공유 (삭제됨)'
       , '# 🏋️ 운동 루틴 공유\n\n### 저의 개인 운동 루틴\n\n```\n월: 가슴, 삼두\n화: 등, 이두\n수: 하체\n목: 어깨\n금: 코어\n```\n\n운동을 함께 해봐요! 💪\n\n![운동 이미지](https://example.com/images/workout.jpg)'
       , '2025-03-06 01:29:03', '2025-03-10 10:29:44', 'public', 3, 3)
     , ( '개발자 포트폴리오 만들기 📁'
       , '# 📁 개발자 포트폴리오 가이드\n\n## 1. 필수 포함 항목\n- 프로젝트 소개\n- 기술 스택\n- 경험 및 성과\n\n**Tip**: 깃허브 링크와 블로그를 포함하면 좋아요! 👍\n\n![포트폴리오 예시](https://example.com/images/portfolio-guide.jpg)'
       , '2025-03-07 09:25:42', NULL, 'private', 1, 1)
     , ( '부산 맛집 투어 🍜'
       , '# 🍜 부산 맛집 투어\n\n부산에서 꼭 가봐야 할 맛집 리스트!\n\n📌 **돼지국밥** - 삼진국밥\n📌 **밀면** - 할매밀면\n📌 **회** - 자갈치시장\n\n![부산 맛집](https://example.com/images/busan-food.jpg)'
       , '2025-03-08 04:01:18', NULL, 'subonly', 2, 2)
     , ( 'AI 트렌드 분석 🤖'
       , '# 🤖 최신 AI 트렌드\n\n최근 AI 업계에서 주목할만한 기술과 흐름을 분석합니다.\n\n- OpenAI GPT-5 출시 예정?\n- Stable Diffusion 3.0, 새로운 이미지 생성 기술\n- 기업들이 AI 도입에 집중하는 이유\n\n![AI 트렌드](https://example.com/images/ai-trends.jpg)'
       , '2025-03-09 09:59:55', NULL, 'public', 1, 1)
     , ( '등산 초보자를 위한 코스 추천 🏔️'
       , '# 🏔️ 등산 초보자 추천 코스\n\n### 가볍게 등산할 수 있는 코스\n1️⃣ 북한산 둘레길\n2️⃣ 남산 둘레길\n3️⃣ 인왕산 정상까지 트레킹\n\n![등산 이미지](https://example.com/images/hiking-course.jpg)'
       , '2025-03-10 04:16:58', NULL, 'public', 3, 3);
