package com.ramq.Config;

import com.ramq.Dossier.Coordonnees;
import com.ramq.Dossier.Patient;
import com.ramq.Repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Configuration
public class PatientConfig {

    /*
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {

        return args -> {
            Coordonnees.Adresse adresse = new Coordonnees.Adresse("957 Rue Fréchette", "Longueuil", Coordonnees.Provinces.QUEBEC, "J4J1T3");
            Coordonnees coordonnees = new Coordonnees("5149950723", "demolisseur33@live.ca", adresse);
            Patient patient = patientRepository.findById("BOUM14061999")
                    .orElseThrow(() -> new UsernameNotFoundException("CACA"));
            patient.setCoordonneesPatient(coordonnees);
            patientRepository.save(patient);

        };
    }*/
}
