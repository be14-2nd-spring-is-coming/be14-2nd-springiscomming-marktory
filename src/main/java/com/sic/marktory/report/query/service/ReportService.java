package com.sic.marktory.report.query.service;

import com.sic.marktory.report.query.dto.ReportDTO;
import com.sic.marktory.report.query.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReportService {

    private final ReportMapper reportMapper;

    @Autowired
    public ReportService(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    // 모든 신고 내역 조회
    public List<ReportDTO> findAllReports() {
        return reportMapper.selectAllReports();
    }

    // 신고 당한 ? 의 작성자 조회
    public List<ReportDTO> findReportedWriterId(String type) {
        return reportMapper.selectReportedWriterId(type);
    }
}
