package Servlets;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import DAOS.*;
import DTos.*;

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




}