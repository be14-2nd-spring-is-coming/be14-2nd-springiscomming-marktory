# 📂 댓글 (Comment)

## 📖 개요
게시글에 작성된 댓글을 저장하는 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ comment
> 게시글에 작성된 댓글 정보를 저장하는 테이블

| 필드명            | 타입             | NULL 허용 | 기본값  | 설명 |
|----------------|-----------------|----------|--------|------|
| `id`           | INT AUTO_INCREMENT | NO       | -      | 기본 키 (댓글 ID) |
| `content`      | VARCHAR(255)      | NO       | -      | 댓글 내용 |
| `written_date` | VARCHAR(255)    | NO       | -      | 작성 날짜 |
| `modify_date`  | VARCHAR(255)     | YES      | NULL   | 수정 날짜 |
| `is_deleted`   | BOOLEAN           | NO       | false  | 삭제 여부 |
| `type`         | INT               | NO       | 1      | 댓글 유형 (1: 일반, 2: 대댓글) |
| `above_id`     | INT               | YES      | NULL   | 상위 댓글 ID (대댓글일 경우) |
| `member_id`    | INT               | YES      | NULL   | 작성자 ID |
| `post_id`      | INT               | YES      | NULL   | 해당 게시글 ID |

#### 🔗 관계 (Foreign Key)
- `member_id` → `member.id`
- `post_id` → `post.id`
