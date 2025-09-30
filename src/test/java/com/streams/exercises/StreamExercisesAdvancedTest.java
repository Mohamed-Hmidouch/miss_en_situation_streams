package com.streams.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StreamExercisesAdvancedTest {

    private StreamExercisesAdvanced exercises;
    private List<Person> personnes;

    @BeforeEach
    void setUp() {
        exercises = new StreamExercisesAdvanced();
        personnes = Arrays.asList(
                new Person("Alice", 25, "Paris", 35000),
                new Person("Bob", 35, "Lyon", 45000),
                new Person("Charlie", 28, "Paris", 40000),
                new Person("David", 42, "Marseille", 55000),
                new Person("Eve", 31, "Paris", 38000)
        );
    }

    @Test
    void testExtraireCaracteres() {
        List<Character> result = exercises.extraireCaracteres(personnes);
        assertTrue(result.size() > 0);
        assertTrue(result.contains('A'));
        assertTrue(result.contains('B'));
    }

    @Test
    void testCreerPairesNomVille() {
        List<String[]> result = exercises.creerPairesNomVille(personnes);
        assertEquals(5, result.size());
        assertEquals("Alice", result.get(0)[0]);
        assertEquals("Paris", result.get(0)[1]);
    }

    @Test
    void testCalculerSommeSalairesParallele() {
        double result = exercises.calculerSommeSalairesParallele(personnes);
        assertEquals(213000, result, 0.01);
    }

    @Test
    void testGenererNombresPairs() {
        List<Integer> result = exercises.genererNombresPairs(5);
        assertEquals(5, result.size());
        assertEquals(Arrays.asList(0, 2, 4, 6, 8), result);
    }

    @Test
    void testObtenirStatistiquesAge() {
        IntSummaryStatistics result = exercises.obtenirStatistiquesAge(personnes);
        assertEquals(25, result.getMin());
        assertEquals(42, result.getMax());
        assertEquals(5, result.getCount());
    }

    @Test
    void testAplatirGroupes() {
        List<List<Person>> groupes = Arrays.asList(
                Arrays.asList(personnes.get(0), personnes.get(1)),
                Arrays.asList(personnes.get(2), personnes.get(3)),
                Arrays.asList(personnes.get(4))
        );
        List<Person> result = exercises.aplatirGroupes(groupes);
        assertEquals(5, result.size());
    }

    @Test
    void testFormaterNoms() {
        String result = exercises.formaterNoms(personnes);
        assertTrue(result.startsWith("Noms: ["));
        assertTrue(result.endsWith("]"));
        assertTrue(result.contains("Alice"));
    }

    @Test
    void testGrouperParVilleEtTrancheAge() {
        Map<String, Map<String, List<Person>>> result = exercises.grouperParVilleEtTrancheAge(personnes);
        assertNotNull(result.get("Paris"));
        assertTrue(result.get("Paris").containsKey("Moins de 30") || 
                   result.get("Paris").containsKey("30-50"));
    }

    @Test
    void testTrouverNomLePlusLong() {
        Optional<String> result = exercises.trouverNomLePlusLong(personnes);
        assertTrue(result.isPresent());
        assertEquals("Charlie", result.get());
    }

    @Test
    void testCombinerEtTrier() {
        List<Person> personnes2 = Arrays.asList(
                new Person("Zara", 30, "Nice", 40000),
                new Person("Anna", 27, "Nantes", 35000)
        );
        List<Person> result = exercises.combinerEtTrier(personnes, personnes2);
        assertEquals(7, result.size());
        assertEquals("Alice", result.get(0).getNom());
        assertEquals("Zara", result.get(result.size() - 1).getNom());
    }

    @Test
    void testCalculerMoyenneSalaireParVille() {
        Map<String, Double> result = exercises.calculerMoyenneSalaireParVille(personnes);
        assertEquals(3, result.size());
        assertEquals(37666.67, result.get("Paris"), 1.0);
    }

    @Test
    void testPrendreJusquaPlusDe50Ans() {
        List<Person> personnesTriees = Arrays.asList(
                new Person("Alice", 25, "Paris", 35000),
                new Person("Charlie", 28, "Paris", 40000),
                new Person("Eve", 31, "Paris", 38000),
                new Person("Bob", 35, "Lyon", 45000),
                new Person("David", 55, "Marseille", 55000)
        );
        List<Person> result = exercises.prendreJusquaPlusDe50Ans(personnesTriees);
        assertEquals(4, result.size());
        assertTrue(result.stream().allMatch(p -> p.getAge() <= 50));
    }

    @Test
    void testIgnorerJusquaPlusDe30Ans() {
        List<Person> personnesTriees = Arrays.asList(
                new Person("Alice", 25, "Paris", 35000),
                new Person("Charlie", 28, "Paris", 40000),
                new Person("Eve", 31, "Paris", 38000),
                new Person("Bob", 35, "Lyon", 45000),
                new Person("David", 42, "Marseille", 55000)
        );
        List<Person> result = exercises.ignorerJusquaPlusDe30Ans(personnesTriees);
        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(p -> p.getAge() > 30));
    }
}
