package com.example.mesdiscreen.controllers;

import com.example.mesdiscreen.modeles.Patients;
import com.example.mesdiscreen.repositories.PatientsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Controller permettant de visualiser, d'ajouter, modifier et supprimer des elements a la table patients.
 *
 */

@Controller
public class PatientsController {


    private static final Logger logger = LogManager.getLogger(PatientsController.class);

    private final PatientsRepository patientsRepository;

    public PatientsController(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    /**
     *
     * @param model : parametre a a transmettre au Modele pour exposition a la vue : Liste de patients.
     * @return : Retour de la page html.
     */

    @RequestMapping("/patient/list")
    public String home(Model model)
    {
        model.addAttribute("patients", patientsRepository.findAll());
        return "patient/list";
    }

    /**
     *
     * @param patients : parametre a a transmettre au Modele pour exposition a la vue add de patients.
     * @return : retour de la pgae html
     */

    @GetMapping("/patient/add")
    public String addPatientsForm(Patients patients) {
        return "patient/add";
    }


    /**
     *
     * @param patients : instace de l'Objet Bidlist pour validation des contraintes de format
     * @param result : resultat de la validation
     * @param model : parametre a transmettre au Modele pour exposition a la vue : Liste de bidlist.
     * @return : Retour de la page html.
     */

    @PostMapping("/patient/validate")
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
    }

    /**
     *
     * @param id : attribut du Modele Bidlist
     * @param model : parametre a transmettre au Modele pour exposition a la vue : Liste de bidlist.
     * @return : retour de la page html
     */

    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws Exception {

        Patients patients = patientsRepository.findByIdpatients(id);
        model.addAttribute("patients", patients);
        return "patient/update";
    }


    @PostMapping("/bidList/update/{id}")
    public String updatePatient(@PathVariable("id") Integer id, @Valid Patients patients,
                            BindingResult result, Model model) {

        if (result.hasErrors()) {
            logger.info("Format non Valide");
            return "patient/update";
        }
        patients.setIdpatients(id);
        patientsRepository.save(patients);
        logger.info("Element Patient mis a jour en BDD");
        model.addAttribute("patients", patientsRepository.findAll());
        return "redirect:/patient/list";
    }

    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id, Model model) {

        Patients patient = patientsRepository.findByIdpatients(id);
        patientsRepository.delete(patient);
        logger.info("Element Patient supprimé");
        return "redirect:/patient/list";
    }


















}
