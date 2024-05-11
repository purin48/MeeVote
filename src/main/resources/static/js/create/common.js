// 달력 관련 변수
let date = new Date();
let year = date.getFullYear();
let month = date.getMonth();
let startDate = new Date();;
let endDate = new Date();
let isAllDay = false;

// 함수
// ---- 함수 : 달력 표시----
function calendarDisplay() {
	// 달력 비우기
	$('.calendar-dates').children().remove();

	// 기준 날짜 추출
	let dayone = new Date(year, month, 1).getDay();
	let lastdate = new Date(year, month + 1, 0).getDate();
	let dayend = new Date(year, month, lastdate).getDay();
	let monthlastdate = new Date(year, month, 0).getDate();

	// 달력에 넣을 엘리먼트 생성
	const dateList = [];

	for (let i = dayone; i > 0; i--) {
		const td = $('<td></td>');
		td.addClass('inactive');
		td.text(`${monthlastdate - i + 1}`);
		dateList.push(td);
	}

	for (let i = 1; i <= lastdate; i++) {
		const td = $('<td></td>');
		td.text(`${i}`)
		// 시작 날짜와 종료 날짜 그리고 그 사이 날짜 표시
		const calendarDate = new Date(`${year}-${month+1}-${i}`);
		if (i === startDate.getDate() && month === startDate.getMonth() && year === startDate.getFullYear()) {
			td.addClass('start-date-calendar');
		} 
		if ((i === endDate.getDate() && month === endDate.getMonth() && year === endDate.getFullYear())) {
			td.addClass('end-date-calendar');
		} 
		if (calendarDate > startDate && calendarDate < endDate ) {
			td.addClass('between-date-calendar');
		}
		dateList.push(td);
	}

	for (let i = dayend; i < 6; i++) {
		const td = $('<td></td>');
		td.addClass('inactive');
		td.text(`${i - dayend + 1}`);
		dateList.push(td);
	}
	
	// 달력에 날짜 엘리먼트 추가
	let count = 0;
	let tr = $('<tr></tr>')
	tr.addClass('calendar-row')
	$.each(dateList, function (index, el) {
		// 일요일 빨간색 표시, 토요일 파란색 표시
		if (count === 0 && !el.hasClass('inactive')) el.css('color', 'tomato');
		else if (count === 6 && !el.hasClass('inactive')) el.css('color', 'blueviolet');
		// 행에 날짜 추가
		tr.append(el)
		count++;
		// 7개의 날짜 엘리먼트를 추가한후 ul 초기화
		if (count === 7) {
			$('.calendar-dates').append(tr);
			tr = $('<tr></tr>');
			tr.addClass('calendar-row');
			count = 0;
		}
	});

	// 년월 표시
	$('.calendar-current-date').text(`${year}년 ${month+1}월`);
}
// ---- 함수 : 달력 표시 End ----

// ---- 함수 : 입력값 날짜 동기화 ----
function inputToDate(selector, selectDate) {
	let inputDate = new Date($(selector).val());
	selectDate.setFullYear(inputDate.getFullYear());
	selectDate.setMonth(inputDate.getMonth());
	selectDate.setDate(inputDate.getDate());
}

function dateToInput(selector, selectDate) {
	const y = selectDate.getFullYear();
	const m = ('0' + (selectDate.getMonth() + 1)).slice(-2);
	const d = ('0' + selectDate.getDate()).slice(-2);
	$(selector).val(`${y}-${m}-${d}`);
}

function inputToTime(selector, selectDate) {
	let inputTime = $(selector).val().split(':');
	selectDate.setHours(inputTime[0]);
	selectDate.setMinutes(inputTime[1]);
}

function timeToInput(selector, selectDate) {
	const h = ('0' + (selectDate.getHours())).slice(-2);
	const mm = ('0' + (selectDate.getMinutes())).slice(-2);
	$(selector).val(`${h}:${mm}`);
}
// ---- 함수 : 입력값 날짜 동기화 End ----

// ---- 함수 : 종료 날짜를 시작날짜 자정으로 맞추기 ----
function allDaySync() {
	endDate = new Date(startDate);
	endDate.setHours('23');
	endDate.setMinutes('59');
	console.log(endDate)
	dateToInput('#end-date', endDate);
	timeToInput('#end-time', endDate);
}
// ---- 함수 : 종료 날짜를 시작날짜 자정으로 맞추기 End ----

 
// 이벤트 등록
// ---- 이벤트 등록 : 달력 넘기기 ----
$.each($('.calendar-navigation span'), function(index, icon) {
	$(icon).click(function(e) {
		month = icon.id === 'calendar-prev' ? month - 1 : month + 1;
		if (month < 0 || month > 11) {
				date = new Date(year, month, new Date().getDate());
				year = date.getFullYear();
				month = date.getMonth();
		}
		else {
				date = new Date();
		}
		calendarDisplay();
	})
})
// ---- 이벤트 등록 : 달력 넘기기 End ----

// ---- 이벤트 등록 : 날짜 및 시간 등록 ----
$('#start-date').change(function (e) {
	inputToDate(this, startDate);
	// 시작 날짜가 종료 날짜보다 크면 종료 날짜 자동 조정
	if (isAllDay) {
		allDaySync();
	}
	else if (startDate > endDate) {
		endDate = new Date(startDate);
		dateToInput('#end-date', endDate);
		timeToInput('#end-time', endDate);
	}
	calendarDisplay();
});

$('#start-time').change(function (e) {
	inputToTime(this, startDate);
	console.log(startDate)
	// 시작 날짜 종료 날짜보다 크면 종료 날짜 자동 조정
	if (startDate > endDate) {
		endDate = new Date(startDate);
		dateToInput('#end-date', endDate);
		timeToInput('#end-time', endDate);
	}
	calendarDisplay();
});

$('#end-date').change(function (e) {
	inputToDate(this, endDate);
	// 시작 날짜가 종료 날짜보다 크면 시작 날짜 자동 조정
	if (startDate > endDate) {
		startDate = new Date(endDate);
		dateToInput('#start-date', startDate);
		timeToInput('#start-time', startDate);
	}
	calendarDisplay();
});

$('#end-time').change(function (e) {
	inputToTime(this, endDate);
	// 시작 날짜가 종료 날짜보다 크면 시작 날짜 자동 조정
	if (startDate > endDate) {
		startDate = new Date(endDate);
		dateToInput('#start-date', startDate);
		timeToInput('#start-time', startDate);
	}
	calendarDisplay();
});
// ---- 이벤트 등록 : 날짜 및 시간 등록 End ----

// ---- 이벤트 등록 : 하루 종일 체크 ----
$('#allday-check').change(function(e) {
	isAllDay = $(this).is(':checked')
	$('#end-date').attr('disabled', isAllDay);
	$('#end-time').attr('disabled', isAllDay);
	if(isAllDay) {
		allDaySync();
	}
})
// ---- 이벤트 등록 : 하루 종일 체크 End----


// 시작 이벤트
// ---- 디폴트 일정 날짜 등록 ----
startDate.setHours(startDate.getHours() + 1); // 시작 시간은 현재 + 1시간
dateToInput('#start-date', startDate);
timeToInput('#start-time', startDate);
endDate.setHours(endDate.getHours() + 2);  // 종료 시간은 현재 + 1시간
dateToInput('#end-date', endDate);
timeToInput('#end-time', endDate);
// ---- 디폴트 일정 날짜 등록 End ----

calendarDisplay();