package Inventario;
import Entradas.FrmGEntradas;
import Home.FrmPrincipal;
import MantProductos.QueryProductos;
import Salidas.FrmGSalidas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.usermodel.Range;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/** @author WASM    */
public class FrmGInventario extends javax.swing.JFrame {
    private CtrlInventario controlador;
    
    public FrmGInventario() {
        initComponents();
        setTitle("Mantenimiento de Clientes");        
        controlador= new CtrlInventario(this);
        preTabla();
    }    
    
    
    public void preTabla(){
        QueryInventario  prueba= new QueryInventario();
        ArrayList <ClsInventario> marcas = prueba.marcasArr();
        initTabla(marcas);
    }
    
    public void initTabla(ArrayList <ClsInventario> m){        
        String[] columnNames = {"Nro.","Nombre","Categoria","Marca","Formato","Tipo","Precio S./","Stock"};
        DefaultTableModel modelo = new DefaultTableModel(null,columnNames);       
        tblDatos.setModel(modelo);
        
        for(int  i=0; i<m.size();i++){
            String[] fila={Integer.toString(i+1),m.get(i).getProNom(),m.get(i).getProCatNom(),
                m.get(i).getProMarNom(),m.get(i).getProForNom(),m.get(i).getProTipNom(),
                Double.toString(m.get(i).getProPreVen()),Double.toString(m.get(i).getStock())};
            modelo.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnEntradas = new javax.swing.JButton();
        btnSalidas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        brnKardexE = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MHome = new javax.swing.JMenu();
        MInventario = new javax.swing.JMenu();
        MProductos = new javax.swing.JMenu();
        MBusqueda = new javax.swing.JMenu();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DE INVENTARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        txtBuscar.setForeground(new java.awt.Color(0, 51, 255));
        txtBuscar.setCaretColor(new java.awt.Color(0, 0, 153));
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 635, -1));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 801, 480));

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BUSCAR :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 70, 60, 20));

        btnSalir.setBackground(new java.awt.Color(0, 204, 153));
        btnSalir.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 205));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salir4.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 100, 39));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, 220, 20));

        jTextField1.setText("conbobox bucarcar por categoria");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 190, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 100, -1, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 150, 220, 20));

        btnEntradas.setBackground(new java.awt.Color(50, 216, 193));
        btnEntradas.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnEntradas.setForeground(new java.awt.Color(0, 102, 205));
        btnEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/entrada48.png"))); // NOI18N
        btnEntradas.setText("Entradas");
        btnEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradasActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 180, 50));

        btnSalidas.setBackground(new java.awt.Color(50, 216, 193));
        btnSalidas.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnSalidas.setForeground(new java.awt.Color(0, 102, 205));
        btnSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida48.png"))); // NOI18N
        btnSalidas.setText("Salidas");
        btnSalidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidasActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 180, 50));

        jButton1.setBackground(new java.awt.Color(50, 216, 193));
        jButton1.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 205));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/exportar48.png"))); // NOI18N
        jButton1.setText("Exportar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 310, -1, 100));

        jButton2.setBackground(new java.awt.Color(50, 216, 193));
        jButton2.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 205));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/importar48.png"))); // NOI18N
        jButton2.setText("Importar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 310, -1, 100));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 430, 220, 20));

        brnKardexE.setBackground(new java.awt.Color(50, 216, 193));
        brnKardexE.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        brnKardexE.setForeground(new java.awt.Color(0, 102, 205));
        brnKardexE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/kardexe32.png"))); // NOI18N
        brnKardexE.setText("Kardex Unitario");
        brnKardexE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(brnKardexE, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, 180, 60));

        jButton3.setBackground(new java.awt.Color(50, 216, 193));
        jButton3.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 205));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/kardext48.png"))); // NOI18N
        jButton3.setText("Kardex Total");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 520, 180, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-780, -20, 1930, 710));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 600));

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        MHome.setText("Home");
        MHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MHomeActionPerformed(evt);
            }
        });
        jMenuBar1.add(MHome);

        MInventario.setText("Mi Inventario");
        MInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MInventarioActionPerformed(evt);
            }
        });
        jMenuBar1.add(MInventario);

        MProductos.setText("Mis Productos");
        MProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MProductosActionPerformed(evt);
            }
        });
        jMenuBar1.add(MProductos);

        MBusqueda.setText("Busqueda");
        jMenuBar1.add(MBusqueda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
    
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MHomeActionPerformed
    
    }//GEN-LAST:event_MHomeActionPerformed

    private void MInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MInventarioActionPerformed
        this.dispose();
    }//GEN-LAST:event_MInventarioActionPerformed

    private void MProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MProductosActionPerformed
        FrmGInventario frm = new FrmGInventario();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MProductosActionPerformed

    private void btnEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradasActionPerformed
        FrmGEntradas frm = new FrmGEntradas();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEntradasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidasActionPerformed
        FrmGSalidas frm = new FrmGSalidas();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalidasActionPerformed
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
            java.util.logging.Logger.getLogger(FrmGInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGInventario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MBusqueda;
    private javax.swing.JMenu MHome;
    private javax.swing.JMenu MInventario;
    private javax.swing.JMenu MProductos;
    private javax.swing.JButton brnKardexE;
    private javax.swing.JButton btnEntradas;
    private javax.swing.JButton btnSalidas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
