
$("#alarmIcon").click(function () {
    let icon = $(this);
    let overlay = $(".overlay-container");

    // 아이콘의 클래스를 토글하여 색상을 변경합니다.
    icon.toggleClass("active-icon");

    // 오버레이를 표시하거나 숨깁니다.
    overlay.toggleClass("show-overlay");
});

$(".msg-overlay-bubble-list").ready(function() {
    // 페이지가 완전히 로드된 후에 알림을 띄우는 함수 실행
    showNotifications();
    // x 버튼 클릭 시 ...
    $(document).on('click', '.bi.bi-x-square',function(e) {
        e.stopPropagation(); // 이벤트 전파 중지
        let isRead = $(this).data('is-read');
        let notifyID = $(this).data('notify-id');

        if (isRead != true) {
            isRead = true;  // isRead 의 값이 false 인 경우, x 버튼을 누르면 true 로 바꾸기
        }

        $.ajax({
            type: 'PUT',
            url: '/api/notify/read',
            dataType: 'json',
            data: {
                notifyId: notifyID
            },
            success: function (response) {

                let $cardToRemove = $(document).find('[data-notify-id="' + notifyID + '"]').closest('.card-outer');
                $cardToRemove.remove();
            },
            error: function (xhr, status, error) {
            }
        })
    })

    $(document).on('click', '.card-outer', function() {
        // 클릭한 카드의 ID 가져오기
        let scheduleId = $(this).data('schedule-id');
        // // 클릭된 카드의 notifyCategoryId 가져오기
        let notifyCategoryId = $(this).data('notify-category-id');

        if (notifyCategoryId === 1) {  // 모임 일정 초대
            location.href = '/schedule/vote?scheduleId=' + scheduleId;
        } else if (notifyCategoryId === 2) {  // 모임 일정 장소 확정
            // 카드 상세 페이지로 이동
            location.href = '/schedule/detail?scheduleId=' + scheduleId;
        } else if (notifyCategoryId === 3) {  // 일정 예고
            // 카드 상세 페이지로 이동
            location.href = '/schedule/detail?scheduleId=' + scheduleId;
        }

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
            // 데이터 배열을 순회하면서 카드 생성
            cardData.forEach(function(card) {
                // 카드 생성 및 데이터 추가
                let $cardOuter = $('<div class="card-outer" data-schedule-id="' + card.scheduleId + '" data-notify-category-id="' + card.notifyCategoryId + '"></div>');

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
                let startTime = dateTimeArray[1]; // "HH:mm:ss"
                let startTimeArray = startTime.split(":");
                let startTimewithoutSec = startTimeArray[0] + ":" + startTimeArray[1];

                // 메세지 가공
                let fullMessage = card.message;
                let fullMessageArray = fullMessage.split(".");
                let message1 = fullMessageArray[0];
                let message2 = fullMessageArray[1];
                if(message2 === null) {
                    $cardName.append(fullMessage);
                } else {
                    $cardName.append(message1 + "<br>" + message2);
                }


                // 데이터 추가
               // $cardName.append(card.message);
                $cardMain1.append("<h3 style='font-weight: bold; font-size: 15px;'>" + card.name + "</h3>");
                //$cardMain2.append('<p><i class="bi bi-calendar-check"> </i>' + startDate + '</p>');
                $cardMain3.append('<p style="font-size: 12px;"><i class="bi bi-calendar-check" style="margin-top: 16px;"> </i>' + startDate + '</p>');
                $cardMain3.append('<p style="font-size: 12px;"><i class="bi bi-clock" style="margin-top: 16px;"> </i>' + startTimewithoutSec + '</p>');
                $cardMain1.append('<p style="font-size: 20px;"><i class="bi bi-x-square" style="margin-top: 16px; color: #000000" data-is-read="' + card.isRead + '" data-notify-id="' + card.notifyId + '"></i>' + '</p>');


                // 카드를 화면에 추가합니다.
                $cardOuter.append($cardName);
                $cardOuter.append($cardMain);
                $cardMain.append($cardMain1);
                $cardMain.append($cardMain2);
                $cardMain.append($cardMain3);
                $(".msg-overlay-bubble-list").append($cardOuter);

                // if (card.placeName === null) {
                //     $cardMain2.append('<p style="font-size: 12px;"><i class="bi bi-geo-alt" style="margin-top: 16px;"> </i>' + '투표중' + '</p>')
                // } else {
                //     $cardMain2.append('<p style="font-size: 12px;"><i class="bi bi-geo-alt" style="margin-top: 16px;"> </i>' + card.placeName + '</p>')
                // }

                if (card.voteDeadline === null) {  // 투표 마감일 X = 개인 일정
                    $cardMain2.append("");
                } else if (card.voteDeadline < today) {  // 투표 마감일 지남
                    //$cardMain3.append("<p style='margin-top: 16px;'>" + "투표 마감</p>");
                    $cardMain2.append(card.placeName);
                } else { // 투표 마감일 전 (투표중)
                    let deadline = card.voteDeadline;
                    let deadlineArray = deadline.split(" ");
                    let deadlineDate = deadlineArray[0];
                    let deadlineDateArray = deadlineDate.split("-");
                    let deadlineYear = deadlineDateArray[0];
                    let deadlineMonth = deadlineDateArray[1];
                    let deadlineDay = deadlineDateArray[2];
                    $cardMain2.append("<p style='font-size: 12px;'><i class=\"bi bi-geo-alt\" style=\"margin-top: 16px;\"> </i>" + deadlineMonth + "/" + deadlineDay + " 투표 마감</p>");
                }

                $cardMain2.append(
                    '<p class="highlight-category" style="background-color: ' +
                    card.color +  // 카테고리에 해당하는 색상을 가져옵니다.
                    '; border-radius: 5px; padding: 2px 4px; font-size: 12px; color: #ffffff">' +
                    card.scheduleCategoryName +
                    "</p>"
                );

                // if(card.isRead === true) {
                //     $('.card-outer').hide();
                // }

            });
        },
        error: function(xhr, status, error) {
            // 데이터 받아오지 못할 경우 예외 처리
        }
    });
};

