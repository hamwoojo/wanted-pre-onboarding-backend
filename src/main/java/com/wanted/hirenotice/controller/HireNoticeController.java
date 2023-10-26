package com.wanted.hirenotice.controller;

import com.wanted.hirenotice.domain.HireNotice;
import com.wanted.hirenotice.dto.HireNoticeSaveDTO;
import com.wanted.hirenotice.dto.HireNoticeUpdateDTO;
import com.wanted.hirenotice.service.HireNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/hire-notice")
@RequiredArgsConstructor
public class HireNoticeController {
    private final HireNoticeService hireNoticeService;
    @PostMapping
    public ResponseEntity<HireNotice> add(@RequestBody HireNoticeSaveDTO hireNoticeSaveDTO){
        HireNotice hireNotice = hireNoticeService.save(hireNoticeSaveDTO);
        return ResponseEntity.ok(hireNotice);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<HireNotice> update(@PathVariable Long id, @RequestBody HireNoticeUpdateDTO hireNoticeUpdateDTO){
        HireNotice hireNotice = hireNoticeService.update(id,hireNoticeUpdateDTO);
        return ResponseEntity.ok(hireNotice);
    }
    @GetMapping
    public ResponseEntity<List<HireNotice>> retrieve(){
        List<HireNotice> hireNotices = hireNoticeService.findAll();
        return ResponseEntity.ok(hireNotices);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        hireNoticeService.delete(id);
        return ResponseEntity.ok(id+"가 삭제 되었습니다.");
    }
}
