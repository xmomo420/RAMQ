package com.ramq.Config;

import com.ramq.Dossier.Medecin;
import com.ramq.Repository.MedecinRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedecinConfig {
    /*
    @Bean
    CommandLineRunner commandLineRunner(MedecinRepository medecinRepository) {

        return args -> {
            String noPermis = "CAMD-4598-7835";
            String prenom = "Mathieu";
            String nom = "Lebeau";
            Medecin medecin = new Medecin(noPermis, prenom, nom);
            medecinRepository.save(medecin);

            String noPermis1 = "DOCT-1234-5678";
            String prenom1 = "Marie";
            String nom1 = "Dupuis";
            Medecin medecin1 = new Medecin(noPermis1, prenom1, nom1);
            medecinRepository.save(medecin1);

            String noPermis2 = "MD-9876-5432";
            String prenom2 = "Jean";
            String nom2 = "Lefebvre";
            Medecin medecin2 = new Medecin(noPermis2, prenom2, nom2);
            medecinRepository.save(medecin2);

            String noPermis3 = "DR-4567-7890";
            String prenom3 = "Isabelle";
            String nom3 = "Gagnon";
            Medecin medecin3 = new Medecin(noPermis3, prenom3, nom3);
            medecinRepository.save(medecin3);

            String noPermis4 = "MED-7890-1234";
            String prenom4 = "Marc";
            String nom4 = "Tremblay";
            Medecin medecin4 = new Medecin(noPermis4, prenom4, nom4);
            medecinRepository.save(medecin4);

            String noPermis5 = "DOC-2345-6789";
            String prenom5 = "Sophie";
            String nom5 = "Martin";
            Medecin medecin5 = new Medecin(noPermis5, prenom5, nom5);
            medecinRepository.save(medecin5);
        };
    }*/
}
