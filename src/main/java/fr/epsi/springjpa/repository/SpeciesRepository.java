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
    
    // Retourne la première Species dont le nom commun est égal au paramètre
    Optional<Species> findFirstByCommonName(String commonName);
    
    // Retourne une liste de Species dont le nom latin contient le paramètre en ignorant la casse
    List<Species> findByLatinNameContainingIgnoreCase(String latinName);
}
