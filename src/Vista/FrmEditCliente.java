package Vista;
import Controlador.CtrlEquipos;
import Modelo.ClsClientes;
import Modelo.ClsEquipos;
//import Modelo.ClsTipoTrabajador;
import Modelo.QueryClientes;
import Modelo.QueryEquipos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;
// importamos la variable con el id del cliente
import static Vista.FrmMantClientes.numIdCliente;
public class FrmEditCliente extends javax.swing.JFrame {
    /**
     * Creates new form FrmUsuarios
     */

    public FrmEditCliente() {
        initComponents();
        txtId.setText(String.valueOf(numIdCliente));
        ClsClientes cliente = new ClsClientes();
        QueryClientes mod = new QueryClientes();
        cliente=mod.devuelveCliente(numIdCliente);
        String nombreCompleto =null;
        txtDireccion.setText(cliente.getClientedir());
        txtTelefono.setText(cliente.getClientetel());
        txtCorreo.setText(cliente.getClientecorr());
        txtClienteCod.setText(String.valueOf(cliente.getClientecod()));
        nombreCompleto=mod.devuelveNombreCliente(numIdCliente);
        boxNombre.getEditor().setItem(nombreCompleto);
        boxNombre.setEnabled(false);
        cargar("");
    }
        public void cargar(String valor) {
        QueryClientes modelo;
        modelo = new QueryClientes();
        tblContenido.setModel(modelo.listarEquipos(numIdCliente)); 
        tblContenido.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblContenido.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblContenido.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblContenido.getColumnModel().getColumn(3).setPreferredWidth(150);
        tblContenido.getColumnModel().getColumn(4).setPreferredWidth(50);        
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnDetEditar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        boxNombre = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtClienteCod = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContenido = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnDetNuevo = new javax.swing.JButton();
        btnDetEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtDetId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel1.setText("Mantenimiento de Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jLabel4.setText("CODIGO  : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 90, 20));

        jLabel5.setText("CORREO ELECTRONICO : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 160, 20));

        btnDetEditar.setText("Modificar");
        getContentPane().add(btnDetEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, 80, 30));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 50, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, 80, 80));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setText("APELLIDOS Y NOMBRES : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 160, -1));

        jLabel10.setText("TELEFONO : ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 90, 20));

        boxNombre.setEditable(true);
        boxNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                boxNombreFocusLost(evt);
            }
        });
        boxNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                boxNombreKeyTyped(evt);
            }
        });
        getContentPane().add(boxNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 500, -1));

        jLabel3.setText("DIRECCION : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 90, -1));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 500, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 240, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 500, -1));
        getContentPane().add(txtClienteCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 230, -1));

        tblContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblContenido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblContenidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblContenido);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 670, 190));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("EQUIPOS DISPONIBLES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 320, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 650, 10));

        btnDetNuevo.setText("Nuevo");
        btnDetNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDetNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 80, 30));

        btnDetEliminar.setText("Eliminar");
        getContentPane().add(btnDetEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 80, 30));

        btnEditar.setText("Modificar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 80, 30));
        getContentPane().add(txtDetId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 50, -1));

        setSize(new java.awt.Dimension(733, 597));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        FrmMantClientes frm = new FrmMantClientes();
        frm.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnSalirActionPerformed

    private void boxNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxNombreKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_boxNombreKeyTyped

    private void boxNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_boxNombreFocusLost
        // TODO add your handling code here:
//         JOptionPane.showMessageDialog(null,"texto a buscar  "+boxNombre.getSelectedItem().toString());
//        buscar(boxNombre.getSelectedItem().toString());
    }//GEN-LAST:event_boxNombreFocusLost

    private void tblContenidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblContenidoMouseClicked
        // TODO add your handling code here:
/*        if(this.tblContenido.getSelectedRow()!=-1){
            QueryPersonas modelo = new QueryPersonas();//clase donde estan los querys
            ClsPersonas persona = new ClsPersonas();
            this.txtId.setText(tblContenido.getValueAt(tblContenido.getSelectedRow(), 6).toString());
            int c=Integer.parseInt(this.txtId.getText());
            persona=modelo.devuelvePersona(c);
            this.txtApePat.setText(persona.getAp_paterno());
            this.txtApeMat.setText(persona.getAp_materno());
            this.txtNombres.setText(persona.getNombres());
            this.txtNro_doc.setText(persona.getNro_documento());
            this.txtTipo.setText(String.valueOf(persona.getTipo_per()));
            this.txtSexo.setText(String.valueOf(persona.getSexo()));
            if(persona.getSexo()==1){
                this.cmbTipo.setSelectedItem("Masculino");
            }else {
                this.cmbTipo.setSelectedItem("Femenino");
            }
            if(persona.getTipo_per()==1){
                this.cmbTipo.setSelectedItem("Persona Natural");
            }else {
                this.cmbTipo.setSelectedItem("Persona Juridica");
            }
            //Poner fecha a JdateChooser
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha = persona.getFecha_nac();
            Date fecha = null;
            try {
                fecha = formatoDelTexto.parse(strFecha);
                this.jDateFecNacimiento.setDate(fecha);
            } catch (ParseException ex) {
                //JOptionPane.showMessageDialog(null, ex.getMessage());
                System.out.println(this.jDateFecNacimiento.getDate().toString());
            }
            this.btnDetModificar.setEnabled(false);
//            this.btnModificar.setEnabled(true);
//            this.btnEliminar.setEnabled(true);
            this.btnBuscar.doClick();
        } */
    }//GEN-LAST:event_tblContenidoMouseClicked

    private void btnDetNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetNuevoActionPerformed
        // TODO add your handling code here:
// Cargar formulario para ingreso de nuevo equipo
        ClsEquipos mod = new ClsEquipos();
        QueryEquipos modQ = new QueryEquipos();
        FrmEquipos frm = new FrmEquipos();
        CtrlEquipos ctrl = new CtrlEquipos(mod,modQ,frm);
        ctrl.iniciar();
        frm.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_btnDetNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed
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
            java.util.logging.Logger.getLogger(FrmEditCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrmEditCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> boxNombre;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnDetEditar;
    public javax.swing.JButton btnDetEliminar;
    public javax.swing.JButton btnDetNuevo;
    public javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tblContenido;
    public javax.swing.JTextField txtClienteCod;
    public javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDetId;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
