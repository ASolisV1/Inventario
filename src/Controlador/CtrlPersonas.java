package Controlador;
// Vamos a implementar ActionListener
import Modelo.ClsPersonas;
import Modelo.QueryPersonas;
import Vista.FrmPersonas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
public class CtrlPersonas implements ActionListener {
    private ClsPersonas mod;
    private QueryPersonas modQ;
    private FrmPersonas frm;
    // Crear el constructor
    public CtrlPersonas(ClsPersonas mod, QueryPersonas modQ, FrmPersonas frm){
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
        frm.txtSexo.setVisible(false);
        frm.txtTipo.setVisible(false);
        frm.btnBuscar.setVisible(false);
        limpiar();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnGuardar) {
            mod.setAp_paterno(frm.txtApePat.getText());
            mod.setAp_materno(frm.txtApeMat.getText());
            mod.setNombres(frm.txtNombres.getText());   
            mod.setNro_documento(frm.txtNro_doc.getText());            
            // grabar la fecha
            int yearTemp = frm.jDateFecNacimiento.getCalendar().get(Calendar.YEAR);
            int mesTemporal = frm.jDateFecNacimiento.getCalendar().get(Calendar.MONTH)+1;
            int diaTemp = frm.jDateFecNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);            
            String fechaTemp = yearTemp + "-" + mesTemporal + "-" + diaTemp;
            mod.setFecha_nac(fechaTemp);            
            // Masculino = 1    Femenino = 0            
            String varSexo = frm.cmbSexo.getSelectedItem().toString();
            mod.setSexo(0);
            if(varSexo.equals("Masculino")) {
                mod.setSexo(1);                
            }
            String varTipo = frm.cmbTipo.getSelectedItem().toString();
            mod.setTipo_per(0);
            if(varTipo.equals("Persona Natural")) {
                mod.setTipo_per(1);                
            }            
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
            mod.setAp_paterno(frm.txtApePat.getText());
            mod.setAp_materno(frm.txtApeMat.getText());
            mod.setNombres(frm.txtNombres.getText());
            mod.setNro_documento(frm.txtNro_doc.getText());            
            // grabar la fecha
            int yearTemp = frm.jDateFecNacimiento.getCalendar().get(Calendar.YEAR);
            int mesTemporal = frm.jDateFecNacimiento.getCalendar().get(Calendar.MONTH)+1;
            int diaTemp = frm.jDateFecNacimiento.getCalendar().get(Calendar.DAY_OF_MONTH);            
            String fechaTemp = yearTemp + "-" + mesTemporal + "-" + diaTemp;
            mod.setFecha_nac(fechaTemp);            
            // jala el estado si es activo es 1 inactivo es 0
            String varSexo = frm.cmbSexo.getSelectedItem().toString();
            mod.setSexo(0);
            if(varSexo.equals("Masculino")) {
                mod.setSexo(1);                
            }
            String varTipo = frm.cmbTipo.getSelectedItem().toString();
            mod.setTipo_per(0);
            if(varTipo.equals("Persona Natural")) {
                mod.setTipo_per(1);                
            }
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
        frm.txtApePat.setText(null);
        frm.txtApeMat.setText(null);
        frm.txtNombres.setText(null);
        frm.txtSexo.setText(null);
        frm.txtNro_doc.setText(null);
        frm.btnGuardar.setEnabled(true);
        frm.btnModificar.setEnabled(false);
        frm.btnEliminar.setEnabled(false);  
        // Masculino = 1    Femenino = 0 
        frm.cmbSexo.setSelectedItem("Masculino");
        // Persona Natural = 1    Persona Juridica = 0 
        frm.cmbTipo.setSelectedItem("Persona Natural");
    }
}
