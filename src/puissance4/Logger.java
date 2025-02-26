package puissance4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

	static final int ALL = 0;
	static final int DEBUG = 100;
	static final int INFO = 500;
	static final int IMPORTANT = 900;
	static final int OFF = Integer.MAX_VALUE;
	
	private int level; // minimum
	private PrintWriter flux_sortie;
	
	private String fichier;
	
	public Logger(int level) {
		this.level = level;
	}
	
	public Logger() {
		this(DEBUG);
		this.flux_sortie = new PrintWriter(System.err, true);
	}
	
	public Logger(int level, PrintWriter f) {
		this.level = level;
		this.flux_sortie = f;
	}
	
	public Logger(String fichierConfig) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichierConfig))) {
            String ligne = br.readLine();
            if (ligne != null) {
            	
                String[] parts = ligne.split("\\s+"); // Sépare niveau et fichier
                if (parts.length >= 2) {
                    this.level = niveauDegreImportance(parts[0]); // Convertit le niveau String en vrai degre d'importance
                    this.flux_sortie = gereFichier(parts[1]); // Initialise la sortie
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier de configuration : " + e.getMessage());
            this.level = DEBUG;
            this.flux_sortie = new PrintWriter(System.err, true);
        }
    }
	/** 
	 * Permet de convertir un niveau qui est de type string en constante
	 * @param levelStr le degre d'importance en string
	 */
    private int niveauDegreImportance(String levelStr) {
        return switch (levelStr.toUpperCase()) { // En majuscule au cas ou
            case "ALL" -> ALL;
            case "DEBUG" -> DEBUG;
            case "INFO" -> INFO;
            case "IMPORTANT" -> IMPORTANT;
            case "OFF" -> OFF;
            default -> DEBUG; // Niveau par défaut si inconnu
        };
    }

    /** 
	 * Permet d'ecrire dans un fichier selon le type de la sortie
	 * @param sortie le fichier de sortie
	 */
    private PrintWriter gereFichier(String sortie) throws IOException {
        if (sortie.equalsIgnoreCase("System.err")) {
            return new PrintWriter(System.err, true); 
        } else if (sortie.equalsIgnoreCase("System.out")) {
            return new PrintWriter(System.out, true);
        } else {
            return new PrintWriter(new FileWriter(sortie, true)); // Écriture dans un fichier
        }
    }
    /** 
	 * Affiche un message selon le niveau donné
	 * @param level le degre d'importance
	 * @param message un message a envoyé
	 */
	public void Log(int level, String message) {
		
		if (level >= this.level) {
			flux_sortie.println(message);
		}
		
	}
	
	
	
	
}
