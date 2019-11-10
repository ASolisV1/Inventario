package CrudCategoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlCategoria implements ActionListener  {
    private ClsCategoria mod = new ClsCategoria();
    private QueryCategoria query = new QueryCategoria();
    private FrmListaCategoria vista;
    private FrmAnadirNuevaCategoria vistaAdd;
    private FrmModCategoria vistaMod;
    
    public CtrlCategoria(){ }
    
    public CtrlCategoria(FrmListaCategoria _vista){
        vista=_vista;
        vista.btnCategoriaAdd.addActionListener(this);
        vista.btnCategoriaMod.addActionListener(this);
        vista.btnCategoriaDel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.btnCategoriaAdd){
           vistaAdd = new FrmAnadirNuevaCategoria(vista);
           vistaAdd.btnCategoriaAddAdd.addActionListener(this);
           vistaAdd.setVisible(true);
       }
       
       else if(e.getSource()==vista.btnCategoriaMod){
           mod = new ClsCategoria();
           int codigo;
           String nombre;
           
            if(vista.jTable1.getSelectedRow()!=-1){
                codigo= Integer.parseInt((String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 1));
                nombre= (String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 2);
                mod.setCodCateg(codigo);
                mod.setNomCateg(nombre);
                vistaMod = new FrmModCategoria(vista,mod);
                vistaMod.btnCategoriaModMod.addActionListener(this);
                vistaMod.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(e.getSource()==vista.btnCategoriaDel){
            mod = new ClsCategoria();
            int codigo;
            String nombre;            
            
            if(vista.jTable1.getSelectedRow()!=-1){
                if(JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminando", JOptionPane.YES_NO_OPTION)
                        ==0){
                    codigo= Integer.parseInt((String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 1));
                    nombre= (String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 2);
                    mod.setCodCateg(codigo);
                    mod.setNomCateg(nombre);
                    query.delete(mod);
                    vista.preTabla();
                }
            }
        
            else{
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(vistaAdd!=null&&e.getSource()==vistaAdd.btnCategoriaAddAdd){
            mod = new ClsCategoria();
            int codigo = Integer.parseInt(vistaAdd.jTextField1.getText());
            String nombre = vistaAdd.jTextField2.getText();
            mod.setCodCateg(codigo);
            mod.setNomCateg(nombre);
        
            if (query.save(mod)){
                System.out.println("Insertado");
                JOptionPane.showMessageDialog(null, "Categoria Insertada correctamente");
                vista.preTabla();
                vistaAdd.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Error al insertar");
                System.out.println("Error al insertar");
            }
       }
       
       else if(vistaMod!=null&&e.getSource()==vistaMod.btnCategoriaModMod){
            mod = new ClsCategoria();
            int codigo = Integer.parseInt(vistaMod.jTextField1.getText());
            String nombre = vistaMod.jTextField2.getText();
            mod.setCodCateg(codigo);
            mod.setNomCateg(nombre);
        
            if (query.update(mod)){
                JOptionPane.showMessageDialog(null, "Categoria Modificada correctamente");
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
