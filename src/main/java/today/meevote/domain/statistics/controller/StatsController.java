package today.meevote.domain.statistics.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import today.meevote.domain.statistics.dto.response.GetMyCategoryStatsDto;
import today.meevote.domain.statistics.dto.response.GetMyScheduleStatsDto;
import today.meevote.domain.statistics.service.StatsService;
import today.meevote.response.DataResponse;
import today.meevote.response.SuccessInfo;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "통계 API 명세서")
@RequestMapping("/api/stats")
@Validated
public class StatsController {

    private final StatsService statsService;
    @Operation(summary = "카테고리 통계 조회")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
            content = @Content(examples = {
                    @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
                    @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
                    @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
            }))
    @GetMapping("/me/category")
    public DataResponse<List<GetMyCategoryStatsDto>> getMyCategoryStats(
            @RequestParam(required = false)
            Boolean isGroup,

            @Schema(description = "년도", defaultValue = "2024")
            @NotBlank(message = "년도를 입력해주세요.")
            @Pattern(regexp = "^[1-9]\\d{3}$", message = "올바른 년도 형식이 아닙니다.")
            String year,

            @Schema(description = "월", defaultValue = "05")
            @NotBlank(message = "월을 입력해주세요.")
            @Pattern(regexp = "^(0[1-9]|1[0-2])$", message = "올바른 월 형식이 아닙니다.")
            String month){

        return new DataResponse(SuccessInfo.GET_MY_CATEGORY_STATS,
                statsService.getMyCategoryStats(isGroup, year, month));
    }


    @Operation(summary = "일정 통계 조회")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
            content = @Content(examples = {
                    @ExampleObject(name = "존재하지 않는 카테고리", value = "{\"isSuccess\": false, \"code\": \"S01\", \"message\": \"존재하지않는 카테고리입니다.\"}"),
                    @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
                    @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
                    @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
            }))
    @GetMapping("/me/schedule")
    public DataResponse<List<GetMyScheduleStatsDto>> getMyScheduleStats(
            @RequestParam(required = false)
            Boolean isGroup,

            @RequestParam(required = false)
            Long categoryId,

            @Schema(description = "년도", defaultValue = "2024")
            @NotBlank(message = "년도를 입력해주세요.")
            @Pattern(regexp = "^[1-9]\\d{3}$", message = "올바른 년도 형식이 아닙니다.")
            String year){

        return new DataResponse(SuccessInfo.GET_MY_SCHEDULE_STATS,
                statsService.getMyScheduleStats(isGroup, categoryId, year));
    }

}
