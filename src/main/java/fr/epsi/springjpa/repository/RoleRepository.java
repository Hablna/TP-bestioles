package fr.epsi.springjpa.repository;

import fr.epsi.springjpa.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    // Méthodes de recherche dérivées
    Optional<Role> findByLabel(String label);
    
    List<Role> findByLabelContainingIgnoreCase(String label);
}
