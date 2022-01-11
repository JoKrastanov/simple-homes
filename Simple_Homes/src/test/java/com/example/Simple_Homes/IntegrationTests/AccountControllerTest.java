package com.example.simple_homes.IntegrationTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestCreateAccount() throws Exception {
        mockMvc.perform(post("http://localhost:8080/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\" : \"mock\", \"password\" : \"mock\", \"phoneNumber\" : \"mock\", \"name\" : \"mock\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void TestLogInAccount() throws Exception {
        mockMvc.perform(post("http://localhost:8080/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\" : \"test@gmail.com\", \"password\" : \"test\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void TestGetAccountWithoutToken() throws Exception
    {
        mockMvc.perform(post("http://localhost:8080/accounts/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void TestGetAccountWithToken() throws Exception
    {
        mockMvc.perform(get("http://localhost:8080/accounts/{id}", 18)
                        .header("Authorization", getToken()))
                .andExpect(status().isOk());
    }

    @Test
    public void TestGetAllAccountsWithoutToken() throws Exception {
        mockMvc.perform(get("http://localhost:8080/accounts"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void TestGetAllAccountsWithToken() throws Exception {
        mockMvc.perform(get("http://localhost:8080/accounts")
                        .header("Authorization", getToken()))
                .andExpect(status().isOk());
    }

    @Test
    public void TestUpdateAccountWithoutToken() throws Exception {
        mockMvc.perform(put("http://localhost:8080/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\" : \"18\", \"password\" : \"test\", \"phoneNumber\" : \"test\", \"name\" : \"test\", \"email\" : \"test\"}"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void TestUpdateAccountWithToken() throws Exception {
        mockMvc.perform(put("http://localhost:8080/accounts")
                        .header("Authorization", getToken())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\" : \"18\", \"password\" : \"test\", \"phoneNumber\" : \"test\", \"name\" : \"test\", \"email\" : \"test@gmail.com\"}"))
                .andExpect(status().isNoContent());
    }

    @Test
   public  void TestDeleteAccountWithoutToken() throws Exception {
        mockMvc.perform(delete("http://localhost:8080/accounts/{id}" , 18))
                .andExpect(status().isForbidden());
    }

    @Test
    public void TestDeleteAccountWithToken() throws Exception {
        mockMvc.perform(delete("http://localhost:8080/accounts/{id}" , 18)
                        .header("Authorization", getToken()))
                .andExpect(status().isOk());
    }


    private String getToken() throws Exception {
        MvcResult MVC = mockMvc.perform(post("http://localhost:8080/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\" : \"test@gmail.com\", \"password\" : \"test\"}"))
                .andExpect(status().isOk())
                .andReturn();

        String mvcResponse = MVC.getResponse().getContentAsString();
        String token = mvcResponse.split("\"")[3];
        return token;
    }
}

