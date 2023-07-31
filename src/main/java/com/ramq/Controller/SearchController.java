package com.ramq.Controller;

import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Patient;
import com.ramq.Repository.DossierRepository;
import com.ramq.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    private final DossierRepository dossierRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public SearchController(DossierRepository dossierRepository, PatientRepository patientRepository) {
        this.dossierRepository = dossierRepository;
        this.patientRepository = patientRepository;
    }

    // ... autres méthodes du contrôleur ...

    @PostMapping("/search")
    public String searchPatient(@RequestParam("noAssuranceMaladie") String noAssuranceMaladie, Model model) {
        // Recherche du dossier patient par numéro d'assurance maladie dans la base de données
        Dossier dossier = dossierRepository.findById(noAssuranceMaladie)
                .orElseThrow(() -> new UsernameNotFoundException("Aucun dossier ne correspond à ce numéro d'assurance maladie : " + noAssuranceMaladie));
        Patient patient = patientRepository.findById(noAssuranceMaladie)
                .orElseThrow(() -> new UsernameNotFoundException("Aucun patient avec ce numéro d'assurance : " + noAssuranceMaladie));

        if (dossier != null) {
            // Dossier patient trouvé, ajout du dossier au modèle pour l'affichage dans la vue
            model.addAttribute("dossier", dossier);
        } else {
            // Dossier patient non trouvé, ajout d'un message d'erreur au modèle pour l'affichage dans la vue
            model.addAttribute("errorMessage", "Dossier non trouvé pour le numéro d'assurance maladie saisi.");
        }
        if (patient != null) {
            // Patient trouvé, ajout du patient au modèle pour l'affichage dans la vue
            model.addAttribute("patient", patient);
        } else {
            // Patient non trouvé, ajout d'un message d'erreur au modèle pour l'affichage dans la vue
            model.addAttribute("errorMessage", "Patient non trouvé pour le numéro d'assurance maladie saisi.");
        }

        return "search"; // Redirige vers la vue search.html après le traitement de la recherche
    }


}

