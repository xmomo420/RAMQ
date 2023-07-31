package com.ramq.Config;

import com.ramq.Dossier.Medecin;
import com.ramq.Dossier.Patient;
import com.ramq.Dossier.Utilisateur;
import com.ramq.Repository.MedecinRepository;
import com.ramq.Repository.PatientRepository;
import com.ramq.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    public UtilisateurConfig(MedecinRepository medecinRepository, UtilisateurRepository utilisateurRepository, PatientRepository patientRepository) {
        this.medecinRepository = medecinRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Medecin> medecins = medecinRepository.findAll();
        List<Patient> patients = patientRepository.findAll();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        for (Medecin medecin : medecins) {
            String motDePasse = passwordEncoder.encode(generateRandomPassword(10));
            Utilisateur utilisateur = new Utilisateur(medecin.getNoPermisMedical(), motDePasse, Utilisateur.Role.MEDECIN);
            utilisateurRepository.save(utilisateur);
        }

        for (Patient patient : patients) {
            String motDePasse = passwordEncoder.encode(generateRandomPassword(10));
            Utilisateur utilisateur = new Utilisateur(patient.getNoAssuranceMaladie(), motDePasse, Utilisateur.Role.PATIENT);
            utilisateurRepository.save(utilisateur);
        }

        Utilisateur userAdminPatient = new Utilisateur("BOUM14061999", passwordEncoder.encode("abc123"), Utilisateur.Role.PATIENT);
        utilisateurRepository.save(userAdminPatient);
        Utilisateur userAdminMEDECIN = new Utilisateur("CHAG19021998", passwordEncoder.encode("123abc"), Utilisateur.Role.MEDECIN);
        utilisateurRepository.save(userAdminMEDECIN);
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
