package com.ramq.Dossier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DossierFactory {

    private static final Random random = new Random();

    public static Dossier createRandomDossier() {
        Dossier dossier = new Dossier();

        // Générer un numéro d'assurance maladie aléatoire
        //String noAssuranceMaladie = generateRandomNoAssuranceMaladie();
        //dossier.setNoAssuranceMaladie(noAssuranceMaladie);

        // Générer une liste d'antécédents aléatoires
        List<Dossier.Antecedant> antecedants = generateRandomAntecedants();
        dossier.setAntecedants(antecedants);

        // Générer une liste de visites aléatoires
        List<Dossier.Visite> visites = generateRandomVisites();
        dossier.setVisites(visites);

        return dossier;
    }

    private static String generateRandomNoAssuranceMaladie() {
        // Vous pouvez adapter cette méthode pour générer un numéro d'assurance maladie aléatoire
        // selon les règles spécifiques de votre application.
        // Par exemple, vous pouvez utiliser un algorithme pour générer un numéro aléatoire unique et valide.
        // Pour cet exemple, nous allons simplement générer un numéro aléatoire de 10 chiffres.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private static List<Dossier.Antecedant> generateRandomAntecedants() {
        // Générer une liste d'antécédents aléatoires (ici, nous en créons simplement deux pour l'exemple)
        List<Dossier.Antecedant> antecedants = new ArrayList<>();

        Dossier.Antecedant antecedant1 = new Dossier.Antecedant();
        antecedant1.setDiagnostic("Hypertension");
        antecedant1.setTraitement("Médicaments pour la tension artérielle");
        antecedant1.setMedecinTraitant(new Medecin("12345", "Dr. Dupont", "Cardiologue"));
        antecedant1.setDebutMaladie(LocalDate.of(2015, 3, 10));
        antecedant1.setFinMaladie(LocalDate.of(2017, 7, 15));
        antecedants.add(antecedant1);

        Dossier.Antecedant antecedant2 = new Dossier.Antecedant();
        antecedant2.setDiagnostic("Diabète de type 2");
        antecedant2.setTraitement("Régime et insuline");
        antecedant2.setMedecinTraitant(new Medecin("67890", "Dr. Tremblay", "Endocrinologue"));
        antecedant2.setDebutMaladie(LocalDate.of(2018, 5, 5));
        antecedant2.setFinMaladie(LocalDate.now());
        antecedants.add(antecedant2);

        return antecedants;
    }

    private static List<Dossier.Visite> generateRandomVisites() {
        // Générer une liste de visites aléatoires (ici, nous en créons simplement deux pour l'exemple)
        List<Dossier.Visite> visites = new ArrayList<>();

        Dossier.Visite visite1 = new Dossier.Visite();
        visite1.setEtablissement(new Dossier.Etablissement("Hôpital général", createRandomAdresse()));
        visite1.setMedecinVisite(new Medecin("54321", "Dr. Martin", "Médecin généraliste"));
        visite1.setDateVisite(LocalDate.of(2021, 8, 20));
        visite1.setDiagnosticVisite("Grippe");
        visite1.setTraitementVisite("Repos et médicaments pour la fièvre");
        visite1.setResumeeVisite("Le patient présente des symptômes de grippe.");
        visite1.setNotes(new ArrayList<>());
        visites.add(visite1);

        Dossier.Visite visite2 = new Dossier.Visite();
        visite2.setEtablissement(new Dossier.Etablissement("Clinique médicale", createRandomAdresse()));
        visite2.setMedecinVisite(new Medecin("98765", "Dr. Gagnon", "Dermatologue"));
        visite2.setDateVisite(LocalDate.of(2022, 2, 10));
        visite2.setDiagnosticVisite("Éruption cutanée");
        visite2.setTraitementVisite("Crème pour l'éruption cutanée");
        visite2.setResumeeVisite("Le patient présente une éruption cutanée sur les bras.");
        visite2.setNotes(new ArrayList<>());
        visites.add(visite2);

        return visites;
    }

    private static Coordonnees.Adresse createRandomAdresse() {
        // Générer une adresse aléatoire (pour simplifier l'exemple, nous créons une adresse fictive)
        Coordonnees.Adresse adresse = new Coordonnees.Adresse();
        adresse.setRue("123 rue Principale");
        adresse.setVille("Montréal");
        adresse.setProvince(Coordonnees.Provinces.QUEBEC);
        adresse.setCodePostal("H2X 1K1");
        return adresse;
    }
}

