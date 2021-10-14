package ua.com.autoplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.autoplus.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
