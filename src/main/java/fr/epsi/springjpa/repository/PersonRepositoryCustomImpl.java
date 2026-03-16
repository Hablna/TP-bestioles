package fr.epsi.springjpa.repository;

import fr.epsi.springjpa.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    private static final String[] FIRSTNAMES = {
        "Alice", "Bob", "Charlie", "Diana", "Eve",
        "Frank", "Grace", "Hugo", "Iris", "Jules"
    };

    private static final String[] LASTNAMES = {
        "Martin", "Bernard", "Dupont", "Durand", "Leroy",
        "Moreau", "Simon", "Laurent", "Petit", "Roux"
    };

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deletePersonsWithoutAnimals() {
        entityManager.createQuery(
            "DELETE FROM Person p WHERE p.animals IS EMPTY"
        ).executeUpdate();
    }

    @Override
    public void generatePersons(int count) {
        for (int i = 0; i < count; i++) {
            String firstname = FIRSTNAMES[(int) (Math.random() * FIRSTNAMES.length)];
            String lastname  = LASTNAMES[(int) (Math.random() * LASTNAMES.length)];
            String login     = (firstname + "." + lastname + i).toLowerCase();
            int age          = 18 + (int) (Math.random() * 50);

            Person person = new Person(firstname, lastname, login, "password");
            person.setAge(age);
            entityManager.persist(person);
        }
    }

}
