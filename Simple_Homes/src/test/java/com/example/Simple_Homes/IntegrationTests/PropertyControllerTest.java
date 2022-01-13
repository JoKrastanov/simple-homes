package com.example.simple_homes.IntegrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class PropertyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestCreateProperty() throws Exception {
        mockMvc.perform(post("http://localhost:8080/properties")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"type\" : \"Room\", \"price\" : 400, \"taken\" : \"false\", \"description\" : \"test\"," +
                                " \"forSale\" : \"false\", \"publisherId\" : 1, \"address\" : \"test\", \"postalCode\" : \"test\"," +
                                " \"city\" : \"test\", \"size\" : 15, \"dateAvailable\" : \"2021-11-01 00:00:00\", \"datePublished\" : \"2021-11-01 00:00:00\"," +
                                " \"rooms\" : 1, \"interior\" : \"Furnished\", \"availability\" : \"false\", \"publisher\" : 1}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void TestUpdateProperty() throws Exception {
        mockMvc.perform(put("http://localhost:8080/properties")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\" : \"23\", \"type\" : \"Room\", \"price\" : 400, \"taken\" : \"false\", \"description\" : \"test\"," +
                                " \"forSale\" : \"false\", \"publisherId\" : 1, \"address\" : \"test\", \"postalCode\" : \"test\"," +
                                " \"city\" : \"test\", \"size\" : 15, \"dateAvailable\" : \"2021-11-01 00:00:00\", \"datePublished\" : \"2021-11-01 00:00:00\"," +
                                " \"rooms\" : 1, \"interior\" : \"Furnished\", \"availability\" : \"false\", \"publisher\" : 1}"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void TestDeleteExistingProperty() throws Exception {
        mockMvc.perform(delete("http://localhost:8080/properties/783")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isOk());
    }

    @Test
    public void TestGetExistingProperty() throws Exception {
        mockMvc.perform(get("http://localhost:8080/properties/783")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isOk());
    }

    @Test
    public void TestGetMissingProperty() throws Exception {
        mockMvc.perform(get("http://localhost:8080/properties/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isNotFound());
    }

    @Test
    public void TestGetAllProperties() throws Exception {
        mockMvc.perform(get("http://localhost:8080/properties")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isOk());
    }

    @Test
    public void TestSearchExistingPropertyLocation() throws Exception {
        mockMvc.perform(get("http://localhost:8080/properties/search/Eindhoven")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isOk());
    }

    @Test
    public void TestSearchMissingPropertyLocation() throws Exception {
        mockMvc.perform(get("http://localhost:8080/properties/search/dasdasdasd")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isNotFound());
    }
}
