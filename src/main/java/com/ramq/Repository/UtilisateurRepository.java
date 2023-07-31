package com.ramq.Repository;

import com.ramq.Dossier.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    Utilisateur findByIdentifiant(String identifiant);
}
