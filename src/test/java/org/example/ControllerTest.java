package org.example;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.example.controllers.CompanyDto;
import org.example.controllers.EmployeeDto;
import org.example.controllers.OfficeDto;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest extends AbstractAppTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    @SneakyThrows
    void testCompanies() {
        var response = mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn().getResponse().getContentAsString();

        var json = readFile("/fixtures/companies.json");
        var expected = stringToObject(json, CompanyDto[].class);
        var actual = stringToObject(response, CompanyDto[].class);
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(actual));
    }

    @Test
    @SneakyThrows
    void testOffices() {
        var response = mockMvc.perform(get("/offices"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn().getResponse().getContentAsString();

        var json = readFile("/fixtures/offices.json");
        var expected = stringToObject(json, OfficeDto[].class);
        var actual = stringToObject(response, OfficeDto[].class);
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(actual));
    }

    @Test
    @SneakyThrows
    void testEmployees() {
        var response = mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn().getResponse().getContentAsString();

        var json = readFile("/fixtures/employees.json");
        var expected = stringToObject(json, EmployeeDto[].class);
        var actual = stringToObject(response, EmployeeDto[].class);
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(actual));
    }

    @SneakyThrows
    private static String readFile(String file) {
        var is = ControllerTest.class.getResourceAsStream(file);
        return IOUtils.toString(is, Charset.defaultCharset());
    }

    @SneakyThrows
    private static <T> T stringToObject(String json, Class<T> clazz) {
        return OBJECT_MAPPER.readValue(json, clazz);
    }
}
