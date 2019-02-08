package exemples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Une telle classe hérite de junit.framework.TestCase. La méthode annotée par
 * @BeforeEach est exécutée avant les méthodes de test, celle précédée par @AfterEach est
 * appelée à la fin. De la même manière, la méthode annotée par @BeforeAll est
 * appelée au lancement du testCase, celle précédée par @AfterAll est appelée
 * juste avant la fin. Les tests sont des méthodes annotées par @Test, elles font
 * des traitements et vérifient le bon comportement des classes testées par des
 * méthodes assert***(), toute assertion non vérifiée est signalée comme défaillante.
 * Un cas de test (TestCase) peut avoir plusieurs sections @Test. Si une section
 * @Test échoue, le TestCase ne s'arrête pas mais continue sur les sections @Test
 * suivantes (s'il y en a).
 */

/* assertEquals() : Vérifier l'égalité de deux valeurs de type primitif ou objet
 *                  (en utilisant la méthode equals()). Il existe de nombreuses
 *                  surcharges de cette méthode pour chaque type primitif, pour
 *                  un objet de type Object et pour un objet de type String
 * assertTrue() : Vérifier que la valeur fournie en paramètre est vraie
 * assertFalse() : Vérifier que la valeur fournie en paramètre est fausse
 * assertNull() : Vérifier que l'objet fourni en paramètre soit null
 * assertNotNull() : Vérifier que l'objet fourni en paramètre ne soit pas null
 * assertSame() : Vérifier que les deux objets fournis en paramètre font référence
 *                à la même entité (obj1 == obj2)
 * assertNotSame() : Vérifier que les deux objets fournis en paramètre ne font pas
 *                   référence à la même entité
 * assertThrows() : Vérifier qu'une exception d'un type donné est lancée
 */

public class PersonneTest {
    // ATTRIBUT
    private Personne personne;
    
    // METHODES
    @BeforeEach
    public void setUp() {
        personne = new Personne("nom1","prenom1");
    }

    @AfterEach
    public void tearDown() {
        personne = null;
    }

    @Test
    public void testPersonne() {
        assertNotNull(personne, "L'instance n'est pas créée");
    }

    @Test
    public void testGetNom() {
        assertEquals("nom1", personne.getNom(), "Le nom est incorrect");
    }

    @Test
    public void testSetNom() {
        personne.setNom("nom2");
        assertEquals("nom2", personne.getNom(), "Le nom est incorrect");
        assertThrows(IllegalArgumentException.class, () -> personne.setNom(null),
        		"IllegalArgumentException n'est pas lancée");
    }

    @Test
    public void testGetPrenom() {
        assertEquals("prenom1", personne.getPrenom(), "Le prenom est incorrect");
    }

    @Test
    public void testSetPrenom() {
        personne.setPrenom("prenom2");
        assertEquals("prenom2", personne.getPrenom(), "Le prenom est incorrect");
    }
}
