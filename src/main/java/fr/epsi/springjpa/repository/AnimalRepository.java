package fr.epsi.springjpa.repository;

import fr.epsi.springjpa.model.Animal;
import fr.epsi.springjpa.model.Person;
import fr.epsi.springjpa.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    
    // Requête JPQL : Renvoie le nombre d'Animaux dont le Sex est égal au paramètre fourni
    @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
    Long countAnimalBySex(@Param("sex") String sex);
    
    // Requête JPQL très difficile : Renvoie un booléen si l'Animal fourni appartient à au moins une Personne
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Person p JOIN p.animals a WHERE a.id = :animalId")
    boolean isAnimalOwnedByPerson(@Param("animalId") Integer animalId);
}
