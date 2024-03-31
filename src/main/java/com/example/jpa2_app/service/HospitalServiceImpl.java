package com.example.jpa2_app.service;

import com.example.jpa2_app.entities.Consultation;
import com.example.jpa2_app.entities.Medecin;
import com.example.jpa2_app.entities.Patient;
import com.example.jpa2_app.entities.RendezVous;
import com.example.jpa2_app.repositories.ConsultationRepository;
import com.example.jpa2_app.repositories.MedecinRepository;
import com.example.jpa2_app.repositories.PatientRepository;
import com.example.jpa2_app.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

//les objets de la couche metier utilise annotation service
//je voudrais toutes les methodes soit transa
@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    //appel a les interfaces  et on suite on va faire linjection des depandance soit jutilise solution 1:@autowired pour chaque interface
    //solution 2 : faire le constructeur
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString()); //generer une chaine aleatoire unique
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
