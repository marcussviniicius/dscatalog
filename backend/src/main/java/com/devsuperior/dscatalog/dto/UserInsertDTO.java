package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.services.validation.UserInsertValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@UserInsertValid
public class UserInsertDTO extends UserDTO{

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 8, message = "Deve ter no mínimo 8 caracteres")
    private String password;

    public UserInsertDTO(){
        super();
    }
}
