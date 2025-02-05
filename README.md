## PUISSANCE 4

## EN FRANCAIS :fr:
#### @auteur : @Bluz0 @Ewilanstr

### Classe : Plateau
<p> Premierement, nous avons crée une classe Plateau permettant de modeliser un plateau de jeu par rapport a un nombre de colonnes et de lignes grace à la methode paintComponent.</p>
<p> Pour dessiner le plateau, on doit delimiter les lignes et colonnes. On recupere une largeur, une hauteur et le x et y pour placer notre pion au bon endroit. </p>

<p>Code de la methode paintComponent de la classe Plateau :
<img src="images/placement_pion.png">

<p> Comme on peut le voir si le modele est vide , notre plateau sera composé de pions vides. Selon le choix du joueur, son pion se placera selon la position souhaité.</p>

<p>Résultat :</p>
<img src="images/plateau_vide.png">

### Classe : GridBouton

<p>La classe GridBouton permet de creer une ligné de boutons afin de pouvoir inserer nos pions selon le bouton cliqué.</p>
<p> On implemente egalement dans ce JPanel l'interface PropertyChangeListener afin de pouvoir actualiser le nombre de boutons si le nombre de colonnes est changé.</p>
<p>A l'aide d'une boucle, on ajoute un bouton pour chaque colonne, et on attribut a ces boutons un listener afin de creer une action lorsque l'on clique dessus (InsereListener)</p>

<p>Pour un nombre de colonnes de 7 (par defaut), on crée 7 boutons</p>
<img src="images/boutons_sans_fcts.png">

### Classe : InsereListener

<p>Grace à l'implementation d'ActionListener et de sa methode actionPerformed, a chaque fois qu'un bouton est cliqué, on va selectionné la colonne et verifier si la il est possible de jouer et de verifier si le partie n'est pas fini</p>

<p>En cliquant sur le 3eme bouton en partant de la gauche, on constate que notre pion est posé. On constate egalement que le programme pose instantanement son pion.</p>
<img src="images/bouton_avec_fct.png">

### Classe : AfficheResultat

<p>La classe AfficheResultat est un JPanel permettant de voir le resultat final, les gagnants peuvent etre le joueur ou le programme</p> 
<p>Le panel se refraichit tant que le jeu ne se fini pas, si le joueur decide de continuer de jouer alors que le jeu est fini , le plateau cesse de se rafraichir</p>

<p>Si le programme gagne, un fond rouge et un texte s'affiche</p>
<img src="images/programme_win.png">

<p>Meme procedé pour la victoire du joueur</p>
<img src="images/joueur_win.png">

<p>Le resultat change dans la methode propertyChange</p>

### Classe : PlateauCanvas

<p>Cette classe regroupe les trois JPanels : GridBoutons, Plateau et AfficheResultat en un Jpanel.</p>
<p>Dans notre constructeur on a bien evidemment l'ajout dans des JPanel mais il y a aussi l'actualisation du modele dans les classes AfficheResultat et GridBoutons : "modele.addPropertyChangeListener(param)".</p>

### Classe SourisClick

<p>Cette classe permet de jouer au jeu sans cliquer sur les boutons. On peut maintenant jouer en cliquant sur le plateau directement en cliquant sur la colonne voulu.</p>

<p>On recupere le nb colonnes à l'aide de la position de la souris, de la largeur du plateau et du nombre de colonnes.</p>

<p>On peut jouer en cliquant sur le plateau</p>

### Classe NouvelleGame

<p>La classe nouvelleGame est un JPanel comportant un bouton (Voir Classe puiss4Frame) permettant de creer un nouveauJeu en modifiant le nombre de colonnes , le nombre de lignes et le niveau de difficulté en recuperant dans des JTextField les informations necessaires (Voir Classe puiss4Frame)</p>

### Classe Puiss4Frame

<p>Toute ces classes sont inutiles sans fenetre , dans notre constructeur un jpanel est ajouté pour chaque classe.</p>

<p>Pour la classe NouvelleGame, on associe un bouton a l'ActionListener : NouvelleGame permettant de changer le nombre de colonnes , de lignes et le niveau de difficulté dans le modele</p>

<img src="images/bouton_new_game.png">

<p>Mais ce bouton ne fonctionne pas sans recuperer nos données necessaires</p>

<p>On crée alors trois JLabel et trois JTextField avec comme valeur par defaut ceux du jeu par default (nb colonnes : 7, nb lignes : 6, niveau de difficulté : 2).</p>

<p>Grace a nos TxtField notre bouton est fonctionnel</p>
<img src="images/game_defaut.png">

<p>En changeant nos jtxtfield puis en cliquant sur Nouvelle Partie, notre plateau se modifie en plateau 9x9 : </p>

<img src="images/9x9.png">


