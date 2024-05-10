$(document).ready(function() {
    // 오늘 날짜 가져오기
    let today = new Date();
    let dd = String(today.getDate()).padStart(2, '0');
    let mm = String(today.getMonth() + 1).padStart(2, '0'); // 0부터 시작하기 때문에 1을 더해줍니다.
    let yyyy = today.getFullYear();

    today = yyyy + '-' + mm + '-' + dd;

    // tit_date 요소에 오늘 날짜 표시
    $('.tit_date').text(today);

    // 캘린더 div 참조
    let calendarEl = document.getElementById('calendar');

    let events = [
        {
            title : ' tomcat 뿌시기',
            start: '2024-05-01T08:30:00',
            allDay: false,
            category: 'category1', // 카테고리 정보 추가
            propA: '일정상세정보...'
        },
        {
            title : ' spring 뿌시기',
            start: '2024-05-12T08:30:00',
            end: '2024-05-14T16:00:00',
            category: 'category2',
            propA: '일정상세정보...'
        },
        {
            title : ' jquery 뿌시기',
            start: '2024-05-16T16:00:00',
            allDay: false,
            category: 'category3',
            propA: '일정상세정보...'
        },
        // 카테고리별로 추가적인 일정 정보를 배열에 추가 가능
        {
            title : ' sql developer 뿌시기',
            start: '2024-05-16T17:35:00',
            allDay: false,
            category: 'category2',
            propA: '일정상세정보...'
        },
        {
            title : ' 맛집 탐방',
            start: '2024-05-21T11:45:00',
            allDay: false,
            category: 'category1',
            propA: '일정상세정보...'
        },
        {
            title : ' 공원 나들이',
            start: '2024-05-16T11:45:00',
            allDay: false,
            category: 'category1',
            propA: '일정상세정보...'
        },
        {
            title : ' 한강 나들이',
            start: '2024-05-21T08:45:00',
            allDay: false,
            category: 'category2',
            propA: '일정상세정보...'
        },
        {
            title: ' 밥약',
            start: '2024-05-16T18:45:00',
            allDay: false,
            category: 'category2',
            propA: '일정상세정보...'
        }
    ]

    let calendar = new FullCalendar.Calendar(calendarEl, {
        timeZone: 'UTC',
        themeSystem: 'bootstrap5',
        initialView: 'dayGridMonth',
        // contentHeight: 600,
        editable: true,  //  드래그해서 수정 가능한지, 길게 확장도 가능
        selectable: true,
        navLinks: true,  //  요일이랑 날짜 클릭 시 일이나 주단위 보여주는 화면으로 넘어감
        select: function(info) {
            // 클릭한 날짜 정보를 콘솔에 출력
            // console.log('Clicked date:', info.start);
            // -> 확인용 코드
            console.log(info);
            // 클릭한 날짜에 해당하는 일정 가져오기
            let selectedDate = info.start;
            let selectedEvents = getEventsForDate(selectedDate);

            // console.log(selectedEvents)
            // 가져온 일정을 리스트 형식으로 보여주기
            showEventsList(selectedEvents);

            // 클릭한 날짜를 tit_date에 표시
            let clickedDate = selectedDate.toISOString().slice(0, 10); // YYYY-MM-DD 형식으로 변환
            $('.tit_date').text(clickedDate);
        },

        headerToolbar: {
            left: 'prev,next',
            center: 'title',
            right: 'today'
        },

        initialDate: today, // 달력 처음 로드될 때 표시되는 날짜, default 는 현재 날짜
        editable: false,
        dayMaxEvents: true, // +more 표시 전 최대 이벤트 갯수, true는 셀 높이에 의해 결정
        eventLimit: true,
        events: events.map(function(event) {
            return {
                title: event.title,
                start: event.start,
                backgroundColor: getCategoryColor(event.category),
                textColor: "#ffffff"
            };
        }),
    });

    calendar.render();

    $('#myDropdownButton').click(function() {
        $('#customDropdownMenu').toggleClass('show');
    });

    $('.dropdown-item').click(function() {
        let text = $(this).text();
        console.log(text + ' clicked');
        hideDropdownMenu();
        $('#myDropdownButton').text(text);
    });

    function hideDropdownMenu() {
        $('#customDropdownMenu').removeClass('show');
    }



    // dropdown 버튼 클릭 시 메뉴 토글
    $('#dropdownMenuButton1').click(function() {
        $('#customDropdownMenu').toggleClass('show');
    });

    // 각 dropdown 아이템 클릭 시 처리
    $('.dropdown-item').click(function() {
        var text = $(this).text();
        console.log(text + ' clicked');
        hideDropdownMenu();
        // dropdown button의 텍스트 변경
        $('#customDropdownButton').text(text);
    });


    // 클릭한 날짜에 해당하는 일정을 가져오는 함수
    function getEventsForDate(date) {
        // 클릭한 날짜에 해당하는 일정 데이터를 필터링하여 반환

        return events.filter(event => new Date(event.start).toDateString() === date.toDateString());
    }

    // 클릭한 날짜에 해당하는 일정을 리스트 형식으로 보여주는 함수
    function showEventsList(events) {
        // 우측 사이드바에 있는 일정 목록을 참조
        let sidebar = $('.area_agenda_info');

        // 기존에 있는 일정 목록을 초기화
        sidebar.empty();

        // 가져온 일정 데이터를 리스트 형식으로 추가
        let ul = $('<ul>').addClass('events-list');

        events.forEach(event => {
            let li = $('<li>');


            let dateTimeArray = event.start.split('T');
            let date = dateTimeArray[0]; // 날짜 부분
            let full_time = dateTimeArray[1]; // 시간 부분  00:00:00


            let TimeArray = full_time.split(':');
            let hour = TimeArray[0];
            let min = TimeArray[1];


            li.html(`${hour}:${min} ${event.title} <br> ${event.propA}`);


            // 일정에 해당하는 카테고리의 색상 적용
            // li.css('background-color', getCategoryColor(event.category));
            li.css('border-left', '4px solid ' + getCategoryColor(event.category));
            ul.css('padding', '0 0 0 4px ');

            console.log(li)
            $(ul).append(li);

            // 클릭 이벤트 추가
            li.on('click', function() {
                // 클릭한 날짜에 해당하는 캘린더 이벤트 선택
                calendar.select(event.start);
                // calendar.select(event.end);

            });
        });

        // 리스트를 우측 사이드바에 추가
        sidebar.append(ul);
    }

    // 이벤트 시작일을 포맷하는 함수
    function formatDateTime(date) {
        let hours = date.getHours().toString().padStart(2, '0'); // 시간
        let minutes = date.getMinutes().toString().padStart(2, '0'); // 분
        return hours + ':' + minutes;
    }

    // dropdown 메뉴 숨기는 함수
    function hideDropdownMenu() {
        $('#customDropdownMenu').removeClass('show');
    }

    // 각 카테고리에 대한 색상 반환
    function getCategoryColor(category) {
        switch (category) {
            case 'category1':
                return "rgb(71, 147, 175)";
            case 'category2':
                return "rgb(255, 196, 112)"
            case 'category3':
                return "rgb(221, 87, 70)"
            case 'category4':
                return "rgb(139, 50, 44)"
        }
    }

});
