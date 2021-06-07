package com.example.mesdiscreen.repositories;

import com.example.mesdiscreen.modeles.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Couche Repository pour le Modele Patient
 */

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Integer> {


}
