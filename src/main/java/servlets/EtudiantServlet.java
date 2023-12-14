package servlets;

import beans.EtudiantBean;
import dao.EtudiantDao;
import dao.FiliereDao;
import dao.impl.EtudiantDaoImpl;
import dao.impl.FiliereDaoImpl;
import entities.Etudiant;
import entities.Filiere;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Etudiants/*")
public class EtudiantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EtudiantDao etudiantDao = new EtudiantDaoImpl();
        FiliereDao filiereDao = new FiliereDaoImpl();
        EtudiantBean etudiantBean = (EtudiantBean) req.getSession().getAttribute("etudiantBean");

        etudiantBean.getEtudiant().setNom(req.getParameter("nom"));
        etudiantBean.getEtudiant().setPrenom(req.getParameter("prenom"));
        etudiantBean.getEtudiant().setCne(req.getParameter("cne"));

        if(req.getRequestURI().contains("save"))
        {
            Filiere filiere = null;

            if(req.getParameter("filiere") != null)
            {
                 filiere = filiereDao.getByCode(req.getParameter("filiere"));
                 etudiantBean.getEtudiant().setFiliere(filiere);
            }
           // System.out.println(etudiantBean.getEtudiant().toString());
            etudiantDao.saveOrUpdate(etudiantBean.getEtudiant());
            etudiantBean.setEtudiant(new Etudiant());
            etudiantBean.setModify(false);
        }

        if (req.getRequestURI().contains("modify"))
        {
            Integer id = Integer.parseInt(req.getParameter("id"));
            etudiantBean.setEtudiant(etudiantDao.findById(id));
            etudiantBean.setModify(true);
        }

        if (req.getRequestURI().contains("delete"))
        {
            Integer id = Integer.parseInt(req.getParameter("id"));
            etudiantDao.delete(etudiantDao.findById(id));
        }
        resp.sendRedirect("/School_Mang_war_exploded/Etudiant");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
