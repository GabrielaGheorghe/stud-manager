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
@Table(name = "MATERIE")
public class Materie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIE", nullable = false, updatable = false)
    private Long idMaterie;

    @Column(name = "DENUMIRE")
    private String denumire;

    @Column(name = "NR_ORE")
    private Long nrOre;

    @Column(name = "SEMESTRU")
    private Long semestru;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_AN", referencedColumnName = "ID_AN")
    private An an;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PLAN_INVATAMANT", referencedColumnName = "ID_PLAN_INVATAMANT")
    private PlanInvatamant planInvatamant;
}
