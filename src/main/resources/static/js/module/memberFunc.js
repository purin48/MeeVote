export async function getMyInfo() {
  const response = await $.ajax({
    type: "GET",
    url: '/api/member/me',
    dataType: "json",
    contentType: "application/json"
  });
  
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  } 
  
  return response.data;
}

