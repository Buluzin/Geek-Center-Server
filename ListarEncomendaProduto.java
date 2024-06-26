/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.visao;

import br.com.controle.Encomenda_Produto;
import br.com.entidade.ManterEncomenda_Produto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bruno
 */
public class ListarEncomendaProduto extends javax.swing.JFrame {

    /**
     * Creates new form ListarEncomendaProduto
     */
    public ListarEncomendaProduto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTctdr = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTcpf = new javax.swing.JTextField();
        jBlistar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTctdr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Produto_id"
            }
        ));
        jScrollPane1.setViewportView(jTctdr);

        jLabel1.setText("Digite o Codigo:");

        jBlistar.setText("Pesquisar");
        jBlistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlistarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jBlistar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(jTcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBlistar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBlistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlistarActionPerformed
        // TODO add your handling code here:
        try {
            Encomenda_Produto encProduto = new Encomenda_Produto();
            ManterEncomenda_Produto manterEncomendaProduto = new ManterEncomenda_Produto();

            DefaultTableModel modeloTabela = (DefaultTableModel) jTctdr.getModel();
            modeloTabela.setRowCount(0);

            if (jTcpf.getText().isEmpty()) {
            ArrayList<Encomenda_Produto> encomendasProduto = manterEncomendaProduto.PesquisarTudo();

            encomendasProduto.forEach((e) -> {
                modeloTabela.addRow(new Object[]{e.getCodigo(), e.getProduto_id()});
            });
        } else {
            encProduto.setCodigo(jTcpf.getText());
            manterEncomendaProduto.PesquisarRegistro(encProduto);

            if (encProduto.getCodigo() != null) {
                modeloTabela.addRow(new Object[]{encProduto.getCodigo(), encProduto.getProduto_id()});
            } else {
                System.out.println("Encomenda de produto não encontrada.");
            }
        }

            jTcpf.setText(null);
            jTcpf.requestFocus();
        }
        catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
        }
    }//GEN-LAST:event_jBlistarActionPerformed

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
            java.util.logging.Logger.getLogger(ListarEncomendaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarEncomendaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarEncomendaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarEncomendaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarEncomendaProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBlistar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTcpf;
    private javax.swing.JTable jTctdr;
    // End of variables declaration//GEN-END:variables
}
