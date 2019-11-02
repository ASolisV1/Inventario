package MantProductos;
// Vamos a implementar ActionListener
import Controlador.*;
import CrudCategoria.FrmAnadirNuevaCategoria;
import CrudCategoria.FrmListaCategoria;
import CrudMarcas.FrmListaMarcas;
import MantProductos.ClsProductos;
import MantProductos.QueryProductos;
import MantProductos.FrmNuevoProducto;
import Objetos.FrmObjetos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
public class CtrlProductos implements ActionListener {
    private ClsProductos mod;
    private QueryProductos modQ;
    private FrmNuevoProducto frm;
    
    private FrmGProductos vista;
    private FrmNuevoProducto vistaAdd;
    
    // Crear el constructor
    
    public CtrlProductos(ClsProductos mod, QueryProductos modQ, FrmNuevoProducto frm){
        this.mod=mod;
        this.modQ=modQ;
        this.frm=frm;
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
            mod.setClientetel(frm.txtTelefono.getText());
            mod.setClientecod(Integer.parseInt(frm.txtClienteCod.getText()));
            if(modQ.guardar(mod)){
                JOptionPane.showMessageDialog(null,"Datos Correctamente Guardados");
                limpiar();
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
//        frm.cmbEstado.setSelectedItem("Activo");
    }
}
