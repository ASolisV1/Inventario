package Entradas;
// Vamos a implementar ActionListener
import MantProductos.*;
import Controlador.*;
import MantProductos.ClsProductos;
import MantProductos.QueryProductos;
import MantProductos.FrmEditProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
public class CtrlEditEntradas implements ActionListener {
    private ClsProductos mod;
    private QueryProductos modQ;
    private FrmEditProductos frm;
    // Crear el constructor
    public CtrlEditEntradas(ClsProductos mod, QueryProductos modQ, FrmEditProductos frm){
        this.mod=mod;
        this.modQ=modQ;
        this.frm=frm;
        this.frm.btnEditar.addActionListener(this);
        
    }
    public void iniciar(){
        frm.setTitle("Mantenimiento Productos");
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
            mod.setClientetel(frm.txtTelefono.getText());
            mod.setClientecod(Integer.parseInt(frm.txtClienteCod.getText()));
            if(modQ.modificar(mod)){
                JOptionPane.showMessageDialog(null,"Datos Correctamente Modificados");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null,"Error al Modificar la Información");
                limpiar();
            }
        }
        

    }
    public void limpiar() {
        frm.txtId.setVisible(false);  
        frm.btnBuscar.setVisible(false);   
        
//        frm.cmbEstado.setSelectedItem("Activo");
    }
}
