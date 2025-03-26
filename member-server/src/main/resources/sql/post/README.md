# 📂 게시글 (Post)

## 📖 개요
사용자가 작성한 게시글을 저장하는 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ post
> 사용자가 작성한 게시글 정보를 저장하는 테이블

| 필드명            | 타입             | NULL 허용 | 기본값  | 설명 |
|----------------|-----------------|----------|--------|------|
| `id`           | INT AUTO_INCREMENT | NO       | -      | 기본 키 (게시글 ID) |
| `title`        | VARCHAR(255)      | NO       | -      | 게시글 제목 |
| `content`      | LONGTEXT          | NO       | -      | 게시글 내용 |
| `written_date` | VARCHAR(255)    | NO       | -      | 작성 날짜 ('YYYY-MM-DD HH:MM:SS') |
| `delete_date`  | VARCHAR(255)     | YES      | NULL   | 삭제 날짜 ('YYYY-MM-DD HH:MM:SS') |
| `visibility`   | VARCHAR(255)     | NO       | 'public' | 공개 상태 (`public`, `private`, `subonly`) |
| `member_id`    | INT               | YES      | NULL   | 작성자 ID |
| `category_id`  | INT               | YES      | NULL   | 카테고리 ID |

#### 🔗 관계 (Foreign Key)
- `member_id` → `member.id`
- `category_id` → `category.id`
