package com.ramq.Config;

import com.ramq.Dossier.Coordonnees;
import com.ramq.Dossier.Patient;
import com.ramq.Repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PatientConfig {

    /*
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {

        return args -> {
            String prenom = "Georges";
            String nom = "Laracque";
            String noAssuranceMaladie = "LARG70848726";
            String villeNaissance = "Montreal";
            List<Patient.Parent> mere = List.of(new Patient.Parent("Maryline", "Pierre", true));
            List<Patient.Parent> pere = List.of(new Patient.Parent("Alex", "Laracque", true));
            Coordonnees.Adresse adresse = new Coordonnees.Adresse("1090 Rue Tourterelles", "Boucherville", Coordonnees.Provinces.QUEBEC, "J7A1Z3");
            Coordonnees coordonnees = new Coordonnees("5146484243","georges69@gmail.com",adresse);
            Patient George = new Patient(noAssuranceMaladie, prenom, nom,Patient.Genre.HOMME, villeNaissance, coordonnees, mere, pere);
            patientRepository.save(George);
            String prenom1 = "Alice";
            String nom1 = "Dubois";
            String noAssuranceMaladie1 = "DUBOIS123456";
            String villeNaissance1 = "Quebec";
            List<Patient.Parent> mere1 = List.of(new Patient.Parent("Marie", "Dupont", true));
            List<Patient.Parent> pere1 = List.of(new Patient.Parent("Jean", "Dubois", true));
            Coordonnees.Adresse adresse1 = new Coordonnees.Adresse("123 Rue des Lilas", "Quebec", Coordonnees.Provinces.QUEBEC, "G1V2M4");
            Coordonnees coordonnees1 = new Coordonnees("4185551234", "alice.dubois@example.com", adresse1);
            Patient patient1 = new Patient(noAssuranceMaladie1, prenom1, nom1, Patient.Genre.FEMME, villeNaissance1, coordonnees1, mere1, pere1);
            patientRepository.save(patient1);
            String prenom2 = "John";
            String nom2 = "Smith";
            String noAssuranceMaladie2 = "SMITH789012";
            String villeNaissance2 = "Toronto";
            List<Patient.Parent> mere2 = List.of(new Patient.Parent("Emily", "Johnson", true));
            List<Patient.Parent> pere2 = List.of(new Patient.Parent("Michael", "Smith", true));
            Coordonnees.Adresse adresse2 = new Coordonnees.Adresse("456 Oak Street", "Toronto", Coordonnees.Provinces.ONTARIO, "M4B1B3");
            Coordonnees coordonnees2 = new Coordonnees("4167774567", "john.smith@example.com", adresse2);
            Patient patient2 = new Patient(noAssuranceMaladie2, prenom2, nom2, Patient.Genre.HOMME, villeNaissance2, coordonnees2, mere2, pere2);
            patientRepository.save(patient2);
            String prenom3 = "Emma";
            String nom3 = "Garcia";
            String noAssuranceMaladie3 = "GARCIA345678";
            String villeNaissance3 = "Montreal";
            List<Patient.Parent> mere3 = List.of(new Patient.Parent("Sophie", "Martin", true));
            List<Patient.Parent> pere3 = List.of(new Patient.Parent("David", "Garcia", true));
            Coordonnees.Adresse adresse3 = new Coordonnees.Adresse("789 Rue de la Paix", "Montreal", Coordonnees.Provinces.QUEBEC, "H3A2K5");
            Coordonnees coordonnees3 = new Coordonnees("5149998765", "emma.garcia@example.com", adresse3);
            Patient patient3 = new Patient(noAssuranceMaladie3, prenom3, nom3, Patient.Genre.FEMME, villeNaissance3, coordonnees3, mere3, pere3);
            patientRepository.save(patient3);
            String prenom4 = "William";
            String nom4 = "Anderson";
            String noAssuranceMaladie4 = "ANDERSON234567";
            String villeNaissance4 = "Vancouver";
            List<Patient.Parent> mere4 = List.of(new Patient.Parent("Olivia", "Lee", true));
            List<Patient.Parent> pere4 = List.of(new Patient.Parent("James", "Anderson", true));
            Coordonnees.Adresse adresse4 = new Coordonnees.Adresse("567 Elm Avenue", "Vancouver", Coordonnees.Provinces.COLOMBIE_BRITANNIQUE, "V6B2Y3");
            Coordonnees coordonnees4 = new Coordonnees("6043337890", "william.anderson@example.com", adresse4);
            Patient patient4 = new Patient(noAssuranceMaladie4, prenom4, nom4, Patient.Genre.HOMME, villeNaissance4, coordonnees4, mere4, pere4);
            patientRepository.save(patient4);
            String prenom5 = "Isabella";
            String nom5 = "Rodriguez";
            String noAssuranceMaladie5 = "RODRIGUEZ456789";
            String villeNaissance5 = "Calgary";
            List<Patient.Parent> mere5 = List.of(new Patient.Parent("Maria", "Lopez", true));
            List<Patient.Parent> pere5 = List.of(new Patient.Parent("Carlos", "Rodriguez", true));
            Coordonnees.Adresse adresse5 = new Coordonnees.Adresse("1234 Maple Lane", "Calgary", Coordonnees.Provinces.ALBERTA, "T2P0B4");
            Coordonnees coordonnees5 = new Coordonnees("4038885678", "isabella.rodriguez@example.com", adresse5);
            Patient patient5 = new Patient(noAssuranceMaladie5, prenom5, nom5, Patient.Genre.FEMME, villeNaissance5, coordonnees5, mere5, pere5);
            patientRepository.save(patient5);
            String prenom6 = "Alexander";
            String nom6 = "Chen";
            String noAssuranceMaladie6 = "CHEN567890";
            String villeNaissance6 = "Ottawa";
            List<Patient.Parent> mere6 = List.of(new Patient.Parent("Sophia", "Wang", true));
            List<Patient.Parent> pere6 = List.of(new Patient.Parent("Kevin", "Chen", true));
            Coordonnees.Adresse adresse6 = new Coordonnees.Adresse("789 Birch Street", "Ottawa", Coordonnees.Provinces.ONTARIO, "K1P5B6");
            Coordonnees coordonnees6 = new Coordonnees("6132221111", "alexander.chen@example.com", adresse6);
            Patient patient6 = new Patient(noAssuranceMaladie6, prenom6, nom6, Patient.Genre.HOMME, villeNaissance6, coordonnees6, mere6, pere6);
            patientRepository.save(patient6);
            String prenom7 = "Olivia";
            String nom7 = "Martinez";
            String noAssuranceMaladie7 = "MARTINEZ678901";
            String villeNaissance7 = "Edmonton";
            List<Patient.Parent> mere7 = List.of(new Patient.Parent("Elena", "Sanchez", true));
            List<Patient.Parent> pere7 = List.of(new Patient.Parent("Carlos", "Martinez", true));
            Coordonnees.Adresse adresse7 = new Coordonnees.Adresse("567 Willow Avenue", "Edmonton", Coordonnees.Provinces.ALBERTA, "T6G1J3");
            Coordonnees coordonnees7 = new Coordonnees("7804443333", "olivia.martinez@example.com", adresse7);
            Patient patient7 = new Patient(noAssuranceMaladie7, prenom7, nom7, Patient.Genre.FEMME, villeNaissance7, coordonnees7, mere7, pere7);
            patientRepository.save(patient7);
            String prenom8 = "Ethan";
            String nom8 = "Li";
            String noAssuranceMaladie8 = "LI789012";
            String villeNaissance8 = "Winnipeg";
            List<Patient.Parent> mere8 = List.of(new Patient.Parent("Lily", "Zhang", true));
            List<Patient.Parent> pere8 = List.of(new Patient.Parent("Michael", "Li", true));
            Coordonnees.Adresse adresse8 = new Coordonnees.Adresse("456 Pine Street", "Winnipeg", Coordonnees.Provinces.MANITOBA, "R3T2N2");
            Coordonnees coordonnees8 = new Coordonnees("2046662222", "ethan.li@example.com", adresse8);
            Patient patient8 = new Patient(noAssuranceMaladie8, prenom8, nom8, Patient.Genre.HOMME, villeNaissance8, coordonnees8, mere8, pere8);
            patientRepository.save(patient8);
            String prenom9 = "Sophia";
            String nom9 = "Gauthier";
            String noAssuranceMaladie9 = "GAUTHIER901234";
            String villeNaissance9 = "Sherbrooke";
            List<Patient.Parent> mere9 = List.of(new Patient.Parent("Catherine", "Leblanc", true));
            List<Patient.Parent> pere9 = List.of(new Patient.Parent("Philippe", "Gauthier", true));
            Coordonnees.Adresse adresse9 = new Coordonnees.Adresse("890 Cedar Lane", "Sherbrooke", Coordonnees.Provinces.QUEBEC, "J1E2S4");
            Coordonnees coordonnees9 = new Coordonnees("8197778888", "sophia.gauthier@example.com", adresse9);
            Patient patient9 = new Patient(noAssuranceMaladie9, prenom9, nom9, Patient.Genre.FEMME, villeNaissance9, coordonnees9, mere9, pere9);
            patientRepository.save(patient9);
            String prenom10 = "Noah";
            String nom10 = "Taylor";
            String noAssuranceMaladie10 = "TAYLOR123456";
            String villeNaissance10 = "Halifax";
            List<Patient.Parent> mere10 = List.of(new Patient.Parent("Emma", "Brown", true));
            List<Patient.Parent> pere10 = List.of(new Patient.Parent("James", "Taylor", true));
            Coordonnees.Adresse adresse10 = new Coordonnees.Adresse("1233 Oak Street", "Halifax", Coordonnees.Provinces.NOUVELLE_ECOSSE, "B3H2W3");
            Coordonnees coordonnees10 = new Coordonnees("9025557777", "noah.taylor@example.com", adresse10);
            Patient patient10 = new Patient(noAssuranceMaladie10, prenom10, nom10, Patient.Genre.HOMME, villeNaissance10, coordonnees10, mere10, pere10);
            patientRepository.save(patient10);


        };
    }*/
}