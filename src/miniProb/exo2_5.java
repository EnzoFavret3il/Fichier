package miniProb;

import java.io.*;
import java.util.Scanner;

public class exo2_5 {
	static double count = 0;
    static String filePath = "C:\\Users\\Enzo Favret\\Desktop\\TestText.txt";
    static BufferedReader br;
    static String line = "";

    public static void main(String[] args) {
    	Scanner scan=new Scanner(System.in);

        String inputSearch = scan.nextLine();
    	try {
    	    br = new BufferedReader(new FileReader(filePath));
    	    try {
    	        while((line = br.readLine()) != null)
    	        {
    	            String[] words = line.split(" ");

    	            for (String word : words) {
    	              if (word.equals(inputSearch)) {
    	                count++;
    	              }
    	            }
    	        }
    	        br.close();
    	    } catch (IOException e) {
    	        // TODO Auto-generated catch block
    	        e.printStackTrace();
    	    }
    	} catch (FileNotFoundException e) {
    	    // TODO Auto-generated catch block
    	    e.printStackTrace();
    	}

    	System.out.println("Mot trouvé : "+count+" fois");
    	}
    }

