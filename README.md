## PUISSANCE 4

## EN FRANCAIS :fr:
#### @auteurs : @Bluz0 @Ewilanstr

### Jeu crée en java avec swing

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




## CONNECT FOUR

## IN ENGLISH :gb:
#### @author: @Bluz0 @Ewilanstr

### Game created in Java with Swing

### Class: Board

<p>First, we created a Board class to model a game board with a specific number of columns and rows using the paintComponent method.</p> <p>To draw the board, we need to define the rows and columns. We retrieve a width, a height, and the x and y coordinates to place our piece in the correct position.</p> <p>Code of the paintComponent method from the Board class: <img src="images/placement_pion.png"> <p>As we can see, if the model is empty, our board will consist of empty pieces. Depending on the player's choice, their piece will be placed in the desired position.</p> <p>Result:</p> <img src="images/plateau_vide.png">
Class: GridButton
<p>The GridButton class allows the creation of a row of buttons to insert pieces based on the clicked button.</p> <p>We also implement the PropertyChangeListener interface in this JPanel to update the number of buttons when the number of columns changes.</p> <p>Using a loop, we add a button for each column and assign a listener to these buttons to create an action when clicked (InsertListener).</p> <p>For a default column count of 7, we create 7 buttons:</p> <img src="images/boutons_sans_fcts.png">


### Class: InsertListener

<p>By implementing ActionListener and its actionPerformed method, each time a button is clicked, we select the column, check if it's possible to play, and verify if the game is over.</p> <p>By clicking on the third button from the left, we see that our piece is placed. We also notice that the program immediately places its piece.</p> <img src="images/bouton_avec_fct.png">

### Class: DisplayResult
<p>The DisplayResult class is a JPanel that shows the final result. The winner can be either the player or the program.</p> <p>The panel refreshes as long as the game is not over. If the player decides to continue playing after the game has ended, the board stops refreshing.</p> <p>If the program wins, a red background and a message appear:</p> <img src="images/programme_win.png"> <p>The same process applies when the player wins:</p> <img src="images/joueur_win.png"> <p>The result changes in the propertyChange method.</p>

### Class: BoardCanvas

<p>This class groups the three JPanels: GridButtons, Board, and DisplayResult into a single JPanel.</p> <p>In our constructor, we add these JPanels and update the model in the DisplayResult and GridButtons classes using "modele.addPropertyChangeListener(param)".</p>

### Class: MouseClick
<p>This class allows playing the game without clicking on the buttons. Now, we can play by clicking directly on the board in the desired column.</p> <p>We retrieve the number of columns using the mouse position, the board width, and the number of columns.</p> <p>Players can now place their pieces by clicking on the board.</p>

### Class: NewGame
<p>The NewGame class is a JPanel containing a button (See Puiss4Frame class) that allows creating a new game by modifying the number of columns, rows, and difficulty level using data retrieved from JTextFields (See Puiss4Frame class).</p>

### Class: Puiss4Frame
<p>All these classes are useless without a window. In our constructor, a JPanel is added for each class.</p> <p>For the NewGame class, we associate a button with the ActionListener: NewGame, which allows changing the number of columns, rows, and difficulty level in the model.</p> <img src="images/bouton_new_game.png"> <p>However, this button will not work without retrieving the necessary data.</p> <p>We then create three JLabels and three JTextFields with default values taken from the default game settings (columns: 7, rows: 6, difficulty level: 2).</p> <p>Thanks to our JTextFields, our button is functional.</p> <img src="images/game_defaut.png"> <p>By changing our JTextFields and clicking on New Game, our board updates to a 9x9 board:</p> <img src="images/9x9.png">
