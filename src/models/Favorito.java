/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Tiago Enriquez Tachy
 */
public class Favorito {
    
    private int id;
    private String nome;
    private String url;
    private String assunto;

    /**
     * Inicializa um favorito sem a informação de id.
     * @param nome
     * @param url
     * @param assunto 
     */
    public Favorito(String nome, String url, String assunto) {
        this.nome = nome;
        this.url = url;
        this.assunto = assunto;
    }

    /**
     * Inicializa um favorito com todos os seus atributos.
     * @param id
     * @param nome
     * @param url
     * @param assunto 
     */
    public Favorito(int id, String nome, String url, String assunto) {
        this.id = id;
        this.nome = nome;
        this.url = url;
        this.assunto = assunto;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    public String getAssunto() {
        return assunto;
    }
    
}
