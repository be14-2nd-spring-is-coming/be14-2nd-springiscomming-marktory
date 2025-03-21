# 📂 개인 템플릿 (Member Template)

## 📖 개요
사용자가 생성한 템플릿을 저장하는 테이블입니다.  
템플릿은 공개(`public`), 비공개(`private`), 구독자 전용(`subonly`)으로 설정할 수 있으며,  
다른 템플릿 저장소(`template_repository`)와 연결될 수 있습니다.

---

## 🏗️ 테이블 구조

### 1️⃣ `member_template`
> 사용자가 생성한 템플릿 정보를 저장하는 테이블

| 필드명         | 타입             | NULL 허용 | 기본값  | 설명 |
|---------------|-----------------|----------|------|------|
| `id`         | INT AUTO_INCREMENT | NO       | -    | 기본 키 (템플릿 ID) |
| `title`      | VARCHAR(255)      | NO       | -    | 템플릿 제목 |
| `content`    | LONGTEXT          | NO       | -    | 템플릿 내용 |
| `visibility` | VARCHAR(255)      | NO       | -    | 공개 범위 (`public`, `private`, `subonly`) |
| `written_date` | VARCHAR(255)    | NO       | -    | 작성 날짜 |
| `delete_date` | VARCHAR(255)     | YES      | NULL | 삭제 날짜 |
| `usage_count` | INT               | NO       | 0    | 사용 횟수 |
| `is_copy`    | CHAR(1)           | NO       | 'N'  | 복사 여부 (`Y`, `N`) |
| `repository_id` | INT            | YES      | NULL | 템플릿 저장소 ID (FK) |

#### 🔗 관계 (Foreign Key)
- `repository_id` → `template_repository.id`
