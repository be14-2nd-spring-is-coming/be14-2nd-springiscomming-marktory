# 📂 회원별 프로필사진 (Member Profile Image)

## 📖 개요
사용자의 프로필 이미지를 저장하는 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ member_profile_image
> 사용자 프로필 이미지를 저장하는 테이블

| 필드명         | 타입             | NULL 허용 | 기본값 | 설명 |
|-------------|-----------------|----------|--------|------|
| `member_id` | INT             | NO       | -      | 사용자 ID (고유) |
| `id`        | INT AUTO_INCREMENT | NO       | -      | 이미지 고유 ID |
| `URL`       | VARCHAR(255)    | YES      | NULL   | 프로필 이미지 URL |

#### 🔗 관계 (Foreign Key)
- `member_id` → `member.id`
