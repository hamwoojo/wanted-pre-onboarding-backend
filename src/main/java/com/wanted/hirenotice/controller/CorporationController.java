package com.wanted.hirenotice.controller;

import com.wanted.hirenotice.domain.Corporation;
import com.wanted.hirenotice.dto.CorporationSaveDTO;
import com.wanted.hirenotice.dto.CorporationUpdateDTO;
import com.wanted.hirenotice.service.CorporationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/corporation")
public class CorporationController {
    private final CorporationService corporationService;

    @PostMapping
    public ResponseEntity<Corporation> add(CorporationSaveDTO corporationSaveDTO){
        Corporation corporation = corporationService.save(corporationSaveDTO);
        return ResponseEntity.ok(corporation);
    }

    @GetMapping
    public List<Corporation> retrieve(){
        return corporationService.findAll();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Corporation> update(@PathVariable Long id, CorporationUpdateDTO corporationUpdateDTO){
        Corporation updatedCorporation = corporationService.update(id, corporationUpdateDTO);
        return ResponseEntity.ok(updatedCorporation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        corporationService.delete(id);
        return ResponseEntity.ok(id + "가 삭제되었습니다.");
    }


}
