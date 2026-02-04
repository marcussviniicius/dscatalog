package com.devsuperior.dscatalog.dto;

import lombok.Data;

@Data
public class UserInsertDTO extends UserDTO{

    private String password;

    public UserInsertDTO(){
        super();
    }
}
