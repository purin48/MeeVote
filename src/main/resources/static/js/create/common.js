
let date = new Date();
let year = date.getFullYear();
let month = date.getMonth();
 
const day = document.querySelector(".calendar-dates");
 
const prenexIcons = document
    .querySelectorAll(".calendar-navigation span");
 
const manipulate = () => {
	// 기준 날짜 추출
	let dayone = new Date(year, month, 1).getDay();
	let lastdate = new Date(year, month + 1, 0).getDate();
	let dayend = new Date(year, month, lastdate).getDay();
	let monthlastdate = new Date(year, month, 0).getDate();

	// 달력에 넣을 엘리먼트 생성
	const dateList = [];

	for (let i = dayone; i > 0; i--) {
		const li = $('<li></li>');
		li.addClass('inactive');
		li.text(`${monthlastdate - i + 1}`);
		dateList.push(li);
	}

	for (let i = 1; i <= lastdate; i++) {
			let isToday = i === date.getDate()
					&& month === new Date().getMonth()
					&& year === new Date().getFullYear()
					? "active"
					: "";
			const li = $('<li></li>');
			li.addClass(`${isToday}`);
			li.text(`${i}`)
			dateList.push(li);
	}

	for (let i = dayend; i < 6; i++) {
		const li = $('<li></li>');
		li.addClass('inactive');
		li.text(`${i - dayend + 1}`);
		dateList.push(li);
	}
	
	// 달력에 날짜 엘리먼트 추가
	let count = 0;
	const ul = $('<ul></ul>')
	$.each(dateList, function (index, el) {
		// 7개의 날짜 엘리먼트를 추가한후 ul 초기화
		if (count === 7) {
			$('.calendar-body').append(ul);
			ul = $('<ul></ul>')
			count = 0;
		}
		// 일요일 빨간색 표시, 토요일 파란색 표시
		if (count === 0) el.css('color', 'red');
		else if (count === 6) el.css('color', 'blue');
		ul.append(el)
		count++;
		console.log(el.text())
	});

	// 년월 표시
	$('.calendar-current-date').text(`${year}년 ${month+1}월`)
}
 
manipulate();
 

prenexIcons.forEach(icon => {
 
    icon.addEventListener("click", () => {
 
        // Check if the icon is "calendar-prev"
        // or "calendar-next"
        month = icon.id === "calendar-prev" ? month - 1 : month + 1;
 
        // Check if the month is out of range
        if (month < 0 || month > 11) {
 
            // Set the date to the first day of the 
            // month with the new year
            date = new Date(year, month, new Date().getDate());
 
            // Set the year to the new year
            year = date.getFullYear();
 
            // Set the month to the new month
            month = date.getMonth();
        }
 
        else {
 
            // Set the date to the current date
            date = new Date();
        }
 
        // Call the manipulate function to 
        // update the calendar display
        manipulate();
    });
});