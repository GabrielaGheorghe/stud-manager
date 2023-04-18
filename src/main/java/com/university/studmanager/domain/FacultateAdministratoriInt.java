package com.university.studmanager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "FACULTATE_ADMINISTRATORI_INT")
public class FacultateAdministratoriInt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FACULTATE_ADMINISTRATORI")
    private Long idFacultateAdministratori;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_FACULTATE")
    private Facultate facultate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ID_ADMINISTRATOR")
    private Administrator administrator;
}
