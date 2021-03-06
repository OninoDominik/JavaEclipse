package p4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlateauTest {

	// Attribut Local
			private Plateau testPlateau;
		@BeforeEach
		void setUp() {
			testPlateau = new Plateau(6,8);
		}
		@AfterEach
		void nuller() {
			testPlateau = null;
		}
		@Test
		void testConstructeur() {
			assertNotNull(testPlateau, " le constructeur n'a aps cr�er d'instance");
			assertTrue(testPlateau.getCapacite() == 8, "capacit� incorrect");
			assertTrue(testPlateau.getJoueur() == 2, "hauteur differente de zero");
			assertTrue(testPlateau.getColonnesLength() == 6, "taille du tableau collone incorrect");
	        for (int i = 0; i < testPlateau.getColonnesLength(); i++) {
	        	assertNotNull(testPlateau.getColonnes()[i] );
	        }
		}
		@Test
		void testEstPleinPlateauVide() {
			assertFalse(testPlateau.estPlein(), "reconnu plein alors qu'il est vide");
		}
		@Test
		void testEstPleinPlateauMiVide() {
			testPlateau.getColonnes()[1].ajouter(2);
			testPlateau.getColonnes()[1].ajouter(2);
			testPlateau.getColonnes()[0].ajouter(2);
			testPlateau.getColonnes()[1].ajouter(1);
			testPlateau.getColonnes()[3].ajouter(2);
			testPlateau.getColonnes()[4].ajouter(1);
			testPlateau.getColonnes()[3].ajouter(2);
			testPlateau.getColonnes()[4].ajouter(1);
			testPlateau.getColonnes()[3].ajouter(2);
			testPlateau.getColonnes()[4].ajouter(1);
			assertFalse(testPlateau.estPlein(), "reconnu plein alors qu'il est vide");
		}
		
		

}
