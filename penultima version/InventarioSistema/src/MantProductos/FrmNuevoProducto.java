package MantProductos;

import Objetos.FrmObjetos;
import javax.swing.DefaultComboBoxModel;

public class FrmNuevoProducto extends javax.swing.JFrame {

    QueryProductos query= new QueryProductos();
    FrmGProductos padre;
    
    
    public FrmNuevoProducto() {
        initComponents();
        cargarCombos();
    }
    
    public FrmNuevoProducto(FrmGProductos _padre) {
        padre=_padre;
        initComponents();
        cargarCombos();
    }
    
    public void cargarCombos(){
        String [] catNom=query.getCatQ().arrString();
        String [] marNom=query.getMarQ().arrString();
        String [] forNom=query.getForQ().arrString();
        String [] tipNom=query.getTipQ().arrString();
        
        DefaultComboBoxModel mod = new DefaultComboBoxModel(marNom);
        jCBProMar.setModel(mod);
        mod = new DefaultComboBoxModel(forNom);
        jCBProFor.setModel(mod);
        mod = new DefaultComboBoxModel(tipNom);
        jCBProTipo.setModel(mod);
        mod = new DefaultComboBoxModel(catNom);
        jCBProCat.setModel(mod);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAddProducto = new javax.swing.JButton();
        boxNombre = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        btnNuevoAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jCBProMar = new javax.swing.JComboBox();
        jCBProTipo = new javax.swing.JComboBox();
        jCBProFor = new javax.swing.JComboBox();
        jCBProCat = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jTFArtPre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jFCodPro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NUEVO PRODUCTO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MARCA:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 90, 20));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, -1));

        btnCancelar.setBackground(new java.awt.Color(50, 216, 193));
        btnCancelar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 102, 205));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 130, 40));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PRECIO S/.:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic Light", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FORMATO:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, 20));

        btnAddProducto.setBackground(new java.awt.Color(50, 216, 193));
        btnAddProducto.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnAddProducto.setForeground(new java.awt.Color(0, 102, 205));
        btnAddProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add48.png"))); // NOI18N
        btnAddProducto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAddProducto.setContentAreaFilled(false);
        btnAddProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddProducto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add32.png"))); // NOI18N
        btnAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 50, 50));

        boxNombre.setEditable(true);
        boxNombre.setForeground(new java.awt.Color(0, 51, 255));
        boxNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        boxNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                boxNombreFocusLost(evt);
            }
        });
        boxNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNombreActionPerformed(evt);
            }
        });
        boxNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                boxNombreKeyTyped(evt);
            }
        });
        getContentPane().add(boxNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 420, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TIPO:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 90, -1));

        btnNuevoAdd.setBackground(new java.awt.Color(50, 216, 193));
        btnNuevoAdd.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnNuevoAdd.setForeground(new java.awt.Color(0, 102, 205));
        btnNuevoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnNuevoAdd.setText("Guardar");
        btnNuevoAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 130, 40));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CATEGORIA:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        jCBProMar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCBProMar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 240, 20));

        jCBProTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCBProTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 240, 20));

        jCBProFor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCBProFor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 240, 20));

        jCBProCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCBProCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 240, 20));

        jLabel8.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("COD. PRO. :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, 20));
        getContentPane().add(jTFArtPre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 150, 20));

        jLabel9.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NOMBRE:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 60, 20));

        jFCodPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFCodProActionPerformed(evt);
            }
        });
        getContentPane().add(jFCodPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 100, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1010, -220, 1700, 600));

        setSize(new java.awt.Dimension(662, 391));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        FrmGProductos frm = new FrmGProductos();
        frm.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoAddActionPerformed

    private void btnAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductoActionPerformed
        FrmObjetos frm = new FrmObjetos();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAddProductoActionPerformed

    private void boxNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_boxNombreKeyTyped

    private void boxNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxNombreActionPerformed

    private void boxNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_boxNombreFocusLost
        // TODO add your handling code here:
        //         JOptionPane.showMessageDialog(null,"texto a buscar  "+boxNombre.getSelectedItem().toString());
        //        buscar(boxNombre.getSelectedItem().toString());
    }//GEN-LAST:event_boxNombreFocusLost

    private void jFCodProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFCodProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFCodProActionPerformed
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
            java.util.logging.Logger.getLogger(FrmNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNuevoProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> boxNombre;
    public javax.swing.JButton btnAddProducto;
    public javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnNuevoAdd;
    public javax.swing.JComboBox jCBProCat;
    public javax.swing.JComboBox jCBProFor;
    public javax.swing.JComboBox jCBProMar;
    public javax.swing.JComboBox jCBProTipo;
    public javax.swing.JTextField jFCodPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField jTFArtPre;
    public javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
