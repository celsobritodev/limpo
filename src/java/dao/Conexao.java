/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/dbconsole";
    public static final String USER_LOGIN = "root";
    public static final String USER_PASSWD = "admin";
    public static Connection conn = null;

    public static Connection getConexao() throws SQLException {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(URL, USER_LOGIN, USER_PASSWD);
                System.out.println("Conexão efetuada com sucesso");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver não encontrado");
            }
        }
        return conn;
    }

    public static void closeConexao() throws SQLException {
        if (conn != null) {
            conn.close();
            conn=null;
        }
    }
}
