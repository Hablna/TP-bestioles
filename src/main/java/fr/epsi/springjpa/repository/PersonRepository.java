package fr.epsi.springjpa.repository;

import fr.epsi.springjpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    
    // Méthodes de recherche dérivées
    Optional<Person> findByLogin(String login);
    
    List<Person> findByActiveTrue();
    
    List<Person> findByActiveFalse();
    
    List<Person> findByAgeGreaterThan(Integer age);
    
    List<Person> findByFirstnameContainingIgnoreCase(String firstname);
    
    List<Person> findByLastnameContainingIgnoreCase(String lastname);
    
    // Retourne les personnes ayant pour nom le premier paramètre ou pour prénom le second paramètre
    List<Person> findByLastnameOrFirstname(String lastname, String firstname);
    
    // Retourne toutes les personnes d'un âge supérieur ou égal au paramètre
    List<Person> findByAgeGreaterThanEqual(Integer age);
}
