package org.example.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mappers.OfficeMapper;
import org.example.models.Office;
import org.example.services.OfficeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("offices")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;
    private final OfficeMapper officeMapper;

    @GetMapping
    public ResponseEntity<List<OfficeDto>> getOffices() {
        log.info("Get offices");
        var result = officeService.getAllOffices().stream()
                .map(officeMapper::toDto)
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<OfficeDto> getOffice(@PathVariable Long id) {
        log.info("Get office by id: {}", id);
        var result = officeService.getOffice(id);
                return ResponseEntity.ok(officeMapper.toDto(officeService.getOffice(id)));
    }

    @PostMapping
    public ResponseEntity<OfficeDto> createOffice(@RequestBody OfficeDto officeDto) {
        log.info("Create office: {}", officeDto);
        var result = officeService.createOffice(officeMapper.toEntity(officeDto));
        return ResponseEntity.ok(officeMapper.toDto(result));
    }
}
