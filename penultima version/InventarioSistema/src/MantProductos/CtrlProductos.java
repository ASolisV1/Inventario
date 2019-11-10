package MantProductos;
// Vamos a implementar ActionListener
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlProductos implements ActionListener {
    private ClsProductos mod = new ClsProductos();
    private QueryProductos query = new QueryProductos ();
    
    private FrmGProductos vista;
    private FrmNuevoProducto vistaAdd;
    private FrmEditProductos vistaMod;
        
    public CtrlProductos (FrmGProductos _vista){
        vista=_vista;
        vista.btnProAdd.addActionListener(this);
        vista.btnProMod.addActionListener(this);
        vista.btnProDel.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vista.btnProAdd){
           vistaAdd = new FrmNuevoProducto(vista);
           vistaAdd.btnNuevoAdd.addActionListener(this);
           vistaAdd.setVisible(true);
       }
       
       else if(e.getSource()==vista.btnProMod){
           mod = new ClsProductos();
           int codigo;
           String nombre;
           double precio;
           
            if(vista.tblDatos.getSelectedRow()!=-1){
                codigo= Integer.parseInt((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 1));
                nombre= (String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 2);
                precio= Double.parseDouble((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 7));
                mod.setProCod(codigo);
                mod.setProNom(nombre);
                mod.setProPreVen(precio);
                vistaMod = new FrmEditProductos(vista,mod);
                vistaMod.btnEditar.addActionListener(this);
                vistaMod.setVisible(true);
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(e.getSource()==vista.btnProDel){
            mod = new ClsProductos();
            int codigo; 
            
            if(vista.tblDatos.getSelectedRow()!=-1){
                if(JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminando", JOptionPane.YES_NO_OPTION)
                        ==0){
                    codigo= Integer.parseInt((String) vista.tblDatos.getValueAt(vista.tblDatos.getSelectedRow(), 1));
                    mod.setProCod(codigo);
                    query.delete(mod);
                    vista.preTabla();
                }
            }
        
            else{
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado");
                System.out.println("Ninguna elemento seleccionado");
            }
       }
       
       else if(vistaMod!=null&&e.getSource()==vistaMod.btnEditar){
            mod = new ClsProductos();
            int proCod = Integer.parseInt(vistaMod.jFCodPro.getText());
            int proCatCod = query.getCatQ().getByNom(vistaMod.jCBProCat.getSelectedItem().toString()).getCodCateg();
            int proMarCod = query.getMarQ().getByNom(vistaMod.jCBProMar.getSelectedItem().toString()).getCodMarca();
            int proForCod = query.getForQ().getByNom(vistaMod.jCBProFor.getSelectedItem().toString()).getCodFor();
            int proTipCod = query.getTipQ().getByNom(vistaMod.jCBProTipo.getSelectedItem().toString()).getTipcod();
            String proNom=vistaMod.boxNombre.getSelectedItem().toString();
            Double proPreVen = Double.parseDouble(vistaMod.jTFArtPre.getText());
            
            mod.setProCod(proCod);
            mod.setProCatNom(proCatCod);
            mod.setProMarNom(proMarCod);
            mod.setProForNom(proForCod);
            mod.setProTipNom(proTipCod);
            mod.setProNom(proNom);
            mod.setProPreVen(proPreVen);
        
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
       
       
       else if(vistaAdd!=null&&e.getSource()==vistaAdd.btnNuevoAdd){
            mod = new ClsProductos();
            int proCod = Integer.parseInt(vistaAdd.jFCodPro.getText());
            int proCatCod = query.getCatQ().getByNom(vistaAdd.jCBProCat.getSelectedItem().toString()).getCodCateg();
            int proMarCod = query.getMarQ().getByNom(vistaAdd.jCBProMar.getSelectedItem().toString()).getCodMarca();
            int proForCod = query.getForQ().getByNom(vistaAdd.jCBProFor.getSelectedItem().toString()).getCodFor();
            int proTipCod = query.getTipQ().getByNom(vistaAdd.jCBProTipo.getSelectedItem().toString()).getTipcod();
            String proNom=vistaAdd.boxNombre.getSelectedItem().toString();
            Double proPreVen = Double.parseDouble(vistaAdd.jTFArtPre.getText());
            
            mod.setProCod(proCod);
            mod.setProCatNom(proCatCod);
            mod.setProMarNom(proMarCod);
            mod.setProForNom(proForCod);
            mod.setProTipNom(proTipCod);
            mod.setProNom(proNom);
            mod.setProPreVen(proPreVen);
            
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
       }
       
    }
    
}
