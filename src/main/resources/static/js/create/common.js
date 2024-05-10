
let date = new Date();
let year = date.getFullYear();
let month = date.getMonth();
 
const prenexIcons = document
    .querySelectorAll(".calendar-navigation span");
calendarDisplay();


// 함수 - 달력 표시
function calendarDisplay() {
	// 달력 비우기
	$(".calendar-dates").children().remove();

	// 기준 날짜 추출
	let dayone = new Date(year, month, 1).getDay();
	let lastdate = new Date(year, month + 1, 0).getDate();
	let dayend = new Date(year, month, lastdate).getDay();
	let monthlastdate = new Date(year, month, 0).getDate();

	// 달력에 넣을 엘리먼트 생성
	const dateList = [];

	for (let i = dayone; i > 0; i--) {
		const td = $("<td></td>");
		td.addClass("inactive");
		td.text(`${monthlastdate - i + 1}`);
		dateList.push(td);
	}

	for (let i = 1; i <= lastdate; i++) {
			let isToday = i === date.getDate()
					&& month === new Date().getMonth()
					&& year === new Date().getFullYear()
					? "active"
					: "";
			const td = $("<td></td>");
			td.addClass(`${isToday}`);
			td.text(`${i}`)
			dateList.push(td);
	}

	for (let i = dayend; i < 6; i++) {
		const td = $("<td></td>");
		td.addClass("inactive");
		td.text(`${i - dayend + 1}`);
		dateList.push(td);
	}
	
	// 달력에 날짜 엘리먼트 추가
	let count = 0;
	let tr = $("<tr></tr>")
	tr.addClass("calendar-row")
	$.each(dateList, function (index, el) {
		// 일요일 빨간색 표시, 토요일 파란색 표시
		if (count === 0 && !el.hasClass("inactive")) el.css("color", "tomato");
		else if (count === 6 && !el.hasClass("inactive")) el.css("color", "blueviolet");
		// 행에 날짜 추가
		tr.append(el)
		count++;
		// 7개의 날짜 엘리먼트를 추가한후 ul 초기화
		if (count === 7) {
			$(".calendar-dates").append(tr);
			tr = $("<tr></tr>");
			tr.addClass("calendar-row");
			count = 0;
		}
	});

	// 년월 표시
	$(".calendar-current-date").text(`${year}년 ${month+1}월`);
}
// 함수 - 달력 표시 End

 
// 이벤트 등록 - 달력 넘기기 
$.each($(".calendar-navigation span"), function(index, icon) {
	$(icon).click(function(e) {
		month = icon.id === "calendar-prev" ? month - 1 : month + 1;
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

// 이벤트 등록 - 데이트 피커(Jquery UI)
$( "#datepicker1" ).datepicker();
$( "#datepicker2" ).datepicker();
