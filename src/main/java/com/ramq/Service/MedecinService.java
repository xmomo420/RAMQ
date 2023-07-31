package com.ramq.Service;

import com.ramq.Dossier.Medecin;
import com.ramq.Repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedecinService {

    private final MedecinRepository medecinRepository;

    @Autowired
    public MedecinService(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    public void creerMedecin(Medecin medecin) {
        medecinRepository.save(medecin);
    }
}
