// 내 정보 불러오기
export async function getMyInfo() {
  const response = await $.ajax({
    type: 'GET',
    url: '/api/member/me',
    dataType: 'json',
    contentType: 'application/json'
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  } 
  
  return response.data;
}


// 투표 상세 정보 불러오기
export async function getVotingDetail(scheduleID) {
  const response = await $.ajax({
    type: 'GET',
    url: '/api/voting/schedule/detail',
    dataType: 'json',
    contentType: 'application/json',
    data : {'scheduleId' : scheduleID}
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response.data;
}


// 투표 항목 추가하기
export async function postVotingItem(scheduleID, placeInfo) {
  const response = await $.ajax({
    type: 'POST',
    url: `/api/voting/schedule/place?scheduleId=${scheduleID}`,
    dataType: 'json',
    contentType: 'application/json',
    data : JSON.stringify(placeInfo)
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 투표하기
export async function doVote(placeToVoteId) {
  const response = await $.ajax({
    type: 'PUT',
    url: `/api/voting/schedule/place/toggle?placeToVoteId=${placeToVoteId}`,
    dataType: 'json',
    contentType: 'application/json',
    data : {'placeToVoteId': placeToVoteId}
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 일정 삭제하기
export async function deleteSchedule(id) {
  const response = await $.ajax({
    type: 'DELETE',
    url: `/api/schedule/personal?scheduleId=${id}`,
    dataType: 'json',
    contentType: 'application/json',
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 일정 나가기
export async function outSchedule(id) {
  const response = await $.ajax({
    type: 'DELETE',
    url: `/api/schedule/out?scheduleId=${id}`,
    dataType: 'json',
    contentType: 'application/json',
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 투표 일정 목록
export async function getVoteSchedules() {
  const response = await $.ajax({
    type: 'get',
    url: '/api/voting/schedule/list',
    dataType: 'json',
    contentType: 'application/json',
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
    return [];
  }

  return response.data;
}


// 예정 일정 목록
export async function getFutureSchedules() {
  const response = await $.ajax({
    type: 'get',
    url: '/api/schedule/future/list',
    dataType: 'json',
    contentType: 'application/json',
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
    return [];
  }

  return response.data;
}


// 일정 상세 보기
export async function getScheduleDetail(scheduleId) {
  const response = await $.ajax({
    type: 'GET',
    url: `/api/schedule/detail?scheduleId=${scheduleId}`,
    dataType: 'json',
    contentType: 'application/json',
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response.data;
}


// 출발 위치 이동
export async function updateDeparture(scheduleId, data) {
  const response = await $.ajax({
    type: 'PUT',
    url: `/api/voting/schedule/departure?scheduleId=${scheduleId}`,
    dataType: 'json',
    contentType: 'application/json',
    data : JSON.stringify(data)
  });
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 맴버 검색
export async function serachMember(data) {
  const response = await $.ajax({
    type: "GET",
    url: '/api/member/search',
    dataType: "json",
    contentType: "application/json",
    data: data,
  });
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 맴버 초대
export async function inviteMember(data) {
  const response = await $.ajax({
    type: "POST",
    url: '/api/schedule/invite',
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(data),
  });
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 맴버 초대
export async function getMemberInvite(email) {
  const response = await $.ajax({
    type: "GET",
    url: '/api/member/invite',
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(data),
  });
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 장소 투표 확정
export async function endVote(scheduleID) {
  const response = await $.ajax({
    type: "POST",
    url: `/api/voting/schedule/place/confirm?placeToVoteId=${scheduleID}`,
    dataType: "json",
    contentType: 'application/json',
  });
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 카테고리 불러오기
export async function getCategories() {
  const response = await $.ajax({
    type: "GET",
    dataType : 'json',
    contentType: 'application/json',
    url: "/api/schedule/category",
  });
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// 카테고리 불러오기
export async function getScheduleHistory(catogoryId, keyword, page, size) {
  const response = await $.ajax({
    type: "GET",
    dataType : 'json',
    contentType: 'application/json',
    url: `/api/schedule/past/list?categoryId=${catogoryId}&keyword=${keyword}&page=${page}&size=${size}`,
  });
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}



// 월별 통계불러오기
export async function getMonthStatic(year, isGroup) {
  const response = await $.ajax({
    type: "GET",
    dataType : 'json',
    contentType: 'application/json',
    url: `/api/stats/me/schedule`,
    data : {
      "year" : year,
      "isGroup" : isGroup
    }
  });
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}



// 카테고리별 통계불러오기
export async function getCategoryStatic(year, month, isGroup) {
  console.log(year, month)

  const response = await $.ajax({
    type: "GET",
    dataType : 'json',
    contentType: 'application/json',
    // url: `/api/stats/me/category?year=${year}?month=${month}`,
    url: `/api/stats/me/category`,
    data : {
      "month" : month,
      "year" : year,
      "isGroup" : isGroup
    }
  });

  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}