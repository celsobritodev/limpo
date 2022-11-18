/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import dao.ConsoleDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import modelo.Console;

/**
 *
 * @author Celso
 */
public class TestarCRUD {

    public static void main(String[] args) {
        //TestarListar();
      // TestarInserir();
        //TestarAlterar();
        //TestarPegarPorId(2);
       // TestarExcluirPorId(7);
        TestarListarPorFiltro();
        
    }
    
   
    public static void TestarListarPorFiltro() {
        ConsoleDAO consoleDao = new ConsoleDAO();
        ArrayList<Console> consoles = consoleDao.listarPorFiltro("CASA");
        for (Console console : consoles) {
            System.out.println("idConsole: " + console.getIdConsole());
            System.out.println("Número de série: " + console.getNumSerie());
            System.out.println("Nome: " + console.getNome());
            System.out.println("Marca: " + console.getMarca());
            System.out.println("Valor: " + console.getValor());
            System.out.println("----------------------------------------------");

        }

    } 
    

    public static void TestarExcluirPorId(long idConsole) {
        String mensagem;

        ConsoleDAO consoleDao = new ConsoleDAO();

        if (consoleDao.excluir(idConsole)) {
            mensagem = "Dados excluidos com sucesso para o id: " + idConsole;
        } else {
            mensagem = "<< Console não encontrado >>";
        }
        System.out.println(mensagem);
        System.out.println("----------------------------------------------");
    }

    public static void TestarPegarPorId(long idConsole) {
        String mensagem;

        ConsoleDAO consoleDao = new ConsoleDAO();
        Console console = consoleDao.getConsolePorId(idConsole);

        if (console != null) {
            mensagem = "Dados obtidos com sucesso";
            System.out.println("idConsole: " + console.getIdConsole());
            System.out.println("Número de série: " + console.getNumSerie());
            System.out.println("Nome: " + console.getNome());
            System.out.println("Marca: " + console.getMarca());
            System.out.println("Valor: " + console.getValor());
        } else {
            mensagem = "<< Console não encontrado >>";
        }
        System.out.println(mensagem);
        System.out.println("----------------------------------------------");
    }

    public static void TestarAlterar() {
        String mensagem;

        Console console = new Console();
        console.setIdConsole(2);
        console.setNumSerie("24HHDM0");
        console.setNome("NINT");
        console.setMarca("MEGADRV");
        console.setValor(new BigDecimal("18301.88"));

        ConsoleDAO consoleDao = new ConsoleDAO();

        if (consoleDao.salvar(console)) {
            mensagem = "Console gravado com sucesso!";
        } else {
            mensagem = "Erro ao gravar console";
        }
        System.out.println(mensagem);

    }

    public static void TestarInserir() {
        String mensagem;

        Console console = new Console();
        console.setNumSerie("HMK339BS");
        console.setNome("3EM1");
        console.setMarca("KY");
        console.setValor(new BigDecimal("9999"));

        ConsoleDAO consoleDao = new ConsoleDAO();

        if (consoleDao.salvar(console)) {
            mensagem = "Console gravado com sucesso!";
        } else {
            mensagem = "Erro ao gravar console";
        }
        System.out.println(mensagem);

    }

    /**
     * testa listagens
     */
    public static void TestarListar() {
        ConsoleDAO consoleDao = new ConsoleDAO();
        ArrayList<Console> consoles = consoleDao.listar();
        for (Console console : consoles) {
            System.out.println("idConsole: " + console.getIdConsole());
            System.out.println("Número de série: " + console.getNumSerie());
            System.out.println("Nome: " + console.getNome());
            System.out.println("Marca: " + console.getMarca());
            System.out.println("Valor: " + console.getValor());
            System.out.println("----------------------------------------------");

        }

    }
}
