# 📆 MEEVOTE

## **0️⃣ 프로젝트 개요**

🎈 프로젝트명 : 미봇(MEEVOTE)

📌 프로젝트 컨셉 : 투표를 통해 공평한 모임 장소를 정할 수 있는 일정 관리 서비스

🛠 개발 기간 : 24.04.29 ~ 24.05.17 (3주)

🧑🏻 팀원 : 권수현, 김한주, 이소민, 이우성

💻 사용 기술스택 : Spring Boot, MyBatis, JSP, JQuery

<br>

## **1️⃣ 팀원 정보 및 업무 분담 내역**

| 이름            | 역할     | 설명                                                        |
| --------------- | -------- | ------------------------------------------------------------ |
| 김한주 (팀장) | 화면 개발 | 회원 기능<br>일정 생성<br>투표 생성 및 투표 진행<br>카카오맵 API를 통한 장소 정보 제공 |
| 권수현 | 화면 개발 | 달력을 통한 일정 표시<br>알람창 조회 및 알람 삭제 |
| 이우성 | API 개발 | 프로젝트 초기 설정<br>ec2 서버 서비스 배포<br> |
| 이소민 | API 개발 |  |
<br>

## **2️⃣ 서비스 대표 기능**

| 기능 | 세부기능 |
| --- | --- |
| 회원기능 | 이메일 인증을 통한 회원가입<br>프로필 사진 변경<br>주소 검색 API를 통한 주소 등록 |
| 달력을 통한 일정 조회 | fullcalendar 라이브러리를 통해 달력으로 일정 표시<br>사이드바에 시간 순서로 일정 정보 제공 |
| 일정 상세 조회 | 일정 상세 정보 조회 및 카카오맵 API를 통한 장소 추가 정보 제공 |
| 개인 일정 생성 | 개인 일정 생성<br>카카오맵 API 장소 검색을 통한 일정 장소 추가 기능 제공<br>설정한 날짜를 달력을 통해 표시 |
| 모임 일정 생성 | 모임 일정 생성<br>카카오맵 API 장소 검색을 통한 일정 장소 추가 기능 제공<br>회원 검색을 통한 참여 인원 초대<br>설정한 날짜를 달력을 통해 표시 |
| 모임 일정 장소 투표 | 카카오맵 API를 통해 장소 검색 후 투표 장소로 추가<br>장소까지의 거리, 택시비, 이동시간 등 추가정보 제공 |
| 일정 히스토리 조회 | 지난 일정 테이블 형식으로 조회<br>카테고리 혹은 개인과 그룹 일정으로 필터링 가능<br>모임 횟수에 대한 통계 자료 제공 |
| 알람 | 모임 일정 초대, 다가오는 일정 등을 알람에 표시<br>알람을 확인하면 알람창에서 삭제 |

<br>

## 3️⃣ 서비스 화면

<h4>모델 만들기</h4>

![make model](./exec/asset/screen/make_model.gif)

<h4>커버송 만들기</h4>

![make cover](./exec/asset/screen/make_cover.gif)

<h4>커버송 듣기</h4>

![play](./exec/asset/screen/play.gif)

<h4>커버송 검색</h4>

![search](./exec/asset/screen/search.gif)

<h4>커버송 요청</h4>

![cover request](./exec/asset/screen/cover_request.gif)

<h4>푸쉬 알람</h4>

![alarm](./exec/asset/screen/alarm.gif)

<br>

## **4️⃣ ERD**

![erd](./exec/asset/erd.PNG)

<br>

## **5️⃣ 시스템 아키텍쳐**

![system_architecture](./exec/asset/system_architecture.png)

<br>

## **6️⃣ 개발 환경**

<h4>🌐 공통</h4>

| 상세               |       내용        |
| ------------------ | :---------------: |
| GitLab             |     형상 관리     |
| Jira               | 일정 및 이슈 관리 |
| Mattermost         |   커뮤니케이션    |
| Confluence             | 일정 및 문서 관리 |
| Figma           | 디자인 |
| Premiere pro           | UCC 제작 |
| Visual Studio Code | IDE |

<h4>📱 FrontEnd</h4>

| 상세             |  버전   |
| ---------------- | :-----: |
| Node.js | 18.17.0 |
| React-Native |  0.76.7  |
| TypeScript |  5.1.6  |
| Android SDK |  21~  |
| Java | 11.0 |
| Kotlin | 1.9.0 |
| Recoil | 0.7.7 |
| react-native-audio-recorder-player | 3.5.4 |
| react-native-firebase | 18.4.0 |

<h4>💾 BackEnd Server</h4>

