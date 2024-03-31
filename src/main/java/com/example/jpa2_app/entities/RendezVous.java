package com.example.jpa2_app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id
    private String id;
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/
    private Date date;
    // cest un type numerique ordinaire mais si je veux la stocker format string
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //tu vas prendre en consideration cette attribut quand je fait ajout et nont pas  eciture
    //un rend concerne un medecin et un patient
    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
