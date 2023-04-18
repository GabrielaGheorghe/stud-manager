package com.university.studmanager.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long idStudent;
    private String nrMatricol;
    private String cnp;
    private String serieCI;
    private String nume;
    private String prenume;
    private String adresa;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private LocalDate dataNastere;
    private Long idFacultate;
    private Long idDepartament;
    private Long idAn;
    private Long idSerie;
    private Long idGrupa;
}
