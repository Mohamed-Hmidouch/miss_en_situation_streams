package com.streams.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamExercisesBasicTest {

    private StreamExercisesBasic exercises;
    private List<Person> personnes;

    @BeforeEach
    void setUp() {
        exercises = new StreamExercisesBasic();
        personnes = Arrays.asList(
                new Person("Alice", 25, "Paris", 35000),
                new Person("Bob", 35, "Lyon", 45000),
                new Person("Charlie", 28, "Paris", 40000),
                new Person("David", 42, "Marseille", 55000),
                new Person("Eve", 31, "Paris", 38000),
                new Person("Frank", 29, "Lyon", 42000),
                new Person("Grace", 22, "Marseille", 32000)
        );
    }

    @Test
    void testFilterPersonnesPlus30Ans() {
        List<Person> result = exercises.filterPersonnesPlus30Ans(personnes);
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(p -> p.getAge() > 30));
    }

    @Test
    void testGetNoms() {
        List<String> result = exercises.getNoms(personnes);
        assertEquals(7, result.size());
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("Bob"));
    }

    @Test
    void testGetNomsPersonnesPlus25Ans() {
        List<String> result = exercises.getNomsPersonnesPlus25Ans(personnes);
        assertEquals(5, result.size());
        assertFalse(result.contains("Grace"));
        assertFalse(result.contains("Alice"));
    }

    @Test
    void testCompterPersonnesAParis() {
        long result = exercises.compterPersonnesAParis(personnes);
        assertEquals(3, result);
    }

    @Test
    void testToutesPersonnesMajeures() {
        boolean result = exercises.toutesPersonnesMajeures(personnes);
        assertTrue(result);
    }

    @Test
    void testExistePersonneAvecSalaireEleve() {
        boolean result = exercises.existePersonneAvecSalaireEleve(personnes);
        assertTrue(result);
    }

    @Test
    void testTrierParAge() {
        List<Person> result = exercises.trierParAge(personnes);
        assertEquals("Grace", result.get(0).getNom());
        assertEquals("David", result.get(result.size() - 1).getNom());
    }

    @Test
    void testGetTroisPremieres() {
        List<Person> result = exercises.getTroisPremieres(personnes);
        assertEquals(3, result.size());
        assertEquals("Alice", result.get(0).getNom());
    }

    @Test
    void testIgnorerDeuxPremieres() {
        List<Person> result = exercises.ignorerDeuxPremieres(personnes);
        assertEquals(5, result.size());
        assertEquals("Charlie", result.get(0).getNom());
    }

    @Test
    void testGetVillesDistinctes() {
        List<String> result = exercises.getVillesDistinctes(personnes);
        assertEquals(3, result.size());
        assertTrue(result.contains("Paris"));
        assertTrue(result.contains("Lyon"));
        assertTrue(result.contains("Marseille"));
    }
}
