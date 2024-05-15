import {displayMap, createMarker, locFromAddress, addrFromLoc, createPolyline} from '/js/module/map.js'
import {getMyInfo, getScheduleDetail, postVotingItem, doVote, deleteSchedule, outSchedule} from '/js/module/ajax.js'
import {getRoute} from '/js/module/mobility.js'


// ---- 스케쥴 관련 정보
const urlSearch = new URLSearchParams(location.search);
let scheduleId = await urlSearch.get('scheduleId');
let scheduleResponse = await getScheduleDetail(scheduleId);
let scheduleInfo =scheduleResponse.data;
const targetInfo = scheduleInfo.scheduleDetailInfo;
// ---- 사용자 정보 ----
const myInfo = await getMyInfo();
const myScheduleInfo = scheduleInfo.memberList.find(v => v.email === myInfo.email);
const myPoint = myScheduleInfo.lat? [myScheduleInfo.lat, myScheduleInfo.lng] : await locFromAddress(myInfo.address);


// 1. 도착지가 있든 없든 보여주는 정보
const scheduleInfoContainer = $(`
  <div class="schedule-info">
    <p class="name">${targetInfo.name}</p>
    <p class="description">${targetInfo.description? targetInfo.description : "즐거운 하루 되세요!"}</p>
  </div>
`)
scheduleInfoContainer.css('border-color', targetInfo.color)
$('.info-container').append(scheduleInfoContainer)

// 2. 도착지 정보가 없는 경우
if (!targetInfo.lat) {
}

// 3. 도착지 정보가 있는 경우
if (targetInfo.lat) {
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
}


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

