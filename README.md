# MarkTory, 기술을 넘어 이야기를 담는 공간

![메인이미지](./docs/banner/banner.png)

<br>

# :cherry_blossom: 봄이오조 :cherry_blossom:

<table>
  <tr>
    <td><img src="./docs/member/Kasey.JPEG" width="150" height="150"/></td>
    <td><img src="./docs/member/D.JPEG" width="150" height="150"/></td>
    <td><img src="./docs/member/Alex.JPEG" width="150" height="150"/></td>
    <td><img src="./docs/member/Morris.JPEG" width="150" height="150"/></td>
    <td><img src="./docs/member/Dong.png" width="150" height="150"/></td>
    <td><img src="./docs/member/Tim.jpeg" width="150" height="150"/></td>
  </tr>
  <tr>
    <td>:crown:주아현</td>
    <td>강이도은</td>
    <td>곽우석</td>
    <td>이상모</td>
    <td>정동한</td>
    <td>한윤상</td>
  </tr>
</table>

# 기술스택

## 🛠️ Backend
![Java](https://img.shields.io/badge/Java-17-007396.svg?&logo=java&color=red)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3-6DB33F.svg?&logo=spring-boot&color=lightgreen)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F.svg?&logo=spring-data-JPA)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C.svg?&logo=hibernate)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F.svg?&logo=spring-security&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000.svg?&logo=json-web-token&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?&logo=gradle)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162.svg?&logo=junit5&logoColor=white&color=green)

## 💽 DB
<!--![Ubuntu](https://img.shields.io/badge/Ubuntu-E95420.svg?&logo=ubuntu&logoColor=white)-->
![MariaDB](https://img.shields.io/badge/MariaDB-003545.svg?&logo=mariadb)
<img src="https://img.shields.io/badge/MyBatis-FF5733?style=flat&logo=MyBatis&logoColor=white">
<!--!![Redis](https://img.shields.io/badge/Redis-DC382D.svg?&logo=redis&logoColor=white)-->

## ⛓️ Server
<img src="https://img.shields.io/badge/Eureka%20Server-4D8FC9?style=flat&logo=Spring&logoColor=white">

## ⚙ Tool
<img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"> &nbsp; <img src="https://img.shields.io/badge/ERD%20cloud-%230000FF.svg?style=flat&logo=erlang&logoColor=white"> &nbsp; <img src="https://img.shields.io/badge/DA%23-0B6121.svg?style=flat&logo=draw.io&logoColor=white"> &nbsp; <!--<img src="https://img.shields.io/badge/Linux-FCC624?style=flat&logo=linux&logoColor=black"> &nbsp; <img src="https://img.shields.io/badge/Ubuntu-E95420?style=flat&logo=Ubuntu&logoColor=white">--><img src="https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=flat&logo=IntelliJ%20IDEA&logoColor=white">

<br>

# 목차 
1. [개요](#개요)    
2. [주요 기능](#주요-기능)
3. [WBS](#WBS)
4. [요구사항 명세서](#요구사항-명세서)
5. [DDD](#DDD)
6. [DB 모델링](#DB-모델링)
7. [프로젝트 아키텍쳐](#프로젝트-아키텍쳐)
8. [API명세서](#API-명세서)
8. [API Test](#API-Test)
9. [TestCase](#TestCase)
10. [팀 회고](#팀-회고)

# 개요

> 자기 PR의 시대, 나만의 개발자 공간을 만들다. 지루한 기술 블로그에서 벗어나 자유롭게 글을 작성하고, 나만의 스타일로 PR할 수 있는 공간!
> MarkTory는 Markdown 기반으로 간편하게 블로그를 운영하고, 개발자 간 소통과 네트워킹을 지원합니다. 기술을 공유하는 것에서 한 걸음 더 나아가, 커스텀 템플릿을 통해 나만의 색깔을 표현하고 성잘할 수 있는 커뮤니티를 제공합니다. 이제 개발자의 글쓰기는 단순한 기록이 아닌, 개인의 브랜딩과 연결되는 새로운 경험이 됩니다. 쉽고 자유로운 글쓰기, 더 넓은 개발자 네트워크! 지금 MarkTory와 함께 나만의 공간을 만들어보세요.

<br>

##  개발 배경
### 1️⃣ 개발자 블로그의 한계와 PR 공간의 부재
기술 블로그는 개발자의 성장과 지식 공유의 필수적인 도구이지만, 기존 플랫폼은 개발자 친화적인 기능 부족, 네트워크 제한, Markdown 지원 미흡 등의 문제를 가지고 있습니다. 또한, 개인 포트폴리오와 연결된 자기 PR 공간이 부족하여 개발자들이 자신의 기술력을 효과적으로 표현하기 어려운 상황입니다. 이에 따라, Markdown 기반의 블로그와 PR 페이지를 결합한 새로운 플랫폼이 필요합니다.

### 2️⃣ 자유로운 글쓰기와 네트워킹의 필요성
개발자들은 기술 공유뿐만 아니라 템플릿을 활용한 효율적인 글 작성, 네트워크 형성, 피드백 교류를 원합니다. 하지만 기존 블로그 플랫폼은 구독, 템플릿 공유, 개발자 간 연결 기능이 부족하여 단순한 글쓰기 공간에 머물러 있습니다. 따라서, 개발자들이 기술을 공유하면서도 서로 연결될 수 있는 새로운 커뮤니티가 필요합니다.

<br>

## 📋주요 기능
### 1️⃣ Markdown 기반의 간편한 글쓰기
개발자들이 익숙한 Markdown 문법을 사용하여 손쉽게 글을 작성하고 관리할 수 있습니다.

### 2️⃣ 커스터마이징 가능한 템플릿
다양한 템플릿을 제공하여 사용자가 자신의 스타일에 맞게 블로그를 꾸밀 수 있습니다.

### 3️⃣ 개발자 네트워킹 지원
다른 개발자들의 블로그를 구독하고, 댓글과 피드백을 주고받으며, 협업의 기회를 넓힐 수 있습니다.

### 4️⃣ 포트폴리오
자유롭게 작성한 글과 템플릿을 통해 자신만의 개성있는 포트폴리오를 만들 수 있습니다.

<br>

## 💡 차별성

![차별성이미지](./docs/necessity/necessity.png)

### 1️⃣ 개발자 중심의 기능 제공
기존 플랫폼들이 가지는 Markdown 지원 미흡, 제한적인 커스터마이징 등의 문제를 해결하여 개발자 친화적인 환경을 제공합니다.

### 2️⃣ 네트워킹과 커뮤니티 강화
단순한 블로깅을 넘어 개발자 간의 소통과 협업을 촉진하는 기능을 제공합니다.

<br>

# [WBS](https://docs.google.com/spreadsheets/d/1Fo4dbNoZw4fOaGpFP54IiKlQQwziKJoDIP2-uSstzzg/edit?usp=sharing)
![WBS이미지](./docs/wbs/wbs.png)

<br>

# [요구사항 명세서](https://docs.google.com/spreadsheets/d/1yIbZjcO_11O52FWxNXQUNZFIGag_PA7eXX80ekW4n4o/edit?usp=sharing)
![요구사항명세서이미지](./docs/reqDoc/요구사항명세서.png)

<br>

# DDD
### 1️⃣ Bounded Context
![바운디드컨텍스트이미지](./docs/ddd/bounded.jpg)

### 2️⃣ Context Mapping
![컨텍스트메핑이미지](./docs/ddd/mapping.jpg)

<br>

# DB 모델링
### 1️⃣ 플로우차트
![플로우차트이미지](./docs/flowchart/플로우차트_메인.png)

### 2️⃣ 논리모델링
![논리모델링이미지](./docs/modeling/논리모델링.png)

### 3️⃣ 물리모델링
![물리모델링이미지](./docs/modeling/물리모델링.png)

<br>

# 프로젝트 아키텍쳐
- Project Server 구조
![아키텍쳐이미지](./docs/architecture/server.jpg)
- Eureka Server
![유레카서버이미지](./docs/architecture/eureka_server.png)

<br>

# API 명세서
## 📍 Swagger-UI
<details>
 <summary>Member Template</summary>
  <img src="./docs/swagger/swagger/swagger02.png" width=700>
</details>
<details>
 <summary>Post</summary>
  <img src="./docs/swagger/swagger/swagger03.png" width=700>
</details>
<details>
 <summary>Comment</summary>
  <img src="./docs/swagger/swagger/swagger01.png" width=700>
</details>
<details>
 <summary>Report</summary>
  <img src="./docs/swagger/swagger/swagger04.png" width=700>
</details>
<details>
 <summary>Subscribe</summary>
  <img src="./docs/swagger/swagger/swagger05.png" width=700>
</details>

<br>

# API Test
## 📍 01_Member
<details>
 <summary> 회원가입 인증 이메일 전송</summary>
  <img src="./docs/APITest/member/member01.png" width=700>
  <img src="./docs/APITest/member/member02.png" width=700>
  
  - 일반 회원 토큰  
  <img src="./docs/APITest/member/member03.png" width=700>
  
  - 관리자 토큰
  <img src="./docs/APITest/member/member04.png" width=700>
</details>
<details>
 <summary>회원 가입 인증 완료</summary>
  <img src="./docs/APITest/member/member05.png" width=700>
  
  - 회원 가입 인증 실패
  <img src="./docs/APITest/member/member06.png" width=700>
</details>
<details>
 <summary>회원 가입</summary>
  <img src="./docs/APITest/member/member07.png" width=700>
</details>
<details>
 <summary>로그인</summary>
  <img src="./docs/APITest/member/member08.png" width=700>
</details>
<details>
 <summary>관리자 로그인</summary>
  <img src="./docs/APITest/member/member09.png" width=700>
</details>
<details>
 <summary>마이페이지에서 닉네임, 프로필사진 조회</summary>
  <img src="./docs/APITest/member/member10.png" width=700>
</details>
<details>
 <summary>마이페이지에서 내가 작성한 댓글 조회</summary>
  <img src="./docs/APITest/member/member11.png" width=700>
</details>
<details>
 <summary>마이페이지에서 내가 작성한 템플릿 조회</summary>
  <img src="./docs/APITest/member/member12.png" width=700>
</details>

## 📍 02_Member_Templates
<details>
 <summary>특정 회원 모든 공개 템플릿 조회</summary>
  <img src="./docs/APITest/m_templates/m_templates01.png" width=700>
</details>
<details>
 <summary> 특정 회원 모든 템플릿 조회</summary>
  <img src="./docs/APITest/m_templates/m_templates02.png" width=700>
</details>
<details>
 <summary> 템플릿 생성 </summary>
  
  - 요청
  <img src="./docs/APITest/m_templates/m_templates03.png" width=700>
  
  - 결과(서버에서 HTML 코드 생성 후 반환)
  <img src="./docs/APITest/m_templates/m_templates04.png" width=700>
</details>
<details>
 <summary> 템플릿 수정  </summary>
  <img src="./docs/APITest/m_templates/m_templates05.png" width=700>
</details>
<details>
 <summary> 템플릿 삭제</summary>
  <img src="./docs/APITest/m_templates/m_templates06.png" width=700>
</details>

## 📍 03_Post
<details>
 <summary> 현재 공개 게시물 모두 조회 </summary>
  <img src="./docs/APITest/post/post_01.png" width=700>
</details>
<details>
 <summary> 게시글 작성</summary>
  <img src="./docs/APITest/post/post_02.png" width=700>
</details>
<details>
 <summary> 게시글 삭제 </summary>
  <img src="./docs/APITest/post/post_03.png" width=700>
</details>

## 📍 04_Comment
<details>
 <summary> 댓글 조회 </summary>
  <img src="./docs/APITest/comment/comment1.png" width=700>
</details>
<details>
 <summary> 댓글 작성</summary>
  <img src="./docs/APITest/comment/comment2.png" width=700>
</details>
<details>
 <summary> 댓글 수정</summary>
  <img src="./docs/APITest/comment/comment3.png" width=700>
</details>
<details>
 <summary> 댓글 삭제</summary>
  <img src="./docs/APITest/comment/comment4.png" width=700>
</details>

## 📍 05_Report
<details>
 <summary> 신고 전체 조회 </summary>
  <img src="./docs/APITest/report/report1.png" width=700>
</details>
<details>
 <summary> 피신고자 조회 </summary>
  <img src="./docs/APITest/report/report2.png" width=700>
</details>

## 📍 06_Subscribe
<details>
 <summary> 구독 요청 </summary>
  <img src="./docs/APITest/subscribe/sub1.png" width=700>
  <img src="./docs/APITest/subscribe/sub2.png" width=700>
</details>
<details>
 <summary> 구독 알림 끄기 </summary>
  <img src="./docs/APITest/subscribe/sub3.png" width=700>
</details>
<details>
 <summary> 구독 중인 회원 조회 </summary>
  <img src="./docs/APITest/subscribe/sub4.png" width=700>
</details>
<details>
 <summary> 내 구독자 조회 </summary>
  <img src="./docs/APITest/subscribe/sub5.png" width=700>
</details>
<details>
 <summary> 구독한 회원 정보 조회</summary>
  <img src="./docs/APITest/subscribe/sub6.png" width=700>
</details>
<details>
 <summary> 구독 취소 </summary>
    구독 해지하는 회원 ID, 구독 대상 ID
  <img src="./docs/APITest/subscribe/sub7.png" width=700>
  <img src="./docs/APITest/subscribe/sub8.png" width=700>
</details>
<br>

# TestCase

- Test Code
![Test code_comment](./docs/test/comment_updateCode.png)
- Test Summary
![Test Summary_comment](./docs/test/commentTest.png)



# 팀 회고
### 주아현
| Team Member | Peer Review |
|-------------|------------|
| 강이도은      | 매 회의 시작 때마다 팀이 해야 할 일을 소통을 통해 목표로 잡고, 이전 회의의 주요사항을 리마인드 해주었습니다. 팀원들의 의견을 우선적으로 들어주시고 존중해 주셔서 감사했습니다. 이번 프로젝트 때에는 역할을 제대로 분담했으면 좋겠다고 계속 말씀해 주셔서 팀원들이 서로의 강점을 믿고 역할을 나누어 진행을 원활하게 해주었습니다. 주도적으로 강사님 피드백을 받아주었고, 상시 팀원들 의견을 잘 정리해두어 흐름을 잘 잡아주었습니다. 의견이 늘어질 때에는 원래의 논점을 상기시켜주어 삼천포로 빠지지 않게 도와주었습니다. 최고의 팀장! 최고의 PM!      |
| 곽우석       | 항상 팀원들의 얘기에 귀 기울여 주시고 누구 하나 서운한 사람이 생기지 않도록 모든 사람을 챙기시는 모습이 존경스러웠습니다. 프로젝트를 진행하는 동안에도 팀원들의 역할을 분담해주시거나 데드라인을 명확히 정해주시는 등 카리스마있는 모습에도 놀랐습니다. 잠을 줄이고 피곤하신 와중에도 밝은 모습을 보여주시는 Kasey 멋있으십니다!      |
| 이상모       | 항상 밝은 모습으로 팀원들의 이야기를 경청 했으며 개발 일정 조율, 개발 현황 전파, 업무 분담 등등 프로젝트 진행에 관련하여 전반적인 조율을 잘 해주셨습니다. 본인도 개발을 하면서 쉽지 않았을텐데 인상 깊었고 덕분에 좋은 결과가 나온거 같습니다.       |
| 정동한       | 항상 중심을 잡아주시면서, 팀장의 역할을 정말 잘 수행주셨습니다. 발표에서 어떤 부분을 준비해야 하고, 이번 프로젝트에서 어떤 게 중요한지, 리마인드를 진행해 주었습니다. 역할 분배도 정말 잘하셨고 팀원들 의견의 사소한 것 하나하나 들어주시고 팀원들에 멘탈도 잘 잡아주실 수 있는 따듯한 마음을 가진 팀장님입니다! 제 생각엔 너무 좋은 PM이셨습니다.    |
| 한윤상       | 이번 프로젝트에서 따뜻함과 리더십을 겸비한 PM의 모습을 보여주셨습니다. 회의 시 매번 목표를 정확히 짚어주시고, 지난 회의의 흐름을 자연스럽게 이어가며 논점에서 벗어나지 않도록 중심을 잘 잡아주셨습니다. 다양한 의견이 나오는 상황에서도 항상 팀원들의 이야기를 끝까지 들어주시고, 필요할땐 단호하게 결정을 내려주셔서 모두가 신뢰하고 따라갈 수 있었습니다. 일정 조율, 역할 분담, 회의록 정리같은 눈에 보이지 않는 일들도 묵묵히 도맡아 해주셨고, 프로젝트 전반의 흐름을 한결같이 안정적으로 이끌어 주셨습니다. 특히 팀원들의 성향과 강점을 세심하게 파악해 적절한 역할을 분배해주신 덕분에, 각자 자신의 일에 더 몰입할 수 있었고 협업의 시너지를 최대로 이끌어 낼 수 있었습니다. 살인적인 일정으로 모두가 지쳐있던 시점에도 특유의 차분함과 따뜻한 분위기로 팀을 이끌어주셔서 끝까지 힘을 낼 수 있었습니다. 함께할 수 있어 정말 든든했던 최고의 PM이였습니다.   |

### 강이도은
| Team Member | Peer Review |
|-------------|------------|
| 주아현       | 프로젝트를 진행하며 어떤 일이든 믿고 맡길 수 있는 든든한 팀원입니다. 마크토리 기획부터 문서작업, 백엔드 개발, 발표 PPT까지 맡은 부분을 빈틈없이 완성할 수 있는 역량을 갖췄다고 생각합니다. 특히 구독 기능에 고민할 부분이 많았음에도 기능 구현 및 예외처리까지 섬세하게 개발해주어 옆에서 보고 많이 배울 수 있었습니다. 촉박한 기간임에도 백마디 말보다 한 번의 행동으로 보여주는 ‘디’ 덕분에 프로젝트를 잘 마칠 수 있었습니다. 감사합니다!!    |
| 곽우석       | 문서 작업과 개발은 물론, PPT까지 뛰어난 실력을 보여주셨습니다. 며칠 밤을 새워가며 책임감 있게 작업하시는 모습과 점심도 굶으며 작업에 몰입하시는 모습이 인상적이었습니다. 제가 부족한 부분에서 항상 정답을 알고 계셨고, 친절하게 설명해 주시는 모습에서 좋은 분이라는 걸 느꼈습니다. 또한 작업이 막혀 우울했던 순간마다 장난스러운 말들과 따뜻한 격려로 큰 힘이 되어주셔서 정말 감사했습니다.     |
| 이상모       | 문서 작업부터(플로우차트, 모델링, PPT등) 실무 개발까지 모자람 없이 완벽에 가깝게 처리하는 점이 놀라웠습니다. 특히 짧은 개발 시간 안에 스프링은 처음 하는 것일 텐데 구독 시스템을 예외처리까지 잘 처리해주셔서 배울점도 많았습니다.       |
| 정동한       | PPT 디자인에서 강점을 보인 팀원입니다. 사소한 부분을 놓치지 않고 체크하는 부분이 좋은 자세를 가졌습니다. 프로세스에 대한 순서도도 혼자 만들고, 어쩌면 협업에서 필요한 부분 중 하나인 문서화에 대해서는 완성이 되어있다고 생각이 드는 팀원이었습니다. 구독 시스템의 api 명세가 완성도가 높았기에 이미 문서화 + 개발의 완성도 높은 개발자로 다가가고 있는 팀원입니다.       |
| 한윤상       | 누가 시키지 않아도 항상 먼저 해야 할 일을 파악하고 조용히 처리해주는 모습이 반복될수록, 팀 전체가 점점 더 믿고 의지하게 되는 분위기가 자연스럽게 만들어졌습니다. 특히 문서 작성과 PPT 제작에 있어서는 말 그대로 압도적인 능력을 보여주셨습니다. 단순히 예쁘고 보기 좋은 수준을 넘어서, 프로젝트의 구조와 흐름을 일관성 있게 담아낼 줄 아는 분이었고, 발표 준비에서도 큰 중심을 잡아주셨습니다. 개발 외에도 팀 전반의 기록을 챙기고, 자료 하나하나에 세심하게 신경 써준 덕분에 결과물의 완성도가 확연히 올라갔다고 생각합니다. 무엇보다 인상 깊었던 건, 몸도 마음도 힘들 법한 상황 속에서도 늘 프로젝트를 우선순위에 두고 묵묵히 자신의 역할을 해주신 점이었습니다. 손이 닿지 않은 부분이 없었고, 그 조용한 노력 덕분에 팀이 흔들림 없이 끝까지 나아갈 수 있었습니다. 팀원 모두에게 큰 버팀목이 되어주었고, 함께할 수 있어서 정말 든든했습니다.       |

### 곽우석
| Team Member | Peer Review |
|-------------|------------|
| 주아현       | 적극적으로 프로젝트에 참여하고자 열정을 가진 팀원이었습니다. 항시 자신이 해야할 일을 찾아 책임지고 해내고자 노력하셨습니다. 특히 팀원들의 과열된 분위기를 환기하는 센스를 가지셨으며 참여적 자세로 팀 내 동기를 불러 일으켜주셔서 프로젝트를 끝까지 잘 마칠수 있었습니다. 백엔드 프로젝트동안 고생많으셨습니다!      |
| 강이도은      | 별명 아이디어를 제시한 덕에 어색했던 첫 만남도 빠르게 편해졌고, 분위기가 과열되는 순간에도 한 번씩 농담을 던져주셔서 항상 좋은 분위기로 마무리되었던 것 같습니다. 손이 필요할 때 제일 먼저 나서주시고, 모두가 이해를 다르게 하고 있다고 느껴질 때에는, 그 순간을 잘 짚어주셔서 큰 도움이 되었습니다. 어떤 일을 하든 다 경험이라고 생각하고, 끝없이 공부하려는 자세 덕에 복잡한 신고 부분을 믿고 맡길 수 있었습니다. 포기하지 않고 파고들었고, 결국 해내고야 낸 모습 정말 멋있습니다! 좋은 자세 본받고 갑니다.!      |
| 이상모       | 항상 자신이 잘 모르는 것에 대해서 부끄러워 하지 않고 팀원들에게 질문을 하여 새로운 논의 의제를 이끌어내는 등 모두가 틀에 박힐뻔한 의식을 환기 시켜주는 역할을 해주셨다고 생각합니다.    |
| 정동한       | 자신이 궁금한 점을 질문할 줄 알고, 팀원들의 기분도 생각할 줄 아는 분위기 메이커입니다. 기획에서 궁금한 점이나, 세세한 부분을 캐치할 줄 아는 능력을 가졌습니다. 분위기가 다운되려고 할 때 파이팅을 하자며 분위기를 다 잡아주는 모습은 봄이 5조 팀원들이 다시 파이팅 할 수 있는 모습들이었습니다. 로직이나 순서가 제대로 정해지지 않는 신고 도메인을 맡아 고생을 많이 해서 수고했다고 말해주고 싶은 팀원입니다!      |
| 한윤상       | 질문을 주저하지 않고 던질 줄 아는, 건강한 개발 태도를 보여준 팀원이였습니다. 모르는 것이 생기면 곧장 질문했고, 답을 들은 뒤에도 스스로 이해할 때까지 끝까지 붙들고 공부하는 끈기를 꾸준히 보여주셨습니다. 특히 복잡했던 신고 기능을 담당하면서도 처음부터 끝까지 스스로 부딪히고, 부족한 부분은 자료를 찾아가며 완성해가는 모습이 보기 좋았습니다. 기술적인 부분뿐 아니라, 팀 분위기 면에서도 큰 역할을 해주셨습니다. 논의가 길어지거나 다소 무거워질때면 파이팅!으로 분위기를 환기시켜 주었고, 그 덕분에 늘 편안하고 유연한 분위기 속에서 작업할 수 있었습니다.      |

### 이상모
| Team Member | Peer Review |
|-------------|------------|
| 주아현       | 프로젝트 기획 단계부터 팀원들의 사고를 넓게 열어주신 감사한 팀원입니다. 팀 내에서 의견이 분분할 때 중심을 잘 잡을 수 있도록 여러 해결책들을 던져주셔서 혼란스러운 상황을 피할 수 있었습니다. 특히 Github협업 툴에 대한 지식을 팀원분들에게 공유해주셔서 협력적으로 개발할 수 있었습니다. 모님의 꾸준히 탐구하는 자세를 보고 옆에서 많이 배울 수 있었습니다! 더불어 특유의 재치 있는 언어로 팀 분위기를 밝혀주셔서 프로젝트 기간이 즐거웠습니다. 정말 고생 많으셨습니다!       |
| 강이도은      | 항상 소통의 중요성을 상기시켜주고, 협업에 대한 룰을 가장 잘 지키며 꼼꼼하게 세우고자 하셨습니다. 다양하고 좋은 아이디어도 많이 내시고, 매번 생각의 틀에 갇히려 할 때 꺼내주는 고마운 분입니다. 특히, 개인의 생각을 열린 결말로 존중해 주셔서 능동적인 태도를 가지게 도와주셨습니다. 또, 사소한 질문이어도 새로운 지식이 나타날 때에 끝없이 파고 드려 하시고, 팀원들에게 유용할 것 같은 정보들을 다 공유해 주셨습니다. 모리스 덕분에 팀의 원활한 소통과 의견 공유, 현재 필요한 팀의 방향성을 잘 잡히지 않았나 싶습니다. 가끔 튀어나오는 무미건조한 농담도 너무 재밌습니다!!      |
| 곽우석       | 저희 팀의 분위기 메이커, Morris! 모두가 지쳐 있는 순간에도 덕분에 웃을 일이 많았던 것이 기억에 남습니다. 개발 실력은 두말할 것도 없이 뛰어나셨습니다. 저는 손도 대지 못할 부분에서도 완벽한 결과물을 만들어내시는 모습이 정말 신처럼 느껴졌어요..! 또한, 제가 모르는 부분을 자주 질문했음에도 귀찮은 기색 없이 자신의 일처럼 친절하게 설명해 주시는 모습에 감동의 눈물이 찔끔 났습니다. 약 한 달 동안 Morris 덕분에 좋은 기억만 가득했습니다. 정말 감사합니다! 😊       |
| 정동한       | 상모님이 없으셨다면, 기능들이 세세하게 나오고, 그 기능을 기준으로 프로젝트에서 강점을 가질 수 있었을까라는 생각이 듭니다. Swagger나 API 문서화 정리, 그리고 템플릿에서 html 적용이라는 어려운 부분을 맡으셨고 그 부분이 주요 기능이었는데 정말 잘 완성해 주셨고, 한 번씩 분위기 환기도 잘 해주시는 모습이 봄이 5조의 핵심이었다과 볼 수 있는 팀원이었습니다.       |
| 한윤상       | 현업 경험을 바탕으로, 논의의 깊이를 한 단계 더 끌어올려준 팀원이었습니다. 매번 회의 때마다 우리끼리 놓치고 있던 실질적인 사용자 관점이나 협업 구조에 대한 인사이트를 던져주셨고, 덕분에 논의가 현실적이면서도 넓은 시야로 이어질 수 있었습니다. 기능 하나를 정할 때도 그 목적과 구조에 대해 생각하게끔 유도해주셔서, 개발뿐만 아니라 사고의 방식 자체를 다르게 만들어준 분이었습니다. 동시에 조용히 웃긴 분이기도 했습니다. 말투는 늘 차분하고 진지한데, 툭툭 던지는 말들이 은근히 팀원들 웃게 만들어서 회의 분위기가 경직되지 않고 부드럽게 흘렀던 것도 기억에 많이 남습니다. API 문서화, swagger 정리처럼 섬세한 작업을 맡아주시면서도, 팀원들이 고민하는 부분에 끊임없이 아이디어를 제시해주셨고, 배려와 책임감을 동시에 갖춘 팀원이였습니다.      |

### 정동한
| Team Member | Peer Review |
|-------------|------------|
| 주아현       | 프로젝트를 진행하며 발견하는 문제점들을 긍정적인 시각으로 바라보고 여러 방면으로 해결하고자 노력하는 모습이 멋진 팀원이었습니다. 특히 회원 기능과 MSA, Security 권한 등 여러 주요 부분을 담당하여 개발하셨습니다. 마감이 촉박한 시간임에도 포기하지 않고 담당한 부분들을 끝까지 책임지고 해내는 모습들이 개발자로서 배울 점이 정말 많다고 느꼈습니다. 덕분에 프로젝트를 완성도 있게 잘 마칠 수 있었습니다. 동님의 수고에 감사합니다!!       |
| 강이도은      | 봄이오조의 GPT 아닐까 싶습니다. 1 정도의 질문에 10의 대답과 본인이 알고 있는 최대한의 정보 공유를 해주셔서 정말 많은 도움이 되었고, 공부 의지를 불태울 수 있었습니다. 이번에 회원, 권한과 관련된 어려운 부분을 맡으셨는데, 본인의 욕심이라며 책임감을 가지고 임해주셔서 이번 프로젝트가 수월하게 흘러갔던 것 같습니다. 되게 신기했던 점은 저는 사용자 차원에서 생각을 한다면, Dong님은 개발자 차원에서 생각을 한다는 점인데요. 덕분에 저희 서비스에서 구현 가능한 것과 필요한 것들을 잘 챙겨 갈 수 있었습니다. 안된다는 것보다는 일단 해볼게요 라고 하시고, 진짜 해오는 모습 최고였습니다. 동 믿습니다.      |
| 곽우석       | 맡은 역할에 최선을 다하며 밤을 새워서라도 끝내 완성해내는 모습에서 강한 책임감이 느껴졌고, 그 모습에 깊이 감명받았습니다. 또한, 많은 지식을 가졌음에도 과시하거나 잘난 체하는 대신, 그 실력으로 팀원들을 도와주고 자신의 일에도 끊임없이 열정을 쏟는 모습이 인상적이었습니다. Dong 덕분에 많은 도움을 받았고, 당분간 저의 롤모델은 단연 Dong일 것 같습니다! 😊       |
| 이상모       | 개발자라면 이래야 되지 않을까 라는 생각을 들게 만든 팀원 이였습니다. 피드백에 대한 열린 태도는 물론이고, 문제 해결에 대한 집요함과 적절한 판단력, 잘 모르는 영역에 대한 도전 정신까지 갖고 계셨습니다. 특히 MSA 구현과 그에 관련된 설정들을 개발 기한까지 결국엔 해낸 부분이 인상 깊었습니다.       |
| 한윤상       | ‘진짜 개발자’라는 말이 딱 어울리는 분이었습니다. 회원 시스템, MSA, Security 등 가장 복잡하고 어려운 파트임에도 스스로 먼저 맡겠다고 해주셨고, 실제로 그 파트를 빠짐없이 끝까지 완성해주신 덕분에 우리 프로젝트가 제대로 굴러갈 수 있었습니다. 하나를 물으면 열을 알려주려는 그 태도 덕분에 자극받고 더 배우고 싶다는 동기를 얻었습니다. 기술적인 역량도 뛰어나지만, 문제 해결을 향한 집요함과 공유하려는 마음까지 갖춘 분이기에 프로젝트가 잘 마무리 될 수 있었다고 생각합니다.      |

### 한윤상
| Team Member | Peer Review |
|-------------|------------|
| 주아현       | 팀 내에 논의 시 필요한 일이라면 자신의 의견을 분명하게 나타내어 팀의 방향성에 도움을 주었습니다. 프로젝트 내에서 작은 일, 큰일 구분하지 않고 필요한 부분이라면 나서서 담당했고 묵묵히 맡은 바를 책임지고 해내는 모습에 감사했습니다. 더불어 본인의 의견 및 태도를 항시 스스로 돌아보고 피드백 하시는 모습이 타인에 대한 배려심이라 생각되었고 제가 배울 점이라 느꼈습니다. 고생 많으셨습니다!!      |
| 강이도은      | 가장 번거로웠던 문서의 틀을 다 작성해 주시고, 많이 도와주셔서 감사합니다! 팀원들을 잘 서포트 해주어 어쩌면 이번 프로젝트에서 현 상황을 제일 이해를 잘 하고 있지 않을까 생각이 듭니다. 의견이 오고 갈 때는, 모두의 상황을 깊게 생각해 보고 현재 상황에서 가장 합리적인 의견을 내주었습니다. 덕분에 모두가 납득을 하고, 자칫 언쟁까지 이어질 상황을 막아주었던 것 같습니다. 프로젝트 시 칼퇴 없이 모든 일정을 팀에 우선시해주었습니다. 또, 본인이 맡은 도메인도 책임감 있게 개발하시고 더 나아가 테스트 코드까지 개발한 모습 인상 깊었습니다!      |
| 곽우석       | 저의 짝꿍 Tim! 매일 함께했지만, 단 한 번도 불편함을 느낀 적 없는, 함께 있는 것만으로도 편안함을 주는 팀원이었습니다. 아침마다 학원에 가장 먼저 도착하는 성실함은 물론, 프로젝트 기간 내내 묵묵히 자신의 역할을 완수하는 모습이 마치 든든한 버팀목과 같았습니다. Tim에게 많은 부분을 물어보면서도 바쁜 와중에 방해가 될까 미안했지만, 언제나 친절하게 설명해 주셔서 정말 감사했습니다!        |
| 이상모       | 항상 묵묵히 본인이 맡은 도메인에 대해서 끝까지 책임지며 개발 하셨고, 팀원들과 논의 시간에 현실적인 의견을 내며 유연한 자세로 팀원들과 토론을 하여 불필요한 시간낭비를 발생하지 않게 한거 같습니다. 군더더기 없는 깔끔함? 이라는 느낌 이였습니다.       |
| 정동한       | 팀장님과 팀원들을 도와줄 수 있는 뒤에서 고생을 많이 한 팀원이라고 생각합니다. 하기 귀찮다고 생각하는 작업들을 세심하게 잘 수행해 주었고, 문서나 리드미에서 작업과 깔끔한 코드 작성으로 서포팅을 잘 수행한 팀원이라고 생각합니다. 또한 팀원들의 기분도 생각할 줄 아는 모습이 좋은 서포팅이었다고 생각합니다. 회의록과 피드백에 대한 정리에 감사하다고 전하고 싶습니다!      |
