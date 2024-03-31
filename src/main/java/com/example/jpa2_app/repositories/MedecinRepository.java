package com.example.jpa2_app.repositories;

import com.example.jpa2_app.entities.Medecin;
import com.example.jpa2_app.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
