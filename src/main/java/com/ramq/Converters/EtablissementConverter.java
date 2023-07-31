package com.ramq.Converters;

import com.ramq.Dossier.Coordonnees;
import com.ramq.Dossier.Dossier;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;

public class EtablissementConverter implements AttributeConverter<Dossier.Etablissement, String> {
    @Override
    public String convertToDatabaseColumn(Dossier.Etablissement etablissement) {
        if (etablissement != null) {
            final String SEPARATOR = ", ";
            AdresseConverter adresseConverter = new AdresseConverter();
            return etablissement.getNomEtablissement() +
                    SEPARATOR +
                    adresseConverter.convertToDatabaseColumn(etablissement.getAdresseEtablissement());
        } else
            return null;
    }

    @Override
    public Dossier.Etablissement convertToEntityAttribute(String s) {
        String [] donnees = Dossier.extraireDonnees(s, ", ");
        String nom = donnees[0];
        AdresseConverter adresseConverter = new AdresseConverter();
        Coordonnees.Adresse adresse =
                adresseConverter.convertToEntityAttribute(donnees[1] + ", " + donnees[2] + ", " + donnees[3] + ", " + donnees[4]);
        return new Dossier.Etablissement(nom, adresse);
    }
}
