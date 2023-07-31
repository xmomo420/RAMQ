package com.ramq.Converters;

import com.ramq.Dossier.Coordonnees;
import com.ramq.Dossier.Dossier;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;

public class AdresseConverter implements AttributeConverter<Coordonnees.Adresse, String> {
    @Override
    public String convertToDatabaseColumn(Coordonnees.Adresse adresse) {
        if (adresse != null) {
            final String SEPARATOR = ", ";
            return adresse.getRue() +
                    SEPARATOR +
                    adresse.getVille() +
                    SEPARATOR +
                    adresse.getProvince() +
                    SEPARATOR +
                    adresse.getCodePostal();
        } else
            return null;
    }

    @Override
    public Coordonnees.Adresse convertToEntityAttribute(String s) {
        if (s != null) {
            String[] donnees = Dossier.extraireDonnees(s, ", ");
            String rue = donnees[0];
            String ville = donnees[1];
            Coordonnees.Provinces province =
                    Coordonnees.Provinces.valueOf(donnees[2]);
            String codePostal = donnees[3];
            return new Coordonnees.Adresse(rue, ville, province, codePostal);
        } else
            return null;
    }
}
