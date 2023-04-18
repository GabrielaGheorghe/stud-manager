package com.university.studmanager.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "SECRETAR")
public class Secretar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SECRETAR")
    private Long idSecretar;

    @Column(name = "NUME")
    private String nume;

    @Column(name = "PRENUME")
    private String prenume;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DEPARTAMENT", referencedColumnName = "ID_DEPARTAMENT")
    private Departament departament;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private Users user;
}
