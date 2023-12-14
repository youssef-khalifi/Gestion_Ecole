package service.impl;

import dao.FiliereDao;
import dao.impl.FiliereDaoImpl;
import entities.Filiere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FiliereService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class FiliereServiceImplTest {

    private FiliereDao dao;
    private FiliereService service;

    @BeforeEach
    void setUp() {
        dao = new FiliereDaoImpl();
        service = new FiliereServiceImpl();
    }

    @Test
    void getFiliereTrie() {

        List<Filiere> filieresNonTrie = dao.getAll();
        List<Filiere> filieresTrie = service.getFiliereTrie();

        assertEquals(filieresTrie.size(), filieresNonTrie.size());
    }
}