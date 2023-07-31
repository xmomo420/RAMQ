package com.ramq.Dossier;

import com.ramq.Converters.CoordonneesConverter;
import com.ramq.Converters.Parent.ParentListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {

    @Id
    private String noAssuranceMaladie;
    private String prenom;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String villeNaissance;
    @Convert(converter = CoordonneesConverter.class)
    private Coordonnees coordonneesPatient;
    @Convert(converter = ParentListConverter.class)
    private List<Parent> mere;
    @Convert(converter = ParentListConverter.class)
    private List<Parent> pere;

    public enum Genre {
        HOMME,
        FEMME,
        NON_BINAIRE
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Parent {
        private String prenomParent;
        private String nomParent;
        private boolean estBiologique;

        @Override
        public String toString() {
            return "{" + prenomParent + ", " + nomParent + ", " + estBiologique + "}";
        }
    }
}
