# 📂 게시글별 해시태그 (Post Hashtag)

## 📖 개요
게시글과 해시태그의 관계를 저장하는 관계 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ `post_hashtag`
> 게시글과 해시태그 간의 관계를 저장하는 테이블

| 필드명       | 타입             | NULL 허용 | 기본값 | 설명 |
|-------------|-----------------|----------|--------|------|
| `post_id`   | INT             | NO       | -      | 게시글 ID (FK) |
| `hashtag_id` | INT            | NO       | -      | 해시태그 ID (FK) |

#### 🔗 관계 (Foreign Key)
- `post_id` → `post.id`
- `hashtag_id` → `hashtag.id`
