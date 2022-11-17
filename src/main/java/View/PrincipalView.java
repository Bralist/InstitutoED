/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.ImageIcon;

/**
 *
 * @author Jesus Joaquin
 */
public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public PrincipalView() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/img/hospital32.png")).getImage());        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnExit = new javax.swing.JMenuItem();
        btnBusquedas = new javax.swing.JMenu();
        btnEstadisticas = new javax.swing.JMenu();
        jmUsuario = new javax.swing.JMenu();
        btnCerrarSession = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/banner2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/settings64.png"))); // NOI18N
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnExit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close32.png"))); // NOI18N
        btnExit.setText("Cerrar aplicación");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jMenu1.add(btnExit);

        jMenuBar1.add(jMenu1);

        btnBusquedas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busquedas64.png"))); // NOI18N
        btnBusquedas.setText("Búsquedas");
        btnBusquedas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBusquedas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusquedasMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnBusquedas);

        btnEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estadisticas64.png"))); // NOI18N
        btnEstadisticas.setText("Estadísticas");
        btnEstadisticas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEstadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadisticasMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnEstadisticas);

        jmUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/avatar64.png"))); // NOI18N
        jmUsuario.setText("Usuario");
        jmUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(jmUsuario);

        btnCerrarSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit48.png"))); // NOI18N
        btnCerrarSession.setText("Cerrar sesión");
        btnCerrarSession.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCerrarSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSessionMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnCerrarSession);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBusquedasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedasMouseClicked
        BusquedasView view = new BusquedasView();
        view.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnBusquedasMouseClicked

    private void btnCerrarSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSessionMouseClicked
        LoginView view = new LoginView();
        view.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCerrarSessionMouseClicked

    private void btnEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadisticasMouseClicked
        EstadisticasView view = new EstadisticasView(this,true);
        view.setVisible(true);
    }//GEN-LAST:event_btnEstadisticasMouseClicked

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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnBusquedas;
    private javax.swing.JMenu btnCerrarSession;
    private javax.swing.JMenu btnEstadisticas;
    private javax.swing.JMenuItem btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmUsuario;
    // End of variables declaration//GEN-END:variables
}
