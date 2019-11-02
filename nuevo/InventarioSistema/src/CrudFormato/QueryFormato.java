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
        String sql="INSERT INTO formato (codformato,nomformato) VALUES (?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getCodFor());
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
        String sql="UPDATE formato SET nomformato=? WHERE codformato=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getNomFor());
            ps.setString(2,clase.getCodFor());
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
        String sql="DELETE FROM formato WHERE codformato=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getCodFor());            
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
                nuevo.setCodFor(rs.getString(1));
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
    
}
