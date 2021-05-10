package com.example.mesdiscreen.controllers;

import com.example.mesdiscreen.modeles.Patients;
import com.example.mesdiscreen.services.PatientsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controller permettant de visualiser, d'ajouter, modifier et supprimer des elements a la table patients.
 *
 */

@RestController
@RequestMapping("api/patients")
@CrossOrigin
public class PatientsController {

    private static final Logger logger = LogManager.getLogger(PatientsController.class);

//    public PatientsController(PatientsRepository patientsRepository) {
//    }

    @Autowired
    PatientsService patientsService;

    /**
     * @return : Retourne la liste complete de tous les utilisateurs
     */

    @GetMapping("/list")
    public List<Patients> listPatients()
    {
        logger.info("Liste de tous les Patients récupérée");
        return patientsService.listAll();

    }


    /**
     * @param patients : parametre Objet Patient a transmettre au controller pour ajout a la liste des patients
     */
    @PostMapping("/add")
    public void addPatient(@RequestBody Patients patients) {
        patientsService.save(patients);
        logger.info("Element Patient ajouté");
    }


    /**
     *
     * @param id : parametre idpatient du patient
     * @return : retourne le patient correspondant a cet id
     */
    @GetMapping("/id")
    public Patients showPatient(Integer id) {
        return patientsService.get(id);
     }


    /**
     *
     * @param patients : parametre Objet Patient
     * @return : Retourne le Patient mis a jour
     */
    @PostMapping("/update")
    public void updatePatient(@RequestBody Patients patients) {
//        patients.setIdpatients(id);
        patientsService.save(patients);
        logger.info("Element Patient mis a jour en BDD");
    }


    /**
     *
     * @param id : parametre idpatient du Patient a supprimer.
     */
    @DeleteMapping("/delete")
    public void deletePatient(Integer id) {
        patientsService.delete(id);
        logger.info("Element Patient supprimé");
    }


    /**
     *
     * @param id : parametre idpatient du patient
     * @return : retourne le patient correspondant a cet id
     */
    @GetMapping("/age")
    public String agePatient(Integer id) {
        LocalDate date = patientsService.get(id).getDatenaissance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedString = date.format(formatter);

        return patientsService.getAge(formattedString);
    }

    /**
     *
     * @param id : parametre idpatient du patient
     * @return : retourne le patient correspondant a cet id
     */
    @GetMapping("/genre")
    public String genrePatient(Integer id) {

        return patientsService.get(id).getGenre();
    }

}
