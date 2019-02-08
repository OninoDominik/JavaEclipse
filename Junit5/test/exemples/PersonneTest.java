package exemples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Une telle classe h�rite de junit.framework.TestCase. La m�thode annot�e par
 * @BeforeEach est ex�cut�e avant les m�thodes de test, celle pr�c�d�e par @AfterEach est
 * appel�e � la fin. De la m�me mani�re, la m�thode annot�e par @BeforeAll est
 * appel�e au lancement du testCase, celle pr�c�d�e par @AfterAll est appel�e
 * juste avant la fin. Les tests sont des m�thodes annot�es par @Test, elles font
 * des traitements et v�rifient le bon comportement des classes test�es par des
 * m�thodes assert***(), toute assertion non v�rifi�e est signal�e comme d�faillante.
 * Un cas de test (TestCase) peut avoir plusieurs sections @Test. Si une section
 * @Test �choue, le TestCase ne s'arr�te pas mais continue sur les sections @Test
 * suivantes (s'il y en a).
 */

/* assertEquals() : V�rifier l'�galit� de deux valeurs de type primitif ou objet
 *                  (en utilisant la m�thode equals()). Il existe de nombreuses
 *                  surcharges de cette m�thode pour chaque type primitif, pour
 *                  un objet de type Object et pour un objet de type String
 * assertTrue() : V�rifier que la valeur fournie en param�tre est vraie
 * assertFalse() : V�rifier que la valeur fournie en param�tre est fausse
 * assertNull() : V�rifier que l'objet fourni en param�tre soit null
 * assertNotNull() : V�rifier que l'objet fourni en param�tre ne soit pas null
 * assertSame() : V�rifier que les deux objets fournis en param�tre font r�f�rence
 *                � la m�me entit� (obj1 == obj2)
 * assertNotSame() : V�rifier que les deux objets fournis en param�tre ne font pas
 *                   r�f�rence � la m�me entit�
 * assertThrows() : V�rifier qu'une exception d'un type donn� est lanc�e
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
        assertNotNull(personne, "L'instance n'est pas cr��e");
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
        		"IllegalArgumentException n'est pas lanc�e");
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
