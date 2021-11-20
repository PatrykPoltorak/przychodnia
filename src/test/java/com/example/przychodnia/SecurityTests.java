package com.example.przychodnia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class SecurityTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")
    public void AdminAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/patient").accept(MediaType.ALL))
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/user/doctors").accept(MediaType.ALL))
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/patient/add").accept(MediaType.ALL))
                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(roles = "DOCTOR")
    public void DoctorToAdminOnlyPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/add").accept(MediaType.ALL))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "RECEPTION")
    public void ReceptionToAdminOnlyPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/add").accept(MediaType.ALL))
                .andExpect(status().isForbidden());
    }


    @Test
    public void NotLoggedRedirection() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/home").accept(MediaType.ALL))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(MockMvcRequestBuilders.get("/patient").accept(MediaType.ALL))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(MockMvcRequestBuilders.get("/patient/add").accept(MediaType.ALL))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(MockMvcRequestBuilders.get("/patient/edit/?id=1").accept(MediaType.ALL))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(MockMvcRequestBuilders.get("/patient/delate/?id=1").accept(MediaType.ALL))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(MockMvcRequestBuilders.get("/patient/add-visit/?id=1").accept(MediaType.ALL))
                .andExpect(status().is3xxRedirection());
        mockMvc.perform(MockMvcRequestBuilders.get("/visit/today").accept(MediaType.ALL))
                .andExpect(status().is3xxRedirection());
    }


}
