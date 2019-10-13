package Controlador;
// Vamos a implementar ActionListener
import Modelo.ClsArticulos;
import Modelo.ClsClientes;
import Modelo.ClsTipo;
import Modelo.QueryArticulos;
import Modelo.QueryClientes;
import Modelo.QueryTipo;
import Vista.FrmArticulos;

import Vista.FrmClientes;
import Vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class CtrlArticulos implements ActionListener {
    private ClsArticulos mod;
    private QueryArticulos modQ;
    private FrmArticulos frm;
    // Crear el constructor
    public CtrlArticulos(ClsArticulos mod, QueryArticulos modQ, FrmArticulos frm){
        this.mod=mod;
        this.modQ=modQ;
        this.frm=frm;
        this.frm.btnArtGuardar.addActionListener(this);
        this.frm.btnArtModificar.addActionListener(this);
        this.frm.btnArtEliminar.addActionListener(this);
        this.frm.btnArtLimpiar.addActionListener(this);
        //this.frm.btnLimpiar.addActionListener(this);
    }
    public void iniciar(){
        frm.setTitle("Mantenimiento de Cliente del Sistema");
        frm.setLocationRelativeTo(null);
        frm.txtArtId.setVisible(false);  
        frm.btnArtBuscar.setVisible(false);
        limpiar();
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frm.btnArtGuardar) {
            mod.setArticulonom(frm.txtArticulo.getText());
            //mod.setClientecor(Integer.parseInt(frm.txtCliCor.getText()));
            mod.setArticulocod(Integer.parseInt(frm.txtArtCod.getText()));
            mod.setArticulodes(frm.txtArtDes.getText());
            mod.setArticulocosto(Integer.parseInt(frm.txtArtCost.getText()));
            
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
        if(e.getSource()==frm.btnArtModificar) {
            mod.setArticuloid(Integer.parseInt(frm.txtArtId.getText()));
            mod.setArticulonom(frm.txtArticulo.getText());
            mod.setArticulocod(Integer.parseInt(frm.txtArtCod.getText()));
            mod.setArticulodes(frm.txtArtDes.getText());
            mod.setArticulocosto(Integer.parseInt(frm.txtArtCost.getText()));
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
        if(e.getSource()==frm.btnArtEliminar) {
            mod.setArticuloid(Integer.parseInt(frm.txtArtId.getText()));
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
        if(e.getSource()==frm.btnArtLimpiar) {
            limpiar();
        }
    }
    public void limpiar() {
        frm.txtArticulo.setText(null);
        frm.txtArtCod.setText(null);
        frm.txtArtDes.setText(null);
        frm.txtArtCost.setText(null);
        
        frm.btnArtGuardar.setEnabled(true);
        frm.btnArtModificar.setEnabled(false);
        frm.btnArtEliminar.setEnabled(false);  
    }
}
