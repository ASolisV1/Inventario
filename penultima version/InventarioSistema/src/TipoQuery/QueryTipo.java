package TipoQuery;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryTipo extends Conexion{
    
    public ArrayList <ClsTipo> marcasArr (){
        Statement ps=null;
        Connection con = getConexion();
        ResultSet rs= null;
        
        ArrayList <ClsTipo> marcas = new ArrayList <ClsTipo>();
        String sql="SELECT * FROM public.tipo";
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ClsTipo nuevo = new ClsTipo();
                nuevo.setTipcod(rs.getInt(1));
                nuevo.setTipnom(rs.getString(2));
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
    
    public ClsTipo getByCod (int _cod){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;
        
        ClsTipo nuevo=new ClsTipo();
        
        String sql="SELECT * FROM public.tipo WHERE tipcod="+_cod;
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setTipcod(rs.getInt(1));
                nuevo.setTipnom(rs.getString(2));
            }
        rs.close();
        ps.close();
        con.close();    
        
        } catch (SQLException e) {
                System.err.println("ERROR cargando las clases");
        }        
        return nuevo;
    }
    
    public ClsTipo getByNom (String _nom){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;        
        
        ClsTipo nuevo = new ClsTipo();
        String sql="SELECT * FROM public.tipo WHERE tipnom='"+_nom+"'";
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setTipcod(rs.getInt(1));
                nuevo.setTipnom(rs.getString(2));
            }
            
        rs.close();
        ps.close();
        con.close();    
        
        } catch (SQLException e) {
                System.err.println("ERROR cargando las clases");
        }        
        return nuevo;
    }
    
    public String[] arrString(){
        ArrayList <ClsTipo> preString = marcasArr();
        String arrNames[]= new String[preString.size()];
        
        for (int i = 0; i < arrNames.length; i++) {
                arrNames[i]=preString.get(i).getTipnom();
        }
        return arrNames;
    }
    
}

