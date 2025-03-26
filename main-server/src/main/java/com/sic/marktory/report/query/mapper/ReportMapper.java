package com.sic.marktory.report.query.mapper;

import com.sic.marktory.report.query.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface ReportMapper {

    List<ReportDTO> selectAllReports();

    List<ReportDTO> selectReportedWriterId(@Param("type") String type);

}
