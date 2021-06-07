package com.example.mesdiscreen.crud;

import com.example.mesdiscreen.modeles.Patients;
import com.example.mesdiscreen.repositories.PatientsRepository;
import org.junit.Assert;
import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/insert_patients.sql"})
public class PatientsTests {

    @Autowired
    private PatientsRepository patientsRepository;

    Patients patient3 = new Patients(5, "anne", "guillet", LocalDate.now(),"F", "7 Rue de Talhouet", "0123456789");


    @Test
    public void savePatient() {
        patientsRepository.save(patient3);
        Assert.assertNotNull(patient3.getPrenom());
        Assert.assertEquals(patient3.getPrenom(), "anne", "anne");
    }

    @Test
    public void updatePatient() {
        Patients patients;
        Optional<Patients> updPatients = patientsRepository.findById(1);
        patients = updPatients.get();
        patients.setGenre("M");
        patientsRepository.save(patients);
        updPatients = patientsRepository.findById(1);
        patients = updPatients.get();
        Assert.assertEquals(patients.getGenre(), "M", "M");
    }

    @Test
    public void findPatient() {
        List<Patients> listResult = patientsRepository.findAll();
        Assert.assertTrue(listResult.size() > 0);
    }

    @Test
    public void deletePatient() {
        Patients patients;
        Optional<Patients> delPatients = patientsRepository.findById(2);
        patients = delPatients.get();
        patientsRepository.delete(patients);
        Optional<Patients> patientList = patientsRepository.findById(2);
        Assert.assertFalse(patientList.isPresent());
    }

}
