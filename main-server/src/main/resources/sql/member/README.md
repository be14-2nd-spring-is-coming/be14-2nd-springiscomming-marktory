# 📂 회원 (Member)

## 📖 개요
사용자 정보를 저장하는 테이블로, 로그인 및 회원 관리 기능을 담당합니다.

---

## 🏗️ 테이블 구조

### 1️⃣ member
> 사용자 계정 정보를 저장하는 테이블

| 필드명         | 타입             | NULL 허용 | 기본값      | 설명                                          |
|---------------|-----------------|----------|------------|---------------------------------------------|
| `id`         | INT AUTO_INCREMENT | NO       | -          | 기본 키 (사용자 ID)                               |
| `email`      | VARCHAR(255)      | NO       | -          | 사용자 이메일 (유니크)                               |
| `password`   | VARCHAR(255)      | NO       | -          | 암호화된 비밀번호                                   |
| `name`       | VARCHAR(255)      | NO       | -          | 사용자 실명                                      |
| `nickname`   | VARCHAR(255)      | NO       | -          | 사용자 닉네임 (유니크)                               |
| `birthday`   | VARCHAR(255)      | NO       | -          | 생년월일                                        |
| `image`      | VARCHAR(255)      | YES      | NULL       | 프로필 이미지 URL                                 |
| `status`     | VARCHAR(255)      | NO       | 'is_active' | 계정 상태 (`is_active`, `is_delete`, `is_black`) |
| `black_date` | VARCHAR(255)      | YES      | NULL       | 계정 정지 날짜 ('YYYY-MM-DD HH:MM:SS')            |
| `assigned_date` | VARCHAR(255)  | NO       | -          | 계정 생성 날짜  ('YYYY-MM-DD HH:MM:SS')                                   |
| `delete_date` | VARCHAR(255)    | YES      | NULL       | 계정 삭제 날짜   ('YYYY-MM-DD HH:MM:SS')                                  |
| `report_count` | INT           | YES      | 0          | 신고 횟수                                       |
| `is_terms`   | BOOLEAN          | NO       | -          | 약관 동의 여부                                    |

#### 🔗 관계 (Foreign Key)
없음
