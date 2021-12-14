/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.FavoritoDao;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import models.Favorito;

/**
 *
 * @author Tiago Enriquez Tachy
 */
public class FavoritoService {

    /**
     * Salva um novo favorito.
     *
     * @param favorito
     * @throws Exception
     */
    public void inserir(Favorito favorito) throws Exception {
        try {
            new FavoritoDao().inserir(favorito);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
    
    /**
     * Salva as alterações dos dados de um favorito.
     * @param favorito
     * @throws Exception 
     */
    public void alterar(Favorito favorito) throws Exception {
        try {
            new FavoritoDao().alterar(favorito);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
     
    /**
     * Salva a alteração de um assunto.
     * @param assuntoAntigo
     * @param assuntoNovo
     * @throws Exception 
     */
    public void alterarAssunto(String assuntoAntigo, String assuntoNovo) throws Exception {
        try {
            new FavoritoDao().alterarAssunto(assuntoAntigo, assuntoNovo);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
    
    /**
     * Remove um favorito do banco de dados.
     * @param id
     * @throws Exception 
     */
    public void deletar(int id) throws Exception {
        try {
            new FavoritoDao().deletar(id);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
    
    /**
     * Remove um assunto do banco de dados.
     * @param assunto
     * @throws Exception 
     */
    public void deletarAssunto(String assunto) throws Exception {
        try {
            new FavoritoDao().deletarAssunto(assunto);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    /**
     * Retorna a lista de favoritos de determinado assunto.
     *
     * @param assunto
     * @return
     * @throws java.lang.Exception
     */
    public List<Favorito> favoritos(String assunto) throws Exception {
        try {
            if (!assunto.equals("")) {
                return new FavoritoDao().favoritos(assunto);
            } else {
                return null;
            }
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    /**
     * Retorna a lista de assuntos.
     *
     * @return
     * @throws java.lang.Exception
     */
    public List<String> assuntos() throws Exception {
        try {
            return new FavoritoDao().assuntos();
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
    
    /**
     * Abre o site.
     * @param site
     * @throws Exception 
     */
    public void abrirSite(String site) throws Exception {
        try {
            Desktop.getDesktop().browse(new URI(site.replace(" ", "%20")));
        } catch (URISyntaxException uRISyntaxException) {
            throw new Exception("Endereço não existe\n" + uRISyntaxException);
        } catch (IOException iOException) {
            throw new Exception("Não foi possível abrir o site\n" + iOException);
        }
    }
    
    /**
     * Faz pesquisa no google.
     * @param pesquisa
     * @throws Exception 
     */
    public void pesquisarGoogle(String pesquisa) throws Exception {
        try {
            abrirSite("http://www.google.com.br/search?q=" + pesquisa);
        } catch (Exception ex) {
            throw new Exception("Erro ao tentar fazer a pesquisa no google\n" + ex);
        }
    }
    
    /**
     * Faz pesquisa no Youtube.
     * @param pesquisa
     * @throws Exception 
     */
    public void pesquisarYoutube(String pesquisa) throws Exception {
        try {
            abrirSite("http://www.youtube.com/results?search_query=" + pesquisa);
        } catch (Exception ex) {
            throw new Exception("Erro ao tentar fazer a pesquisa no youtube\n" + ex);
        }
    }
    
    /**
     * Pesquisa no google conteúdo em outros sites.
     * @param pesquisa
     * @param urlFavorito
     * @throws Exception 
     */
    public void pesquisar(String pesquisa, String urlFavorito) throws Exception {
        try {
            pesquisa = "%22" + pesquisa + "%22" + " site:" + urlFavorito;
            pesquisarGoogle(pesquisa);
        } catch (Exception ex) {
            throw new Exception("Erro ao tentar fazer a pesquisa no google\n" + ex);
        }
    } 

}
