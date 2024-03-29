/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.CtrlAntecedentes;
import Controlador.CtrlArticulos;
import Controlador.CtrlClientes;
import Controlador.CtrlPersonas;
import Controlador.CtrlTipo;
import Controlador.CtrlTipoEquipo;
import Controlador.CtrlUsuarios;
import Modelo.ClsAntecedentes;
import Modelo.ClsArticulos;
import Modelo.ClsClientes;
import Modelo.ClsManteniento;
import Modelo.ClsPersonas;
import Modelo.ClsTipo;
import Modelo.ClsTipoEquipo;
import Modelo.ClsUsuarios;
import Modelo.QueryAntecedentes;
import Modelo.QueryArticulos;
import Modelo.QueryClientes;
import Modelo.QueryPersonas;
import Modelo.QueryTipo;
import Modelo.QueryTipoEquipos;
import Modelo.QueryUsuarios;

/**
 *
 * @author WasM
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setTitle("Sistema de Control de Mantenimiento Servis Soft - 2019");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnUsuarios = new javax.swing.JMenuItem();
        btnUsuariosTipo = new javax.swing.JMenuItem();
        btnEquiposTipo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setText("SERVISOFT  -  2019");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 441, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SERVISOFT - AREQUIPA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 569, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setText("SISTEMA ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 56, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 0));
        jLabel4.setText("DE CONTROL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 239, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pegasonegro.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 630));

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Maestros");

        btnUsuarios.setText("Usuarios");
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        jMenu2.add(btnUsuarios);

        btnUsuariosTipo.setText("TipoUsuario");
        btnUsuariosTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosTipoActionPerformed(evt);
            }
        });
        jMenu2.add(btnUsuariosTipo);

        btnEquiposTipo.setText("TipoEquipo");
        btnEquiposTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiposTipoActionPerformed(evt);
            }
        });
        jMenu2.add(btnEquiposTipo);

        jMenuItem2.setText("Articulos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem5.setText("Personas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Procesos");

        jMenuItem4.setText("Gestion Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Nosotros");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1078, 686));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        //Salir del Sistema
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        // Damos la Funcionalidad para el Formulario FrmUsuarios
        ClsUsuarios mod = new ClsUsuarios();
        QueryUsuarios modQ = new QueryUsuarios();
        FrmUsuarios frm = new FrmUsuarios();
        CtrlUsuarios ctrl = new CtrlUsuarios(mod,modQ,frm);
        ctrl.iniciar();
        frm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnUsuariosTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosTipoActionPerformed
        // TODO add your handling code here:
        ClsTipo mod = new ClsTipo();
        QueryTipo modQ = new QueryTipo();
        FrmTipos frm = new FrmTipos();
        CtrlTipo ctrl = new CtrlTipo(mod,modQ,frm);
        ctrl.iniciar();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUsuariosTipoActionPerformed

    private void btnEquiposTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiposTipoActionPerformed
       // TODO add your handling code here:
        ClsTipoEquipo mod = new ClsTipoEquipo();
        QueryTipoEquipos modQ = new QueryTipoEquipos();
        FrmTiposEquipo frm = new FrmTiposEquipo();
        CtrlTipoEquipo ctrl = new CtrlTipoEquipo(mod,modQ,frm);
        ctrl.iniciar();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEquiposTipoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         // TODO add your handling code here:
        // Damos la Funcionalidad para el Formulario FrmUsuarios
        ClsArticulos mod = new ClsArticulos();
        QueryArticulos modQ = new QueryArticulos();
        FrmArticulos frm = new FrmArticulos();
        CtrlArticulos ctrl = new CtrlArticulos(mod,modQ,frm);
        ctrl.iniciar();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        ClsPersonas mod = new ClsPersonas();
        QueryPersonas modQ = new QueryPersonas();
        FrmPersonas frm = new FrmPersonas();
        CtrlPersonas ctrl = new CtrlPersonas(mod,modQ,frm);
        ctrl.iniciar();
        frm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        FrmMantClientes frm = new FrmMantClientes();
        frm.setVisible(true);
        this.dispose();



    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnEquiposTipo;
    private javax.swing.JMenuItem btnUsuarios;
    private javax.swing.JMenuItem btnUsuariosTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}
