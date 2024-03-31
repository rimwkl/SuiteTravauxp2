package com.example.jpa2_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Collections;

import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    //valeur du rendezvous cest attribut patient qui est dans la classe patient
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    //un patient il peut effectuer plusieurs rendezvous
    //je dois mettre REndezvous comme une entite jpa
    private Collection<RendezVous>rendezVous;

}
