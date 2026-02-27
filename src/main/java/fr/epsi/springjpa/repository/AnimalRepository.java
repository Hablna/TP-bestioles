package fr.epsi.springjpa.repository;

import fr.epsi.springjpa.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    // On pourra ne pas ajouter de méthodes de recherche spécifiques, car les méthodes génériques de JpaRepository suffisent pour la plupart des cas.
    List<Animal> findByName(String name);
    
    List<Animal> findBySex(String sex);
    
    List<Animal> findByColor(String color);
    
    List<Animal> findBySpeciesId(Integer speciesId);
    
    List<Animal> findByNameContainingIgnoreCase(String name);
}
