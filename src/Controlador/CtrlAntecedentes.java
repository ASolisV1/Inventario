package Controlador;
// Vamos a implementar ActionListener
import Modelo.ClsAntecedentes;

import Modelo.QueryAntecedentes;

import Vista.FrmAntecedentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrlAntecedentes implements ActionListener {
    private ClsAntecedentes mod;
    private QueryAntecedentes modQ;
    private FrmAntecedentes frm;
    // Crear el constructor
    public CtrlAntecedentes(ClsAntecedentes mod, QueryAntecedentes modQ, FrmAntecedentes frm){
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
        frm.txtIdEquipo.setVisible(false);  
        frm.btnBuscar.setVisible(false);
        limpiar();
        //Llena ComboBox Tipos        
        //Seleccionar administrador como defecto
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnGuardar) {
            mod.setEquipoid(Integer.parseInt(frm.txtIdEquipo.getText())); 
            mod.setAntid(Integer.parseInt(frm.txtId.getText())); 
            mod.setAntdes(frm.txtDescripcion.getText());
            mod.setAntsolucion(frm.txtDescripcion.getText());
            
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
            mod.setEquipoid(Integer.parseInt(frm.txtIdEquipo.getText())); 
            mod.setAntid(Integer.parseInt(frm.txtId.getText())); 
            mod.setAntdes(frm.txtDescripcion.getText());
            mod.setAntsolucion(frm.txtDescripcion.getText());
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
//        frm.txtPassword.setText(null);
        frm.btnGuardar.setEnabled(true);
        frm.btnModificar.setEnabled(false);
//        frm.btnEliminar.setEnabled(false);  
    }
}
