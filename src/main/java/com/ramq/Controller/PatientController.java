package com.ramq.Controller;

import com.ramq.Dossier.Coordonnees;
import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Patient;
import com.ramq.Repository.PatientRepository;
import com.ramq.Service.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {

    private final DossierService dossierService;

    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(DossierService dossierService, PatientRepository patientRepository) {
        this.dossierService = dossierService;
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patient")
    public String patientPage(Model model) {
        Dossier dossier = dossierService.getDossierForLoggedPatient();
        model.addAttribute("dossier", dossier);
        Patient patient = patientRepository.findById(dossier.getNoAssuranceMaladie())
                .orElseThrow(() -> new UsernameNotFoundException("pas trouvé"));
        model.addAttribute("patient", patient);
        return "patient";
    }

    @PostMapping("/modifier-coordonnees")
    public String modifierCoordonnees(@ModelAttribute Patient patient) {
        // Récupérer le patient à partir de la base de données en utilisant son numéro d'assurance maladie
        Patient existingPatient = patientRepository.findById(patient.getNoAssuranceMaladie())
                .orElseThrow(() -> new UsernameNotFoundException("Patient introuvable pour le numéro d'assurance maladie : " + patient.getNoAssuranceMaladie()));

        // Mettre à jour les coordonnées du patient existant avec les nouvelles coordonnées soumises
        existingPatient.setCoordonneesPatient(patient.getCoordonneesPatient());

        // Sauvegarder les modifications dans la base de données
        patientRepository.save(existingPatient);

        // Rediriger l'utilisateur vers une autre page (par exemple, la page de profil du patient mis à jour)
        return "redirect:/patient"; // Remplacez "/patient" par l'URL de la page appropriée
    }
}
