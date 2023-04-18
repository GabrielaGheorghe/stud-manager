package com.university.studmanager.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaterieDTO {

    private String denumire;
    private Long nrOre;
    private Long semestru;
    private Long idAn;
    private Long idPlanInvatamant;
}
