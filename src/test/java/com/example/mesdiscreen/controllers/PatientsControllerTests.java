package com.example.mesdiscreen.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@EnableAutoConfiguration(exclude = {SecurityFilterAutoConfiguration.class, SecurityAutoConfiguration.class})
public class PatientsControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getPatientsList() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/patients/list"))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

/*    @Test
    public void AddPatient() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/patients/add"))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }*/

/*    @Test
    public void getBidListValidateOk() throws Exception {
        // Arange & Act
        this.mockMvc.perform(post("/bidList/validate")
                .param("idpatient", "1")
                .param("account", "NameTests")
                .param("type", "Desctests")
                .param("bidQuantity", "10"))
                // Assert
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andDo(MockMvcResultHandlers.print());
    }*/

/*    @Test
    public void getBidListValidateKo() throws Exception {
        // Arange & Act
        this.mockMvc.perform(post("/bidList/validate")
                .param("account", "")
                .param("type", "Desctests")
                .param("bidQuantity", "10"))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("bidList/add"))
                .andDo(MockMvcResultHandlers.print());
    }*/

/*    @Test
    public void UpdatePatient() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/patient/update/{id}", "1"))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }*/

   /* @Test
    public void UpdatePatient() throws Exception {
        // Arange & Act
        this.mockMvc.perform(post("/patients/update", "1")
                .param("prenom", "cyrilleNew")
                .param("nom", "guilletNew"))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }*/

/*    @Test
    public void postBidListUpdateKo() throws Exception {
        // Arange & Act
        this.mockMvc.perform(post("/bidList/update/{id}", "1")
                .param("account", "")
                .param("type", "DescTestsUpdate")
                .param("bidQuantity", "50"))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("bidList/update"))
                .andDo(MockMvcResultHandlers.print());
    }*/

/*    @Test
    public void DeletePatient() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/patients/delete/{id}", "2"))
                // Assert
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andDo(MockMvcResultHandlers.print());
    }*/


}
