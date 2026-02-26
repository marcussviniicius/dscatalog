package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDTO {
    @Setter
    private Long id;
    @Setter
    @NotBlank(message = "Campo obrigatório")
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    @NotBlank(message = "Favor entrar com um email válido")
    private String email;

    Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(User entity){
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }
}
