package MantProductos;
import CrudCategoria.FrmListaCategoria;
import CrudFormato.FrmListaFormato;
import CrudMarcas.FrmListaMarcas;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrmGProductos extends javax.swing.JFrame {
    private CtrlProductos controlador;
    
    
    public FrmGProductos() {
        initComponents();
        setLocationRelativeTo(null); 
        setTitle("Mantenimiento de Clientes");        
        controlador= new CtrlProductos(this);
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
        btnProDel = new javax.swing.JButton();
        btnProMod = new javax.swing.JButton();
        btnProAdd = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnCategoria = new javax.swing.JButton();
        btnFormato = new javax.swing.JButton();
        btnMarca = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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
        jLabel1.setText("GESTION DE PRODUCTOS");
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
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 100, 39));

        btnProDel.setBackground(new java.awt.Color(50, 216, 193));
        btnProDel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        btnProDel.setForeground(new java.awt.Color(0, 102, 205));
        btnProDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        btnProDel.setText("Eliminar Producto");
        btnProDel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProDelActionPerformed(evt);
            }
        });
        jPanel1.add(btnProDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 170, 42));

        btnProMod.setBackground(new java.awt.Color(50, 216, 193));
        btnProMod.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        btnProMod.setForeground(new java.awt.Color(0, 102, 205));
        btnProMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit32.png"))); // NOI18N
        btnProMod.setText("Editar Producto");
        btnProMod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProModActionPerformed(evt);
            }
        });
        jPanel1.add(btnProMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 170, 42));

        btnProAdd.setBackground(new java.awt.Color(50, 216, 193));
        btnProAdd.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btnProAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnProAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addL2.png"))); // NOI18N
        btnProAdd.setText("Nuevo Producto");
        btnProAdd.setContentAreaFilled(false);
        btnProAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnProAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 130, 230, 50));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 200, 10));

        btnCategoria.setBackground(new java.awt.Color(50, 216, 193));
        btnCategoria.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btnCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addL2.png"))); // NOI18N
        btnCategoria.setText("Añadir Categoria");
        btnCategoria.setContentAreaFilled(false);
        btnCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCategoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 240, 50));

        btnFormato.setBackground(new java.awt.Color(50, 216, 193));
        btnFormato.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btnFormato.setForeground(new java.awt.Color(255, 255, 255));
        btnFormato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addL2.png"))); // NOI18N
        btnFormato.setText("Añadir Formato");
        btnFormato.setContentAreaFilled(false);
        btnFormato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFormato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormatoActionPerformed(evt);
            }
        });
        jPanel1.add(btnFormato, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 410, 240, 50));

        btnMarca.setBackground(new java.awt.Color(50, 216, 193));
        btnMarca.setFont(new java.awt.Font("Yu Gothic", 1, 16)); // NOI18N
        btnMarca.setForeground(new java.awt.Color(255, 255, 255));
        btnMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/addL2.png"))); // NOI18N
        btnMarca.setText("Añadir Marca");
        btnMarca.setContentAreaFilled(false);
        btnMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMarca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });
        jPanel1.add(btnMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 240, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-760, -30, 1890, 710));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnProModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProModActionPerformed
       
    }//GEN-LAST:event_btnProModActionPerformed
    private void btnProDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProDelActionPerformed
        
    }//GEN-LAST:event_btnProDelActionPerformed
    private void btnProAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProAddActionPerformed

    }//GEN-LAST:event_btnProAddActionPerformed

    private void btnFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormatoActionPerformed
        FrmListaFormato frm = new FrmListaFormato();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFormatoActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        FrmListaCategoria frm = new FrmListaCategoria();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        FrmListaMarcas frm = new FrmListaMarcas();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMarcaActionPerformed
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGProductos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnFormato;
    private javax.swing.JButton btnMarca;
    public javax.swing.JButton btnProAdd;
    public javax.swing.JButton btnProDel;
    public javax.swing.JButton btnProMod;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
