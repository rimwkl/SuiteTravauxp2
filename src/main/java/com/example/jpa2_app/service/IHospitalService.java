package com.example.jpa2_app.service;

import com.example.jpa2_app.entities.Consultation;
import com.example.jpa2_app.entities.Medecin;
import com.example.jpa2_app.entities.Patient;
import com.example.jpa2_app.entities.RendezVous;

public interface IHospitalService  {
    //methode qui permet ajouter patient ...
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
