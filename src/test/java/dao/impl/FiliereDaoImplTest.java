package dao.impl;

import com.sun.source.tree.AssertTree;
import entities.Filiere;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FiliereDaoImplTest {

    private FiliereDaoImpl dao ;
    @BeforeEach
    void setUp() {
       dao  = new FiliereDaoImpl();
    }

    @Test
    void saveOrUpdate() {

    }

    @Test
    void create() {
        //Arrange

        Filiere f = new Filiere();
        f.setCode("SMI");
        f.setLibelle("Science Mathematique Informatique");

        //Assert
        assertTrue(dao.create(f));
        assertNotNull(f.getId());
    }

    @Test
    void update() {

        Filiere f = new Filiere();
        f.setCode("SA");
        f.setLibelle("Science Mathematique ");
        dao.create(f);


        f.setLibelle("Science Mathematique Applique et mathode devops");

        assertTrue(dao.update(f));
        assertEquals("Science Mathematique Applique et mathode devops" , f.getLibelle());
    }

    @Test
    void findById() {

        Filiere f = new Filiere();
        f.setCode("SMA");
        f.setLibelle("Science Mathematique Applique ");
        dao.create(f);

        Integer fId = f.getId();
        Filiere retrievedFiliere = dao.findById(fId);


        assertNotNull(retrievedFiliere);
        assertEquals(fId, retrievedFiliere.getId());
    }

    @Test
    void getAll() {
        //Arrange
        List<Filiere> filieres =  new ArrayList<>();

        //Act
        filieres = dao.getAll();

        //Assert
        assertNotNull(filieres);
        assertFalse(filieres.isEmpty());
    }

    @Test
    void delete() {

        Filiere f = new Filiere();
        f.setCode("DCC");
        f.setLibelle("devops & cloud computing");
        dao.create(f);

        assertTrue(dao.delete(f));
    }

    @Test
    void getByCode() {

        //Arrange
        Filiere f = new Filiere();
        f.setCode("test");
        f.setLibelle("test");
        dao.create(f);
        //Act
        Filiere getF = dao.getByCode(f.getCode());

        //Assert
        assertEquals(f.getCode() , getF.getCode());
    }


}