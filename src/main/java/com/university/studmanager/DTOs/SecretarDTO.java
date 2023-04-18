package com.university.studmanager.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SecretarDTO {

    private String nume;
    private String prenume;
    private Long idDepartament;
}
