package Controlador;
// Vamos a implementar ActionListener
import Modelo.ClsTipo;
import Modelo.QueryTipo;
import Vista.FrmPrincipal;
import Vista.FrmTipos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlTipo implements ActionListener {
    private ClsTipo mod;
    private QueryTipo modQ;
    private FrmTipos frm;
    // Crear el constructor

    public CtrlTipo() {
    }
    
    public CtrlTipo(ClsTipo mod, QueryTipo modQ, FrmTipos frm){
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
        frm.setTitle("Mantenimiento de Tipos de Usuario del Sistema");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);  
        frm.btnBuscar.setVisible(false);
        limpiar();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnGuardar) {
            mod.setUsutiponom(frm.txtTipo.getText());
            mod.setUsutipcod(Integer.parseInt(frm.txtNivel.getText()));
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
            mod.setUsutipid(Integer.parseInt(frm.txtId.getText()));
            mod.setUsutiponom(frm.txtTipo.getText());
            mod.setUsutipcod(Integer.parseInt(frm.txtNivel.getText()));
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
            mod.setUsutipid(Integer.parseInt(frm.txtId.getText()));
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
        frm.txtTipo.setText(null);
        frm.txtNivel.setText(null);
        frm.btnGuardar.setEnabled(true);
        frm.btnModificar.setEnabled(false);
        frm.btnEliminar.setEnabled(false);        
    }
}
