package puissance4;

import java.awt.*;
import javax.swing.*;

import puisQuatre.Puis4;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GridBouton extends JPanel implements PropertyChangeListener{

	private Puis4 modele;
	private PlateauCanvas plateau;

	private int hauteur = 50;
	private int largeur = 600;
	
	private Logger flux;
	
	/** 
	 * Creation de la lignée de boutons selon un nombre de colonnes
	 * @param m est le modele 
	 * @param p afin d'inserer dans la classe PlateauCanvas
	 */
	public GridBouton(Puis4 m, PlateauCanvas p,Logger f) {
		
		this.modele = m;
		this.flux = f;
		this.plateau = p;
		int colonnes = modele.getNbColonnes();
		this.setLayout(new GridLayout(1,colonnes));
		this.setPreferredSize(new Dimension(largeur,hauteur));
		for(int i = 0; i < colonnes; i++ ) { // Premiere ligne de boutons
			JButton btn = new JButton("V");
			btn.addActionListener(new InsereListener(plateau,modele,i,flux));
			this.add(btn);
			
		}
		m.addPropertyChangeListener(this);
	}
	
	/** 
	 * Lorsque le joueur decide de changer le nombre de colonnes, le nombre de boutons s'actualise
	 * @param evt l'evenement
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
		this.removeAll();
        int colonnes = modele.getNbColonnes(); // Récupère le nouveau nombre de colonnes
        this.setLayout(new GridLayout(1, colonnes)); // Applique la nouvelle disposition

        // Recrée les boutons
        for (int i = 0; i < colonnes; i++) {
            JButton btn = new JButton("V");
            btn.addActionListener(new InsereListener(plateau, modele, i,flux));
            this.add(btn);
        }

        this.revalidate(); // Force la mise à jour du layout
        this.repaint(); // Redessine l'interface
	}
	
	/** 
	 * Fond du Jpanel boutons
	 * @param g permet de dessiner
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color nouveau_bleu = new Color(217,243,255);
		this.setBackground(nouveau_bleu);

	}

		
}
