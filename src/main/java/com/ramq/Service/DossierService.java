package com.ramq.Service;

import com.ramq.Dossier.Dossier;
import com.ramq.Repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DossierService {

    private final DossierRepository dossierRepository;

    @Autowired
    public DossierService(DossierRepository dossierRepository) {
        this.dossierRepository = dossierRepository;
    }

    public void creerDossier(Dossier dossier) {
        dossierRepository.save(dossier);
    }
}
