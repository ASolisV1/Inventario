package Controlador;
// Vamos a implementar ActionListener
import Modelo.ClsClientes;
import Modelo.QueryClientes;
import Vista.FrmNewCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
public class CtrlClientes implements ActionListener {
    private ClsClientes mod;
    private QueryClientes modQ;
    private FrmNewCliente frm;
    // Crear el constructor
    public CtrlClientes(ClsClientes mod, QueryClientes modQ, FrmNewCliente frm){
        this.mod=mod;
        this.modQ=modQ;
        this.frm=frm;
        this.frm.btnDetEditar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("Mantenimiento de Clientes");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);  
//        frm.txtEstado.setVisible(false);
//        frm.txtIdTipTraba.setVisible(false);
        frm.btnBuscar.setVisible(false);        
        frm.btnGuardar.setVisible(false);
        frm.btnDetEditar.setVisible(false);
        frm.btnDetEliminar.setVisible(false);
        frm.btnDetNuevo.setVisible(false);
        limpiar();        
//        frm.cmbEstado.setSelectedItem("Activo");  // Estado 1 = activo 0 = Inactivo
        //Llena ComboBox Tipo de Trabajadores 
//        this.modQ.llenarCombo(frm.cmbTipoTrabajador);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnGuardar) {
            mod.setPersonaid(Integer.parseInt(frm.txtId.getText()));
            mod.setClientedir(frm.txtDireccion.getText());
            mod.setClientecorr(frm.txtCorreo.getText());
            mod.setClientetel(frm.txtTelefono.getText());
            mod.setClientecod(Integer.parseInt(frm.txtClienteCod.getText()));
            if(modQ.guardar(mod)){
                JOptionPane.showMessageDialog(null,"Datos Correctamente Guardados");
                limpiar();
                frm.btnDetNuevo.setVisible(true);
                frm.btnDetEliminar.setVisible(true);
                frm.btnDetEditar.setVisible(true);                
            } else {
                JOptionPane.showMessageDialog(null,"Error al grabar la Información");
                limpiar();
            }
        }
        
/*        if(e.getSource()==frm.btnDetModificar) {
            mod.setId_persona(Integer.parseInt(frm.txtId.getText()));
            int idTipoGrabar = Integer.parseInt(frm.txtIdTipTraba.getText());
            mod.setId_tip_trabajador(idTipoGrabar);             
            mod.setTra_descrip(frm.txtDescripcion.getText());            
            // grabar la fecha
            int yearTemp = frm.jDateFecIngreso.getCalendar().get(Calendar.YEAR);
            int mesTemporal = frm.jDateFecIngreso.getCalendar().get(Calendar.MONTH)+1;
            int diaTemp = frm.jDateFecIngreso.getCalendar().get(Calendar.DAY_OF_MONTH);            
            String fechaTemp = yearTemp + "-" + mesTemporal + "-" + diaTemp;
            mod.setFech_ingreso(fechaTemp);   
            mod.setTra_sueldo(Double.parseDouble(frm.txtSueldo.getText()));
            // jala el estado si es activo es 1 inactivo es 0
            String varEstado = frm.cmbEstado.getSelectedItem().toString();
            mod.setEstado(0);
            if(varEstado=="Activo") {
                mod.setEstado(1);                
            }
            if(modQ.guardar(mod)){
                JOptionPane.showMessageDialog(null,"Datos Correctamente Guardados");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null,"Error al grabar la Información");
                limpiar();
            }
        }*/
    }
    public void limpiar() {
//        frm.txtEstado.setText(null);
//        frm.txtSueldo.setText(null);
        frm.btnDetEditar.setEnabled(true);
//        frm.cmbEstado.setSelectedItem("Activo");
    }
}
