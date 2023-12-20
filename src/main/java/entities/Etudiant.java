package entities;

import jakarta.persistence.*;

@Entity
public class Etudiant {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "NOM", nullable = false, length = 255)
    private String nom;
    @Basic
    @Column(name = "PRENOM", nullable = false, length = 255)
    private String prenom;
    @Basic
    @Column(name = "CNE", nullable = false, length = 255)
    private String cne;
    @ManyToOne
    @JoinColumn(name = "FILIERE", referencedColumnName = "ID")
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
