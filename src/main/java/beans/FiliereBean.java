package beans;

import entities.Filiere;
import service.FiliereService;
import service.impl.FiliereServiceImpl;

import java.util.List;

public class FiliereBean {

    private Filiere filiere;
    private FiliereService service;
    private boolean isModify;
    public FiliereBean() {
        this.filiere = new Filiere();
        this.service = new FiliereServiceImpl();
        this.isModify = false;
    }

    public boolean isModify() {
        return isModify;
    }

    public void setModify(boolean modify) {
        isModify = modify;
    }

    public String getLabel(){
        if (!isModify) {
            return  "Enregistrer";
        } else {
            return "Modifier";
        }
    }

    public List<Filiere> getFilieres(){
        return this.service.getFiliereTrie();
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
