package Salidas;
// Extendemos Conexion agregando extends Conexion de esta forma
// poder utilizar de forma directa la conexion a la BD.
import MantProductos.*;
import Conexion.Conexion;
import Inventario.QueryInventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class QuerySalidas extends Conexion {

    QueryProductos proQ = new QueryProductos();
    QueryInventario invQ = new QueryInventario();
    
    public ArrayList <ClsSalidas> marcasArr (){
        Statement ps=null;
        Connection con = getConexion();
        ResultSet rs= null;
        
        ArrayList <ClsSalidas> marcas = new ArrayList <ClsSalidas>();
        String sql="SELECT * FROM public.salida";
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ClsSalidas nuevo = new ClsSalidas();
                nuevo.setSalcod(rs.getInt(1));
                nuevo.setSaldoc(rs.getString(2));
                nuevo.setSalprodcod(rs.getInt(3));
                nuevo.setSalcant(rs.getInt(4));
                nuevo.setSaldia(rs.getInt(5));
                nuevo.setSalmes(rs.getInt(6));
                nuevo.setSalanio(rs.getInt(7));
                nuevo=toStringNom(nuevo);
                marcas.add(nuevo);
            }
        rs.close();
        ps.close();
        con.close();    
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR cargando las clases");
        }        
        return marcas;
    }
    
    private ClsSalidas toStringNom(ClsSalidas _mod){
        _mod.setSalprodnom(proQ.getByCod(_mod.getSalprodcod()).getProNom());
        return _mod;
    }
    
    
    public boolean save(ClsSalidas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO salida (saldoc, salprodcod, salcant,"+ 
                "saldia, salmes, salanio) VALUES (?,?,?,?,?,?)";
        if(!(clase.getSalcant()>invQ.getStock(clase.getSalprodcod()))){
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getSaldoc());
            ps.setInt(2,clase.getSalprodcod());
            ps.setInt(3,clase.getSalcant());
            ps.setInt(4,clase.getSaldia());
            ps.setInt(5,clase.getSalmes());
            ps.setInt(6,clase.getSalanio());
            invQ.lessStock(clase.getSalprodcod(), clase.getSalcant());
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
        else{
            JOptionPane.showMessageDialog(null, "Error salida, mayor al stock");
            return false;
        }
    }
    
     public boolean delete(ClsSalidas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM salida WHERE salcod=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getSalcod());            
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
    
     public boolean update(ClsSalidas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE salida SET saldoc=?, salprodcod=?, salcant=?, saldia=?"+
                ", salmes=?, salanio=? WHERE salcod='?'";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getSaldoc());
            ps.setInt(2,clase.getSalprodcod());
            ps.setInt(3,clase.getSalcant());
            ps.setInt(4,clase.getSaldia());
            ps.setInt(5,clase.getSalmes());
            ps.setInt(6,clase.getSalanio());            
            ps.setInt(7,clase.getSalcod());
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
     
     public ClsSalidas getByCod (int _cod){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;
        
        ClsSalidas nuevo=new ClsSalidas();
        
        String sql="SELECT * FROM public.salida WHERE salcod="+_cod;
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setSalcod(rs.getInt(1));
                nuevo.setSaldoc(rs.getString(2));
            }
        rs.close();
        ps.close();
        con.close();    
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR cargando las clases");
        }        
        return nuevo;
    }
    
    public ClsSalidas getByNom (String _nom){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;        
        String sql="SELECT * FROM public.salida WHERE saldoc='"+_nom+"'";
        
        ClsSalidas nuevo=new ClsSalidas();
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setSalcod(rs.getInt(1));
                nuevo.setSaldoc(rs.getString(2));
            }
        rs.close();
        ps.close();
        con.close();    
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR cargando las clases");
        }        
        return nuevo;
    }
     
    
    public String[] arrString(){
        ArrayList <ClsSalidas> preString = marcasArr();
        String arrNames[]= new String[preString.size()];
        
        for (int i = 0; i < arrNames.length; i++) {
                arrNames[i]=preString.get(i).getSaldoc();
        }
        return arrNames;
    }
}
