package com.ramq.Config;

import com.ramq.Dossier.Coordonnees;

import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Medecin;
import com.ramq.Dossier.Patient;
import com.ramq.Repository.DossierRepository;
import com.ramq.Repository.MedecinRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DossierConfig {

    /*
    @Bean
    CommandLineRunner commandLineRunner(DossierRepository dossierRepository) {

        return args -> {
            String noAss = "JALB20010620";
            //Medecin medecin = new Medecin("DR_5687-1676", "Gilbert", "Rousseau");
            //Coordonnees.Adresse = new Coordonnees.Adresse("");

        };
    }*/

}
