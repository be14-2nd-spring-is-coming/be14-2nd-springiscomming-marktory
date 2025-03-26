package com.sic.marktory.member_template.query.mapper;

import com.sic.marktory.member_template.query.dto.MemberTemplateDTO;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.yml") // 또는 application-test.yml
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class MemberTemplateMapperTest {

//    @Autowired
//    private MemberTemplateMapper memberTemplateMapper;
//
//    @Test
//    public void 템플릿_정상조회() {
//        // when
//        List<MemberTemplateDTO> result = memberTemplateMapper.selectMemberTemplatePublicAll(1L);
//
//        // then
//        assertThat(result).isNotNull();
//        assertThat(result).isNotEmpty(); // 혹은 isEmpty()를 예상하면 그에 맞게
//        result.forEach(System.out::println);
//    }
}
