package com.ramq.Service;

import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Utilisateur;
import com.ramq.Repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DossierService {

    private final DossierRepository dossierRepository;
    private final UtilisateurService utilisateurService;
    @Autowired
    public DossierService(DossierRepository dossierRepository, UtilisateurService utilisateurService) {
        this.dossierRepository = dossierRepository;
        this.utilisateurService = utilisateurService;
    }

    public Dossier getDossierForLoggedPatient() {
        Utilisateur loggedUser = utilisateurService.getLoggedUser();
        String noAssuranceMaladie = loggedUser.getIdentifiant();

        return dossierRepository.findById(noAssuranceMaladie)
                .orElseThrow(() -> new UsernameNotFoundException("Aucun dossier ne correspond au numéro d'assurance maladie : " + noAssuranceMaladie));
    }

    public void creerDossier(Dossier dossier) {
        dossierRepository.save(dossier);
    }
}
