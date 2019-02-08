package exemples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SecuriteHelperTest {

    @Test
    public void testIsMotDePasseValideNull() {
        assertThrows(IllegalArgumentException.class, () -> SecuriteHelper.isMotDePasseValide(null),
        		"IllegalArgumentException n'est pas lancée");
    }

    @Test
    public void testIsMotDePasseValideVide() {
        assertFalse(SecuriteHelper.isMotDePasseValide(""),
		"Le mot de passe est vide");
    }

    @Test
    public void testIsMotDePasseValideTropCourt() {
        assertFalse(SecuriteHelper.isMotDePasseValide("aaa"),
		"Le mot de passe est trop court");
    }

    @Test
    public void testIsMotDePasseValideTropLong() {
        assertFalse(SecuriteHelper.isMotDePasseValide("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"),
		"Le mot de passe est trop long");
    }

    @Test
    public void testIsMotDePasseValideSansChiffre() {
        assertFalse(SecuriteHelper.isMotDePasseValide("aaaaa"),
		"Le mot de passe ne contient pas de chiffre");
    }

    @Test
    public void testIsMotDePasseValideChiffreEnDernier() {
        assertFalse(SecuriteHelper.isMotDePasseValide("aaaaa6"),
		"Le mot de passe contient un chiffre en derniere position");
    }

    @Test
    public void testIsMotDePasseValideAvecMinMaj() {
        assertTrue(SecuriteHelper.isMotDePasseValide("aAa6Aa"),
		"Le mot de passe est valide");
    }

    @Test
    public void testIsMotDePasseValideAvecArobase() {
        assertTrue(SecuriteHelper.isMotDePasseValide("a@aA6aa"),
		"Le mot de passe est valide");
    }

    @Test
    public void testIsMotDePasseValideStandard() {
        assertTrue(SecuriteHelper.isMotDePasseValide("abc456def"),
		"Le mot de passe est valide");
    }
}
