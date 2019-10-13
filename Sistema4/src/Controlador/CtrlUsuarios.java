package Controlador;
// Vamos a implementar ActionListener
import Modelo.ClsTipo;
import Modelo.ClsUsuarios;
import Modelo.QueryTipo;
import Modelo.QueryUsuarios;
import Vista.FrmPrincipal;
import Vista.FrmUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrlUsuarios implements ActionListener {
    private ClsUsuarios mod;
    private QueryUsuarios modQ;
    private FrmUsuarios frm;
    // Crear el constructor
    public CtrlUsuarios(ClsUsuarios mod, QueryUsuarios modQ, FrmUsuarios frm){
        this.mod=mod;
        this.modQ=modQ;
        this.frm=frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        //this.frm.btnLimpiar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("Mantenimiento de Usuarios del Sistema");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);  
        frm.txtTipo.setVisible(false);
        frm.btnBuscar.setVisible(false);
        limpiar();
        //Llena ComboBox Tipos        
        this.modQ.llenarCombo(frm.cmbTipo);
        //Seleccionar administrador como defecto
        

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnGuardar) {
            mod.setUsuarionom(frm.txtUsuario.getText());
            mod.setUsuariodni(Integer.parseInt(frm.txtDni.getText()));
            // Guardamos el id del tipo ojo ya teenmos el valor en txt tipo
            ClsTipo tp = new ClsTipo();
            // Casteamos el tipo
            tp=(ClsTipo) frm.cmbTipo.getSelectedItem();
            int idTipoGrabar = tp.getUsutipid();
            //mod.setUsuariotipo(Integer.parseInt(frm.txtTipo.getText()));
            mod.setUsuariotipo(idTipoGrabar);
            frm.txtTipo.setText(Integer.toString(idTipoGrabar));
            
            mod.setUsuariopassword(frm.txtPassword.getText());
            if(modQ.guardar(mod)){
                // datos correctos abrir Formulario Principal
                JOptionPane.showMessageDialog(null,"Datos Correctamente Guardados");
                limpiar();
            } else {
                //datos falsos
                JOptionPane.showMessageDialog(null,"Error al grabar la Información");
                limpiar();
            }
        }
        if(e.getSource()==frm.btnModificar) {
            mod.setUsuarioid(Integer.parseInt(frm.txtId.getText()));
            mod.setUsuarionom(frm.txtUsuario.getText());
            mod.setUsuariodni(Integer.parseInt(frm.txtDni.getText()));
            mod.setUsuariotipo(Integer.parseInt(frm.txtTipo.getText()));            
            mod.setUsuariopassword(frm.txtPassword.getText());
            if(modQ.modificar(mod)){
                // datos correctos abrir Formulario Principal
                JOptionPane.showMessageDialog(null,"Datos Correctamente Modificados");
                limpiar();
            } else {
                //datos falsos
                JOptionPane.showMessageDialog(null,"Error al Modificar la Información");
                limpiar();
            }
        }
        if(e.getSource()==frm.btnEliminar) {
            mod.setUsuarioid(Integer.parseInt(frm.txtId.getText()));
            if(modQ.eliminar(mod)){
                // datos correctos abrir Formulario Principal
                JOptionPane.showMessageDialog(null,"Datos Correctamente Eliminados");
                limpiar();
            } else {
                //datos falsos
                JOptionPane.showMessageDialog(null,"Error al Eliminar la Información");
                limpiar();
            }
        }
        if(e.getSource()==frm.btnLimpiar) {
            limpiar();
        }
    }
    public void limpiar() {
        frm.txtUsuario.setText(null);
        frm.txtDni.setText(null);
        frm.txtTipo.setText(null);
        frm.txtPassword.setText(null);
        frm.btnGuardar.setEnabled(true);
        frm.btnModificar.setEnabled(false);
        frm.btnEliminar.setEnabled(false);  
        frm.cmbTipo.setSelectedItem(null);
    }
}
