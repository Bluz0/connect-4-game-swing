package puissance4;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import puisQuatre.Puis4;

public class SourisClick implements MouseListener{
	
	private PlateauCanvas plateau;
	private Puis4 jeu;
	/** 
	 * Permet de cliquer sur le plateau
	 * @param p le plateauCanvas
	 * @param j le modele
	 * @param le nombre de colonnes
	 */
	public SourisClick(PlateauCanvas p , Puis4 j, int col) {
		
		this.plateau = p;
		this.jeu = j;
	}

	/** 
	 * Choisi la colonne a l'aide de la souris
	 * @param e l'evenemnt de la souris
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		
		int col = jeu.getNbColonnes();

		int clickcol = (e.getX()/(plateau.getLargeur()/col));
		
		if (jeu.estPossibleJouer(clickcol) && !jeu.estTermine()) {
			jeu.joueurJoue(clickcol);
			jeu.progJoue();
			plateau.repaint();
		}

		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
