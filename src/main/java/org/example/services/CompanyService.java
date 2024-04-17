package org.example.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.models.Company;
import org.example.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> findAll() {
        log.info("Find all companies");
        return companyRepository.findAll();
    }

    public Company findById(Long id) {
        log.info("Find company by id {}", id);
        return companyRepository.findById(id).orElse(null);
    }

    public Company save(Company company) {
        log.info("Save company {}", company);
        return companyRepository.save(company);
    }
}
