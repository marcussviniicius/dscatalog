package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDTO {

    private Long id;
    private String authority;

    public RoleDTO(Role entity){
        this.id = entity.getId();
        this.authority = entity.getAuthority();
    }
}
