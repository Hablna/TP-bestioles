package fr.epsi.springjpa.repository;

import fr.epsi.springjpa.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    
    // Requête JPQL : Récupère toutes les Species ordonnées par nom commun ascendant
    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllSpeciesOrderedByCommonName();
    
    // Requête JPQL : Retourne les Species avec un nom commun LIKE le paramètre fourni
    @Query("SELECT s FROM Species s WHERE s.commonName LIKE %:commonName%")
    List<Species> findSpeciesByCommonNameLike(@Param("commonName") String commonName);
}
