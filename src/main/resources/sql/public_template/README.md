# 📂 공용 템플릿 Public_Template

## 📖 개요
회원들이 공개한 공용템플릿 입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ template
> 템플릿 정보를 저장하는 테이블

| 필드명       | 타입             | NULL 허용 | 기본값 | 설명 |
|-------------|-----------------|----------|--------|------|
| `id`        | INT AUTO_INCREMENT | NO       | -      | 템플릿 ID |
| `title`     | VARCHAR(255)    | NO       | -      | 템플릿 제목 |
| `content`   | LONGTEXT        | NO       | -      | 템플릿 내용 |
| `written_date` | VARCHAR(255) | NO       | -      | 작성 날짜 |
| `delete_date` | VARCHAR(255) | YES      | NULL   | 삭제 날짜 |
| `usage_count` | INT           | NO       | 0      | 사용 횟수 |
| `writer_id` | INT             | NO       | -      | 작성자 ID |

#### 🔗 관계 (Foreign Key)
- `writer_id` → `member.id`
