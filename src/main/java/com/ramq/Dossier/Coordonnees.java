package com.ramq.Dossier;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Coordonnees {

    private String noTelephone;
    private String courriel;
    private Adresse adresse;

    @Override
    public String toString() {
        return "{" + noTelephone + ", " + courriel + ", " + adresse + "}";
    }

    public enum Provinces {
        ONTARIO,
        QUEBEC,
        ALBERTA,
        MANITOBA,
        COLOMBIE_BRITANNIQUE,
        SASKATCHEWAN,
        NOUVEAU_BRUNSWICK,
        TERRE_NEUVE_ET_LABRADOR,
        ILE_DU_PRINCE_EDOUARD,
        NOUVELLE_ECOSSE
    }
    
    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Adresse {
        private String rue;
        private String ville;
        private Provinces province;
        private String codePostal;

        @Override
        public String toString() {
            return "{" +
                     rue + ", " + ville + ", " + province + ", " + codePostal + "}";
        }
    }
}
