package fr.epsi.springjpa.repository;

public interface PersonRepositoryCustom {

    void deletePersonsWithoutAnimals();

    void generatePersons(int count);

}
