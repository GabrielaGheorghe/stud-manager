package com.university.studmanager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "CATALOG")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATALOG", nullable = false, updatable = false)
    private Long idCatalog;

    @Column(name = "NOTA")
    private Long nota;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_STUDENT", referencedColumnName = "ID_STUDENT")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_MATERIE", referencedColumnName = "ID_MATERIE")
    private Materie materie;
}
