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

# Adding Save and Load Buttons

To add our two buttons, Save and Load, let's create these two classes: Save and Load.
## The Save Class

The Save class implements the Serializable and ActionListener interfaces, allowing us to click on a Save button.

After creating the Save constructor, which takes the Puiss4 model and a filename (String) as parameters, we add the actionPerformed method.

Inside this method, we use a try/catch block. In the try section, we use the ObjectOutputStream class to write objects to a file, along with the FileOutputStream class.

We write the game board to the file using the writeObject method.
<img src="images/sauvegarder-1.png"/>
## The Load Class

The same principle applies to the constructor.

In the actionPerformed method, we use the same class, but this time in Input mode to load the saved file.

Further in the method, we use setText to modify the number of columns, rows, and difficulty level if they have been changed.
<img src="images/charger-1.png"> <img src="images/ligne-col-niv.png">
Converting Them into Buttons

It is quite simple to turn these classes into buttons. We just need to go to our Puiss4Frame class, which contains our frame, and add JButtons to it.
<img src="images/boutons.png"> <img src="images/boutons-2.png">
## Demonstration:

The game state I just saved by clicking the button:
<img src="images/le-sauv.png">

I decide to create a new game while changing the board dimensions:
<img src="images/new-game.png">

Then, I want to return to the previous game state by clicking Load. As we can see, our previous game with 8 columns, 8 rows, and a difficulty level of 3 has been restored.
<img src="images/le-sauv2.png">
## The Logger Class

To implement a logging system, we need to create the Logger class.

We create the three required constructors:
<img src="images/logger-3.png">

Then, we create the Log method, which displays a message along with its importance level.
<img src="images/log.png">

To make our Logger class usable, we need to integrate it into our other classes.

For example, to track which user clicks on which column, we simply create an instance of Logger and use its Log method.

Each message is associated with its importance level.
<img src="images/inserelistener.png">

After implementing it in each class, we initialize it in our Puiss4Frame class:
Logger fl = new Logger();

As seen, each action generates a message in the console.
<img src="images/infos.png">

This also happens when closing the window.

To initialize the logging system by reading the logging configuration from a file, we need to use the Logger(String) constructor.

In this constructor, we read the file using FileReader, extracting only the first line of the given file.

We parse this file to extract the importance level (as a String) and the directory + file name.

Using the niveauDegreImportance method, which converts a string into a constant (INFO, DEBUG, etc.), and the gereFichier method, we can see how log outputs are managed.
<img src="images/logger-2.png">

Then, in the main method of the Puiss4Frame class, we initialize our Logger as follows:
Logger fl = new Logger("config.txt");
Examples:

I decide to modify my config.txt file to store all necessary information in another file named touteInfo.txt.
<img src="images/all.png">

I play a game and close the window—each log entry has been written to touteInfo.txt.

Only INFO messages are displayed, which is why messages such as "Window Closed" or "The program has won" do not appear.
<img src="images/ttinfo.png">

Another example with DEBUG: the messages will not be written to a file but displayed in the console if we specify System.err.
<img src="images/debug.png"> <img src="images/debug-console.png">





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

# Ajout boutons sauvegarder et charger

<p> Pour ajouter nos deux boutons savegarder et charger, créeons ces deux classes : Sauvegarder et Charger. </p>

## La classe : Sauvegarder
<p> La classe Sauvegarder implemente les interfaces Serializable et ActionListener permettant de pouvoir cliquer sur un bouton Sauvegarder. </p>

<p> Apres avoir creer le constructeur Sauvegarder accompagné en parametre du modele Puis4 et un nom de fichier (String), on ajoute la methode actionPerformed. </p>

<p> Dans notre methode, on retrouve un try/catch, dans notre try on retrouve la classe ObjectOutputStream qui permet d’écrire des objets dans un fichier, accompagné du fichier FileOutputStream. </p>

<p> On ecrit dans ce meme fichier notre plateau à sauvegarder à l'aide de la méthode writeObject.

