package fr.epsi.springjpa.repository;

import fr.epsi.springjpa.model.Animal;
import fr.epsi.springjpa.model.Species;
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
    
    // Retourne tous les animaux de la Species fournie en paramètre
    List<Animal> findBySpecies(Species species);
    
    // Retourne tous les animaux dont la couleur fait partie de la liste fournie
    List<Animal> findByColorIn(List<String> colors);
}
