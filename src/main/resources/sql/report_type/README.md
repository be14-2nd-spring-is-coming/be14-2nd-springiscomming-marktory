# 📂 신고별 구분 (Report Type)

## 📖 개요
신고된 대상이 **게시글, 댓글, 템플릿 중 어느 것인지 식별하는 테이블**입니다.  
신고(`report`) 테이블과 연관된 데이터를 저장하며, **하나의 신고가 특정 대상(게시글, 댓글, 템플릿)과 연결될 수 있습니다.**

---

## 🏗️ 테이블 구조

### 1️⃣ `report_type`
> 신고된 대상(게시글, 댓글, 템플릿 등)의 유형을 저장하는 테이블

| 필드명        | 타입             | NULL 허용 | 기본값 | 설명 |
|--------------|-----------------|----------|--------|------|
| `id`         | INT AUTO_INCREMENT | NO       | -      | 기본 키 (신고 유형 ID) |
| `report_id`  | INT             | NO       | -      | 신고 ID (FK) |
| `comment_id` | INT             | YES      | NULL   | 신고된 댓글 ID (FK) |
| `post_id`    | INT             | YES      | NULL   | 신고된 게시글 ID (FK) |
| `template_id`| INT             | YES      | NULL   | 신고된 템플릿 ID (FK) |

#### 🔗 관계 (Foreign Key)
- `report_id` → `report.id`
- `comment_id` → `comment.id`
- `post_id` → `post.id`
- `template_id` → `template.id`
