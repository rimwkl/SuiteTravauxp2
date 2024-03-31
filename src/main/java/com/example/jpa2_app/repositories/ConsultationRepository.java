package com.example.jpa2_app.repositories;

import com.example.jpa2_app.entities.Consultation;
import com.example.jpa2_app.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
