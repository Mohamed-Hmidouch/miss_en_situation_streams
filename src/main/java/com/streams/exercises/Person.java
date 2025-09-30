package com.streams.exercises;

import java.util.Objects;

/**
 * Classe Person pour les exercices de streams
 */
public class Person {
    private String nom;
    private int age;
    private String ville;
    private double salaire;

    public Person(String nom, int age, String ville, double salaire) {
        this.nom = nom;
        this.age = age;
        this.ville = ville;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Double.compare(person.salaire, salaire) == 0 &&
                Objects.equals(nom, person.nom) &&
                Objects.equals(ville, person.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, age, ville, salaire);
    }

    @Override
    public String toString() {
        return "Person{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", ville='" + ville + '\'' +
                ", salaire=" + salaire +
                '}';
    }
}
