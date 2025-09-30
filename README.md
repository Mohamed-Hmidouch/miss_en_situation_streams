# Exercices Pratiques sur les Streams Java

Ce projet contient une collection complète d'exercices pratiques sur les Streams Java pour apprendre et manipuler facilement l'API Stream.

## 📚 Structure du Projet

Le projet est organisé en trois niveaux de difficulté :

### 1. **Exercices de Base** (`StreamExercisesBasic`)
- Filtrage avec `filter()`
- Transformation avec `map()`
- Comptage avec `count()`
- Vérifications avec `allMatch()`, `anyMatch()`
- Tri avec `sorted()`
- Limitation et saut avec `limit()` et `skip()`
- Élimination des doublons avec `distinct()`

### 2. **Exercices Intermédiaires** (`StreamExercisesIntermediate`)
- Réduction avec `reduce()`
- Agrégations : somme, moyenne, min, max
- Groupement avec `groupingBy()`
- Partitionnement avec `partitioningBy()`
- Conversion en Map avec `toMap()`
- Jointure de chaînes avec `joining()`
- Collectors avancés

### 3. **Exercices Avancés** (`StreamExercisesAdvanced`)
- Aplatissement avec `flatMap()`
- Streams parallèles avec `parallelStream()`
- Streams infinis avec `iterate()` et `generate()`
- Statistiques avec `summaryStatistics()`
- Groupement multiniveau
- `takeWhile()` et `dropWhile()` (Java 9+)
- Combinaison de streams avec `concat()`
- Peek pour le débogage

## 🚀 Installation et Utilisation

### Prérequis
- Java 11 ou supérieur
- Maven 3.6 ou supérieur

### Compilation
```bash
mvn clean compile
```

### Exécution des Tests
```bash
mvn test
```

### Structure des Fichiers
```
src/
├── main/
│   └── java/
│       └── com/
│           └── streams/
│               └── exercises/
│                   ├── Person.java                      # Classe de modèle
│                   ├── StreamExercisesBasic.java        # Exercices de base
│                   ├── StreamExercisesIntermediate.java # Exercices intermédiaires
│                   └── StreamExercisesAdvanced.java     # Exercices avancés
└── test/
    └── java/
        └── com/
            └── streams/
                └── exercises/
                    ├── StreamExercisesBasicTest.java        # Tests de base
                    ├── StreamExercisesIntermediateTest.java # Tests intermédiaires
                    └── StreamExercisesAdvancedTest.java     # Tests avancés
```

## 📖 Exemples d'Utilisation

### Exemple 1 : Filtrer les personnes de plus de 30 ans
```java
StreamExercisesBasic exercises = new StreamExercisesBasic();
List<Person> personnes = Arrays.asList(
    new Person("Alice", 25, "Paris", 35000),
    new Person("Bob", 35, "Lyon", 45000),
    new Person("Charlie", 42, "Marseille", 55000)
);

List<Person> result = exercises.filterPersonnesPlus30Ans(personnes);
// Résultat : Bob et Charlie
```

### Exemple 2 : Grouper les personnes par ville
```java
StreamExercisesIntermediate exercises = new StreamExercisesIntermediate();
Map<String, List<Person>> personnesParVille = exercises.grouperParVille(personnes);
// Résultat : Map avec Paris -> [Alice], Lyon -> [Bob], etc.
```

### Exemple 3 : Calculer les statistiques d'âge
```java
StreamExercisesAdvanced exercises = new StreamExercisesAdvanced();
IntSummaryStatistics stats = exercises.obtenirStatistiquesAge(personnes);
System.out.println("Âge moyen : " + stats.getAverage());
System.out.println("Âge min : " + stats.getMin());
System.out.println("Âge max : " + stats.getMax());
```

## 🎯 Objectifs Pédagogiques

Ce projet vous permet de :
- ✅ Maîtriser les opérations de base des Streams (filter, map, collect)
- ✅ Comprendre les opérations intermédiaires et terminales
- ✅ Apprendre les Collectors complexes (groupingBy, partitioningBy)
- ✅ Manipuler les Optional pour gérer les valeurs nullables
- ✅ Utiliser les streams parallèles pour améliorer les performances
- ✅ Pratiquer avec des cas d'usage réels et concrets

## 🧪 Tests

Tous les exercices sont accompagnés de tests unitaires complets utilisant JUnit 5. Les tests vérifient :
- La correction des résultats
- Les cas limites
- Les comportements attendus

Pour exécuter les tests :
```bash
mvn test
```

Pour exécuter un test spécifique :
```bash
mvn test -Dtest=StreamExercisesBasicTest
```

## 📝 Concepts Clés Couverts

### Opérations Intermédiaires
- `filter()` : Filtrage des éléments
- `map()` : Transformation des éléments
- `flatMap()` : Aplatissement de structures
- `sorted()` : Tri des éléments
- `distinct()` : Élimination des doublons
- `limit()` : Limitation du nombre d'éléments
- `skip()` : Saut d'éléments
- `peek()` : Inspection des éléments (débogage)

### Opérations Terminales
- `collect()` : Collection des résultats
- `forEach()` : Itération sur les éléments
- `reduce()` : Réduction à une seule valeur
- `count()` : Comptage
- `anyMatch()`, `allMatch()`, `noneMatch()` : Vérifications
- `findFirst()`, `findAny()` : Recherche d'éléments
- `min()`, `max()` : Recherche d'extremums

### Collectors
- `toList()`, `toSet()` : Collection en List/Set
- `toMap()` : Conversion en Map
- `joining()` : Jointure de chaînes
- `groupingBy()` : Groupement
- `partitioningBy()` : Partitionnement
- `counting()` : Comptage
- `summingInt()`, `averagingDouble()` : Agrégations numériques

## 🤝 Contribution

Ce projet est à but pédagogique. N'hésitez pas à :
- Ajouter de nouveaux exercices
- Améliorer la documentation
- Signaler des bugs
- Proposer des optimisations

## 📄 Licence

Ce projet est libre d'utilisation à des fins éducatives.

## 👨‍💻 Auteur

Mohamed Hmidouch

---

**Bon apprentissage des Streams Java ! 🚀**