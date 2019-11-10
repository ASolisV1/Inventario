package Entradas;
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

public class QueryEntradas extends Conexion {

    QueryProductos proQ = new QueryProductos();
    QueryInventario invQ = new QueryInventario();
    
    public ArrayList <ClsEntradas> marcasArr (){
        Statement ps=null;
        Connection con = getConexion();
        ResultSet rs= null;
        
        ArrayList <ClsEntradas> marcas = new ArrayList <ClsEntradas>();
        String sql="SELECT * FROM public.entrada";
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ClsEntradas nuevo = new ClsEntradas();
                nuevo.setEntcod(rs.getInt(1));
                nuevo.setEntdoc(rs.getString(2));
                nuevo.setEntprodcod(rs.getInt(3));
                nuevo.setEntcant(rs.getInt(4));
                nuevo.setEntdia(rs.getInt(5));
                nuevo.setEntmes(rs.getInt(6));
                nuevo.setEntanio(rs.getInt(7));
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
    
    private ClsEntradas toStringNom(ClsEntradas _mod){
        _mod.setEntprodnom(proQ.getByCod(_mod.getEntprodcod()).getProNom());
        return _mod;
    }
    
    
    public boolean save(ClsEntradas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO entrada (entdoc, entprodcod, entcant,"+ 
                "entdia, entmes, entanio) VALUES (?,?,?,?,?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getEntdoc());
            ps.setInt(2,clase.getEntprodcod());
            ps.setInt(3,clase.getEntcant());
            ps.setInt(4,clase.getEntdia());
            ps.setInt(5,clase.getEntmes());
            ps.setInt(6,clase.getEntanio());
            ps.execute();
            invQ.addStock(clase.getEntprodcod(), clase.getEntcant());
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
    
     public boolean delete(ClsEntradas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM entrada WHERE entcod=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getEntcod());            
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
    
     public boolean update(ClsEntradas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE entrada SET entdoc=?, entprodcod=?, entcant=?, entdia=?"+
                ", entmes=?, entanio=? WHERE entcod=\'?\'";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getEntdoc());
            ps.setInt(2,clase.getEntprodcod());
            ps.setInt(3,clase.getEntcant());
            ps.setInt(4,clase.getEntdia());
            ps.setInt(5,clase.getEntmes());
            ps.setInt(6,clase.getEntanio());            
            ps.setInt(7,clase.getEntcod());
            ps.execute();
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();                
            } catch(SQLException e) {
                e.printStackTrace();
                System.err.println(e);
            }        
        }            
    }
     
     public ClsEntradas getByCod (int _cod){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;
        
        ClsEntradas nuevo=new ClsEntradas();
        
        String sql="SELECT * FROM public.entrada WHERE entcod="+_cod;
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setEntcod(rs.getInt(1));
                nuevo.setEntdoc(rs.getString(2));
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
    
    public ClsEntradas getByNom (String _nom){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;        
        String sql="SELECT * FROM public.entrada WHERE entdoc='"+_nom+"'";
        
        ClsEntradas nuevo=new ClsEntradas();
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setEntcod(rs.getInt(1));
                nuevo.setEntdoc(rs.getString(2));
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
        ArrayList <ClsEntradas> preString = marcasArr();
        String arrNames[]= new String[preString.size()];
        
        for (int i = 0; i < arrNames.length; i++) {
                arrNames[i]=preString.get(i).getEntdoc();
        }
        return arrNames;
    }
}
