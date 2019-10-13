package Modelo;
// Extendemos Conexion agregando extends Conexion de esta forma
// poder utilizar de forma directa la conexion a la BD.
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class QueryPersonas extends Conexion {
    public boolean guardar(ClsPersonas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="INSERT INTO tbl_personas (ap_paterno,ap_materno,nombres,nro_documento,fecha_nac,sexo,tipo_per) VALUES (?,?,?,?,?,?,?)";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getAp_paterno());
            ps.setString(2,clase.getAp_materno());
            ps.setString(3,clase.getNombres());
            ps.setString(4,clase.getNro_documento());
            ps.setDate(5,java.sql.Date.valueOf(clase.getFecha_nac()));
            ps.setInt(6,clase.getSexo());
            ps.setInt(7,clase.getTipo_per());            
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
public boolean modificar(ClsPersonas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="UPDATE tbl_personas SET ap_paterno=?,ap_materno=?,nombres=?,nro_documento=?,fecha_nac=?,sexo=?,tipo_per=? WHERE id=?";
        try {            
            ps = con.prepareStatement(sql);
            ps.setString(1,clase.getAp_paterno());
            ps.setString(2,clase.getAp_materno());
            ps.setString(3,clase.getNombres());
            ps.setString(4,clase.getNro_documento());
            ps.setDate(5,java.sql.Date.valueOf(clase.getFecha_nac()));
            ps.setInt(6,clase.getSexo());
            ps.setInt(7,clase.getTipo_per());
            ps.setInt(8,clase.getId());   
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
public boolean eliminar(ClsPersonas clase) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        String sql="DELETE FROM tbl_personas WHERE id=? ";
        try {            
            ps = con.prepareStatement(sql);
            ps.setInt(1,clase.getId());            
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
        String[] titulos = {"Nro","Apellido Paterno","Apellido Materno","Nombres","Documento","Sexo","Id"};
        String[] registros = new String[7];
        int contador=0;
        // pone titulos a la tabla
        modelo = new DefaultTableModel(null, titulos);
        String sql = "SELECT ap_paterno,ap_materno,nombres,nro_documento,sexo,id FROM tbl_personas WHERE ap_paterno LIKE ? OR ap_materno LIKE ? OR ap_materno LIKE ? ORDER BY ap_paterno,ap_materno,nombres";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            //ps.setString(1, "%"+valor.toUpperCase()+"%");            
            ps.setString(1, "%"+valor+"%");
            ps.setString(2, "%"+valor+"%");
            ps.setString(3, "%"+valor+"%");
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                contador++;
                registros[0] = Integer.toString(contador);  //Numero
                registros[1] = rs.getString(1).trim();  //Apellido Paterno
                registros[2] = rs.getString(2).trim();  //Apellido Materno                
                registros[3] = rs.getString(3).trim();  //Nombres
                registros[4] = rs.getString(4).trim();  // Nro Documento
                int estadoValor = Integer.parseInt(rs.getString(5));  // sexo
                if(estadoValor==1) {
                  registros[5] = "Masculino";  // sexo 1  
                } else {
                  registros[5] = "Femenino";  // sexo 0
                }                
                registros[6] = rs.getString(6);  // id                
                modelo.addRow(registros);
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL");
        }
        return modelo;
    }
    public ClsPersonas devuelvePersona(int idPersona) {
        ClsPersonas persona = new ClsPersonas();
        String sql = "SELECT * FROM tbl_personas WHERE id=?";
        try {
            PreparedStatement ps;
            ps=this.getConexion().prepareStatement(sql);
            ps.setInt(1, idPersona);
            ResultSet rs = ps.executeQuery();           
            while (rs.next()) {
                persona.setAp_paterno(rs.getString("ap_paterno").trim());
                persona.setAp_materno(rs.getString("ap_materno").trim());
                persona.setNombres(rs.getString("nombres").trim());
                persona.setNro_documento(rs.getString("nro_documento").trim());
                persona.setFecha_nac(rs.getString("fecha_nac"));               
                persona.setSexo(rs.getInt("sexo"));
                persona.setTipo_per(rs.getInt("tipo_per"));
            }
        } catch (SQLException ex) {
            System.out.println("Error con el SQL");
        }
        return persona;
    }
}
