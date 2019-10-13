package Modelo;
// Extendemos Conexion agregando extends Conexion de esta forma
// poder utilizar de forma directa la conexion a la BD.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QueryUsuarios extends Conexion {
    // Metodo para validar Usuario y Password
    public boolean validar(ClsUsuarios usu) {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con = getConexion();
        String sql="SELECT usuarionom,usuariopassword FROM usuario WHERE usuarionom = ? AND usuariopassword=?";
        //String dato1="";
        //String dato2="";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getUsuarionom());            
            ps.setString(2,usu.getUsuariopassword());            
            rs=ps.executeQuery();
            if (rs.next()) {
                //encontro información correcta
            //    dato1 = rs.getString("usuarionom");
            //    dato2 = rs.getString("usuariopassword");
            //JOptionPane.showMessageDialog(null,"Correctamente Logeado"+dato1+" "+dato2);
                return true;
            } else {
                // no encontro ningun registro
                return false;
            }
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
    public boolean guardar(ClsUsuarios usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO usuario (usuarionom,usuariodni,usuariotipo,usuariopassword) VALUES (?,?,?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getUsuarionom());            
            ps.setInt(2,usu.getUsuariodni());            
            ps.setInt(3,usu.getUsuariotipo());            
            ps.setString(4,usu.getUsuariopassword());            
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
public boolean modificar(ClsUsuarios usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE usuario SET usuarionom=?,usuariodni=?,usuariotipo=?,usuariopassword=? WHERE usuarioid=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,usu.getUsuarionom());            
            ps.setInt(2,usu.getUsuariodni());            
            ps.setInt(3,usu.getUsuariotipo());            
            ps.setString(4,usu.getUsuariopassword());            
            ps.setInt(5,usu.getUsuarioid());            
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
public boolean eliminar(ClsUsuarios usu) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM usuario WHERE usuarioid=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,usu.getUsuarioid());            
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
    public javax.swing.table.DefaultTableModel listar(String valor) {
        javax.swing.table.DefaultTableModel modelo;
        String[] titulos = {"ID","Usuario","Password","DNI","IdTipo","Tipo"};
        String[] registros = new String[6];
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT usuarioid,usuarionom,usuariodni,usuariotipo,usuario_tipo.usutiponom,usuariopassword FROM usuario LEFT JOIN usuario_tipo on usuariotipo = usutipid WHERE usuarionom LIKE ? ORDER BY usuarionom";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            //ps.setString(1, "%"+valor.toUpperCase()+"%");            
            ps.setString(1, "%"+valor+"%");
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                registros[0] = rs.getString(1);  //usuarioid
                registros[1] = rs.getString(2);  // usuarionombre
                registros[2] = rs.getString(6);  // password
                registros[3] = rs.getString(3);  // dni
                registros[4] = rs.getString(4);  // usuariotipoid
                registros[5] = rs.getString(5);  // usutipnom
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL");
        }
        return modelo;
    }
public void llenarCombo(JComboBox box){
    DefaultComboBoxModel value;
    String sql = "SELECT usutipid,usutiponom,usutipcod FROM usuario_tipo";
    try {
        PreparedStatement ps;
        ps=this.getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        value=new DefaultComboBoxModel();
        box.setModel(value);
        while (rs.next()) {
            value.addElement(new ClsTipo(rs.getInt(1),rs.getString(2),rs.getInt(3)));
        }
        } catch(Exception e) {
            System.err.println(e);
        }  
}
public void llenarComboSeleccion(JComboBox box,int valor){
    DefaultComboBoxModel value;
    String sql = "SELECT usutipid,usutiponom,usutipcod FROM usuario_tipo";
    try {
        PreparedStatement ps;
        ps=this.getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        value=new DefaultComboBoxModel();
        box.setModel(value);
        String seleccionado=""; 
        while (rs.next()) {
            int xx=rs.getInt(1);
            String temp=rs.getString(2);
            value.addElement(new ClsTipo(xx,temp,rs.getInt(3)));
            if(xx==valor){
                seleccionado=temp;
            }
        }
        value.setSelectedItem(seleccionado);
        } catch(Exception e) {
            System.err.println(e);
        }  
}
}
