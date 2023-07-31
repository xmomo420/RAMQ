package com.ramq.Dossier;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medecin {

    @Override
    public String toString() {
        return "{" +  noPermisMedical + ", " + prenom + ", " + nom + "}";
    }

    @Id
    private String noPermisMedical;
    private String prenom;
    private String nom;
}
