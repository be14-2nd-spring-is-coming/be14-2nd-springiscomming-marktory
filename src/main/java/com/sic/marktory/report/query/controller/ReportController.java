package com.sic.marktory.report.query.controller;

import com.sic.marktory.report.query.dto.ReportDTO;
import com.sic.marktory.report.query.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 조회 API
// 사용자가 /report/all 요청 보내면 받아서 service로
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
    @GetMapping("/reports/all")
    public List<ReportDTO> getAllReports() {
        return reportService.findAllReports();
    }

    // 해당하는 신고 ? 로 이동하여 작성자 id 조회 (어떤 type의 신고인지 따라 동적 쿼리 발생)
    @GetMapping("/reportedWriterId")
    public List<ReportDTO> getReportedWriterId(@RequestParam(value = "type", required = true) String type) {
        log.info("getReportedWriterId type : {}", type);

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type is null");
        }
        return reportService.findReportedWriterId(type);
    }
}
