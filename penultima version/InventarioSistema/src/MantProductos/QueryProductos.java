package MantProductos;

import Conexion.Conexion;
import CrudCategoria.QueryCategoria;
import CrudFormato.QueryFormato;
import CrudMarcas.QueryMarcas;
import Inventario.QueryInventario;
import TipoQuery.QueryTipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryProductos extends Conexion {
    
    private QueryMarcas marQ = new QueryMarcas();
    private QueryCategoria catQ = new QueryCategoria();
    private QueryFormato forQ = new QueryFormato();
    private QueryTipo tipQ = new QueryTipo();
  
    public QueryProductos(){}    
    
    public ArrayList <ClsProductos> marcasArr (){
        Statement ps=null;
        Connection con = getConexion();
        ResultSet rs= null;
        
        ArrayList <ClsProductos> marcas = new ArrayList <ClsProductos>();
        String sql="SELECT * FROM public.articulo";
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                ClsProductos nuevo = new ClsProductos();
                nuevo.setProCod(rs.getInt(1));
                nuevo.setProCatNom(rs.getInt(2));
                nuevo.setProMarNom(rs.getInt(3));
                nuevo.setProForNom(rs.getInt(4));
                nuevo.setProTipNom(rs.getInt(5));
                nuevo.setProNom(rs.getString(6));
                nuevo.setProPreVen(rs.getDouble(7));
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
    
    private ClsProductos toStringNom(ClsProductos _mod){
        _mod.setProCatNom2(catQ.getByCod(_mod.getProCatNom()).getNomCateg());
        _mod.setProMarNom2(marQ.getByCod(_mod.getProMarNom()).getNomMarca());
        _mod.setProForNom2(forQ.getByCod(_mod.getProForNom()).getNomFor());
        _mod.setProTipNom2(tipQ.getByCod(_mod.getProTipNom()).getTipnom());
        return _mod;
    }
    
    public boolean save(ClsProductos clase) {
        QueryInventario invQ = new QueryInventario();
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO articulo (artcod, artcatcod, artmarcod, artforcod,"+ 
                "arttipcod, artnom, artprecioart) VALUES (?,?,?,?,?,?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getProCod());
            ps.setInt(2,clase.getProCatNom());
            ps.setInt(3,clase.getProMarNom());
            ps.setInt(4,clase.getProForNom());
            ps.setInt(5,clase.getProTipNom());
            ps.setString(6,clase.getProNom());
            ps.setDouble(7,clase.getProPreVen());            
            ps.execute();
            invQ.save(clase);
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
        QueryInventario invQ = new QueryInventario();
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM articulo WHERE artcod=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getProCod());            
            ps.execute();
            invQ.delete(clase);
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
    
     public boolean update(ClsProductos clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE articulo SET artcatcod=?, artmarcod=?, artforcod=?, arttipcod=?"+
                ", artnom=?, artprecioart=? WHERE artcod=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getProCatNom());
            ps.setInt(2,clase.getProMarNom());
            ps.setInt(3,clase.getProForNom());
            ps.setInt(4,clase.getProTipNom());
            ps.setString(5,clase.getProNom());
            ps.setDouble(6,clase.getProPreVen());       
            ps.setInt(7,clase.getProCod());
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
     
     public ClsProductos getByCod (int _cod){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;
        
        ClsProductos nuevo=new ClsProductos();
        
        String sql="SELECT * FROM public.articulo WHERE artcod="+_cod;
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
                 nuevo.setProCod(rs.getInt(1));
                nuevo.setProCatNom(rs.getInt(2));
                nuevo.setProMarNom(rs.getInt(3));
                nuevo.setProForNom(rs.getInt(4));
                nuevo.setProTipNom(rs.getInt(5));
                nuevo.setProNom(rs.getString(6));
                nuevo.setProPreVen(rs.getDouble(7));
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
    
    public ClsProductos getByNom (String _nom){
        Statement ps;
        Connection con = getConexion();
        ResultSet rs;        
        String sql="SELECT * FROM public.articulo WHERE artnom='"+_nom+"'";
        
        ClsProductos nuevo=new ClsProductos();
        
        try {
            ps=con.createStatement();
            rs=ps.executeQuery(sql);
            while(rs.next()){
               nuevo.setProCod(rs.getInt(1));
                nuevo.setProCatNom(rs.getInt(2));
                nuevo.setProMarNom(rs.getInt(3));
                nuevo.setProForNom(rs.getInt(4));
                nuevo.setProTipNom(rs.getInt(5));
                nuevo.setProNom(rs.getString(6));
                nuevo.setProPreVen(rs.getInt(7));
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
        ArrayList <ClsProductos> preString = marcasArr();
        String arrNames[]= new String[preString.size()];
        
        for (int i = 0; i < arrNames.length; i++) {
                arrNames[i]=preString.get(i).getProNom();
        }
        return arrNames;
    }
    
    
     
    public QueryMarcas getMarQ() {
        return marQ;
    }

    public void setMarQ(QueryMarcas marQ) {
        this.marQ = marQ;
    }

    public QueryCategoria getCatQ() {
        return catQ;
    }

    public void setCatQ(QueryCategoria catQ) {
        this.catQ = catQ;
    }

    public QueryFormato getForQ() {
        return forQ;
    }

    public void setForQ(QueryFormato forQ) {
        this.forQ = forQ;
    }

    public QueryTipo getTipQ() {
        return tipQ;
    }

    public void setTipQ(QueryTipo tipQ) {
        this.tipQ = tipQ;
    }
    
    
    
    
}
