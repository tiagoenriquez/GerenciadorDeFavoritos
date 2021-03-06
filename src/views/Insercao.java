/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import shared.Global;
import java.util.List;
import models.Favorito;
import services.FavoritoService;

/**
 *
 * @author Tiago Enriquez Tachy
 */
public class Insercao extends javax.swing.JFrame {

    private Principal principal = new Principal();
    private FavoritoService favoritoService;

    /**
     * Inicializa a janela de inserção passando a tela principal como parâmetro.
     *
     * @param principal
     */
    public Insercao(Principal principal) {
        initComponents();
        this.logo();
        setLocationRelativeTo(this);
        this.principal = principal;
        favoritoService = new FavoritoService();
        preencherAssuntos();
    }

    /**
     * Creates new form Insercao
     */
    public Insercao() {
        initComponents();
    }

    /**
     * Preenche o combo box com os assuntos dos favoritos.
     */
    private void preencherAssuntos() {
        try {
            comboBoxAssuntos.addItem("-");
            comboBoxAssuntos.setSelectedIndex(0);
            int tamanho = comboBoxAssuntos.getItemCount();
            for (int i = 1; i < tamanho; i++) comboBoxAssuntos.removeItemAt(1);
            List<String> assuntos = favoritoService.assuntos();
            assuntos.forEach((assunto) -> comboBoxAssuntos.addItem(assunto));
        } catch (Exception exception) {
            new Erro(exception.getMessage()).setVisible(true);
        }
    }

    /**
     * Limpa os campos de digitação.
     */
    private void limparCampos() {
        textFieldNome.setText("");
        textFieldUrl.setText("");
        textFieldAssunto.setText("");
    }
    
    /**
     * Fecha esta janela informando para a tela principal que esta está sendo fechada.
     */
    private void fechar() {
        principal.fecharInsercao();
        this.dispose();
    }
    
    /**
     * Mostra logotipo.
     */
    private void logo() {
        try {
            new Global().logo(this);
        } catch (Exception exception) {
            new Erro("Erro ao mostrar o logotipo").setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        textFieldUrl = new javax.swing.JTextField();
        textFieldAssunto = new javax.swing.JTextField();
        comboBoxAssuntos = new javax.swing.JComboBox<>();
        buttonInserir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserção de Favorito");
        setPreferredSize(new java.awt.Dimension(430, 320));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                fechar(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Nome");
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 30));

        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("URL");
        jLabel2.setPreferredSize(new java.awt.Dimension(50, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Assunto");
        jLabel3.setPreferredSize(new java.awt.Dimension(50, 30));

        textFieldNome.setPreferredSize(new java.awt.Dimension(300, 30));

        textFieldUrl.setPreferredSize(new java.awt.Dimension(300, 30));

        textFieldAssunto.setPreferredSize(new java.awt.Dimension(300, 30));

        comboBoxAssuntos.setPreferredSize(new java.awt.Dimension(300, 30));
        comboBoxAssuntos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                escolherAssunto(evt);
            }
        });

        buttonInserir.setBackground(new java.awt.Color(0, 0, 0));
        buttonInserir.setForeground(new java.awt.Color(255, 255, 0));
        buttonInserir.setText("Inserir");
        buttonInserir.setPreferredSize(new java.awt.Dimension(70, 30));
        buttonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserir(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxAssuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buttonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(comboBoxAssuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(buttonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        desktopPane.add(jPanel1);
        jPanel1.setBounds(0, 0, 420, 280);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Informa a tela principal que esta tela está sendo fechada.
     *
     * @param evt
     */
    private void fechar(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fechar
        fechar();
    }//GEN-LAST:event_fechar

    /**
     * Insere no campo de digitação do assunto o escolhido no combo box.
     *
     * @param evt
     */
    private void escolherAssunto(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_escolherAssunto
        String assunto = comboBoxAssuntos.getSelectedItem().toString();
        textFieldAssunto.setText(assunto);
    }//GEN-LAST:event_escolherAssunto

    /**
     * Salva as informações de um novo favorito.
     *
     * @param evt
     */
    private void inserir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserir
        try {
            String nome = textFieldNome.getText();
            String url = textFieldUrl.getText();
            String assunto = textFieldAssunto.getText();
            favoritoService.inserir(new Favorito(nome, url, assunto));
            limparCampos();
            preencherAssuntos();
            principal.preencherListas();
            new Sucesso("Favorito incluído com sucesso").setVisible(true);
        } catch (Exception exception) {
            new Erro(exception.getMessage()).setVisible(true);
        }
    }//GEN-LAST:event_inserir

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Insercao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insercao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insercao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insercao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insercao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInserir;
    private javax.swing.JComboBox<String> comboBoxAssuntos;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textFieldAssunto;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldUrl;
    // End of variables declaration//GEN-END:variables

}
