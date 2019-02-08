package exemples;

public class Personne {
    // ATTRIBUTS
    private String nom;
    private String prenom;

    // CONSTRUCTEURS
    public Personne() {
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    // METHODES
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        if (nom == null) {
            throw new IllegalArgumentException("la propriété nom ne peut pas être null");
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
