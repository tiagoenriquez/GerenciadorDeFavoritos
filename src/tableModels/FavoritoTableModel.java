/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Favorito;

/**
 *
 * @author Tiago Enriquez Tachy
 */
public class FavoritoTableModel extends AbstractTableModel{
    
    private List<Favorito> favoritos;

    public void setFavoritos(List<Favorito> favoritos) {
        this.favoritos = favoritos;
    }
    
    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "Nome";
            case 1:
                return "URL";
            default:
                return null;
        }
    }

    @Override
    public int getRowCount() {
        if (favoritos != null) {
            return favoritos.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int linhas, int colunas) {
        if (favoritos != null && linhas >= 0 && linhas < favoritos.size()) {
            Favorito favorito = favoritos.get(linhas);
            switch (colunas) {
                case 0:
                    return favorito.getNome();
                case 1:
                    return favorito.getUrl();
                case 2:
                    return favorito.getId();
            }
        }
        return null;
    }
    
}
