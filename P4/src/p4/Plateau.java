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
		} else if (DiagonalVic(choixLigne, joueurEnCours, choixCol) == true) {
			changeDeJoueur();
			return true;
		} else {
			changeDeJoueur();
			return false;
		}

	}

	public void joueUnePartie()

	{
		int choix;
		do {
			changeDeJoueur();
			choix = choixDuJoueur() - 1;
			colonnes[choix].ajouter(joueur);
		} while (!aGagne(choix));

	}

	private int choixDuJoueur() {
// Présentation de l’état du plateau
		System.out.println("Etat du plateau :");
		System.out.println(this);
// Demande au joueur dans quelle colonne il va placer son pion
		System.out.print("Le joueur " + joueur + " ajoute un pion dans la colonne : ");
// Récupération du choix du joueur (un numéro de colonne entre 1 et col.length inclus)
		Scanner lire = new Scanner(System.in);
		int choixCol = lire.nextInt();
		while ((choixCol > colonnes.length) || (choixCol <= 0) || colonnes[choixCol - 1].estPleine()) {
			System.out.println("Colonne inexistante ou pleine, reessayez !");
			choixCol = lire.nextInt();
			lire.close();
		}
// La méthode renvoie le choix du joueur
		return choixCol;
	}

	private boolean VerticalVic(int NumLigne, int joueurEnCours, int choixCol) {

		int nbrPionAligne = 0;
		for (int i = NumLigne - 4; i < NumLigne; i++) {
			int test = colonnes[choixCol].getPions(i);
			if (test == joueurEnCours) {
				nbrPionAligne++;
			} else {
				nbrPionAligne = 0;
			}
			if (nbrPionAligne == 3) {
				System.out.println("Joueur " + joueurEnCours + " à gagné");
				return true;
			}
		}
		return false;
	}

	private boolean HorizontalVic(int NumLigne, int joueurEnCours, int choixCol) {
		int nbrPionAligne = 0;

		for (int i = -3; i <= 3; i++) {
			if (i + choixCol >= 0 && i + choixCol < colonnes.length) {
				int test = colonnes[i + choixCol].getPions(NumLigne);
				if (colonnes[i + choixCol].getPions(NumLigne) == joueurEnCours || i + choixCol == choixCol) {
					nbrPionAligne++;
				} else {
					nbrPionAligne = 0;
				}
				if (nbrPionAligne == 4) {
					System.out.println("Joueur " + joueurEnCours + " à gagné");
					return true;
				}
			}
		}
		return false;
	}

	private boolean DiagonalVic(int NumLigne, int joueurEnCours, int choixCol) {
		int nbrPionAligne = 0;

		for (int i = -3; i < 3; i++) {
			if (choixCol + i >= 0 && choixCol + i < colonnes.length && NumLigne + i >= 0
					&& NumLigne + i < colonnes[0].pions.length) {
				if (colonnes[choixCol + i].getPions(NumLigne + i) == joueurEnCours) {
					nbrPionAligne++;
				}
			} else {
				nbrPionAligne = 0;
			}
			if (nbrPionAligne == 4) {
				System.out.println("Joueur " + joueurEnCours + " à gagné");
				return true;
			}
		}
		return false;
	}

	private boolean DiagonalVic2(int NumLigne, int joueurEnCours, int choixCol) {
		int nbrPionAligne = 0;

		for (int i = -3; i < 3; i++) {
			if (choixCol + i >= 0 && choixCol + i < colonnes.length && NumLigne - i >= 0
					&& NumLigne - i < colonnes[0].pions.length) {
				if (colonnes[choixCol + i].getPions(NumLigne - i) == joueurEnCours) {
					nbrPionAligne++;
				}
			} else {
				nbrPionAligne = 0;
			}
			if (nbrPionAligne == 4) {
				System.out.println("Joueur " + joueurEnCours + " à gagné");
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
