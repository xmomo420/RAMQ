package com.ramq.Dossier;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Coordonnees {

    private String noTelephone;
    private String courriel;
    private Adresse adresse;

    private enum Provinces {
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
    @Embeddable
    @NoArgsConstructor
    public static class Adresse {
        private String rue;
        private String ville;
        private Provinces province;
        private String codePostal;

    }
}
