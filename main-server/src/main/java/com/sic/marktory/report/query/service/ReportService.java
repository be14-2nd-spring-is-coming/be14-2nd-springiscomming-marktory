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

    // 신고 당한 type에 따라 작성자의 id를 조회
    public List<ReportDTO> findReportedWriterId(String type) {
        return reportMapper.selectReportedWriterId(type);
    }

    // 신고 누적 횟수 3번 이상의 회원들 조회
    public List<ReportDTO> findReportedMemberId() { return reportMapper.selectReportedMemberId(); }
    }

