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
        String msg;
        String pagina = "index.jsp";
        ConsoleDAO consoleDao;
        consoleDao = new ConsoleDAO();
        List<Console> consoles;
        switch (acao) {
            case "list":
                String filtro = request.getParameter("txtFiltro");
                if (filtro == null) {
                    consoles = consoleDao.listar();
                } else {
                    consoles = consoleDao.listarPorFiltro(filtro);
                }
                request.setAttribute("consoles", consoles);
                break;
            case "del":
                Long idConsole1 = Long.valueOf(request.getParameter("id"));
                Boolean deuCerto = consoleDao.excluir(idConsole1);
                if (deuCerto) {
                    msg = "<script>alert('Registro excluído com sucesso');</script>";
                } else {
                    msg = "<script>alert('Erro ao excluir, verifique dependencias');</script>";
                }
               consoles = consoleDao.listar();
                request.setAttribute("consoles", consoles);
                request.setAttribute("msg", msg);
                break;
            case "upd":
                Long idConsole2 = Long.valueOf(request.getParameter("id"));
                Console consoleUpd = consoleDao.getConsolePorId(idConsole2);
                request.setAttribute("console", consoleUpd);
                pagina = "upd.jsp";
                break;

        }
        
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
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
        String pagina;
        String msg;
        Boolean deuCerto;
        Long idConsole = 0L;
        pagina = "add.jsp";
        // verifica se está no modo de alteracao
        if (request.getParameter("txtIdConsole") != null) {
            idConsole = Long.valueOf(request.getParameter("txtIdConsole"));
            pagina = "upd.jsp";
        }

        String numSerie = request.getParameter("txtNumSerie");
        String nome = request.getParameter("txtNome");
        String marca = request.getParameter("txtMarca");
        BigDecimal valor = new BigDecimal(request.getParameter("txtValor"));
        // Monto meu objeto
        Console console = new Console();
        console.setIdConsole(idConsole);
        console.setNumSerie(numSerie);
        console.setMarca(marca);
        console.setNome(nome);
        console.setValor(valor);
        // grava no banco
        ConsoleDAO dao = new ConsoleDAO();

        deuCerto = dao.salvar(console);

        if (deuCerto) {
            msg = "Operação realizada com sucesso";
        } else {
            msg = "Erro ao executar a operação";
        }

        request.setAttribute("msg", msg);

        // manda para a pagina destino
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
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
