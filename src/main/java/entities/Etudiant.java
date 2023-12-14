package entities;

public class Etudiant {
    private Integer id;
    private String nom;
    private String prenom;
    private String cne;
    private Filiere filiere;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String cne, Filiere filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
        this.filiere = filiere;
    }

    public Etudiant(String nom, String prenom, String cne) {
        this.nom = nom;
        this.prenom = prenom;
        this.cne = cne;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cne='" + cne + '\'' +
                ", filiere=" + filiere +
                '}';
    }
}
