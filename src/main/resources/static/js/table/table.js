import * as aj from '/js/module/ajax.js';

// 캐러셀 관련
const carouelLen = 280;
const voteList = await aj.getVoteSchedules();
const futureList = await aj.getFutureSchedules();
const voteCount = voteList.length;
const futureCount = futureList.length;
// 검색 관련
let categoryId = 0;
let page = 0;
let size = 10;
let keyword = "";
let isLast = true;
// 차트 관련
const today = new Date();
let isGroup;
let barIsGroup = null;
let circleIsGroup = null;


// !왼쪽 사이드 캐러셀
let leftSlid = 0;

$('.voting-container .carousel_prev').click(function(e) {
  if (leftSlid > 0) showLeftSlide(leftSlid - 1);
})

$('.voting-container .carousel_next').click(function(e) {
  if (leftSlid < voteCount-1) showLeftSlide(leftSlid + 1);
})

addCarousel(voteList, '.voting-container .carousel_wrapper', true)
showLeftSlide(0);
// !왼쪽 사이드 캐러셀 End


// !오른쪽 사이드 캐러셀
let rightSlide = 0;

$('.future-container .carousel_prev').click(function(e) {
  if (rightSlide > 0) showRightSlide(rightSlide - 1);
})

$('.future-container .carousel_next').click(function(e) {
  if (rightSlide < futureCount-1) showRightSlide(rightSlide + 1);
})

addCarousel(futureList, '.future-container .carousel_wrapper', false);
showRightSlide(0);
// !오른쪽 사이드 캐러셀 End


// ! 데이터 테이블
await getCategories()

await getFirstSchedules();

$('.name-serach > i').click(async function(e){
  categoryId = $('.category-select').val();
  keyword = $('.name-serach > input').val();
  await getFirstSchedules();
})

$('.down-btn').click(async function(e) {
  page++;
  await getSchedules();
})


// ! 차트
const circleChart = await showFirstCircleChart();
const barChart = await showFirstBarChart();





// 1. 캐러셀 함수
// ---- 캐러셀 생성 함수 ----
function createCarousel(schedule, isVoting) {
  let place;
  if (isVoting) place = '투표 중!';
  else if (!schedule.placeName) place = "장소 정보 없음"
  else place = schedule.placeName;
  const icon = isVoting? '<i class="bi bi-alarm"></i>' : '<i class="bi bi-calendar2-minus"></i>'
  const carousel = $(
    `
    <div class="carousel">
      <div class="carousel-head">
        <span class="name">${schedule.name}</span>
      </div>
      <div class="carousel-content">
        <div class="date">
          ${icon}
          <span>${isVoting? schedule.voteDeadline : schedule.startDate}</span>
        </div>
        <div class="category">${schedule.categoryName}</div>
      </div>
      <div class="carousel-footer">
        <div class="place">
          <i class="bi bi-geo-alt"></i>
          <span>${place}</span>
        </div>
      </div>
    </div>
    `
  );

  carousel.css('border-color', schedule.color);
  carousel.find('.category').css('background-color', schedule.color);
  carousel.click(function(e){
    location.href = `/schedule/${isVoting? 'vote':'detail'}?scheduleId=${schedule.scheduleId}`
  })

  return carousel;
}
// ---- 캐러셀 생성 함수 End ----

// ---- 캐러셀에 추가 ----
function addCarousel(list, selector, isVoting) {
  $.each(list, function (idx, item) { 
    const carousel = createCarousel(item, isVoting);
    $(selector).append(carousel);
  });
}
// ---- 캐러셀에 추가 End ----

// ---- 오른쪽 캐러셀 이동 함수 ----
function showRightSlide(slideIndex) {
  $('.future-container .carousel_wrapper').css('transform', `translateX(-${slideIndex * carouelLen}px)`)
  rightSlide = slideIndex;
}
// ---- 오른쪽 캐러셀 이동 함수 End ----

// ---- 왼쪽 캐러셀 이동 함수 ----
function showLeftSlide(slideIndex) {
  $('.voting-container .carousel_wrapper').css('transform', `translateX(-${slideIndex * carouelLen}px)`)
  leftSlid = slideIndex;
}
// ---- 왼쪽 캐러셀 이동 함수 End ----
// 1. 캐러샐 End



// 2. 데이터 테이블
// ---- 카테고리 불러오기 ----
async function getCategories() {
  // 데이터 로드
  const response = await aj.getCategories();
  const categoryList = response.data;
  // ui 추가
  $.each(categoryList, function (idx, category) {
    const opt = $('<option></option>');
    opt.attr('value', category.scheduleCategoryId);
    opt.text(category.categoryName);
    $('.category-select').append(opt);
  });
}
// ---- 카테고리 불러오기 End ----

