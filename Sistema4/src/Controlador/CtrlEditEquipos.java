/*package Controlador;
// Vamos a implementar ActionListener
import Modelo.ClsClientes;
import Modelo.ClsEquipos;
import Modelo.QueryClientes;
import Modelo.QueryEquipos;
import Vista.FrmEditCliente;
import Vista.FrmEditEquipos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
public class CtrlEditEquipos implements ActionListener {
    private ClsEquipos mod;
    private QueryEquipos modQ;
    private FrmEditEquipos frm;
    // Crear el constructor
    public CtrlEditEquipos(ClsEquipos mod, QueryEquipos modQ, FrmEditEquipos frm){
        this.mod=mod;
        this.modQ=modQ;
        this.frm=frm;
        this.frm.btnDetEditar.addActionListener(this);
        this.frm.btnDetEliminar.addActionListener(this);
        this.frm.btnEditar.addActionListener(this);
        
    }
    public void iniciar(){
        frm.setTitle("Mantenimiento de Clientesasasas");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);  
        frm.btnBuscar.setVisible(false);        
        //frm.btnEditar.setVisible(true);
        //frm.btnDetEditar.setVisible(false);
        //frm.btnDetEliminar.setVisible(false);
        //frm.btnDetNuevo.setVisible(false);
        limpiar();        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnEditar) {
            mod.setEquipoid(Integer.parseInt(frm.txtId.getText()));
            mod.setsetClienteid(frm.txtIdEquipo.getText());
            mod.setClientecorr(frm.txtCorreo.getText());
            mod.setClientetel(frm.txtTelefono.getText());
            mod.setClientecod(Integer.parseInt(frm.txtClienteCod.getText()));
            if(modQ.modificar(mod)){
                JOptionPane.showMessageDialog(null,"Datos Correctamente Modificados");
                limpiar();
                frm.btnDetNuevo.setVisible(true);
                frm.btnDetEliminar.setVisible(true);
                frm.btnDetEditar.setVisible(true);                
            } else {
                JOptionPane.showMessageDialog(null,"Error al Modificar la Información");
                limpiar();
            }
        }
        if(e.getSource()==frm.btnDetEliminar) {
            mod.setPersonaid(Integer.parseInt(frm.txtId.getText()));
            mod.setClientedir(frm.txtDireccion.getText());
            mod.setClientecorr(frm.txtCorreo.getText());
            mod.setClientetel(frm.txtTelefono.getText());
            mod.setClientecod(Integer.parseInt(frm.txtClienteCod.getText()));
            if(modQ.modificar(mod)){
                JOptionPane.showMessageDialog(null,"Datos Correctamente Modificados");
                limpiar();
                frm.btnDetNuevo.setVisible(true);
                frm.btnDetEliminar.setVisible(true);
                frm.btnDetEditar.setVisible(true);                
            } else {
                JOptionPane.showMessageDialog(null,"Error al Modificar la Información");
                limpiar();
            }
        }

    }
    public void limpiar() {
        frm.txtId.setVisible(false);  
        frm.btnBuscar.setVisible(false);   
        frm.btnDetEditar.setEnabled(true);
//        frm.cmbEstado.setSelectedItem("Activo");
    }
}*/
