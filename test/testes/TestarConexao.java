/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;

import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;

public class TestarConexao {

    public static void main(String[] args) {
        try {
            Connection conn = Conexao.getConexao();
            if (conn != null) {
                System.out.println("Teste de conexão: Está tudo bem!");
            }
        } catch (SQLException e) {
            System.out.println("Não foi possivel estabelecer conexão: "+e.getMessage());
        }
      
    }
}
