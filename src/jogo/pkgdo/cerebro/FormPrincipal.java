/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.pkgdo.cerebro;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JLabel;
import nucleo.Conta;
import nucleo.Cronometro;
import nucleo.PrintTaskPainel;

/**
 *
 * @author RauLuar
 */
public class FormPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipal
     */
    private Conta conta;
    public static boolean respondeu;
    public static JLabel jLabel[];

    public FormPrincipal() {

        initComponents();
        //this.conta=new Conta(1, 50, 5);
        


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelAcerto = new javax.swing.JLabel();
        jLabelComecar = new javax.swing.JLabel();
        jLabelNumero1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelOperacao = new javax.swing.JLabel();
        jTextFieldResultado = new javax.swing.JTextField();
        jLabelErro = new javax.swing.JLabel();
        jLabelPontuacao = new javax.swing.JLabel();
        jLabelNumero2 = new javax.swing.JLabel();
        jLabelTempo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo do Cérebro");
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Histórico");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(890, 10, 390, 60);

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nível");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 10, 370, 60);

        jLabelAcerto.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabelAcerto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAcerto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAcerto.setText("00");
        jPanel1.add(jLabelAcerto);
        jLabelAcerto.setBounds(330, 500, 130, 100);

        jLabelComecar.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabelComecar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelComecar.setText("Começar");
        jLabelComecar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelComecarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelComecar);
        jLabelComecar.setBounds(490, 10, 370, 60);

        jLabelNumero1.setFont(new java.awt.Font("Rockwell", 0, 54)); // NOI18N
        jLabelNumero1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumero1.setText("00");
        jPanel1.add(jLabelNumero1);
        jLabelNumero1.setBounds(480, 460, 150, 90);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/igual.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(710, 480, 160, 60);

        jLabelOperacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/subtracao.png"))); // NOI18N
        jPanel1.add(jLabelOperacao);
        jLabelOperacao.setBounds(610, 480, 50, 60);

        jTextFieldResultado.setEditable(false);
        jTextFieldResultado.setBackground(new java.awt.Color(0, 0, 102));
        jTextFieldResultado.setFont(new java.awt.Font("Rockwell", 0, 54)); // NOI18N
        jTextFieldResultado.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldResultado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldResultadoMouseEntered(evt);
            }
        });
        jTextFieldResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldResultadoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldResultado);
        jTextFieldResultado.setBounds(820, 470, 90, 80);

        jLabelErro.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabelErro.setForeground(new java.awt.Color(255, 255, 255));
        jLabelErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErro.setText("00");
        jPanel1.add(jLabelErro);
        jLabelErro.setBounds(330, 610, 130, 90);

        jLabelPontuacao.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabelPontuacao.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPontuacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPontuacao.setText("00");
        jLabelPontuacao.setName("Pontuacao"); // NOI18N
        jPanel1.add(jLabelPontuacao);
        jLabelPontuacao.setBounds(330, 400, 130, 100);

        jLabelNumero2.setFont(new java.awt.Font("Rockwell", 0, 54)); // NOI18N
        jLabelNumero2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumero2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumero2.setText("00");
        jPanel1.add(jLabelNumero2);
        jLabelNumero2.setBounds(630, 460, 160, 90);

        jLabelTempo.setFont(new java.awt.Font("Rockwell", 0, 54)); // NOI18N
        jLabelTempo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTempo.setText("00:00");
        jPanel1.add(jLabelTempo);
        jLabelTempo.setBounds(500, 580, 420, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Templete4.1.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-90, -10, 1480, 880);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1361, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldResultadoActionPerformed

    private void jTextFieldResultadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldResultadoMouseEntered
        // TODO add your handling code here:
        new Teclado(this, jTextFieldResultado, respondeu).setVisible(true);
        this.respondeu = true;

    }//GEN-LAST:event_jTextFieldResultadoMouseEntered

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        requestFocus();

        new Teclado(this, jTextFieldResultado, respondeu).setVisible(true);
        FormPrincipal.this.respondeu = true;

        //this.conta.proximaConta(jLabel1, jLabel2, jLabel3);

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabelComecarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelComecarMouseClicked
        // TODO add your handling code here:
        ExecutorService executorService;
        executorService = Executors.newCachedThreadPool();
        PrintTaskPainel task = new PrintTaskPainel(jLabelNumero1, jLabelNumero2, jLabelOperacao, jLabelTempo, jTextFieldResultado, respondeu);
        executorService.execute(task); 
        jLabel = new JLabel[3];
        this.jLabel[0] = jLabelPontuacao;
        this.jLabel[1] = jLabelAcerto;
        this.jLabel[2] = jLabelErro; 
    }//GEN-LAST:event_jLabelComecarMouseClicked

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAcerto;
    private javax.swing.JLabel jLabelComecar;
    private javax.swing.JLabel jLabelErro;
    private javax.swing.JLabel jLabelNumero1;
    private javax.swing.JLabel jLabelNumero2;
    private javax.swing.JLabel jLabelOperacao;
    private javax.swing.JLabel jLabelPontuacao;
    private javax.swing.JLabel jLabelTempo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldResultado;
    // End of variables declaration//GEN-END:variables
}