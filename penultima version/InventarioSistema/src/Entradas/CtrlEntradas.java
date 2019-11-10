package Entradas;
// Vamos a implementar ActionListener
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlEntradas implements ActionListener {
    private ClsEntradas mod = new ClsEntradas();
    private QueryEntradas query = new QueryEntradas();
    
    private FrmGEntradas vista;
    private FrmNuevaEntrada vistaAdd;
    private FrmEditEntradas vistaMod;
    
    public CtrlEntradas (FrmGEntradas _vista){
        vista=_vista;
        vista.btnNuevo.addActionListener(this);
        vista.btnEditar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.btnNuevo){
           vistaAdd = new FrmNuevaEntrada(vista);
           vistaAdd.btnGuardar.addActionListener(this);
           vistaAdd.setVisible(true);
       }
       
       else if(e.getSource()==vista.btnEditar){
           mod = new ClsEntradas();
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
                
                mod.setEntcod(codigo);
                mod.setEntdoc(nombre);
                mod.setEntcant(cantidad);
                mod.setEntdia(dia);
                mod.setEntmes(mes);
                mod.setEntanio(anio);
                vistaMod = new FrmEditEntradas(vista,mod);
                vistaMod.btnEditar.addActionListener(this);
                vistaMod.setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(e.getSource()==vista.btnEliminar){
            mod = new ClsEntradas();
            int codigo; 
            
            if(vista.tblDatos.getSelectedRow()!=-1){
                if(JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminando", JOptionPane.YES_NO_OPTION)
                        ==0){
                    codigo= Integer.parseInt((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 1));
                    mod.setEntcod(codigo);
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
            mod = new ClsEntradas();
            String docEnt = vistaAdd.nomdoc.getText();
            int proCodEnt;
            int cantEnt = Integer.parseInt(vistaAdd.cantidad.getText());
            if(vistaAdd.tblDatos.getSelectedRow()!=-1){
                proCodEnt = Integer.parseInt((String) vistaAdd.tblDatos.getValueAt(vistaAdd.tblDatos.getSelectedRow(),1));
                mod.setEntdoc(docEnt);
                mod.setEntprodcod(proCodEnt);
                mod.setEntcant(cantEnt);
                mod.setEntdia(7);
                mod.setEntmes(7);
                mod.setEntanio(7);
                
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
            mod = new ClsEntradas();
            String docEnt = vistaMod.nomdoc.getText();
            int proCodEnt;
            int cantEnt = Integer.parseInt(vistaMod.cantidad.getText());
            if(vistaMod.tblDatos.getSelectedRow()!=-1){
                proCodEnt = Integer.parseInt((String) vistaMod.tblDatos.getValueAt(vistaMod.tblDatos.getSelectedRow(),1));
                mod.setEntdoc(docEnt);
                mod.setEntprodcod(proCodEnt);
                mod.setEntcant(cantEnt);
                mod.setEntdia(7);
                mod.setEntmes(7);
                mod.setEntanio(7);
              
                if (query.update(mod)){
                        JOptionPane.showMessageDialog(null, "Entrada Modificado correctamente");
                        System.out.println("Modificado");
                        vista.preTabla();
                        vistaMod.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Error al Modificar");
                        System.out.println("Error al modificar");
                    }
                
              
            } else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
    }
    
}
