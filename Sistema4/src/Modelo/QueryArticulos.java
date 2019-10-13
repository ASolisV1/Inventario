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

public class QueryArticulos extends Conexion {

    //Metodo para guardar articulos :3    
    public boolean guardar(ClsArticulos cli) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO articulo (articulonom,articulocod,articulodes,articulocosto) VALUES (?,?,?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,cli.getArticulonom());            
            ps.setInt(2,cli.getArticulocod());            
            ps.setString(3,cli.getArticulodes());            
            ps.setInt(4,cli.getArticulocosto());   
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
public boolean modificar(ClsArticulos cli) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE articulo SET articulonom=?,articulocod=?,articulodes=?,articulocosto=? WHERE articuloid=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,cli.getArticulonom());            
            ps.setInt(2,cli.getArticulocod());            
            ps.setString(3,cli.getArticulodes()); 
            ps.setInt(4,cli.getArticulocosto());            
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
public boolean eliminar(ClsArticulos cli) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM articulo WHERE articuloid=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,cli.getArticuloid());            
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
        String[] titulos = {"ID","Articulo","Codigo","Descripccion","Costo"};
        String[] registros = new String[5];
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT articuloid,articulonom,articulocod,articulodes,articulocosto FROM articulo WHERE articulonom LIKE ? ORDER BY articulonom";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            //ps.setString(1, "%"+valor.toUpperCase()+"%");            
            ps.setString(1, "%"+valor+"%");
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                registros[0] = rs.getString(1);  //articuloid
                registros[1] = rs.getString(2);  // articulonombre
                registros[2] = rs.getString(3);  // articulocodigo
                registros[3] = rs.getString(4);  // articulodescripcion
                registros[4] = rs.getString(5);  // articulocosto
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL de listar");
        }
        return modelo;
    }

}
