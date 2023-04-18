package com.university.studmanager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STUDENT")
    private Long idStudent;

    @Column(name = "NR_MATRICOL")
    private String nrMatricol;

    @Column(name = "CNP")
    private String cnp;

    @Column(name = "SERIE_CI")
    private String serieCI;

    @Column(name = "NUME")
    private String nume;

    @Column(name = "PRENUME")
    private String prenume;

    @Column(name = "ADRESA")
    private String adresa;

    @Column(name = "DATA_NASTERE")
    private LocalDate dataNastere;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private Users user;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FACULTATE", referencedColumnName = "ID_FACULTATE")
    private Facultate facultate;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DEPARTAMENT", referencedColumnName = "ID_DEPARTAMENT")
    private Departament departament;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_AN", referencedColumnName = "ID_AN")
    private An an;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SERIE", referencedColumnName = "ID_SERIE")
    private Serie serie;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_GRUPA", referencedColumnName = "ID_GRUPA")
    private Grupa grupa;

}
