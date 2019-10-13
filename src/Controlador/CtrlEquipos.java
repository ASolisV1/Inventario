package Controlador;
// Vamos a implementar ActionListener
import Modelo.ClsEquipos;
import Modelo.QueryEquipos;
import Vista.FrmEquipos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrlEquipos implements ActionListener {
    private ClsEquipos mod;
    private QueryEquipos modQ;
    private FrmEquipos frm;
    // Crear el constructor
    public CtrlEquipos(ClsEquipos mod, QueryEquipos modQ, FrmEquipos frm){
        this.mod=mod;
        this.modQ=modQ;
        this.frm=frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
//        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        //this.frm.btnLimpiar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("Agregar Equipos al Usuario");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);  
        frm.txtIdCliente.setVisible(false);  
        frm.txtTipo.setVisible(false);
        frm.btnBuscar.setVisible(false);
        limpiar();
        //Llena ComboBox Tipos        
        this.modQ.llenarCombo(frm.cmbTipoEquipo);
        //Seleccionar administrador como defecto
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnGuardar) {
            mod.setClienteid(Integer.parseInt(frm.txtIdCliente.getText())); 
            mod.setEquipotipo(Integer.parseInt(frm.txtTipo.getText())); 
            mod.setEquipocod(Integer.parseInt(frm.txtCodigoEquipo.getText())); 
            mod.setEquipodes(frm.txtDescripcion.getText());
            mod.setEquipomar(frm.txtMarca.getText());
            mod.setEquipomod(frm.txtModelo.getText());
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
            mod.setEquipoid(Integer.parseInt(frm.txtId.getText()));
            mod.setClienteid(Integer.parseInt(frm.txtIdCliente.getText())); 
            mod.setEquipotipo(Integer.parseInt(frm.txtTipo.getText())); 
            mod.setEquipocod(Integer.parseInt(frm.txtCodigoEquipo.getText())); 
            mod.setEquipodes(frm.txtDescripcion.getText());
            mod.setEquipomar(frm.txtMarca.getText());
            mod.setEquipomod(frm.txtModelo.getText());
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
/*        if(e.getSource()==frm.btnEliminar) {
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
        }*/
    }
    public void limpiar() {
//        frm.txtUsuario.setText(null);
//        frm.txtDni.setText(null);
        frm.txtTipo.setText(null);
//        frm.txtPassword.setText(null);
        frm.btnGuardar.setEnabled(true);
        frm.btnModificar.setEnabled(false);
//        frm.btnEliminar.setEnabled(false);  
        frm.cmbTipoEquipo.setSelectedItem(null);
    }
}
