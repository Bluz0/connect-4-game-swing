package puissance4;

import java.awt.*;
import javax.swing.*;

import puisQuatre.Puis4;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Plateau extends JPanel implements PropertyChangeListener{

	private Puis4 modele;
	private SourisClick souris;
	private int hauteur = 500;
	private int largeur = 600;
	
	/** 
	 * Constructeur permettant de creer le plateau (JPanel se trouvant entre les boutons et le JPanel resultat)
	 * @param m est le modele Puis4 
	 * @param p le plateauCanvas incluant les boutons et resultats
	 */
	public Plateau(Puis4 m, PlateauCanvas p) {
		
		this.modele = m;
		this.setPreferredSize(new Dimension(largeur,hauteur));
		m.addPropertyChangeListener(this);
		int col = modele.getNbColonnes();

	}
	
	/** 
	 * Rafrechit a chaque action
	 * @param evt l'evenement de la classe PropertyChangeEvent
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.repaint();
	}
	
	/** 
	 * Dessin du plateau et du placement des pions
	 * @param g le parametre permettant de dessiner
	 */
	@Override
	protected void paintComponent(Graphics g) {

		int lignes = modele.getNbLignes();
		int colonnes = modele.getNbColonnes();

		Color nouveau_bleu = new Color(217,243,255);
		for(int i = 0; i < lignes; i++ ) {
			for (int j = 0; j < colonnes; j++) {

				int largeur_rond = (largeur/colonnes)-4;
				int hauteur_rond = (hauteur/lignes+1)-4;
				int pos_x_rond = (largeur/colonnes)*j + 2;
				int pos_y_rond = (hauteur - (hauteur/lignes)) - ((hauteur/lignes)*i );
				if (modele.getPion(j, i) == modele.VIDE) {
					g.setColor(nouveau_bleu);
					g.fillOval(pos_x_rond, pos_y_rond,largeur_rond, hauteur_rond);
				}
				else if (modele.getPion(j,i) == modele.JOUEUR) {
					g.setColor(Color.yellow);
					g.fillOval(pos_x_rond, pos_y_rond,largeur_rond, hauteur_rond);
				}
				else if (modele.getPion(j,i) == modele.PROG) {
					g.setColor(Color.red);
					g.fillOval(pos_x_rond, pos_y_rond,largeur_rond, hauteur_rond);
				}



			}
		}

	
	
	}

	
	
	
}
