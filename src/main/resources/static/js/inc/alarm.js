
$("#alarmIcon").click(function () {
    let icon = $(this);
    let overlay = $(".overlay-container");

    // 아이콘의 클래스를 토글하여 색상을 변경합니다.
    icon.toggleClass("active-icon");

    // 오버레이를 표시하거나 숨깁니다.
    overlay.toggleClass("show-overlay");
});

$(document).ready(function() {
    // 페이지가 완전히 로드된 후에 알림을 띄우는 함수 실행
    showNotifications();

    $(document).on('click', '.card-outer', function() {
        // 클릭한 카드의 ID 가져오기
        let cardId = $(this).data('card-id');
        //let notiCateId = $(this).data('notify-category-id');
        console.log(cardId)
        //console.log(notiCateId)
        window.location.href = '/schedule/detail';

        // if (cardID === 1) {
        //
        // } else if (cardID === 2) {
        //     // 카드 상세 페이지로 이동
        //     window.location.href = '/schedule/vote';
        // } else {
        //     // 카드 상세 페이지로 이동
        //     window.location.href = '/schedule/detail';
        // }
        //
        // // 카드 상세 페이지로 이동
        // window.location.href = '/detail/' + cardId;
    });
});

// 알림을 띄우는 함수
function showNotifications() {
    // ajax 요청
    $.ajax({
        type: 'GET',
        url: '/api/notify/list',
        dataType: 'json',
        data: {},
        success: function(response) {
            // 데이터 성공적으로 받아오면 실행되는 함수
            let cardData = response.data;  // 데이터 배열
            console.log(response.data)
            // 데이터 배열을 순회하면서 카드 생성
            cardData.forEach(function(card) {
                console.log(card.voteDeadline)
                // 카드 생성 및 데이터 추가
                let $cardOuter = $('<div class = "card-outer" data-card-id="{{card.scheduleId}}"></div>');
                let $cardName = $('<div class = "card-name"></div>');
                let $cardMain = $('<div class = "card-main"></div>');
                let $cardMain1 = $('<div class = "card-main-1"></div>');
                let $cardMain2 = $('<div class = "card-main-2"></div>');
                let $cardMain3 = $('<div class = "card-main-3"></div>');

                // 오늘 날짜 가져오기 (deadline과의 비교용)
                let today = new Date();

                // 날짜, 시간 데이터 가공
                let dateTime = card.startDate;
                let dateTimeArray = dateTime.split(" ");
                let startDate = dateTimeArray[0]; // "YYYY-MM-DD"
                let startTime = dateTimeArray[1]; // "HH:mm"

                let deadline = card.voteDeadline;
                let deadlineArray = deadline.split(" ")
                let deadlineDate = deadlineArray[0];

                // 데이터 추가
                $cardName.append(card.message);
                $cardMain1.append("<h3 style='margin-top: 5px; font-weight: bold;'>" + card.name + "</h3>");
                //$cardMain2.append('<p><i class="bi bi-calendar-check"> </i>' + startDate + '</p>');
                $cardMain2.append('<p style="margin-top: 16px;"><i class="bi bi-calendar-check" style="margin-top: 16px;"> </i>' + startDate + '</p>');
                $cardMain2.append('<p style="margin-top: 16px;"><i class="bi bi-clock" style="margin-top: 16px;"> </i>' + startTime + '</p>');
                // $cardMain3.append("<p>" + card.voteDeadline + "투표 마감</p>");

                // 카드를 화면에 추가합니다.
                $cardOuter.append($cardName);
                $cardOuter.append($cardMain);
                $cardMain.append($cardMain1);
                $cardMain.append($cardMain2);
                $cardMain.append($cardMain3);
                $(".msg-overlay-bubble-list").append($cardOuter);

                if (card.placeName === null) {
                    $cardMain3.append('<p style="margin-top: 16px;"><i class="bi bi-geo-alt" style="margin-top: 16px;"> </i>' + '투표중' + '</p>')
                } else {
                    $cardMain3.append('<p style="margin-top: 16px;"><i class="bi bi-geo-alt" style="margin-top: 16px;"> </i>' + card.placeName + '</p>')
                }

                if (card.voteDeadline === null) {  // 투표 마감일 X = 개인 일정
                    $cardMain3.append("");
                } else if (card.voteDeadline < today) {  // 투표 마감일 지남
                    //$cardMain3.append("<p style='margin-top: 16px;'>" + "투표 마감</p>");
                    $cardMain3.append("");
                } else {  // 투표 마감일 전
                    $cardMain3.append("<p style='margin-top: 16px;'>" + deadlineDate + "투표 마감</p>");
                }

                $cardMain1.append(
                    '<p class="highlight-category" style="background-color: ' +
                    card.color +  // 카테고리에 해당하는 색상을 가져옵니다.
                    '; border-radius: 5px; padding: 3px 6px; margin-top: 8px;">' +
                    card.scheduleCategoryName +
                    "</p>"
                );


                // if (card.start === "투표중" && card.loc === "미정") {
                //     $cardName.append("새로운 투표가 등록되었습니다");
                // } else if (card.loc === "투표중") {
                //     $cardName.append("장소 투표를 진행 중입니다.");
                // } else if (
                //     (card.start != "투표중" && card.loc != "미정") ||
                //     (card.start != "투표중" && card.loc != "미정" && card.loc != "투표중")
                // ) {
                //     $cardName.append("일정이 확정되었습니다.");
                // }
                //
                // $cardMain1.append("<h3>" + card.title + "</h3>");
                // $cardMain3.append(
                //     '<p><i class="bi bi-geo-alt"> </i>' + card.loc + "</p>"
                // );
                //
                // $cardMain1.append(
                //     '<p class="highlight-category" style="background-color: ' +
                //     categoryColor[0][card.category] +  // 카테고리에 해당하는 색상을 가져옵니다.
                //     '; border-radius: 5px; padding: 3px 6px;">' +
                //     card.category +
                //     "</p>"
                // );
                //
                // $cardMain2.append(
                //     '<p><i class="bi bi-calendar-check"> </i>' + card.startDate + "</p>"
                // );
                // $cardMain2.append(
                //     '<p><i class="bi bi-clock"> </i>' + card.startTime + "</p>"
                // );
                // $cardMain3.append("<p>"+card.voteEnd + "투표 마감</p>");
            });
        },
        error: function(xhr, status, error) {
            // 데이터 받아오지 못할 경우 예외 처리
            console.error("Error: ", error);
        }
    });
};

