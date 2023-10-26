package com.wanted.hirenotice.service;

import com.wanted.hirenotice.domain.HireNotice;
import com.wanted.hirenotice.dto.HireNoticeSaveDTO;
import com.wanted.hirenotice.dto.HireNoticeUpdateDTO;
import com.wanted.hirenotice.repository.HireNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HireNoticeService {
    private final HireNoticeRepository hireNoticeRepository;
    public HireNotice save(HireNoticeSaveDTO hireNoticeSaveDTO) {
        return hireNoticeRepository.save(hireNoticeSaveDTO.toEntity());
    }

    public HireNotice save(HireNotice hireNotice) {
        return hireNoticeRepository.save(hireNotice);
    }

    public HireNotice findById(Long hireNoticeId){
        Optional<HireNotice> hireNotice = hireNoticeRepository.findById(hireNoticeId);
        if(hireNotice.isPresent()){
            return hireNotice.get();
        }
        else throw new NoSuchElementException(hireNoticeId + "에 해당하는 데이터 조회에 실패하였습니다.");
    }


    public HireNotice update(HireNotice savedHireNotice, HireNoticeUpdateDTO hireNoticeUpdateDTO) {

        Optional.ofNullable(hireNoticeUpdateDTO.getCorporationName())
                .filter(s -> !s.isEmpty())
                .ifPresent(savedHireNotice::setCorporationName);

        Optional.ofNullable(hireNoticeUpdateDTO.getNation())
                .filter(s -> !s.isEmpty())
                .ifPresent(savedHireNotice::setNation);

        Optional.ofNullable(hireNoticeUpdateDTO.getRegion())
                .filter(s -> !s.isEmpty())
                .ifPresent(savedHireNotice::setRegion);

        Optional.ofNullable(hireNoticeUpdateDTO.getHirePosition())
                .filter(s -> !s.isEmpty())
                .ifPresent(savedHireNotice::setHirePosition);

        Optional.ofNullable(hireNoticeUpdateDTO.getHireCompensation())
                .ifPresent(savedHireNotice::setHireCompensation);

        Optional.ofNullable(hireNoticeUpdateDTO.getTechStack())
                .filter(s -> !s.isEmpty())
                .ifPresent(savedHireNotice::setTechStack);

        return hireNoticeRepository.save(savedHireNotice);
    }

    public List<HireNotice> findAll() {
        return hireNoticeRepository.findAll();
    }

    public void delete(Long id) {
        HireNotice hireNotice = findById(id);
        hireNoticeRepository.delete(hireNotice);
    }
}
