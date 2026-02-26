package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.PasswordRecover;
import com.devsuperior.dscatalog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRecoverRepository extends JpaRepository<PasswordRecover, Long> {

}
