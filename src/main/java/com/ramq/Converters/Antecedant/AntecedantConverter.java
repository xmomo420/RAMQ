package com.ramq.Converters.Antecedant;

import com.ramq.Converters.MedecinConverter;
import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Medecin;
import com.ramq.Dossier.Patient;
import jakarta.persistence.AttributeConverter;

import java.time.LocalDate;

public class AntecedantConverter implements AttributeConverter<Dossier.Antecedant, String> {

    @Override
    public String convertToDatabaseColumn(Dossier.Antecedant antecedant) {
        if (antecedant == null) {
            return null;
        } else {
            return antecedant.toString();
        }
    }

    @Override
    public Dossier.Antecedant convertToEntityAttribute(String s) {
        if (s != null) {
            StringBuilder stringBuilder = new StringBuilder(s);
            stringBuilder.deleteCharAt(0);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String stringMAJ = stringBuilder.toString();
            String [] donnees = Dossier.extraireDonnees(stringMAJ, ", ");
            String diagnostic = donnees[0];
            String traitement = donnees[1];
            LocalDate debut = LocalDate.parse(donnees[2]);
            LocalDate fin = LocalDate.parse(donnees[3]);
            MedecinConverter medecinConverter = new MedecinConverter();
            Medecin medecin = medecinConverter.convertToEntityAttribute(donnees[4] + ", " + donnees[5] + ", " + donnees[6]);
            return new Dossier.Antecedant(diagnostic, traitement, medecin, debut, fin);
        } else
            return null;
    }

}
