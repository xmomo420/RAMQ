package com.ramq.Converters.Parent;

import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Patient;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class ParentListConverter implements AttributeConverter<List<Patient.Parent>,
        String> {

    @Override
    public String convertToDatabaseColumn(List<Patient.Parent> parents) {
        if (parents == null) {
            return null;
        }
        return parents.toString();
    }

    @Override
    public List<Patient.Parent> convertToEntityAttribute(String string) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String stringMAJ = stringBuilder.toString();
        String [] arrayParent = Dossier.extraireDonnees(stringMAJ,", }");
        System.out.println(Arrays.toString(arrayParent));
        ParentConverter parentConverter = new ParentConverter();
        return Arrays.stream(arrayParent).map(parentConverter::convertToEntityAttribute).toList();
    }
}
