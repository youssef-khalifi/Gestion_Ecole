package dao.impl;

import dao.EtudiantDao;
import dao.FiliereDao;
import entities.Etudiant;
import entities.Filiere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EtudiantDaoImplTest {

    private  EtudiantDao dao = null;
    private FiliereDao daoF = null;
    @BeforeEach
    void setUp() {
        dao = new EtudiantDaoImpl();
        daoF = new FiliereDaoImpl();
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void create() {

        //Arrange
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("youssef");
        etudiant.setPrenom("khalifi");
        etudiant.setCne("P123456789");

        Filiere filiere = new Filiere("DCC" , "devops cloud computing");
        daoF.create(filiere);
        etudiant.setFiliere(filiere);
        //Act
        boolean save = dao.create(etudiant);
        //Assert
        assertNotNull(etudiant.getId());
        assertTrue(save);
        assertNotNull(etudiant.getFiliere());
        assertEquals(etudiant.getFiliere().getId() , filiere.getId());

    }

    @Test
    void update() {
        //Arrange
        Filiere f = daoF.findById(28);
        Etudiant etudiant = new Etudiant("Etu1","Etu1","P123456789",f);
        dao.create(etudiant);

        //act
        etudiant.setCne("P00");
        boolean update = dao.update(etudiant);

        //Assert
        assertTrue(update);
        assertEquals(etudiant.getCne() , "P00");
    }

    @Test
    void findById() {
        //Arrange
        Filiere f = daoF.findById(28);
        Etudiant etudiant = new Etudiant("Etu2","Etu2","P123",f);
        dao.create(etudiant);

        //act
       Integer etudiantId = etudiant.getId();
       Etudiant getEtudiant = dao.findById(etudiantId);

        //Assert
        assertEquals(etudiantId , getEtudiant.getId());

    }

    @Test
    void getAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants = dao.getAll();

        assertNotNull(etudiants);
    }

    @Test
    void delete() {
        //Arrange
        Filiere f = daoF.findById(28);
        Etudiant etudiant = new Etudiant("Etu3","Etu3","P1234",f);
        dao.create(etudiant);

        //act
        boolean delete = dao.delete(etudiant);
        //Assert
        assertTrue(delete);
    }

    @Test
    void getByNom() {
        //Arrange
        Filiere f = daoF.findById(28);
        Etudiant etudiant = new Etudiant("Etu5","Etu5","P1234",f);
        dao.create(etudiant);

        //act
        String nom = etudiant.getNom();
        Etudiant getEtudiant = dao.getByNom(nom);
        //Assert
        assertEquals(nom , getEtudiant.getNom());
    }
}