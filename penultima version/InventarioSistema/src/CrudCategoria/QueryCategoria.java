/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudCategoria;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryCategoria extends Conexion{

    public boolean save(ClsCategoria clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO categoria (catcod,catnom) VALUES (?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getCodCateg());
            ps.setString(2,clase.getNomCateg());
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
    
    public boolean update(ClsCategoria clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE categoria SET catnom=? WHERE catcod=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getNomCateg());
            ps.setInt(2,clase.getCodCateg());
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
    
    public boolean delete(ClsCategoria clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM categoria WHERE catcod=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getCodCateg());            
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
    
    public ArrayList <ClsCategoria> marcasArr (){
        Statement ps=null;
        Connection con = getConexion();
        ResultSet rs= null;
        
        ArrayList <ClsCategoria> marcas = new ArrayList <ClsCategoria>();
        String sql="SELECT * FROM public.categoria";
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ClsCategoria nuevo = new ClsCategoria();
                nuevo.setCodCateg(rs.getInt(1));
                nuevo.setNomCateg(rs.getString(2));
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
    
    public ClsCategoria getByCod (int _cod){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;
        
        
        ClsCategoria nuevo=new ClsCategoria();
        String sql="SELECT * FROM public.categoria WHERE catcod="+_cod;
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setCodCateg(rs.getInt(1));
                nuevo.setNomCateg(rs.getString(2));
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
    
    public ClsCategoria getByNom (String _nom){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;        
        String sql="SELECT * FROM public.categoria WHERE catnom='"+_nom+"'";
        
        ClsCategoria nuevo=new ClsCategoria();
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setCodCateg(rs.getInt(1));
                nuevo.setNomCateg(rs.getString(2));
            }
        rs.close();
        ps.close();
        con.close();    
         
        } catch (SQLException e) {
            //Aca angie modificar, en mi caso yo puse en mi tabla categoria el codigo como String
            //Solo borras el Integer.toString creo,            
                e.printStackTrace();
                System.err.println("ERROR cargando las clases");
        }              
        return nuevo;
    }
    
    public String[] arrString(){
        ArrayList <ClsCategoria> preString = marcasArr();
        String arrNames[]= new String[preString.size()];
        
        for (int i = 0; i < arrNames.length; i++) {
                arrNames[i]=preString.get(i).getNomCateg();
        }
        return arrNames;
    }
    
    
}
