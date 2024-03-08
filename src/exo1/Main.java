package exo1;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
	}
	public static void ecrireDansFichier(String nomFichier, String contenu) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
            writer.write(contenu);
            writer.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
	public static int compterligne(String nomFichier) {
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
