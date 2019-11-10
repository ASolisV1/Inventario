
package CrudMarcas;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class QueryMarcas extends Conexion{

    public boolean save(ClsMarcas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO marca (marcod,marnom) VALUES (?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getCodMarca());
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
        String sql="UPDATE marca SET marnom=? WHERE marcod=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getNomMarca());
            ps.setInt(2,clase.getCodMarca());
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
        String sql="DELETE FROM marca WHERE marcod=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getCodMarca());            
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
        String sql="SELECT * FROM public.marca";
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ClsMarcas nuevo = new ClsMarcas();
                nuevo.setCodMarca(rs.getInt(1));
                nuevo.setNomMarca(rs.getString(2));
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
    
    
    public javax.swing.table.DefaultTableModel listar(String valor) {
        javax.swing.table.DefaultTableModel modelo;
        String[] titulos = {"Nro."+"Codigo","Nombre de la Marca"};
        String[] registros = new String[3];
        int contador=0;
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT codmarca,nommarca FROM marca";
        
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

    
    public ClsMarcas getByCod (int _cod){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;
        
        ClsMarcas nuevo=new ClsMarcas();
        
        String sql="SELECT * FROM public.marca WHERE marcod="+_cod;
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setCodMarca(rs.getInt(1));
                nuevo.setNomMarca(rs.getString(2));
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
    
    public ClsMarcas getByNom (String _nom){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;        
        String sql="SELECT * FROM public.marca WHERE marnom='"+_nom+"'";
        
        ClsMarcas nuevo=new ClsMarcas();
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                nuevo.setCodMarca(rs.getInt(1));
                nuevo.setNomMarca(rs.getString(2));
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
        ArrayList <ClsMarcas> preString = marcasArr();
        String arrNames[]= new String[preString.size()];
        
        for (int i = 0; i < arrNames.length; i++) {
                arrNames[i]=preString.get(i).getNomMarca();
        }
        return arrNames;
    }

}
