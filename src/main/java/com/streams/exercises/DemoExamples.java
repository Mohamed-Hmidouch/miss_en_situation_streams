package com.streams.exercises;

import java.util.*;

/**
 * Classe de démonstration pour les exercices de Streams Java
 * Exécutez cette classe pour voir des exemples d'utilisation
 */
public class DemoExamples {

    public static void main(String[] args) {
        // Création d'une liste de personnes pour les démonstrations
        List<Person> personnes = Arrays.asList(
                new Person("Alice", 25, "Paris", 35000),
                new Person("Bob", 35, "Lyon", 45000),
                new Person("Charlie", 28, "Paris", 40000),
                new Person("David", 42, "Marseille", 55000),
                new Person("Eve", 31, "Paris", 38000),
                new Person("Frank", 29, "Lyon", 42000),
                new Person("Grace", 22, "Marseille", 32000)
        );

        System.out.println("=== EXEMPLES D'EXERCICES DE BASE ===\n");
        demonstrateBasicExercises(personnes);

        System.out.println("\n=== EXEMPLES D'EXERCICES INTERMÉDIAIRES ===\n");
        demonstrateIntermediateExercises(personnes);

        System.out.println("\n=== EXEMPLES D'EXERCICES AVANCÉS ===\n");
        demonstrateAdvancedExercises(personnes);
    }

    private static void demonstrateBasicExercises(List<Person> personnes) {
        StreamExercisesBasic exercises = new StreamExercisesBasic();

        // Exercice 1: Filtrer les personnes de plus de 30 ans
        System.out.println("1. Personnes de plus de 30 ans:");
        exercises.filterPersonnesPlus30Ans(personnes)
                .forEach(p -> System.out.println("   - " + p.getNom() + " (" + p.getAge() + " ans)"));

        // Exercice 2: Récupérer tous les noms
        System.out.println("\n2. Tous les noms:");
        System.out.println("   " + String.join(", ", exercises.getNoms(personnes)));

        // Exercice 3: Compter les personnes à Paris
        System.out.println("\n3. Nombre de personnes à Paris: " + 
                exercises.compterPersonnesAParis(personnes));

        // Exercice 4: Vérifier si toutes les personnes sont majeures
        System.out.println("\n4. Toutes les personnes sont-elles majeures (>18 ans)? " + 
                exercises.toutesPersonnesMajeures(personnes));

        // Exercice 5: Villes distinctes
        System.out.println("\n5. Villes distinctes: " + 
                String.join(", ", exercises.getVillesDistinctes(personnes)));
    }

    private static void demonstrateIntermediateExercises(List<Person> personnes) {
        StreamExercisesIntermediate exercises = new StreamExercisesIntermediate();

        // Exercice 1: Somme des salaires
        System.out.println("1. Somme totale des salaires: " + 
                String.format("%.2f €", exercises.calculerSommeSalaires(personnes)));

        // Exercice 2: Moyenne d'âge
        System.out.println("\n2. Moyenne d'âge: " + 
                String.format("%.1f ans", exercises.calculerMoyenneAge(personnes)));

        // Exercice 3: Personne la plus âgée
        exercises.trouverPersonnePlusAgee(personnes).ifPresent(p -> 
                System.out.println("\n3. Personne la plus âgée: " + p.getNom() + 
                        " (" + p.getAge() + " ans)"));

        // Exercice 4: Grouper par ville
        System.out.println("\n4. Groupement par ville:");
        exercises.grouperParVille(personnes).forEach((ville, liste) -> 
                System.out.println("   - " + ville + ": " + liste.size() + " personne(s)"));

        // Exercice 5: Salaire total par ville
        System.out.println("\n5. Salaire total par ville:");
        exercises.calculerSalaireTotalParVille(personnes).forEach((ville, salaire) -> 
                System.out.println("   - " + ville + ": " + String.format("%.2f €", salaire)));
    }

    private static void demonstrateAdvancedExercises(List<Person> personnes) {
        StreamExercisesAdvanced exercises = new StreamExercisesAdvanced();

        // Exercice 1: Statistiques sur les âges
        System.out.println("1. Statistiques sur les âges:");
        IntSummaryStatistics stats = exercises.obtenirStatistiquesAge(personnes);
        System.out.println("   - Minimum: " + stats.getMin() + " ans");
        System.out.println("   - Maximum: " + stats.getMax() + " ans");
        System.out.println("   - Moyenne: " + String.format("%.1f ans", stats.getAverage()));
        System.out.println("   - Total: " + stats.getSum() + " ans");

        // Exercice 2: Nom le plus long
        exercises.trouverNomLePlusLong(personnes).ifPresent(nom -> 
                System.out.println("\n2. Nom le plus long: " + nom));

        // Exercice 3: Groupement multiniveau (ville et tranche d'âge)
        System.out.println("\n3. Groupement par ville et tranche d'âge:");
        exercises.grouperParVilleEtTrancheAge(personnes).forEach((ville, tranches) -> {
            System.out.println("   - " + ville + ":");
            tranches.forEach((tranche, liste) -> 
                    System.out.println("      * " + tranche + ": " + liste.size() + " personne(s)"));
        });

        // Exercice 4: Générer des nombres pairs
        System.out.println("\n4. Génération des 10 premiers nombres pairs:");
        System.out.println("   " + exercises.genererNombresPairs(10));

        // Exercice 5: Moyenne des salaires par ville
        System.out.println("\n5. Moyenne des salaires par ville:");
        exercises.calculerMoyenneSalaireParVille(personnes).forEach((ville, moyenne) -> 
                System.out.println("   - " + ville + ": " + String.format("%.2f €", moyenne)));
    }
}
