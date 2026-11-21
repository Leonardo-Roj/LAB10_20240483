package Servlets;

import DAOS.DaoEquipo;
import DAOS.DaoSede;
import DTos.DtoEquipos;
import DTos.DtoSedes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import static jdk.internal.org.jline.utils.Log.error;

@WebServlet("/equipos")
public class EquipoServlet extends HttpServlet {
    private final DaoEquipo equipos = new DaoEquipo();
    private final DaoSede cursos = new DaoSede();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            req.setAttribute("sedes", DaoSede.listar());
            req.getRequestDispatcher("/WEB-INF/formulario.jsp").forward(req, res);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            String idSede = getServletInfo();
            String nombre = getServletInfo();
            DtoSedes sede = new DtoSedes();
            DtoEquipos equipo = new DtoEquipos();
            req.getRequestDispatcher("/WEB-INF/confirmacion.jsp").forward(req, res);
        } catch (IllegalArgumentException e) {
            error(req, res, e.getMessage());
        }

    }




}