| 상세           |    버전     |
| :------------- | :---------: |
| AWS S3 | |
| AWS EC2 Ubuntu | 20.04 LTS |
| Docker | 24.0.6 |
| NGINX | 1.25.2 |
| django | 4.2.5 |
| MariaDB | 11.1.2 |
| certbot | 2.7.0 |
| uwsgi | 2.0.22 |
| Jenkins | 2.141.1 |
| Docker-compose |   2.20.2    |
| PyCharm | 2023.2.1 |

<h4>🤖 AI Learning Server</h4>

| 상세           |    버전     |
| :------------- | :---------: |
| AWS EC2 Ubuntu | 20.04 LTS |
| Python | 3.9.7 |
| CUDA | 12.1 |
| pytorch | 2.0.0+cu118 |
| pytorch-lightning | 2.0.9 |
| vim | 8.1.3741 |

<br>

## **7️⃣ 프로젝트 디렉토리 구조**

### Front
```
SingChro
├── App.tsx
...
└── src
    ├── assets
    │   ├── icon
            └──...
    │   └── images
            └──...
    ├── components
    │   ├── Auth
    │   │   └── AuthSide.tsx
    │   ├── Cover
    │   │   ├── NewSongList.tsx
    │   │   ├── NewSongModal.tsx
    │   │   ├── OldSongList.tsx
    │   │   ├── OldSongModal.tsx
    │   │   ├── PickedSongItem.tsx
    │   │   ├── PickedVoiceItem.tsx
    │   │   ├── VoiceList.tsx
    │   │   └── VoiceModal.tsx
    │   ├── Footer
    │   │   └── BottomBar.tsx
    │   ├── Header
    │   │   ├── AlarmListItem.tsx
    │   │   ├── AlarmModal.tsx
    │   │   ├── NameHeader.tsx
    │   │   ├── RequestListItem.tsx
    │   │   └── RequestModal.tsx
    │   ├── Home
    │   │   └── FilterBtn.tsx
    │   ├── Player
    │   │   ├── BtnBox.tsx
    │   │   ├── ImgBox.tsx
    │   │   └── PlayController.tsx
    │   ├── Profile
    │   │   ├── ChangeNameModal.tsx
    │   │   ├── ChangePwModal.tsx
    │   │   ├── CoverManageList.tsx
    │   │   ├── CoverManageModal.tsx
    │   │   ├── DeleteUserModal.tsx
    │   │   ├── VoiceManageList.tsx
    │   │   └── VoiceManageModal.tsx
    │   ├── Record
    │   │   ├── GuideBox.tsx
    │   │   ├── PlayBox.tsx
    │   │   └── RecordBox.tsx
    │   └── shared
    │       ├── AuthInput.tsx
    │       ├── Badge.tsx
    │       ├── CommonModal.tsx
    │       ├── CoverItem.tsx
    │       ├── FunctionBtn.tsx
    │       ├── Loading.tsx
    │       ├── MascotBg.tsx
    │       ├── MascotBottom.tsx
    │       ├── RectangleBtn.tsx
    │       ├── RoundBtn.tsx
    │       ├── SearchInput.tsx
    │       ├── TitleBox.tsx
    │       ├── WhiteBtn.tsx
    │       └── WithIconBtn.tsx
    ├── constants
    │   ├── featureTypes.tsx
    │   └── modelTypes.tsx
    ├── functions
    │   ├── alarmFunc.tsx
    │   ├── authFunc.tsx
    │   ├── axiosFunc.tsx
    │   ├── hooksFunc.tsx
    │   ├── permissionFunc.tsx
    │   ├── test.tsx
    │   └── validationFunc.tsx
    ├── states
    │   ├── featureState.tsx
    │   └── modelState.tsx
    ├── styles
    │   ├── coverStyles.tsx
    │   ├── homeStyles.tsx
    │   ├── loginStyles.tsx
    │   ├── playerStyles.tsx
    │   ├── profileStyles.tsx
    │   ├── recordStlyes.tsx
    │   ├── searchStyles.tsx
    │   ├── shadowStyles.tsx
    │   └── startStyles.tsx
    └── views
        ├── Auth
        │   ├── EmailVerifyView.tsx
        │   ├── LoginView.tsx
        │   └── SignupView.tsx
        ├── Cover
        │   ├── CoverConfirmView.tsx
        │   ├── CoverDoneView.tsx
        │   ├── SongPickView.tsx
        │   └── VoicePickView.tsx
        ├── Home
        │   ├── HomeView.tsx
        │   └── OtherHomeView.tsx
        ├── Player
        │   └── MusicPlayerView.tsx
        ├── Profile
        │   └── ProfileView.tsx
        ├── Record
        │   ├── RecordDoingView.tsx
        │   ├── RecordDoneView.tsx
        │   ├── RecordRequestView.tsx
        │   └── RecordStartView.tsx
        ├── Search
        │   └── SearchCoverView.tsx
        └── Start
            └── StartView.tsx
```
### Back
```
└── singchro
    ├── Dockerfile
    ├── accounts
    │   ├── __init__.py
    │   ├── admin.py
    │   ├── apps.py
    │   ├── migrations
    │   │   └── __init__.py
    │   ├── models.py
    │   ├── serializers.py
    │   ├── templates
    │   │   └── confirmation_email.txt
    │   ├── tests.py
    │   ├── urls.py
    │   ├── utils.py
    │   └── views.py
    ├── db.sqlite3
    ├── manage.py
    ├── requirements.txt
    ├── restapi
    │   ├── __init__.py
    │   ├── admin.py
    │   ├── apps.py
    │   ├── fcm.py
    │   ├── migrations
    │   │   └── __init__.py
    │   ├── models.py
    │   ├── serializers.py
    │   ├── tests.py
    │   ├── urls.py
    │   └── views.py
    ├── singchro
    │   ├── __init__.py
    │   ├── asgi.py
    │   ├── key
    │   │   └── a404-singchro-1a28e631aa61.json
    │   ├── settings.py
    │   ├── urls.py
    │   └── wsgi.py
    ├── uwsgi
    │   ├── uwsgi.ini
    │   └── uwsgi.service
    └── wait-for-it.sh
```
### AI

