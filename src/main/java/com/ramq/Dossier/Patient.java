package com.ramq.Dossier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends Utilisateur {

    private Genre genre;
    private String villeNaissance;
    private Coordonnees coordonnees;
    private List<Parent> mere;
    private List<Parent> pere;

    private enum Genre {
        HOMME,
        FEMME,
        NON_BINAIRE
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class Parent {
        private String prenom;
        private String nom;
        private boolean estBiologique;
    }
}
