package exo1;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Etudiant etudiant = new Etudiant("Michouuii", 20, "123456");

	        
	        String nomFichier = "etudiant.ser";
	        serialiserEtudiant(etudiant, nomFichier);

	        
	        Etudiant etudiantDeserialise = deserialiserEtudiant(nomFichier);

	        
	        if (etudiantDeserialise != null) {
	            System.out.println("Détails de l'étudiant désérialisé :");
	            System.out.println("Nom: " + etudiantDeserialise.getNom());
	            System.out.println("Âge: " + etudiantDeserialise.getAge());
	            System.out.println("Numéro étudiant: " + etudiantDeserialise.getNumeroEtudiant());
	        }
	    }

	    
	    private static void serialiserEtudiant(Etudiant etudiant, String nomFichier) {
	        try {
	            FileOutputStream fichierOut = new FileOutputStream(nomFichier);
	            ObjectOutputStream objOut = new ObjectOutputStream(fichierOut);
	            objOut.writeObject(etudiant);
	            objOut.close();
	            fichierOut.close();
	            System.out.println("L'étudiant a été sérialisé avec succès.");
	        } catch (IOException e) {
	            System.err.println("Erreur lors de la sérialisation de l'étudiant : " + e.getMessage());
	        }
	    }


	    private static Etudiant deserialiserEtudiant(String nomFichier) {
	        Etudiant etudiant = null;
	        try {
	            FileInputStream fichierIn = new FileInputStream(nomFichier);
	            ObjectInputStream objIn = new ObjectInputStream(fichierIn);
	            etudiant = (Etudiant) objIn.readObject();
	            objIn.close();
	            fichierIn.close();
	        } catch (IOException | ClassNotFoundException e) {
	            System.err.println("Erreur lors de la désérialisation de l'étudiant : " + e.getMessage());
	        }
	        return etudiant;
	    
	}
	public static void ecrireFichier(String nomFichier) {
        try {
        	Scanner scan=new Scanner(System.in);
        	String contenu=scan.nextLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
            writer.write(contenu);
            writer.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
	public static int compterLigne(String nomFichier) {
        try {
            BufferedReader lecteur = new BufferedReader(new FileReader(nomFichier));
            int nombreLignes = 0;

            while (lecteur.readLine() != null) {
                nombreLignes++;
            }

            lecteur.close();
            System.out.println("Le fichier " + nomFichier + " contient " + nombreLignes + " lignes.");
            return nombreLignes;
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
            return 0;
        }
	}

}
