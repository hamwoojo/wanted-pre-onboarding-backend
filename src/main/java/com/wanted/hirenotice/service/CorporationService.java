package com.wanted.hirenotice.service;

import com.wanted.hirenotice.domain.Corporation;
import com.wanted.hirenotice.dto.CorporationSaveDTO;
import com.wanted.hirenotice.dto.CorporationUpdateDTO;
import com.wanted.hirenotice.repository.CorporationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CorporationService {

    private final CorporationRepository corporationRepository;
    public Corporation save(CorporationSaveDTO corporationSaveDTO) {
        return corporationRepository.save(corporationSaveDTO.toEntity());
    }


    public List<Corporation> findAll() {
        return corporationRepository.findAll();
    }

    public Corporation findById(Long corporationId){
        Optional<Corporation> corporation = corporationRepository.findById(corporationId);
        if(corporation.isPresent()){
            return corporation.get();
        } else throw new NoSuchElementException(corporationId + "에 해당하는 데이터 조회에 실패하였습니다.");
    }

    public Corporation update(Long corporationId, CorporationUpdateDTO corporationUpdateDTO) {
        Corporation savedCorporation = findById(corporationId);

        Optional.ofNullable(corporationUpdateDTO.getCorporationName())
                .filter(s -> !s.isEmpty())
                .ifPresent(savedCorporation::setCorporationName);
        Optional.ofNullable(corporationUpdateDTO.getCorporationOverview())
                .filter(s -> !s.isEmpty())
                .ifPresent(savedCorporation::setCorporationOverview);
        Optional.ofNullable(corporationUpdateDTO.getCorporationIndustry())
                .filter(s -> !s.isEmpty())
                .ifPresent(savedCorporation::setCorporationIndustry);
        Optional.ofNullable(corporationUpdateDTO.getFoundingYear())
                .filter(s -> !(s.intValue() == 0))
                .ifPresent(savedCorporation::setFoundingYear);

        return corporationRepository.save(savedCorporation);
    }

    public void delete(Long id) {
        Corporation corporation = findById(id);
        corporationRepository.delete(corporation);
    }
}
