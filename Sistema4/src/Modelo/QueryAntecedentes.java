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

public class QueryAntecedentes extends Conexion {
    // Metodo para validar Usuario y Password
    public boolean guardar(ClsAntecedentes usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO antecedentes (antnom,antdes,equipoid,antsolucion) VALUES (?,?,?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getAntnom());            
            ps.setString(2,usu.getAntdes());                       
            ps.setInt(3,usu.getEquipoid());            
            ps.setString(4,usu.getAntsolucion());
            ps.execute();
            return true;
        } catch(SQLException e) {
            System.out.println("se guardaron correctamente los datos de antecedentes");
            return false;
        } finally {
            try {
                con.close();                
            } catch(SQLException e) {
                System.out.println("Error al guardar antecedente ");
            }        
        }            
    }
public boolean modificar(ClsAntecedentes usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE antecedentes SET antnom=?,antdes=?,equipoid=?,antsolucion=? WHERE antid=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getAntnom());            
            ps.setString(2,usu.getAntdes());                       
            ps.setInt(3,usu.getEquipoid());            
            ps.setString(4,usu.getAntsolucion());
            ps.setInt(5,usu.getAntid());
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
public boolean eliminar(ClsAntecedentes usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM antecedentes WHERE antid=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,usu.getAntid());            
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
        String[] titulos = {"Nro","Antecedente","Id Equipo","Solucion"};
        String[] registros = new String[6];
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT antnom,equipoid,antsolucion FROM antecedentes WHERE antid LIKE ? ORDER BY antnom";
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
                registros[1] = rs.getString(1);  //nombre
                registros[2] = rs.getString(2);  // idequipo
                registros[3] = rs.getString(3);  // solucion
                registros[4] = rs.getString(4);  // id
                
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL");
        }
        return modelo;
    }

}
