package com.university.studmanager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "ADMINISTRATOR")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ADMINISTRATOR")
    private Long idAdministrator;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private Users user;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "FACULTATE_ADMINISTRATORI_INT",
            joinColumns = @JoinColumn(name = "ID_ADMINISTRATOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_FACULTATE"))
    private Set<Facultate> facultati = new HashSet<>();
}
