package com.ramq.Converters.Parent;

import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Patient;
import jakarta.persistence.AttributeConverter;

public class ParentConverter implements AttributeConverter<Patient.Parent,
        String> {
    @Override
    public String convertToDatabaseColumn(Patient.Parent parent) {
        if (parent != null) {
            final String SEPARATOR = ", ";
            return parent.getPrenomParent() +
                    SEPARATOR +
                    parent.getNomParent() +
                    SEPARATOR +
                    parent.isEstBiologique();
        } else
            return null;
    }

    @Override
    public Patient.Parent convertToEntityAttribute(String s) {
        if (s != null) {
            String [] donnees = Dossier.extraireDonnees(s, ", ");
            String prenom = donnees[0];
            String nom = donnees[1];
            boolean estBio = donnees[2].equals("true");
            return new Patient.Parent(prenom, nom, estBio);
        } else
            return null;
    }
}
