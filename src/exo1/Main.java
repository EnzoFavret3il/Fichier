package exo1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String nomFichier = "monFichier.txt"; 

	        try {
	            BufferedReader lecteur = new BufferedReader(new FileReader(nomFichier));
	            int nombreLignes = 0;

	            while (lecteur.readLine() != null) {
	                nombreLignes++;
	            }

	            lecteur.close();
	            System.out.println("Le fichier " + nomFichier + " contient " + nombreLignes + " lignes.");
	        } catch (IOException e) {
	            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
	        }
	}

}
