package com.example.mesdiscreen.controllers;

import com.example.mesdiscreen.modeles.Patients;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql({"/insert_patients.sql"})
public class PatientsControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    Patients patient3 = new Patients(5, "anne", "guillet", LocalDate.now(),"F", "7 Rue de Talhouet", "0123456789");
    Patients patient3u = new Patients(5, "anne", "guillet", LocalDate.now(),"F", "7 Rue de Talhouet", "0123456790");

    @Test
    public void getPatientsList() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/api/patients/list"))
                // Assert
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getPatients2() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/api/patients/id?id=2"))
                // Assert
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void AddPatient() throws Exception {
        // Arange & Act
        this.mockMvc.perform(post("/api/patients/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patient3)))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
        }

    @Test
    public void UpdatePatient() throws Exception {
        // Arange & Act
        this.mockMvc.perform(post("/api/patients/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patient3u)))
                // Assert
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void DeletePatient() throws Exception {
        // Arange & Act
        this.mockMvc.perform(delete("/api/patients/delete?id=1"))
                // Assert
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void GetAge() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/api/patients/age?id=1"))
                // Assert
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void GetGenre() throws Exception {
        // Arange & Act
        this.mockMvc.perform(get("/api/patients/genre?id=1"))
                // Assert
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


}
