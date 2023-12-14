package service.impl;

import dao.FiliereDao;
import dao.impl.FiliereDaoImpl;
import entities.Filiere;
import service.FiliereService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FiliereServiceImpl implements FiliereService {

    private FiliereDao dao = new FiliereDaoImpl();
    @Override
    public List<Filiere> getFiliereTrie() {

        List<Filiere> filieres = dao.getAll();

        Collections.sort(filieres, new Comparator<Filiere>() {
            @Override
            public int compare(Filiere o1, Filiere o2) {
                return o1.getCode().compareTo(o2.getCode());
            }
        });

       /* List<Filiere> sortedFilieres = filieres.stream()
                .sorted((f1, f2) -> f1.getCode().compareTo(f2.getCode()))
                .collect(Collectors.toList());*/

        return filieres;
    }
}
