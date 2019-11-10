package Salidas;
// Vamos a implementar ActionListener
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlSalidas implements ActionListener {
    private ClsSalidas mod = new ClsSalidas();
    private QuerySalidas query = new QuerySalidas();
    
    private FrmGSalidas vista;
    private FrmNuevaSalida vistaAdd;
    private FrmEditSalidas vistaMod;
    
    public CtrlSalidas (FrmGSalidas _vista){
        vista=_vista;
        vista.btnNuevo.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.btnNuevo){
           vistaAdd = new FrmNuevaSalida(vista);
           vistaAdd.btnGuardar.addActionListener(this);
           vistaAdd.setVisible(true);
       }
       
       else if(e.getSource()==vista.btnEditar){
           mod = new ClsSalidas();
           int codigo;
           String nombre;
           int cantidad;
           int dia;
           int mes;
           int anio;
           
            if(vista.tblDatos.getSelectedRow()!=-1){
                codigo= Integer.parseInt((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 1));
                nombre= (String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 2);
                cantidad= Integer.parseInt((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 4));
                dia=Integer.parseInt((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 5));
                mes=Integer.parseInt((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 6));
                anio=Integer.parseInt((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 7));
                
                mod.setSalcod(codigo);
                mod.setSaldoc(nombre);
                mod.setSalcant(cantidad);
                mod.setSaldia(dia);
                mod.setSalmes(mes);
                mod.setSalanio(anio);
                vistaMod = new FrmEditSalidas(vista,mod);
                vistaMod.btnEditar.addActionListener(this);
                vistaMod.setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(e.getSource()==vista.btnEliminar){
            mod = new ClsSalidas();
            int codigo; 
            
            if(vista.tblDatos.getSelectedRow()!=-1){
                if(JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminando", JOptionPane.YES_NO_OPTION)
                        ==0){
                    codigo= Integer.parseInt((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 1));
                    mod.setSalcod(codigo);
                    query.delete(mod);
                    vista.preTabla();
                }
            }
        
            else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(vistaAdd!=null&&e.getSource()==vistaAdd.btnGuardar){
            mod = new ClsSalidas();
            String docSal = vistaAdd.nomdoc.getText();
            int proCodSal;
            int cantSal = Integer.parseInt(vistaAdd.cantidad.getText());
            if(vistaAdd.tblDatos.getSelectedRow()!=-1){
                proCodSal = Integer.parseInt((String) vistaAdd.tblDatos.getValueAt(vistaAdd.tblDatos.getSelectedRow(),1));
                mod.setSaldoc(docSal);
                mod.setSalprodcod(proCodSal);
                mod.setSalcant(cantSal);
                mod.setSaldia(7);
                mod.setSalmes(7);
                mod.setSalanio(7);
                
                if (query.save(mod)){
                    System.out.println("Insertado");
                    JOptionPane.showMessageDialog(null, "Producto Insertada correctamente");
                    vista.preTabla();
                    vistaAdd.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error al insertar");
                    System.out.println("Error al insertar");
                }
                
            } else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
            
       }
       
       else if(vistaMod!=null&&e.getSource()==vistaMod.btnEditar){
            mod = new ClsSalidas();
            String docSal = vistaMod.nomdoc.getText();
            int proCodSal;
            int cantSal = Integer.parseInt(vistaMod.cantidad.getText());
            if(vistaMod.tblDatos.getSelectedRow()!=-1){
                proCodSal = Integer.parseInt((String) vistaMod.tblDatos.getValueAt(vistaMod.tblDatos.getSelectedRow(),1));
                mod.setSaldoc(docSal);
                mod.setSalprodcod(proCodSal);
                mod.setSalcant(cantSal);
                mod.setSaldia(7);
                mod.setSalmes(7);
                mod.setSalanio(7);
                
                if (query.save(mod)){
                    System.out.println("Insertado");
                    JOptionPane.showMessageDialog(null, "Salida Insertada correctamente");
                    vista.preTabla();
                    vistaMod.dispose();
                    
                    if (query.update(mod)){
                        JOptionPane.showMessageDialog(null, "Salida Modificado correctamente");
                        System.out.println("Modificado");
                        vista.preTabla();
                        vistaMod.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Error al Modificar");
                        System.out.println("Error al modificar");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error al insertar");
                    System.out.println("Error al insertar");
                }
                
            } else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
    }
    
}
