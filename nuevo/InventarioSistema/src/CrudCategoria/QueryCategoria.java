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
        String sql="INSERT INTO categoria (codcategoria,nomcategoria) VALUES (?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getCodCateg());
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
        String sql="UPDATE categoria SET nomcategoria=? WHERE codcategoria=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getNomCateg());
            ps.setString(2,clase.getCodCateg());
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
        String sql="DELETE FROM categoria WHERE codcategoria=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getCodCateg());            
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
                nuevo.setCodCateg(rs.getString(1));
                nuevo.setNomCateg(rs.getString(2));
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
    
}
