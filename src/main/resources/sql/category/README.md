# 📂 카테고리 (Category)

## 📖 개요
게시글의 카테고리를 저장하는 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ category
> 게시글의 카테고리를 저장하는 테이블

| 필드명         | 타입             | NULL 허용 | 기본값 | 설명 |
|-------------|-----------------|----------|--------|------|
| `id`        | INT AUTO_INCREMENT | NO       | -      | 카테고리 ID |
| `name`      | VARCHAR(255)    | NO       | -      | 카테고리 이름 |
| `member_id` | INT             | YES      | NULL   | 카테고리 생성자 ID |

#### 🔗 관계 (Foreign Key)
- `member_id` → `member.id`
