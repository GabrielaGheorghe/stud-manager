package com.university.studmanager.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {

    private Long idSerie;
    private String denumire;
    private Long idAn;
}
