package com.university.studmanager.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "PLAN_INVATAMANT")
public class PlanInvatamant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLAN_INVATAMANT")
    private Long idPlanInvatamant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_AN", referencedColumnName = "ID_AN")
    private An an;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "planInvatamant")
    private List<Materie> materii;
}
