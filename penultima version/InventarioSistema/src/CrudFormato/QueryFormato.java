/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudFormato;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryFormato extends Conexion{

    public boolean save(ClsFormato clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO formato (forcod,fornom) VALUES (?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getCodFor());
            ps.setString(2,clase.getNomFor());
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
    
    public boolean update(ClsFormato clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE formato SET fornom=? WHERE forcod=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getNomFor());
            ps.setInt(2,clase.getCodFor());
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
    
    public boolean delete(ClsFormato clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM formato WHERE forcod=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getCodFor());            
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
    
    public ArrayList <ClsFormato> marcasArr (){
        Statement ps=null;
        Connection con = getConexion();
        ResultSet rs= null;
        
        ArrayList <ClsFormato> marcas = new ArrayList <ClsFormato>();
        String sql="SELECT * FROM public.formato";
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ClsFormato nuevo = new ClsFormato();
                nuevo.setCodFor(rs.getInt(1));
                nuevo.setNomFor(rs.getString(2));
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

    public ClsFormato getByCod (int _cod){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;
        
        ClsFormato nuevo=new ClsFormato();
        
        String sql="SELECT * FROM public.formato WHERE forcod="+_cod;
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setCodFor(rs.getInt(1));
                nuevo.setNomFor(rs.getString(2));
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
    
    public ClsFormato getByNom (String _nom){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;        
        String sql="SELECT * FROM public.formato WHERE fornom='"+_nom+"'";
        ClsFormato nuevo=new ClsFormato();
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setCodFor(rs.getInt(1));
                nuevo.setNomFor(rs.getString(2));
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
        ArrayList <ClsFormato> preString = marcasArr();
        String arrNames[]= new String[preString.size()];
        
        for (int i = 0; i < arrNames.length; i++) {
                arrNames[i]=preString.get(i).getNomFor();
        }
        return arrNames;
    }
    
}
