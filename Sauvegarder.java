package puissance4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.sound.midi.SysexMessage;
import javax.swing.*;

import puisQuatre.Puis4;

public class Sauvegarder implements Serializable , ActionListener {

	private Puis4 modele; 
	private String nomFichier;
	private Logger flux;
	
	
	public Sauvegarder(Puis4 m, String nomFichier,Logger f) {
		this.modele = m;
		this.nomFichier = nomFichier;
		this.flux = f;
	}

	@Override
	/** 
	 * Permet de sauvegarder une partie dans un fichier
	 * @param a de type ActionEvent
	 */
	public void actionPerformed(ActionEvent a) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))){
			oos.writeObject(this.modele.getPlateau());
			ObjectOutputStream oos_2 = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir")+"\\save_level.obj"));
			oos_2.writeObject(this.modele.getNiveauJeu());	
			flux.Log(flux.INFO, "Sauvegarde du jeu");
			oos_2.close();
		}
		catch (IOException e) {
			flux.Log(100, "Erreur sur le flux");
		}/*
		finally {
			oos.close();
		}*/
	}
		
}
