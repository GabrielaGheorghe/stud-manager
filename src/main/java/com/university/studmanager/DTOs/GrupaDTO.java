package com.university.studmanager.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrupaDTO {

    private Long idGrupa;
    private String denumire;
    private Long idSerie;

}
