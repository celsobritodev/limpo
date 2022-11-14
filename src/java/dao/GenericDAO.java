/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//T = classe, I = tipo
public abstract class GenericDAO<T, I extends Serializable> {

    protected GenericDAO() {
        Connection emf;
        try {
            emf = Conexao.getConexao();

        } catch (Exception ex) {
            Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger("Não foi possível realizar a conexão com a unidade de persistência. Verifique a conexão");

        }

    }

    public Boolean incluir(T obj) {
        Boolean retorno;
        try {

            retorno = true;
        } catch (RuntimeException e) {

            retorno = false;
            throw e;
        } finally {
            //em.close();

        }
        return retorno;
    }

    public Boolean alterar(T obj) {
        Boolean retorno;
        try {

            retorno = true;
        } catch (RuntimeException e) {

            retorno = false;
            throw e;
        } finally {
            // em.close();
        }
        return retorno;
    }

    public Boolean excluir(I chaveprimaria) {
        Boolean retorno;
        try {

            retorno = true;
        } catch (RuntimeException e) {
            //em.getTransaction().rollback();
            retorno = false;
        } finally {
            //em.close();
        }
        return retorno;
    }

    public Boolean excluir(T obj) {
        Boolean retorno;
        try {

            retorno = true;
        } catch (RuntimeException e) {

            retorno = false;
        } finally {
            //em.close();
        }
        return retorno;
    }

    public List<T> listar() {
        return null;
    }

    public List<T> listar(String filtro) throws Exception {
        return null;
    }

    public T buscarPorChavePrimaria(I chaveprimaria) {
        return null;
    }

    public void fecharEmf() throws SQLException {
        Conexao.closeConexao();
    }

}
