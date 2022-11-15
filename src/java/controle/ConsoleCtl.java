/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ConsoleDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import modelo.Console;

/**
 *
 * @author marcelosiedler
 */
@WebServlet(name = "ConsoleCtl", urlPatterns = {"/console/ConsoleCtl"})
public class ConsoleCtl extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("action");
        ConsoleDAO consoleDao;
        switch (acao) {
            case "list":
                consoleDao = new ConsoleDAO();
                List<Console> lista = consoleDao.listar();
                request.setAttribute("lista", lista);
                break;
        }
        RequestDispatcher destino = request.getRequestDispatcher("index.jsp");
        destino.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numserie = request.getParameter("txtNumSerie");
        String nome = request.getParameter("txtNome");
        String marca = request.getParameter("txtMarca");
        BigDecimal valor = new BigDecimal(request.getParameter("txtValor"));
        // Monto meu objeto
        Console console = new Console();
        console.setNumSerie(numserie);
        console.setMarca(marca);
        console.setNome(nome);
        console.setValor(valor);
        // grava no banco
        ConsoleDAO dao = new ConsoleDAO();

        Boolean deuCerto = dao.salvar(console);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
