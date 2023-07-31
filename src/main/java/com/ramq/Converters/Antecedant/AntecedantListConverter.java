package com.ramq.Converters.Antecedant;

import com.ramq.Converters.Visite.VisiteConverter;
import com.ramq.Dossier.Dossier;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class AntecedantListConverter implements AttributeConverter<List<Dossier.Antecedant>,String> {

    @Override
    public String convertToDatabaseColumn(List<Dossier.Antecedant> antecedants) {
        if (antecedants == null) {
            return null;
        }
        return antecedants.toString();
    }

    @Override
    public List<Dossier.Antecedant> convertToEntityAttribute(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String stringMAJ = stringBuilder.toString();
        String [] arrayAntecedant = Dossier.extraireDonnees(stringMAJ,";,");
        AntecedantConverter antecedantConverter = new AntecedantConverter();
        return Arrays.stream(arrayAntecedant).map(antecedantConverter::convertToEntityAttribute).toList();
    }
}
