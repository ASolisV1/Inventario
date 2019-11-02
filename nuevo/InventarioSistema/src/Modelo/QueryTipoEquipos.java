package Modelo;
// Extendemos Conexion agregando extends Conexion de esta forma
// poder utilizar de forma directa la conexion a la BD.
import Conexion.Conexion;
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

public class QueryTipoEquipos extends Conexion {
    // Metodo para validar Tipos equipo
    public boolean guardar(ClsTipoEquipo usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO tipo_equipo (tipequinom) VALUES (?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getTipequinom());            
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
public boolean modificar(ClsTipoEquipo usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE tipo_equipo SET tipequinom=? WHERE tipequiid=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getTipequinom());            
            ps.setInt(2,usu.getTipequiid());
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
public boolean eliminar(ClsTipoEquipo usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM tipo_equipo WHERE tipequiid=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,usu.getTipequiid());            
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
        String[] titulos = {"Nº","Tipo","ID"};
        String[] registros = new String[3];
        int contador =0;
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT tipequiid,tipequinom FROM tipo_equipo WHERE tipequinom LIKE ? ORDER BY tipequinom";
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
                registros[2] = rs.getString(1);  //Id
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL de Listar");
        }
        return modelo;
    }

}
