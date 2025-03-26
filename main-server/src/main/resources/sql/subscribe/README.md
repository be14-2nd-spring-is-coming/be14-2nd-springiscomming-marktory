# 📂 구독 (Subscribe)

## 📖 개요
사용자 간 구독 정보를 저장하는 테이블입니다.

---

## 🏗️ 테이블 구조

### 1️⃣ subscribe
> 사용자 간 구독 관계를 저장하는 테이블

| 필드명         | 타입             | NULL 허용 | 기본값 | 설명 |
|---------------|-----------------|----------|--------|------|
| `id`         | INT AUTO_INCREMENT | NO       | -      | 기본 키 (구독 관계 ID) |
| `is_notification` | CHAR(1)   | NO       | -      | 알림 여부 (`Y`, `N`) |
| `subscriber_id`  | INT         | YES      | NULL   | 구독하는 사용자 ID |
| `subscribed_id`  | INT         | YES      | NULL   | 구독 대상 사용자 ID |

#### 🔗 관계 (Foreign Key)
- `subscriber_id` → `member.id`
- `subscribed_id` → `member.id`
