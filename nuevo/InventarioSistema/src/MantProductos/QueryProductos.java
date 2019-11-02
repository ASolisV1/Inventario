package MantProductos;
// Extendemos Conexion agregando extends Conexion de esta forma
// poder utilizar de forma directa la conexion a la BD.
import Modelo.*;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class QueryProductos extends Conexion {
    public boolean guardar(ClsProductos clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO cliente (clientecorr,clientedir,clientecod,clientetel,personaid) VALUES (?,?,?,?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getClientecorr());
            ps.setString(2,clase.getClientedir());
            ps.setInt(3,clase.getClientecod());
            ps.setString(4,clase.getClientetel());
            ps.setInt(5,clase.getPersonaid());            
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
public boolean modificar(ClsProductos clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE cliente SET clientecorr=?,clientedir=?,clientecod=?,clientetel=?,personaid=? WHERE clienteid=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getClientecorr());
            ps.setString(2,clase.getClientedir());
            ps.setInt(3,clase.getClientecod());
            ps.setString(4,clase.getClientetel());
            ps.setInt(5,clase.getPersonaid());            
            ps.setInt(6,clase.getClienteid());   
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
public boolean eliminar(ClsProductos clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM cliente WHERE clienteid=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getClienteid());            
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
        String[] titulos = {"Nro","Apellidos y Nombres","Telefono","Correo Electronico","Id"};
        String[] registros = new String[5];
        int contador=0;
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT nom_per,clientetel,clientecorr,clienteid FROM vw_clientes WHERE nom_per LIKE ? ORDER BY nom_per";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            //ps.setString(1, "%"+valor.toUpperCase()+"%");            
            ps.setString(1, "%"+valor+"%");
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                contador++;
                registros[0] = Integer.toString(contador);  //Numero
                registros[1] = rs.getString(1).trim();  //nom_per
                registros[2] = rs.getString(2).trim();  //Telefono                
                registros[3] = rs.getString(3).trim();  //Correo
                registros[4] = rs.getString(4).trim();  //Correo
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL LISTARRRR");
        }
        return modelo;
    }

    public ClsProductos devuelveCliente(int idPersona) {
        ClsProductos cliente = new ClsProductos();
        String sql = "SELECT * FROM cliente WHERE clienteid=?";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            ps.setInt(1, idPersona);
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                cliente.setClientecorr(rs.getString("clientecorr").trim());
                cliente.setClientedir(rs.getString("clientedir").trim());
                cliente.setClientetel(rs.getString("clientetel").trim());
                cliente.setClientecod(rs.getInt("clientecod"));
                cliente.setPersonaid(rs.getInt("personaid"));
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL");
        }
        return cliente;
    }
public String devuelveNombreCliente(int idPersona) {
        String clienteNombre = new String();
        String sql = "SELECT nom_per FROM vw_clientes WHERE clienteid=?";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            ps.setInt(1, idPersona);
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                clienteNombre = rs.getString("nom_per").trim();
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL");
        }
        return clienteNombre;
    }
    public DefaultComboBoxModel getLista(String cadenaEscrita){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        String sql = "SELECT nom_per FROM vw_personas WHERE nom_per LIKE ? ORDER BY nom_per LIMIT 15";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            ps.setString(1, "%"+cadenaEscrita.toUpperCase()+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelo.addElement(rs.getString("nom_per").trim());
            }
        } catch(Exception e) {
            System.err.println(e);
        }  
     return modelo;
    }
    public String[] buscar(String valor){
        String[] datos = new String[2];
//        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        String sql = "SELECT id,nom_per FROM vw_personas WHERE nom_per like ?";
        try {
        PreparedStatement ps;
        ps=this.getConexion().prepareStatement(sql);
        ps.setString(1, "%"+valor.toUpperCase()+"%");
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString("id");
                datos[1] = rs.getString("nom_per");
            }
        } catch (SQLException ex) {
            return null;
        }
        return datos;
    }    
    public javax.swing.table.DefaultTableModel listarEquipos(int valor) {
        javax.swing.table.DefaultTableModel modelo;
        String[] titulos = {"Nro","Equipo","Marca","Modelo","Id"};
        String[] registros = new String[5];
        int contador=0;
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT tipequinom,equipomar,equipomod,equipoid FROM vw_equipos WHERE clienteid=? ORDER BY clienteid";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            //ps.setString(1, "%"+valor.toUpperCase()+"%");            
            ps.setInt(1, valor);
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                contador++;
                registros[0] = Integer.toString(contador);  //Numero
                registros[1] = rs.getString(1).trim();  //nom_per
                registros[2] = rs.getString(2).trim();  //Telefono                
                registros[3] = rs.getString(3).trim();  //Correo
                registros[4] = rs.getString(4).trim();  //Correo
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL LISTARRRR de equipos de cliente");
        }
        return modelo;
    }

}
