package puissance4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JTextField;

import puisQuatre.Puis4;

public class Charger implements Serializable, ActionListener {

	private Puis4 modele;
	private String nomFichier;
	private JTextField niveau;
	private JTextField ligne;
	private JTextField colonne;
	private Logger flux;
	
	public Charger(Puis4 m, String nomFichier,JTextField ligne, JTextField col, JTextField niveau, Logger f) {
		this.modele = m;
		this.nomFichier = nomFichier;
		this.ligne = ligne;
		this.colonne = col;
		this.niveau = niveau;
		this.flux = f;
	}
	
	@Override
	/** 
	 * Permet de charger une partie precedemment sauvegarder
	 * @param a de type ActionEvent
	 */
	public void actionPerformed(ActionEvent a) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))){
			modele.setPlateau((int[][]) ois.readObject());
			
			ObjectInputStream ois_2 = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"\\save_level.obj"));
			modele.setNiveauJeu((int)ois_2.readObject());
			ligne.setText(String.valueOf(modele.getNbLignes()));
			colonne.setText(String.valueOf(modele.getNbColonnes()));
			niveau.setText(String.valueOf(modele.getNiveauJeu()));
			flux.Log(flux.INFO, "Chargement du jeu");
			ois_2.close();
			
		}
		catch(IOException e) {
			flux.Log(100, "Erreur sur le flux");
		}
		catch(ClassNotFoundException e) {
			flux.Log(100, "Type d'objet inconnu");
		}

		
	}

}
