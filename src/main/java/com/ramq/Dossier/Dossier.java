package com.ramq.Dossier;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dossier {

    @Id
    private String noAssuranceMaladie;
    private Patient patient;
    private Antecedant[] antecedants;
    private Visite[] visites;

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Antecedant {
        private String diagnostic;
        private String traitement;
        private Medecin medecinTraitant;
        private LocalDate debutMaladie;
        private LocalDate finMaladie;
    }

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Visite {
        private Etablissement etablissement;
        private Medecin medecin;
        private LocalDate dateVisite;
        private String diagnosticVisite;
        private String traitementVisite;
        private String resumeeVisite;
        private String[] notes;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class Etablissement {
        private String nom;
        private Coordonnees.Adresse adresse;
    }
}
