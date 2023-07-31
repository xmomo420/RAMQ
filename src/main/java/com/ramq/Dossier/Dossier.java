package com.ramq.Dossier;

import com.ramq.Converters.AdresseConverter;
import com.ramq.Converters.Antecedant.AntecedantListConverter;
import com.ramq.Converters.EtablissementConverter;
import com.ramq.Converters.MedecinConverter;
import com.ramq.Converters.Visite.VisiteListConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dossier {

    @Id
    private String noAssuranceMaladie;
    @Convert(converter = AntecedantListConverter.class)
    private List<Antecedant> antecedants;
    @Convert(converter = VisiteListConverter.class)
    private List<Visite> visites;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Antecedant {
        private String diagnostic;
        private String traitement;
        @Convert(converter = MedecinConverter.class)
        private Medecin medecinTraitant;
        private LocalDate debutMaladie;
        private LocalDate finMaladie;

        @Override
        public String toString() {
            return  "{" + diagnostic + ", " + traitement + ", " + debutMaladie + ", " + finMaladie +
                    ", " + medecinTraitant + ";";
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Visite {
        @Override
        public String toString() {
            return "{" + etablissement + ", " + medecinVisite + ", " + dateVisite +
                    ", " + diagnosticVisite + ", " + traitementVisite +  ", " +
                     resumeeVisite + ", " + notes + "}";
        }

        @Convert(converter = EtablissementConverter.class)
        private Etablissement etablissement;
        @Convert(converter = MedecinConverter.class)
        private Medecin medecinVisite;
        private LocalDate dateVisite;
        private String diagnosticVisite;
        private String traitementVisite;
        private String resumeeVisite;
        private List<String> notes;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Etablissement {
        @Override
        public String toString() {
            return "{" + nomEtablissement + ", " + adresseEtablissement + "}";
        }

        private String nomEtablissement;
        @Convert(converter = AdresseConverter.class)
        private Coordonnees.Adresse adresseEtablissement;
    }

    public static String [] extraireDonnees(String string, String separator) {
        return string.split(separator);
    }
}