// ---- 처음 데이터 불러오기 ----
async function getFirstSchedules() {
  // 테이블 비우기
  $('tbody').empty();
  page = 0;
  // 데이터 로드
  await getSchedules();
}
// ---- 데이터 불러오기 End ----

// ---- 데이터 불러오기 ----
async function getSchedules() {
  // 데이터 로드
  const response = await aj.getScheduleHistory(categoryId, keyword, page, size);
  const schedulesInfo = response.data;
  // ui 추가
  $.each(schedulesInfo.content, function (idx, schedule) { 
    const row = $(`
    <tr>
      <td><i class="${schedule.isGroup ? 'bi bi-people' : 'bi bi-person'}"></i></td>
      <td><p>${schedule.categoryName}</p></td>
      <td>${schedule.startDate}</td>
      <td>${schedule.name}</td>
      <td>${schedule.placeName? schedule.placeName : '장소 없음'}</td>
    </tr>
    `)

    row.find('p').css("background-color", schedule.color)

    row.click(function(e) {
      location.href = `/schedule/detail?scheduleId=${schedule.scheduleId}`
    })

    $('tbody').append(row);
  });
  // 마지막 페이지인지 기록
  $('.down-btn').css('display', schedulesInfo.last? 'none' : 'block')
  // isLast = schedulesInfo.last;
}
// ---- 데이터 불러오기 End ----
// 2. 데이터 테이블 End



// 3. 차트
// --- 원 그래프 데이터 가져오기 ----
async function getCircleData() {
  const year = today.getFullYear();
  const month = (today.getMonth() + 1).toString().padStart(2, '0');

  const response = await aj.getCategoryStatic(year, month, isGroup);
  const countData = response.data;
  
  const data = {
    labels: [],
    datasets: [
        {
          label: '전체 카테고리 통계',
          data: [],
          backgroundColor: [],
        }
    ]
  };

  $.each(countData, function (idx, category) { 
    data.labels.push(category.categoryName);
    data.datasets[0].data.push(category.scheduleCount);
    data.datasets[0].backgroundColor.push(category.color);
  });

  return data
}
// --- 원 그래프 데이터 가져오기 ---- 


// --- 막대 그래프 데이터 가져오기 ----
async function getBarData() {
  const year = today.getFullYear();

  const data = {
    labels: [1,2,3,4,5,6,7,8,9,10,11,12],
    datasets: [
      {
        label: '전체',
        data: new Array(12).fill(0),
        borderColor: '#4FD1C5',
        backgroundColor: '#4FD1C5',
        borderWidth: 2,
      },
      {
        label: '그룹',
        data: new Array(12).fill(0),
        borderColor: '#4FD1C5',
        backgroundColor: '#4FD1C5',
        borderWidth: 2,
      },
      {
        label: '개인',
        data: new Array(12).fill(0),
        borderColor: '#4FD1C5',
        backgroundColor: '#4FD1C5',
        borderWidth: 2,
      },
    ]
  };

  // 전체 일정
  const response1 = await aj.getMonthStatic(year);
  const countData1 = response1.data;

  $.each(countData1, function (idx, month) {
    const monthIdx = Number(month.month) - 1;
    data.datasets[0].data[monthIdx] = month.scheduleCount;
  });

  // 그룹 일정
  const response2 = await aj.getMonthStatic(year, true);
  const countData2 = response2.data;
  $.each(countData2, function (idx, month) { 
    const monthIdx = Number(month.month) - 1;
    data.datasets[0].data[monthIdx] = month.scheduleCount;
  });

  // 개인 일정
  const response3 = await aj.getMonthStatic(year, false);
  const countData3 = response3.data;
  $.each(countData3, function (idx, month) { 
    const monthIdx = Number(month.month) - 1;
    data.datasets[0].data[monthIdx] = month.scheduleCount;
  });

  return data
}
// --- 막대 그래프 데이터 가져오기 ---- 

// ---- 원 그래프 처음 보여주기 ----
async function showFirstCircleChart() {
  const barEl = $('#circle-chart > canvas');
  
  const data = await getCircleData();
  var myChart = new Chart(barEl, {
    type: 'doughnut',
    data: data,
    options: {
      responsive: true,
      plugins: {
        legend: {
          position: 'top',
        },
        title: {
          display: true,
          text: '카테고리별 일정 통계'
        }
      }
    },
  });

  return myChart;
}
// ---- 원 그래프 처음 보여주기 End ----

// ---- 막대 그래프 처음 보여주기 ----
async function showFirstBarChart() {
  const barEl = $('#bar-chart > canvas');
  
  const data = await getBarData();
  var myChart = new Chart(barEl, {
    type: 'bar',
    data: data,
    options: {
      responsive: true,
      plugins: {
        legend: {
          position: 'top',
        },
        title: {
          display: true,
          text: '월별 일정 통계'
        }
      }
    },
  });

  return myChart;
}
// ---- 막대 그래프 처음 보여주기 End ----
// ---- 원 그래프 End ----