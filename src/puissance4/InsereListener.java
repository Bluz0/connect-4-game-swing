package puissance4;

import java.awt.*;
import javax.swing.*;

import puisQuatre.Puis4;
import java.awt.event.*;

public class InsereListener implements ActionListener {

	private PlateauCanvas plateau;
	private Puis4 jeu;
	private int col;
	/** 
	 * Methode permettant d'inserer un pion lorsque le constructeur est appelé (utilisé sur les boutons)
	 * @param p l'affichage du plateau et options
	 * @param j le modele
	 * @param col le nombre de colonnes dans le plateau
	 */
	public InsereListener(PlateauCanvas p , Puis4 j, int col) {
		this.plateau = p;
		this.jeu = j;
		this.col = col;
		
	}

	/** 
	 * Gere les possibilité lorsque le joueur clique sur un bouton
	 * Permet de jouer ou non
	 * @param e l'evenement
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (jeu.estPossibleJouer(col) && !jeu.estTermine()) {
			jeu.joueurJoue(col);
			jeu.progJoue();
			plateau.repaint();
		}
		
	}
	
	
	
	
}
