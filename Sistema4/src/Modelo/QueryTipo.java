package Modelo;
// Extendemos Conexion agregando extends Conexion de esta forma
// poder utilizar de forma directa la conexion a la BD.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QueryTipo extends Conexion {
    // Metodo para validar Usuario y Password
    public boolean guardar(ClsTipo usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO usuario_tipo (usutiponom,usutipcod) VALUES (?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getUsutiponom());            
            ps.setInt(2,usu.getUsutipcod());            
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
public boolean modificar(ClsTipo usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE usuario_tipo SET usutiponom=?,usutipcod=? WHERE usutipid=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getUsutiponom());            
            ps.setInt(2,usu.getUsutipcod());            
            ps.setInt(3,usu.getUsutipid());            
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
public boolean eliminar(ClsTipo usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM usuario_tipo WHERE usutipid=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,usu.getUsutipid());            
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
        String[] titulos = {"Nº","Tipo","Nivel","ID"};
        String[] registros = new String[4];
        int contador =0;
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT usutipid,usutiponom,usutipcod FROM usuario_tipo WHERE usutiponom LIKE ? ORDER BY usutiponom";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            //ps.setString(1, "%"+valor.toUpperCase()+"%");            
            ps.setString(1, "%"+valor+"%");
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                contador++;
                registros[0] = Integer.toString(contador);  //nombre
                registros[1] = rs.getString(2);  //nombre
                registros[2] = rs.getString(3);  //Nivel
                registros[3] = rs.getString(1);  //Id
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL de Listar Tipos");
        }
        return modelo;
    }

}
