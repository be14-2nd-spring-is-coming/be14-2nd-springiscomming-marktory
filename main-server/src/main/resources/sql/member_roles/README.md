# 📂 회원별 권한 (member Roles)

## 📖 개요
사용자의 역할(권한)을 저장하는 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ member_roles
> 사용자 권한 매핑 정보를 저장하는 테이블

| 필드명            | 타입     | NULL 허용 | 기본값 | 설명 |
|----------------|--------|----------|--------|------|
| `member_id`    | INT   | NO       | -      | 사용자 ID |
| `authority_id` | INT | NO       | -      | 권한 ID |

#### 🔗 관계 (Foreign Key)
- `member_id` → `member.id`
- `authority_id` → `authority.id`
