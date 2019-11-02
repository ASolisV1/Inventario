package CrudMarcas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlMarcas  implements ActionListener  {
    private ClsMarcas mod = new ClsMarcas();
    private QueryMarcas query = new QueryMarcas();
    private FrmListaMarcas vista;
    private FrmAnadirNuevaMarca vistaAdd;
    private FrmModMarca vistaMod;
    
    public CtrlMarcas(){ }
    
    public CtrlMarcas(FrmListaMarcas _vista){
        vista=_vista;
        vista.btnMarcasAdd.addActionListener(this);
        vista.btnMarcasMod.addActionListener(this);
        vista.btnMarcasDel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.btnMarcasAdd){
           vistaAdd = new FrmAnadirNuevaMarca(vista);
           vistaAdd.btnMarcasAddAdd.addActionListener(this);
           vistaAdd.setVisible(true);
       }
       
       else if(e.getSource()==vista.btnMarcasMod){
           mod = new ClsMarcas();
           String codigo;
           String nombre;
           
            if(vista.jTable1.getSelectedRow()!=-1){
                codigo= (String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 1);
                nombre= (String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 2);
                mod.setCodMarca(codigo);
                mod.setNomMarca(nombre);
                vistaMod = new FrmModMarca(vista,mod);
                vistaMod.btnMarcasModMod.addActionListener(this);
                vistaMod.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(e.getSource()==vista.btnMarcasDel){
            mod = new ClsMarcas();
            String codigo;
            String nombre;            
            
            if(vista.jTable1.getSelectedRow()!=-1){
                if(JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminando", JOptionPane.YES_NO_OPTION)
                        ==0){
                    codigo= (String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 1);
                    nombre= (String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 2);
                    mod.setCodMarca(codigo);
                    mod.setNomMarca(nombre);
                    query.delete(mod);
                    vista.preTabla();
                }
            }
        
            else{
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(vistaAdd!=null&&e.getSource()==vistaAdd.btnMarcasAddAdd){
            mod = new ClsMarcas();
            String codigo = vistaAdd.jTextField1.getText();
            String nombre = vistaAdd.jTextField2.getText();
            mod.setCodMarca(codigo);
            mod.setNomMarca(nombre);
        
            if (query.save(mod)){
                System.out.println("Insertado");
                JOptionPane.showMessageDialog(null, "Marca Insertada correctamente");
                vista.preTabla();
                vistaAdd.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Error al insertar");
                System.out.println("Error al insertar");
            }
       }
       
       else if(vistaMod!=null&&e.getSource()==vistaMod.btnMarcasModMod){
            mod = new ClsMarcas();
            String codigo = vistaMod.jTextField1.getText();
            String nombre = vistaMod.jTextField3.getText();
            mod.setCodMarca(codigo);
            mod.setNomMarca(nombre);
        
            if (query.update(mod)){
                JOptionPane.showMessageDialog(null, "Marca Modificada correctamente");
                System.out.println("Modificado");
                vista.preTabla();
                vistaMod.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                System.out.println("Error al modificar");
            }
       }
        
    }
    
    
    
}