<img src="images/sauvegarder-1.png">

## La classe : Charger

<p> Meme principe concernant le constructeur</p>

<p> Dans la méthode actionPerformed , meme classe à utiliser mais cette fois ci en Input pour charger le fichier sauvegarder.</p>

<p> Plus loin on voit des setText pour modifier les nombres de colonnes , lignes, et niveau si ceux-ci ont été modifié.</p>

<img src="images/charger-1.png">
<img src="images/ligne-col-niv.png">

## Les transformer en boutons

<p> Assez simple de transformer ces classes en boutons. Il suffit d'aller dans notre classe puiss4Frame qui contient notre frame et d'ajouter a cette meme frame des JButtons.</p>

<img src="images/boutons.png">
<img src="images/boutons-2.png">

#### Demonstration :

<p> Partie que je viens de sauvegarder en cliquant sur le bouton</p>
<img src="images/le-sauv.png">

<p> Je decide de creer une nouvelle partie en changeant par ailleurs les dimensions du plateau </p>

<img src="images/new-game.png">

<p> Par la suite je souhaite retourné a la partie precedente en cliquant sur charger, comme on le constate , notre partie avec un nombre de colonne de 8 , un nombre de lignes de 8 et un niveau de difficulté de 3 est revenue. </p>

<img src="images/le-sauv2.png">

## La classe : Logger

<p> Pour réaliser un système de traçage, il faut créer la classe Logger </p>

<p> On crée nos 3 constructeurs demandé </p>
<img src="images/logger-3.png">

<p> On crée par la suite la méthode Log, qui permet d'afficher un message accompagné du degré d'importance </p>

<img src="images/log.png">

<p> Pour que notre classe Logger soit utilisable, il faut l'utiliser dans nos autres classe. </p>

<p>Exemple : pour afficher savoir quel utilisateur clique sur quel colonne il suffit d'avoir notre instance logger et d'utiliser sa methode Log. </p>

<p>Chaque message est accompagné de son degré d'importance. </p>
<img src="images/inserelistener.png">

<p> Apres l'avoir implementé dans chaque classe, il faut l'initialisé dans notre classe Puiss4Frame. Logger fl = new Logger();</p>

<p> Comme on le voit a chaque action, une information est affiché dans la console </p>

<img src="images/infos.png">

<p> Et ce, meme à la fermeture de la fenetre </p>

<p> Pour pouvoir initialiser le système précédent en lisant la configuration de "traçage" dans un fichier, il faut d'abord cette classe Logger(String) </p>


<p> Dans ce constructeur on lit le fichier à l'aide de FileReader, on decide de lire uniquement la premiere ligne de ce fichier donnée en parametre.</p>

<p> On decoupe dans ce fichier le degre d'importance ( en string ) et le repertoire + fichier choisi. </p>

<p> A l'aide de notre methode niveauDegreImportance, qui nous permet de convertir un string en constante (INFO,DEBUG...etc) et de notre methode gereFichier. On peut voir comment les sorties sont gerée . </p>
<img src="images/logger-2.png">

<p> Par la suite dans notre main de la classe Puiss4Frame, on initialise notre Logger comme ceci : Logger fl = new Logger("config.txt"); </p>

### Exemples :

<p> Je décide de modifier mon fichier config.txt pour pouvoir mettre toutes les infos dont j'ai besoin dans un autre fichier nommé touteInfo.txt </p>

<img src="images/all.png">

<p> Je joue une partie et decide de fermer la fenetre, chaque information a été écrite dans notre fichier touteInfo.txt </p>

<p> Il n'y a que les INFO qui sont affiché, c'est pour cela que les messages tel que Fermer Fenetre ou Le programme a gagné ne s'affichent pas </p>

<img src="images/ttinfo.png">

<p> Autre exemple avec DEBUG, les messages ne s'afficheront pas dans un fichier mais dans notre console si on indique System.err <p>

<img src="images/debug.png">
<img src="images/debug-console.png">





