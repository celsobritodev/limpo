/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Console;

/**
 *
 * @author Celso
 */
public class ConsoleDAO {

  
    public boolean excluir(long idConsole) {
        boolean isTransactionOk;
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "delete from console where idconsole=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setLong(1, idConsole);
            isTransactionOk=(!ps.execute());
        } catch (SQLException e) {
            System.out.println("Erro ao excluir dados: " + e.getMessage());
            isTransactionOk = false;
        }
        return isTransactionOk;
    }

    // pega um console por seu ID
    public Console getConsolePorId(long idConsole) {
        Console console = null;
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "select * from console where idconsole = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setLong(1, idConsole);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                console = new Console();
                console.setIdConsole(rs.getLong("idconsole"));
                console.setNumSerie(rs.getString("numserie"));
                console.setNome(rs.getString("nome"));
                console.setMarca(rs.getString("marca"));
                double valorConsole = Double.parseDouble(rs.getString("valor"));
                console.setValor(new BigDecimal(valorConsole));
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL : " + e.getMessage());
        }
        return console;
    }

    // lista todos os consoles
    public ArrayList<Console> listar() {
        ArrayList<Console> consoles = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "select * from console";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Console console = new Console();
                console.setIdConsole(rs.getLong("idconsole"));
                console.setNumSerie(rs.getString("numserie"));
                console.setNome(rs.getString("nome"));
                console.setMarca(rs.getString("marca"));
                double valorConsole = Double.parseDouble(rs.getString("valor"));
                console.setValor(new BigDecimal(valorConsole));
                consoles.add(console);
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL : " + e.getMessage());
        }
        return consoles;
    }

    // salva um console
    public boolean salvar(Console console) {
        boolean isTransactionOk;
        try {
            Connection conexao = Conexao.getConexao();
            String sql;
            boolean isInsertMode = (console.getIdConsole() == 0); // flag que indica que esta no modo de insercao de dados
            if (isInsertMode) {
                sql = "INSERT INTO console (numserie,nome,marca,valor) values (?,?,?,?)";
            } else {
                sql = "UPDATE console SET numserie=?, nome=?, marca=?, valor=? where idconsole=?";
            }
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, console.getNumSerie());
            ps.setString(2, console.getNome());
            ps.setString(3, console.getMarca());
            ps.setBigDecimal(4, console.getValor());
            if (!isInsertMode) {
                ps.setLong(5, console.getIdConsole());
            }
           isTransactionOk=!ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            isTransactionOk = false;
        }
        return isTransactionOk;

    }

}
