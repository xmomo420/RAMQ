package com.ramq.Repository;

import com.ramq.Dossier.Medecin;
import com.ramq.Dossier.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, String> {

}
