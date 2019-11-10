package Inventario;

import MantProductos.QueryProductos;
import java.sql.Connection;
import Conexion.Conexion;
import MantProductos.ClsProductos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryInventario extends Conexion{
    private QueryProductos proQ = new QueryProductos();
    
    public QueryInventario() {};
    
    public ArrayList <ClsInventario> marcasArr (){
        Statement ps=null;
        Connection con = getConexion();
        ResultSet rs= null;
        
        ArrayList <ClsInventario> marcas = new ArrayList <ClsInventario>();
        String sql="SELECT * FROM public.inventario";
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ClsInventario nuevo = new ClsInventario();
                nuevo.setCodinv(rs.getInt(1));
                nuevo.setCodprod(rs.getInt(2));
                nuevo.setStock(rs.getInt(3));
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
    
    private ClsInventario toStringNom(ClsInventario _mod){
        _mod.setProNom(proQ.getByCod(_mod.getCodprod()).getProNom());
        _mod.setProCatCod(proQ.getByCod(_mod.getCodprod()).getProCatNom());
        _mod.setProCatNom(proQ.getCatQ().getByCod(_mod.getProCatCod()).getNomCateg());
        _mod.setProMarCod(proQ.getByCod(_mod.getCodprod()).getProMarNom());
        _mod.setProMarNom(proQ.getMarQ().getByCod(_mod.getProMarCod()).getNomMarca());
        _mod.setProForCod(proQ.getByCod(_mod.getCodprod()).getProForNom());
        _mod.setProForNom(proQ.getForQ().getByCod(_mod.getProForCod()).getNomFor());
        _mod.setProTipCod(proQ.getByCod(_mod.getCodprod()).getProTipNom());
        _mod.setProTipNom(proQ.getTipQ().getByCod(_mod.getProTipCod()).getTipnom());
        _mod.setProPreVen(proQ.getByCod(_mod.getCodprod()).getProPreVen());
        return _mod;
    }
    
       
    public boolean save(ClsProductos clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO inventario (codprod, codstock) VALUES (?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getProCod());
            ps.setInt(2,0);
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
    
     public boolean delete(ClsProductos clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM inventario WHERE codprod=? ";
         try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getProCod());            
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
    
    public boolean addStock(int codProd, int newStock){
        PreparedStatement ps=null;
        Connection con = getConexion();
        int nStock = newStock+getStock(codProd);
        String sql="UPDATE inventario SET codstock=? WHERE codprod=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,nStock);
            ps.setInt(2,codProd);
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
    
    public boolean lessStock(int codProd, int newStock){
        PreparedStatement ps=null;
        Connection con = getConexion();
        int nStock = getStock(codProd)-newStock;
        String sql="UPDATE inventario SET codstock=? WHERE codprod=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,nStock);
            ps.setInt(2,codProd);
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
    
    public int getStock(int _codProd){
        int stock=0;
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;
        
        String sql="SELECT * FROM public.inventario WHERE codprod="+_codProd;
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                stock=rs.getInt(3);                
            }
        rs.close();
        ps.close();
        con.close();    
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR cargando las clases");
        }        
        return stock;
    }
    
    public String[] arrString(){
        ArrayList <ClsInventario> preString = marcasArr();
        String arrNames[]= new String[preString.size()];
        
        for (int i = 0; i < arrNames.length; i++) {
                arrNames[i]=preString.get(i).getProNom();
        }
        return arrNames;
    }
    
}
