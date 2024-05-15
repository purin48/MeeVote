import {displayMap, createMarker, locFromAddress, addrFromLoc, createPolyline} from '/js/module/map.js';
import * as aj from '/js/module/ajax.js'
import {getRoute} from '/js/module/mobility.js'


// ---- 스케쥴 관련 정보
const urlSearch = new URLSearchParams(location.search);
let scheduleId = await urlSearch.get('scheduleId');
let scheduleInfo = await aj.getScheduleDetail(scheduleId);
const targetInfo = scheduleInfo.scheduleDetailInfo;
// ---- 사용자 정보 ----
const myInfo = await aj.getMyInfo();
const myScheduleInfo = scheduleInfo.memberList.find(v => v.email === myInfo.email);
const myPoint = myScheduleInfo.lat? [myScheduleInfo.lat, myScheduleInfo.lng] : await locFromAddress(myInfo.address);
const memberList = {};


// !!도착지가 있든 없든 보여주는 정보
const scheduleInfoContainer = $(`
  <div class="schedule-info">
    <p class="name">${targetInfo.name}</p>
    <p>
      <span><i class="bi bi-bookmark-check-fill"></i> 카테고리</span> 
      <span class="category">${targetInfo.categoryName}</span>
    </p>
    <p>
      <span><i class="bi bi-calendar"></i> 시작시간</span> 
      <span>${targetInfo.startDate}</span>
    </p>
    <p>
      <span><i class="bi bi-calendar"></i> 종료시간</span> 
      <span>${targetInfo.endDate}</span>
    </p>
    <p class="description">${targetInfo.description? targetInfo.description : "즐거운 하루 되세요!"}</p>
  </div>
`)

// 일정 정보 표시하기
scheduleInfoContainer.find('.category').css('background-color', targetInfo.color)
$('.info-container').append(scheduleInfoContainer)

// 일정 나가기
$('.del-btn').click(async function(e) {
  await deleteSchedule(targetInfo.requesterOwner, scheduleId);
})



// !!도착지 정보가 없는 경우
if (!targetInfo.lat) {
  $('.no-place').css('display', 'flex')
}



// !!도착지 정보가 있는 경우
if (targetInfo.lat) {
  $('.map-container').css('display', 'block')
  // ---- 목적지 주소 정보 ----
  const addr = await addrFromLoc(targetInfo.lat, targetInfo.lng);
  // ---- 지도 객체 ----
  const map = await displayMap('.map-container', myPoint[0], myPoint[1]);
  // ---- 마커 정보 ----
  let myMarker = await createMarker(map,  myPoint[0],  myPoint[1], 72, '/image/marker/my.png');
  // myMarker.setDraggable(true); 
  let targetMarker = await createMarker(map,  targetInfo.lat,   targetInfo.lng, 72, '/image/marker/target.png');
  // ---- 교통 정보 ----
  let routeInfo = await getRouteData();
  // ---- 교통 정보 UI ----
  let distanceUI = createRouteUI(routeInfo, addr);
  // ---- 폴리 라인 ----
  let polyline = createPolyLine(routeInfo, map);
  // ---- 지도 줌 축소 ----
  await changeMapZoom(myMarker, targetMarker, map);

}



// !!그룹 일정일 경우
if (targetInfo.isGroup) {
  // 맴버 컨테이너 활성화
  $('.member-container').css('display', 'block');
  $('.member-btn').css('display', 'block');
  resetMemberAll();
  // 회원 검색 이벤트 등록
  $('#name-serach > i').click(function(e){
    memberSearch();
  });
  $('#name-serach > input').keypress(function (e) { 
  if(e.keyCode && e.keyCode == 13) memberSearch();
  });
  // 검색창 닫기
  $('#search-container').click(function(e) {
    e.stopPropagation();
  });
  $(document).click(function(e) {
    $('#search-list-container').css('display', 'none');
  });

}



// 1. 교통 정보 함수
// ---- 함수 : 교통 정보 불러오기 ----
async function getRouteData() {
  const origin = `${myPoint[1]},${myPoint[0]}`
  const destination = `${targetInfo.lng},${targetInfo.lat}`
  const routeInfo = await getRoute(origin, destination);

  return routeInfo.routes[0];
}
// ---- 함수 : 교통 정보 불러오기 End ----

