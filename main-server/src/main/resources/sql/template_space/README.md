# 📂 회원별 템플릿 저장소 (Template Space)

## 📖 개요
사용자가 생성한 템플릿을 저장하는 저장소 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ template_repository
> 템플릿 저장소 정보를 저장하는 테이블

| 필드명         | 타입             | NULL 허용 | 기본값 | 설명 |
|-------------|-----------------|----------|--------|------|
| `id`        | INT AUTO_INCREMENT | NO       | -      | 저장소 ID |
| `title`     | VARCHAR(255)    | NO       | -      | 저장소 제목 |
| `member_id` | INT             | NO       | -      | 생성자 ID |

#### 🔗 관계 (Foreign Key)
- `member_id` → `member.id`
