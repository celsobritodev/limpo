/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) {
        try {
            Connection conn = Conexao.getConexao();
            if (conn != null) {
                System.out.println("tudo bem!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
