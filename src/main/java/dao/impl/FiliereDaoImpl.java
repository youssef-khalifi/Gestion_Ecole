package dao.impl;

import dao.FiliereDao;
import dao.SingletonConnection;
import entities.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiliereDaoImpl implements FiliereDao {

  Connection connection = SingletonConnection.getConnection();

    @Override
    public boolean saveOrUpdate(Filiere filiere) {
        if(connection == null || filiere == null)
            return false;

        if(this.findById(filiere.getId()) != null){
            return this.update(filiere);
        }else{
            return this.create(filiere);
        }

    }

    @Override
    public boolean create(Filiere filiere) {

        if(connection == null || filiere == null)
            return false;

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into filiere (code,libelle) values(?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, filiere.getCode());
            ps.setString(2, filiere.getLibelle());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next())
            {
                filiere.setId(rs.getInt(1));
            }
            rs.close();
            ps.close();
            System.out.println("add filiere OK");
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur creation"+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Filiere filiere) {

        if(connection == null || filiere == null)
            return false;

        try {
            PreparedStatement ps = connection.prepareStatement(
                    "update filiere set code = ? , libelle = ? where id = ?"
            );

            ps.setString(1, filiere.getCode());
            ps.setString(2, filiere.getLibelle());
            ps.setInt(3,filiere.getId());
            ps.executeUpdate();

            ps.close();
            System.out.println("update filiere OK");
            return true;
        } catch (SQLException e) {
            System.out.println("Erreur update"+e.getMessage());
            return false;
        }
    }

    @Override
    public Filiere findById(Integer id) {
        if(connection == null || id == null)
            return null;

        Filiere filiere = null;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from filiere where id = ?"
            );
            ps.setInt(1 ,id);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                filiere = new Filiere();

                filiere.setId(rs.getInt(1));
                filiere.setCode(rs.getString(2));
                filiere.setLibelle(rs.getString(3));
            }

            rs.close();
            ps.close();
            System.out.println("get Filiere By ID OK");
        } catch (SQLException e) {
            System.out.println("get Filiere By ID Erreur"+e.getMessage());
        }
        return filiere;
    }

    @Override
    public List<Filiere> getAll() {

        if (connection == null)
            return null;

        List<Filiere> filieres = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from filiere"
            );
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Filiere f = new Filiere();

                f.setId(rs.getInt(1));
                f.setCode(rs.getString(2));
                f.setLibelle(rs.getString(3));
                filieres.add(f);

            }
            rs.close();
            ps.close();
            System.out.println("get All Filiere  OK");
        } catch (SQLException e) {
            System.out.println("get All Filiere  Error"+e.getMessage());
        }
        return filieres;
    }

    @Override
    public boolean delete(Filiere filiere) {

        if (connection == null)
            return false;


        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from filiere where id = ?"
            );
            ps.setInt(1,filiere.getId());
            ps.executeUpdate();
            ps.close();
            System.out.println("Delete Filiere  OK");
            return true;
        } catch (SQLException e) {
            System.out.println("Delete Filiere  Error"+e.getMessage());
            return false;
        }
    }

    @Override
    public Filiere getByCode(String code) {
        if (connection == null )
            return null;

        Filiere filiere = null;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from filiere where code = ?"
            );
            ps.setString(1 ,code);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                filiere = new Filiere();

                filiere.setId(rs.getInt(1));
                filiere.setCode(rs.getString(2));
                filiere.setLibelle(rs.getString(3));
            }

            rs.close();
            ps.close();
            System.out.println("get Filiere By Code OK");
        } catch (SQLException e) {
            System.out.println("get Filiere By Code Erreur"+e.getMessage());
        }
        return filiere;
    }

}
