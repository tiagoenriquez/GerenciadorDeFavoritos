/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * Contem métodos compartilhados por mais diversas telas.
 *
 * @author Tiago Enriquez Tachy
 */
public class Global {
    
    /**
     * Insere o logotipo na barra de título.
     * 
     * @param frame
     * @throws Exception 
     */
    public void logo(JFrame frame) throws Exception {
        try {
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("favorito.png")));
        } catch (Exception e) {
            throw new Exception("Erro na inserção do logotipo na barra de título");
        }
    }
    
}
