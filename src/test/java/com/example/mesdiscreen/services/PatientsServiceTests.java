package com.example.mesdiscreen.services;

import com.example.mesdiscreen.modeles.Patients;
import com.example.mesdiscreen.repositories.PatientsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"/insert_patients.sql"})
public class PatientsServiceTests {

    @Autowired
    private PatientsService patientsService;


    Patients patient5 = new Patients(5, "anne", "guillet", LocalDate.now(),"F", "7 Rue de Talhouet", "0123456789");


    @Test
    public void savePatient() {
        Patients savedPatieznt = patientsService.save(patient5);
        Assert.assertEquals(savedPatieznt.getPrenom(), "anne", "anne");
    }

    @Test
    public void updatePatient() {
        Patients updPatients = patientsService.get(1);
        updPatients.setGenre("M");
        patientsService.save(updPatients);
        Patients updPatients2 = patientsService.get(1);
        Assert.assertEquals(updPatients2.getGenre(), "M", "M");
    }

    @Test
    public void findPatient() {
        List<Patients> listResult = patientsService.listAll();
        Assert.assertTrue(listResult.size() > 0);
    }

    @Test
    public void deletePatient() {
        Patients patient2 = patientsService.get(2);
        patientsService.delete(2);
        Assert.assertFalse(patientsService.listAll().contains(patient2));
    }

}
