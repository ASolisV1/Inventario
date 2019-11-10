
package Inventario;

import MantProductos.ClsProductos;
import MantProductos.FrmEditProductos;
import MantProductos.FrmGProductos;
import MantProductos.FrmNuevoProducto;
import MantProductos.QueryProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlInventario implements ActionListener {
    private ClsInventario mod = new ClsInventario();
    private QueryInventario query = new QueryInventario ();
    
    private FrmGInventario vista;
        
    public CtrlInventario (FrmGInventario _vista){
        vista=_vista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
    }
    
}
