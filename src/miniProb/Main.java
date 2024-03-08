package miniProb;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        ArrayList<Etudiant> listeEtudiants = new ArrayList<>();
        System.out.print("Combien d'étudiants souhaitez-vous enregistrer ? ");
        int nombreEtudiants = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < nombreEtudiants; i++) {
            System.out.println("Étudiant " + (i + 1) + " :");
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            System.out.print("Âge : ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Numéro étudiant : ");
            String numeroEtudiant = scanner.nextLine();
            listeEtudiants.add(new Etudiant(nom, age, numeroEtudiant));
        }

        String nomFichier = "etudiants.ser";
        serialiserEtudiants(listeEtudiants, nomFichier);
        System.out.println("Les étudiants ont été sérialisés dans le fichier " + nomFichier);

        System.out.print("Entrez le nom de l'étudiant que vous souhaitez rechercher : ");
        String nomRecherche = scanner.nextLine();
        Etudiant etudiantTrouve = rechercherEtudiant(nomRecherche, nomFichier);
        if (etudiantTrouve != null) {
            System.out.println("Détails de l'étudiant trouvé :");
            System.out.println(etudiantTrouve);
        } else {
            System.out.println("Aucun étudiant trouvé avec le nom '" + nomRecherche + "'.");
        }
    }

    private static void serialiserEtudiants(ArrayList<Etudiant> listeEtudiants, String nomFichier) {
        try {
            FileOutputStream fichierOut = new FileOutputStream(nomFichier);
            ObjectOutputStream objOut = new ObjectOutputStream(fichierOut);
            objOut.writeObject(listeEtudiants);
            objOut.close();
            fichierOut.close();
        } catch (IOException e) {
            System.err.println("Erreur lors de la sérialisation des étudiants : " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static Etudiant rechercherEtudiant(String nom, String nomFichier) {
        Etudiant etudiantTrouve = null;
        try {
            FileInputStream fichierIn = new FileInputStream(nomFichier);
            ObjectInputStream objIn = new ObjectInputStream(fichierIn);
            ArrayList<Etudiant> listeEtudiants = (ArrayList<Etudiant>) objIn.readObject();
            for (Etudiant etudiant : listeEtudiants) {
                if (etudiant.getNom().equalsIgnoreCase(nom)) {
                    etudiantTrouve = etudiant;
                    break;
                }
            }
            objIn.close();
            fichierIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la recherche de l'étudiant : " + e.getMessage());
        }
        return etudiantTrouve;
    }
	
}
