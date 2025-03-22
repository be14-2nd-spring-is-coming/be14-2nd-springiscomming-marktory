# 📂 공지사항 (Notice)

## 📖 개요
공지사항 데이터를 저장하는 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ notice
> 공지사항 정보를 저장하는 테이블

| 필드명         | 타입             | NULL 허용 | 기본값   | 설명 |
|-------------|-----------------|----------|---------|------|
| `id`        | INT AUTO_INCREMENT | NO       | -       | 공지사항 ID |
| `date`      | VARCHAR(255)    | NO       | -       | 생성 날짜 ('YYYY-MM-DD HH:MM:SS') |
| `content`   | VARCHAR(255)    | NO       | -       | 공지 내용 |
| `member_id` | INT             | YES      | NULL    | 작성자 ID |

#### 🔗 관계 (Foreign Key)
- `member_id` → `member.id`
