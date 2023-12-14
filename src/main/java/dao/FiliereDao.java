package dao;

import entities.Filiere;

public interface FiliereDao extends IDAO<Filiere>{

    Filiere getByCode(String code);
}
