package com.project.myCv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.myCv.model.Role;

/**
 * @author Karen 21 de fev de 2018
 */

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
