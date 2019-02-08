package exemples;

public class SecuriteHelper {
    
    public static boolean isMotDePasseValide(String mdp) {
        boolean resultat = true;
        if (mdp == null) {
            resultat = false;
            throw new IllegalArgumentException("le mot de passe n'est pas renseigne");
        } else {
            if (mdp.length() < 6 || mdp.length() > 15) {
                resultat = false;
            }
            if (!mdp.matches(".*[a-zA-Z]*[0-9]*[a-zA-Z]")) {
                resultat = false;
            }
        }
        return resultat;
    }
}
