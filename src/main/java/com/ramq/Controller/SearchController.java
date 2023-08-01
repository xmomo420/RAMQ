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
        Dossier dossier = dossierRepository.findById(noAssuranceMaladie).orElse(null);
        Patient patient = patientRepository.findById(noAssuranceMaladie).orElse(null);

        if (dossier != null && patient != null) {
            // Dossier patient trouvé, ajout du dossier au modèle pour l'affichage dans la vue
            model.addAttribute("dossier", dossier);
            model.addAttribute("patient", patient);
            return "search"; // Correspond à la page où le résultat de la recherche est affiché
        } else {
            // Dossier patient non trouvé, ajout d'un message d'erreur au modèle pour l'affichage dans la vue
            model.addAttribute("errorMessage", "Dossier non trouvé pour le numéro d'assurance maladie saisi.");
            return "medecin"; // Redirige vers la vue medecin.html pour que le medecin puisse effectuer une autre recherche
        }
    }
}

