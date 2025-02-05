/** 
@author @Bluz0 (Mouats Amine)
@author @Ewilanstr (Struffi Camille)
*/



package puissance4;

import java.awt.*;
import javax.swing.*;

import puisQuatre.Puis4;

public class puiss4Frame extends JFrame {
	
	private PlateauCanvas plateau;
	private Puis4 modele;
	
	final static int HAUTEUR = 800;
	final static int LARGEUR = 800;
	/** 
	 * Fenetre affichant :
	 * - La classe NouvelleGame ( bouton "Nouvelle Partie" )
	 * - Notre PlateauCanvas incluant les 3 classes
	 * - Des JLabel et JTextField permettant de montrer le nombre de colonnes,lignes et niveau de difficulté
	 * @param p plateauCanvas
	 * @param m le modele
	 */
	public puiss4Frame(PlateauCanvas p,Puis4 m) {
		
		
		this.plateau = p;
		this.modele = m;
		this.setSize(LARGEUR,HAUTEUR);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.getContentPane().setLayout(new BorderLayout());
		
		// Panel pour integrer notre bouton NouvelleGame
		JPanel bouton_p = new JPanel();
		bouton_p.setPreferredSize(new Dimension(300,100));
		bouton_p.setLayout(new FlowLayout());
		
		// Panel pour integrer notre PlateauCanvas
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		pane.add(plateau);
		
		// Panel pour integrer les JLabel et JTextField
		JPanel infoP = new JPanel();
		
		// Declaration des JLabel et JTextField
		JLabel lcol = new JLabel("Nb colonnes :");
		JTextField lnbcol = new JTextField(String.valueOf(modele.getNbColonnes()));
		
		JLabel llignes = new JLabel("Nb lignes :");
		JTextField lnblignes = new JTextField(String.valueOf(modele.getNbLignes()));
		
		JLabel lniveau = new JLabel("Niveau de difficulté :");
		JTextField txtniveau = new JTextField(String.valueOf(modele.getNiveauJeu()));
		
		// Ajout des JLabel et JTextField dans le panel infoP
		infoP.add(lcol);
		infoP.add(lnbcol);
		infoP.add(llignes);
		infoP.add(lnblignes);
		infoP.add(lniveau);
		infoP.add(txtniveau);
		
		// Gere le bouton nouvelle game en le mettant dans un jpanel, en attribuant la classe permettant de changer le plateau
		JButton nouvellePartie = new JButton("Nouvelle partie");
		nouvellePartie.addActionListener(new NouvelleGame(m,lnbcol,lnblignes,txtniveau));
		Color nouveau_bleu = new Color(217,243,255);
		infoP.setBackground(nouveau_bleu);
		bouton_p.setBackground(nouveau_bleu);
		bouton_p.add(nouvellePartie);
		pane.setBackground(nouveau_bleu);
		
		this.add(bouton_p,BorderLayout.NORTH);
		
		this.add(pane);
		this.add(infoP,BorderLayout.SOUTH);
		
	}

	
	public static void main(String[] args) {
		/** 
		 * Ouverture de la fenetre
		 */
		Puis4 m = new Puis4();
		PlateauCanvas p = new PlateauCanvas(m);
		puiss4Frame f = new puiss4Frame(p,m);
		
		f.setVisible(true);
		
	}

}
