package Modelo;
// Extendemos Conexion agregando extends Conexion de esta forma
// poder utilizar de forma directa la conexion a la BD.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QueryEquipos extends Conexion {
    // Metodo para validar Usuario y Password
    public boolean guardar(ClsEquipos usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO equipo (clienteid,equipotipo,equipocod,equipodes,equipomar,equipomod) VALUES (?,?,?,?,?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,usu.getClienteid());            
            ps.setInt(2,usu.getEquipotipo());            
            ps.setInt(3,usu.getEquipocod());                       
            ps.setString(4,usu.getEquipodes());            
            ps.setString(5,usu.getEquipomar());
            ps.setString(6,usu.getEquipomod());
            ps.execute();
            return true;
        } catch(SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();                
            } catch(SQLException e) {
                System.err.println(e);
            }        
        }            
    }
public boolean modificar(ClsEquipos usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE equipo SET clienteid=?,equipotipo=?,equipocod=?,equipodes=?,equipomar=?,equipomod=? WHERE equipoid=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,usu.getClienteid());            
            ps.setInt(2,usu.getEquipotipo());            
            ps.setInt(3,usu.getEquipocod());                       
            ps.setString(4,usu.getEquipodes());            
            ps.setString(5,usu.getEquipomar());
            ps.setString(6,usu.getEquipomod());
            ps.setInt(7,usu.getEquipoid());
            ps.execute();
            return true;
        } catch(SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();                
            } catch(SQLException e) {
                System.err.println(e);
            }        
        }            
    }
public boolean eliminar(ClsEquipos usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM equipo WHERE equipoid=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,usu.getEquipoid());            
            ps.execute();
            return true;
        } catch(SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();                
            } catch(SQLException e) {
                System.err.println(e);
            }        
        }            
    }
    public javax.swing.table.DefaultTableModel listar(String valor) {
        javax.swing.table.DefaultTableModel modelo;
        String[] titulos = {"Nro","Equipo","Codigo","Marca","Modelo","ID"};
        String[] registros = new String[6];
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT nom_equipo,equipocodigo,equipomarca,equipomodelo,equipoid FROM vw_equipos WHERE clienteid LIKE ? ORDER BY nom_equipo";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            //ps.setString(1, "%"+valor.toUpperCase()+"%");            
            ps.setString(1, "%"+valor+"%");
            ResultSet rs = ps.executeQuery();           
            int contador=0;
            while (rs.next()) {
                contador++;
                registros[0] = Integer.toString(contador);  //Numero                
                registros[1] = rs.getString(1);  //nom_equipo
                registros[2] = rs.getString(2);  // codigo
                registros[3] = rs.getString(3);  // marca
                registros[4] = rs.getString(4);  // modelo
                registros[5] = rs.getString(5);  // id
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL");
        }
        return modelo;
    }
public void llenarCombo(JComboBox box){
    DefaultComboBoxModel value;
    String sql = "SELECT tipequiid,tipequinom FROM tipo_equipo";
    try {
        PreparedStatement ps;
        ps=this.getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        value=new DefaultComboBoxModel();
        box.setModel(value);
        while (rs.next()) {
            value.addElement(new ClsTipoEquipo(rs.getInt(1),rs.getString(2)));
        }
        } catch(Exception e) {
            System.err.println(e);
        }  
}
public void llenarComboSeleccion(JComboBox box,int valor){
    DefaultComboBoxModel value;
    String sql = "SELECT tipequiid,tipequinom FROM tipo_equipo";
    try {
        PreparedStatement ps;
        ps=this.getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        value=new DefaultComboBoxModel();
        box.setModel(value);
        String seleccionado=""; 
        while (rs.next()) {
            int xx=rs.getInt(1);
            String temp=rs.getString(2);
            value.addElement(new ClsTipoEquipo(xx,temp));
            if(xx==valor){
                seleccionado=temp;
            }
        }
        value.setSelectedItem(seleccionado);
        } catch(Exception e) {
            System.err.println(e);
        }  
}
}
