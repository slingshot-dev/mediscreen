package com.example.mesdiscreen.crud;

import com.example.mesdiscreen.modeles.Patients;
import com.example.mesdiscreen.repositories.PatientsRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/insert_patients.sql"})
public class PatientsTests {

    @Autowired
    private PatientsRepository patientsRepository;

    Patients patient1 = new Patients(1, "cyrille", "guillet", "1973/03/28","m", "7 Rue de Talhouet", "0123456789");
    Patients patient2 = new Patients(2, "fabienne", "cassagne", "1971/02/17","f", "6 rue alexandre dumas 91170 viry-chatillon", "0663986587");
    Patients patient3 = new Patients(3, "anne", "guillet", "1975/03/28","m", "7 Rue de Talhouet", "0123456789");



    @Test
    public void savePatient() {
        patientsRepository.save(patient3);
        Assert.assertNotNull(patient3.getPrenom());
        Assert.assertEquals(patient3.getPrenom(), "anne", "anne");
    }

    @Test
    public void updatePatient() {
        patient2.setGenre("m");
        patient2 = patientsRepository.save(patient2);
        Assert.assertEquals(patient2.getGenre(), "f", "f");
    }

    @Test
    public void findPatient() {
        List<Patients> listResult = patientsRepository.findAll();
        Assert.assertTrue(listResult.size() > 0);
    }

    @Test
    public void deletePatient() {
        Integer id = patient1.getIdpatients();
        patientsRepository.delete(patient1);
        Optional<Patients> patientList = patientsRepository.findById(id);
        Assert.assertFalse(patientList.isPresent());
    }

}
