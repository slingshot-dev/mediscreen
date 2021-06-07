package com.example.mesdiscreen.services;

import com.example.mesdiscreen.modeles.Patients;
import com.example.mesdiscreen.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


/**
 * Service permettant l'ensemble des actions CRUD du programme.
 */

@Service
@Transactional
public class PatientsService {

    @Autowired
    private PatientsRepository repo;

    public List<Patients> listAll() {
        return repo.findAll();
    }

    public Patients save(Patients patients) {
        return repo.save(patients);
    }

    public Patients get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }


    public String getAge(String birthDate) {
        int calculAge = 0;

        if (!birthDate.equals("TbD")) {
            LocalDate localDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
                    .withLocale(Locale.FRENCH);

            LocalDate date = LocalDate.parse(birthDate, formatter);
            calculAge = Period.between(date, localDate).getYears();
        } else {
            return "TbD";
        }

        return String.valueOf(calculAge);
    }


}
