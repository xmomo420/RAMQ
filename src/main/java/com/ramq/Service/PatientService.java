package com.ramq.Service;

import com.ramq.Dossier.Patient;
import com.ramq.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void creerPatient(Patient patient) {
        patientRepository.save(patient);
    }
}
