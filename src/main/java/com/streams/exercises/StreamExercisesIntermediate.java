package com.streams.exercises;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Exercices intermédiaires sur les Streams Java
 */
public class StreamExercisesIntermediate {

    /**
     * Exercice 1: Calculer la somme des salaires de toutes les personnes
     * @param personnes liste des personnes
     * @return somme des salaires
     */
    public double calculerSommeSalaires(List<Person> personnes) {
        return personnes.stream()
                .mapToDouble(Person::getSalaire)
                .sum();
    }

    /**
     * Exercice 2: Calculer la moyenne d'âge
     * @param personnes liste des personnes
     * @return moyenne d'âge
     */
    public double calculerMoyenneAge(List<Person> personnes) {
        return personnes.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }

    /**
     * Exercice 3: Trouver le salaire maximum
     * @param personnes liste des personnes
     * @return salaire maximum
     */
    public Optional<Double> trouverSalaireMax(List<Person> personnes) {
        return personnes.stream()
                .map(Person::getSalaire)
                .max(Double::compare);
    }

    /**
     * Exercice 4: Trouver la personne la plus âgée
     * @param personnes liste des personnes
     * @return personne la plus âgée
     */
    public Optional<Person> trouverPersonnePlusAgee(List<Person> personnes) {
        return personnes.stream()
                .max(Comparator.comparingInt(Person::getAge));
    }

    /**
     * Exercice 5: Grouper les personnes par ville
     * @param personnes liste des personnes
     * @return map des personnes groupées par ville
     */
    public Map<String, List<Person>> grouperParVille(List<Person> personnes) {
        return personnes.stream()
                .collect(Collectors.groupingBy(Person::getVille));
    }

    /**
     * Exercice 6: Compter les personnes par ville
     * @param personnes liste des personnes
     * @return map du nombre de personnes par ville
     */
    public Map<String, Long> compterParVille(List<Person> personnes) {
        return personnes.stream()
                .collect(Collectors.groupingBy(Person::getVille, Collectors.counting()));
    }

    /**
     * Exercice 7: Partitionner les personnes selon si elles gagnent plus de 40000
     * @param personnes liste des personnes
     * @return map partitionnée (true: salaire > 40000, false: salaire <= 40000)
     */
    public Map<Boolean, List<Person>> partitionnerParSalaire(List<Person> personnes) {
        return personnes.stream()
                .collect(Collectors.partitioningBy(p -> p.getSalaire() > 40000));
    }

    /**
     * Exercice 8: Créer une map avec nom comme clé et âge comme valeur
     * @param personnes liste des personnes
     * @return map nom -> âge
     */
    public Map<String, Integer> creerMapNomAge(List<Person> personnes) {
        return personnes.stream()
                .collect(Collectors.toMap(Person::getNom, Person::getAge, (age1, age2) -> age1));
    }

    /**
     * Exercice 9: Joindre tous les noms avec une virgule
     * @param personnes liste des personnes
     * @return chaîne avec tous les noms séparés par des virgules
     */
    public String joindreNoms(List<Person> personnes) {
        return personnes.stream()
                .map(Person::getNom)
                .collect(Collectors.joining(", "));
    }

    /**
     * Exercice 10: Calculer le salaire total par ville
     * @param personnes liste des personnes
     * @return map du salaire total par ville
     */
    public Map<String, Double> calculerSalaireTotalParVille(List<Person> personnes) {
        return personnes.stream()
                .collect(Collectors.groupingBy(
                        Person::getVille,
                        Collectors.summingDouble(Person::getSalaire)
                ));
    }

    /**
     * Exercice 11: Réduire pour calculer l'âge total
     * @param personnes liste des personnes
     * @return âge total de toutes les personnes
     */
    public int calculerAgeTotal(List<Person> personnes) {
        return personnes.stream()
                .map(Person::getAge)
                .reduce(0, Integer::sum);
    }

    /**
     * Exercice 12: Trouver les noms des personnes ayant le salaire le plus élevé par ville
     * @param personnes liste des personnes
     * @return map ville -> nom de la personne avec le plus haut salaire
     */
    public Map<String, Optional<Person>> trouverPersonneSalaireMaxParVille(List<Person> personnes) {
        return personnes.stream()
                .collect(Collectors.groupingBy(
                        Person::getVille,
                        Collectors.maxBy(Comparator.comparingDouble(Person::getSalaire))
                ));
    }
}
