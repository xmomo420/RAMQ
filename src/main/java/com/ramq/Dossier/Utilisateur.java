package com.ramq.Dossier;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    @Id
    String identifiant;
    String motDePasse;
    String courriel;
    String prenom;
    String nom;

}
