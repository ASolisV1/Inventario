package CrudMarcas;
//import Modelo.ClsTipoTrabajador;

import MantProductos.FrmGProductos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


// importamos la variable con el id del cliente
public class FrmListaMarcas extends javax.swing.JFrame {
    
    private CtrlMarcas controlador;

    public FrmListaMarcas() {
        initComponents();
        controlador=new CtrlMarcas(this);
        preTabla();
    }
    
    public void preTabla(){
        QueryMarcas  prueba= new QueryMarcas();
        ArrayList <ClsMarcas> marcas = prueba.marcasArr();
        initTabla(marcas);
    }
    
    public void initTabla(ArrayList <ClsMarcas> m){        
        String[] columnNames = {"Nro.","Codigo","Nombre de la marca",};
        DefaultTableModel modelo = new DefaultTableModel(null,columnNames);       
        jTable1.setModel(modelo);
        
        for(int  i=0; i<m.size();i++){
            String[] fila={Integer.toString(i+1),Integer.toString(m.get(i).getCodMarca()),m.get(i).getNomMarca()};
            modelo.addRow(fila);
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

        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        btnMarcasAdd = new javax.swing.JButton();
        btnMarcasMod = new javax.swing.JButton();
        btnMarcasDel = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MARCAS - PRODUCTOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        btnSalir.setText("Buscar");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("BUSCAR:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 60, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 600, 310));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 60, -1));

        btnMarcasAdd.setBackground(new java.awt.Color(0, 204, 153));
        btnMarcasAdd.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnMarcasAdd.setForeground(new java.awt.Color(0, 101, 205));
        btnMarcasAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add32.png"))); // NOI18N
        btnMarcasAdd.setText("Añadir nueva...");
        btnMarcasAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarcasAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcasAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnMarcasAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, -1, -1));

        btnMarcasMod.setBackground(new java.awt.Color(0, 204, 153));
        btnMarcasMod.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnMarcasMod.setForeground(new java.awt.Color(0, 101, 205));
        btnMarcasMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit32.png"))); // NOI18N
        btnMarcasMod.setText("Modificar");
        btnMarcasMod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarcasMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcasModActionPerformed(evt);
            }
        });
        getContentPane().add(btnMarcasMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 190, 150, -1));

        btnMarcasDel.setBackground(new java.awt.Color(0, 204, 153));
        btnMarcasDel.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnMarcasDel.setForeground(new java.awt.Color(0, 101, 205));
        btnMarcasDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnMarcasDel.setText("Eliminar");
        btnMarcasDel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarcasDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcasDelActionPerformed(evt);
            }
        });
        getContentPane().add(btnMarcasDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 150, -1));

        btnSalir1.setBackground(new java.awt.Color(0, 204, 153));
        btnSalir1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnSalir1.setForeground(new java.awt.Color(0, 101, 205));
        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir4.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 470, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1000, -290, -1, 1200));

        setSize(new java.awt.Dimension(823, 465));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    //Actualizar
    private void btnMarcasModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcasModActionPerformed
    
    }//GEN-LAST:event_btnMarcasModActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        FrmGProductos frm = new FrmGProductos();
        frm.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    //Metodooo para añadir
    private void btnMarcasAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcasAddActionPerformed

    }//GEN-LAST:event_btnMarcasAddActionPerformed

    
    //Eliminar
    private void btnMarcasDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcasDelActionPerformed
     
    }//GEN-LAST:event_btnMarcasDelActionPerformed
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
            java.util.logging.Logger.getLogger(FrmListaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmListaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmListaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmListaMarcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmListaMarcas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnMarcasAdd;
    public javax.swing.JButton btnMarcasDel;
    public javax.swing.JButton btnMarcasMod;
    public javax.swing.JButton btnSalir;
    public javax.swing.JButton btnSalir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}