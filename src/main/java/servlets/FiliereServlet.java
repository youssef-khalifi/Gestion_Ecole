package servlets;

import beans.FiliereBean;
import dao.FiliereDao;
import dao.impl.FiliereDaoImpl;
import entities.Filiere;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Filiere/*")
public class FiliereServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FiliereDao dao = new FiliereDaoImpl();
        FiliereBean filiereBean = (FiliereBean) req.getSession().getAttribute("filiereBean");

        filiereBean.getFiliere().setCode(req.getParameter("code"));
        filiereBean.getFiliere().setLibelle(req.getParameter("libelle"));

        if (req.getRequestURI().contains("save"))
        {
            dao.saveOrUpdate(filiereBean.getFiliere());
            filiereBean.setFiliere(new Filiere());
            filiereBean.setModify(false);
        }

        if(req.getRequestURI().contains("modify")){
            int id = Integer.parseInt(req.getParameter("id"));
            filiereBean.setFiliere(dao.findById(id));
            filiereBean.setModify(true);
        }

        if(req.getRequestURI().contains("delete")){
            int id = Integer.parseInt(req.getParameter("id"));
            dao.delete(dao.findById(id));
        }


       resp.sendRedirect("/School_Mang_war_exploded/Home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
