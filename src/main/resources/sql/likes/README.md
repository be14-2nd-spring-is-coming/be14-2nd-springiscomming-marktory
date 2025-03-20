# 📂 좋아요 (Likes)

## 📖 개요
게시글 또는 댓글에 대한 "좋아요" 데이터를 저장하는 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ likes
> 사용자가 게시글 또는 댓글에 대한 좋아요를 저장하는 테이블

| 필드명         | 타입             | NULL 허용 | 기본값  | 설명 |
|---------------|-----------------|----------|--------|------|
| `id`         | INT AUTO_INCREMENT | NO       | -      | 기본 키 (좋아요 ID) |
| `type`       | VARCHAR(255)      | NO       | -      | 좋아요 대상 (`post`, `comment`) |
| `post_id`    | INT               | YES      | NULL   | 게시글 ID (해당하는 경우) |
| `comment_id` | INT               | YES      | NULL   | 댓글 ID (해당하는 경우) |

#### 🔗 관계 (Foreign Key)
- `post_id` → `post.id`
- `comment_id` → `comment.id`
