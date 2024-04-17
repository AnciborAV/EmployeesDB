package org.example.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mappers.CompanyMapper;
import org.example.services.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper mapper;

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAll() {
        var result = companyService.findAll().stream()
                .map(mapper::toDto)
                .toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<CompanyDto> getById(@PathVariable Long id) {
        log.info("Get company by id: {}", id);
        var result = companyService.findById(id);
        return ResponseEntity.ok(mapper.toDto(result));
    }

    @PostMapping
    public ResponseEntity<CompanyDto> create(@RequestBody CompanyDto companyDto) {
        log.info("Create company: {}", companyDto);
        var entity = mapper.toEntity(companyDto);
        var result = companyService.save(entity);
        return ResponseEntity.ok(mapper.toDto(result));
    }
}
