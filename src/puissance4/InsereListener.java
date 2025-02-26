package puissance4;

import java.awt.*;
import javax.swing.*;

import puisQuatre.Puis4;
import java.awt.event.*;

public class InsereListener implements ActionListener {

	private PlateauCanvas plateau;
	private Puis4 jeu;
	private int col;
	
	private Logger flux;
	/** 
	 * Methode permettant d'inserer un pion lorsque le constructeur est appelé (utilisé sur les boutons)
	 * @param p l'affichage du plateau et options
	 * @param j le modele
	 * @param col le nombre de colonnes dans le plateau
	 */
	public InsereListener(PlateauCanvas p , Puis4 j, int col, Logger f) {
		this.plateau = p;
		this.jeu = j;
		this.col = col;
		this.flux = f;
	}

	/** 
	 * Gere les possibilité lorsque le joueur clique sur un bouton
	 * Permet de jouer ou non
	 * @param e l'evenement
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		flux.Log(flux.DEBUG, "Click sur " + col);
		if (jeu.estPossibleJouer(col) && !jeu.estTermine()) {
			flux.Log(flux.INFO, "Joueur place un pion dans "+ col);
			jeu.joueurJoue(col);
			jeu.progJoue();
			flux.Log(flux.INFO, "Prog place un pion dans "+ jeu.getMeilleurChoix());
			plateau.repaint();
		}
		
		else {
			flux.Log(flux.IMPORTANT, "Coup interdit !");
		}
		
	}
	
	
	
	
}
