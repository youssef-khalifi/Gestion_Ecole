package dao.impl;

import dao.EtudiantDao;
import dao.FiliereDao;
import dao.SingletonConnection;
import entities.Etudiant;
import entities.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDaoImpl implements EtudiantDao {

    Connection connection = SingletonConnection.getConnection();

    @Override
    public boolean saveOrUpdate(Etudiant etudiant)
    {
        if(connection == null || etudiant == null)
            return false;

        if(this.findById(etudiant.getId()) != null){
            return this.update(etudiant);
        }else{
            return this.create(etudiant);
        }
    }

    @Override
    public boolean create(Etudiant etudiant)
    {
        if(connection == null || etudiant ==null)
            return false;

        try {
            String query = "insert into etudiant(nom,prenom,cne,filiere) values (?,?,?,?)";

            if (etudiant.getFiliere() == null)
            {
                query = "insert into etudiant(nom,prenom,cne) values (?,?,?)";
            }
            PreparedStatement ps = connection.prepareStatement
                    (query,PreparedStatement.RETURN_GENERATED_KEYS
                    );
            ps.setString(1,etudiant.getNom());
            ps.setString(2,etudiant.getPrenom());
            ps.setString(3,etudiant.getCne());

            if(etudiant.getFiliere() != null)
            {
                ps.setLong(4 , etudiant.getFiliere().getId());
            }
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            while(rs.next())
            {
                etudiant.setId(rs.getInt(1));
            }

            rs.close();
            ps.close();
            System.out.println("Ajouter Etudiant OK");
            return true;
        } catch (SQLException e) {
            System.out.println("Ajouter Etudiant Error"+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Etudiant etudiant) {


        if(connection == null || etudiant ==null)
            return false;

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "update etudiant set nom = ? , prenom = ? , cne = ? , filiere = ? where id = ?"
            );
            ps.setString(1,etudiant.getNom());
            ps.setString(2,etudiant.getPrenom());
            ps.setString(3,etudiant.getCne());
            ps.setLong(4,etudiant.getFiliere().getId());
            ps.setLong(5,etudiant.getId());

            ps.executeUpdate();
            ps.close();
            System.out.println("Modifier Etudiant OK");
            return true;
        } catch (SQLException e) {
            System.out.println("Modifier Etudiant Error"+e.getMessage());
            return false;
        }
    }

    @Override
    public Etudiant findById(Integer id) {

        FiliereDao dao = null;
        Etudiant etudiant = null;

        if(connection == null || id == null)
            return null;

        try {
            PreparedStatement ps = connection.prepareStatement
                    ("select * from etudiant where id = ?");

            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                etudiant = new Etudiant();
                etudiant.setId(rs.getInt(1));
                etudiant.setNom(rs.getString(2));
                etudiant.setPrenom(rs.getString(3));
                etudiant.setCne(rs.getString(4));

                dao = new FiliereDaoImpl();
                etudiant.setFiliere(dao.findById(rs.getInt(5)));
            }
            rs.close();
            ps.close();
            System.out.println("Get etudiant by id OK");
        } catch (SQLException e) {
            System.out.println("Get etudiant by id Error"+e.getMessage());
        }
        return etudiant;
    }

    @Override
    public List<Etudiant> getAll() {

        List<Etudiant> etudiants = new ArrayList<>();
        FiliereDao dao = new FiliereDaoImpl();;

        if(connection == null)
            return null;

        try {
            PreparedStatement ps = connection.prepareStatement
                    ("select * from etudiant");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                Etudiant etudiant = new Etudiant();

                etudiant.setId(rs.getInt(1));
                etudiant.setNom(rs.getString(2));
                etudiant.setPrenom(rs.getString(3));
                etudiant.setCne(rs.getString(4));

                Filiere filiere = dao.findById(rs.getInt(5));
                etudiant.setFiliere(filiere);
                etudiants.add(etudiant);
            }
            rs.close();
            ps.close();
            System.out.println("Get All etudiants OK");
        } catch (SQLException e) {
            System.out.println("Get All etudiants Error"+e.getMessage());
        }
        return etudiants;
    }

    @Override
    public boolean delete(Etudiant etudiant) {

        if (connection == null)
            return false;

        try {
            PreparedStatement ps = connection.prepareStatement
                    ("delete from etudiant where id = ?");
            ps.setInt(1 , etudiant.getId());
            ps.executeUpdate();
            System.out.println("Delete etudiant OK");
            return true;
        } catch (SQLException e) {
            System.out.println("Delete etudiant Error"+e.getMessage());
            return false;
        }

    }

    @Override
    public Etudiant getByNom(String nom) {

        Etudiant etudiant = null;
        FiliereDao dao = new FiliereDaoImpl();
        if (connection == null || nom == null)
            return null;

        try {
            PreparedStatement ps = connection.prepareStatement
                    ("select * from etudiant where nom = ?");
            ps.setString(1 , nom);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                etudiant = new Etudiant();
                etudiant.setId(rs.getInt(1));
                etudiant.setNom(rs.getString(2));
                etudiant.setPrenom(rs.getString(3));
                etudiant.setCne(rs.getString(4));

                Filiere filiere = dao.findById(rs.getInt(5));

                etudiant.setFiliere(filiere);
            }
            rs.close();
            ps.close();
            System.out.println("Get by Nom OK");
        } catch (SQLException e) {
            System.out.println("Get by Nom Error"+e.getMessage());
        }

        return etudiant;
    }
}
