package puissance4;

import java.awt.*;
import javax.swing.*;

import puisQuatre.Puis4;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AfficheResultat extends JPanel implements PropertyChangeListener{

	
	private Puis4 modele;
	private PlateauCanvas plateau;
	private int hauteur = 50;
	private int largeur = 600;
	
	private JLabel resultat;
	/** 
	 * JPanel affichant le resultat du gagnant
	 * @param modele le modele du jeu
	 * @param p le PlateauCanvas permettant d'inclure les options
	 */
	public AfficheResultat(Puis4 modele,PlateauCanvas p) {
		
		this.modele = modele;
		this.plateau = p;
		this.setLayout(new BorderLayout());
		
		this.resultat = new JLabel("");
		this.add(resultat);

		Color nouveau_bleu = new Color(217,243,255);
		this.setBackground(nouveau_bleu);

		
	}
	
	/** 
	 * Tant que la partie n'est pas fini on rafrechit , si la partie est fini et que le joueur continue de cliquer
	 * alors on arrete de rafraichir l'affichage
	 * @param g permettant de dessiner
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (!modele.estTermine()) {
			plateau.repaint();
		}
	}
	
	/** 
	 * En fonction du resultat un message adaptée et le fond s'adapte
	 * @param evt l'evenement
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (modele.estProgGagne()) {
			resultat.setText("Le Programme a gagné.");
            this.setBackground(Color.red);
        } 
		else if (modele.estJoueurGagne()) {
            resultat.setText("Vous avez gagné.");
            this.setBackground(Color.green);
        } else {
            resultat.setText("");

    		Color nouveau_bleu = new Color(217,243,255);
    		this.setBackground(nouveau_bleu);
        }
        repaint();
		
	}	
	
	

	
	
	
}
