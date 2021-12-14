/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Favorito;
import util.Conexao;

/**
 *
 * @author Tiago Enriquez Tachy
 */
public class FavoritoDao {
    
    Connection conexao;
    private final String TABELA = "favoritos";
    private final String ID = "id";
    private final String NOME = "nome";
    private final String URL = "url";
    private final String ASSUNTO = "assunto";
    
    /**
     * Inicializa a conexão com o banco de dados.
     * @throws java.lang.Exception
     */
    public FavoritoDao()throws Exception {
        try {
            this.conexao = Conexao.getConnection();
        } catch(Exception e) {
            throw new Exception("Erro: " + e.getMessage());
        }
    }
    
    /**
     * Insere um favorito no banco de dados.
     * @param favorito
     * @throws java.lang.Exception
     */
    public void inserir(Favorito favorito) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = this.conexao;
            String query = "insert into " + TABELA + "(" + NOME + ", " + URL + ", " + ASSUNTO + ") values (?, ?, ?)";
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, favorito.getNome());
            preparedStatement.setString(2, favorito.getUrl());
            preparedStatement.setString(3, favorito.getAssunto());
            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            throw new Exception("Erro ao inserir o favorito no banco de dados.\n" + sQLException);
        } finally {
            Conexao.closeConnection(conexao, preparedStatement);
        }
    }
    
    /**
     * Atualiza ou corrige os dados de um favorito no banco de dados.
     * @param favorito
     * @throws java.lang.Exception
     */
    public void alterar(Favorito favorito) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = this.conexao;
            String query = "update " + TABELA + " set " + NOME + " = ?, " + URL + " = ?, " + ASSUNTO + " = ? where " + ID + " = ?";
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, favorito.getNome());
            preparedStatement.setString(2, favorito.getUrl());
            preparedStatement.setString(3, favorito.getAssunto());
            preparedStatement.setInt(4, favorito.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            throw new Exception("Erro ao atualiza os dados do favorito no banco de dados.\n" + sQLException);
        } finally {
            Conexao.closeConnection(conexao, preparedStatement);
        }
    }
    
    /**
     * Altera o nome de um assunto no banco de dados.
     * @param assuntoAntigo
     * @param assuntoNovo
     * @throws Exception 
     */
    public void alterarAssunto(String assuntoAntigo, String assuntoNovo) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = this.conexao;
            String query = "update " + TABELA + " set " + ASSUNTO + " = ? where " + ASSUNTO + " = ?";
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, assuntoNovo);
            preparedStatement.setString(2, assuntoAntigo);
            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            throw new Exception("Erro ao alterar o assunto.\n" + sQLException);
        } finally {
            Conexao.closeConnection(conexao, preparedStatement);
        }
    }
    
    /**
     * Remove um favorito do banco de dados.
     * @param id
     * @throws Exception 
     */
    public void deletar(int id) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = this.conexao;
            String query = "delete from " + TABELA + " where " + ID + " = ?";
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            throw new Exception("Erro na remoção do favorito.\n" + sQLException);
        } finally {
            Conexao.closeConnection(conexao, preparedStatement);
        }
    }
    
    /**
     * Remove todos os favoritos de determinado assunto do banco de dados.
     * @param assunto
     * @throws Exception 
     */
    public void deletarAssunto(String assunto) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        try {
            conexao = this.conexao;
            String query = "delete from " + TABELA + " where " + ASSUNTO + " = ?";
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, assunto);
            preparedStatement.executeUpdate();
        } catch (SQLException sQLException) {
            throw new Exception("Erro na remoção do assunto.\n" + sQLException);
        } finally {
            Conexao.closeConnection(conexao, preparedStatement);
        }
    }
    
    /**
     * Busca no banco de dados os favoritos de determinado assunto em ordem alfabética.
     * @param assunto
     * @return 
     * @throws java.lang.Exception 
     */
    public List<Favorito> favoritos(String assunto) throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conexao = this.conexao;
            String query = "select * from " + TABELA + " where " + ASSUNTO + " = ?";
            preparedStatement = conexao.prepareStatement(query);
            preparedStatement.setString(1, assunto);
            resultSet = preparedStatement.executeQuery();
            List<Favorito> lista = new ArrayList<>();
            while (resultSet.next()) {
                lista.add(new Favorito(
                        resultSet.getInt(ID),
                        resultSet.getString(NOME),
                        resultSet.getString(URL),
                        resultSet.getString(ASSUNTO)
                ));
            }
            return lista;
        } catch (SQLException sQLException) {
            throw new Exception("Erro na listagem dos favoritos.\n" + sQLException);
        } finally {
            Conexao.closeConnection(conexao, preparedStatement, resultSet);
        }
    }
    
    /**
     * Busca no banco de dados os assuntos em ordem alfabética.
     * @return 
     * @throws java.lang.Exception
     */
    public List<String> assuntos() throws Exception {
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conexao = this.conexao;
            String query = "select distinct " + ASSUNTO + " from " + TABELA + " order by " + ASSUNTO + " asc";
            preparedStatement = conexao.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            List<String> lista = new ArrayList<>();
            while (resultSet.next()) {
                lista.add(resultSet.getString(ASSUNTO));
            }
            return lista;
        } catch (SQLException sQLException) {
            throw new Exception("Erro na listagem dos assuntos.\n" + sQLException);
        } finally {
            Conexao.closeConnection(conexao, preparedStatement, resultSet);
        }
    }
    
}
