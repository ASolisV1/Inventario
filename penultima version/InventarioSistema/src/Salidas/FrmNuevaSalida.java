package Salidas;

import MantProductos.ClsProductos;
import MantProductos.QueryProductos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrmNuevaSalida extends javax.swing.JFrame {

    QuerySalidas query= new QuerySalidas();
    QueryProductos queryP = new QueryProductos();
    FrmGSalidas padre;
    
    
    public FrmNuevaSalida() {
        initComponents();
        preTabla();
    }
    
    public FrmNuevaSalida(FrmGSalidas _padre) {
        padre=_padre;
        initComponents();
        preTabla();
    }
    
    public void preTabla(){
        QueryProductos  prueba= new QueryProductos();
        ArrayList <ClsProductos> marcas = prueba.marcasArr();
        initTabla(marcas);
    }
    
    public void initTabla(ArrayList <ClsProductos> m){        
        String[] columnNames = {"Nro.","Codigo","Nombre","Categoria","Marca","Formato","Tipo","Precio S./"};
        DefaultTableModel modelo = new DefaultTableModel(null,columnNames);       
        tblDatos.setModel(modelo);
        
        for(int  i=0; i<m.size();i++){
            String[] fila={Integer.toString(i+1),Integer.toString(m.get(i).getProCod()),m.get(i).getProNom()
                    ,m.get(i).getProCatNom2(),m.get(i).getProMarNom2(),m.get(i).getProForNom2(),m.get(i).getProTipNom2()
                    ,Double.toString(m.get(i).getProPreVen())};
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
        txtId = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        nomdoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NUEVA SALIDA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));

        btnCancelar.setBackground(new java.awt.Color(50, 216, 193));
        btnCancelar.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 102, 205));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 480, 130, 40));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CANTIDAD:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 140, 70, -1));

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        getContentPane().add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 160, 80, -1));

        btnGuardar.setBackground(new java.awt.Color(50, 216, 193));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 102, 205));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 420, 130, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 801, 480));

        nomdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomdocActionPerformed(evt);
            }
        });
        getContentPane().add(nomdoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 190, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Agregar  caledario");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 210, 130, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NOMBRE DOCUMENTO:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 150, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-800, -10, 1860, 590));

        setSize(new java.awt.Dimension(1068, 613));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void nomdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomdocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomdocActionPerformed

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNuevaSalida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JTextField cantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField nomdoc;
    public javax.swing.JTable tblDatos;
    public javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
