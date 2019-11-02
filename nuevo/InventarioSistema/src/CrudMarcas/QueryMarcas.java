
package CrudMarcas;

import Conexion.Conexion;
import MantProductos.ClsProductos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class QueryMarcas extends Conexion{

    public boolean save(ClsMarcas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO marcas (codmarca,nommarca) VALUES (?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getCodMarca());
            ps.setString(2,clase.getNomMarca());
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
    
    public boolean update(ClsMarcas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE marcas SET nommarca=? WHERE codmarca=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getNomMarca());
            ps.setString(2,clase.getCodMarca());
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
    
    public boolean delete(ClsMarcas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM marcas WHERE codmarca=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getCodMarca());            
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
    
    public ArrayList <ClsMarcas> marcasArr (){
        Statement ps=null;
        Connection con = getConexion();
        ResultSet rs= null;
        
        ArrayList <ClsMarcas> marcas = new ArrayList <ClsMarcas>();
        String sql="SELECT * FROM public.marcas";
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ClsMarcas nuevo = new ClsMarcas();
                nuevo.setCodMarca(rs.getString(1));
                nuevo.setNomMarca(rs.getString(2));
                marcas.add(nuevo);
            }
        rs.close();
        ps.close();
        con.close();    
        } catch (SQLException e) {
                System.err.println("ERROR cargando las clases");
        }        
        return marcas;
    }
    
    
    public javax.swing.table.DefaultTableModel listar(String valor) {
        javax.swing.table.DefaultTableModel modelo;
        String[] titulos = {"Nro."+"Codigo","Nombre de la Marca"};
        String[] registros = new String[3];
        int contador=0;
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT codmarca,nommarca FROM marcas";
        
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
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL LISTARRRR");
        }
        return modelo;
    }

    
    
    public ClsMarcas devuelveCliente(String idMarca) {
        ClsMarcas cliente = new ClsMarcas();
        String sql = "SELECT * FROM cliente WHERE codmarca=?";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            ps.setString(1, idMarca);
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                cliente.setCodMarca(rs.getString("codmarca").trim());
                cliente.setNomMarca(rs.getString("nommarca").trim());
            }
            
        } catch (SQLException ex) {
            System.out.println("Error con el SQL");
        }
        return cliente;
    }
    
    public String devuelveNombreCliente(String idMarca) {
        String marcaNombre = new String();
        String sql = "SELECT nommarca FROM marcas WHERE codmarca=?";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            ps.setString(1, idMarca);
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                marcaNombre = rs.getString("nommarca").trim();
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL");
        }
        return marcaNombre;
    }
    
}
