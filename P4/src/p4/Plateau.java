/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p4;

import java.util.Scanner;

/**
 *
 * @author campus
 */
public class Plateau {

	private Colonne colonnes[];
	private int capacite;

	private int joueur;

	/**
	 * Constructeur.
	 * 
	 * @param nbCol    Nombre de collones
	 * @param capacite taille des collonne
	 */
	public Plateau(int nbCol, int capacite) {
		this.capacite = capacite;
		this.joueur = 2;
		colonnes = new Colonne[nbCol];
		for (int i = 0; i < colonnes.length; i++) {
			colonnes[i] = new Colonne(capacite);
		}
	}

	/**
	 * getteur de capacite.
	 * 
	 * @return capacite attribut de classe
	 */
	public int getCapacite() {
		return capacite;
	}

	public int getJoueur() {
		return joueur;
	}

	public int getColonnesLength() {
		return colonnes.length;
	}

	public Colonne[] getColonnes() {
		return colonnes;
	}

	public boolean estPlein() //
	{
		boolean estPlein = false;
		for (Colonne colonne : colonnes) {
			if (colonne.estPleine()) {
				estPlein = true;
			}
		}
		return estPlein;
	}

	public String toString() {
		String resultString = "";
		for (int i = (capacite - 1); i >= 0; i--) {
			for (int j = 0; j < (colonnes.length); j++) {
				switch (colonnes[j].getPions(i)) {
				case 0:
					resultString += ".";
					break;
				case 1:
					resultString += "O";
					break;
				case 2:
					resultString += "X";
					break;
				default:
					break;
				}
				if (j == colonnes.length - 1) {
					resultString += "\n";
				}
			}
		}
		return resultString;
	}

	private void changeDeJoueur() {
		if (joueur == 1) {
			joueur = 2;
		} else {
			joueur = 1;
		}

	}

	private boolean aGagne(int choixCol) {
		changeDeJoueur();
		int joueurEnCours = joueur;

		// Test Horizontal
		int choixLigne = colonnes[choixCol].getHauteur();
		if (HorizontalVic(choixLigne, joueurEnCours, choixCol) == true) {
			changeDeJoueur();
			return true;
		} else if (VerticalVic(choixLigne, joueurEnCours, choixCol) == true) {
			changeDeJoueur();
			return true;
		} else if (DiagonalVic2(choixLigne, joueurEnCours, choixCol) == true) {
			changeDeJoueur();
			return true;
		}else {
			changeDeJoueur();
			return false;
		}

	}

	public void joueUnePartie()

	{
		int choix = choixDuJoueur() - 1;
		System.out.println("choix :" + choix);
		while (!aGagne(choix)) {
			System.out.println("choix :" + choix);
			changeDeJoueur();
			colonnes[choix].ajouter(joueur);
			System.out.println("choix :" + choix);
			choix = choixDuJoueur() - 1;

		}

	}

	private int choixDuJoueur() {
// Pr�sentation de l��tat du plateau
		System.out.println("Etat du plateau :");
		System.out.println(this);
// Demande au joueur dans quelle colonne il va placer son pion
		System.out.print("Le joueur " + joueur + " ajoute un pion dans la colonne : ");
// R�cup�ration du choix du joueur (un num�ro de colonne entre 1 et col.length inclus)
		Scanner lire = new Scanner(System.in);
		int choixCol = lire.nextInt();
		while ((choixCol > colonnes.length) || (choixCol <= 0) || colonnes[choixCol - 1].estPleine()) {
			System.out.println("Colonne inexistante ou pleine, reessayez !");
			choixCol = lire.nextInt();
			lire.close();
		}
// La m�thode renvoie le choix du joueur
		return choixCol;
	}

	private boolean VerticalVic(int NumLigne, int joueurEnCours, int choixCol) {

		int nbrPionAligne = 0;
		System.out.println("V numligne : " + NumLigne);
		System.out.println("V joueurEnCours : " + joueurEnCours + joueur);
		System.out.println("V choixCol : " + choixCol);

		for (int i = NumLigne - 4; i <= NumLigne; i++) {
			int test = colonnes[choixCol].getPions(i);
			if (test == joueurEnCours) {
				nbrPionAligne++;
			} else {
				nbrPionAligne = 0;
			}
			if (nbrPionAligne == 3) {
				System.out.println(joueurEnCours + "gagne");
				return true;
			}
		}
		return false;
	}

	private boolean HorizontalVic(int NumLigne, int joueurEnCours, int choixCol) {
		int nbrPionAligne = 0;
		System.out.println("H numligne : " + NumLigne);
		System.out.println("H joueurEnCours : " + joueurEnCours);
		System.out.println("H choixCol : " + choixCol);
		for (int i = choixCol - 3; i < choixCol + 3; i++) {
			if (choixCol - 3 >= 0 && choixCol + 3 <= colonnes.length) {
				if (colonnes[i].getPions(NumLigne) == joueurEnCours) {
					nbrPionAligne++;
				} else {
					nbrPionAligne = 0;
				}
				if (nbrPionAligne == 3) {
					System.out.println(joueurEnCours + "gagne");
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean DiagonalVic(int NumLigne, int joueurEnCours, int choixCol) {
		int nbrPionAligne = 0;
		System.out.println("H numligne : " + NumLigne);
		System.out.println("H joueurEnCours : " + joueurEnCours);
		System.out.println("H choixCol : " + choixCol);
		for (int i =  - 3; i <  3; i++) {
			System.out.println("H numligne : " + (NumLigne+i) );
			
			if (choixCol + i >= 0 && choixCol + i < colonnes.length && NumLigne+i >=0 && NumLigne+i < colonnes[0].pions.length) {
				if (colonnes[choixCol+i].getPions(NumLigne+i) == joueurEnCours) {
					nbrPionAligne++;
				}} else {
					nbrPionAligne = 0;
				}
				if (nbrPionAligne == 3) {
					System.out.println(joueurEnCours + "gagne");
					return true;
				}
			}
		return false;
	}
	private boolean DiagonalVic2(int NumLigne, int joueurEnCours, int choixCol) {
		int nbrPionAligne = 0;
		System.out.println("H numligne : " + NumLigne);
		System.out.println("H joueurEnCours : " + joueurEnCours);
		System.out.println("H choixCol : " + choixCol);
		for (int i =  - 3; i <  3; i++) {
			System.out.println("H numligne : " + (NumLigne+i) );
			
			if (choixCol + i >= 0 && choixCol + i < colonnes.length && NumLigne-i >=0 && NumLigne-i < colonnes[0].pions.length) {
				if (colonnes[choixCol+i].getPions(NumLigne-i) == joueurEnCours) {
					nbrPionAligne++;
				}} else {
					nbrPionAligne = 0;
				}
				if (nbrPionAligne == 3) {
					System.out.println(joueurEnCours + "gagne");
					return true;
				}
			}
		return false;
	}

	public static void main(String[] args) {
		Plateau dom = new Plateau(7, 6);
		dom.joueUnePartie();
	}
}