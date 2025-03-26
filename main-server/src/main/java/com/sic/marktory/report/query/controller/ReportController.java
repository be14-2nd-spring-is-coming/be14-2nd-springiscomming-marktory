package com.sic.marktory.report.query.controller;

import com.sic.marktory.report.query.dto.ReportDTO;
import com.sic.marktory.report.query.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 조회 API
// 사용자가 /report/all 요청 보내면 받아서 service로
@Tag(name = "Report Query", description = "신고 조회, 피신고자 조회 ")
@Slf4j
@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // 신고 테이블 전체 조회
    @Operation(
            summary = "신고 전체 조회",
            description = """
        신고 테이블에 등록된 모든 신고 내역을 조회합니다.
        - 운영자 또는 관리자 권한에서 사용될 수 있는 API입니다.
        - 모든 신고 데이터를 리스트 형태로 반환합니다.
        """
    )
    @GetMapping("/reports/all")
    public List<ReportDTO> getAllReports() {
        return reportService.findAllReports();
    }

    // 해당하는 신고 ? 로 이동하여 작성자 id 조회 (어떤 type의 신고인지 따라 동적 쿼리 발생)
    @Operation(
            summary = "피신고자 조회",
            description = """
        신고 유형(type)에 따라 피신고자의 ID 목록을 조회합니다.
        - `type` 파라미터는 필수이며, 신고 대상의 종류(게시글, 댓글 등)를 지정합니다.
        - 내부적으로 type에 따라 동적 쿼리를 수행하여, 신고당한 작성자 정보를 가져옵니다.
        - 예: `/api/report/reportedWriterId?type=post`
        """
    )
    @GetMapping("/reportedWriterId")
    public List<ReportDTO> getReportedWriterId(@RequestParam(value = "type", required = true) String type) {
        log.info("getReportedWriterId type : {}", type);

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type is null");
        }
        return reportService.findReportedWriterId(type);
    }
}
