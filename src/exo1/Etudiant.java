package exo1;

import java.io.*;

class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L; 

    private String nom;
    private int age;
    private String numeroEtudiant;

    
    public Etudiant(String nom, int age, String numeroEtudiant) {
        this.nom = nom;
        this.age = age;
        this.numeroEtudiant = numeroEtudiant;
    }

    // Getters
    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }
}