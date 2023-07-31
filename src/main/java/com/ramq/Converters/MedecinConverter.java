package com.ramq.Converters;

import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Medecin;
import com.ramq.Dossier.Utilisateur;
import jakarta.persistence.AttributeConverter;

public class MedecinConverter implements AttributeConverter<Medecin, String> {
    @Override
    public String convertToDatabaseColumn(Medecin medecin) {
        if (medecin == null) {
            return null;
        }
        return medecin.toString();
    }

    @Override
    public Medecin convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String stringMAJ = stringBuilder.toString();
        String [] donnees = Dossier.extraireDonnees(stringMAJ, ", ");
        String noPermis = donnees[0];
        String prenom = donnees[1];
        String nom = donnees[2];
        return new Medecin(noPermis, prenom, nom);
    }
}
