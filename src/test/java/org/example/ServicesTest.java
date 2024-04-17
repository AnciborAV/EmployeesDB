package org.example;

import org.example.services.CompanyService;
import org.example.services.EmployeeService;
import org.example.services.OfficeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ServicesTest extends AbstractAppTest {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void testOffice() {
        var all = officeService.getAllOffices();
        assertEquals(6, all.size());
    }

    @Test
    void testEmployee() {
        var all = employeeService.getAllEmployees();
        assertEquals(7, all.size());
    }

    @Test
    void testCompany() {
        var all = companyService.findAll();
        assertEquals(5, all.size());
    }
}
