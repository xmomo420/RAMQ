package com.ramq.Config;

import com.ramq.Dossier.Medecin;
import com.ramq.Repository.MedecinRepository;
import com.ramq.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedecinConfig {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public MedecinConfig(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /*@Bean
    CommandLineRunner commandLineRunner(MedecinRepository medecinRepository) {

        return args -> {

            String prenom = "Gabriel";
            String nom = "Chartrand";
            Medecin medecin = new Medecin("CHAG19021998", prenom, nom);
            medecinRepository.save(medecin);

        };
    }*/
}
