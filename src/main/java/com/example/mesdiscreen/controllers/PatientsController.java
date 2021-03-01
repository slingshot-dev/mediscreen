package com.example.mesdiscreen.controllers;

import com.example.mesdiscreen.modeles.Patients;
import com.example.mesdiscreen.repositories.PatientsRepository;
import com.example.mesdiscreen.services.PatientsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller permettant de visualiser, d'ajouter, modifier et supprimer des elements a la table patients.
 *
 */

@RestController
@RequestMapping("patients")
public class PatientsController {

    private static final Logger logger = LogManager.getLogger(PatientsController.class);

    public PatientsController(PatientsRepository patientsRepository) {
    }

    @Autowired
    PatientsService patientsService;

    /**
     * @return : Retourne la liste complete de tous les utilisateurs
     */
    @GetMapping("/list")
    public List<Patients> listPatients()
    {
        return patientsService.listAll();
    }


    /**
     * @param patients : parametre Objet Patient a transmettre au controller pour ajout a la liste des patients
     */
    @PutMapping("/add")
    public void addPatient(Patients patients) {
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
     * @param id : parametre idpatient du patient
     * @param patients : parametre Objet Patient
     * @return : Retourne le Patient mis a jour
     */
    @PostMapping("/update")
    public void updatePatient(Integer id,Patients patients) {
        patients.setIdpatients(id);
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




/*    @PostMapping("/patient/validate")
    public String validate(@Valid Patients patients, BindingResult result, Model model) {

        // Verifie que les datas dont valides et sinon return sur la page d'ajout de données
        if (!result.hasErrors()) {

            // Ajout des elements en BDD et redirection vers Bid List
            patientsRepository.save(patients);
            logger.info("Element Patient ajouté a la BDD");
            model.addAttribute("patients", patientsRepository.findAll());
            return "redirect:/patients/list";
        }
        logger.info("Format non Valide");
        return "patient/add";
    }*/













}
