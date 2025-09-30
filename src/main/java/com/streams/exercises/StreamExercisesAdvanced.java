package com.streams.exercises;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Exercices avancés sur les Streams Java
 */
public class StreamExercisesAdvanced {

    /**
     * Exercice 1: FlatMap - Créer une liste de tous les caractères des noms
     * @param personnes liste des personnes
     * @return liste de tous les caractères
     */
    public List<Character> extraireCaracteres(List<Person> personnes) {
        return personnes.stream()
                .map(Person::getNom)
                .flatMap(nom -> nom.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
    }

    /**
     * Exercice 2: Créer une liste de paires [nom, ville]
     * @param personnes liste des personnes
     * @return liste de tableaux [nom, ville]
     */
    public List<String[]> creerPairesNomVille(List<Person> personnes) {
        return personnes.stream()
                .map(p -> new String[]{p.getNom(), p.getVille()})
                .collect(Collectors.toList());
    }

    /**
     * Exercice 3: Parallel Stream - Calculer la somme des salaires en parallèle
     * @param personnes liste des personnes
     * @return somme des salaires
     */
    public double calculerSommeSalairesParallele(List<Person> personnes) {
        return personnes.parallelStream()
                .mapToDouble(Person::getSalaire)
                .sum();
    }

    /**
     * Exercice 4: Stream infini - Générer une séquence de nombres pairs
     * @param limite nombre d'éléments à générer
     * @return liste de nombres pairs
     */
    public List<Integer> genererNombresPairs(int limite) {
        return IntStream.iterate(0, n -> n + 2)
                .limit(limite)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * Exercice 5: Statistiques - Obtenir les statistiques sur les âges
     * @param personnes liste des personnes
     * @return statistiques (min, max, moyenne, somme, count)
     */
    public IntSummaryStatistics obtenirStatistiquesAge(List<Person> personnes) {
        return personnes.stream()
                .mapToInt(Person::getAge)
                .summaryStatistics();
    }

    /**
     * Exercice 6: FlatMap avec listes imbriquées
     * @param groupes liste de listes de personnes
     * @return liste plate de toutes les personnes
     */
    public List<Person> aplatirGroupes(List<List<Person>> groupes) {
        return groupes.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * Exercice 7: Collect avec Collector personnalisé - Concaténer les noms avec préfixe et suffixe
     * @param personnes liste des personnes
     * @return chaîne formatée
     */
    public String formaterNoms(List<Person> personnes) {
        return personnes.stream()
                .map(Person::getNom)
                .collect(Collectors.joining(", ", "Noms: [", "]"));
    }

    /**
     * Exercice 8: Peek pour déboguer - Filtrer et afficher les étapes (pour débogage)
     * @param personnes liste des personnes
     * @return liste des personnes de plus de 30 ans
     */
    public List<Person> filtrerAvecPeek(List<Person> personnes) {
        return personnes.stream()
                .peek(p -> System.out.println("Traitement de: " + p.getNom()))
                .filter(p -> p.getAge() > 30)
                .peek(p -> System.out.println("Filtré: " + p.getNom()))
                .collect(Collectors.toList());
    }

    /**
     * Exercice 9: Groupement multiniveau - Grouper par ville puis par tranche d'âge
     * @param personnes liste des personnes
     * @return map ville -> tranche d'âge -> liste de personnes
     */
    public Map<String, Map<String, List<Person>>> grouperParVilleEtTrancheAge(List<Person> personnes) {
        return personnes.stream()
                .collect(Collectors.groupingBy(
                        Person::getVille,
                        Collectors.groupingBy(p -> {
                            if (p.getAge() < 30) return "Moins de 30";
                            else if (p.getAge() < 50) return "30-50";
                            else return "Plus de 50";
                        })
                ));
    }

    /**
     * Exercice 10: Optional avec reduce - Trouver le nom le plus long
     * @param personnes liste des personnes
     * @return nom le plus long
     */
    public Optional<String> trouverNomLePlusLong(List<Person> personnes) {
        return personnes.stream()
                .map(Person::getNom)
                .reduce((nom1, nom2) -> nom1.length() >= nom2.length() ? nom1 : nom2);
    }

    /**
     * Exercice 11: Combiner plusieurs streams
     * @param personnes1 première liste de personnes
     * @param personnes2 deuxième liste de personnes
     * @return liste combinée et triée par nom
     */
    public List<Person> combinerEtTrier(List<Person> personnes1, List<Person> personnes2) {
        return Stream.concat(personnes1.stream(), personnes2.stream())
                .sorted(Comparator.comparing(Person::getNom))
                .collect(Collectors.toList());
    }

    /**
     * Exercice 12: Collector avec downstreaming - Moyenne des salaires par ville
     * @param personnes liste des personnes
     * @return map ville -> moyenne des salaires
     */
    public Map<String, Double> calculerMoyenneSalaireParVille(List<Person> personnes) {
        return personnes.stream()
                .collect(Collectors.groupingBy(
                        Person::getVille,
                        Collectors.averagingDouble(Person::getSalaire)
                ));
    }

    /**
     * Exercice 13: takeWhile - Prendre les personnes jusqu'à ce qu'on trouve quelqu'un de plus de 50 ans
     * Note: disponible à partir de Java 9
     * @param personnes liste des personnes triées par âge
     * @return liste des personnes jusqu'au premier de plus de 50 ans
     */
    public List<Person> prendreJusquaPlusDe50Ans(List<Person> personnes) {
        return personnes.stream()
                .takeWhile(p -> p.getAge() <= 50)
                .collect(Collectors.toList());
    }

    /**
     * Exercice 14: dropWhile - Ignorer les personnes jusqu'à trouver quelqu'un de plus de 30 ans
     * Note: disponible à partir de Java 9
     * @param personnes liste des personnes triées par âge
     * @return liste des personnes après le premier de plus de 30 ans
     */
    public List<Person> ignorerJusquaPlusDe30Ans(List<Person> personnes) {
        return personnes.stream()
                .dropWhile(p -> p.getAge() <= 30)
                .collect(Collectors.toList());
    }
}
