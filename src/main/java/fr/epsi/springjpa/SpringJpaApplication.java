package fr.epsi.springjpa;

import fr.epsi.springjpa.model.Animal;
import fr.epsi.springjpa.repository.AnimalRepository;
import fr.epsi.springjpa.repository.PersonRepository;
import fr.epsi.springjpa.repository.RoleRepository;
import fr.epsi.springjpa.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {
    // Mauvaise pratique
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n========== AFFICHAGE DES DONNÉES ==========\n");

        // Afficher toutes les espèces
        System.out.println("===== SPECIES (findAll) =====");
        speciesRepository.findAll().forEach(species -> {
            System.out.println(species);
        });

        // Afficher tous les animaux
        System.out.println("\n===== ANIMALS (findAll) =====");
        animalRepository.findAll().forEach(animal -> {
            System.out.println(animal);
        });

        // Afficher toutes les personnes
        System.out.println("\n===== PERSONS (findAll) =====");
        personRepository.findAll().forEach(person -> {
            System.out.println(person);
        });

        // Afficher tous les rôles
        System.out.println("\n===== ROLES (findAll) =====");
        roleRepository.findAll().forEach(role -> {
            System.out.println(role);
        });

        System.out.println("\n========== FIN ==========\n");

        //test findBySpecies
        List<Animal> animaux = animalRepository.findBySpecies(speciesRepository.findById(1).orElseThrow());
        System.out.println("Animaux de la species 1 : " + animaux);
    }

}
