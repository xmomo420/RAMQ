package com.ramq.Converters.Visite;

import com.ramq.Converters.EtablissementConverter;
import com.ramq.Converters.MedecinConverter;
import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Medecin;
import jakarta.persistence.AttributeConverter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VisiteConverter implements AttributeConverter<Dossier.Visite,
        String> {
    @Override
    public String convertToDatabaseColumn(Dossier.Visite visite) {
        if (visite != null) {
            final String SEPARATOR = ": ";
            MedecinConverter medecinConverter = new MedecinConverter();
            EtablissementConverter etablissementConverter = new EtablissementConverter();
            return visite.getDiagnosticVisite() +
                    SEPARATOR +
                    visite.getResumeeVisite() +
                    SEPARATOR +
                    visite.getTraitementVisite() +
                    SEPARATOR +
                    visite.getDateVisite().toString() +
                    SEPARATOR +
                    visite.getNotes().toString() +
                    SEPARATOR +
                    medecinConverter.convertToDatabaseColumn(visite.getMedecinVisite()) +
                    SEPARATOR +
                    etablissementConverter.convertToDatabaseColumn(visite.getEtablissement());
        } else
            return null;
    }

    @Override
    public Dossier.Visite convertToEntityAttribute(String s) {
        if (s != null) {
            String [] donnees = Dossier.extraireDonnees(s, ": ");
            String diagnosticVisite = donnees[0];
            String resume = donnees[1];
            String traitement = donnees[2];
            LocalDate date = LocalDate.parse(donnees[3]);
            StringBuilder stringBuilder = new StringBuilder(donnees[4]);
            stringBuilder.deleteCharAt(0);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            String [] notesList = stringBuilder.toString().split(", ");
            List<String> notes = Arrays.asList(notesList);
            MedecinConverter medecinConverter = new MedecinConverter();
            Medecin medecin = medecinConverter.convertToEntityAttribute(donnees[5]);
            EtablissementConverter etablissementConverter = new EtablissementConverter();
            Dossier.Etablissement etablissement = etablissementConverter.convertToEntityAttribute(donnees[6]);
            return new Dossier.Visite(etablissement, medecin, date, diagnosticVisite, traitement, resume, notes);

        } else
            return null;
    }
}
