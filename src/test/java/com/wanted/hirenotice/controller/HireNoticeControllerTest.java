package com.wanted.hirenotice.controller;

import com.wanted.hirenotice.domain.HireNotice;
import com.wanted.hirenotice.dto.HireNoticeSaveDTO;
import com.wanted.hirenotice.dto.HireNoticeUpdateDTO;
import com.wanted.hirenotice.repository.HireNoticeRepository;
import com.wanted.hirenotice.service.HireNoticeService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HireNoticeControllerTest {

    @Autowired
    private HireNoticeRepository hireNoticeRepository;
    @Autowired
    private HireNoticeService hireNoticeService;

    private long id;

    @Test
    @Order(1)
    void add() {
        HireNoticeSaveDTO hireNoticeSaveDTO1 = new HireNoticeSaveDTO("네이버","한국","서울","백엔드 개발자",500000L,"Java&Spring");
        HireNoticeSaveDTO hireNoticeSaveDTO2 = new HireNoticeSaveDTO("구글","미국","뉴욕","데이터 엔지니어",1000000L,"Python,Kafka,Airflow");

        HireNotice savedHireNotice1 = hireNoticeService.save(hireNoticeSaveDTO1);
        HireNotice savedHireNotice2 = hireNoticeService.save(hireNoticeSaveDTO2);

        HireNotice hireNotice = hireNoticeService.findById(savedHireNotice1.getHireNoticeId());
        id = hireNotice.getHireNoticeId();
        assertThat(hireNotice.getCorporationName()).isEqualTo("네이버");

        List<HireNotice> hireNotices = hireNoticeService.findAll();
        assertThat(hireNotices.get(0)).isEqualTo(savedHireNotice1);
        assertThat(hireNotices.get(1)).isEqualTo(savedHireNotice2);

    }

    @Test
    @Order(2)
    void update() {
        HireNoticeUpdateDTO hireNoticeUpdateDTO = new HireNoticeUpdateDTO();
        hireNoticeUpdateDTO.setHirePosition("프론트 개발자");
        hireNoticeUpdateDTO.setTechStack("자바스크립트");

        Long hireNoticeId = id;

        HireNotice updatedHireNotice = hireNoticeService.update(hireNoticeId, hireNoticeUpdateDTO);

        assertThat(updatedHireNotice.getHirePosition()).isEqualTo(hireNoticeUpdateDTO.getHirePosition());
        assertThat(updatedHireNotice.getHirePosition()).isEqualTo("프론트 개발자");
        assertThat(updatedHireNotice.getTechStack()).isEqualTo("자바스크립트");
        assertThat(updatedHireNotice.getTechStack()).isEqualTo(hireNoticeUpdateDTO.getTechStack());
    }

    @Test
    @Order(3)
    void retrieve() {
        List<HireNotice> hireNotices = hireNoticeService.findAll();

        assertThat(hireNotices.size()).isEqualTo(2);
        assertThat(hireNotices.get(0).getCorporationName()).isEqualTo("네이버");
        assertThat(hireNotices.get(0).getHirePosition()).isEqualTo("프론트 개발자");
        assertThat(hireNotices.get(0).getTechStack()).isEqualTo("자바스크립트");

    }

    @Order(4)
    @Test
    void delete() {
        Long hireNoticeId1 = id;

        hireNoticeService.delete(hireNoticeId1);

        List<HireNotice> hireNotices = hireNoticeService.findAll();

        assertThat(hireNotices.size()).isEqualTo(1);
    }

    @Order(5)
    @Test
    void deleteAll(){
        hireNoticeRepository.deleteAll();
    }

}