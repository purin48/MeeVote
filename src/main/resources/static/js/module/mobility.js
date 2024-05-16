const kakaoAPI = 	'782ddcea4d38ba4c585152a42fb4bf3b';

// ---- 경로 정보 받아오기 ----
export async function getRoute(origin, destination) {
  const result = await $.ajax({
    type: "GET",
    url: "https://apis-navi.kakaomobility.com/v1/directions",
    headers: {
      "Authorization": `KakaoAK ${kakaoAPI}`
    },
    data: {origin: origin, destination: destination},
    dataType: "json",
    contentType: "application/json",
  });

  return result;
}
// ---- 경로 정보 받아오기 End ----


// ---- 경로 정보 받아오기 ----
export async function getMultiRoutes(origins, destination) {
  const data = {
    origins: origins, 
    destination: destination, 
    radius: 100000
  };
  const result = await $.ajax({
    type: "POST",
    url: "https://apis-navi.kakaomobility.com/v1/origins/directions",
    headers: {
      "Authorization": `KakaoAK ${kakaoAPI}`
    },
    dataType: "json",
    data: JSON.stringify(data),
    contentType: "application/json",
  });

  return result;
}
// ---- 경로 정보 받아오기 End ----