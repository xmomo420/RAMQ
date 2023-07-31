package com.ramq.Config;

import com.ramq.Dossier.*;
import com.ramq.Repository.DossierRepository;
import com.ramq.Repository.MedecinRepository;
import com.ramq.Repository.PatientRepository;
import com.ramq.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

@Component
public class UtilisateurConfig
        //implements CommandLineRunner
{

    /*private final MedecinRepository medecinRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final PatientRepository patientRepository;

    private final DossierRepository dossierRepository;

    @Autowired
    public UtilisateurConfig(MedecinRepository medecinRepository, UtilisateurRepository utilisateurRepository, PatientRepository patientRepository, DossierRepository dossierRepository) {
        this.medecinRepository = medecinRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.patientRepository = patientRepository;
        this.dossierRepository = dossierRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Patient> patients = patientRepository.findAll();
        for (Patient patient:patients) {
            Dossier dossier = DossierFactory.createRandomDossier();
            dossier.setNoAssuranceMaladie(patient.getNoAssuranceMaladie());
            dossierRepository.save(dossier);
        }
    }

    private String generateRandomPassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(index);
            password.append(randomChar);
        }
        return password.toString();
    }*/
}
