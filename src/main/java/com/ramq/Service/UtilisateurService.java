package com.ramq.Service;

import com.ramq.Dossier.Utilisateur;
import com.ramq.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public void creerUtilisateur(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public Utilisateur getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (Utilisateur) auth.getPrincipal();
    }

    @Override
    public UserDetails loadUserByUsername(String identifiant) throws UsernameNotFoundException {
        return utilisateurRepository.findById(identifiant)
                .orElseThrow(() -> new UsernameNotFoundException("id pas trouvé " + identifiant));
    }
}
