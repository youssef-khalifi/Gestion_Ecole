package entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

@Entity
public class Filiere {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "CODE", nullable = false, length = 255)
    private String code;
    @Basic
    @Column(name = "LIBELLE", nullable = false, length = 255)
    private String libelle;
    @OneToMany(mappedBy = "filiere")
    private Set<Etudiant> etudiants;

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Filiere(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Filiere() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
