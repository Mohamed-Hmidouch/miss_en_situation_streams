package com.streams.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StreamExercisesIntermediateTest {

    private StreamExercisesIntermediate exercises;
    private List<Person> personnes;

    @BeforeEach
    void setUp() {
        exercises = new StreamExercisesIntermediate();
        personnes = Arrays.asList(
                new Person("Alice", 25, "Paris", 35000),
                new Person("Bob", 35, "Lyon", 45000),
                new Person("Charlie", 28, "Paris", 40000),
                new Person("David", 42, "Marseille", 55000),
                new Person("Eve", 31, "Paris", 38000)
        );
    }

    @Test
    void testCalculerSommeSalaires() {
        double result = exercises.calculerSommeSalaires(personnes);
        assertEquals(213000, result, 0.01);
    }

    @Test
    void testCalculerMoyenneAge() {
        double result = exercises.calculerMoyenneAge(personnes);
        assertEquals(32.2, result, 0.1);
    }

    @Test
    void testTrouverSalaireMax() {
        Optional<Double> result = exercises.trouverSalaireMax(personnes);
        assertTrue(result.isPresent());
        assertEquals(55000, result.get(), 0.01);
    }

    @Test
    void testTrouverPersonnePlusAgee() {
        Optional<Person> result = exercises.trouverPersonnePlusAgee(personnes);
        assertTrue(result.isPresent());
        assertEquals("David", result.get().getNom());
    }

    @Test
    void testGrouperParVille() {
        Map<String, List<Person>> result = exercises.grouperParVille(personnes);
        assertEquals(3, result.size());
        assertEquals(3, result.get("Paris").size());
        assertEquals(1, result.get("Lyon").size());
        assertEquals(1, result.get("Marseille").size());
    }

    @Test
    void testCompterParVille() {
        Map<String, Long> result = exercises.compterParVille(personnes);
        assertEquals(3, result.size());
        assertEquals(3L, result.get("Paris"));
        assertEquals(1L, result.get("Lyon"));
    }

    @Test
    void testPartitionnerParSalaire() {
        Map<Boolean, List<Person>> result = exercises.partitionnerParSalaire(personnes);
        assertEquals(2, result.get(true).size());
        assertEquals(3, result.get(false).size());
    }

    @Test
    void testCreerMapNomAge() {
        Map<String, Integer> result = exercises.creerMapNomAge(personnes);
        assertEquals(5, result.size());
        assertEquals(25, result.get("Alice"));
        assertEquals(35, result.get("Bob"));
    }

    @Test
    void testJoindreNoms() {
        String result = exercises.joindreNoms(personnes);
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains(", "));
    }

    @Test
    void testCalculerSalaireTotalParVille() {
        Map<String, Double> result = exercises.calculerSalaireTotalParVille(personnes);
        assertEquals(113000, result.get("Paris"), 0.01);
        assertEquals(45000, result.get("Lyon"), 0.01);
    }

    @Test
    void testCalculerAgeTotal() {
        int result = exercises.calculerAgeTotal(personnes);
        assertEquals(161, result);
    }

    @Test
    void testTrouverPersonneSalaireMaxParVille() {
        Map<String, Optional<Person>> result = exercises.trouverPersonneSalaireMaxParVille(personnes);
        assertEquals(3, result.size());
        assertTrue(result.get("Paris").isPresent());
        assertEquals("Charlie", result.get("Paris").get().getNom());
    }
}
