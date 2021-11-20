package com.example.przychodnia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ControllersTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN")
    public void homeControllerTest() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void patientControllerTest() throws Exception {
        mockMvc.perform(get("/patient"))
                .andExpect(status().isOk())
                .andExpect(view().name("show-patients"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void patientAddControllerTest() throws Exception {
        mockMvc.perform(get("/patient/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-patient"));
    }


    @Test
    @WithMockUser(roles = "ADMIN")
    public void AddUserControllerTest() throws Exception {
        mockMvc.perform(get("/user/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-user"));
    }


}


