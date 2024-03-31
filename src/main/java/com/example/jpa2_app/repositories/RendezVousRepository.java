package com.example.jpa2_app.repositories;

import com.example.jpa2_app.entities.Patient;
import com.example.jpa2_app.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String > {
}
