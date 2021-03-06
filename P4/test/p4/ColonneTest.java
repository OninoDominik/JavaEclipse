package p4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ColonneTest {

	// Attribut Local
		Colonne col;
	@BeforeEach
	void setUp() {
		 col = new Colonne(6);
	}
	@AfterEach
	void nuller() {
		 col = null;
	}

	@Test
	void testConstructeur() {

		assertTrue(col.getHauteur() == 0, "hauteur differente de zero");
		assertTrue(col.pions.length == 6, "taille du tableau incorrect");
	}

	@Test
	void testGetHauteur() {
		Colonne col = new Colonne(6);
		assertTrue(col.getHauteur() == 0, "hauteur differente de zero");
	}

	@Test
	void testEstPleine() {
		Colonne col = new Colonne(6);
		col.hauteur = 6;
		assertTrue(col.estPleine() == true);
		col.hauteur = 5;
		assertTrue(col.estPleine() == false);
		col.hauteur = 0;
		for (int i = 0; i < 5; i++) {
			col.ajouter(2);
		}
		assertTrue(col.estPleine() == false);
		col.ajouter(2);
		assertTrue(col.estPleine() == true);
	}

	@Test
	void testAjouter() {
		Colonne col = new Colonne(6);
		col.ajouter(5);
		assertTrue(col.pions[0] == 5);
		col.ajouter(6);
		assertFalse(col.pions[1] != 6);
	}
	
	@Test
	void testGetPions() {
		col.ajouter(5);
		assertTrue(col.getPions(0)==5, "mauvaise valeur renvoyer");
		col.ajouter(6);
		assertTrue(col.getPions(1)==6, "mauvaise valeur renvoyer");
		col.ajouter(4);
		assertTrue(col.getPions(2)==4, "mauvaise valeur renvoyer");
		col.ajouter(3);
		assertTrue(col.getPions(3)==3, "mauvaise valeur renvoyer");
		col.ajouter(7);
		assertTrue(col.getPions(4)==7, "mauvaise valeur renvoyer");
		col.ajouter(8);
		assertTrue(col.getPions(5)==8, "mauvaise valeur renvoyer");
		assertTrue(col.getPions(6)==-1, "pas de renvoy de -1");
		assertTrue(col.getPions(7)==-1, "pas de renvoy de -1");
		
	}
	
	

}
