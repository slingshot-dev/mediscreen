package com.example.mesdiscreen.repositories;

import com.example.mesdiscreen.modeles.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Integer> {

    Patients findByIdpatients(Integer id);

    Patients findByNom(String nom);

}
