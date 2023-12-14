package dao;

import entities.Etudiant;

public interface EtudiantDao extends IDAO<Etudiant>{
    Etudiant getByNom(String nom);
}
