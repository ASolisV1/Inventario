package Objetos;
// Vamos a implementar ActionListener
import CrudCategoria.FrmAnadirNuevaCategoria;
import Modelo.ClsPersonas;
import Modelo.QueryPersonas;
import Objetos.FrmObjetos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
public class CtrlObjetos implements ActionListener {
    private ClsPersonas mod;
    private QueryPersonas modQ;
    private FrmObjetos frm;
    // Crear el constructor
    public CtrlObjetos(ClsPersonas mod, QueryPersonas modQ, FrmObjetos frm){
        this.mod=mod;
        this.modQ=modQ;
        this.frm=frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("Mantenimiento de Personas");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);  
        frm.btnBuscar.setVisible(false);
        limpiar();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
      
        
        if(e.getSource()==frm.btnGuardar) {
            mod.setNombres(frm.txtNombres.getText());   
                        
            if(modQ.guardar(mod)){
                JOptionPane.showMessageDialog(null,"Datos Correctamente Guardados");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null,"Error al grabar la Información");
                limpiar();
            }
        }
        if(e.getSource()==frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setNombres(frm.txtNombres.getText());
            
            if(modQ.modificar(mod)){
                JOptionPane.showMessageDialog(null,"Datos Correctamente Modificados");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null,"Error al Modificar la Información");
                limpiar();
            }
        }
        if(e.getSource()==frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            if(modQ.eliminar(mod)){
                JOptionPane.showMessageDialog(null,"Datos Correctamente Eliminados");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null,"Error al Eliminar la Información");
                limpiar();
            }
        }
        if(e.getSource()==frm.btnLimpiar) {
            limpiar();
        }
    }
    public void limpiar() {
        frm.txtNombres.setText(null);
        frm.btnGuardar.setEnabled(true);
        frm.btnModificar.setEnabled(false);
        frm.btnEliminar.setEnabled(false);  
        
    }
}