// ---- 함수 : 교통 정보 UI 그리기 ----
function createRouteUI(routeInfo, addr) {
  const taxiTime = parseInt((routeInfo.summary.duration) / 60);
  const taxiFee = routeInfo.summary.fare.taxi;
  const walkTime = parseInt((routeInfo.summary.distance) / 65);
  const totalDistance = parseInt((routeInfo.summary.distance) / 1000);
  // ---- 교통 정보 UI 표시
  const distanceContainer = $(`
  <div class="distance-info ">
    <div class="row-container vote-head">
      <p class="name">${targetInfo.placeName}</p>
    </div>
    <p class="address">${[addr[0].address.address_name]}</p>
    <div class="row-container transporter-container">
      <div class="transporter">
        <img src="/image/icon/walk.png" alt="">
        <span>${walkTime}분</span>
      </div>
      <div class="transporter">
        <img src="/image/icon/taxi.png" alt="">
        <span>${taxiTime}분</span>
      </div>
      <div class="transporter fee">
        <span>${totalDistance}km</span>
        <span>${taxiFee}원</span>
      </div>
    </div>
  </div>
  `)

  $('.info-container').append(distanceContainer);

  return distanceContainer;
}
// ---- 함수 : 교통 정보 UI 그리기 End ----

// ---- 함수 : 폴리 라인 그리기 ----
async function createPolyLine(routeInfo, map) {
  const routes = routeInfo.sections[0].guides;
  const cordArr = []
  $.each(routes, function (index, route) { 
    cordArr.push(new kakao.maps.LatLng(route.y, route.x));
  });

  const polyline = createPolyline(map, cordArr);

  return polyline;
}
// ---- 함수 :폴리 라인 그리기 End ----


// ---- 함수 : 지도 축소 ----
async function changeMapZoom(start, end, map) {
  const bounds = new kakao.maps.LatLngBounds();
  bounds.extend(start.getPosition()); 
  bounds.extend(end.getPosition()); 
  map.setBounds(bounds);
}
// ---- 함수 : 지도 축소 End ----
// 1. 교통 정보 함수



// 2. 맴버 불러오기
// ---- 함수 : 맴버 ui 추가----
function createMemberUI(info) {
  const li = $(`
  <li class="search-item">
    <div class="member-image"> 
      <img src=${info.imgSrc} alt="">
    </div>
    <p class="member-info">${info.name}</p>
  </li>
  `)

  $('.member-list').append(li);
  return li;
}
// ---- 함수 : 맴버 ui 추가 ----

// --- 함수 : 맴버 목록 갱신 ----
async function resetMemberAll() {

  $.each(scheduleInfo.memberList, async function (index, info) {
    if (memberList.hasOwnProperty(info.email)) return;
    const ui = createMemberUI(info);
  
    memberList[info.email] = {"ui": ui, "info":info};
  });
}
// --- 함수 : 맴버 목록 갱신 End----

// ---- 이벤트 등록 : 맴버 관리 이벤트 ----
$('.member-btn').click(function(e) {
  $('.member-container').toggleClass('hide-container');
})
// ---- 이벤트 등록 : 맴버 관리 이벤트 ----
// 2. 맴버 불러오기 End



// 3. 맴버 검색
// ---- 함수 : 맴버 검색 함수 ----
async function memberSearch(e){
  // ul 태그 비우기
  $('#search-list').empty();  
  // 검색 리스트 구성
  const response = await aj.serachMember({name: $('#name-serach > input').val()});
  const searchList = response.data

  $.each(searchList, function (idx, member) { 
    if (memberList.hasOwnProperty(member.email)) return;
    // 요소 생성
    let searchUI = $(`
      <li class="search-item">
        <div class="member-image"> 
          <img src=${member.imgSrc} alt="">
        </div>
        <p class="member-info">${member.name}</p>
      </li>
    `)
    // 맴버 추가 이벤트
    $(searchUI).click(async function(e) {
      const data = {
          "scheduleId": scheduleId,
          "inviteEmailList": [
            member.email
          ]
      };
      const response = await aj.inviteMember(data);
      scheduleInfo = await aj.getScheduleDetail(scheduleId);
      await resetMemberAll();
      $(this).remove();
    })

    $('#search-list').append(searchUI);
  });

  // 검색 리스트 표시
  $('#search-list-container').css('display', 'block');
}
// 3. 맴버 검색 End



// 4. 일정 나가기
async function deleteSchedule(isOwner, scheduleId){
  const result = await Swal.fire({
    title: isOwner? '일정 삭제' : '일정 나가기',
    text: isOwner? 
      '한 번 삭제된 일정은 되돌릴 수 없습니다. 정말 삭제하시겠습니까?' : 
      '한 번 나가면 다시 초대받을 때까지 들어올 수 없습니다. 정말로 나가시겠습니까?',
    icon: 'warning',
    showConfirmButton: false,
    showDenyButton: true,
    showCancelButton: true,
    cancelButtonText: '아니오',
    denyButtonText: '네'
  });

  if (result.isDenied) {
    let response = isOwner? await aj.deleteSchedule(scheduleId) : await aj.outSchedule(scheduleId);
    if (response.isSuccess) {
      location.replace('/');
    }
  }
}

