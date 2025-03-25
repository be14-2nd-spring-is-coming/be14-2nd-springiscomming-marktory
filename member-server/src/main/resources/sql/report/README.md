# 📂 신고 (Report)

## 📖 개요
사용자가 신고한 정보를 저장하는 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ report
> 신고 정보를 저장하는 테이블

| 필드명         | 타입             | NULL 허용 | 기본값 | 설명 |
|-------------|-----------------|----------|--------|------|
| `id`        | INT AUTO_INCREMENT | NO       | -      | 신고 ID |
| `content`   | VARCHAR(255)    | NO       | -      | 신고 내용 |
| `status`    | BOOLEAN         | NO       | false  | 처리 여부 |
| `date`      | VARCHAR(255)    | NO       | -      | 신고 날짜 ('YYYY-MM-DD HH:MM:SS') |
| `member_id` | INT             | NO       | -      | 신고자 ID |

#### 🔗 관계 (Foreign Key)
- `member_id` → `member.id`
