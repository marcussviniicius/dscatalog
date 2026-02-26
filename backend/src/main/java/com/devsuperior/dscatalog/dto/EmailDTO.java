package com.devsuperior.dscatalog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    @Getter
    @NotBlank(message = "Campo obrigatório")
    @Email(message = "Email inválido")
    private String email;
}
