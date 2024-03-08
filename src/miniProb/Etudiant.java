package miniProb;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Etudiant implements Serializable {
    private static final long serialVersionUID = 1654;

    private String nom;
    private int age;
    private String numeroEtudiant;

    public Etudiant(String nom, int age, String numeroEtudiant) {
        this.nom = nom;
        this.age = age;
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Âge: " + age + ", Numéro étudiant: " + numeroEtudiant;
    }
}