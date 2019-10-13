package Controlador;
// Vamos a implementar ActionListener
import Modelo.ClsClientes;
import Modelo.QueryClientes;
import Vista.FrmEditCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
public class CtrlEditClientes implements ActionListener {
    private ClsClientes mod;
    private QueryClientes modQ;
    private FrmEditCliente frm;
    // Crear el constructor
    public CtrlEditClientes(ClsClientes mod, QueryClientes modQ, FrmEditCliente frm){
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
}
