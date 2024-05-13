import {getVoteSchedules, getFutureSchedules} from '/js/module/ajax.js';

const voteList = await getVoteSchedules();
const futureList = await getFutureSchedules();
const voteCount = voteList.length;
const futureCount = futureList.length;

// 캐러셀
// ---- 왼쪽 사이드 캐러셀 ----
let leftSlid = 0;

function showLeftSlide(slideIndex) {
  $('.voting-container .carousel_wrapper').css('transform', `translateX(-${slideIndex * 330}px)`)
  leftSlid = slideIndex;
}

$('.voting-container .carousel_prev').click(function(e) {
  if (leftSlid > 0) showLeftSlide(leftSlid - 1);
})

$('.voting-container .carousel_next').click(function(e) {
  if (leftSlid < voteCount-1) showLeftSlide(leftSlid + 1);
})

showLeftSlide(0);
// ---- 왼쪽 사이드 캐러셀 End ----

// ---- 오른쪽 사이드 캐러셀 ----
let rightSlide = 0;

function showRightSlide(slideIndex) {
  $('.future-container .carousel_wrapper').css('transform', `translateX(-${slideIndex * 330}px)`)
  rightSlide = slideIndex;
}

$('.future-container .carousel_prev').click(function(e) {
  if (rightSlide > 0) showRightSlide(rightSlide - 1);
})

$('.future-container .carousel_next').click(function(e) {
  if (rightSlide < voteCount-1) showRightSlide(rightSlide + 1);
})

showRightSlide(0);
// ---- 오른쪽 사이드 캐러셀 End ----



// 캐러셀 아이템
// ---- 캐러셀 추가 함수 ----
function createCarousel(schedule, isVoting) {
  let place;
  if (isVoting) place = '투표 중!';
  else if (!schedule.placeName) place = "장소 정보 없음"
  else place = schedule.placeName;

  const carousel = $(
    `
    <div class="carousel">
      <div class="carousel-head">
        <span class="name">${schedule.name}</span>
      </div>
      <div class="carousel-content">
        <div class="date">
          <i class="bi bi-calendar2-minus"></i>
          <span>${isVoting? schedule.voteDeadline + " 마감" : schedule.startDate}</span>
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
    location.href = `/${isVoting? 'vote':'detail'}?scheduleId=${schedule.scheduleId}`
  })

  return carousel;
}
// ---- 캐러셀 추가 함수 End ----

// ---- 투표 중인 항목 캐러셀에 추가 ----
$.each(voteList, function (idx, item) { 
  const carousel = createCarousel(item, true);
  $('.voting-container .carousel_wrapper').append(carousel);
  console.log(carousel)
});

$.each(futureList, function (idx, item) { 
  const carousel = createCarousel(item, false);
  $('.future-container .carousel_wrapper').append(carousel);
});
// ---- 투표 중인 항목 캐러셀에 추가 End ----