```
├── MultiProcessingTest.py
├── UVR
│   └── ...
├── data_inference
├── data_train
├── handleCoveredSong.py
├── handleVoiceModel.py
├── multiProcessing.py
├── requirements.txt
├── slicer2.py
├── so-vits-svc-5.0
│   ├── ...
├── user_inference
│   ├── ...
└── voicefile_path
```

<br>

## **8️⃣ Covention**

### 🤙 Jira

|구성 요소|역할|비고|
|---|---|---|
|Component|파트 단위|앱, 백엔드, AI, 발표 등|
|Epic|큰 작업 단위|레이아웃, 기능구현, CI/CD 등|
|Story|세부작업(개인)| 기능별 세부 작업 내용 |

### 🤙 Git Commit

| Type | 설명 |
|---|---|
| Add | 새로운 파일 추가 |
| Update  | 코드 수정(개발 중) |
| Fix | 버그 수정 |
| Refactor | 코드 개선( + 유지보수) |
| Log  | log 기록 |

- <b>Commit message format</b>
>[Type] Jira: {Issue number}, message

### 🤙 Git Flow
```
master
└ develop
  ├ front
  ├ back
  ├ AI
  └ log
```

- master : 운영 서버로 배포하기 위한 브랜치
- develop : 개발 기능을 테스트 해보기 위한 브랜치
  - front : 모바일 프론트엔드를 개발
  - back : 백엔드 서버를 개발
  - AI : AI 모델 학습 테스트, AI 학습 서버 개발
  - log : 기록 및 기타

<br>

## **9️⃣ 회고**

|이름|내용|
|:---:|---|
|손세이<br>😄|요즘 많이 사용하는 생성형 AI를 사용하여 내 목소리 커버라는 singing voice를 만들어보니<br>실제로 모델이 돌아가고 만들어지는 과정을 학습하고 사용해볼 수 있어 좋았습니다.<br>혼자 하면 어려웠을 부분들을 팀원들과 함께 분업하니 무사히 완성할 수 있었습니다.|
|류병민<br>😘|처음부터 재밌게 하고 싶었던 프로젝트 주제를 정하게 되어 즐겁게 할 수 있는 프로젝트였습니다<br>체계적으로 진행되지 않은 것 같아 아쉬운 부분이 많지만, 완성할 수 있어 다행입니다<br>조금이지만 백엔드도 새롭게 경험해보게 되어 좋은 경험이었습니다. 많은 시행착오를 겪으며 많은 것을 배웠습니다<br>고생했습니다 모두|
|하제우<br>👹|이번 프로젝트 처음 접해보는 분야였지만 무사히 잘 되어서 다행입니다.<br>다음 프로젝트도 화이팅.|
|김한주<br>😎|주제 자체도 신선해서 굉장히 재밌게 진행했습니다.<br>또한 푸쉬알람, 권한 요청 등 모바일 환경에서의 새로운 작업들을 경험할 수 있어서 좋았습니다.<br>하지만 처음 사용한 기술 스택이다 보니 더 배워야할 느낌은 지울 수가 없네요.<br>분위기 좋은 팀에서 즐거운 플젝할 수 있어서 정말 고맙게 생각합니다!|
|채문희<br>😋|평소에 재미있게 봤던 AI 커버송을 직접 서비스 개발을 하다보니 즐겁게 프로젝트를 할 수 있어서 좋았습니다.<br>처음 백엔드 역할을 맡으면서 프론트 많이 고생시키고 CI/CD를 많이 도와주신<br>우리 팀원들이 있어서 프로젝트를 서비스할 수 있었습니다.<br>감사합니다~!! 우리 404Found 팀!|
