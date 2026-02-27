package fr.epsi.springjpa.repository;

import fr.epsi.springjpa.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    
    // Méthodes de recherche dérivées
    Optional<Species> findByCommonName(String commonName);
    
    Optional<Species> findByLatinName(String latinName);
    
    List<Species> findByCommonNameContainingIgnoreCase(String commonName);
}
