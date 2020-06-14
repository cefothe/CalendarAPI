package com.stefanangelov.authentication.persistence.repository;

import com.stefanangelov.authentication.persistence.entity.Role;
import com.stefanangelov.authentication.persistence.entity.Role.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleType name);
}
