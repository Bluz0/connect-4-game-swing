package puissance4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import puisQuatre.Puis4;

public class NouvelleGame extends JPanel implements ActionListener {

	private Puis4 modele;
	private JTextField col;
	private JTextField ligne;
	private JTextField niveau;
	

	/** 
	 * Permet de creer un nouveau plateau lorsque le bouton "Nouvelle Partie" est cliqué
	 * Recupere les valeurs des inputs pour créer un nouveau plateau
	 * @param modele le modele du jeu
	 * @param col le nombre de colonnes a recuperer sur le TxtField
	 * @param ligne le nombre de lignes a recuperer sur le TxtField
	 * @param niveau le niveau de difficulté a recuperer sur le TxtField
	 */
	public NouvelleGame(Puis4 modele, JTextField col , JTextField ligne, JTextField niveau) {
		
		this.modele = modele;
		this.col = col;
		this.ligne = ligne;
		this.niveau = niveau;

	}
	
	/** 
	 * Recupere les valeurs des inputs pour créer un nouveau plateau
	 * @param e l'evenement
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		modele.nouveauJeu(Integer.parseInt(col.getText()),Integer.parseInt(ligne.getText()),Integer.parseInt(niveau.getText()));
		this.repaint();
	}
	
	
	
	
}
