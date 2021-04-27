package com.example.mesdiscreen.services;

import com.example.mesdiscreen.modeles.Patients;
import com.example.mesdiscreen.repositories.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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


}
