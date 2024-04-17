package org.example.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.models.Office;
import org.example.repositories.OfficeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;

    public List<Office> getAllOffices() {
        log.info("Getting all offices from DB");
        return officeRepository.findAll();
    }

    public Office getOffice(Long id) {
        log.info("Getting office with id {}", id);
        return officeRepository.findById(id).orElse(null);
    }

    public Office createOffice(Office office) {
        log.info("Creating office {}", office);
        return officeRepository.save(office);
    }
}
