package puissance4;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import puisQuatre.Puis4;

public class PlateauCanvas extends JPanel implements PropertyChangeListener{

	private Puis4 modele;
	private Plateau p;
	private GridBouton boutons;
	private AfficheResultat gagnant;
	private SourisClick souris;
	private int hauteur = 600;
	private int largeur = 600;
	
	private Logger flux;
	
	/** 
	 * Classe comportant un JPanel incluant : 
	 * - Une grille de boutons (GridLayout)
	 * - Le plateau permettant d'ajouter les pions ( Venant de la classe Plateau )
	 * - Le resultat affichant le gagnant ( Venant de la classe AfficheResultat )
	 * @param m le modele
	 */
	public PlateauCanvas (Puis4 m, Logger f) {
		
		
		
		
		// Permet d'afficher la grille de boutons
		this.modele = m;
		this.flux = f;
		this.boutons = new GridBouton(modele,this,flux);
		this.setLayout(new BorderLayout());
		this.add(boutons, BorderLayout.NORTH);
		this.p = new Plateau(m,this);
		this.add(p,BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(largeur,hauteur));
		
		// Affiche le resultat via un JPanel
		this.gagnant = new AfficheResultat(m,this,flux);
		this.add(gagnant,BorderLayout.SOUTH);
		this.gagnant.setPreferredSize(new Dimension(600,50));
		
		// Gere le clic lorsque un joueur souhaite poser un pion avec la souris
		int colo = modele.getNbColonnes();
		this.souris = new SourisClick(this,m,colo,flux);
		this.addMouseListener(souris);
		
		
		// Permet d'actualiser notre JPanel lorsque le joueur ou le programme gagne
		modele.addPropertyChangeListener(gagnant);
		
		// Permet d'actualiser le nombre de boutons lorsqu'une nouvelle partie est lancé
		modele.addPropertyChangeListener(boutons);
		
		
		
		
		
		
	}
	
	/** 
	 * Retourne la largeur du PlateauCanvas
	 * @return la variable largeur de notre JPanel PlateauCanvas
	 */
	public int getLargeur() {

		return this.largeur;
	}
	
	/** 
	 * Redessine le plateau a chaque action
	 * @param evt l'evenement
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.repaint();
		
	}
	
	/** 
	 * Gere la couleur de fond
	 * @param g permet de dessiner
	 */
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Color nouveau_bleu = new Color(0,0,128);
		this.setBackground(nouveau_bleu);
	}

	
	
}
