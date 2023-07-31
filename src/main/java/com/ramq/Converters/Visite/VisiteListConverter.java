package com.ramq.Converters.Visite;

import com.ramq.Converters.EtablissementConverter;
import com.ramq.Dossier.Dossier;
import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.List;

public class VisiteListConverter implements AttributeConverter<List<Dossier.Visite>,
        String> {

    @Override
    public String convertToDatabaseColumn(List<Dossier.Visite> visites) {
        if (visites != null) {
            VisiteConverter visiteConverter = new VisiteConverter();
            StringBuilder retour = new StringBuilder();
            final String SEPARATOR = "; ";
            int i = 0;
            for (Dossier.Visite vis: visites) {
                retour.append(visiteConverter.convertToDatabaseColumn(vis));
                if (i < visites.size() - 1)
                    retour.append(SEPARATOR);
                i++;
            }
            return retour.toString();
        } else
            return null;
    }

    @Override
    public List<Dossier.Visite> convertToEntityAttribute(String s) {
        String [] arrayVisite = Dossier.extraireDonnees(s,"; ");
        VisiteConverter visiteConverter = new VisiteConverter();
        return Arrays.stream(arrayVisite).map(visiteConverter::convertToEntityAttribute).toList();
    }
}
