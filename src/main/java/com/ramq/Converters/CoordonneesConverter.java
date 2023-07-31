package com.ramq.Converters;

import com.ramq.Dossier.Coordonnees;
import com.ramq.Dossier.Dossier;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;

public class CoordonneesConverter implements AttributeConverter<Coordonnees,
        String> {
    @Override
    public String convertToDatabaseColumn(Coordonnees coordonnees) {
        if (coordonnees != null) {
            final String SEPARATOR = ", ";
            AdresseConverter adresseConverter = new AdresseConverter();
            return adresseConverter.convertToDatabaseColumn(coordonnees.getAdresse()) +
                    SEPARATOR +
                    coordonnees.getCourriel() +
                    SEPARATOR +
                    coordonnees.getNoTelephone();
        } else
            return null;

    }

    @Override
    public Coordonnees convertToEntityAttribute(String s) {
        if (s != null) {
            AdresseConverter adresseConverter = new AdresseConverter();
            String[] donnees = s.split(", ");
            Coordonnees.Adresse adresse =
                    adresseConverter.convertToEntityAttribute(donnees[0] + ", " + donnees[1] + ", " + donnees[2] + ", " + donnees[3]);
            String courriel = donnees[4];
            String noTel = donnees[5];
            return new Coordonnees(noTel, courriel, adresse);
        } else
            return null;
    }
}
