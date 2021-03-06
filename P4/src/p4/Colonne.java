
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4;

/**
 *
 * @author campus
 */
public class Colonne {

    int hauteur;
    int[] pions;

    public Colonne(int capacite) {
        hauteur = 0;
        pions = new int[capacite];
    }

    public int getHauteur() {
        return hauteur;
    }

    public boolean estPleine() {
        return hauteur == pions.length;
    }

    public void ajouter(int joueur) {
        pions[hauteur] = joueur;
        hauteur++;
    }

    public int getPions(int h) {
        if ((h < pions.length) && (h >= 0)) {
            if (pions[h] == 0) {
                return 0;
            } else {
                return pions[h];
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Colonne truc = new Colonne(5);
        System.out.println(truc.getPions(1));
    }

}

