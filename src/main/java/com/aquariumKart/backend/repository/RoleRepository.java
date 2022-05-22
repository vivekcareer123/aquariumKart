package com.aquariumKart.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquariumKart.backend.entities.users.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
