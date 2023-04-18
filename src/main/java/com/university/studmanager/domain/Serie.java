package com.university.studmanager.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERIE")
    private Long idSerie;

    @Column(name = "DENUMIRE")
    private String denumire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_AN", referencedColumnName = "ID_AN")
    @JsonBackReference
    private An an;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "serie")
    private List<Grupa> grupe;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "serie")
    private List<Student> studenti;

}
