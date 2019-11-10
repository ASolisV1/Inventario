package CrudFormato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlFormato implements ActionListener  {
    private ClsFormato mod = new ClsFormato();
    private QueryFormato query = new QueryFormato();
    private FrmListaFormato vista;
    private FrmAnadirNuevoFormato vistaAdd;
    private FrmModFormato vistaMod;
    
    public CtrlFormato(){ }
    
    public CtrlFormato(FrmListaFormato _vista){
        vista=_vista;
        vista.btnFormatoAdd.addActionListener(this);
        vista.btnFormatoMod.addActionListener(this);
        vista.btnFormatoDel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.btnFormatoAdd){
           vistaAdd = new FrmAnadirNuevoFormato(vista);
           vistaAdd.btnFormatoAddAdd.addActionListener(this);
           vistaAdd.setVisible(true);
       }
       
       else if(e.getSource()==vista.btnFormatoMod){
           mod = new ClsFormato();
           int codigo;
           String nombre;
           
            if(vista.jTable1.getSelectedRow()!=-1){
                codigo= Integer.parseInt((String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 1));
                nombre= (String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 2);
                mod.setCodFor(codigo);
                mod.setNomFor(nombre);
                vistaMod = new FrmModFormato(vista,mod);
                vistaMod.btnFormatoModMod.addActionListener(this);
                vistaMod.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(e.getSource()==vista.btnFormatoDel){
            mod = new ClsFormato();
            int codigo;
            String nombre;            
            
            if(vista.jTable1.getSelectedRow()!=-1){
                if(JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminando", JOptionPane.YES_NO_OPTION)
                        ==0){
                    codigo= Integer.parseInt((String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 1));
                    nombre= (String) vista.jTable1.getValueAt(vista.jTable1.getSelectedRow(), 2);
                    mod.setCodFor(codigo);
                    mod.setNomFor(nombre);
                    query.delete(mod);
                    vista.preTabla();
                }
            }
        
            else{
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(vistaAdd!=null&&e.getSource()==vistaAdd.btnFormatoAddAdd){
            mod = new ClsFormato();
            int codigo = Integer.parseInt(vistaAdd.jTextField1.getText());
            String nombre = vistaAdd.jTextField2.getText();
            mod.setCodFor(codigo);
            mod.setNomFor(nombre);
        
            if (query.save(mod)){
                System.out.println("Insertado");
                JOptionPane.showMessageDialog(null, "Formato Insertado correctamente");
                vista.preTabla();
                vistaAdd.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Error al insertar");
                System.out.println("Error al insertar");
            }
       }
       
       else if(vistaMod!=null&&e.getSource()==vistaMod.btnFormatoModMod){
            mod = new ClsFormato();
            int codigo = Integer.parseInt(vistaMod.jTextField1.getText());
            String nombre = vistaMod.jTextField3.getText();
            mod.setCodFor(codigo);
            mod.setNomFor(nombre);
        
            if (query.update(mod)){
                JOptionPane.showMessageDialog(null, "Formato Modificado correctamente");
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
