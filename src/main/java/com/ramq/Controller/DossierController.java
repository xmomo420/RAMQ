package com.ramq.Controller;

import com.ramq.Dossier.Coordonnees;
import com.ramq.Dossier.Dossier;
import com.ramq.Dossier.Medecin;
import com.ramq.Dossier.Patient;
import com.ramq.Repository.DossierRepository;
import com.ramq.Repository.MedecinRepository;
import com.ramq.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DossierController {

    private final DossierRepository dossierRepository;
    private final MedecinRepository medecinRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public DossierController(DossierRepository dossierRepository, MedecinRepository medecinRepository, PatientRepository patientRepository) {
        this.dossierRepository = dossierRepository;
        this.medecinRepository = medecinRepository;
        this.patientRepository = patientRepository;
    }


    @GetMapping("/search")
    public String afficherFormulaire(Model model) {
        model.addAttribute("antecedant", new Dossier.Antecedant());
        return "search";
    }

    @PostMapping("/ajouter-antecedant")
    public String ajouterAntecedant(@RequestParam("noAssuranceMaladie") String noAssuranceMaladie,
                                    @RequestParam("diagnostic") String diagnostic,
                                    @RequestParam("traitement") String traitement,
                                    @RequestParam("debutMaladie") LocalDate debutMaladie,
                                    @RequestParam("finMaladie") LocalDate finMaladie,
                                    Model model, RedirectAttributes redirectAttributes) {
        // Recherchez le dossier du patient par le numéro d'assurance maladie
        Dossier dossier = dossierRepository.findById(noAssuranceMaladie).orElse(null);
        if (dossier != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Medecin medecin = medecinRepository.findById(authentication.getName()).orElse(null);
            if (medecin != null) {
                // Créer l'antecédant
                Dossier.Antecedant antecedant = new Dossier.Antecedant();
                antecedant.setDiagnostic(diagnostic);
                antecedant.setTraitement(traitement);
                antecedant.setDebutMaladie(debutMaladie);
                antecedant.setFinMaladie(finMaladie);
                antecedant.setMedecinTraitant(medecin);
                // Copier la liste
                List<Dossier.Antecedant> antecedantList = new ArrayList<>(dossier.getAntecedants());
                // Ajouter la visite à la liste des visites du dossier
                antecedantList.add(antecedant);
                dossier.setAntecedants(antecedantList);
                dossierRepository.save(dossier); // Sauvegarder le dossier mis à jour dans la base de données
                redirectAttributes.addFlashAttribute("succesAnt", "Antécédant ajouté avec succès !");
            } else
                model.addAttribute("errorSaveAnt", "Erreur lors de la sauvegarde");
        } else {
            model.addAttribute("errorSaveAnt", "Erreur lors de la sauvegarde");
            // Gérer le cas où le dossier n'a pas été trouvé (afficher un message d'erreur par exemple)
        }
        // Ajoutez l'objet dossier en tant qu'attribut de redirection
        redirectAttributes.addFlashAttribute("dossier", dossier);
        return "redirect:/search";
    }

    @PostMapping("/ajouter-visite")
    public String ajouterVisite(@RequestParam("noAssuranceMaladie") String noAssuranceMaladie,
                                @RequestParam("nomEtablissement") String nomEtablissement,
                                @RequestParam("rue") String rue,
                                @RequestParam("ville") String ville,
                                @RequestParam("province") Coordonnees.Provinces province,
                                @RequestParam("codePostal") String codePostal,
                                @RequestParam("dateVisite") LocalDate dateVisite,
                                @RequestParam("diagnostic") String diagnostic,
                                @RequestParam("traitement") String traitement,
                                @RequestParam("resume") String resume,
                                @RequestParam("note") String note,
                                Model model, RedirectAttributes redirectAttributes) {
        // Recherchez le dossier du patient par le numéro d'assurance maladie
        Dossier dossier = dossierRepository.findById(noAssuranceMaladie).orElse(null);
        if (dossier != null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Medecin medecin = medecinRepository.findById(authentication.getName()).orElse(null);
            if (medecin != null) {
                Dossier.Visite visite = new Dossier.Visite();
                List<String> notesAjoutees = new ArrayList<>();
                notesAjoutees.add(note);
                Coordonnees.Adresse adresse = new Coordonnees.Adresse(rue, ville, province, codePostal);
                Dossier.Etablissement etablissement = new Dossier.Etablissement(nomEtablissement, adresse);
                visite.setEtablissement(etablissement);
                visite.setMedecinVisite(medecin);
                visite.setDiagnosticVisite(diagnostic);
                visite.setTraitementVisite(traitement);
                visite.setDateVisite(dateVisite);
                visite.setNotes(notesAjoutees);
                visite.setResumeeVisite(resume);
                // Copier la liste des visites
                List<Dossier.Visite> visites = new ArrayList<>(dossier.getVisites());
                visites.add(visite);
                dossier.setVisites(visites);
                // Ajouter la visite à la liste des visites du dossier
                dossierRepository.save(dossier); // Sauvegarder le dossier mis à jour dans la base de données
                redirectAttributes.addFlashAttribute("succesVisit", "Visite ajoutée avec succès !");
            } else
                model.addAttribute("errorSaveVis", "Erreur lors de la sauvegarde");
        } else {
            model.addAttribute("errorSaveVis", "Erreur lors de la sauvegarde");
            // Gérer le cas où le dossier n'a pas été trouvé (afficher un message d'erreur par exemple)
        }
        redirectAttributes.addFlashAttribute("dossier", dossier);
        return "redirect:/search";
    }



}
