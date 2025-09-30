package com.streams.exercises;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercices de base sur les Streams Java
 */
public class StreamExercisesBasic {

    /**
     * Exercice 1: Filtrer les personnes de plus de 30 ans
     * @param personnes liste des personnes
     * @return liste des personnes de plus de 30 ans
     */
    public List<Person> filterPersonnesPlus30Ans(List<Person> personnes) {
        return personnes.stream()
                .filter(p -> p.getAge() > 30)
                .collect(Collectors.toList());
    }

    /**
     * Exercice 2: Récupérer les noms de toutes les personnes
     * @param personnes liste des personnes
     * @return liste des noms
     */
    public List<String> getNoms(List<Person> personnes) {
        return personnes.stream()
                .map(Person::getNom)
                .collect(Collectors.toList());
    }

    /**
     * Exercice 3: Filtrer et transformer - Récupérer les noms des personnes de plus de 25 ans
     * @param personnes liste des personnes
     * @return liste des noms des personnes de plus de 25 ans
     */
    public List<String> getNomsPersonnesPlus25Ans(List<Person> personnes) {
        return personnes.stream()
                .filter(p -> p.getAge() > 25)
                .map(Person::getNom)
                .collect(Collectors.toList());
    }

    /**
     * Exercice 4: Compter le nombre de personnes habitant à Paris
     * @param personnes liste des personnes
     * @return nombre de personnes à Paris
     */
    public long compterPersonnesAParis(List<Person> personnes) {
        return personnes.stream()
                .filter(p -> "Paris".equals(p.getVille()))
                .count();
    }

    /**
     * Exercice 5: Vérifier si toutes les personnes ont plus de 18 ans
     * @param personnes liste des personnes
     * @return true si toutes les personnes ont plus de 18 ans
     */
    public boolean toutesPersonnesMajeures(List<Person> personnes) {
        return personnes.stream()
                .allMatch(p -> p.getAge() > 18);
    }

    /**
     * Exercice 6: Vérifier s'il existe une personne avec un salaire supérieur à 50000
     * @param personnes liste des personnes
     * @return true s'il existe au moins une personne avec salaire > 50000
     */
    public boolean existePersonneAvecSalaireEleve(List<Person> personnes) {
        return personnes.stream()
                .anyMatch(p -> p.getSalaire() > 50000);
    }

    /**
     * Exercice 7: Trier les personnes par âge croissant
     * @param personnes liste des personnes
     * @return liste des personnes triées par âge
     */
    public List<Person> trierParAge(List<Person> personnes) {
        return personnes.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());
    }

    /**
     * Exercice 8: Récupérer les 3 premières personnes
     * @param personnes liste des personnes
     * @return liste des 3 premières personnes
     */
    public List<Person> getTroisPremieres(List<Person> personnes) {
        return personnes.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Exercice 9: Ignorer les 2 premières personnes et récupérer les autres
     * @param personnes liste des personnes
     * @return liste des personnes sauf les 2 premières
     */
    public List<Person> ignorerDeuxPremieres(List<Person> personnes) {
        return personnes.stream()
                .skip(2)
                .collect(Collectors.toList());
    }

    /**
     * Exercice 10: Obtenir les villes distinctes
     * @param personnes liste des personnes
     * @return liste des villes uniques
     */
    public List<String> getVillesDistinctes(List<Person> personnes) {
        return personnes.stream()
                .map(Person::getVille)
                .distinct()
                .collect(Collectors.toList());
    }
}
